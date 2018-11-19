﻿USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_ZYBCJL_SHSCBCJL]    Script Date: 2018/11/19 9:26:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[USP_SPLIT_ZYBCJL_SHSCBCJL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    -------------------------住院病程记录－术后首次病程记录-------------------------

    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SHSCBCJL'))
      drop table #DC_ZYBCJL_SHSCBCJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZYBCJL_SHSCBCJL'))
      drop table #HLHT_ZYBCJL_SHSCBCJL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SHSCBCJL_SHZD'))
      drop table #DC_ZYBCJL_SHSCBCJL_SHZD
    --创建临时表
    SELECT * INTO  #HLHT_ZYBCJL_SHSCBCJL  FROM HLHT_ZYBCJL_SHSCBCJL WHERE STATUS = '0'
    --住院病程记录－术后首次病程记录
    create table #DC_ZYBCJL_SHSCBCJL (
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
      birth      datetime       not null/* 患者出生日期 */,
      lxdh       varchar(50)    not null/* 联系电话 */,
      hyzkdm     varchar(20)    not null/* 患者婚姻状况代码 */,
      hyzk       varchar(50)    not null/* 患者婚姻状况 */,
      mzdm       varchar(20)    not null/* 民族代码 */,
      mz         varchar(50)    not null/* 民族 */,
      hkszd      varchar(50)    null/* 户口所在地 */,
      csdz       varchar(500)   null/* 出生地址 */,
      gzdw       varchar(50)    null/* 工作单位名称 */,
      gzdwdz     varchar(500)   null/* 工作地点 */,
      gzdwdh     varchar(70)    null/* 工作单位电话 */,
      jgd        varchar(50)    null/* 籍贯地 */,
      sfzhm      varchar(18)    not null/* 患者身份证号标识 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      jlrq       datetime       not null/* 记录日期时间 */,
      ssczbm     varchar(64)    not null/* 手术及操作编码 */,
      ssmc       varchar(128)   not null/* 手术名称 */,
      ssmbbwdm   varchar(64)    not null/* 手术目标部位编码 */,
      ssbwmc     varchar(128)   not null/* 手术目标部位名称 */,
      ssrq       datetime       not null/* 手术日期时间 */,
      mzffdm     varchar(64)    not null/* 麻醉方法代码 */,
      mzffmc     varchar(128)   not null/* 麻醉方法名称 */,
      ssgc       nvarchar(2000) not null/* 手术过程 */,
      zdyjdm     nvarchar(1000) not null/* 诊断依据编码 */,
      zdyj       nvarchar(1000) not null/* 诊断依据名称 */,
      zysx       nvarchar(1000) null/* 注意事项 */,
      ysbm       varchar(20)    not null/* 签名人工号 */,
      ysqm       varchar(50)    not null/* 签名人姓名 */,
      qmrq       datetime       not null/* 签名日期时间 */,
      jzkssj     datetime       not null/* (入院)就诊开始时间 */,
      jzjssj     datetime       not null/* (出院)就诊结束时间 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_ZYBCJL_SHSCBCJL
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
           CONVERT(datetime, birth),
           CONVERT(varchar(50), lxdh),
           CONVERT(varchar(20), hyzkdm),
           CONVERT(varchar(50), hyzk),
           CONVERT(varchar(20), mzdm),
           CONVERT(varchar(50), mz),
           CONVERT(varchar(50), hkszd),
           CONVERT(varchar(500), csdz),
           CONVERT(varchar(50), gzdw),
           CONVERT(varchar(500), gzdwdz),
           CONVERT(varchar(70), gzdwdh),
           CONVERT(varchar(50), jgd),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(datetime, jlrq),
           CONVERT(varchar(64), ssczbm),
           CONVERT(varchar(128), ssmc),
           CONVERT(varchar(64), ssmbbwdm),
           CONVERT(varchar(128), ssbwmc),
           CONVERT(datetime, ssrq),
           CONVERT(varchar(64), mzffdm),
           CONVERT(varchar(128), mzffmc),
           CONVERT(nvarchar(2000), ssgc),
           CONVERT(nvarchar(1000), zdyjdm),
           CONVERT(nvarchar(1000), zdyj),
           CONVERT(nvarchar(1000), zysx),
           CONVERT(varchar(20), ysbm),
           CONVERT(varchar(50), ysqm),
           CONVERT(datetime, qmrq),
           CONVERT(datetime, jzkssj),
           CONVERT(datetime, jzjssj),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_ZYBCJL_SHSCBCJL

    Merge Into DC_ZYBCJL_SHSCBCJL _target
    using #DC_ZYBCJL_SHSCBCJL _source
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
        _target.birth    = _source.birth,
        _target.lxdh     = _source.lxdh,
        _target.hyzkdm   = _source.hyzkdm,
        _target.hyzk     = _source.hyzk,
        _target.mzdm     = _source.mzdm,
        _target.mz       = _source.mz,
        _target.hkszd    = _source.hkszd,
        _target.csdz     = _source.csdz,
        _target.gzdw     = _source.gzdw,
        _target.gzdwdz   = _source.gzdwdz,
        _target.gzdwdh   = _source.gzdwdh,
        _target.jgd      = _source.jgd,
        _target.sfzhm    = _source.sfzhm,
        _target.xbdm     = _source.xbdm,
        _target.xbmc     = _source.xbmc,
        _target.nls      = _source.nls,
        _target.nly      = _source.nly,
        _target.jlrq     = _source.jlrq,
        _target.ssczbm   = _source.ssczbm,
        _target.ssmc     = _source.ssmc,
        _target.ssmbbwdm = _source.ssmbbwdm,
        _target.ssbwmc   = _source.ssbwmc,
        _target.ssrq     = _source.ssrq,
        _target.mzffdm   = _source.mzffdm,
        _target.mzffmc   = _source.mzffmc,
        _target.ssgc     = _source.ssgc,
        _target.zdyjdm   = _source.zdyjdm,
        _target.zdyj     = _source.zdyj,
        _target.zysx     = _source.zysx,
        _target.ysbm     = _source.ysbm,
        _target.ysqm     = _source.ysqm,
        _target.qmrq     = _source.qmrq,
        _target.jzkssj   = _source.jzkssj,
        _target.jzjssj   = _source.jzjssj,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, hzxm, birth, lxdh, hyzkdm, hyzk, mzdm, mz, hkszd, csdz, gzdw, gzdwdz, gzdwdh, jgd, sfzhm, xbdm, xbmc, nls, nly, jlrq, ssczbm, ssmc, ssmbbwdm, ssbwmc, ssrq, mzffdm, mzffmc, ssgc, zdyjdm, zdyj, zysx, ysbm, ysqm, qmrq, jzkssj, jzjssj, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.ksdm, _source.ksmc,
                              _source.bqdm, _source.bqmc, _source.bfh, _source.bfmc, _source.bch, _source.hzxm,
                                                                                     _source.birth, _source.lxdh,
                                                                                     _source.hyzkdm, _source.hyzk,
                                                                                     _source.mzdm, _source.mz,
                                                                                     _source.hkszd, _source.csdz,
        _source.gzdw, _source.gzdwdz, _source.gzdwdh, _source.jgd, _source.sfzhm, _source.xbdm, _source.xbmc,
        _source.nls, _source.nly, _source.jlrq, _source.ssczbm, _source.ssmc, _source.ssmbbwdm, _source.ssbwmc,
                                                _source.ssrq, _source.mzffdm, _source.mzffmc, _source.ssgc,
                                                _source.zdyjdm, _source.zdyj, _source.zysx, _source.ysbm, _source.ysqm,
                                                                              _source.qmrq, _source.jzkssj,
                                                                              _source.jzjssj, _source.isNew,
                                                                              _source.createtime, _source.gxrq,
                                                                              _source.sys_id, _source.lsnid,
              _source.isdelete);
    drop table #DC_ZYBCJL_SHSCBCJL

    --住院病程记录－术后首次病程记录_术后诊断
    create table #DC_ZYBCJL_SHSCBCJL_SHZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      shzdmc     varchar(128) not null/* 术后诊断名称 */,
      shzdbm     varchar(64)  not null/* 术后诊断编码 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )

    insert into #DC_ZYBCJL_SHSCBCJL_SHZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_ZYBCJL_SHSCBCJL as a
           CROSS APPLY dbo.fn_com_split_ext(a.shzdmc, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.shzdbm, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_ZYBCJL_SHSCBCJL_SHZD _target
    using #DC_ZYBCJL_SHSCBCJL_SHZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.shzdmc = _source.shzdmc,
        _target.shzdbm = _source.shzdbm,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, shzdmc, shzdbm, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.shzdmc, _source.shzdbm, _source.isNew,
        _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_ZYBCJL_SHSCBCJL_SHZD

    UPDATE A SET A.STATUS='1' FROM HLHT_ZYBCJL_SHSCBCJL A,#HLHT_ZYBCJL_SHSCBCJL B WHERE A.yjlxh = B.yjlxh
    drop table #HLHT_ZYBCJL_SHSCBCJL
  end