/**
 * @author chensj
 * @title  住院病程记录－术前小结
 * @email chensj@winning.com.cn
 * @date: 2018-11-16 10:33
 * exec USP_SPLIT_ZYBCJL_SQXJ '12345678','  '
 */
CREATE PROCEDURE [dbo].[USP_SPLIT_ZYBCJL_SQXJ]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SQXJ'))
      drop table #DC_ZYBCJL_SQXJ
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SQXJ_GMS'))
      drop table #DC_ZYBCJL_SQXJ_GMS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SQXJ_SQZD'))
      drop table #DC_ZYBCJL_SQXJ_SQZD

    --主表操作
    create table #DC_ZYBCJL_SQXJ (
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
      bfmc       varchar(50)    not null/* 病房名称 */,
      bch        varchar(10)    not null/* 病床号 */,
      hzxm       varchar(50)    not null/* 患者姓名 */,
      sfzhm      varchar(18)    not null/* 患者身份证号标识 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      xjrq       datetime       not null/* 小结日期时间 */,
      blzy       nvarchar(200)  not null/* 病历摘要 */,
      zdyjdm     varchar(100)   not null/* 诊断依据代码 */,
      zdyj       nvarchar(1000) not null/* 诊断依据名称 */,
      gmsbz      char(1)        not null/* 过敏史标志 */,
      fzjcjg     nvarchar(1000) not null/* 辅助检查结果 */,
      sssyz      nvarchar(100)  not null/* 手术适应证 */,
      ssjjz      nvarchar(100)  not null/* 手术禁忌症 */,
      sszz       nvarchar(500)  not null/* 手术指征 */,
      hzyj       nvarchar(2000) null/* 会诊意见 */,
      ssczbm     varchar(64)    not null/* 拟实施手术及操作编码 */,
      ssczmc     varchar(128)   not null/* 拟实施手术及操作名称 */,
      ssmbbwdm   varchar(64)    not null/* 拟实施手术目标部位代码 */,
      ssbwmc     varchar(128)   not null/* 拟实施手术目标部位名称 */,
      ssczrq     datetime       not null/* 拟实施手术及操作日期时间 */,
      mzffdm     varchar(64)    not null/* 拟实施麻醉方法代码 */,
      mzffmc     varchar(128)   not null/* 拟实施麻醉方法名称 */,
      zysx       nvarchar(1000) not null/* 注意事项 */,
      ssyd       nvarchar(200)  not null/* 手术要点 */,
      sqzb       nvarchar(1000) not null/* 术前准备 */,
      sszbm      varchar(20)    not null/* 手术者工号 */,
      sszqm      varchar(50)    not null/* 手术者签名 */,
      ysbm       varchar(20)    null/* 签名人工号 */,
      ysqm       varchar(50)    null/* 签名人姓名 */,
      qmrq       datetime       not null/* 签名日期时间 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_ZYBCJL_SQXJ
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
           CONVERT(varchar(50), bfmc),
           CONVERT(varchar(10), bch),
           CONVERT(varchar(50), hzxm),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(datetime, xjrq),
           CONVERT(nvarchar(200), blzy),
           CONVERT(varchar(100), zdyjdm),
           CONVERT(nvarchar(1000), zdyj),
           CONVERT(char(1), gmsbz),
           CONVERT(nvarchar(1000), fzjcjg),
           CONVERT(nvarchar(100), sssyz),
           CONVERT(nvarchar(100), ssjjz),
           CONVERT(nvarchar(500), sszz),
           CONVERT(nvarchar(2000), hzyj),
           CONVERT(varchar(64), ssczbm),
           CONVERT(varchar(128), ssczmc),
           CONVERT(varchar(64), ssmbbwdm),
           CONVERT(varchar(128), ssbwmc),
           CONVERT(datetime, ssczrq),
           CONVERT(varchar(64), mzffdm),
           CONVERT(varchar(128), mzffmc),
           CONVERT(nvarchar(1000), zysx),
           CONVERT(nvarchar(200), ssyd),
           CONVERT(nvarchar(1000), sqzb),
           CONVERT(varchar(20), sszbm),
           CONVERT(varchar(50), sszqm),
           CONVERT(varchar(20), ysbm),
           CONVERT(varchar(50), ysqm),
           CONVERT(datetime, qmrq),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from HLHT_ZYBCJL_SQXJ
    Merge Into DC_ZYBCJL_SQXJ _target
    using #DC_ZYBCJL_SQXJ _source
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
        _target.xjrq     = _source.xjrq,
        _target.blzy     = _source.blzy,
        _target.zdyjdm   = _source.zdyjdm,
        _target.zdyj     = _source.zdyj,
        _target.gmsbz    = _source.gmsbz,
        _target.fzjcjg   = _source.fzjcjg,
        _target.sssyz    = _source.sssyz,
        _target.ssjjz    = _source.ssjjz,
        _target.sszz     = _source.sszz,
        _target.hzyj     = _source.hzyj,
        _target.ssczbm   = _source.ssczbm,
        _target.ssczmc   = _source.ssczmc,
        _target.ssmbbwdm = _source.ssmbbwdm,
        _target.ssbwmc   = _source.ssbwmc,
        _target.ssczrq   = _source.ssczrq,
        _target.mzffdm   = _source.mzffdm,
        _target.mzffmc   = _source.mzffmc,
        _target.zysx     = _source.zysx,
        _target.ssyd     = _source.ssyd,
        _target.sqzb     = _source.sqzb,
        _target.sszbm    = _source.sszbm,
        _target.sszqm    = _source.sszqm,
        _target.ysbm     = _source.ysbm,
        _target.ysqm     = _source.ysqm,
        _target.qmrq     = _source.qmrq,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, hzxm, sfzhm, xbdm, xbmc, nls, nly, xjrq, blzy, zdyjdm, zdyj, gmsbz, fzjcjg, sssyz, ssjjz, sszz, hzyj, ssczbm, ssczmc, ssmbbwdm, ssbwmc, ssczrq, mzffdm, mzffmc, zysx, ssyd, sqzb, sszbm, sszqm, ysbm, ysqm, qmrq, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.ksdm, _source.ksmc,
                              _source.bqdm, _source.bqmc, _source.bfh, _source.bfmc, _source.bch, _source.hzxm,
                                                                                     _source.sfzhm, _source.xbdm,
                                                                                     _source.xbmc, _source.nls,
                                                                                     _source.nly, _source.xjrq,
                                                                                     _source.blzy, _source.zdyjdm,
        _source.zdyj, _source.gmsbz, _source.fzjcjg, _source.sssyz, _source.ssjjz, _source.sszz, _source.hzyj,
        _source.ssczbm, _source.ssczmc, _source.ssmbbwdm, _source.ssbwmc, _source.ssczrq, _source.mzffdm,
                                                          _source.mzffmc, _source.zysx, _source.ssyd, _source.sqzb,
                                                          _source.sszbm, _source.sszqm, _source.ysbm, _source.ysqm,
              _source.qmrq, _source.isNew, _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid,
              _source.isdelete);
    drop table #DC_ZYBCJL_SQXJ

    declare @error int
    -- 住院病程记录－术前小结_过敏史
    declare @yjlxh as nvarchar(max), @gms as nvarchar(max)
    -- 住院病程记录－术前小结_术前诊断
    declare @sqzdbm as nvarchar(max), @sqzdmc as nvarchar(max)
    set @error = 0
    begin tran  --申明事务
    --申明游标为,需要加时间范围
    declare order_cursor cursor for (select yjlxh, gms, sqzdbm, sqzdmc from [dbo].[HLHT_ZYBCJL_SQXJ] where STATUS = 0)
    --打开游标--
    open order_cursor
    --开始循环游标变量--
    fetch next from order_cursor into @yjlxh, @gms, @sqzdbm, @sqzdmc
    while @@FETCH_STATUS = 0 --返回被 FETCH语句执行的最后游标的状态--
      begin
        --住院病程记录－术前小结_过敏史
        create table #DC_ZYBCJL_SQXJ_GMS (
          xh         numeric(12) identity (1, 1)/* 序号  */,
          yljgdm     varchar(20)    not null/* 医疗机构代码  */,
          yjlxh      varchar(64)    not null/* 源记录序号 */,
          zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
          gms        nvarchar(1000) null/* 过敏史 */,
          isNew      bit            NULL,
          createtime datetime       NULL,
          gxrq       datetime       NOT NULL,
          sys_id     varchar(50)    NOT NULL,
          lsnid      bigint         NULL,
          isdelete   varchar(8)     NULL
        )
        insert into #DC_ZYBCJL_SQXJ_GMS (yljgdm, yjlxh, zyjlxh, gms, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
        select @yljgdm,
               ltrim(rtrim(@yjlxh)) + ltrim(rtrim(Str(a.id))),
               @yjlxh,
               a.value,
               1,
               getdate(),
               getdate(),
               'EMR',
               0,
               '0'
        from (select * from (values (1, @gms))t (id, value)) a
        Merge Into DC_ZYBCJL_SQXJ_GMS _target
        using #DC_ZYBCJL_SQXJ_GMS _source
        on (_target.yjlxh = _source.yjlxh)
        When Matched Then Update set
          _target.yljgdm     = _source.yljgdm,
          _target.yjlxh      = _source.yjlxh,
          _target.zyjlxh     = _source.zyjlxh,
          _target.gms        = _source.gms,
          _target.isNew      = _source.isNew,
          _target.gxrq       = _source.gxrq,
          _target.createtime = _source.createtime,
          _target.lsnid      = _source.lsnid,
          _target.isdelete   = _source.isdelete,
          _target.sys_id     = _source.sys_id
        When Not Matched By Target Then Insert
        (yljgdm, yjlxh, zyjlxh, gms, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
        values
        (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.gms, _source.isNew, _source.createtime,
         _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
        drop table #DC_ZYBCJL_SQXJ_GMS

        --住院病程记录－术前小结_术前诊断
        create table #DC_ZYBCJL_SQXJ_SQZD (
          xh         numeric(12) identity (1, 1)/* 序号  */,
          yljgdm     varchar(20)  not null/* 医疗机构代码  */,
          yjlxh      varchar(64)  not null/* 源记录序号 */,
          zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
          sqzdbm     varchar(64)  not null/* 术前诊断编码 */,
          sqzdmc     varchar(128) not null/* 术前诊断名称 */,
          isNew      bit          NULL,
          createtime datetime     NULL,
          gxrq       datetime     NOT NULL,
          sys_id     varchar(50)  NOT NULL,
          lsnid      bigint       NULL,
          isdelete   varchar(8)   NULL
        )

        insert into #DC_ZYBCJL_SQXJ_SQZD
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
        from (select id, value from [dbo].[f_splitString](@sqzdbm, @regex)) _0,
             (select id, value from [dbo].[f_splitString](@sqzdmc, @regex)) _1
        where _0.id = _1.id

        Merge Into DC_ZYBCJL_SQXJ_SQZD _target
        using #DC_ZYBCJL_SQXJ_SQZD _source
        on (_target.yjlxh = _source.yjlxh)
        When Matched Then
          Update set
            _target.yljgdm = _source.yljgdm,
            _target.yjlxh  = _source.yjlxh,
            _target.zyjlxh = _source.zyjlxh,
            _target.sqzdbm = _source.sqzdbm,
            _target.sqzdmc = _source.sqzdmc,
            _target.gxrq   = getdate()
        When Not Matched By Target Then
          Insert (yljgdm, yjlxh, zyjlxh, sqzdbm, sqzdmc, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
          values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.sqzdbm, _source.sqzdmc, _source.isNew,
            _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
        drop table #DC_ZYBCJL_SQXJ_SQZD

        UPDATE A SET A.STATUS = 1 FROM HLHT_ZYBCJL_SQXJ A WHERE A.yjlxh = @yjlxh;
        set @error = @error + @@ERROR   --记录每次运行sql后是否正确，0正确
        fetch next from order_cursor into @yjlxh, @gms, @sqzdbm, @sqzdmc   --转到下一个游标
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
    close order_cursor  --关闭游标
    deallocate order_cursor --释放游标
  end
