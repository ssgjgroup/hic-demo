/**
 * @author chensj
 * @title  住院病程记录－死亡病例讨论记录
 * @email chensj@winning.com.cn
 * @package 
 * @date: 2018-11-16 12:15
 * exec USP_SPLIT_ZYBCJL_SWBLTLJL '12345678','  '
 */
alter PROCEDURE [dbo].[USP_SPLIT_ZYBCJL_SWBLTLJL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SWBLTLJL'))
      drop table #DC_ZYBCJL_SWBLTLJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZYBCJL_SWBLTLJL'))
      drop table #HLHT_ZYBCJL_SWBLTLJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SWBLTLJL_SWZD'))
      drop table #DC_ZYBCJL_SWBLTLJL_SWZD
    declare @error int
    -- 住院病程记录－死亡病例讨论记录_死亡诊断
    declare @yjlxh as nvarchar(max), @swzdbm as nvarchar(max), @swzdmc as nvarchar(max)
    set @error = 0
    begin tran  --申明事务
    --创建临时表
    select * into #HLHT_ZYBCJL_SWBLTLJL from HLHT_ZYBCJL_SWBLTLJL where STATUS = 0;
    --主表操作
    create table #DC_ZYBCJL_SWBLTLJL (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      jzlsh      varchar(64)    not null/* 就诊流水号 */,
      patid      varchar(64)    not null/* 患者patid */,
      zyh        varchar(64)    not null/* 住院号标识 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      ksdm       varchar(10)    not null/* 科室代码 */,
      ksmc       varchar(50)    not null/* 科室名称 */,
      bqdm       varchar(10)    not null/* 病区代码 */,
      bqmc       varchar(50)    not null/* 病区名称 */,
      bfh        varchar(10)    not null/* 病房号 */,
      bfmc       varchar(10)    not null/* 病房名称 */,
      bch        varchar(10)    not null/* 病床号 */,
      hzxm       varchar(50)    not null/* 患者姓名 */,
      sfzhm      varchar(18)    not null/* 患者身份证号标识 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      tlrq       datetime       not null/* 讨论日期时间 */,
      tldddm     varchar(20)    not null/* 讨论地点代码 */,
      tldd       varchar(50)    not null/* 讨论地点名称 */,
      zcrbm      varchar(100)   not null/* 主持人工号 */,
      zcrxm      varchar(500)   not null/* 主持人姓名 */,
      tlrybm     varchar(100)   not null/* 参加讨论人员工号 */,
      cjtlmd     varchar(500)   not null/* 参加讨论人员名单 */,
      zyzwlbdm   varchar(10)    not null/* 专业技术职务类别代码 */,
      zyzwlbmc   varchar(50)    not null/* 专业技术职务类别名称 */,
      zjswyymc   varchar(128)   not null/* 直接死亡原因名称 */,
      zjswyybm   varchar(64)    not null/* 直接死亡原因编码 */,
      swtljl     nvarchar(2000) not null/* 死亡讨论记录 */,
      zcrzjyj    nvarchar(2000) not null/* 主持人总结意见 */,
      zzysbm     varchar(20)    not null/* 主治医师工号 */,
      zzysqm     varchar(50)    not null/* 主治医师签名 */,
      zrysbm     varchar(20)    not null/* 主任医师工号 */,
      zrysqm     varchar(50)    not null/* 主任医师签名 */,
      qmrq       datetime       not null/* 签名日期时间 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_ZYBCJL_SWBLTLJL
    select @yljgdm,
           CONVERT(varchar(64), jzlsh),
           CONVERT(varchar(64), patid),
           CONVERT(varchar(64), zyh),
           CONVERT(varchar(64), yjlxh),
           CONVERT(varchar(10), ksdm),
           CONVERT(varchar(50), ksmc),
           CONVERT(varchar(10), bqdm),
           CONVERT(varchar(50), bqmc),
           CONVERT(varchar(10), bfh),
           CONVERT(varchar(10), bfmc),
           CONVERT(varchar(10), bch),
           CONVERT(varchar(50), hzxm),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(datetime, tlrq),
           CONVERT(varchar(20), tldddm),
           CONVERT(varchar(50), tldd),
           CONVERT(varchar(100), zcrbm),
           CONVERT(varchar(500), zcrxm),
           CONVERT(varchar(100), tlrybm),
           CONVERT(varchar(500), cjtlmd),
           CONVERT(varchar(10), zyzwlbdm),
           CONVERT(varchar(50), zyzwlbmc),
           CONVERT(varchar(128), zjswyymc),
           CONVERT(varchar(64), zjswyybm),
           CONVERT(nvarchar(2000), swtljl),
           CONVERT(nvarchar(2000), zcrzjyj),
           CONVERT(varchar(20), zzysbm),
           CONVERT(varchar(50), zzysqm),
           CONVERT(varchar(20), zrysbm),
           CONVERT(varchar(50), zrysqm),
           CONVERT(datetime, qmrq),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_ZYBCJL_SWBLTLJL

    Merge Into DC_ZYBCJL_SWBLTLJL _target
    using #DC_ZYBCJL_SWBLTLJL _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.jzlsh    = _source.jzlsh,
        _target.patid    = _source.patid,
        _target.zyh      = _source.zyh,
        _target.yjlxh    = _source.yjlxh,
        _target.ksdm     = _source.ksdm,
        _target.ksmc     = _source.ksmc,
        _target.bqdm     = _source.bqdm,
        _target.bqmc     = _source.bqmc,
        _target.bfh      = _source.bfh,
        _target.bfmc     = _source.bfmc,
        _target.bch      = _source.bch,
        _target.hzxm     = _source.hzxm,
        _target.sfzhm    = _source.sfzhm,
        _target.xbdm     = _source.xbdm,
        _target.xbmc     = _source.xbmc,
        _target.nls      = _source.nls,
        _target.nly      = _source.nly,
        _target.tlrq     = _source.tlrq,
        _target.tldddm   = _source.tldddm,
        _target.tldd     = _source.tldd,
        _target.zcrbm    = _source.zcrbm,
        _target.zcrxm    = _source.zcrxm,
        _target.tlrybm   = _source.tlrybm,
        _target.cjtlmd   = _source.cjtlmd,
        _target.zyzwlbdm = _source.zyzwlbdm,
        _target.zyzwlbmc = _source.zyzwlbmc,
        _target.zjswyymc = _source.zjswyymc,
        _target.zjswyybm = _source.zjswyybm,
        _target.swtljl   = _source.swtljl,
        _target.zcrzjyj  = _source.zcrzjyj,
        _target.zzysbm   = _source.zzysbm,
        _target.zzysqm   = _source.zzysqm,
        _target.zrysbm   = _source.zrysbm,
        _target.zrysqm   = _source.zrysqm,
        _target.qmrq     = _source.qmrq,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, hzxm, sfzhm, xbdm, xbmc, nls, nly, tlrq, tldddm, tldd, zcrbm, zcrxm, tlrybm, cjtlmd, zyzwlbdm, zyzwlbmc, zjswyymc, zjswyybm, swtljl, zcrzjyj, zzysbm, zzysqm, zrysbm, zrysqm, qmrq, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.ksdm, _source.ksmc,
                              _source.bqdm, _source.bqmc, _source.bfh, _source.bfmc, _source.bch, _source.hzxm,
                                                                                     _source.sfzhm, _source.xbdm,
                                                                                     _source.xbmc, _source.nls,
                                                                                     _source.nly, _source.tlrq,
                                                                                     _source.tldddm, _source.tldd,
        _source.zcrbm, _source.zcrxm, _source.tlrybm, _source.cjtlmd, _source.zyzwlbdm, _source.zyzwlbmc,
        _source.zjswyymc, _source.zjswyybm, _source.swtljl, _source.zcrzjyj, _source.zzysbm, _source.zzysqm,
                                                                             _source.zrysbm, _source.zrysqm,
                                                                             _source.qmrq, _source.isNew,
                                                                             _source.createtime, _source.gxrq,
                                                                             _source.sys_id, _source.lsnid,
              _source.isdelete);
    drop table #DC_ZYBCJL_SWBLTLJL

    --申明游标为,需要加时间范围
    declare order_cursor cursor for (select yjlxh, swzdbm, swzdmc from #HLHT_ZYBCJL_SWBLTLJL)
    --打开游标--
    open order_cursor
    --开始循环游标变量--
    fetch next from order_cursor
    into @yjlxh, @swzdbm, @swzdmc
    while @@FETCH_STATUS = 0 --返回被 FETCH语句执行的最后游标的状态--
      begin
        create table #DC_ZYBCJL_SWBLTLJL_SWZD (
          xh         numeric(12) identity (1, 1)/* 序号  */,
          yljgdm     varchar(20)  not null/* 医疗机构代码  */,
          yjlxh      varchar(64)  not null/* 源记录序号 */,
          zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
          swzdbm     varchar(100) not null/* 死亡诊断编码 */,
          swzdmc     varchar(500) not null/* 死亡诊断名称 */,
          isNew      bit          NULL,
          createtime datetime     NULL,
          gxrq       datetime     NOT NULL,
          sys_id     varchar(50)  NOT NULL,
          lsnid      bigint       NULL,
          isdelete   varchar(8)   NULL
        )

        insert into #DC_ZYBCJL_SWBLTLJL_SWZD
        select @yljgdm,
               ltrim(rtrim(@yjlxh)) + ltrim(rtrim(Str(_0.id))),
               @yjlxh,
               _0.value,
               _1.value,
               1,
               getdate(),
               getdate(),
               'EMR',
               0,
               '0'
        from (select id, value from [dbo].[f_splitString](@swzdbm, @regex)) _0,
             (select id, value from [dbo].[f_splitString](@swzdmc, @regex)) _1
        where 1 = 1
          and _0.id = _1.id

        Merge Into DC_ZYBCJL_SWBLTLJL_SWZD _target
        using #DC_ZYBCJL_SWBLTLJL_SWZD _source
        on (_target.yjlxh = _source.yjlxh)
        When Matched Then
          Update set
            _target.yljgdm = _source.yljgdm,
            _target.yjlxh  = _source.yjlxh,
            _target.zyjlxh = _source.zyjlxh,
            _target.swzdbm = _source.swzdbm,
            _target.swzdmc = _source.swzdmc,
            _target.gxrq   = getdate()
        When Not Matched By Target Then
          Insert (yljgdm, yjlxh, zyjlxh, swzdbm, swzdmc, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
          values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.swzdbm, _source.swzdmc, _source.isNew,
            _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
        drop table #DC_ZYBCJL_SWBLTLJL_SWZD

        UPDATE A SET A.STATUS = 1 FROM HLHT_ZYBCJL_SWBLTLJL A WHERE A.yjlxh = @yjlxh;
        set @error = @error + @@ERROR   --记录每次运行sql后是否正确，0正确
        fetch next from order_cursor
        into @yjlxh, @swzdbm, @swzdmc   --转到下一个游标
      end
    if @error = 0
      begin
        commit tran   --提交事务
      end
    else
      begin
        rollback tran --回滚事务
        close order_cursor  --关闭游标
        deallocate order_cursor  --关闭游标
      end
    drop table #HLHT_ZYBCJL_SWBLTLJL
    close order_cursor  --关闭游标
    deallocate order_cursor --释放游标
  end