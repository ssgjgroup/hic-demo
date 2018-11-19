USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_RYJL_RYSWJL]    Script Date: 2018/11/19 9:25:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * 入院记录 — 24小时内入院死亡记录
 * exec USP_SPLIT_RYJL_RYSWJL '888888','  '
 */
ALTER PROCEDURE [dbo].[USP_SPLIT_RYJL_RYSWJL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    -----------------------------入院记录 ― 24小时内入院死亡记录----------------------------
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL'))
      drop table #DC_RYJL_RYSWJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_RYJL_RYSWJL'))
      drop table #HLHT_RYJL_RYSWJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL_ZYSZGCJG'))
      drop table #DC_RYJL_RYSWJL_ZYSZGCJG
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL_RYZYZD'))
      drop table #DC_RYJL_RYSWJL_RYZYZD
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL_RYXYZD'))
      drop table #DC_RYJL_RYSWJL_RYXYZD
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL_SWZYZD'))
      drop table #DC_RYJL_RYSWJL_SWZYZD
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_RYJL_RYSWJL_SWXYZD'))
      drop table #DC_RYJL_RYSWJL_SWXYZD
    --创建临时表
    SELECT * INTO  #HLHT_RYJL_RYSWJL  FROM HLHT_RYJL_RYSWJL WHERE STATUS = '0'
    --主表操作
    create table #DC_RYJL_RYSWJL (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      jzlsh      varchar(64)    not null/* 就诊流水号 */,
      patid      varchar(64)    not null/* 患者patid */,
      zyh        varchar(64)    not null/* 住院号 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      hzxm       varchar(50)    not null/* 患者姓名 */,
      sfzhm      varchar(18)    not null/* 身份证号 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      mz         varchar(2)     null/* 民族 */,
      mzmc       varchar(32)    null/* 民族名称 */,
      hyzkdm     varchar(2)     null/* 婚姻状况代码 */,
      hyzkmc     varchar(32)    null/* 婚姻状况名称 */,
      dzsf       varchar(70)    not null/* 地址-省（自治区、直辖市） */,
      dzsq       varchar(70)    not null/* 地址-市（地区、州） */,
      dzx        varchar(70)    not null/* 地址-县（区） */,
      dzxz       varchar(70)    not null/* 地址-乡（镇、街道办事处） */,
      dzc        varchar(70)    not null/* 地址-村（街、路、弄等） */,
      dzmphm     varchar(70)    not null/* 地址-门牌号码 */,
      zylbdm     varchar(2)     null/* 职业类别代码 */,
      zylbmc     varchar(50)    null/* 职业类别名称 */,
      bscszxm    varchar(50)    not null/* 病史陈述者姓名 */,
      cszhzgxdm  varchar(2)     not null/* 陈述者与患者的关系代码 */,
      cszhzgxmc  varchar(50)    not null/* 陈述者与患者的关系名称 */,
      csnrbz     char(1)        not null/* 陈述内容可靠标志 */,
      ryrq       datetime       not null/* 入院日期时间 */,
      swrq       datetime       not null/* 死亡日期时间 */,
      ryqk       nvarchar(2000) not null/* 入院情况 */,
      zfbm       varchar(20)    null/* 治则治法代码 */,
      zzzf       nvarchar(100)  null/* 治则治法 */,
      zlgcms     nvarchar(2000) not null/* 诊疗过程描述 */,
      swyy       nvarchar(100)  not null/* 死亡原因 */,
      jzysbm     varchar(20)    not null/* 接诊医师编码 */,
      jzysqm     varchar(50)    not null/* 接诊医师签名 */,
      zyysbm     varchar(20)    not null/* 住院医师编码 */,
      zyysqm     varchar(50)    not null/* 住院医师签名 */,
      zzysbm     varchar(20)    not null/* 主治医师编码 */,
      zzysqm     varchar(50)    not null/* 主治医师签名 */,
      zrysbm     varchar(20)    not null/* 主任医师编码 */,
      zrysqm     varchar(50)    not null/* 主任医师签名 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_RYJL_RYSWJL
    select @yljgdm,
           CONVERT(varchar(64), jzlsh),
           CONVERT(varchar(64), patid),
           CONVERT(varchar(64), zyh),
           CONVERT(varchar(64), yjlxh),
           CONVERT(varchar(50), hzxm),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(16), xbmc),
           CONVERT(varchar(2), xbdm),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(varchar(2), mz),
           CONVERT(varchar(32), mzmc),
           CONVERT(varchar(2), hyzkdm),
           CONVERT(varchar(32), hyzkmc),
           CONVERT(varchar(70), dzsf),
           CONVERT(varchar(70), dzsq),
           CONVERT(varchar(70), dzx),
           CONVERT(varchar(70), dzxz),
           CONVERT(varchar(70), dzc),
           CONVERT(varchar(70), dzmphm),
           CONVERT(varchar(2), zylbdm),
           CONVERT(varchar(50), zylbmc),
           CONVERT(varchar(50), bscszxm),
           CONVERT(varchar(2), cszhzgxdm),
           CONVERT(varchar(50), cszhzgxmc),
           CONVERT(char(1), csnrbz),
           CONVERT(datetime, ryrq),
           CONVERT(datetime, swrq),
           CONVERT(nvarchar(2000), ryqk),
           CONVERT(varchar(20), zfbm),
           CONVERT(nvarchar(100), zzzf),
           CONVERT(nvarchar(2000), zlgcms),
           CONVERT(nvarchar(100), swyy),
           CONVERT(varchar(20), jzysbm),
           CONVERT(varchar(50), jzysqm),
           CONVERT(varchar(20), zyysbm),
           CONVERT(varchar(50), zyysqm),
           CONVERT(varchar(20), zzysbm),
           CONVERT(varchar(50), zzysqm),
           CONVERT(varchar(20), zrysbm),
           CONVERT(varchar(50), zrysqm),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_RYJL_RYSWJL

    Merge Into DC_RYJL_RYSWJL _target
    using #DC_RYJL_RYSWJL _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm    = _source.yljgdm,
        _target.jzlsh     = _source.jzlsh,
        _target.patid     = _source.patid,
        _target.zyh       = _source.zyh,
        _target.yjlxh     = _source.yjlxh,
        _target.hzxm      = _source.hzxm,
        _target.sfzhm     = _source.sfzhm,
        _target.xbmc      = _source.xbmc,
        _target.xbdm      = _source.xbdm,
        _target.nls       = _source.nls,
        _target.nly       = _source.nly,
        _target.mz        = _source.mz,
        _target.mzmc      = _source.mzmc,
        _target.hyzkdm    = _source.hyzkdm,
        _target.hyzkmc    = _source.hyzkmc,
        _target.dzsf      = _source.dzsf,
        _target.dzsq      = _source.dzsq,
        _target.dzx       = _source.dzx,
        _target.dzxz      = _source.dzxz,
        _target.dzc       = _source.dzc,
        _target.dzmphm    = _source.dzmphm,
        _target.zylbdm    = _source.zylbdm,
        _target.zylbmc    = _source.zylbmc,
        _target.bscszxm   = _source.bscszxm,
        _target.cszhzgxdm = _source.cszhzgxdm,
        _target.cszhzgxmc = _source.cszhzgxmc,
        _target.csnrbz    = _source.csnrbz,
        _target.ryrq      = _source.ryrq,
        _target.swrq      = _source.swrq,
        _target.ryqk      = _source.ryqk,
        _target.zfbm      = _source.zfbm,
        _target.zzzf      = _source.zzzf,
        _target.zlgcms    = _source.zlgcms,
        _target.swyy      = _source.swyy,
        _target.jzysbm    = _source.jzysbm,
        _target.jzysqm    = _source.jzysqm,
        _target.zyysbm    = _source.zyysbm,
        _target.zyysqm    = _source.zyysqm,
        _target.zzysbm    = _source.zzysbm,
        _target.zzysqm    = _source.zzysqm,
        _target.zrysbm    = _source.zrysbm,
        _target.zrysqm    = _source.zrysqm,
        _target.gxrq      = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, hzxm, sfzhm, xbmc, xbdm, nls, nly, mz, mzmc, hyzkdm, hyzkmc, dzsf, dzsq, dzx, dzxz, dzc, dzmphm, zylbdm, zylbmc, bscszxm, cszhzgxdm, cszhzgxmc, csnrbz, ryrq, swrq, ryqk, zfbm, zzzf, zlgcms, swyy, jzysbm, jzysqm, zyysbm, zyysqm, zzysbm, zzysqm, zrysbm, zrysqm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.hzxm, _source.sfzhm,
                              _source.xbmc, _source.xbdm, _source.nls, _source.nly, _source.mz, _source.mzmc,
                                                                                    _source.hyzkdm, _source.hyzkmc,
                                                                                    _source.dzsf, _source.dzsq,
                                                                                    _source.dzx, _source.dzxz,
                                                                                    _source.dzc, _source.dzmphm,
        _source.zylbdm, _source.zylbmc, _source.bscszxm, _source.cszhzgxdm, _source.cszhzgxmc, _source.csnrbz,
        _source.ryrq, _source.swrq, _source.ryqk, _source.zfbm, _source.zzzf, _source.zlgcms, _source.swyy,
                                                                _source.jzysbm, _source.jzysqm, _source.zyysbm,
                                                                _source.zyysqm, _source.zzysbm, _source.zzysqm,
                                                                _source.zrysbm, _source.zrysqm, _source.isNew,
              _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL
    --入院记录 — 24小时内入院死亡记录_中医四诊观察结果
    create table #DC_RYJL_RYSWJL_ZYSZGCJG (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      zyszgcjg   nvarchar(1000) null/* 中医“四诊”观察结果 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_RYJL_RYSWJL_ZYSZGCJG
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_RYJL_RYSWJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.zyszgcjg, @regex) _0

    Merge Into DC_RYJL_RYSWJL_ZYSZGCJG _target
    using #DC_RYJL_RYSWJL_ZYSZGCJG _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then Update set
      _target.yljgdm     = _source.yljgdm,
      _target.yjlxh      = _source.yjlxh,
      _target.zyjlxh     = _source.zyjlxh,
      _target.zyszgcjg   = _source.zyszgcjg,
      _target.isNew      = _source.isNew,
      _target.gxrq       = _source.gxrq,
      _target.createtime = _source.createtime,
      _target.lsnid      = _source.lsnid,
      _target.isdelete   = _source.isdelete,
      _target.sys_id     = _source.sys_id
    When Not Matched By Target Then Insert
    (yljgdm, yjlxh, zyjlxh, zyszgcjg, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
    values
    (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.zyszgcjg, _source.isNew, _source.createtime,
     _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL_ZYSZGCJG

    --入院记录 — 24小时内入院死亡记录_入院中医诊断
    create table #DC_RYJL_RYSWJL_RYZYZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      rzzybmmc   varchar(128) not null/* 入院诊断-中医病名名称 */,
      rzzybmdm   varchar(64)  not null/* 入院诊断-中医病名代码 */,
      rzzyzhmc   varchar(128) not null/* 入院诊断-中医证候名称 */,
      rzzyzhdm   varchar(64)  not null/* 入院诊断-中医证候代码 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )

    insert into #DC_RYJL_RYSWJL_RYZYZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,_2.value,_3.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_RYJL_RYSWJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.rzzybmmc, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.rzzybmdm, @regex) _1
           CROSS APPLY dbo.fn_com_split_ext(a.rzzyzhmc, @regex) _2
           CROSS APPLY dbo.fn_com_split_ext(a.rzzyzhdm, @regex) _3
    where 1 = 1 and _0.id = _1.id and _0.id = _2.id and _0.id = _3.id

    Merge Into DC_RYJL_RYSWJL_RYZYZD _target
    using #DC_RYJL_RYSWJL_RYZYZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.yjlxh    = _source.yjlxh,
        _target.zyjlxh   = _source.zyjlxh,
        _target.rzzybmmc = _source.rzzybmmc,
        _target.rzzybmdm = _source.rzzybmdm,
        _target.rzzyzhmc = _source.rzzyzhmc,
        _target.rzzyzhdm = _source.rzzyzhdm,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, rzzybmmc, rzzybmdm, rzzyzhmc, rzzyzhdm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.rzzybmmc, _source.rzzybmdm, _source.rzzyzhmc,
                              _source.rzzyzhdm, _source.isNew, _source.createtime, _source.gxrq, _source.sys_id,
              _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL_RYZYZD

    --入院记录 — 24小时内入院死亡记录_入院西医诊断
    create table #DC_RYJL_RYSWJL_RYXYZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      rzxyzdmc   varchar(128) not null/* 入院诊断-西医诊断名称 */,
      rzxyzdbm   varchar(64)  not null/* 入院诊断-西医诊断编码 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )

    insert into #DC_RYJL_RYSWJL_RYXYZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_RYJL_RYSWJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.rzxyzdmc, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.rzxyzdbm, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_RYJL_RYSWJL_RYXYZD _target
    using #DC_RYJL_RYSWJL_RYXYZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.yjlxh    = _source.yjlxh,
        _target.zyjlxh   = _source.zyjlxh,
        _target.rzxyzdmc = _source.rzxyzdmc,
        _target.rzxyzdbm = _source.rzxyzdbm,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, rzxyzdmc, rzxyzdbm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.rzxyzdmc, _source.rzxyzdbm, _source.isNew,
        _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL_RYXYZD

    --入院记录 — 24小时内入院死亡记录_死亡中医诊断
    create table #DC_RYJL_RYSWJL_SWZYZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      szzybmmc   varchar(128) not null/* 死亡诊断-中医病名名称 */,
      szzybmdm   varchar(64)  not null/* 死亡诊断-中医病名代码 */,
      szzyzhmc   varchar(128) not null/* 死亡诊断-中医证候名称 */,
      szzyzhdm   varchar(64)  not null/* 死亡诊断-中医证候代码 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )
    insert into #DC_RYJL_RYSWJL_SWZYZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,_2.value,_3.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_RYJL_RYSWJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.szzybmmc, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.szzybmdm, @regex) _1
           CROSS APPLY dbo.fn_com_split_ext(a.szzyzhmc, @regex) _2
           CROSS APPLY dbo.fn_com_split_ext(a.szzyzhdm, @regex) _3
    where 1 = 1 and _0.id = _1.id and _0.id = _2.id and _0.id = _3.id

    Merge Into DC_RYJL_RYSWJL_SWZYZD _target
    using #DC_RYJL_RYSWJL_SWZYZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.yjlxh    = _source.yjlxh,
        _target.zyjlxh   = _source.zyjlxh,
        _target.szzybmmc = _source.szzybmmc,
        _target.szzybmdm = _source.szzybmdm,
        _target.szzyzhmc = _source.szzyzhmc,
        _target.szzyzhdm = _source.szzyzhdm,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, szzybmmc, szzybmdm, szzyzhmc, szzyzhdm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.szzybmmc, _source.szzybmdm, _source.szzyzhmc,
                              _source.szzyzhdm, _source.isNew, _source.createtime, _source.gxrq, _source.sys_id,
              _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL_SWZYZD

    --入院记录 — 24小时内入院死亡记录_死亡西医诊断
    create table #DC_RYJL_RYSWJL_SWXYZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      szxyzdmc   varchar(128) not null/* 死亡诊断-西医诊断名称 */,
      szxyzdbm   varchar(64)  not null/* 死亡诊断-西医诊断编码 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )

    insert into #DC_RYJL_RYSWJL_SWXYZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_RYJL_RYSWJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.szxyzdmc, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.szxyzdbm, @regex) _1
    where 1 = 1 and _0.id = _1.id


    Merge Into DC_RYJL_RYSWJL_SWXYZD _target
    using #DC_RYJL_RYSWJL_SWXYZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.yjlxh    = _source.yjlxh,
        _target.zyjlxh   = _source.zyjlxh,
        _target.szxyzdmc = _source.szxyzdmc,
        _target.szxyzdbm = _source.szxyzdbm,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, szxyzdmc, szxyzdbm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.szxyzdmc, _source.szxyzdbm, _source.isNew,
        _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_RYJL_RYSWJL_SWXYZD

    UPDATE A SET A.STATUS = '1' FROM HLHT_RYJL_RYSWJL A,#HLHT_RYJL_RYSWJL B WHERE A.yjlxh = B.yjlxh;

    drop table #HLHT_RYJL_RYSWJL

  end
