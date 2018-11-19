USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_MJZBL_JZLGBL]    Script Date: 2018/11/19 9:25:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title 门（急）诊病历 — 急诊留观病历
 * @email chensj@winning.com.cn
 * @package  exec USP_SPLIT_MJZBL_JZLGBL '12345678','  '
 * @date: 2018-11-16 12:41
 */
ALTER procedure [dbo].[USP_SPLIT_MJZBL_JZLGBL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_MJZBL_JZLGBL'))
      drop table #DC_MJZBL_JZLGBL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_MJZBL_JZLGBL'))
      drop table #HLHT_MJZBL_JZLGBL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_MJZBL_JZLGBL_GMS'))
      drop table #DC_MJZBL_JZLGBL_GMS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_MJZBL_JZLGBL_SSCZ'))
      drop table #DC_MJZBL_JZLGBL_SSCZ

    -- 创建临时表
    select * into #HLHT_MJZBL_JZLGBL from HLHT_MJZBL_JZLGBL where STATUS = '0';
    -- 主表操作
    create table #DC_MJZBL_JZLGBL (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      jzlsh      varchar(64)    not null/* 就诊流水号 */,
      patid      varchar(64)    not null/* 患者patid */,
      zyh        varchar(64)    not null/* 住院号 */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zzjgdm     varchar(10)    not null/* 医疗机构组织机构代码 */,
      zzjgmc     varchar(70)    not null/* 医疗机构组织机构名称 */,
      mjzh       varchar(64)    not null/* 门急诊号 */,
      ksdm       varchar(10)    not null/* 科室代码 */,
      ksmc       varchar(50)    not null/* 科室名称 */,
      hzxm       varchar(64)    not null/* 患者姓名 */,
      sfzhm      varchar(18)    not null/* 身份证号 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      csrq       date           not null/* 出生日期 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      jzrqsj     datetime       not null/* 就诊日期时间 */,
      czbzdm     varchar(2)     not null/* 初诊标志代码 */,
      czbzmc     varchar(18)    not null/* 初诊标志名称 */,
      srgcsrq    datetime       not null/* 收入观察室日期时间 */,
      zs         nvarchar(100)  not null/* 主诉 */,
      xbs        nvarchar(2000) not null/* 现病史 */,
      jws        nvarchar(1000) not null/* 既往史 */,
      tgjc       nvarchar(500)  not null/* 体格检查 */,
      zyszgcjg   nvarchar(1000) null/* 中医“四诊”观察结果 */,
      fzjcxm     nvarchar(100)  null/* 辅助检查项目 */,
      fzjcjg     nvarchar(1000) null/* 辅助检查结果 */,
      xyzdbm     varchar(64)    not null/* 初步诊断-西医诊断编码 */,
      xyzdmc     varchar(128)   not null/* 初步诊断-西医诊断名称 */,
      zybmdm     varchar(64)    not null/* 初步诊断-中医病名代码 */,
      zybmmc     varchar(128)   not null/* 初步诊断-中医病名名称 */,
      zyzhdm     varchar(64)    not null/* 初步诊断-中医证候代码 */,
      zyzhmc     varchar(128)   not null/* 初步诊断-中医证候名称 */,
      bzyj       nvarchar(100)  null/* 辨证依据 */,
      zfbm       varchar(20)    null/* 治则治法代码 */,
      zzzf       nvarchar(100)  null/* 治则治法 */,
      yzxmlx     varchar(2)     not null/* 医嘱项目类型代码 */,
      yzxmlxmc   sysname        not null/* 医嘱项目类型名称 */,
      yzxmnr     nvarchar(100)  not null/* 医嘱项目内容 */,
      yzbzxx     nvarchar(100)  not null/* 医嘱备注信息 */,
      yzklksdm   varchar(10)    not null/* 医嘱开立代码 */,
      yzklks     varchar(50)    not null/* 医嘱开立科室 */,
      yzklzdm    varchar(20)    not null/* 医嘱开立者工号 */,
      yzklzqm    varchar(50)    not null/* 医嘱开立者签名 */,
      yzklrq     datetime       not null/* 医嘱开立日期时间 */,
      yzshzdm    varchar(20)    not null/* 医嘱审核者工号 */,
      yzshzqm    varchar(50)    not null/* 医嘱审核者签名 */,
      yzshrq     datetime       not null/* 医嘱审核日期时间 */,
      yzzxksdm   varchar(10)    not null/* 医嘱执行代码 */,
      yzzxks     varchar(50)    not null/* 医嘱执行科室 */,
      yzzxzdm    varchar(20)    not null/* 医嘱执行者工号 */,
      yzzxzqm    varchar(50)    not null/* 医嘱执行者签名 */,
      yzzxrq     datetime       not null/* 医嘱执行日期时间 */,
      yzjhjsrq   datetime       not null/* 医嘱计划结束日期时间 */,
      yzzxzt     varchar(50)    not null/* 医嘱执行状态 */,
      qxyzzdm    varchar(20)    not null/* 取消医嘱者工号 */,
      qxyzzqm    varchar(50)    not null/* 取消医嘱者签名 */,
      yzqxrq     datetime       not null/* 医嘱取消日期时间 */,
      dzsqdbh    varchar(50)    not null/* 电子申请单编号 */,
      jzlgbcjl   nvarchar(2000) not null/* 急诊留观病程记录 */,
      qjksrq     datetime       not null/* 抢救开始日期时间 */,
      qjjsrq     datetime       not null/* 抢救结束日期时间 */,
      jzqjjl     nvarchar(2000) not null/* 急诊抢救记录 */,
      jlrqsj     datetime       not null/* 记录日期时间 */,
      zysx       nvarchar(1000) not null/* 注意事项 */,
      cjqjrydm   varchar(100)   not null/* 参加抢救人员名单代码 */,
      cjqjrymd   varchar(500)   not null/* 参加抢救人员名单 */,
      zyjszwlb   varchar(8)     not null/* 专业技术职务类别代码 */,
      zyjszwlbmc varchar(64)    not null/* 专业技术职务类别名称 */,
      hzqxdm     varchar(2)     not null/* 患者去向代码 */,
      hzqxmc     varchar(18)    not null/* 患者去向名称 */,
      zrysbm     varchar(20)    not null/* 责任医师工号 */,
      zrysqm     varchar(50)    not null/* 责任医师姓名 */,
      ysbm       varchar(20)    not null/* 签名医师工号 */,
      ysqm       varchar(50)    not null/* 签名医师名称 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_MJZBL_JZLGBL
    select @yljgdm,
           CONVERT(varchar(64), jzlsh),
           CONVERT(varchar(64), patid),
           CONVERT(varchar(64), zyh),
           CONVERT(varchar(64), yjlxh),
           CONVERT(varchar(10), zzjgdm),
           CONVERT(varchar(70), zzjgmc),
           CONVERT(varchar(64), mjzh),
           CONVERT(varchar(10), ksdm),
           CONVERT(varchar(50), ksmc),
           CONVERT(varchar(64), hzxm),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(date, csrq),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(datetime, jzrqsj),
           CONVERT(varchar(2), czbzdm),
           CONVERT(varchar(18), czbzmc),
           CONVERT(datetime, srgcsrq),
           CONVERT(nvarchar(100), zs),
           CONVERT(nvarchar(2000), xbs),
           CONVERT(nvarchar(1000), jws),
           CONVERT(nvarchar(500), tgjc),
           CONVERT(nvarchar(1000), zyszgcjg),
           CONVERT(nvarchar(100), fzjcxm),
           CONVERT(nvarchar(1000), fzjcjg),
           CONVERT(varchar(64), xyzdbm),
           CONVERT(varchar(128), xyzdmc),
           CONVERT(varchar(64), zybmdm),
           CONVERT(varchar(128), zybmmc),
           CONVERT(varchar(64), zyzhdm),
           CONVERT(varchar(128), zyzhmc),
           CONVERT(nvarchar(100), bzyj),
           CONVERT(varchar(20), zfbm),
           CONVERT(nvarchar(100), zzzf),
           CONVERT(varchar(2), yzxmlx),
           CONVERT(sysname, yzxmlxmc),
           CONVERT(nvarchar(100), yzxmnr),
           CONVERT(nvarchar(100), yzbzxx),
           CONVERT(varchar(10), yzklksdm),
           CONVERT(varchar(50), yzklks),
           CONVERT(varchar(20), yzklzdm),
           CONVERT(varchar(50), yzklzqm),
           CONVERT(datetime, yzklrq),
           CONVERT(varchar(20), yzshzdm),
           CONVERT(varchar(50), yzshzqm),
           CONVERT(datetime, yzshrq),
           CONVERT(varchar(10), yzzxksdm),
           CONVERT(varchar(50), yzzxks),
           CONVERT(varchar(20), yzzxzdm),
           CONVERT(varchar(50), yzzxzqm),
           CONVERT(datetime, yzzxrq),
           CONVERT(datetime, yzjhjsrq),
           CONVERT(varchar(50), yzzxzt),
           CONVERT(varchar(20), qxyzzdm),
           CONVERT(varchar(50), qxyzzqm),
           CONVERT(datetime, yzqxrq),
           CONVERT(varchar(50), dzsqdbh),
           CONVERT(nvarchar(2000), jzlgbcjl),
           CONVERT(datetime, qjksrq),
           CONVERT(datetime, qjjsrq),
           CONVERT(nvarchar(2000), jzqjjl),
           CONVERT(datetime, jlrqsj),
           CONVERT(nvarchar(1000), zysx),
           CONVERT(varchar(100), cjqjrydm),
           CONVERT(varchar(500), cjqjrymd),
           CONVERT(varchar(8), zyjszwlb),
           CONVERT(varchar(64), zyjszwlbmc),
           CONVERT(varchar(2), hzqxdm),
           CONVERT(varchar(18), hzqxmc),
           CONVERT(varchar(20), zrysbm),
           CONVERT(varchar(50), zrysqm),
           CONVERT(varchar(20), ysbm),
           CONVERT(varchar(50), ysqm),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_MJZBL_JZLGBL

    Merge Into DC_MJZBL_JZLGBL _target
    using #DC_MJZBL_JZLGBL _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm     = _source.yljgdm,
        _target.jzlsh      = _source.jzlsh,
        _target.patid      = _source.patid,
        _target.zyh        = _source.zyh,
        _target.yjlxh      = _source.yjlxh,
        _target.zzjgdm     = _source.zzjgdm,
        _target.zzjgmc     = _source.zzjgmc,
        _target.mjzh       = _source.mjzh,
        _target.ksdm       = _source.ksdm,
        _target.ksmc       = _source.ksmc,
        _target.hzxm       = _source.hzxm,
        _target.sfzhm      = _source.sfzhm,
        _target.xbdm       = _source.xbdm,
        _target.xbmc       = _source.xbmc,
        _target.csrq       = _source.csrq,
        _target.nls        = _source.nls,
        _target.nly        = _source.nly,
        _target.jzrqsj     = _source.jzrqsj,
        _target.czbzdm     = _source.czbzdm,
        _target.czbzmc     = _source.czbzmc,
        _target.srgcsrq    = _source.srgcsrq,
        _target.zs         = _source.zs,
        _target.xbs        = _source.xbs,
        _target.jws        = _source.jws,
        _target.tgjc       = _source.tgjc,
        _target.zyszgcjg   = _source.zyszgcjg,
        _target.fzjcxm     = _source.fzjcxm,
        _target.fzjcjg     = _source.fzjcjg,
        _target.xyzdbm     = _source.xyzdbm,
        _target.xyzdmc     = _source.xyzdmc,
        _target.zybmdm     = _source.zybmdm,
        _target.zybmmc     = _source.zybmmc,
        _target.zyzhdm     = _source.zyzhdm,
        _target.zyzhmc     = _source.zyzhmc,
        _target.bzyj       = _source.bzyj,
        _target.zfbm       = _source.zfbm,
        _target.zzzf       = _source.zzzf,
        _target.yzxmlx     = _source.yzxmlx,
        _target.yzxmlxmc   = _source.yzxmlxmc,
        _target.yzxmnr     = _source.yzxmnr,
        _target.yzbzxx     = _source.yzbzxx,
        _target.yzklksdm   = _source.yzklksdm,
        _target.yzklks     = _source.yzklks,
        _target.yzklzdm    = _source.yzklzdm,
        _target.yzklzqm    = _source.yzklzqm,
        _target.yzklrq     = _source.yzklrq,
        _target.yzshzdm    = _source.yzshzdm,
        _target.yzshzqm    = _source.yzshzqm,
        _target.yzshrq     = _source.yzshrq,
        _target.yzzxksdm   = _source.yzzxksdm,
        _target.yzzxks     = _source.yzzxks,
        _target.yzzxzdm    = _source.yzzxzdm,
        _target.yzzxzqm    = _source.yzzxzqm,
        _target.yzzxrq     = _source.yzzxrq,
        _target.yzjhjsrq   = _source.yzjhjsrq,
        _target.yzzxzt     = _source.yzzxzt,
        _target.qxyzzdm    = _source.qxyzzdm,
        _target.qxyzzqm    = _source.qxyzzqm,
        _target.yzqxrq     = _source.yzqxrq,
        _target.dzsqdbh    = _source.dzsqdbh,
        _target.jzlgbcjl   = _source.jzlgbcjl,
        _target.qjksrq     = _source.qjksrq,
        _target.qjjsrq     = _source.qjjsrq,
        _target.jzqjjl     = _source.jzqjjl,
        _target.jlrqsj     = _source.jlrqsj,
        _target.zysx       = _source.zysx,
        _target.cjqjrydm   = _source.cjqjrydm,
        _target.cjqjrymd   = _source.cjqjrymd,
        _target.zyjszwlb   = _source.zyjszwlb,
        _target.zyjszwlbmc = _source.zyjszwlbmc,
        _target.hzqxdm     = _source.hzqxdm,
        _target.hzqxmc     = _source.hzqxmc,
        _target.zrysbm     = _source.zrysbm,
        _target.zrysqm     = _source.zrysqm,
        _target.ysbm       = _source.ysbm,
        _target.ysqm       = _source.ysqm,
        _target.gxrq       = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, zzjgdm, zzjgmc, mjzh, ksdm, ksmc, hzxm, sfzhm, xbdm, xbmc, csrq, nls, nly, jzrqsj, czbzdm, czbzmc, srgcsrq, zs, xbs, jws, tgjc, zyszgcjg, fzjcxm, fzjcjg, xyzdbm, xyzdmc, zybmdm, zybmmc, zyzhdm, zyzhmc, bzyj, zfbm, zzzf, yzxmlx, yzxmlxmc, yzxmnr, yzbzxx, yzklksdm, yzklks, yzklzdm, yzklzqm, yzklrq, yzshzdm, yzshzqm, yzshrq, yzzxksdm, yzzxks, yzzxzdm, yzzxzqm, yzzxrq, yzjhjsrq, yzzxzt, qxyzzdm, qxyzzqm, yzqxrq, dzsqdbh, jzlgbcjl, qjksrq, qjjsrq, jzqjjl, jlrqsj, zysx, cjqjrydm, cjqjrymd, zyjszwlb, zyjszwlbmc, hzqxdm, hzqxmc, zrysbm, zrysqm, ysbm, ysqm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.zzjgdm, _source.zzjgmc,
                              _source.mjzh, _source.ksdm, _source.ksmc, _source.hzxm, _source.sfzhm, _source.xbdm,
                                                                                      _source.xbmc, _source.csrq,
                                                                                      _source.nls, _source.nly,
                                                                                      _source.jzrqsj, _source.czbzdm,
                                                                                      _source.czbzmc, _source.srgcsrq,
        _source.zs, _source.xbs, _source.jws, _source.tgjc, _source.zyszgcjg, _source.fzjcxm, _source.fzjcjg,
        _source.xyzdbm, _source.xyzdmc, _source.zybmdm, _source.zybmmc, _source.zyzhdm, _source.zyzhmc, _source.bzyj,
                                                        _source.zfbm, _source.zzzf, _source.yzxmlx, _source.yzxmlxmc,
                                                        _source.yzxmnr, _source.yzbzxx, _source.yzklksdm,
                                                                                        _source.yzklks, _source.yzklzdm,
                                                                                        _source.yzklzqm, _source.yzklrq,
                                                                                        _source.yzshzdm,
                                                                                        _source.yzshzqm, _source.yzshrq,
                                                                                        _source.yzzxksdm,
                                                                                        _source.yzzxks, _source.yzzxzdm,
                                                                                                        _source.yzzxzqm,
                                                                                                        _source.yzzxrq,
                                                                                                        _source.yzjhjsrq,
                                                                                                        _source.yzzxzt,
                                                                                                        _source.qxyzzdm,
                                                                                                        _source.qxyzzqm,
                                                                                                        _source.yzqxrq,
                                                                                                        _source.dzsqdbh,
                                                                                                        _source.jzlgbcjl,
        _source.qjksrq, _source.qjjsrq, _source.jzqjjl, _source.jlrqsj, _source.zysx, _source.cjqjrydm,
        _source.cjqjrymd, _source.zyjszwlb, _source.zyjszwlbmc, _source.hzqxdm, _source.hzqxmc, _source.zrysbm,
                                                                                _source.zrysqm, _source.ysbm,
                                                                                _source.ysqm, _source.isNew,
                                                                                _source.createtime, _source.gxrq,
                                                                                _source.sys_id, _source.lsnid,
              _source.isdelete);
    drop table #DC_MJZBL_JZLGBL
    --门（急）诊病历 — 急诊留观病历_过敏史
    create table #DC_MJZBL_JZLGBL_GMS (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      gmsbz      char(1)        not null/* 过敏史标志 */,
      gms        nvarchar(1000) not null/* 过敏史 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_MJZBL_JZLGBL_GMS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_MJZBL_JZLGBL as a
           CROSS APPLY dbo.fn_com_split_ext(a.gmsbz, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.gms, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_MJZBL_JZLGBL_GMS _target
    using #DC_MJZBL_JZLGBL_GMS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.gmsbz  = _source.gmsbz,
        _target.gms    = _source.gms,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, gmsbz, gms, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.gmsbz, _source.gms, _source.isNew, _source.createtime,
        _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_MJZBL_JZLGBL_GMS
    -- 门（急）诊病历 — 急诊留观病历_手术操作
    create table #DC_MJZBL_JZLGBL_SSCZ (
      xh         numeric(12) identity (1,1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      ssjczbm    varchar(64)    null/* 手术及操作编码 */,
      ssjczmc    varchar(128)   null/* 手术及操作名称 */,
      ssmbbwbm   varchar(100)   null/* 手术及操作目标部位编码 */,
      ssmbbw     varchar(500)   null/* 手术及操作目标部位名称 */,
      jrwdm      varchar(100)   null/* 介入物代码 */,
      jrwmc      varchar(500)   null/* 介入物名称 */,
      ssjczff    nvarchar(2000) null/* 手术及操作方法 */,
      ssjczcs    varchar(3)     null/* 手术及操作次数 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_MJZBL_JZLGBL_SSCZ
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,_2.value,_3.value,_4.value,_5.value,_6.value,_7.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_MJZBL_JZLGBL as a
           CROSS APPLY dbo.fn_com_split_ext(a.ssjczbm, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.ssjczmc, @regex) _1
           CROSS APPLY dbo.fn_com_split_ext(a.ssmbbwbm, @regex) _2
           CROSS APPLY dbo.fn_com_split_ext(a.ssmbbw, @regex) _3
           CROSS APPLY dbo.fn_com_split_ext(a.jrwdm, @regex) _4
           CROSS APPLY dbo.fn_com_split_ext(a.jrwmc, @regex) _5
           CROSS APPLY dbo.fn_com_split_ext(a.ssjczff, @regex) _6
           CROSS APPLY dbo.fn_com_split_ext(a.ssjczcs, @regex) _7
    where 1 = 1
      and _0.id = _1.id and _0.id = _2.id and _0.id = _3.id and _0.id = _4.id
      and _0.id = _5.id and _0.id = _6.id and _0.id = _7.id

    Merge Into DC_MJZBL_JZLGBL_SSCZ _target
    using #DC_MJZBL_JZLGBL_SSCZ _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm   = _source.yljgdm,
        _target.yjlxh    = _source.yjlxh,
        _target.zyjlxh   = _source.zyjlxh,
        _target.ssjczbm  = _source.ssjczbm,
        _target.ssjczmc  = _source.ssjczmc,
        _target.ssmbbwbm = _source.ssmbbwbm,
        _target.ssmbbw   = _source.ssmbbw,
        _target.jrwdm    = _source.jrwdm,
        _target.jrwmc    = _source.jrwmc,
        _target.ssjczff  = _source.ssjczff,
        _target.ssjczcs  = _source.ssjczcs,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, ssjczbm, ssjczmc, ssmbbwbm, ssmbbw, jrwdm, jrwmc, ssjczff, ssjczcs, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.ssjczbm, _source.ssjczmc, _source.ssmbbwbm,
                              _source.ssmbbw, _source.jrwdm, _source.jrwmc, _source.ssjczff, _source.ssjczcs,
              _source.isNew, _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_MJZBL_JZLGBL_SSCZ

    UPDATE A SET A.STATUS = '1' FROM HLHT_MJZBL_JZLGBL A,#HLHT_MJZBL_JZLGBL B WHERE A.yjlxh = B.yjlxh;
    drop table #HLHT_MJZBL_JZLGBL
  end