USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_ZQGZXX_TSJCZLTYS]    Script Date: 2018/11/19 9:26:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title  知情告知信息－特殊检查及特殊治疗同意书
 * @email chensj@winning.com.cn
 * @package  exec USP_SPLIT_ZQGZXX_TSJCZLTYS '12345678','  '
 * @date: 2018-11-16 12:41
 */
ALTER procedure [dbo].[USP_SPLIT_ZQGZXX_TSJCZLTYS]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZQGZXX_TSJCZLTYS'))
      drop table #DC_ZQGZXX_TSJCZLTYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZQGZXX_TSJCZLTYS'))
      drop table #HLHT_ZQGZXX_TSJCZLTYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZQGZXX_TSJCZLTYS_JBZD'))
      drop table #DC_ZQGZXX_TSJCZLTYS_JBZD

    -- 创建临时表
    select * into #HLHT_ZQGZXX_TSJCZLTYS from HLHT_ZQGZXX_TSJCZLTYS where STATUS = '0';
    -- 主表操作
    create table #DC_ZQGZXX_TSJCZLTYS(
      xh                   numeric(12)         identity(1,1)/* 序号  */,
      yljgdm               varchar(20)         not null/* 医疗机构代码  */,
      jzlsh                varchar(64)         not null/* 就诊流水号 */,
      patid                varchar(64)         not null/* 患者patid */,
      mjzh                 varchar(10)         not null/* 门（急）诊号 */,
      zyh                  varchar(64)         not null/* 住院号 */,
      jzlb                 varchar(2)          not null/* 就诊类别 */,
      yjlxh                varchar(64)         not null/* 源记录序号 */,
      tysbh                varchar(20)         not null/* 知情同意书编号 */,
      ksdm                 varchar(10)         not null/* 科室代码 */,
      ksmc                 varchar(50)         not null/* 科室名称 */,
      bqdm                 varchar(10)         not null/* 病区代码 */,
      bqmc                 varchar(50)         not null/* 病区名称 */,
      bfh                  varchar(10)         not null/* 病房号 */,
      bch                  varchar(10)         not null/* 病床号 */,
      hzxm                 varchar(50)         not null/* 患者姓名 */,
      sfzhm                varchar(18)         not null/* 身份证号码 */,
      xbdm                 varchar(2)          not null/* 性别代码 */,
      xbmc                 varchar(16)         not null/* 性别名称 */,
      nls                  numeric(3)          not null/* 年龄（岁） */,
      nly                  varchar(8)          null/* 年龄（月） */,
      jczlxmmc             varchar(100)        not null/* 特殊检查及特殊治疗项目名称 */,
      jczlmd               nvarchar(100)       not null/* 特殊检查及特殊治疗目的 */,
      jczlbfz              nvarchar(1000)      null/* 特殊检查及特殊治疗可能引起的并发症及风险 */,
      tdfa                 nvarchar(1000)      null/* 替代方案 */,
      hzdlrqm              varchar(50)         not null/* 患者/法定代理人签名 */,
      hzdlrgxdm            varchar(2)          not null/* 法定代理人与患者的关系代码 */,
      hzdlrgxmc            varchar(128)        not null/* 法定代理人与患者的关系名称 */,
      dlrqmrq              datetime            not null/* 患者/法定代理人签名日期时间 */,
      ysbm                 varchar(20)         not null/* 医生工号 */,
      ysqm                 varchar(50)         not null/* 医师签名 */,
      ysqmrq               datetime            not null/* 医师签名日期时间 */,
      isNew                bit                  NULL,
      createtime           datetime             NULL,
      gxrq                 datetime             NOT NULL,
      sys_id               varchar(50)          NOT NULL,
      lsnid                bigint               NULL,
      isdelete             varchar(8)           NULL
    )
    insert into #DC_ZQGZXX_TSJCZLTYS
    select @yljgdm,
           CONVERT(varchar(64), 	jzlsh),
           CONVERT(varchar(64), 	patid),
           CONVERT(varchar(10), 	mjzh),
           CONVERT(varchar(64), 	zyh),
           CONVERT(varchar(2), 	jzlb),
           CONVERT(varchar(64), 	yjlxh),
           CONVERT(varchar(20), 	tysbh),
           CONVERT(varchar(10), 	ksdm),
           CONVERT(varchar(50), 	ksmc),
           CONVERT(varchar(10), 	bqdm),
           CONVERT(varchar(50), 	bqmc),
           CONVERT(varchar(10), 	bfh),
           CONVERT(varchar(10), 	bch),
           CONVERT(varchar(50), 	hzxm),
           CONVERT(varchar(18), 	sfzhm),
           CONVERT(varchar(2), 	xbdm),
           CONVERT(varchar(16), 	xbmc),
           CONVERT(numeric(3), 	nls),
           CONVERT(varchar(8), 	nly),
           CONVERT(varchar(100), 	jczlxmmc),
           CONVERT(nvarchar(100), 	jczlmd),
           CONVERT(nvarchar(1000), 	jczlbfz),
           CONVERT(nvarchar(1000), 	tdfa),
           CONVERT(varchar(50), 	hzdlrqm),
           CONVERT(varchar(2), 	hzdlrgxdm),
           CONVERT(varchar(128), 	hzdlrgxmc),
           CONVERT(datetime, 	dlrqmrq),
           CONVERT(varchar(20), 	ysbm),
           CONVERT(varchar(50), 	ysqm),
           CONVERT(datetime, 	ysqmrq),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_ZQGZXX_TSJCZLTYS
    Merge Into DC_ZQGZXX_TSJCZLTYS _target
    using #DC_ZQGZXX_TSJCZLTYS _source
    on(_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm=_source.yljgdm,
        _target.jzlsh=_source.jzlsh,
        _target.patid=_source.patid,
        _target.mjzh=_source.mjzh,
        _target.zyh=_source.zyh,
        _target.jzlb=_source.jzlb,
        _target.yjlxh=_source.yjlxh,
        _target.tysbh=_source.tysbh,
        _target.ksdm=_source.ksdm,
        _target.ksmc=_source.ksmc,
        _target.bqdm=_source.bqdm,
        _target.bqmc=_source.bqmc,
        _target.bfh=_source.bfh,
        _target.bch=_source.bch,
        _target.hzxm=_source.hzxm,
        _target.sfzhm=_source.sfzhm,
        _target.xbdm=_source.xbdm,
        _target.xbmc=_source.xbmc,
        _target.nls=_source.nls,
        _target.nly=_source.nly,
        _target.jczlxmmc=_source.jczlxmmc,
        _target.jczlmd=_source.jczlmd,
        _target.jczlbfz=_source.jczlbfz,
        _target.tdfa=_source.tdfa,
        _target.hzdlrqm=_source.hzdlrqm,
        _target.hzdlrgxdm=_source.hzdlrgxdm,
        _target.hzdlrgxmc=_source.hzdlrgxmc,
        _target.dlrqmrq=_source.dlrqmrq,
        _target.ysbm=_source.ysbm,
        _target.ysqm=_source.ysqm,
        _target.ysqmrq=_source.ysqmrq,
        _target.gxrq=getdate()
    When Not Matched By Target Then
      Insert (yljgdm,jzlsh,patid,mjzh,zyh,jzlb,yjlxh,tysbh,ksdm,ksmc,bqdm,bqmc,bfh,bch,hzxm,sfzhm,xbdm,xbmc,nls,nly,jczlxmmc,jczlmd,jczlbfz,tdfa,hzdlrqm,hzdlrgxdm,hzdlrgxmc,dlrqmrq,ysbm,ysqm,ysqmrq,isNew,createtime,gxrq,sys_id,lsnid,isdelete)
      values (_source.yljgdm,_source.jzlsh,_source.patid,_source.mjzh,_source.zyh,_source.jzlb,_source.yjlxh,_source.tysbh,_source.ksdm,_source.ksmc,_source.bqdm,_source.bqmc,_source.bfh,_source.bch,_source.hzxm,_source.sfzhm,_source.xbdm,_source.xbmc,_source.nls,_source.nly,_source.jczlxmmc,_source.jczlmd,_source.jczlbfz,_source.tdfa,_source.hzdlrqm,_source.hzdlrgxdm,_source.hzdlrgxmc,_source.dlrqmrq,_source.ysbm,_source.ysqm,_source.ysqmrq,_source.isNew,_source.createtime,_source.gxrq,_source.sys_id,_source.lsnid,_source.isdelete);
    drop table #DC_ZQGZXX_TSJCZLTYS

    create table #DC_ZQGZXX_TSJCZLTYS_JBZD(
      xh                   numeric(12)          identity(1,1)/* 序号  */,
      yljgdm               varchar(20)          not null/* 医疗机构代码  */,
      yjlxh                varchar(64)          not null/* 源记录序号 */,
      zyjlxh               varchar(64)          null/* 主表原纪录序号 */,
      jbzdbm               varchar(64)          not null/* 疾病诊断编码 */,
      jbzd                 varchar(128)         not null/* 疾病诊断名称 */,
      isNew               bit                  NULL,
      createtime          datetime             NULL,
      gxrq                datetime             NOT NULL,
      sys_id              varchar(50)          NOT NULL,
      lsnid               bigint               NULL,
      isdelete            varchar(8)           NULL
    )

    insert into #DC_ZQGZXX_TSJCZLTYS_JBZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_ZQGZXX_TSJCZLTYS as a
           CROSS APPLY dbo.fn_com_split_ext(a.jbzdbm, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.jbzd, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_ZQGZXX_TSJCZLTYS_JBZD _target
    using #DC_ZQGZXX_TSJCZLTYS_JBZD _source
    on(_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm=_source.yljgdm,
        _target.yjlxh=_source.yjlxh,
        _target.zyjlxh=_source.zyjlxh,
        _target.jbzdbm=_source.jbzdbm,
        _target.jbzd=_source.jbzd,
        _target.gxrq=getdate()
    When Not Matched By Target Then
      Insert (yljgdm,yjlxh,zyjlxh,jbzdbm,jbzd,isNew,createtime,gxrq,sys_id,lsnid,isdelete)
      values (_source.yljgdm,_source.yjlxh,_source.zyjlxh,_source.jbzdbm,_source.jbzd,_source.isNew,_source.createtime,_source.gxrq,_source.sys_id,_source.lsnid,_source.isdelete);
    drop table #DC_ZQGZXX_TSJCZLTYS_JBZD

    UPDATE A SET A.STATUS = '1' FROM HLHT_ZQGZXX_TSJCZLTYS A,#HLHT_ZQGZXX_TSJCZLTYS B WHERE A.yjlxh = B.yjlxh;
    drop table #HLHT_ZQGZXX_TSJCZLTYS
  end