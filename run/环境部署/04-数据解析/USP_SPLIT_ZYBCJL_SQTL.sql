USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_ZYBCJL_SQTL]    Script Date: 2018/11/19 9:27:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title  住院病程记录－术前讨论
 * @email chensj@winning.com.cn
 * @date: 2018-11-16 10:33
 * exec USP_SPLIT_ZYBCJL_SQTL '12345678','  '
 */
ALTER PROCEDURE [dbo].[USP_SPLIT_ZYBCJL_SQTL]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SQTL'))
      drop table #DC_ZYBCJL_SQTL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZYBCJL_SQTL'))
      drop table #HLHT_ZYBCJL_SQTL
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZYBCJL_SQTL_SQZD'))
      drop table #DC_ZYBCJL_SQTL_SQZD

    --创建临时表
    SELECT * INTO  #HLHT_ZYBCJL_SQTL  FROM HLHT_ZYBCJL_SQTL WHERE STATUS = '0'
    --主表操作
    create table #DC_ZYBCJL_SQTL (
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
      tlrq       datetime       not null/* 讨论日期时间 */,
      tldd       varchar(50)    not null/* 讨论地点 */,
      zcrbm      varchar(100)   not null/* 主持人工号 */,
      zcrxm      varchar(500)   not null/* 主持人姓名 */,
      tlrybm     varchar(100)   not null/* 参加讨论人员工号 */,
      cjtlmd     varchar(500)   not null/* 参加讨论人员名单 */,
      zyzwlbdm   varchar(4)     not null/* 专业技术职务类别代码 */,
      zyzwlbmc   varchar(50)    not null/* 专业技术职务类别名称 */,
      ryrq       datetime       not null/* 入院日期时间 */,
      ssczmc     varchar(128)   not null/* 拟实施手术及操作名称 */,
      ssczbm     varchar(64)    not null/* 拟实施手术及操作编码 */,
      ssmbbwdm   varchar(64)    not null/* 拟实施手术目标部位代码 */,
      ssbwmc     varchar(128)   not null/* 拟实施手术目标部位名称 */,
      ssczrq     datetime       not null/* 拟实施手术及操作日期时间 */,
      mzffdm     varchar(64)    not null/* 拟实施麻醉方法代码 */,
      mzffmc     varchar(128)   not null/* 拟实施麻醉方法名称 */,
      ssyd       nvarchar(200)  not null/* 手术要点 */,
      sqzb       nvarchar(1000) not null/* 术前准备 */,
      sszz       nvarchar(500)  not null/* 手术指征 */,
      ssfa       nvarchar(1000) not null/* 手术方案 */,
      zysx       nvarchar(1000) not null/* 注意事项 */,
      tlyj       nvarchar(2000) not null/* 讨论意见 */,
      tljl       nvarchar(2000) not null/* 讨论结论 */,
      sszbm      varchar(20)    null/* 手术者工号 */,
      sszqm      varchar(50)    null/* 手术者签名 */,
      mzysbm     varchar(20)    null/* 麻醉医师工号 */,
      mzsqm      varchar(50)    null/* 麻醉医师签名 */,
      ysbm       varchar(20)    not null/* 签名人工号 */,
      ysqm       varchar(50)    not null/* 签名人姓名 */,
      qmrq       datetime       not null/* 签名日期时间 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_ZYBCJL_SQTL
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
           CONVERT(datetime, tlrq),
           CONVERT(varchar(50), tldd),
           CONVERT(varchar(100), zcrbm),
           CONVERT(varchar(500), zcrxm),
           CONVERT(varchar(100), tlrybm),
           CONVERT(varchar(500), cjtlmd),
           CONVERT(varchar(4), zyzwlbdm),
           CONVERT(varchar(50), zyzwlbmc),
           CONVERT(datetime, ryrq),
           CONVERT(varchar(128), ssczmc),
           CONVERT(varchar(64), ssczbm),
           CONVERT(varchar(64), ssmbbwdm),
           CONVERT(varchar(128), ssbwmc),
           CONVERT(datetime, ssczrq),
           CONVERT(varchar(64), mzffdm),
           CONVERT(varchar(128), mzffmc),
           CONVERT(nvarchar(200), ssyd),
           CONVERT(nvarchar(1000), sqzb),
           CONVERT(nvarchar(500), sszz),
           CONVERT(nvarchar(1000), ssfa),
           CONVERT(nvarchar(1000), zysx),
           CONVERT(nvarchar(2000), tlyj),
           CONVERT(nvarchar(2000), tljl),
           CONVERT(varchar(20), sszbm),
           CONVERT(varchar(50), sszqm),
           CONVERT(varchar(20), mzysbm),
           CONVERT(varchar(50), mzsqm),
           CONVERT(varchar(20), ysbm),
           CONVERT(varchar(50), ysqm),
           CONVERT(datetime, qmrq),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_ZYBCJL_SQTL

    Merge Into DC_ZYBCJL_SQTL _target
    using #DC_ZYBCJL_SQTL _source
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
        _target.tldd     = _source.tldd,
        _target.zcrbm    = _source.zcrbm,
        _target.zcrxm    = _source.zcrxm,
        _target.tlrybm   = _source.tlrybm,
        _target.cjtlmd   = _source.cjtlmd,
        _target.zyzwlbdm = _source.zyzwlbdm,
        _target.zyzwlbmc = _source.zyzwlbmc,
        _target.ryrq     = _source.ryrq,
        _target.ssczmc   = _source.ssczmc,
        _target.ssczbm   = _source.ssczbm,
        _target.ssmbbwdm = _source.ssmbbwdm,
        _target.ssbwmc   = _source.ssbwmc,
        _target.ssczrq   = _source.ssczrq,
        _target.mzffdm   = _source.mzffdm,
        _target.mzffmc   = _source.mzffmc,
        _target.ssyd     = _source.ssyd,
        _target.sqzb     = _source.sqzb,
        _target.sszz     = _source.sszz,
        _target.ssfa     = _source.ssfa,
        _target.zysx     = _source.zysx,
        _target.tlyj     = _source.tlyj,
        _target.tljl     = _source.tljl,
        _target.sszbm    = _source.sszbm,
        _target.sszqm    = _source.sszqm,
        _target.mzysbm   = _source.mzysbm,
        _target.mzsqm    = _source.mzsqm,
        _target.ysbm     = _source.ysbm,
        _target.ysqm     = _source.ysqm,
        _target.qmrq     = _source.qmrq,
        _target.gxrq     = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, zyh, yjlxh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, hzxm, sfzhm, xbdm, xbmc, nls, nly, tlrq, tldd, zcrbm, zcrxm, tlrybm, cjtlmd, zyzwlbdm, zyzwlbmc, ryrq, ssczmc, ssczbm, ssmbbwdm, ssbwmc, ssczrq, mzffdm, mzffmc, ssyd, sqzb, sszz, ssfa, zysx, tlyj, tljl, sszbm, sszqm, mzysbm, mzsqm, ysbm, ysqm, qmrq, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.zyh, _source.yjlxh, _source.ksdm, _source.ksmc,
                              _source.bqdm, _source.bqmc, _source.bfh, _source.bfmc, _source.bch, _source.hzxm,
                                                                                     _source.sfzhm, _source.xbdm,
                                                                                     _source.xbmc, _source.nls,
                                                                                     _source.nly, _source.tlrq,
                                                                                     _source.tldd, _source.zcrbm,
        _source.zcrxm, _source.tlrybm, _source.cjtlmd, _source.zyzwlbdm, _source.zyzwlbmc, _source.ryrq, _source.ssczmc,
        _source.ssczbm, _source.ssmbbwdm, _source.ssbwmc, _source.ssczrq, _source.mzffdm, _source.mzffmc, _source.ssyd,
                                                          _source.sqzb, _source.sszz, _source.ssfa, _source.zysx,
                                                          _source.tlyj, _source.tljl, _source.sszbm, _source.sszqm,
                                                                                      _source.mzysbm, _source.mzsqm,
                                                                                      _source.ysbm, _source.ysqm,
                                                                                      _source.qmrq, _source.isNew,
                                                                                      _source.createtime, _source.gxrq,
              _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_ZYBCJL_SQTL

    create table #DC_ZYBCJL_SQTL_SQZD (
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

    insert into #DC_ZYBCJL_SQTL_SQZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_ZYBCJL_SQTL as a
           CROSS APPLY dbo.fn_com_split_ext(a.sqzdbm, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.sqzdmc, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_ZYBCJL_SQTL_SQZD _target
    using #DC_ZYBCJL_SQTL_SQZD _source
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
    drop table #DC_ZYBCJL_SQTL_SQZD

    UPDATE A SET A.STATUS = '1' FROM HLHT_ZYBCJL_SQTL A,#HLHT_ZYBCJL_SQTL B WHERE A.yjlxh = B.yjlxh;
    drop table #HLHT_ZYBCJL_SQTL

  end