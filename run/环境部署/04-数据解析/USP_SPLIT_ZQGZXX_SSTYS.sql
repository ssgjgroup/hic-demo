USE [HOSPITAL_DW]
GO
/****** Object:  StoredProcedure [dbo].[USP_SPLIT_ZQGZXX_SSTYS]    Script Date: 2018/11/19 9:26:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/**
 * @author chensj
 * @title  知情告知信息－手术同意书
 * @email chensj@winning.com.cn
 * @package  exec USP_SPLIT_ZQGZXX_SSTYS '12345678','  '
 * @date: 2018-11-16 12:41
 */
ALTER procedure [dbo].[USP_SPLIT_ZQGZXX_SSTYS]
    @yljgdm varchar(20), --医疗机构代码
    @regex  varchar(20)  --分割符
as
  begin
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZQGZXX_SSTYS'))
      drop table #DC_ZQGZXX_SSTYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#HLHT_ZQGZXX_SSTYS'))
      drop table #HLHT_ZQGZXX_SSTYS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZQGZXX_SSTYS_NSSSS'))
      drop table #DC_ZQGZXX_SSTYS_NSSSS
    if exists(select 1 from tempdb..sysobjects where id = object_id('tempdb..#DC_ZQGZXX_SSTYS_SQZD'))
      drop table #DC_ZQGZXX_SSTYS_SQZD
    -- 创建临时表
    select * into #HLHT_ZQGZXX_SSTYS from HLHT_ZQGZXX_SSTYS where STATUS = '0';
    -- 主表操作
    create table #DC_ZQGZXX_SSTYS (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      jzlsh      varchar(64)    not null/* 就诊流水号 */,
      patid      varchar(64)    not null/* 患者patid */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      mjzh       varchar(64)    not null/* 门（急）诊号 */,
      zyh        varchar(64)    not null/* 住院号 */,
      jzlb       varchar(2)     not null/* 就诊类别 */,
      zqtysbh    varchar(20)    not null/* 知情同意书编号 */,
      ksdm       varchar(10)    not null/* 科室代码 */,
      ksmc       varchar(50)    not null/* 科室名称 */,
      bqdm       varchar(10)    not null/* 病区代码 */,
      bqmc       varchar(50)    not null/* 病区名称 */,
      bfh        varchar(10)    not null/* 病房号 */,
      bfmc       varchar(50)    not null/* 病房名称 */,
      bch        varchar(10)    not null/* 病床号 */,
      hzxm       varchar(50)    not null/* 患者姓名 */,
      lxdh       varchar(50)    not null/* 联系电话 */,
      sfzhm      varchar(18)    not null/* 身份证号 */,
      xbdm       varchar(2)     not null/* 性别代码 */,
      xbmc       varchar(16)    not null/* 性别名称 */,
      nls        numeric(3)     not null/* 年龄（岁） */,
      nly        varchar(8)     null/* 年龄（月） */,
      ssywfx     nvarchar(200)  not null/* 手术中可能出现的意外及风险 */,
      ssywbfz    nvarchar(1000) not null/* 手术后可能出现的意外及并发症 */,
      tdfa       nvarchar(1000) not null/* 替代方案 */,
      yljgyj     nvarchar(2000) not null/* 医疗机构意见 */,
      hzdlryj    nvarchar(2000) not null/* 患者/法定代理人意见 */,
      hzqm       varchar(50)    not null/* 患者签名 */,
      dlrqm      varchar(50)    not null/* 法定代理人签名 */,
      dlrhzgxdm  varchar(2)     not null/* 法定代理人与患者的关系代码 */,
      dlrhzgxmc  varchar(50)    not null/* 法定代理人与患者的关系名称 */,
      dlrqmrq    datetime       not null/* 患者/法定代理人签名日期时间 */,
      jzysdm     varchar(20)    not null/* 经治医师工号 */,
      jzysqm     varchar(50)    not null/* 经治医师签名 */,
      zrysdm     varchar(50)    not null/* 责任医生工号 */,
      zrysxm     varchar(50)    not null/* 责任医生姓名 */,
      sszdm      varchar(20)    not null/* 手术者工号 */,
      sszqm      varchar(50)    not null/* 手术者签名 */,
      ysqmrq     datetime       not null/* 医师签名日期时间 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )
    insert into #DC_ZQGZXX_SSTYS
    select @yljgdm,
           CONVERT(varchar(64), jzlsh),
           CONVERT(varchar(64), patid),
           CONVERT(varchar(64), yjlxh),
           CONVERT(varchar(64), mjzh),
           CONVERT(varchar(64), zyh),
           CONVERT(varchar(2), jzlb),
           CONVERT(varchar(20), zqtysbh),
           CONVERT(varchar(10), ksdm),
           CONVERT(varchar(50), ksmc),
           CONVERT(varchar(10), bqdm),
           CONVERT(varchar(50), bqmc),
           CONVERT(varchar(10), bfh),
           CONVERT(varchar(50), bfmc),
           CONVERT(varchar(10), bch),
           CONVERT(varchar(50), hzxm),
           CONVERT(varchar(50), lxdh),
           CONVERT(varchar(18), sfzhm),
           CONVERT(varchar(2), xbdm),
           CONVERT(varchar(16), xbmc),
           CONVERT(numeric(3), nls),
           CONVERT(varchar(8), nly),
           CONVERT(nvarchar(200), ssywfx),
           CONVERT(nvarchar(1000), ssywbfz),
           CONVERT(nvarchar(1000), tdfa),
           CONVERT(nvarchar(2000), yljgyj),
           CONVERT(nvarchar(2000), hzdlryj),
           CONVERT(varchar(50), hzqm),
           CONVERT(varchar(50), dlrqm),
           CONVERT(varchar(2), dlrhzgxdm),
           CONVERT(varchar(50), dlrhzgxmc),
           CONVERT(datetime, dlrqmrq),
           CONVERT(varchar(20), jzysdm),
           CONVERT(varchar(50), jzysqm),
           CONVERT(varchar(50), zrysdm),
           CONVERT(varchar(50), zrysxm),
           CONVERT(varchar(20), sszdm),
           CONVERT(varchar(50), sszqm),
           CONVERT(datetime, ysqmrq),
           1,
           getdate(),
           getdate(),
           'EMR',
           0,
           '0'
    from #HLHT_ZQGZXX_SSTYS
    Merge Into DC_ZQGZXX_SSTYS _target
    using #DC_ZQGZXX_SSTYS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm    = _source.yljgdm,
        _target.jzlsh     = _source.jzlsh,
        _target.patid     = _source.patid,
        _target.yjlxh     = _source.yjlxh,
        _target.mjzh      = _source.mjzh,
        _target.zyh       = _source.zyh,
        _target.jzlb      = _source.jzlb,
        _target.zqtysbh   = _source.zqtysbh,
        _target.ksdm      = _source.ksdm,
        _target.ksmc      = _source.ksmc,
        _target.bqdm      = _source.bqdm,
        _target.bqmc      = _source.bqmc,
        _target.bfh       = _source.bfh,
        _target.bfmc      = _source.bfmc,
        _target.bch       = _source.bch,
        _target.hzxm      = _source.hzxm,
        _target.lxdh      = _source.lxdh,
        _target.sfzhm     = _source.sfzhm,
        _target.xbdm      = _source.xbdm,
        _target.xbmc      = _source.xbmc,
        _target.nls       = _source.nls,
        _target.nly       = _source.nly,
        _target.ssywfx    = _source.ssywfx,
        _target.ssywbfz   = _source.ssywbfz,
        _target.tdfa      = _source.tdfa,
        _target.yljgyj    = _source.yljgyj,
        _target.hzdlryj   = _source.hzdlryj,
        _target.hzqm      = _source.hzqm,
        _target.dlrqm     = _source.dlrqm,
        _target.dlrhzgxdm = _source.dlrhzgxdm,
        _target.dlrhzgxmc = _source.dlrhzgxmc,
        _target.dlrqmrq   = _source.dlrqmrq,
        _target.jzysdm    = _source.jzysdm,
        _target.jzysqm    = _source.jzysqm,
        _target.zrysdm    = _source.zrysdm,
        _target.zrysxm    = _source.zrysxm,
        _target.sszdm     = _source.sszdm,
        _target.sszqm     = _source.sszqm,
        _target.ysqmrq    = _source.ysqmrq,
        _target.gxrq      = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, jzlsh, patid, yjlxh, mjzh, zyh, jzlb, zqtysbh, ksdm, ksmc, bqdm, bqmc, bfh, bfmc, bch, hzxm, lxdh, sfzhm, xbdm, xbmc, nls, nly, ssywfx, ssywbfz, tdfa, yljgyj, hzdlryj, hzqm, dlrqm, dlrhzgxdm, dlrhzgxmc, dlrqmrq, jzysdm, jzysqm, zrysdm, zrysxm, sszdm, sszqm, ysqmrq, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.jzlsh, _source.patid, _source.yjlxh, _source.mjzh, _source.zyh, _source.jzlb,
                              _source.zqtysbh, _source.ksdm, _source.ksmc, _source.bqdm, _source.bqmc, _source.bfh,
                                                                                         _source.bfmc, _source.bch,
                                                                                         _source.hzxm, _source.lxdh,
                                                                                         _source.sfzhm, _source.xbdm,
                                                                                         _source.xbmc, _source.nls,
        _source.nly, _source.ssywfx, _source.ssywbfz, _source.tdfa, _source.yljgyj, _source.hzdlryj, _source.hzqm,
        _source.dlrqm, _source.dlrhzgxdm, _source.dlrhzgxmc, _source.dlrqmrq, _source.jzysdm, _source.jzysqm,
                                                             _source.zrysdm, _source.zrysxm, _source.sszdm,
                                                             _source.sszqm, _source.ysqmrq, _source.isNew,
                                                             _source.createtime, _source.gxrq, _source.sys_id,
              _source.lsnid, _source.isdelete);
    drop table #DC_ZQGZXX_SSTYS
    --知情告知信息－手术同意书_拟实施手术
    create table #DC_ZQGZXX_SSTYS_NSSSS (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)    not null/* 医疗机构代码  */,
      yjlxh      varchar(64)    not null/* 源记录序号 */,
      zyjlxh     varchar(64)    null/* 主表原纪录序号 */,
      nssbm      varchar(64)    not null/* 拟实施手术及操作编码 */,
      nssczmc    varchar(128)   not null/* 拟实施手术及操作名称 */,
      nssrq      datetime       not null/* 拟实施手术及操作日期时间 */,
      sszz       nvarchar(500)  not null/* 手术指征 */,
      ssjjz      nvarchar(100)  not null/* 手术禁忌症 */,
      ssfs       varchar(30)    not null/* 手术方式 */,
      nmzdm      varchar(2)     not null/* 拟实施麻醉方法代码 */,
      nmzffmc    varchar(30)    not null/* 拟实施麻醉方法名称 */,
      sqzb       nvarchar(1000) not null/* 术前准备 */,
      isNew      bit            NULL,
      createtime datetime       NULL,
      gxrq       datetime       NOT NULL,
      sys_id     varchar(50)    NOT NULL,
      lsnid      bigint         NULL,
      isdelete   varchar(8)     NULL
    )

    insert into #DC_ZQGZXX_SSTYS_NSSSS
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value, convert(datetime,_2.value),_3.value,_4.value,
           _5.value,_6.value,_7.value,_8.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_ZQGZXX_SSTYS as a
           CROSS APPLY dbo.fn_com_split_ext(a.nssbm, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.nssczmc, @regex) _1
           CROSS APPLY dbo.fn_com_split_ext(convert(varchar(100),a.nssrq,120), @regex) _2
           CROSS APPLY dbo.fn_com_split_ext(a.sszz, @regex) _3
           CROSS APPLY dbo.fn_com_split_ext(a.ssjjz, @regex) _4
           CROSS APPLY dbo.fn_com_split_ext(a.ssfs, @regex) _5
           CROSS APPLY dbo.fn_com_split_ext(a.nmzdm, @regex) _6
           CROSS APPLY dbo.fn_com_split_ext(a.nmzffmc, @regex) _7
           CROSS APPLY dbo.fn_com_split_ext(a.sqzb, @regex) _8
    where 1 = 1 and _0.id = _1.id and _0.id = _2.id and _0.id = _3.id and _0.id = _4.id and _0.id = _5.id
      and _0.id = _6.id and _0.id = _7.id and _0.id = _8.id

    Merge Into DC_ZQGZXX_SSTYS_NSSSS _target
    using #DC_ZQGZXX_SSTYS_NSSSS _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm  = _source.yljgdm,
        _target.yjlxh   = _source.yjlxh,
        _target.zyjlxh  = _source.zyjlxh,
        _target.nssbm   = _source.nssbm,
        _target.nssczmc = _source.nssczmc,
        _target.nssrq   = _source.nssrq,
        _target.sszz    = _source.sszz,
        _target.ssjjz   = _source.ssjjz,
        _target.ssfs    = _source.ssfs,
        _target.nmzdm   = _source.nmzdm,
        _target.nmzffmc = _source.nmzffmc,
        _target.sqzb    = _source.sqzb,
        _target.gxrq    = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, nssbm, nssczmc, nssrq, sszz, ssjjz, ssfs, nmzdm, nmzffmc, sqzb, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values
      (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.nssbm, _source.nssczmc, _source.nssrq, _source.sszz,
                       _source.ssjjz, _source.ssfs, _source.nmzdm, _source.nmzffmc, _source.sqzb, _source.isNew,
       _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_ZQGZXX_SSTYS_NSSSS
    --知情告知信息－手术同意书_术前诊断
    create table #DC_ZQGZXX_SSTYS_SQZD (
      xh         numeric(12) identity (1, 1)/* 序号  */,
      yljgdm     varchar(20)  not null/* 医疗机构代码  */,
      yjlxh      varchar(64)  not null/* 源记录序号 */,
      zyjlxh     varchar(64)  null/* 主表原纪录序号 */,
      sqzd       varchar(64)  not null/* 术前诊断编码 */,
      sqzdmc     varchar(128) not null/* 术前诊断名称 */,
      isNew      bit          NULL,
      createtime datetime     NULL,
      gxrq       datetime     NOT NULL,
      sys_id     varchar(50)  NOT NULL,
      lsnid      bigint       NULL,
      isdelete   varchar(8)   NULL
    )

    insert into #DC_ZQGZXX_SSTYS_SQZD
    select
           @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,_0.value,_1.value,1,getdate(),getdate(),'EMR',0,'0'
    from
         #HLHT_ZQGZXX_SSTYS as a
           CROSS APPLY dbo.fn_com_split_ext(a.sqzd, @regex) _0
           CROSS APPLY dbo.fn_com_split_ext(a.sqzdmc, @regex) _1
    where 1 = 1 and _0.id = _1.id

    Merge Into DC_ZQGZXX_SSTYS_SQZD _target
    using #DC_ZQGZXX_SSTYS_SQZD _source
    on (_target.yjlxh = _source.yjlxh)
    When Matched Then
      Update set
        _target.yljgdm = _source.yljgdm,
        _target.yjlxh  = _source.yjlxh,
        _target.zyjlxh = _source.zyjlxh,
        _target.sqzd   = _source.sqzd,
        _target.sqzdmc = _source.sqzdmc,
        _target.gxrq   = getdate()
    When Not Matched By Target Then
      Insert (yljgdm, yjlxh, zyjlxh, sqzd, sqzdmc, isNew, createtime, gxrq, sys_id, lsnid, isdelete)
      values (_source.yljgdm, _source.yjlxh, _source.zyjlxh, _source.sqzd, _source.sqzdmc, _source.isNew,
        _source.createtime, _source.gxrq, _source.sys_id, _source.lsnid, _source.isdelete);
    drop table #DC_ZQGZXX_SSTYS_SQZD

    UPDATE A SET A.STATUS='1'  FROM HLHT_ZQGZXX_SSTYS A,#HLHT_ZQGZXX_SSTYS B WHERE A.yjlxh = B.yjlxh;
    drop table #HLHT_ZQGZXX_SSTYS
  end