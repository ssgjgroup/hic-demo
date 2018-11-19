USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_ZYBCJL_SJYSCFJL]    Script Date: 2018/11/19 9:26:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title  住院病程记录－上级医师查房记录
 * @email chensj@winning.com.cn
 * @package
 * @date: 2018-11-16 12:15
 * exec USP_SPLIT_ZYBCJL_SJYSCFJL '12345678','  '
 */
ALTER PROCEDURE [dbo].[USP_SPLIT_ZYBCJL_SJYSCFJL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SJYSCFJL'))
      drop table #DC_ZYBCJL_SJYSCFJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZYBCJL_SJYSCFJL'))
      drop table #HLHT_ZYBCJL_SJYSCFJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SJYSCFJL_ZYSZGCJG'))
      drop table #DC_ZYBCJL_SJYSCFJL_ZYSZGCJG

    declare @error int
    -- 住院病程记录－上级医师查房记录
    declare @yjlxh as nvarchar(max), @zyszgcjg as nvarchar(max)
    set @error = 0
    begin tran  --申明事务
    -- 创建临时表
    select * into #HLHT_ZYBCJL_SJYSCFJL from HLHT_ZYBCJL_SJYSCFJL where STATUS = '0';
    -- 主表操作
    create table #DC_ZYBCJL_SJYSCFJL (
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
      bfmc       varchar(64)    not null/* 病房名称 */,
      bch        varchar(10)    not null/* 病床号 */,
      cfrq       datetime       not null/* 查房日期时间 */,
      hzxm       varchar(50)    not null/* 患者姓名 */,
      sfzhm      varchar(18)    not null/* 患者身份证号标识 */,
      csrq       date           not null/* 出生日期 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别说明 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      cfjl       nvarchar(2000) not null/* 查房记录 */,
      bzlzms     nvarchar(1000) null/* 辨证论治详细描述 */,
      yznr       nvarchar(1000) null/* 医嘱内容 */,
      zyjzff     nvarchar(100)  null/* 中药煎煮方法 */,
      zyyyff     nvarchar(100)  null/* 中药用药方法 */,
      yljh       nvarchar(2000) not null/* 诊疗计划 */,
      jlrbm      varchar(20)    not null/* 记录人工号 */,
      jlrqm      varchar(50)    not null/* 记录人签名 */,
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

    insert into #DC_ZYBCJL_SJYSCFJL
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
           CONVERT(varchar(64), bfmc),
           CONVERT(varchar(10), bch),
           CONVERT(datetime, cfrq),
           CONVERT(varchar(50), hzxm),
           CONVERT(varchar(18), sfzhm),
           CONVERT(date, csrq),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(nvarchar(2000), cfjl),
           CONVERT(nvarchar(1000), bzlzms),
           CONVERT(nvarchar(1000), yznr),
           CONVERT(nvarchar(100), zyjzff),
           CONVERT(nvarchar(100), zyyyff),
           CONVERT(nvarchar(2000), yljh),
           CONVERT(varchar(20), jlrbm),
           CONVERT(varchar(50), jlrqm),
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
    from #HLHT_ZYBCJL_SJYSCFJL

    Merge Into DC_ZYBCJL_SJYSCFJL _target
    using #DC_ZYBCJL_SJYSCFJL _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.jzlsh  = _source.jzlsh,
        _target.patid  = _source.patid,
        _target.zyh    = _source.zyh,
        _target.yjlxh  = _source.yjlxh,
        _target.ksdm   = _source.ksdm,
        _target.ksmc   = _source.ksmc,
        _target.bqdm   = _source.bqdm,
        _target.bqmc   = _source.bqmc,
        _target.bfh    = _source.bfh,
        _target.bfmc   = _source.bfmc,
        _target.bch    = _source.bch,
        _target.cfrq   = _source.cfrq,
        _target.hzxm   = _source.hzxm,
        _target.sfzhm  = _source.sfzhm,
        _target.csrq   = _source.csrq,
        _target.xbdm   = _source.xbdm,
        _target.xbmc   = _source.xbmc,
        _target.nls    = _source.nls,
        _target.nly    = _source.nly,
        _target.cfjl   = _source.cfjl,
        _target.bzlzms = _source.bzlzms,
        _target.yznr   = _source.yznr,
        _target.zyjzff = _source.zyjzff,
        _target.zyyyff = _source.zyyyff,
        _target.yljh   = _source.yljh,
        _target.jlrbm  = _source.jlrbm,
        _target.jlrqm  = _source.jlrqm,
        _target.zzysbm = _source.zzysbm,
        _target.zzysqm = _source.zzysqm,
        _target.zrysbm = _source.zrysbm,
        _target.zrysqm = _source.zrysqm,
        _target.qmrq   = _source.qmrq,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, cfrq, hzxm, sfzhm, csrq, xbdm, xbmc, nls, nly, cfjl, bzlzms, yznr, zyjzff, zyyyff, yljh, jlrbm, jlrqm, zzysbm, zzysqm, zrysbm, zrysqm, qmrq, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.ksdm, _source.ksmc,
                              _source.bqdm, _source.bqmc, _source.bfh, _source.bfmc, _source.bch, _source.cfrq,
                                                                                     _source.hzxm, _source.sfzhm,
                                                                                     _source.csrq, _source.xbdm,
                                                                                     _source.xbmc, _source.nls,
                                                                                     _source.nly, _source.cfjl,
        _source.bzlzms, _source.yznr, _source.zyjzff, _source.zyyyff, _source.yljh, _source.jlrbm, _source.jlrqm,
        _source.zzysbm, _source.zzysqm, _source.zrysbm, _source.zrysqm, _source.qmrq, _source.isNew, _source.createtime,
              _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_ZYBCJL_SJYSCFJL

    --申明游标为,需要加时间范围
    declare order_cursor cursor for (select yjlxh, zyszgcjg from #HLHT_ZYBCJL_SJYSCFJL)
    --打开游标--
    open order_cursor
    --开始循环游标变量--
    fetch next from order_cursor
    into @yjlxh, @zyszgcjg
    while @@FETCH_STATUS = 0 --返回被 FETCH语句执行的最后游标的状态--
      begin
        --住院病程记录－上级医师查房记录_中医四诊观察结果
        create table #DC_ZYBCJL_SJYSCFJL_ZYSZGCJG (
          xh         numeric(12) identity (1, 1)/* 序号  */,
          yljgdm     varchar(20)    not null/* 医疗机构代码  */,
          yjlxh      varchar(64)    not null/* 源记录序号 */,
          zyjlxh     varchar(64)    not null/* 主源记录序号 */,
          zyszgcjg   nvarchar(1000) null/* 中医“四诊”观察结果 */,
          isNew      bit            NULL,
          createtime datetime       NULL,
          gxrq       datetime       NOT NULL,
          sys_id     varchar(50)    NOT NULL,
          lsnid      bigint         NULL,
          isdelete   varchar(8)     NULL
        )

        insert into #DC_ZYBCJL_SJYSCFJL_ZYSZGCJG
        select @yljgdm,
               ltrim(rtrim(@yjlxh)) + ltrim(rtrim(Str(_0.id))),
               @yjlxh,
               _0.value,
               1,
               getdate(),
               getdate(),
               'EMR',
               0,
               '0'
        from (select * from (values (1, @zyszgcjg))t (id, value)) _0
        where 1 = 1

        Merge Into DC_ZYBCJL_SJYSCFJL_ZYSZGCJG _target
        using #DC_ZYBCJL_SJYSCFJL_ZYSZGCJG _source
        on (_target.yjlxh = _source.yjlxh)
        When Matched Then
          Update set
            _target.yljgdm   = _source.yljgdm,
            _target.yjlxh    = _source.yjlxh,
            _target.zyjlxh   = _source.zyjlxh,
            _target.zyszgcjg = _source.zyszgcjg,
            _target.gxrq     = getdate()
        When Not Matched By Target Then
          Insert (yljgdm, yjlxh, zyjlxh, zyszgcjg, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
          values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.zyszgcjg, _source.isNew, _source.createtime,
                  _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
        drop table #DC_ZYBCJL_SJYSCFJL_ZYSZGCJG

        UPDATE A SET A.STATUS = '1' FROM HLHT_ZYBCJL_SJYSCFJL A WHERE A.yjlxh = @yjlxh;
        set @error = @error + @@ERROR   --记录每次运行sql后是否正确，0正确
        fetch next from order_cursor
        into @yjlxh, @zyszgcjg   --转到下一个游标
      end
    if @error = 0
      begin
        commit tran   --提交事务
      end
    else
      begin
        rollback tran --回滚事务
        drop table #HLHT_ZYBCJL_SJYSCFJL
        close order_cursor  --关闭游标
        deallocate order_cursor  --关闭游标
      end
    drop table #HLHT_ZYBCJL_SJYSCFJL
    close order_cursor  --关闭游标
    deallocate order_cursor --释放游标
  end