USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_BLGY_JBJKXX]    Script Date: 2018/11/19 9:24:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title 病历概要 — 基本健康信息
 * @email chensj@winning.com.cn
 * @package  exec USP_SPLIT_BLGY_JBJKXX '12345678','  '
 * @date: 2018-11-16 12:41
 */
ALTER procedure [dbo].[USP_SPLIT_BLGY_JBJKXX]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX'))
      drop table #DC_BLGY_JBJKXX
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_BLGY_JBJKXX'))
      drop table #HLHT_BLGY_JBJKXX
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_CRBS'))
      drop table #DC_BLGY_JBJKXX_CRBS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_GMS'))
      drop table #DC_BLGY_JBJKXX_GMS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_JBS'))
      drop table #DC_BLGY_JBJKXX_JBS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_JZ_JZS'))
      drop table #DC_BLGY_JBJKXX_JZ_JZS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_HYS'))
      drop table #DC_BLGY_JBJKXX_HYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_SYS'))
      drop table #DC_BLGY_JBJKXX_SYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_BLGY_JBJKXX_YFJZS'))
      drop table #DC_BLGY_JBJKXX_YFJZS

    -- 创建临时表
    select * into #HLHT_BLGY_JBJKXX from HLHT_BLGY_JBJKXX where STATUS = '0';
    -- 主表操作
    create table #DC_BLGY_JBJKXX (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      jzlsh      varchar(64)    not null/* 就诊流水号 */,
      patid      varchar(64)    not null/* 患者patid */,
      jzlb       varchar(2)     not null/* 就诊类别 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      hzxm       varchar(64)    not null/* 患者姓名 */,
      mjzh       varchar(64)    not null/* 门急诊号 */,
      zyh        varchar(64)    not null/* 住院号 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      sfzhm      varchar(18)    not null/* 患者身份证件号码 */,
      jkkh       varchar(18)    not null/* 居民健康卡号 */,
      aboxxdm    varchar(4)     not null/* ABO血型代码 */,
      aboxxmc    varchar(18)    not null/* ABO血型名称 */,
      rhxxdm     varchar(4)     not null/* Rh血型代码 */,
      rhxxmc     varchar(18)    not null/* Rh血型名称 */,
      sxs        nvarchar(1000) not null/* 输血史 */,
      grs        nvarchar(1000) not null/* 个人史 */,
      yjs        nvarchar(1000) not null/* 月经史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_BLGY_JBJKXX
    select @yljgdm,
           CONVERT(varchar(64), jzlsh),
           CONVERT(varchar(64), patid),
           CONVERT(varchar(2), jzlb),
           CONVERT(varchar(64), yjlxh),
           CONVERT(varchar(64), hzxm),
           CONVERT(varchar(64), mjzh),
           CONVERT(varchar(64), zyh),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(18), jkkh),
           CONVERT(varchar(4), aboxxdm),
           CONVERT(varchar(18), aboxxmc),
           CONVERT(varchar(4), rhxxdm),
           CONVERT(varchar(18), rhxxmc),
           CONVERT(nvarchar(1000), sxs),
           CONVERT(nvarchar(1000), grs),
           CONVERT(nvarchar(1000), yjs),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_BLGY_JBJKXX
    Merge Into DC_BLGY_JBJKXX _target
    using #DC_BLGY_JBJKXX _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm  = _source.yljgdm,
        _target.jzlsh   = _source.jzlsh,
        _target.patid   = _source.patid,
        _target.jzlb    = _source.jzlb,
        _target.yjlxh   = _source.yjlxh,
        _target.hzxm    = _source.hzxm,
        _target.mjzh    = _source.mjzh,
        _target.zyh     = _source.zyh,
        _target.xbdm    = _source.xbdm,
        _target.xbmc    = _source.xbmc,
        _target.sfzhm   = _source.sfzhm,
        _target.jkkh    = _source.jkkh,
        _target.aboxxdm = _source.aboxxdm,
        _target.aboxxmc = _source.aboxxmc,
        _target.rhxxdm  = _source.rhxxdm,
        _target.rhxxmc  = _source.rhxxmc,
        _target.sxs     = _source.sxs,
        _target.grs     = _source.grs,
        _target.yjs     = _source.yjs,
        _target.gxrq    = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, jzlb, yjlxh, hzxm, mjzh, zyh, xbdm, xbmc, sfzhm, jkkh, aboxxdm, aboxxmc, rhxxdm, rhxxmc, sxs, grs, yjs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.jzlb, _source.yjlxh, _source.hzxm, _source.mjzh,
                              _source.zyh, _source.xbdm, _source.xbmc, _source.sfzhm, _source.jkkh, _source.aboxxdm,
                                                                                      _source.aboxxmc, _source.rhxxdm,
                                                                                      _source.rhxxmc, _source.sxs,
                                                                                      _source.grs, _source.yjs,
                                                                                      _source.isNew, _source.createtime,
              _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX

    -- 病历概要 — 基本健康信息_传染病史
    create table #DC_BLGY_JBJKXX_CRBS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      crbs       nvarchar(1000) not null/* 传染病史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_BLGY_JBJKXX_CRBS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.crbs, @regex) _0

    Merge Into DC_BLGY_JBJKXX_CRBS _target
    using #DC_BLGY_JBJKXX_CRBS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.crbs   = _source.crbs,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, crbs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.crbs, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_CRBS
    -- 病历概要 — 基本健康信息_过敏史
    create table #DC_BLGY_JBJKXX_GMS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      gms        nvarchar(1000) not null/* 过敏史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_BLGY_JBJKXX_GMS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.gms, @regex) _0

    Merge Into DC_BLGY_JBJKXX_GMS _target
    using #DC_BLGY_JBJKXX_GMS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.gms    = _source.gms,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, gms, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.gms, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_GMS
    -- 病历概要 — 基本健康信息_疾病史
    create table #DC_BLGY_JBJKXX_JBS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      jbs        nvarchar(1000) not null/* 疾病史（含外伤） */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_BLGY_JBJKXX_JBS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.jbs, @regex) _0
    where 1 = 1

    Merge Into DC_BLGY_JBJKXX_JBS _target
    using #DC_BLGY_JBJKXX_JBS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.jbs    = _source.jbs,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, jbs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.jbs, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_JBS
    -- 病历概要 — 基本健康信息_家族史
    create table #DC_BLGY_JBJKXX_JZ_JZS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      jzs        nvarchar(1000) not null/* 家族史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_BLGY_JBJKXX_JZ_JZS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.jzs, @regex) _0
    where 1 = 1

    Merge Into DC_BLGY_JBJKXX_JZ_JZS _target
    using #DC_BLGY_JBJKXX_JZ_JZS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.jzs    = _source.jzs,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, jzs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.jzs, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_JZ_JZS
    -- 病历概要 — 基本健康信息_手术史
    create table #DC_BLGY_JBJKXX_SSS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      sss        nvarchar(1000) not null/* 手术史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_BLGY_JBJKXX_SSS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.sss, @regex) _0
    where 1 = 1

    Merge Into DC_BLGY_JBJKXX_SSS _target
    using #DC_BLGY_JBJKXX_SSS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.sss    = _source.sss,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, sss, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.sss, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_SSS

    -- 病历概要 — 基本健康信息_婚育史
    create table #DC_BLGY_JBJKXX_HYS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      hys        nvarchar(1000) not null/* 婚育史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_BLGY_JBJKXX_HYS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.hys, @regex) _0
    where 1 = 1

    Merge Into DC_BLGY_JBJKXX_HYS _target
    using #DC_BLGY_JBJKXX_HYS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.hys    = _source.hys,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, hys, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.hys, _source.isNew, _source.createtime, _source.gxrq,
       _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_HYS

    -- 病历概要 — 基本健康信息_预防接种史
    create table #DC_BLGY_JBJKXX_YFJZS (
      xh         numeric(12) identity (1, 1)/* 序号 */,
      yljgdm     varchar(20)    not null/* 医疗机构代码 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      yfjzs      nvarchar(1000) not null/* 预防接种史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_BLGY_JBJKXX_YFJZS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_BLGY_JBJKXX as a
           CROSS APPLY dbo.fn_com_split_ext(a.yfjzs, @regex) _0
    where 1 = 1

    Merge Into DC_BLGY_JBJKXX_YFJZS _target
    using #DC_BLGY_JBJKXX_YFJZS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.yfjzs  = _source.yfjzs,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, yfjzs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.yfjzs, _source.isNew, _source.createtime,
              _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_BLGY_JBJKXX_YFJZS
    UPDATE A SET A.STATUS = '1' FROM HLHT_BLGY_JBJKXX A,#HLHT_BLGY_JBJKXX B WHERE A.yjlxh = B.yjlxh;

    drop table #HLHT_BLGY_JBJKXX
  end