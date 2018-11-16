 /*========================================================================*/
 /* DC_BLGY_HZJBXX     ������Ҫ�����߻�����Ϣ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_HZJBXX') )
 create table  DC_BLGY_HZJBXX (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    jkdabh               varchar(17)          not null/* ������񽡿�������� */,
    sfzhm                varchar(18)          not null/* �������֤������ */,
    sfzjlb               varchar(2)           not null/* �������֤�������� */,
    sfzjlbmc             varchar(64)          not null/* �������֤��������� */,
    jkkh                 varchar(18)          not null/* �������� */,
    yblbdm               varchar(2)           not null/* ҽ�Ʊ��������� */,
    yblbmc               varchar(50)          not null/* ҽ�Ʊ���������� */,
    hzxm                 varchar(50)          not null/* �������� */,
    csrq                 date                 not null/* �������� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    hyzkdm               varchar(2)           not null/* ����״������ */,
    hyzkmc               varchar(32)          not null/* ����״������ */,
    mz                   varchar(2)           not null/* ������� */,
    mzmc                 varchar(32)          not null/* ���� */,
    zylb                 varchar(2)           null/* ְҵ������ */,
    zymc                 varchar(32)          null/* ְҵ������� */,
    gzdw                 varchar(70)          not null/* ������λ���� */,
    gzdwhm               varchar(20)          not null/* ������λ�绰���� */,
    dzlbdm               varchar(2)           not null/* ��ַ������ */,
    dzlbmc               varchar(32)          not null/* ��ַ������� */,
    dzsf                 varchar(70)          not null/* ��ַ-ʡ����������ֱϽ�У� */,
    dzsq                 varchar(70)          not null/* ��ַ-�У��������ݣ� */,
    dzx                  varchar(70)          not null/* ��ַ-�أ����� */,
    dzxz                 varchar(70)          not null/* ��ַ-�磨�򡢽ֵ����´��� */,
    dzc                  varchar(70)          not null/* ��ַ-�壨�֡�·��Ū�ȣ� */,
    dzmphm               varchar(70)          not null/* ��ַ-���ƺ��� */,
    yzbm                 varchar(6)           null/* �������� */,
    hzdhhm               varchar(20)          null/* ���ߵ绰���� */,
    lxrxm                varchar(50)          null/* ��ϵ������ */,
    lxrhm                varchar(20)          null/* ��ϵ�˵绰���� */,
    jdrqsj               datetime             not null/* ��������ʱ�� */,
    jdzzjgdm             varchar(10)          not null/* ����ҽ�ƻ�����֯�������� */,
    jdzzjgmc             varchar(70)          not null/* ����ҽ�ƻ�����֯�������� */,
    jdzbm                varchar(20)          not null/* �����߹��� */,
    jdzxm                varchar(32)          not null/* ���������� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('dbo.DC_BLGY_HZJBXX') and minor_id = 0)
begin 
   execute sp_dropextendedproperty 'MS_Description',  
   'user', 'dbo', 'table', 'DC_BLGY_HZJBXX' 
 
end 


execute sp_addextendedproperty 'MS_Description',  
   '������Ҫ�����߻�����Ϣ ', 
   'user', 'dbo', 'table', 'DC_BLGY_HZJBXX'
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX     ������Ҫ �� ����������Ϣ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX') )
 create table  DC_BLGY_JBJKXX (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    hzxm                 varchar(64)          not null/* �������� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    sfzhm                varchar(18)          not null/* �������֤������ */,
    jkkh                 varchar(18)          not null/* ���񽡿����� */,
    aboxxdm              varchar(4)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          not null/* ABOѪ������ */,
    rhxxdm               varchar(4)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          not null/* RhѪ������ */,
    sxs                  nvarchar(1000)       not null/* ��Ѫʷ */,
    grs                  nvarchar(1000)       not null/* ����ʷ */,
    yjs                  nvarchar(1000)       not null/* �¾�ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_CRBS     ������Ҫ �� ����������Ϣ_��Ⱦ��ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_CRBS') )
 create table  DC_BLGY_JBJKXX_CRBS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    crbs                  nvarchar(1000)       not null/* ��Ⱦ��ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_GMS     ������Ҫ �� ����������Ϣ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_GMS') )
 create table  DC_BLGY_JBJKXX_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  nvarchar(1000)       not null/* ����ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_JBS     ������Ҫ �� ����������Ϣ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_JBS') )
 create table  DC_BLGY_JBJKXX_JBS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbs                  nvarchar(1000)       not null/* ����ʷ�������ˣ� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_JZ_JZS     ������Ҫ �� ����������Ϣ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_JZ_JZS') )
 create table  DC_BLGY_JBJKXX_JZ_JZS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jzs                  nvarchar(1000)       not null/* ����ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_SSS     ������Ҫ �� ����������Ϣ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_SSS') )
 create table  DC_BLGY_JBJKXX_SSS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sss                  nvarchar(1000)       not null/* ����ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_SYS     ������Ҫ �� ����������Ϣ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_SYS') )
 create table  DC_BLGY_JBJKXX_HYS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hys                  nvarchar(1000)       not null/* ����ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_JBJKXX_YFJZS     ������Ҫ �� ����������Ϣ_Ԥ������ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_JBJKXX_YFJZS') )
 create table  DC_BLGY_JBJKXX_YFJZS (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yfjzs                nvarchar(1000)       not null/* Ԥ������ʷ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_WSSJZY     ������Ҫ �� �����¼�ժҪ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_WSSJZY') )
 create table  DC_BLGY_WSSJZY (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤������ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    jmjkkh               varchar(18)          not null/* ���񽡿����� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ҽ�ƻ������Ҵ��� */,
    ksmc                 varchar(50)          not null/* ҽ�ƻ����������� */,
    hzlxdm               varchar(2)           not null/* �������ʹ��� */,
    hzlxmc               varchar(50)          not null/* ������������ */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzrqsj               datetime             not null/* ��������ʱ�� */,
    ryrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    cyrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    fbrqsj               datetime             not null/* ��������ʱ�� */,
    jzyy                 nvarchar(1000)       not null/* ����ԭ�� */,
    qtxyzd               varchar(64)          null/* ������ҽ��ϱ��� */,
    qtxyzdmc             varchar(128)         null/* ������ҽ������� */,
    qtyxcz               nvarchar(2000)       not null/* ����ҽѧ���� */,
    gbsy                 varchar(32)          null/* ����������� */,
    gbsymc               varchar(500)         null/* ������������ */,
    zljg                 varchar(2)           null/* ���ƽ������ */,
    zljgmc               varchar(20)          null/* ���ƽ������ */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrys                 varchar(50)          not null/* ����ҽʦ���� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_WSSJZY_GYJW     ������Ҫ �� �����¼�ժҪ_�ؼ�ҩ��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_WSSJZY_GYJW') )
 create table  DC_BLGY_WSSJZY_GYJW (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gjywdm               varchar(100)         not null/* �ؼ�ҩ����� */,
    gjywmc               varchar(500)         not null/* �ؼ�ҩ������ */,
    gjywyf               nvarchar(100)        not null/* �ؼ�ҩ���÷� */,
    ywblfy               nvarchar(100)        not null/* ҩ�ﲻ����Ӧ��� */,
    zysylb               varchar(2)           not null/* ��ҩʹ�������� */,
    zysylbmc             varchar(18)          not null/* ��ҩʹ��������� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_WSSJZY_SSCZ     ������Ҫ �� �����¼�ժҪ_��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_WSSJZY_SSCZ') )
 create table  DC_BLGY_WSSJZY_SSCZ (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ssjcz                varchar(64)          null/* �������������� */,
    ssjczmc              varchar(128)         null/* �������������� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_WSSJZY_XYZD     ������Ҫ �� �����¼�ժҪ_��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_WSSJZY_XYZD') )
 create table  DC_BLGY_WSSJZY_XYZD (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    xyzd                 varchar(64)          not null/* ��ҽ��ϱ��� */,
    xyzdmc               varchar(128)         not null/* ��ҽ������� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_WSSJZY_ZYZD     ������Ҫ �� �����¼�ժҪ_��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_WSSJZY_ZYZD') )
 create table  DC_BLGY_WSSJZY_ZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zybm                 varchar(64)          null/* ��ҽ�������� */,
    zybmmc               varchar(128)         null/* ��ҽ�������� */,
    zyzh                 varchar(64)          null/* ��ҽ֤����� */,
    zyzhmc               varchar(128)         null/* ��ҽ֤������ */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_BLGY_YLFYJL     ������Ҫ �� ҽ�Ʒ��ü�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_BLGY_YLFYJL') )
 create table  DC_BLGY_YLFYJL (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    jkkh                 varchar(18)          not null/* �������� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤������ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    ffdm                 varchar(2)           not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    fffs                 varchar(64)          not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    mzfyje               numeric(8,2)         not null/* ������ý�� */,
    zyfyje               numeric(10,2)        not null/* סԺ���ý�� */,
    grcdfy               numeric(10,2)        not null/* ���˳е����ý�� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('dbo.DC_BLGY_YLFYJL') and minor_id = 0)
begin 
   execute sp_dropextendedproperty 'MS_Description',  
   'user', 'dbo', 'table', 'DC_BLGY_YLFYJL' 
 
end 


execute sp_addextendedproperty 'MS_Description',  
   '������Ҫ �� ҽ�Ʒ��ü�¼ ', 
   'user', 'dbo', 'table', 'DC_BLGY_YLFYJL'
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ     ��ԺС�ᣭ��ԺС��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ') )
 create table  DC_CYXJ_CYXJ (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    jkkh                 varchar(18)          not null/* ���񽡿����� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    hyzkdm               varchar(2)           not null/* ����״������ */,
    hyzkmc               varchar(32)          not null/* ����״������ */,
    zylbdm               varchar(2)           not null/* ְҵ������ */,
    zylbmc               varchar(32)          not null/* ְҵ������� */,
    hzdhhm               varchar(20)          not null/* ���ߵ绰���� */,
    zzlbdm               varchar(2)           not null/* ��ַ������ */,
    zzlbmc               varchar(20)          not null/* ��ַ������� */,
    dzsf                 varchar(70)          not null/* ��ַ-ʡ����������ֱϽ�У� */,
    dzsq                 varchar(70)          not null/* ��ַ-�У��������ݣ� */,
    dzx                  varchar(70)          not null/* ��ַ-�أ����� */,
    dzxz                 varchar(70)          not null/* ��ַ-�磨�򡢽ֵ����´��� */,
    dzc                  varchar(70)          not null/* ��ַ-�壨�֡�·��Ū�ȣ� */,
    dzmphm               varchar(70)          not null/* ��ַ-���ƺ��� */,
    yzbm                 varchar(6)           not null/* �������� */,
    lxrxm                varchar(50)          not null/* ��ϵ������ */,
    lxrdhhm              varchar(20)          not null/* ��ϵ�˵绰���� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    cyrq                 datetime             not null/* ��Ժ����ʱ�� */,
    sjzyts               int                  not null/* ʵ��סԺ���� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    ssqklbdm             char(1)              not null/* �����п������� */,
    ssqklbmc             varchar(20)          not null/* �����п�������� */,
    qkyhdjdm             char(1)              not null/* �п����ϵȼ����� */,
    qkyhdjmc             varchar(20)          not null/* �п����ϵȼ����� */,
    ssczbm               varchar(64)          not null/* �������������� */,
    ssjczmc              varchar(128)         not null/* �������������� */,
    ssczksrq             datetime             not null/* ������������ʼ����ʱ�� */,
    mzffdm               varchar(2)           not null/* ���������� */,
    mzffmc               varchar(30)          not null/* ���������� */,
    ssgc                 nvarchar(200)        not null/* �������� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    cyqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    cyzztz               nvarchar(1000)       not null/* ��Ժʱ֢״������ */,
    cyyz                 nvarchar(1000)       not null/* ��Ժҽ�� */,
    zljgdm               char(1)              not null/* ���ƽ������ */,
    zljgmc               varchar(20)          not null/* ���ƽ������ */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    sjysbm               varchar(20)          not null/* �ϼ�ҽʦ���� */,
    sjysqm               varchar(50)          not null/* �ϼ�ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_CYXYZD     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_CYXYZD') )
 create table  DC_CYXJ_CYXJ_CYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    czxyzd               varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_CYZYBH     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ֤��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_CYZYBH') )
 create table  DC_CYXJ_CYXJ_CYZYBH (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    czzyzh               varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_CYZYBM     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_CYZYBM') )
 create table  DC_CYXJ_CYXJ_CYZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    czzybm               varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_RYXYZD     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_RYXYZD') )
 create table  DC_CYXJ_CYXJ_RYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    rzxyzd               varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_RYZYBM     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_RYZYBM') )
 create table  DC_CYXJ_CYXJ_RYZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    rzzybm               varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_RYZYZH     ��ԺС�ᣭ��ԺС��_��Ժ��ҽ֤��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_RYZYZH') )
 create table  DC_CYXJ_CYXJ_RYZYZH (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    rzzyzh               varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_CYXJ_CYXJ_YXFZJCJG     ��ԺС�ᣭ��ԺС��_���Ը��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_CYXJ_CYXJ_YXFZJCJG') )
 create table  DC_CYXJ_CYXJ_YXFZJCJG (    
    xh                   numeric(12)          identity(1, 1)/* ��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yxfzjcjg             nvarchar(1000)       null/* ���Ը�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_BZBWHL     ���������¼ �� ���أ���Σ�����߻����¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_BZBWHL') )
 create table  DC_HLCZJL_BZBWHL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    hldjdm               varchar(2)           not null/* ����ȼ����� */,
    hldjmc               varchar(64)          not null/* ����ȼ����� */,
    hllxdm               varchar(2)           not null/* �������ʹ��� */,
    hllxmc               varchar(64)          not null/* ������������ */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    xl                   numeric(3)           not null/* ���ʣ���/min�� */,
    hxpl                 numeric(3)           not null/* ����Ƶ�ʣ���/min�� */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    xt                   numeric(4,1)         not null/* Ѫ�Ǽ��ֵ��mmol/L�� */,
    ysqkdm               varchar(2)           not null/* ��ʳ������� */,
    ysqkmc               varchar(100)         not null/* ��ʳ������� */,
    hxjjhxm              varchar(20)          not null/* �������໤��Ŀ */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_BZBWHL_GMS     ���������¼ �� ���أ���Σ�����߻����¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_BZBWHL_GMS') )
 create table  DC_HLCZJL_BZBWHL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  varchar(1000)        null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_BZBWHL_HLCZ     ���������¼ �� ���أ���Σ�����߻����¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_BZBWHL_HLCZ') )
 create table  DC_HLCZJL_BZBWHL_HLCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlczmc               varchar(100)         not null/* ����������� */,
    hlczxmlmmc           varchar(100)         not null/* ���������Ŀ��Ŀ���� */,
    hlczjg               varchar(1000)        not null/* ���������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_BZBWHL_HLGC     ���������¼ �� ���أ���Σ�����߻����¼_����۲�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_BZBWHL_HLGC') )
 create table  DC_HLCZJL_BZBWHL_HLGC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlgcxmmc             varchar(30)          not null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        not null/* ����۲��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_BZBWHL_ZDXX     ���������¼ �� ���أ���Σ�����߻����¼_���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_BZBWHL_ZDXX') )
 create table  DC_HLCZJL_BZBWHL_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zdbm                 varchar(64)          not null/* ������ϱ��� */,
    zdmc                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_CRL     ���������¼ �� ��������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_CRL') )
 create table  DC_HLCZJL_CRL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    birth                date                 not null/* ���߳������� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    hldjdm               varchar(2)           not null/* ����ȼ����� */,
    hldjmc               varchar(64)          not null/* ����ȼ����� */,
    hllxdm               varchar(2)           not null/* �������ʹ��� */,
    hllxmc               varchar(64)          not null/* ������������ */,
    jlrqsj               datetime             not null/* ��¼����ʱ�� */,
    otbz                 char(1)              not null/* Ż�±�־ */,
    pnknbz               char(1)              not null/* �������ѱ�־ */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_CRL_HLCZ     ���������¼ �� ��������¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_CRL_HLCZ') )
 create table  DC_HLCZJL_CRL_HLCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlczxmlmmc           varchar(100)         not null/* ���������Ŀ��Ŀ���� */,
    hlczdm               varchar(10)          not null/* ����������� */,
    hlczmc               varchar(100)         not null/* ����������� */,
    hlczjg               varchar(1000)        not null/* ���������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_CRL_HLGC     ���������¼ �� ��������¼_����۲�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_CRL_HLGC') )
 create table  DC_HLCZJL_CRL_HLGC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlgcxmmc             varchar(64)          not null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        not null/* ����۲��� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_CRL_YYMX     ���������¼ �� ��������¼_��ҩ��Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_CRL_YYMX') )
 create table  DC_HLCZJL_CRL_YYMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywyf                 varchar(100)         null/* ҩ���÷� */,
    zysylbdm             varchar(2)           null/* ��ҩʹ�������� */,
    zysylbmc             varchar(100)         null/* ��ҩʹ��������� */,
    ywsypl               varchar(2)           null/* ҩ��ʹ��Ƶ�� */,
    ywsyplmc             varchar(100)         null/* ҩ��ʹ������ */,
    ywsyjldw             varchar(6)           null/* ҩ��ʹ�ü�����λ */,
    ywsycjl              numeric(12,2)        null/* ҩ��ʹ�ôμ��� */,
    ywsyzjl              numeric(12,2)        null/* ҩ��ʹ���ܼ��� */,
    ywsytjdm             varchar(4)           null/* ҩ��ʹ��;������ */,
    ywsytjmc             varchar(50)          null/* ҩ��ʹ��;������ */,
    ywdm                 varchar(50)          null/* ҩ����� */,
    ywmc                 varchar(50)          null/* ҩ������ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_CRL_ZDXX     ���������¼ �� ��������¼_���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_CRL_ZDXX') )
 create table  DC_HLCZJL_CRL_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zdbm                 varchar(64)          not null/* ������ϱ��� */,
    zdmc                 varchar(128)         not null/* ����������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_GZHC     ���������¼ �� ��ֵ�Ĳ�ʹ�ü�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_GZHC') )
 create table  DC_HLCZJL_GZHC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    jlrqsj               datetime             not null/* ��¼����ʱ�� */,
    zrxhcbz              char(1)              not null/* ֲ���ԺĲı�־ */,
    clmc                 varchar(200)         not null/* �������� */,
    cpbm                 numeric(20)          not null/* ��Ʒ���� */,
    cpsccj               varchar(70)          not null/* ��Ʒ�������� */,
    cpgys                varchar(70)          not null/* ��Ʒ��Ӧ�� */,
    dw                   varchar(6)           not null/* �Ĳĵ�λ */,
    sl                   numeric(5)           not null/* ���� */,
    sytj                 varchar(30)          not null/* ʹ��;�� */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_GZHC_ZDXX     ���������¼ �� ��ֵ�Ĳ�ʹ�ü�¼_�����Ϣ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_GZHC_ZDXX') )
 create table  DC_HLCZJL_GZHC_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zddm                 varchar(64)          not null/* ������ϱ��� */,
    zdmc                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SMTZ     ���������¼ �� ��������������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SMTZ') )
 create table  DC_HLCZJL_SMTZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    hzxm                 varchar(50)          not null/* �������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    birth                date                 not null/* ���߳������� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(64)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    cyrqsj               datetime             null/* (��Ժ)�������ʱ�� */,
    sjzyts               numeric(4)           null/* ʵ��סԺ���� */,
    sshfmhts             numeric(5)           null/* �������������� */,
    jlrqsj               datetime             not null/* ��¼����ʱ�� */,
    hxpl                 numeric(6,2)         not null/* ����Ƶ�ʣ���/min�� */,
    syhxjbz              char(1)              not null/* ʹ�ú�������־ */,
    ml                   numeric(3)           not null/* ���ʣ���/min�� */,
    qbxl                 numeric(3)           not null/* �������ʣ���/min�� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    fw                   numeric(5,1)         not null/* ��Χ��cm�� */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SMTZ_HLGC     ���������¼ �� ��������������¼_����۲�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SMTZ_HLGC') )
 create table  DC_HLCZJL_SMTZ_HLGC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlgcxmmc             varchar(30)          not null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        not null/* ����۲��� */,
   
    
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SMTZ_ZDXX     ���������¼ �� ��������������¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SMTZ_ZDXX') )
 create table  DC_HLCZJL_SMTZ_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zdbm                 varchar(32)          not null/* ������ϱ��� */,
    zdmc                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL     ���������¼ �� ���������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL') )
 create table  DC_HLCZJL_SSHL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    birth                date                 not null/* ���߳������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    mjzh                 varchar(18)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    hzxm                 varchar(50)          not null/* �������� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    aboxxdm              varchar(2)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          not null/* ABOѪ������ */,
    rhxxdm               varchar(2)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          not null/* RhѪ������ */,
    jzkssj               datetime             null/* (��Ժ)���￪ʼʱ�� */,
    jzjssj               datetime             null/* (��Ժ)�������ʱ�� */,
    gmsbz                char(1)              not null/* ����ʷ��־ */,
    hldjdm               varchar(2)           not null/* ����ȼ����� */,
    hldjmc               varchar(100)         not null/* ����ȼ����� */,
    hllxdm               varchar(2)           not null/* �������ʹ��� */,
    hllxmc               varchar(100)         not null/* ������������ */,
    ysdm                 varchar(20)          not null/* ҽ������ */,
    ysxm                 varchar(50)          not null/* ҽ������ */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_GMS     ���������¼ �� ���������¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_GMS') )
 create table  DC_HLCZJL_SSHL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  varchar(1000)        not null/* ����ʷ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_HLCZ     ���������¼ �� ���������¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_HLCZ') )
 create table  DC_HLCZJL_SSHL_HLCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlczxmlmmc           varchar(100)         not null/* ���������Ŀ��Ŀ���� */,
    hlczmc               varchar(100)         not null/* ����������� */,
    hlczjg               varchar(1000)        not null/* ���������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_HLGC     ���������¼ �� ���������¼_����۲�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_HLGC') )
 create table  DC_HLCZJL_SSHL_HLGC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlgcxmmc             varchar(30)          not null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        not null/* ����۲��� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_PFJC     ���������¼ �� ���������¼_Ƥ�����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_PFJC') )
 create table  DC_HLCZJL_SSHL_PFJC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    pfjcms               varchar(1000)        null/* Ƥ��������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_QXHD     ���������¼ �� ���������¼_��е��Ʒ�˶�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_QXHD') )
 create table  DC_HLCZJL_SSHL_QXHD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    szsywpmc             varchar(50)          not null/* ����������Ʒ���� */,
    sqqdbz               char(1)              not null/* ��ǰ����־ */,
    gqhdbz               char(1)              not null/* ��ǰ�˶Ա�־ */,
    ghhdbz               char(1)              not null/* �غ�˶Ա�־ */,
    xthsdm               varchar(20)          not null/* Ѳ̨��ʿ���� */,
    xthsqm               varchar(50)          not null/* Ѳ̨��ʿǩ�� */,
    qxhsdm               varchar(20)          not null/* ��е��ʿ���� */,
    qxhsqm               varchar(50)          not null/* ��е��ʿǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_SHJJ     ���������¼ �� ���������¼_���󽻽�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_SHJJ') )
 create table  DC_HLCZJL_SSHL_SHJJ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    brjjhdxm             varchar(50)          not null/* ���˽��Ӻ˶���Ŀ */,
    jjhsdm               varchar(20)          not null/* ���ӻ�ʿ���� */,
    jjhsqm               varchar(50)          not null/* ���ӻ�ʿǩ�� */,
    zyzdm                varchar(20)          not null/* ת���߹��� */,
    zyzqm                varchar(50)          not null/* ת����ǩ�� */,
    jjrqsj               datetime             not null/* ��������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_SQZD     ���������¼ �� ���������¼_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_SQZD') )
 create table  DC_HLCZJL_SSHL_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_SS     ���������¼ �� ���������¼_����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_SS') )
 create table  DC_HLCZJL_SSHL_SS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ssjbh                varchar(20)          not null/* �������� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssmc                 varchar(128)         not null/* �������������� */,
    sszdm                varchar(20)          not null/* �����߹��� */,
    sszxm                varchar(50)          not null/* ���������� */,
    ssmbbwmc             varchar(128)         not null/* ����Ŀ�겿λ���� */,
    ssjsrqsj             datetime             not null/* ������������ʱ�� */,
    ssksrqsj             datetime             not null/* ������ʼ����ʱ�� */,
    rsssrqsj             datetime             not null/* ������������ʱ�� */,
    csssrqsj             datetime             not null/* ������������ʱ�� */,
    zbsx                 varchar(100)         not null/* ׼������ */,
    szblbz               char(1)              not null/* ���в����־ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_SSHL_TZ     ���������¼ �� ���������¼_����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_SSHL_TZ') )
 create table  DC_HLCZJL_SSHL_TZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_YBHL     ���������¼ �� һ�㻤���¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_YBHL') )
 create table  DC_HLCZJL_YBHL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    csrq                 date                 not null/* ���߳������� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    hldjdm               varchar(2)           not null/* ����ȼ����� */,
    hldjmc               varchar(100)         not null/* ����ȼ����� */,
    hllxdm               varchar(2)           not null/* �������ʹ��� */,
    hllxmc               varchar(100)         not null/* ������������ */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    hxl                  numeric(3)           not null/* ����Ƶ�ʣ���/min�� */,
    ml                   numeric(3)           not null/* ���ʣ���/min�� */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    xybhd                numeric(4,1)         not null/* Ѫ�����Ͷȣ�%�� */,
    zbdmbdbz             char(1)              not null/* �㱳����������־ */,
    ysqkdm               varchar(2)           not null/* ��ʳ������� */,
    ysqkmc               varchar(100)         not null/* ��ʳ������� */,
    dghlms               varchar(1000)        not null/* ���ܻ������� */,
    qghldm               varchar(2)           not null/* ���ܻ������ */,
    qghlmc               varchar(100)         not null/* ���ܻ������� */,
    twhl                 varchar(30)          not null/* ��λ���� */,
    pfhl                 varchar(50)          not null/* Ƥ������ */,
    yyhl                 varchar(100)         not null/* Ӫ������ */,
    yszddm               varchar(4)           not null/* ��ʳָ������ */,
    yszdmc               varchar(100)         not null/* ��ʳָ������ */,
    xlhldm               varchar(2)           not null/* ��������� */,
    xlhlmc               varchar(100)         not null/* ���������� */,
    aqhldm               varchar(2)           not null/* ��ȫ������� */,
    aqhlmc               varchar(30)          not null/* ��ȫ�������� */,
    jybq                 varchar(2000)        not null/* ��Ҫ���� */,
    hlgcxmmc             varchar(30)          not null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        not null/* ����۲��� */,
    fcssaqhdbbz          char(1)              not null/* ����������ȫ�˶Ա�־ */,
    shssaqhdbbz          char(1)              not null/* �ջ�������ȫ�˶Ա�־ */,
    fcssfxpgbbz          char(1)              not null/* ������������������־ */,
    shssfxpgbbz          char(1)              not null/* �ջ���������������־ */,
    glbz                 char(1)              not null/* �����־ */,
    glzldm               varchar(2)           not null/* ����������� */,
    glzlmc               varchar(100)         not null/* ������������ */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_YBHL_GMS     ���������¼ �� һ�㻤���¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_YBHL_GMS') )
 create table  DC_HLCZJL_YBHL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  varchar(1000)        not null/* ����ʷ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_YBHL_HLCZ     ���������¼ �� һ�㻤���¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_YBHL_HLCZ') )
 create table  DC_HLCZJL_YBHL_HLCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlczmc               varchar(100)         not null/* ����������� */,
    hlczxmlmmc           varchar(100)         not null/* ���������Ŀ��Ŀ���� */,
    hlczjg               varchar(1000)        not null/* ���������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLCZJL_YBHL_ZDXX     ���������¼ �� һ�㻤���¼_���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLCZJL_YBHL_ZDXX') )
 create table  DC_HLCZJL_YBHL_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zdbm                 varchar(64)          not null/* ������ϱ��� */,
    zdmc                 varchar(128)         not null/* ����������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_CYPGJZD     ���������ƻ� �� ��Ժ������ָ��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_CYPGJZD') )
 create table  DC_HLPGYJH_CYPGJZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jkkh                 varchar(64)          not null/* ������񽡿����� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    cyrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    ysqkdm               varchar(2)           null/* ��ʳ������� */,
    ysqkmc               varchar(100)         null/* ��ʳ������� */,
    zlnldm               varchar(2)           null/* ������������ */,
    zlnlmc               varchar(18)          null/* ������������ */,
    cyqkmc               varchar(2000)        not null/* ��Ժ��� */,
    lyfsdm               varchar(2)           not null/* ��Ժ��ʽ���� */,
    lyfsmc               varchar(50)          not null/* ��Ժ��ʽ���� */,
    yyzd                 varchar(100)         null/* ��ҩָ�� */,
    yszddm               varchar(2)           null/* ��ʳָ������ */,
    yszdmc               varchar(100)         null/* ��ʳָ������ */,
    shfszd               varchar(50)          null/* ���ʽָ�� */,
    xjnr                 varchar(100)         null/* �������� */,
    fzzd                 varchar(100)         null/* ����ָ�� */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_CYPGJZD_CYZD     ���������ƻ� �� ��Ժ������ָ��_��Ժ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_CYPGJZD_CYZD') )
 create table  DC_HLPGYJH_CYPGJZD_CYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyzdbm               varchar(64)          not null/* ��Ժ��ϱ��� */,
    cyzdmc               varchar(128)         not null/* ��Ժ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_HLJH     ���������ƻ� �� ����ƻ�                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_HLJH') )
 create table  DC_HLPGYJH_HLJH (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jkkh                 varchar(64)          not null/* ������񽡿����� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzdmc               varchar(128)         not null/* ����������� */,
    hldjdm               varchar(2)           not null/* ����ȼ����� */,
    hldjmc               varchar(100)         not null/* ����ȼ����� */,
    hllxdm               varchar(2)           not null/* �������ʹ��� */,
    hllxmc               varchar(100)         not null/* ������������ */,
    hlwt                 varchar(1000)        not null/* �������� */,
    hlczxmlmmc           varchar(100)         not null/* ���������Ŀ��Ŀ���� */,
    hlczmc               varchar(100)         not null/* ����������� */,
    hlczjg               varchar(1000)        not null/* ���������� */,
    dghlms               varchar(1000)        not null/* ���ܻ������� */,
    twhl                 varchar(30)          not null/* ��λ���� */,
    pfhl                 varchar(50)          not null/* Ƥ������ */,
    qghldm               varchar(2)           not null/* ���ܻ������ */,
    qghlmc               varchar(18)          not null/* ���ܻ������� */,
    aqhldm               varchar(2)           not null/* ��ȫ������� */,
    aqhlmc               varchar(18)          not null/* ��ȫ�������� */,
    yszddm               varchar(2)           not null/* ��ʳָ������ */,
    yszdmc               varchar(18)          not null/* ��ʳָ������ */,
    hsdm                 varchar(20)          not null/* ��ʿ���� */,
    hsqm                 varchar(50)          not null/* ��ʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG     ���������ƻ� �� ��Ժ������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG') )
 create table  DC_HLPGYJH_RYPG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jkkh                 varchar(64)          not null/* ������񽡿����� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yexh                 varchar(64)          not null/* Ӥ����� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    gjdm                 varchar(3)           null/* �������� */,
    gjmc                 varchar(18)          null/* �������� */,
    mz                   varchar(2)           null/* ������� */,
    mzmc                 varchar(18)          null/* �������� */,
    hyzkdm               varchar(2)           null/* ����״������ */,
    hyzkmc               varchar(18)          null/* ����״������ */,
    zylbdm               varchar(2)           null/* ְҵ������ */,
    zylbmc               varchar(18)          null/* ְҵ������� */,
    xldm                 varchar(2)           null/* ѧ������ */,
    xlmc                 varchar(18)          null/* ѧ������ */,
    hzdhhm               varchar(20)          null/* ���ߵ绰���� */,
    gzdwdhhm             varchar(20)          null/* ������λ�绰���� */,
    hzdzyjdz             varchar(70)          null/* ���ߵ����ʼ���ַ */,
    lxrxm                varchar(50)          null/* ��ϵ������ */,
    lxrdhhm              varchar(20)          null/* ��ϵ�˵绰���� */,
    rbffs                varchar(20)          null/* �벡����ʽ */,
    ryrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    hxl                  numeric(3)           not null/* ����Ƶ�ʣ���/min�� */,
    ml                   numeric(3)           not null/* ���ʣ���/min�� */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    ryyyms               varchar(1000)        not null/* ��Ժԭ�� */,
    rytjdm               varchar(2)           not null/* ��Ժ;������ */,
    rytjmc               varchar(64)          not null/* ��Ժ;������ */,
    apgarpfz             numeric(2)           null/* Apgar����ֵ */,
    ysqkdm               varchar(2)           not null/* ��ʳ������� */,
    ysqkmc               varchar(18)          not null/* ��ʳ������� */,
    fycddm               varchar(2)           null/* �����̶ȴ��� */,
    fycdmc               varchar(18)          null/* �����̶����� */,
    jsztzcbz             char(1)              null/* ����״̬������־ */,
    smzk                 varchar(1000)        null/* ˯��״�� */,
    tsqk                 varchar(1000)        null/* ������� */,
    xlztdm               varchar(2)           null/* ����״̬���� */,
    xlztmc               varchar(18)          null/* ����״̬���� */,
    yyztdm               varchar(2)           null/* Ӫ��״̬���� */,
    yyztmc               varchar(18)          null/* Ӫ��״̬���� */,
    zlnldm               varchar(2)           null/* ������������ */,
    zlnlmc               varchar(18)          null/* ������������ */,
    ybjkzkbz             char(1)              not null/* һ�㽡��״����־ */,
    hzcrxbz              char(1)              not null/* ���ߴ�Ⱦ�Ա�־ */,
    xybz                 char(1)              not null/* ���̱�־ */,
    tzxyts               numeric(5)           not null/* ֹͣ�������� */,
    xyzkdm               varchar(2)           not null/* ����״������ */,
    xyzkmc               varchar(18)          not null/* ����״������ */,
    rxylz                numeric(3)           not null/* ����������֧�� */,
    yjbz                 char(1)              not null/* ���Ʊ�־ */,
    yjpldm               varchar(2)           not null/* ����Ƶ�ʴ��� */,
    yjplmc               varchar(18)          not null/* ����Ƶ������ */,
    ryjlml               numeric(3)           not null/* ����������mL�� */,
    tzysbz               char(1)              not null/* ֪ͨҽʦ��־ */,
    tzysrqsj             datetime             not null/* ֪ͨҽʦ����ʱ�� */,
    pgrqsj               datetime             not null/* ��������ʱ�� */,
    zrhsdm               varchar(50)          not null/* ���λ�ʿ���� */,
    zrhsqm               varchar(50)          not null/* ���λ�ʿǩ�� */,
    jzhsdm               varchar(50)          not null/* ���ﻤʿ���� */,
    jzhsqm               varchar(50)          not null/* ���ﻤʿǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_CRBS     ���������ƻ� �� ��Ժ������¼_��Ⱦ��ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_CRBS') )
 create table  DC_HLPGYJH_RYPG_CRBS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    crbs                 varchar(1000)        not null/* ��Ⱦ��ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_GMS     ���������ƻ� �� ��Ժ������¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_GMS') )
 create table  DC_HLPGYJH_RYPG_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  varchar(1000)        not null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_HLGCXM     ���������ƻ� �� ��Ժ������¼_����۲���Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_HLGCXM') )
 create table  DC_HLPGYJH_RYPG_HLGCXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    hlgcxmdm             varchar(11)          null/* ����۲���Ŀ���� */,
    hlgcxmmc             varchar(30)          null/* ����۲���Ŀ���� */,
    hlgcjg               varchar(1000)        null/* ����۲��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_JBS     ���������ƻ� �� ��Ժ������¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_JBS') )
 create table  DC_HLPGYJH_RYPG_JBS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbshws               varchar(1000)        not null/* ����ʷ�������ˣ� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_JZS     ���������ƻ� �� ��Ժ������¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_JZS') )
 create table  DC_HLPGYJH_RYPG_JZS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jzs                  varchar(1000)        not null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_RYZD     ���������ƻ� �� ��Ժ������¼_��Ժ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_RYZD') )
 create table  DC_HLPGYJH_RYPG_RYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ryzdbm               varchar(64)          not null/* ��Ժ��ϱ��� */,
    ryzdmc               varchar(128)         not null/* ��Ժ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_SSS     ���������ƻ� �� ��Ժ������¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_SSS') )
 create table  DC_HLPGYJH_RYPG_SSS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sss                  varchar(1000)        not null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_SXS     ���������ƻ� �� ��Ժ������¼_��Ѫʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_SXS') )
 create table  DC_HLPGYJH_RYPG_SXS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sxs                  varchar(1000)        not null/* ��Ѫʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_YFJZS     ���������ƻ� �� ��Ժ������¼_Ԥ������ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_YFJZS') )
 create table  DC_HLPGYJH_RYPG_YFJZS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yfjzs                varchar(1000)        not null/* Ԥ������ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_HLPGYJH_RYPG_ZYZZ     ���������ƻ� �� ��Ժ������¼_��Ҫ֢״                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_HLPGYJH_RYPG_ZYZZ') )
 create table  DC_HLPGYJH_RYPG_ZYZZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyzz                 varchar(50)          not null/* ��Ҫ֢״ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JCJL     �������¼ �� ����¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JCJL') )
 create table  DC_JCJYJL_JCJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgzzjgdm           varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    yljgzzjgmc           varchar(100)         not null/* ҽ�ƻ�����֯�������� */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    hzlxdm               varchar(2)           not null/* �������ʹ��� */,
    hzlxmc               varchar(100)         not null/* ������������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    dhhm                 varchar(20)          null/* �绰���� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    jcsqjgmc             varchar(70)          not null/* �������������� */,
    jcsqksdm             varchar(10)          not null/* �������������� */,
    jcsqksmc             varchar(50)          not null/* ���������� */,
    zdjgdm               varchar(20)          not null/* ��ϻ������� */,
    zdjgmc               varchar(70)          not null/* ��ϻ������� */,
    zdrq                 date                 not null/* ������� */,
    jbzdbm               varchar(32)          not null/* ������ϱ��� */,
    jbzdmc               varchar(128)         not null/* ����������� */,
    zs                   varchar(100)         not null/* ���� */,
    zzksrqsj             datetime             not null/* ֢״��ʼ����ʱ�� */,
    zztzrqsj             datetime             not null/* ֢״ֹͣ����ʱ�� */,
    zzms                 varchar(1000)        not null/* ֢״���� */,
    tsjcbz               char(1)              not null/* �������־ */,
    zlgcms               varchar(2000)        not null/* ���ƹ������� */,
    jcbbh                varchar(20)          not null/* ���걾�� */,
    jcffdm               varchar(10)          not null/* ��鷽������ */,
    jcffmc               varchar(100)         not null/* ��鷽������ */,
    jclbdm               varchar(10)          not null/* ��������� */,
    jclbmc               varchar(100)         not null/* ������ */,
    jcjsdm               varchar(20)          not null/* ��鼼ʦ���� */,
    jcjsqm               varchar(50)          not null/* ��鼼ʦǩ�� */,
    jcysdm               varchar(20)          not null/* ���ҽʦ���� */,
    jcysqm               varchar(50)          not null/* ���ҽʦǩ�� */,
    jcrq                 date                 not null/* ������� */,
    jcbgdbh              varchar(20)          not null/* ��鱨�浥��� */,
    jcbgjgdm             varchar(20)          not null/* ��鱨��������� */,
    jcbgjgmc             varchar(70)          not null/* ��鱨��������� */,
    jcbgksdm             varchar(10)          not null/* ��鱨����� */,
    jcbgksmc             varchar(50)          not null/* ��鱨����� */,
    jcbgjg_kgsj          varchar(200)         not null/* ��鱨����-�͹����� */,
    jcbgjg_zgts          varchar(200)         not null/* ��鱨����-������ʾ */,
    jcbgbz               varchar(100)         not null/* ��鱨�汸ע */,
    jcbgrq               date                 not null/* ��鱨������ */,
    bgysdm               varchar(20)          not null/* ����ҽʦ���� */,
    bgysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    shysdm               varchar(20)          not null/* ���ҽʦ���� */,
    shysqm               varchar(50)          not null/* ���ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JCJL_JCXM     �������¼ �� ����¼_�����Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JCJL_JCXM') )
 create table  DC_JCJYJL_JCJL_JCXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    bblbdm               varchar(20)          not null/* �걾��� */,
    bblbmc               varchar(50)          not null/* �걾���� */,
    bbzt                 varchar(20)          not null/* �걾״̬ */,
    bbgdymc              varchar(50)          not null/* �걾�̶�Һ���� */,
    bbcyrqsj             datetime             not null/* �걾��������ʱ�� */,
    jsbbrqsj             datetime             not null/* ���ձ걾����ʱ�� */,
    jcxmdm               varchar(20)          not null/* �����Ŀ���� */,
    jcxmmc               varchar(50)          not null/* �����Ŀ���� */,
    jcjgdm               varchar(10)          not null/* ��������� */,
    jcjgmc               varchar(50)          not null/* ��������� */,
    jcdljg               numeric(14,4)        not null/* ��鶨����� */,
    jcdljgjldw           varchar(20)          not null/* ��鶨�����������λ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JCJL_SS     �������¼ �� ����¼_����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JCJL_SS') )
 create table  DC_JCJYJL_JCJL_SS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czbm                 varchar(64)          null/* �������� */,
    czmc                 varchar(128)         null/* �������� */,
    czbwbm               varchar(64)          null/* ������λ���� */,
    czbwmc               varchar(128)         null/* ������λ���� */,
    jrwmc                varchar(100)         not null/* ���������� */,
    czffms               varchar(2000)        null/* ������������ */,
    czcs                 numeric(3)           null/* �������� */,
    czrqsj               datetime             null/* ��������ʱ�� */,
    mzffdm               varchar(2)           not null/* ���������� */,
    mzffmc               varchar(50)          not null/* ���������� */,
    mzgcjg               varchar(1000)        not null/* ����۲��� */,
    mzzxybsdm            varchar(2)           not null/* ��������ҽ��ʶ���� */,
    mzzxybsmc            varchar(100)         not null/* ��������ҽ��ʶ���� */,
    mzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JYJL     �������¼ �� �����¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JYJL') )
 create table  DC_JCJYJL_JYJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgzzjgdm           varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    yljgzzjgmc           varchar(100)         not null/* ҽ�ƻ�����֯�������� */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    hzlxdm               varchar(2)           not null/* �������ʹ��� */,
    hzlxmc               varchar(18)          not null/* ������������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    dhhm                 varchar(20)          null/* �绰���� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    jysqjgdm             varchar(20)          not null/* ��������������� */,
    jysqjgmc             varchar(70)          not null/* ��������������� */,
    jysqksdm             varchar(11)          not null/* ����������Ҵ��� */,
    jysqksmc             varchar(50)          not null/* ����������� */,
    jyffdm               varchar(10)          not null/* ���鷽������ */,
    jyffmc               varchar(100)         not null/* ���鷽������ */,
    jylbdm               varchar(10)          not null/* ���������� */,
    jylbmc               varchar(100)         not null/* ������� */,
    jybbh                varchar(20)          not null/* ����걾�� */,
    jyjsdm               varchar(50)          not null/* ���鼼ʦ���� */,
    jyjsqm               varchar(50)          not null/* ���鼼ʦǩ�� */,
    jyjsqmsj             datetime             not null/* ���鼼ʦǩ��ʱ�� */,
    jyysdm               varchar(50)          not null/* ����ҽʦ���� */,
    jyysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    jyysqmsj             datetime             not null/* ����ҽʦʱ�� */,
    jyrq                 date                 not null/* �������� */,
    jybgdbh              varchar(20)          not null/* ���鱨�浥��� */,
    jybgjgdm             varchar(20)          not null/* ���鱨��������� */,
    jybgjgmc             varchar(70)          not null/* ���鱨��������� */,
    jybgksdm             varchar(11)          not null/* ���鱨����Ҵ��� */,
    jybgksmc             varchar(50)          not null/* ���鱨����� */,
    jybgjg               varchar(200)         not null/* ���鱨���� */,
    jybgbz               varchar(100)         not null/* ���鱨�汸ע */,
    jybgrq               date                 not null/* ���鱨������ */,
    bgysdm               varchar(20)          not null/* ����ҽʦ���� */,
    bgysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    shysdm               varchar(20)          not null/* ���ҽʦ��ʶ�� */,
    shysqm               varchar(50)          not null/* ���ҽʦǩ�� */,
    shysqmsj             datetime             not null/* ���ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JYJL_JYXM     �������¼ �� �����¼_������Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JYJL_JYXM') )
 create table  DC_JCJYJL_JYJL_JYXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    bblbdm               varchar(20)          not null/* �걾������ */,
    bblbmc               varchar(50)          not null/* �걾��� */,
    bbzt                 varchar(20)          not null/* �걾״̬ */,
    bbcyrqsj             datetime             not null/* �걾��������ʱ�� */,
    jsbbrqsj             datetime             not null/* ���ձ걾����ʱ�� */,
    jyxmdm               varchar(20)          not null/* ������Ŀ���� */,
    jyxmmc               varchar(50)          not null/* ������Ŀ���� */,
    jyjgdm               varchar(10)          not null/* ���������� */,
    jyjgmc               varchar(100)         not null/* ���������� */,
    jydljg               numeric(14,4)        not null/* ���鶨����� */,
    jydljgjldw           varchar(20)          not null/* ���鶨�����������λ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_JCJYJL_JYJL_ZDXX     �������¼ �� �����¼_���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_JCJYJL_JYJL_ZDXX') )
 create table  DC_JCJYJL_JYJL_ZDXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzdmc               varchar(128)         not null/* ����������� */,
    zdjgdm               varchar(20)          not null/* ��ϻ������� */,
    zdjgmc               varchar(70)          not null/* ��ϻ������� */,
    zdrq                 date                 not null/* ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_JZLGBL     �ţ������ﲡ�� �� �������۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_JZLGBL') )
 create table  DC_MJZBL_JZLGBL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 not null/* �������� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    jzrqsj               datetime             not null/* ��������ʱ�� */,
    czbzdm               varchar(2)           not null/* �����־���� */,
    czbzmc               varchar(18)          not null/* �����־���� */,
    srgcsrq              datetime             not null/* ����۲�������ʱ�� */,
    zs                   nvarchar(100)        not null/* ���� */,
    xbs                  nvarchar(2000)       not null/* �ֲ�ʷ */,
    jws                  nvarchar(1000)       not null/* ����ʷ */,
    tgjc                 nvarchar(500)        not null/* ����� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    fzjcxm               nvarchar(100)        null/* ���������Ŀ */,
    fzjcjg               nvarchar(1000)       null/* ��������� */,
    xyzdbm               varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    xyzdmc               varchar(128)         not null/* �������-��ҽ������� */,
    zybmdm               varchar(64)          not null/* �������-��ҽ�������� */,
    zybmmc               varchar(128)         not null/* �������-��ҽ�������� */,
    zyzhdm               varchar(64)          not null/* �������-��ҽ֤����� */,
    zyzhmc               varchar(128)         not null/* �������-��ҽ֤������ */,
    bzyj                 nvarchar(100)        null/* ��֤���� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    yzxmlx               varchar(2)           not null/* ҽ����Ŀ���ʹ��� */,
    yzxmlxmc             sysname              not null/* ҽ����Ŀ�������� */,
    yzxmnr               nvarchar(100)        not null/* ҽ����Ŀ���� */,
    yzbzxx               nvarchar(100)        not null/* ҽ����ע��Ϣ */,
    yzklksdm             varchar(10)          not null/* ҽ���������� */,
    yzklks               varchar(50)          not null/* ҽ���������� */,
    yzklzdm              varchar(20)          not null/* ҽ�������߹��� */,
    yzklzqm              varchar(50)          not null/* ҽ��������ǩ�� */,
    yzklrq               datetime             not null/* ҽ����������ʱ�� */,
    yzshzdm              varchar(20)          not null/* ҽ������߹��� */,
    yzshzqm              varchar(50)          not null/* ҽ�������ǩ�� */,
    yzshrq               datetime             not null/* ҽ���������ʱ�� */,
    yzzxksdm             varchar(10)          not null/* ҽ��ִ�д��� */,
    yzzxks               varchar(50)          not null/* ҽ��ִ�п��� */,
    yzzxzdm              varchar(20)          not null/* ҽ��ִ���߹��� */,
    yzzxzqm              varchar(50)          not null/* ҽ��ִ����ǩ�� */,
    yzzxrq               datetime             not null/* ҽ��ִ������ʱ�� */,
    yzjhjsrq             datetime             not null/* ҽ���ƻ���������ʱ�� */,
    yzzxzt               varchar(50)          not null/* ҽ��ִ��״̬ */,
    qxyzzdm              varchar(20)          not null/* ȡ��ҽ���߹��� */,
    qxyzzqm              varchar(50)          not null/* ȡ��ҽ����ǩ�� */,
    yzqxrq               datetime             not null/* ҽ��ȡ������ʱ�� */,
    dzsqdbh              varchar(50)          not null/* �������뵥��� */,
    jzlgbcjl             nvarchar(2000)       not null/* �������۲��̼�¼ */,
    qjksrq               datetime             not null/* ���ȿ�ʼ����ʱ�� */,
    qjjsrq               datetime             not null/* ���Ƚ�������ʱ�� */,
    jzqjjl               nvarchar(2000)       not null/* �������ȼ�¼ */,
    jlrqsj               datetime             not null/* ��¼����ʱ�� */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    cjqjrydm             varchar(100)         not null/* �μ�������Ա�������� */,
    cjqjrymd             varchar(500)         not null/* �μ�������Ա���� */,
    zyjszwlb             varchar(8)           not null/* רҵ����ְ�������� */,
    zyjszwlbmc           varchar(64)          not null/* רҵ����ְ��������� */,
    hzqxdm               varchar(2)           not null/* ����ȥ����� */,
    hzqxmc               varchar(18)          not null/* ����ȥ������ */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦ���� */,
    ysbm                 varchar(20)          not null/* ǩ��ҽʦ���� */,
    ysqm                 varchar(50)          not null/* ǩ��ҽʦ���� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_JZLGBL_GMS     �ţ������ﲡ�� �� �������۲���_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_JZLGBL_GMS') )
 create table  DC_MJZBL_JZLGBL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gmsbz                char(1)              not null/* ����ʷ��־ */,
    gms                  nvarchar(1000)       not null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_JZLGBL_SSCZ     �ţ������ﲡ�� �� �������۲���_��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_JZLGBL_SSCZ') )
 create table  DC_MJZBL_JZLGBL_SSCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ssjczbm              varchar(64)          null/* �������������� */,
    ssjczmc              varchar(128)         null/* �������������� */,
    ssmbbwbm             varchar(100)         null/* ����������Ŀ�겿λ���� */,
    ssmbbw               varchar(500)         null/* ����������Ŀ�겿λ���� */,
    jrwdm                varchar(100)         null/* ��������� */,
    jrwmc                varchar(500)         null/* ���������� */,
    ssjczff              nvarchar(2000)       null/* �������������� */,
    ssjczcs              varchar(3)           null/* �������������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL     �ż��ﲡ�� �� �ż��ﲡ��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL') )
 create table  DC_MJZBL_MJZBL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    patid                varchar(64)          not null/* ����patid */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 not null/* �������� */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    jzrqsj               datetime             not null/* ��������ʱ�� */,
    czbzdm               varchar(2)           not null/* �����־���� */,
    czbzmc               varchar(18)          not null/* �����־���� */,
    zs                   nvarchar(100)        not null/* ���� */,
    xbs                  nvarchar(2000)       not null/* �ֲ�ʷ */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    bzyj                 nvarchar(100)        null/* ��֤���� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    ysbm                 varchar(20)          not null/* ҽʦǩ������ */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_FZJCXM     �ż��ﲡ�� �� �ż��ﲡ��_���������Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_FZJCXM') )
 create table  DC_MJZBL_MJZBL_FZJCXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    fzjcxm               nvarchar(100)        null/* ���������Ŀ */,
    fzjcjg               nvarchar(1000)       null/* ��������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_GMS     �ż��ﲡ�� �� �ż��ﲡ��_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_GMS') )
 create table  DC_MJZBL_MJZBL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gmsbz                char(1)              not null/* ����ʷ��־ */,
    gms                  nvarchar(1000)       not null/* ����ʷ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_GWS     �ż��ﲡ�� �� �ż��ﲡ��_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_GWS') )
 create table  DC_MJZBL_MJZBL_GWS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jws                  nvarchar(1000)       not null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_XYZD     �ż��ﲡ�� �� �ż��ﲡ��_��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_XYZD') )
 create table  DC_MJZBL_MJZBL_XYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    xyzdbm               varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    xyzdmc               varchar(128)         not null/* �������-��ҽ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_YBTGJCJG     �ż��ﲡ�� �� �ż��ﲡ��_һ���������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_YBTGJCJG') )
 create table  DC_MJZBL_MJZBL_YBTGJCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    tgjc                 nvarchar(500)        not null/* һ��������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_YZMX     �ż��ﲡ�� �� �ż��ﲡ��_ҽ����ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_YZMX') )
 create table  DC_MJZBL_MJZBL_YZMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yzxmlx               varchar(2)           not null/* ҽ����Ŀ���ʹ��� */,
    yzxmlxmc             nvarchar(100)        not null/* ҽ����Ŀ�������� */,
    yzxmnr               nvarchar(100)        not null/* ҽ����Ŀ���� */,
    yzbzxx               nvarchar(100)        not null/* ҽ����ע��Ϣ */,
    yzklksdm             varchar(10)          not null/* ҽ���������Ҵ��� */,
    yzklks               varchar(50)          not null/* ҽ�������������� */,
    yzklzdm              varchar(20)          not null/* ҽ�������߹��� */,
    yzklzqm              varchar(50)          not null/* ҽ��������ǩ�� */,
    yzklrq               datetime             not null/* ҽ����������ʱ�� */,
    yzshzdm              varchar(20)          not null/* ҽ������߹��� */,
    yzshzqm              varchar(50)          not null/* ҽ�������ǩ�� */,
    yzshrq               datetime             not null/* ҽ���������ʱ�� */,
    zxksdm               varchar(10)          not null/* ҽ��ִ�п��Ҵ��� */,
    yzzxks               varchar(50)          not null/* ҽ��ִ�п������� */,
    yzzxzdm              varchar(20)          not null/* ҽ��ִ���߹��� */,
    yzzxzqm              varchar(50)          not null/* ҽ��ִ����ǩ�� */,
    yzzxrq               datetime             not null/* ҽ��ִ������ʱ�� */,
    yzzxzt               varchar(50)          not null/* ҽ��ִ��״̬ */,
    qxyzzdm              varchar(20)          not null/* ȡ��ҽ���߹��� */,
    qxyzzqm              varchar(50)          not null/* ȡ��ҽ����ǩ�� */,
    yzqxrq               datetime             not null/* ҽ��ȡ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_ZYBM     �ż��ﲡ�� �� �ż��ﲡ��_��ҽ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_ZYBM') )
 create table  DC_MJZBL_MJZBL_ZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zybmdm               varchar(64)          null/* �������-��ҽ�������� */,
    zybmmc               varchar(128)         null/* �������-��ҽ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZBL_MJZBL_ZYZH     �ż��ﲡ�� �� �ż��ﲡ��_��ҽ֤��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZBL_MJZBL_ZYZH') )
 create table  DC_MJZBL_MJZBL_ZYZH (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyzhdm               varchar(64)          null/* �������-��ҽ֤����� */,
    zyzhmc               varchar(128)         null/* �������-��ҽ֤������ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZCF_XYCF     �ż��ﴦ�� �� ��ҩ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZCF_XYCF') )
 create table  DC_MJZCF_XYCF (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    cfxh                 varchar(64)          not null/* ������� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    cfklrq               date                 not null/* ������������ */,
    cfklskdm             varchar(10)          not null/* �����������Ҵ��� */,
    cfklks               varchar(50)          not null/* ������������ */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    ysbm                 varchar(20)          not null/* ��������ҽʦ���� */,
    klysqm               varchar(50)          not null/* ��������ҽʦǩ�� */,
    shyjsbm              varchar(20)          not null/* �������ҩ��ʦ���� */,
    shyjsqm              varchar(50)          not null/* �������ҩ��ʦǩ�� */,
    shyjsqmsj            datetime             not null/* �������ҩ��ʦǩ��ʱ�� */,
    tpyjsbm              varchar(20)          not null/* ��������ҩ��ʦ���� */,
    tpyjsqm              varchar(50)          not null/* ��������ҩ��ʦǩ�� */,
    cftpsj               datetime             not null/* ��������ʱ�� */,
    hdyjsbm              varchar(20)          not null/* �����˶�ҩ��ʦ���� */,
    hdyjsqm              varchar(50)          not null/* �����˶�ҩ��ʦǩ�� */,
    cfhdsj               datetime             not null/* �����˶�ʱ�� */,
    fyyjsbm              varchar(20)          not null/* ������ҩҩ��ʦ���� */,
    fyyjsqm              varchar(50)          not null/* ������ҩҩ��ʦǩ�� */,
    cffysj               datetime             not null/* ������ҩʱ�� */,
    cfypje               numeric(8,2)         not null/* ����ҩƷ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZCF_XYCF_YYMX     �ż��ﴦ�� �� ��ҩ����_��ҩ��ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZCF_XYCF_YYMX') )
 create table  DC_MJZCF_XYCF_YYMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywdm                 varchar(100)         not null/* ҩ����� */,
    ywmc                 varchar(500)         not null/* ҩ������ */,
    ywgg                 varchar(20)          not null/* ҩ���� */,
    ywjxdm               varchar(2)           not null/* ҩ����ʹ��� */,
    ywjx                 varchar(64)          not null/* ҩ��������� */,
    ywsycjl              numeric(5,2)         not null/* ҩ��ʹ�ôμ��� */,
    ywsyjldw             varchar(6)           not null/* ҩ��ʹ�ôε�λ */,
    ywsypcdm             varchar(2)           not null/* ҩ��ʹ��Ƶ�δ��� */,
    ywsypc               varchar(64)          not null/* ҩ��ʹ��Ƶ������ */,
    ywsytj               varchar(3)           not null/* ҩ��ʹ��;������ */,
    ywsytjmc             varchar(64)          not null/* ҩ��ʹ��;������ */,
    ywsyzjl              numeric(12,2)        not null/* ҩ��ʹ���ܼ��� */,
    cfyxts               numeric(2)           not null/* ������Ч���� */,
    cfypzh               varchar(50)          not null/* ����ҩƷ��� */,
    cfbzxx               nvarchar(100)        not null/* ������ע��Ϣ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZCF_ZYCF     �ż��ﴦ�� �� ��ҩ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZCF_ZYCF') )
 create table  DC_MJZCF_ZYCF (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    mjzh                 varchar(64)          not null/* �ż���� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    cfxh                 varchar(12)          not null/* ������� */,
    cflb                 varchar(2)           not null/* ���������� */,
    cflbmc               varchar(18)          not null/* ����������� */,
    cfklrq               date                 not null/* ������������ */,
    cfyxts               numeric(2)           not null/* ������Ч���� */,
    cfklksdm             varchar(10)          not null/* ���Ҵ��� */,
    cfklks               varchar(50)          not null/* �������� */,
    jbzdbm               varchar(64)          not null/* ��ҽ��ϱ��� */,
    jbzd                 varchar(128)         not null/* ��ҽ������� */,
    zybmdm               varchar(64)          not null/* ��ҽ�������� */,
    zybm                 varchar(128)         not null/* ��ҽ�������� */,
    zyzhdm               varchar(64)          not null/* ��ҽ֤����� */,
    zyzh                 varchar(128)         not null/* ��ҽ֤������ */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    ysbm                 varchar(20)          not null/* ��������ҽʦ���� */,
    klysqm               varchar(50)          not null/* ��������ҽʦǩ�� */,
    shyjsbm              varchar(20)          not null/* �������ҩ��ʦ���� */,
    shyjsqm              varchar(50)          not null/* �������ҩ��ʦǩ�� */,
    tpyjsbm              varchar(20)          not null/* ��������ҩ��ʦ���� */,
    tpyjsqm              varchar(50)          not null/* ��������ҩ��ʦǩ�� */,
    hdyjsbm              varchar(20)          not null/* �����˶�ҩ��ʦ���� */,
    hdyjsqm              varchar(50)          not null/* �����˶�ҩ��ʦǩ�� */,
    fyyjsbm              varchar(20)          not null/* ������ҩҩ��ʦ���� */,
    fyyjsqm              varchar(50)          not null/* ������ҩҩ��ʦǩ�� */,
    cfbzxx               nvarchar(100)        not null/* ������ע��Ϣ */,
    cfypje               numeric(8,2)         not null/* ����ҩƷ��� */,
    cfypzh               varchar(50)          not null/* ����ҩƷ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZCF_ZYCF_CFMX     �ż��ﴦ�� �� ��ҩ����_������ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZCF_ZYCF_CFMX') )
 create table  DC_MJZCF_ZYCF_CFMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywdm                 varchar(100)         not null/* ҩ����� */,
    ywmc                 varchar(500)         not null/* ҩ������ */,
    ywgg                 varchar(20)          not null/* ҩ���� */,
    ywjxdm               varchar(2)           not null/* ҩ����ʹ��� */,
    ywjx                 varchar(64)          not null/* ҩ��������� */,
    ywsycjl              numeric(5,2)         not null/* ҩ��ʹ�ôμ��� */,
    ywsyjldw             varchar(6)           not null/* ҩ��ʹ�ü�����λ */,
    ywsypcdm             varchar(2)           not null/* ҩ��ʹ��Ƶ�δ��� */,
    ywsypc               varchar(64)          not null/* ҩ��ʹ��Ƶ������ */,
    ywsytj               varchar(3)           not null/* ҩ��ʹ��;������ */,
    ywsytjmc             varchar(64)          not null/* ҩ��ʹ��;������ */,
    ywsyzjl              numeric(12,2)        not null/* ҩ��ʹ���ܼ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_MJZCF_ZYCF_ZYYPCF     �ż��ﴦ�� �� ��ҩ����_��ҩ��Ƭ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_MJZCF_ZYCF_ZYYPCF') )
 create table  DC_MJZCF_ZYCF_ZYYPCF (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyypcf               nvarchar(500)        not null/* ��ҩ��Ƭ���� */,
    zyypjs               varchar(2)           not null/* ��ҩ��Ƭ���������� */,
    zyypjzf              nvarchar(100)        not null/* ��ҩ��Ƭ���� */,
    zyyyff               nvarchar(100)        not null/* ��ҩ��ҩ���� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_JBXX     ��Ժ��¼ �� ��Ժ��¼������Ϣ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_JBXX') )
 create table  DC_RYJL_JBXX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(18)          not null/* סԺ�� */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    mz                   varchar(2)           null/* ���� */,
    mzmc                 varchar(32)          null/* �������� */,
    hyzkdm               varchar(2)           null/* ����״������ */,
    hyzkmc               varchar(32)          null/* ����״������ */,
    dzsf                 varchar(70)          not null/* ��ַ-ʡ����������ֱϽ�У� */,
    dzsq                 varchar(70)          not null/* ��ַ-�У��������ݣ� */,
    dzx                  varchar(70)          not null/* ��ַ-�أ����� */,
    dzxz                 varchar(70)          not null/* ��ַ-�磨�򡢽ֵ����´��� */,
    dzc                  varchar(70)          not null/* ��ַ-�壨�֡�·��Ū�ȣ� */,
    dzmphm               varchar(70)          not null/* ��ַ-���ƺ��� */,
    zylbdm               varchar(2)           not null/* ְҵ������ */,
    zylbmc               varchar(50)          not null/* ְҵ������� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    bscszxm              varchar(50)          null/* ��ʷ���������� */,
    cszhzgxdm            varchar(2)           null/* �������뻼�ߵĹ�ϵ���� */,
    cszhzgxmc            varchar(50)          null/* �������뻼�ߵĹ�ϵ���� */,
    csnrbz               char(1)              not null/* �������ݿɿ���־ */,
    zs                   nvarchar(100)        not null/* ���� */,
    xbs                  nvarchar(2000)       not null/* �ֲ�ʷ */,
    ybjkbz               char(1)              null/* һ�㽡��״����־ */,
    jbs                  nvarchar(1000)       null/* ����ʷ�������ˣ� */,
    hzcrbz               char(1)              not null/* ���ߴ�Ⱦ�Ա�־ */,
    crbs                 nvarchar(1000)       null/* ��Ⱦ��ʷ */,
    yfjzs                nvarchar(1000)       null/* Ԥ������ʷ */,
    sss                  nvarchar(1000)       null/* ����ʷ */,
    sxs                  nvarchar(1000)       null/* ��Ѫʷ */,
    gms                  nvarchar(1000)       null/* ����ʷ */,
    grs                  nvarchar(1000)       null/* ����ʷ */,
    hys                  nvarchar(1000)       null/* ����ʷ */,
    yjs                  nvarchar(1000)       null/* �¾�ʷ */,
    jzs                  nvarchar(1000)       null/* ����ʷ */,
    tjtw                 numeric(4,1)         not null/* �����--���£��棩 */,
    tjml                 numeric(3)           not null/* �����--���ʣ���/min�� */,
    tjhxpl               numeric(3)           not null/* �����--����Ƶ�ʣ���/min�� */,
    tjssy                numeric(3)           not null/* �����--����ѹ��mmHg�� */,
    tjszy                numeric(3)           not null/* �����--����ѹ��mmHg�� */,
    tjsg                 numeric(5,1)         not null/* �����--��ߣ�cm�� */,
    tjtz                 numeric(5,2)         not null/* �����--���أ�kg�� */,
    tjybjg               nvarchar(1000)       not null/* �����--һ��״������� */,
    tjplmjg              nvarchar(1000)       not null/* �����--Ƥ�����Ĥ����� */,
    tjqblbjg             nvarchar(1000)       not null/* �����--ȫ��ǳDC_RYJL_JBXX�ܰͽ����� */,
    tjtbqgjg             nvarchar(1000)       not null/* �����--ͷ���������ټ���� */,
    tjjbjg               nvarchar(1000)       not null/* �����--��������� */,
    tjxbjg               nvarchar(1000)       not null/* �����--�ز������ */,
    tjfbjg               nvarchar(1000)       not null/* �����--��������� */,
    tjgmzzjg             nvarchar(1000)       not null/* �����--����ָ���������� */,
    tjwszqjg             nvarchar(1000)       not null/* �����--����ֳ������� */,
    tjjzjg               nvarchar(1000)       not null/* �����--��������� */,
    tjszjg               nvarchar(1000)       not null/* �����--��֫����� */,
    tjsjxtjg             nvarchar(1000)       not null/* �����--��ϵͳ����� */,
    zkqk                 nvarchar(1000)       null/* ר����� */,
    fzjcjg               nvarchar(1000)       null/* ��������� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    czxyzdmc             varchar(128)         not null/* �������-��ҽ������� */,
    czxyzdbm             varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    czzybmmc             varchar(128)         null/* �������-��ҽ�������� */,
    czzybmdm             varchar(64)          null/* �������-��ҽ�������� */,
    czzyzhmc             varchar(128)         null/* �������-��ҽ֤������ */,
    czzyzhdm             varchar(64)          null/* �������-��ҽ֤����� */,
    czrq                 date                 not null/* ����������� */,
    xzxyzdmc             varchar(128)         null/* �������-��ҽ������� */,
    xzxyzdbm             varchar(64)          null/* �������-��ҽ��ϱ��� */,
    xzzybmmc             varchar(128)         null/* �������-��ҽ�������� */,
    xzzybmdm             varchar(64)          null/* �������-��ҽ�������� */,
    xzzyzhmc             varchar(128)         null/* �������-��ҽ֤������ */,
    xzzyzhdm             varchar(64)          null/* �������-��ҽ֤����� */,
    xzzdrq               date                 null/* ����������� */,
    qzxyzdmc             varchar(128)         not null/* ȷ�����-��ҽ������� */,
    qzxyzdbm             varchar(64)          not null/* ȷ�����-��ҽ��ϱ��� */,
    qzzybmmc             varchar(128)         null/* ȷ�����-��ҽ�������� */,
    qzzybmdm             varchar(64)          null/* ȷ�����-��ҽ�������� */,
    qzzyzhmc             varchar(128)         null/* ȷ�����-��ҽ֤������ */,
    qzzyzhdm             varchar(64)          null/* ȷ�����-��ҽ֤����� */,
    qzrq                 date                 not null/* ȷ��������� */,
    bzmc                 varchar(128)         null/* ����������� */,
    bzbm                 varchar(64)          null/* ������ϱ��� */,
    bzrq                 date                 null/* ����������� */,
    ryzdsw               varchar(20)          null/* ��Ժ���˳λ */,
    jzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    jzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL     ��Ժ��¼��24Сʱ�����Ժ��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL') )
 create table  DC_RYJL_RCYJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(18)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    mz                   varchar(2)           null/* ���� */,
    mzmc                 varchar(32)          null/* �������� */,
    hyzkdm               varchar(2)           null/* ����״������ */,
    hyzkmc               varchar(32)          null/* ����״������ */,
    dzsf                 varchar(70)          not null/* ��ַ-ʡ����������ֱϽ�У� */,
    dzsq                 varchar(70)          not null/* ��ַ-�У��������ݣ� */,
    dzx                  varchar(70)          not null/* ��ַ-�أ����� */,
    dzxz                 varchar(70)          not null/* ��ַ-�磨�򡢽ֵ����´��� */,
    dzc                  varchar(70)          not null/* ��ַ-�壨�֡�·��Ū�ȣ� */,
    dzmphm               varchar(70)          not null/* ��ַ-���ƺ��� */,
    zylbdm               varchar(2)           null/* ְҵ������ */,
    zylbmc               varchar(32)          null/* ְҵ������� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    cyrq                 datetime             not null/* ��Ժ����ʱ�� */,
    bscszxm              varchar(50)          not null/* ��ʷ���������� */,
    cszhzgxdm            varchar(50)          not null/* �������뻼�ߵĹ�ϵ���� */,
    cszhzgxmc            varchar(50)          not null/* �������뻼�ߵĹ�ϵ���� */,
    csnrbz               char(1)              not null/* �������ݿɿ���־ */,
    zs                   nvarchar(100)        not null/* ���� */,
    xbs                  nvarchar(2000)       not null/* �ֲ�ʷ */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zzmc                 varchar(50)          not null/* ֢״���� */,
    zzms                 nvarchar(1000)       not null/* ֢״���� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    cyqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    cyyz                 nvarchar(1000)       null/* ��Ժҽ�� */,
    yzklysbm             varchar(20)          null/* ҽ������ҽʦ���� */,
    cyyzklrqm            varchar(50)          null/* ��Ժҽ��������ǩ�� */,
    cyyzklrq             datetime             null/* ��Ժҽ����������ʱ�� */,
    jzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    jzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL_CYXYZD     ��Ժ��¼��24Сʱ�����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL_CYXYZD') )
 create table  DC_RYJL_RCYJL_CYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czxyzdmc             varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    czxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL_CYZYZD     ��Ժ��¼��24Сʱ�����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL_CYZYZD') )
 create table  DC_RYJL_RCYJL_CYZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czzybmmc             varchar(128)         not null/* ��Ժ���-��ҽ�������� */,
    czzybmdm             varchar(64)          not null/* ��Ժ���-��ҽ�������� */,
    czzyzhmc             varchar(128)         not null/* ��Ժ���-��ҽ֤������ */,
    czzyzhdm             varchar(64)          not null/* ��Ժ���-��ҽ֤����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL_RYXYZD     ��Ժ��¼��24Сʱ�����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL_RYXYZD') )
 create table  DC_RYJL_RCYJL_RYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzxyzdmc             varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    rzxzzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL_RYZYZD     ��Ժ��¼��24Сʱ�����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL_RYZYZD') )
 create table  DC_RYJL_RCYJL_RYZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzzybmmc             varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    rzzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    rzzyzhmc             varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    rzzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RCYJL_ZYSZGCJG     ��Ժ��¼��24Сʱ�����Ժ��¼_��ҽ����۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RCYJL_ZYSZGCJG') )
 create table  DC_RYJL_RCYJL_ZYSZGCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL     ��Ժ��¼ �� 24Сʱ����Ժ������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL') )
 create table  DC_RYJL_RYSWJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    mz                   varchar(2)           null/* ���� */,
    mzmc                 varchar(32)          null/* �������� */,
    hyzkdm               varchar(2)           null/* ����״������ */,
    hyzkmc               varchar(32)          null/* ����״������ */,
    dzsf                 varchar(70)          not null/* ��ַ-ʡ����������ֱϽ�У� */,
    dzsq                 varchar(70)          not null/* ��ַ-�У��������ݣ� */,
    dzx                  varchar(70)          not null/* ��ַ-�أ����� */,
    dzxz                 varchar(70)          not null/* ��ַ-�磨�򡢽ֵ����´��� */,
    dzc                  varchar(70)          not null/* ��ַ-�壨�֡�·��Ū�ȣ� */,
    dzmphm               varchar(70)          not null/* ��ַ-���ƺ��� */,
    zylbdm               varchar(2)           null/* ְҵ������ */,
    zylbmc               varchar(50)          null/* ְҵ������� */,
    bscszxm              varchar(50)          not null/* ��ʷ���������� */,
    cszhzgxdm            varchar(2)           not null/* �������뻼�ߵĹ�ϵ���� */,
    cszhzgxmc            varchar(50)          not null/* �������뻼�ߵĹ�ϵ���� */,
    csnrbz               char(1)              not null/* �������ݿɿ���־ */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    swrq                 datetime             not null/* ��������ʱ�� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    swyy                 nvarchar(100)        not null/* ����ԭ�� */,
    jzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    jzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL_RYXYZD     ��Ժ��¼ �� 24Сʱ����Ժ������¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL_RYXYZD') )
 create table  DC_RYJL_RYSWJL_RYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzxyzdmc             varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    rzxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL_RYZYZD     ��Ժ��¼ �� 24Сʱ����Ժ������¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL_RYZYZD') )
 create table  DC_RYJL_RYSWJL_RYZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    rzzybmmc             varchar(128)         not null/* ��Ժ���-��ҽ�������� */,
    rzzybmdm             varchar(64)          not null/* ��Ժ���-��ҽ�������� */,
    rzzyzhmc             varchar(128)         not null/* ��Ժ���-��ҽ֤������ */,
    rzzyzhdm             varchar(64)          not null/* ��Ժ���-��ҽ֤����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL_SWXYZD     ��Ժ��¼ �� 24Сʱ����Ժ������¼_������ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL_SWXYZD') )
 create table  DC_RYJL_RYSWJL_SWXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    szxyzdmc             varchar(128)         not null/* �������-��ҽ������� */,
    szxyzdbm             varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL_SWZYZD     ��Ժ��¼ �� 24Сʱ����Ժ������¼_������ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL_SWZYZD') )
 create table  DC_RYJL_RYSWJL_SWZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    szzybmmc             varchar(128)         not null/* �������-��ҽ�������� */,
    szzybmdm             varchar(64)          not null/* �������-��ҽ�������� */,
    szzyzhmc             varchar(128)         not null/* �������-��ҽ֤������ */,
    szzyzhdm             varchar(64)          not null/* �������-��ҽ֤����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_RYJL_RYSWJL_ZYSZGCJG     ��Ժ��¼ �� 24Сʱ����Ժ������¼_��ҽ����۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_RYJL_RYSWJL_ZYSZGCJG') )
 create table  DC_RYJL_RYSWJL_ZYSZGCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZCJL_DCJL     ������¼ �� ������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZCJL_DCJL') )
 create table  DC_ZCJL_DCJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    cfxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    lxrxm                varchar(50)          not null/* ��ϵ������ */,
    lxrdh                varchar(20)          not null/* ��ϵ�˵绰 */,
    lxrhzgxdm            varchar(20)          not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    lxrhzgxmc            varchar(50)          not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    dcrqsj               datetime             not null/* ��������ʱ�� */,
    yc                   numeric(2)           not null/* �д� */,
    cc                   numeric(2)           not null/* ���� */,
    mcyjrq               date                 not null/* ĩ���¾����� */,
    syxsdm               varchar(2)           not null/* ������ʽ���� */,
    syxsmc               varchar(18)          not null/* ������ʽ���� */,
    ycq                  date                 not null/* Ԥ���� */,
    cqjcbz               char(1)              not null/* ��ǰ����־ */,
    cqjcycqk             varchar(200)         not null/* ��ǰ����쳣��� */,
    yqtzkg               numeric(6,2)         not null/* ��ǰ���أ�kg�� */,
    sgcm                 numeric(5,1)         not null/* ��ߣ�cm�� */,
    cqtzkg               numeric(6,2)         not null/* ����ǰ���أ�kg�� */,
    ccrstsqk             varchar(200)         not null/* �˴������������ */,
    jws                  varchar(1000)        not null/* ����ʷ */,
    sss                  varchar(1000)        not null/* ����ʷ */,
    jwycs                varchar(1000)        not null/* �����в�ʷ */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    ml                   numeric(3)           not null/* ���ʣ���/min�� */,
    hxl                  numeric(3)           not null/* ����Ƶ�ʣ���/min�� */,
    gdgdcm               numeric(4,1)         not null/* ���׸߶ȣ�cm�� */,
    fw                   numeric(5,1)         not null/* ��Χ��cm�� */,
    tfwdm                varchar(2)           not null/* ̥��λ���� */,
    tfwmc                varchar(18)          not null/* ̥��λ���� */,
    gjtetz               numeric(4)           not null/* ����̥������ */,
    txlc                 numeric(3)           not null/* ̥���ʣ���/min�� */,
    twncqkdpg            varchar(200)         not null/* ͷλ�Ѳ���������� */,
    ckhjcm               numeric(3,1)         not null/* ���ںᾶ��cm�� */,
    dcwjcm               numeric(4,1)         not null/* �����⾶��cm�� */,
    zgjjjjcm             numeric(4,1)         not null/* ���ǽ�ڼ侶��cm�� */,
    gsqk                 varchar(200)         not null/* ������� */,
    gjhd                 varchar(100)         not null/* ������� */,
    gkqk                 varchar(100)         not null/* ������� */,
    tmqkdm               varchar(2)           not null/* ̥Ĥ������� */,
    tmqkmc               varchar(18)          not null/* ̥Ĥ������� */,
    pmfsdm               varchar(2)           not null/* ��Ĥ��ʽ���� */,
    pmfsmc               varchar(12)          not null/* ��Ĥ��ʽ���� */,
    xlwz                 varchar(100)         not null/* ��¶λ�� */,
    ysqk                 varchar(100)         not null/* ��ˮ��� */,
    bgcybz               char(1)              not null/* ���׳�ӯ��־ */,
    czqbz                char(1)              not null/* ��������־ */,
    jcfsdm               varchar(2)           not null/* ��鷽ʽ���� */,
    jcfsmc               varchar(18)          not null/* ��鷽ʽ���� */,
    czjh                 varchar(2000)        not null/* ���üƻ� */,
    jhxqdfmfs            varchar(2)           not null/* �ƻ�ѡȡ�ķ��䷽ʽ���� */,
    jhxqdfmfsmc          varchar(18)          not null/* �ƻ�ѡȡ�ķ��䷽ʽ���� */,
    ccjlrqsj             datetime             not null/* ���̼�¼����ʱ�� */,
    ccjg                 varchar(200)         not null/* ���̾��� */,
    ccjczdm              varchar(20)          not null/* ���̼���߹��� */,
    ccjczqm              varchar(50)          not null/* ���̼����ǩ�� */,
    zzysdm               varchar(20)          not null/* ����ҽ������ */,
    zzysqm               varchar(50)          not null/* ����ҽ������ */,
    jlrdm                varchar(20)          not null/* ��¼��Ա���� */,
    jlrqm                varchar(50)          not null/* ��¼��Աǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZCJL_PGC     ������¼ �� �ʹ�����¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZCJL_PGC') )
 create table  DC_ZCJL_PGC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    cfxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    dcrqsj               datetime             not null/* ��������ʱ�� */,
    cqzdmc               varchar(200)         not null/* ��ǰ��� */,
    sszz                 varchar(500)         not null/* ����ָ�� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssjczmc              varchar(128)         not null/* �������������� */,
    ssksrqsj             datetime             not null/* ������ʼ����ʱ�� */,
    mzffdm               varchar(2)           not null/* ���������� */,
    mzffmc               varchar(100)         not null/* ���������� */,
    mztw                 varchar(100)         not null/* ������λ */,
    mzxg                 varchar(100)         not null/* ����Ч�� */,
    pgcssgc              varchar(2000)        not null/* �ʹ����������� */,
    zgqk                 varchar(100)         not null/* �ӹ���� */,
    temcfsdm             varchar(11)          not null/* ̥��������� */,
    temcfsmc             varchar(100)         not null/* ̥�������ʽ */,
    ysxz                 varchar(100)         not null/* ��ˮ��״ */,
    ysl                  numeric(5)           not null/* ��ˮ����mL�� */,
    tpwcrqsj             datetime             not null/* ̥���������ʱ�� */,
    tpmcqk               varchar(100)         not null/* ̥�������� */,
    tmwzqkbz             char(1)              not null/* ̥Ĥ���������־ */,
    rjsz                 numeric(3)           not null/* �ƾ����ܣ� */,
    qdcdcm               numeric(5)           not null/* ������ȣ�cm�� */,
    qdycqkms             varchar(200)         not null/* ����쳣������� */,
    cqdxqkbz             char(1)              not null/* �����Ѫ�����־ */,
    zgbfhqk              varchar(100)         not null/* �ӹ��ڷ����� */,
    gsjmc                varchar(50)          not null/* ���������� */,
    gsjsyff              varchar(100)         not null/* ������ʹ�÷��� */,
    temohs               varchar(100)         not null/* ̥Ĥ��Ⱦ */,
    tepanhs              varchar(100)         not null/* ̥�̻�Ⱦ */,
    tfwdm                varchar(20)          not null/* ̥��λ���� */,
    tfwmc                varchar(50)          not null/* ̥��λ���� */,
    ssyy                 varchar(50)          not null/* ������ҩ */,
    ssyyl                varchar(50)          not null/* ������ҩ�� */,
    fqtczg               varchar(100)         not null/* ��ǻ̽���ӹ� */,
    fqtcfj               varchar(100)         not null/* ��ǻ̽�鸽�� */,
    gqtcycqkbz           char(1)              not null/* ��ǻ̽���쳣�����־ */,
    gqtcjlbz             char(1)              not null/* ��ǻ̽�鼡����־ */,
    gqtcycqkms           varchar(1000)        not null/* ��ǻ̽���쳣������� */,
    gqtcclqk             varchar(100)         not null/* ��ǻ̽�鴦����� */,
    ssscfqk              varchar(1000)        not null/* ����ʱ������� */,
    cxlml                numeric(5)           not null/* ��Ѫ����mL�� */,
    sxcf                 varchar(100)         not null/* ��Ѫ�ɷ� */,
    sxlml                numeric(4)           not null/* ��Ѫ����mL�� */,
    sylml                numeric(5)           not null/* ��Һ����mL�� */,
    gysjmin              numeric(4)           not null/* ����ʱ�䣨min�� */,
    qtyy                 varchar(50)          not null/* ������ҩ */,
    qtqk                 varchar(100)         not null/* ������ҩ��� */,
    ssjsrqsj             datetime             not null/* ������������ʱ�� */,
    ssqcsjmin            numeric(4)           not null/* ����ȫ��ʱ�䣨min�� */,
    shzdmc               varchar(200)         not null/* ������� */,
    shgcrqsj             datetime             not null/* ����۲�����ʱ�� */,
    shjcmin              numeric(3)           not null/* ������ʱ�䣨min�� */,
    chssymmhg            numeric(3)           not null/* ��������ѹ��mmHg �� */,
    chszymmhg            numeric(3)           not null/* ��������ѹ��mmHg �� */,
    chmbc                numeric(3)           not null/* ������������/min �� */,
    chxlc                numeric(3)           not null/* �������ʣ���/min �� */,
    chcxlml              numeric(5)           not null/* �����Ѫ����mL�� */,
    chgs                 varchar(200)         not null/* ������ */,
    chgdgdcm             numeric(4,1)         not null/* ���󹬵׸߶ȣ�cm�� */,
    jdcsqk               varchar(100)         not null/* ���������� */,
    xsexbdm              varchar(4)           not null/* �������Ա���� */,
    xsexbmc              varchar(20)          not null/* �������Ա����� */,
    xsecstzg             numeric(4)           not null/* �������������أ�g�� */,
    xsecssccm            numeric(5,1)         not null/* ��������������cm�� */,
    jdnzzs               numeric(5)           not null/* ���Ťת���ܣ� */,
    cldx                 varchar(100)         not null/* ������С */,
    clbw                 varchar(100)         not null/* ������λ */,
    aafsm                varchar(10)          not null/* Apgar���ּ��ʱ����� */,
    aafmc                varchar(18)          not null/* Apgar���ּ��ʱ������ */,
    apgarpfz             numeric(2)           not null/* Apgar����ֵ */,
    fmjjdm               varchar(10)          not null/* �����ִ��� */,
    fmjjmc               varchar(100)         not null/* ���������� */,
    xseycqkdm            varchar(10)          not null/* �������쳣������� */,
    xseycqkmc            varchar(100)         not null/* �������쳣������� */,
    sszdm                varchar(20)          not null/* ����ҽ������ */,
    sszqm                varchar(50)          not null/* ����ҽ��ǩ�� */,
    mzysdm               varchar(20)          not null/* ����ҽ������ */,
    mzysqm               varchar(50)          not null/* ����ҽ��ǩ�� */,
    qxhsdm               varchar(20)          not null/* ��е��ʿ���� */,
    qxhsqm               varchar(50)          not null/* ��е��ʿǩ�� */,
    zsdm                 varchar(20)          not null/* �������ֹ��� */,
    zsqm                 varchar(50)          not null/* ��������ǩ�� */,
    ekysdm               varchar(20)          not null/* ����ҽ������ */,
    ekysqm               varchar(50)          not null/* ����ҽ��ǩ�� */,
    zdysdm               varchar(20)          not null/* ָ���߹��� */,
    zdysqm               varchar(50)          not null/* ָ����ǩ�� */,
    hyzdm                varchar(20)          not null/* ��Ӥ�߹��� */,
    hyzqm                varchar(50)          not null/* ��Ӥ��ǩ�� */,
    jlrdm                varchar(20)          not null/* ��¼��Ա���� */,
    jlrqm                varchar(50)          not null/* ��¼��Աǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZCJL_YDFM     ������¼ �� ��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZCJL_YDFM') )
 create table  DC_ZCJL_YDFM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    cfxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    yc                   numeric(2)           not null/* �д� */,
    cc                   numeric(2)           not null/* ���� */,
    mcyjrq               datetime             not null/* ĩ���¾����� */,
    ycq                  date                 not null/* Ԥ���� */,
    lcrqsj               datetime             not null/* �ٲ�����ʱ�� */,
    tmplrqsj             datetime             not null/* ̥Ĥ��������ʱ�� */,
    zdmc                 varchar(200)         not null/* ��Ժ��� */,
    chpgcybz             char(1)              not null/* ������׳�ӯ��־ */,
    qysxz                varchar(100)         not null/* ǰ��ˮ��״ */,
    qyslml               numeric(5)           not null/* ǰ��ˮ����mL�� */,
    gsksrqsj             datetime             not null/* ������ʼ����ʱ�� */,
    d1ccsc               numeric(4)           not null/* ��1����ʱ����min�� */,
    gkkqrqsj             datetime             not null/* ���ڿ�ȫ����ʱ�� */,
    d2ccsc               numeric(4)           not null/* ��2����ʱ����min�� */,
    temcrqsj             datetime             not null/* ̥���������ʱ�� */,
    d3ccsc               numeric(4)           not null/* ��3����ʱ����min�� */,
    tpmcrqsj             datetime             not null/* ̥���������ʱ�� */,
    zccsc                numeric(4)           not null/* �ܲ���ʱ����min�� */,
    tfwdm                varchar(2)           not null/* ̥��λ���� */,
    tfwmc                varchar(50)          not null/* ̥��λ���� */,
    temczcbz             char(1)              not null/* ̥�����������־ */,
    zcfs                 varchar(100)         not null/* ������ʽ */,
    tpmcqk               varchar(100)         not null/* ̥�������� */,
    tmwzqkbz             char(1)              not null/* ̥Ĥ���������־ */,
    ysxz                 varchar(100)         not null/* ��ˮ��״ */,
    yslml                numeric(5)           not null/* ��ˮ����mL�� */,
    qdcdcm               numeric(5)           not null/* ������ȣ�cm�� */,
    rjsz                 numeric(3)           not null/* �ƾ����ܣ� */,
    qdycqkbz             char(1)              not null/* ����쳣�����־ */,
    qdycqkms             varchar(200)         not null/* ����쳣������� */,
    csyy                 varchar(50)          not null/* ��ʱ��ҩ */,
    yfcs                 varchar(200)         not null/* Ԥ����ʩ */,
    cfhyqkbz             char(1)              not null/* ���������п���־ */,
    hyqkwz               varchar(100)         not null/* �����п�λ�� */,
    cfhyfhzs             numeric(2)           not null/* ��������������� */,
    cfhylscdmc           varchar(100)         not null/* ����������� */,
    cfhylscddm           varchar(2)           not null/* ��������������� */,
    hyxzbz               char(1)              not null/* ����Ѫ�ױ�־ */,
    hyxzdx               varchar(50)          not null/* ����Ѫ�״�С */,
    hyxzcl               varchar(200)         not null/* ����Ѫ�״��� */,
    mzffdm               varchar(2)           not null/* ���������� */,
    mzffmc               varchar(50)          not null/* ���������� */,
    mzywdm               varchar(32)          not null/* ����ҩ����� */,
    mzywmc               varchar(128)         not null/* ����ҩ������ */,
    ydlsbz               char(1)              not null/* �������˱�־ */,
    ydxzbz               char(1)              not null/* ����Ѫ�ױ�־ */,
    ydxzdx               varchar(50)          not null/* ����Ѫ�״�С */,
    gjlsbz               char(1)              not null/* �������˱�־ */,
    ydzcbz               char(1)              not null/* ����������־ */,
    ydzcfs               varchar(100)         not null/* ����������ʽ */,
    ydxzcl               varchar(100)         not null/* ����Ѫ�״��� */,
    gjfhqk               varchar(100)         not null/* ���������� */,
    chyy                 varchar(50)          not null/* ������ҩ */,
    fmgczy               varchar(200)         not null/* �������ժҪ */,
    gsqk                 varchar(200)         not null/* ������� */,
    zgqk                 varchar(100)         not null/* �ӹ���� */,
    elzk                 varchar(100)         not null/* ��¶״�� */,
    hyqk                 varchar(100)         not null/* ������� */,
    xbssgc               varchar(100)         not null/* �޲��������� */,
    cqdxqkbz             char(1)              not null/* �����Ѫ�����־ */,
    chzdmc               varchar(200)         not null/* ������� */,
    chgcrqsj             datetime             not null/* ����۲�����ʱ�� */,
    chjcsj               numeric(3)           not null/* ������ʱ�䣨min�� */,
    chssy                numeric(3)           not null/* ��������ѹ��mmHg �� */,
    chszy                numeric(3)           not null/* ��������ѹ��mmHg �� */,
    chmbc                numeric(3)           not null/* ������������/min �� */,
    chxlc                numeric(3)           not null/* �������ʣ���/min �� */,
    chcxl                numeric(5)           not null/* �����Ѫ����mL�� */,
    chgs                 varchar(200)         not null/* ������ */,
    chgdgd               numeric(4,1)         not null/* ���󹬵׸߶ȣ�cm�� */,
    gc                   varchar(100)         not null/* �ز� */,
    xsexbdm              varchar(2)           not null/* �������Ա���� */,
    xsexbmc              varchar(100)         not null/* �������Ա����� */,
    xsecstzg             numeric(4)           not null/* �������������أ�g�� */,
    xsecssccm            numeric(5,1)         not null/* ��������������cm�� */,
    cldx                 varchar(100)         not null/* ������С */,
    clbw                 varchar(100)         not null/* ������λ */,
    aafsm                varchar(2)           not null/* Apgar���ּ��ʱ����� */,
    aafsmc               varchar(100)         not null/* Apgar���ּ��ʱ�� */,
    apgarpfz             numeric(2)           not null/* Apgar����ֵ */,
    fmjjdm               varchar(2)           not null/* �����ִ��� */,
    fmjjmc               varchar(100)         not null/* ���������� */,
    xseycqkdm            varchar(2)           not null/* �������쳣������� */,
    fmgctsqkms           varchar(200)         not null/* ������������������ */,
    xseycqkmc            varchar(100)         not null/* �������쳣������� */,
    ssysdm               varchar(20)          not null/* ����ҽ������ */,
    ssysqm               varchar(50)          not null/* ����ҽ��ǩ�� */,
    jszdm                varchar(20)          not null/* ������Ա���� */,
    jszqm                varchar(50)          not null/* ������Աǩ�� */,
    zczdm                varchar(20)          not null/* �����߹��� */,
    zczqm                varchar(50)          not null/* ������ǩ�� */,
    zsdm                 varchar(20)          not null/* ���ֹ��� */,
    zsqm                 varchar(50)          not null/* ����ǩ�� */,
    ekysdm               varchar(20)          not null/* ����ҽ������ */,
    ekysqm               varchar(50)          not null/* ����ҽ��ǩ�� */,
    hyzdm                varchar(20)          not null/* ��Ӥ�߹��� */,
    hyzqm                varchar(50)          not null/* ��Ӥ��ǩ�� */,
    zdzdm                varchar(20)          not null/* ָ���߹��� */,
    zdzqm                varchar(50)          not null/* ָ����ǩ�� */,
    jlrdm                varchar(20)          not null/* ��¼��Ա���� */,
    jlrqm                varchar(50)          not null/* ��¼��Աǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL     һ�����ƴ��ü�¼ �� �����¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL') )
 create table  DC_ZLCZJL_MZJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tzkg                 numeric(6,2)         null/* ���أ�kg�� */,
    abo                  varchar(2)           not null/* ABOѪ�ʹ��� */,
    abomc                varchar(18)          not null/* ABOѪ������ */,
    rh                   varchar(2)           not null/* RhѪ�ʹ��� */,
    rhmc                 varchar(18)          not null/* RhѪ������ */,
    ml                   numeric(3)           not null/* ���ʣ���/min�� */,
    csssrqsj             datetime             not null/* ������������ʱ�� */,
    sxrqsj               datetime             null/* ��Ѫ����ʱ�� */,
    sxpzdm               varchar(2)           null/* ��ѪƷ�ִ��� */,
    sxpzmc               varchar(50)          null/* ��ѪƷ������ */,
    sxlml                numeric(4)           null/* ��Ѫ����mL�� */,
    sxljldw              varchar(10)          null/* ��Ѫ��������λ */,
    sxfybz               char(1)              null/* ��Ѫ��Ӧ��־ */,
    szsyxm               varchar(50)          null/* ������Һ��Ŀ */,
    cxl                  numeric(5)           null/* ��Ѫ����mL�� */,
    hzqxdm               varchar(2)           null/* ����ȥ����� */,
    hzqxmc               varchar(64)          null/* ����ȥ������ */,
    mzysdm               varchar(50)          not null/* ����ҽʦ���� */,
    mzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_CGJCXM     һ�����ƴ��ü�¼ �� �����¼_��������Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_CGJCXM') )
 create table  DC_ZLCZJL_MZJL_CGJCXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    cgjcxmmc             varchar(100)         not null/* ��������Ŀ���� */,
    cgjcxmjg             varchar(200)         not null/* ��������Ŀ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_HXPLMX     һ�����ƴ��ü�¼ �� �����¼_����Ƶ����ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_HXPLMX') )
 create table  DC_ZLCZJL_MZJL_HXPLMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    hxl                  numeric(3)           not null/* ����Ƶ�ʣ���/min�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_MZMX     һ�����ƴ��ü�¼ �� �����¼_������ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_MZMX') )
 create table  DC_ZLCZJL_MZJL_MZMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    mzffdm               varchar(2)           not null/* ���������� */,
    mzffmc               varchar(18)          not null/* ���������� */,
    qgcgfl               varchar(100)         null/* ���ܲ�ܷ��� */,
    mzywdm               varchar(10)          not null/* ����ҩ����� */,
    mzywmc               varchar(50)          not null/* ����ҩ������ */,
    mztw                 varchar(100)         not null/* ������λ */,
    asafjbzdm            varchar(2)           not null/* ASA�ּ���׼���� */,
    asafjbzmc            varchar(32)          not null/* ASA�ּ���׼���� */,
    mzxg                 varchar(100)         not null/* ����Ч�� */,
    mzqyy                varchar(100)         not null/* ����ǰ��ҩ */,
    mzksrqsj             datetime             not null/* ����ʼ����ʱ�� */,
    hxlxdm               varchar(2)           not null/* �������ʹ��� */,
    hxlxmc               varchar(32)          not null/* ������������ */,
    mzms                 varchar(200)         not null/* �������� */,
    mzhbzbzdm            varchar(2)           not null/* ����ϲ�֢��־���� */,
    mzhbzbzmc            varchar(32)          not null/* ����ϲ�֢��־���� */,
    ccgc                 varchar(2000)        null/* ���̹��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_SHZD     һ�����ƴ��ü�¼ �� �����¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_SHZD') )
 create table  DC_ZLCZJL_MZJL_SHZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    shzdbm               varchar(64)          not null/* ������ϱ��� */,
    shzdmc               varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_SQZD     һ�����ƴ��ü�¼ �� �����¼_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_SQZD') )
 create table  DC_ZLCZJL_MZJL_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_SSJL     һ�����ƴ��ü�¼ �� �����¼_������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_SSJL') )
 create table  DC_ZLCZJL_MZJL_SSJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    ssjbh                varchar(20)          not null/* �������� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssjczmc              varchar(128)         not null/* �������������� */,
    sstwdm               varchar(2)           not null/* ������λ���� */,
    sstwmc               varchar(50)          not null/* ������λ���� */,
    ssksrqsj             datetime             not null/* ������ʼ����ʱ�� */,
    ssjsrqsj             datetime             not null/* ������������ʱ�� */,
    sszdm                varchar(50)          not null/* �����߹��� */,
    sszxm                varchar(50)          not null/* ���������� */,
    zlgcms               varchar(2000)        not null/* ���ƹ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_TSJCXM     һ�����ƴ��ü�¼ �� �����¼_��������Ŀ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_TSJCXM') )
 create table  DC_ZLCZJL_MZJL_TSJCXM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    tsjcxmmc             varchar(200)         not null/* ��������Ŀ���� */,
    tsjcxmjg             varchar(200)         not null/* ��������Ŀ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_TWMX     һ�����ƴ��ü�¼ �� �����¼_������ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_TWMX') )
 create table  DC_ZLCZJL_MZJL_TWMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    tw                   numeric(4,1)         not null/* ���£��棩 */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_XLMX     һ�����ƴ��ü�¼ �� �����¼_������ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_XLMX') )
 create table  DC_ZLCZJL_MZJL_XLMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    xlc                  numeric(3)           not null/* ���ʣ���/min�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_XYMX     һ�����ƴ��ü�¼ �� �����¼_Ѫѹ��ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_XYMX') )
 create table  DC_ZLCZJL_MZJL_XYMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    ssy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    szy                  numeric(3)           not null/* ����ѹ��mmHg�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZJL_YWSY     һ�����ƴ��ü�¼ �� �����¼_ҩ��ʹ����ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZJL_YWSY') )
 create table  DC_ZLCZJL_MZJL_YWSY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    ywdm                 varchar(50)          not null/* ҩ����� */,
    ywmc                 varchar(50)          not null/* ҩ������ */,
    ywyf                 varchar(100)         not null/* ҩ���÷� */,
    ywsypl               varchar(2)           not null/* ҩ��ʹ��Ƶ�� */,
    ywsypldm             varchar(18)          not null/* ҩ��ʹ�ü������� */,
    ywsyjldw             varchar(6)           not null/* ҩ��ʹ�ü�����λ */,
    ywsycjl              numeric(5,2)         not null/* ҩ��ʹ�ôμ��� */,
    ywsyzjl              numeric(12,2)        not null/* ҩ��ʹ���ܼ��� */,
    ywsytjdm             numeric(3)           not null/* ҩ��ʹ��;������ */,
    ywsytjmc             varchar(18)          not null/* ҩ��ʹ��;������ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSHFSJL     һ�����ƴ��ü�¼ �� ����������Ӽ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSHFSJL') )
 create table  DC_ZLCZJL_MZSHFSJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqsbh              varchar(20)          not null/* �������뵥��� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tz                   numeric(6,2)         not null/* ���أ�kg�� */,
    aboxx                varchar(2)           null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          null/* ABOѪ������ */,
    rhxx                 varchar(2)           null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          null/* RhѪ������ */,
    ybzkjcjg             nvarchar(1000)       not null/* һ��״������� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssjczmc              varchar(128)         not null/* �������������� */,
    mzff                 varchar(2)           not null/* ���������� */,
    mzffmc               varchar(30)          not null/* ���������� */,
    mzhfqk               nvarchar(100)        not null/* ����ָ���� */,
    qxrqsj               datetime             not null/* ��������ʱ�� */,
    bcqgcgbz             char(1)              null/* �γ����ܲ�ܱ�־ */,
    mzsyz                nvarchar(100)        not null/* ������Ӧ֤ */,
    ysbm                 varchar(20)          null/* ҽ������ */,
    mzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSHFSJL_SHZD     һ�����ƴ��ü�¼ �� ����������Ӽ�¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSHFSJL_SHZD') )
 create table  DC_ZLCZJL_MZSHFSJL_SHZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    dzsqsbh              varchar(20)          not null/* �������뵥��� */,
    shzdbm               varchar(64)          not null/* ������ϱ��� */,
    shzdmc               varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSHFSJL_SQZD     һ�����ƴ��ü�¼ �� ����������Ӽ�¼_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSHFSJL_SQZD') )
 create table  DC_ZLCZJL_MZSHFSJL_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    dzsqsbh              varchar(20)          not null/* �������뵥��� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    

	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSHFSJL_TSQK     һ�����ƴ��ü�¼ �� ����������Ӽ�¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSHFSJL_TSQK') )
 create table  DC_ZLCZJL_MZSHFSJL_TSQK (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    tsqk                 nvarchar(1000)       null/* ������� */,
    
   
    

	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSQFSJL     һ�����ƴ��ü�¼ �� ������ǰ���Ӽ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSQFSJL') )
 create table  DC_ZLCZJL_MZSQFSJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqsbh              varchar(20)          not null/* �������뵥��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tz                   numeric(6,2)         null/* ���أ�kg�� */,
    aboxx                varchar(2)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          not null/* ABOѪ������ */,
    rhxx                 varchar(2)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          not null/* RhѪ������ */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    sqhbjb               nvarchar(100)        null/* ��ǰ�ϲ����� */,
    jybs                 nvarchar(100)        not null/* ��Ҫ��ʷ */,
    xdtjcjg              nvarchar(100)        null/* �ĵ�ͼ����� */,
    xbxxjc               nvarchar(100)        null/* �ز�X�߼���� */,
    ctjcjg               nvarchar(100)        null/* CT����� */,
    bcjcjg               nvarchar(100)        null/* B������� */,
    mricjc               nvarchar(1000)       null/* MRI������� */,
    fgnjcjg              nvarchar(1000)       null/* �ι��ܼ���� */,
    xcgjcjg              nvarchar(1000)       null/* Ѫ�������� */,
    ncgjcjg              nvarchar(100)        null/* �򳣹����� */,
    nxgnjc               nvarchar(100)        null/* ��Ѫ���ܼ���� */,
    ggnjcjg              nvarchar(100)        null/* �ι��ܼ���� */,
    xqfxjc               nvarchar(1000)       null/* Ѫ����������� */,
    jsztzcbz             char(1)              null/* ����״̬������־ */,
    xztzjg               nvarchar(100)        null/* ���������� */,
    fbtzjg               nvarchar(100)        null/* �β������� */,
    szjcjg               nvarchar(1000)       null/* ��֫����� */,
    jzjcjg               nvarchar(1000)       null/* ��������� */,
    fbjcjg               nvarchar(1000)       null/* ��������� */,
    qgjcjg               nvarchar(100)        null/* ���ܼ���� */,
    ycjcjg               nvarchar(100)        null/* ���ݼ���� */,
    mzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSQFSJL_GMS     һ�����ƴ��ü�¼ �� ������ǰ���Ӽ�¼_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSQFSJL_GMS') )
 create table  DC_ZLCZJL_MZSQFSJL_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    gms                  nvarchar(1000)       null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSQFSJL_NMZFF     һ�����ƴ��ü�¼ �� ������ǰ���Ӽ�¼_��ʵʩ������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSQFSJL_NMZFF') )
 create table  DC_ZLCZJL_MZSQFSJL_NMZFF (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    nmzffdm              varchar(2)           not null/* ��ʵʩ���������� */,
    nmzffmc              varchar(30)          not null/* ��ʵʩ���������� */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    sqmzyz               nvarchar(1000)       not null/* ��ǰ����ҽ�� */,
    mzsyz                nvarchar(100)        not null/* ������Ӧ֤ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSQFSJL_NSSCZ     һ�����ƴ��ü�¼ �� ������ǰ���Ӽ�¼_��ʵʩ����������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSQFSJL_NSSCZ') )
 create table  DC_ZLCZJL_MZSQFSJL_NSSCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    nssczbm              varchar(64)          not null/* ��ʵʩ�������������� */,
    nssczmc              varchar(128)         not null/* ��ʵʩ�������������� */,
    ssjbh                varchar(20)          not null/* �������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_MZSQFSJL_YBZKJCJG     һ�����ƴ��ü�¼ �� ������ǰ���Ӽ�¼_һ��״�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_MZSQFSJL_YBZKJCJG') )
 create table  DC_ZLCZJL_MZSQFSJL_YBZKJCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    ybzkjc               nvarchar(1000)       null/* һ��״������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_SXJL     һ�����ƴ��ü�¼ �� ��Ѫ��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_SXJL') )
 create table  DC_ZLCZJL_SXJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    aboxx                varchar(2)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          not null/* ABOѪ������ */,
    rhxx                 varchar(2)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          not null/* RhѪ������ */,
    sxsbz                char(1)              not null/* ��Ѫʷ��ʶ���� */,
    sxsbzmc              varchar(64)          not null/* ��Ѫʷ��ʶ���� */,
    sxxzdm               varchar(2)           not null/* ��Ѫ���ʴ��� */,
    sxxzmc               varchar(18)          not null/* ��Ѫ�������� */,
    sqaboxx              varchar(2)           not null/* ����ABOѪ�ʹ��� */,
    sqaboxxmc            varchar(18)          not null/* ����ABOѪ������ */,
    sqrhxx               varchar(2)           not null/* ����RhѪ�ʹ��� */,
    sqrhxxmc             varchar(18)          not null/* ����RhѪ������ */,
    sxzz                 nvarchar(500)        not null/* ��Ѫָ�� */,
    sxgcjl               nvarchar(2000)       not null/* ��Ѫ���̼�¼ */,
    sxpzdm               varchar(2)           not null/* ��ѪƷ�ִ��� */,
    sxpzmc               varchar(50)          not null/* ��ѪƷ������ */,
    xdbm                 varchar(10)          not null/* Ѫ������ */,
    sxl                  numeric(4)           not null/* ��Ѫ����mL�� */,
    sxljldw              varchar(10)          not null/* ��Ѫ��������λ */,
    sxfybz               char(1)              not null/* ��Ѫ��Ӧ��־ */,
    sxfylx               varchar(2)           not null/* ��Ѫ��Ӧ���� */,
    sxfylxmc             varchar(18)          not null/* ��Ѫ��Ӧ�������� */,
    sxcs                 int                  not null/* ��Ѫ���� */,
    sxrqsj               datetime             not null/* ��Ѫ����ʱ�� */,
    sxyy                 nvarchar(100)        not null/* ��Ѫԭ�� */,
    ysbm                 varchar(20)          not null/* ҽʦ���� */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_SXJL_JBZD     һ�����ƴ��ü�¼ �� ��Ѫ��¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_SXJL_JBZD') )
 create table  DC_ZLCZJL_SXJL_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
   
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_YBSSJL     һ�����ƴ��ü�¼ ��һ��������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_YBSSJL') )
 create table  DC_ZLCZJL_YBSSJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqsbh              varchar(20)          not null/* �������뵥��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    shzdbm               varchar(64)          not null/* ������ϱ��� */,
    shzdmc               varchar(128)         not null/* ����������� */,
    ssmbbwdm             varchar(100)         null/* ����Ŀ�겿λ���� */,
    ssmbbw               varchar(500)         null/* ����Ŀ�겿λ���� */,
    jrwdm                varchar(100)         null/* ��������� */,
    jrwmc                nvarchar(500)        null/* ���������� */,
    sstw                 varchar(2)           null/* ������λ���� */,
    sstwmc               varchar(64)          null/* ������λ���� */,
    ssgc                 nvarchar(2000)       null/* ������������ */,
    sssbz                char(1)              null/* ����ʷ��־ */,
    pfxd                 nvarchar(200)        null/* Ƥ���������� */,
    ssqk                 nvarchar(200)        null/* �����п����� */,
    ylbz                 char(1)              null/* ������־ */,
    cxl                  numeric(5)           null/* ��Ѫ����mL�� */,
    syl                  numeric(5)           null/* ��Һ����mL�� */,
    sxl                  numeric(4)           null/* ��Ѫ����mL�� */,
    ylcldm               varchar(100)         null/* �������ϴ��� */,
    ylclmc               nvarchar(500)        null/* ������������ */,
    ylclsm               nvarchar(200)        null/* ����������Ŀ */,
    fzbwdm               varchar(64)          null/* ���ò�λ���� */,
    fzbw                 varchar(128)         null/* ���ò�λ */,
    sxfybz               char(1)              null/* ��Ѫ��Ӧ��־ */,
    sszbm                varchar(20)          not null/* ����ҽ������ */,
    sszxm                varchar(50)          not null/* ����ҽ������ */,
    mzff                 varchar(2)           not null/* ���������� */,
    mzffmc               varchar(30)          not null/* ���������� */,
    mzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysxm               varchar(50)          not null/* ����ҽʦ���� */,
    qmrqsj               datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_YBSSJL_SQYY     һ�����ƴ��ü�¼ ��һ��������¼_��ǰ��ҩ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_YBSSJL_SQYY') )
 create table  DC_ZLCZJL_YBSSJL_SQYY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    sqyydm               varchar(100)         null/* ��ǰ��ҩ���� */,
    sqyy                 nvarchar(500)        null/* ��ǰ��ҩ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_YBSSJL_SSMX     һ�����ƴ��ü�¼ ��һ��������¼_������ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_YBSSJL_SSMX') )
 create table  DC_ZLCZJL_YBSSJL_SSMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    ssjbh                varchar(20)          not null/* �������� */,
    ssksrq               datetime             not null/* ������ʼ����ʱ�� */,
    ssjsrq               datetime             not null/* ������������ʱ�� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssmc                 varchar(128)         not null/* �������� */,
    ssjbdm               varchar(2)           not null/* ����������� */,
    ssjbmc               varchar(18)          not null/* ������������ */,
    yzbm                 varchar(20)          not null/* �������� */,
    yzxm                 varchar(50)          not null/* �������� */,
    ezbm                 varchar(20)          not null/* �������� */,
    ezxm                 varchar(50)          not null/* �������� */,
    qxhsbm               varchar(20)          not null/* ��е��ʿ���� */,
    qxhsxm               varchar(50)          not null/* ��е��ʿ���� */,
    xthsbm               varchar(20)          not null/* Ѳ̨��ʿ���� */,
    xthsxm               varchar(50)          not null/* Ѳ̨��ʿ���� */,
    ssysbm               varchar(20)          not null/* �����߹��� */,
    sszqm                varchar(50)          not null/* ������ǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_YBSSJL_SZYY     һ�����ƴ��ü�¼ ��һ��������¼_������ҩ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_YBSSJL_SZYY') )
 create table  DC_ZLCZJL_YBSSJL_SZYY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    szyydm               varchar(100)         null/* ������ҩ���� */,
    szyy                 nvarchar(500)        null/* ������ҩ */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_ZLJL     ���ƴ��ü�¼�����Ƽ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_ZLJL') )
 create table  DC_ZLCZJL_ZLJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tz                   numeric(6,2)         null/* ���أ�kg�� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    cljzdyj              nvarchar(2000)       null/* ����ָ����� */,
    yczlczbz             char(1)              null/* �д����Ʋ�����־ */,
    gmsbz                char(1)              null/* ����ʷ��־ */,
    gms                  nvarchar(1000)       null/* ����ʷ */,
    yzsybz               nvarchar(100)        null/* ҽ��ʹ�ñ�ע */,
    jhzlfa               nvarchar(1000)       null/* ������Ʒ��� */,
    sffsdm               varchar(2)           null/* ��÷�ʽ���� */,
    sffsmc               varchar(18)          null/* ��÷�ʽ���� */,
    sfrq                 date                 null/* ������� */,
    sfzqjy               varchar(2)           null/* ������ڽ������ */,
    sfzqjymc             varchar(20)          null/* ������ڽ������� */,
    yzzxzdm              varchar(20)          not null/* ҽ��ִ���߹��� */,
    yzzxzqm              varchar(50)          not null/* ҽ��ִ����ǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_ZLJL_SSCZ     ���ƴ��ü�¼�����Ƽ�¼_��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_ZLJL_SSCZ') )
 create table  DC_ZLCZJL_ZLJL_SSCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czbm                 varchar(64)          null/* �������� */,
    czmc                 varchar(128)         null/* �������� */,
    czmbbw               varchar(64)          null/* ����Ŀ�겿λ���� */,
    czmbbwmc             varchar(128)         null/* ����Ŀ�겿λ���� */,
    jrwdm                varchar(64)          null/* ��������� */,
    jrwmc                sysname              null/* ���������� */,
    czffms               nvarchar(2000)       null/* ������������ */,
    czcs                 int                  null/* �������� */,
    czrq                 datetime             null/* ��������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZLCZJL_ZLJL_YYMX     ���ƴ��ü�¼�����Ƽ�¼_��ҩ��ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZLCZJL_ZLJL_YYMX') )
 create table  DC_ZLCZJL_ZLJL_YYMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywdm                 varchar(64)          null/* ҩ����� */,
    ywmc                 varchar(128)         null/* ҩ������ */,
    ywyf                 varchar(128)         null/* ҩ���÷� */,
    zysylb               varchar(2)           null/* ��ҩʹ�������� */,
    zysylbmc             varchar(18)          null/* ��ҩʹ��������� */,
    ywsypl               varchar(2)           null/* ҩ��ʹ��Ƶ�� */,
    ywsyplmc             varchar(10)          null/* ҩ��ʹ��Ƶ������ */,
    ywjxdm               varchar(2)           null/* ҩ����ʹ��� */,
    ywjx                 varchar(50)          null/* ҩ����� */,
    ywsyjldw             varchar(6)           null/* ҩ��ʹ�ü�����λ */,
    ywsycjl              numeric(5,2)         null/* ҩ��ʹ�ôμ��� */,
    ywsyzjl              numeric(12,2)        null/* ҩ��ʹ���ܼ��� */,
    ywsytj               varchar(3)           null/* ҩ��ʹ��;������ */,
    ywsytjmc             varchar(20)          null/* ҩ��ʹ��;�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_BWZTZS     ֪���֪��Ϣ����Σ���أ�֪ͨ��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_BWZTZS') )
 create table  DC_ZQGZXX_BWZTZS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    tysbh                varchar(20)          not null/* ֪��ͬ������ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    bqgkjqjcs            nvarchar(2000)       not null/* �����������Ҫ���ȴ�ʩ */,
    tznr                 nvarchar(1000)       not null/* ��Σ���أ�֪ͨ���� */,
    tzrq                 datetime             not null/* ��Σ���أ�֪ͨ����ʱ�� */,
    dlrqm                varchar(50)          null/* ����������ǩ�� */,
    dlrhzgxdm            varchar(2)           null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrhzgxmc            varchar(50)          null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrqmrq              datetime             null/* ����������ǩ������ʱ�� */,
    ysbm                 varchar(20)          not null/* ҽʦ���� */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    ysqmrq               datetime             not null/* ҽʦǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_BWZTZS_JBZD     ֪���֪��Ϣ����Σ���أ�֪ͨ��_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_BWZTZS_JBZD') )
 create table  DC_ZQGZXX_BWZTZS_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_MZZQTYS     ֪���֪��Ϣ������֪��ͬ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_MZZQTYS') )
 create table  DC_ZQGZXX_MZZQTYS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    tysbh                varchar(20)          not null/* ֪��ͬ������ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    nssbm                varchar(64)          null/* ��ʵʩ�������������� */,
    nssczmc              varchar(128)         null/* ��ʵʩ�������������� */,
    nssrq                datetime             null/* ��ʵʩ��������������ʱ�� */,
    nmzdm                varchar(2)           not null/* ��ʵʩ���������� */,
    nmzffmc              varchar(30)          not null/* ��ʵʩ���������� */,
    hzjcjb               nvarchar(500)        null/* ���߻������� */,
    jcjbmzyx             nvarchar(1000)       null/* ����������������ܲ�����Ӱ�� */,
    nycjcff              nvarchar(2000)       null/* �����д������ͼ�ⷽ�� */,
    mzywbfz              nvarchar(1000)       null/* �����С��������ܷ��������⼰����֢ */,
    mzztb                char(1)              null/* ʹ��������ʹ�ñ�־ */,
    mzaqbx               char(1)              null/* �μ�����ȫ���ձ�־ */,
    yljgyj               nvarchar(2000)       not null/* ҽ�ƻ������ */,
    hzdlryj              nvarchar(2000)       not null/* ����/������������� */,
    hzqm                 varchar(50)          not null/* ����ǩ�� */,
    dlrqm                varchar(50)          not null/* ����������ǩ�� */,
    dlrhzgxdm            varchar(20)          not null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrhzgxmc            varchar(50)          not null/* �����������뻼�ߵĹ�ϵ���� */,
    hzdlrqmrq            datetime             not null/* ����/����������ǩ������ʱ�� */,
    mzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    mzysqmrq             datetime             not null/* ����ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_MZZQTYS_SQZD     ֪���֪��Ϣ������֪��ͬ����_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_MZZQTYS_SQZD') )
 create table  DC_ZQGZXX_MZZQTYS_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sqzd                 varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_QTZQTYS     ֪���֪��Ϣ �� ����֪��ͬ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_QTZQTYS') )
 create table  DC_ZQGZXX_QTZQTYS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(18)          not null/* �ţ�������� */,
    zyh                  varchar(18)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    tysbh                varchar(20)          not null/* ֪��ͬ������ */,
    tysmc                varchar(200)         not null/* ֪��ͬ�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    zqtynr               nvarchar(2000)       not null/* ֪��ͬ������ */,
    yljgyj               nvarchar(2000)       not null/* ҽ�ƻ������ */,
    dlryj                nvarchar(2000)       not null/* ����/������������� */,
    hzqm                 varchar(50)          not null/* ����ǩ�� */,
    dlrqm                varchar(50)          null/* ����������ǩ�� */,
    dlrhzgx              varchar(2)           null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrhzmc              varchar(50)          null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrqmrq              datetime             not null/* ����/����������ǩ������ʱ�� */,
    ysbm                 varchar(20)          not null/* ҽʦ���� */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    ysqmrq               datetime             not null/* ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_QTZQTYS_JBZD     ֪���֪��Ϣ �� ����֪��ͬ����_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_QTZQTYS_JBZD') )
 create table  DC_ZQGZXX_QTZQTYS_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SSTYS     ֪���֪��Ϣ������ͬ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SSTYS') )
 create table  DC_ZQGZXX_SSTYS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    zqtysbh              varchar(20)          not null/* ֪��ͬ������ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    lxdh                 varchar(50)          not null/* ��ϵ�绰 */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ssywfx               nvarchar(200)        not null/* �����п��ܳ��ֵ����⼰���� */,
    ssywbfz              nvarchar(1000)       not null/* ��������ܳ��ֵ����⼰����֢ */,
    tdfa                 nvarchar(1000)       not null/* ������� */,
    yljgyj               nvarchar(2000)       not null/* ҽ�ƻ������ */,
    hzdlryj              nvarchar(2000)       not null/* ����/������������� */,
    hzqm                 varchar(50)          not null/* ����ǩ�� */,
    dlrqm                varchar(50)          not null/* ����������ǩ�� */,
    dlrhzgxdm            varchar(2)           not null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrhzgxmc            varchar(50)          not null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrqmrq              datetime             not null/* ����/����������ǩ������ʱ�� */,
    jzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    jzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysdm               varchar(50)          not null/* ����ҽ������ */,
    zrysxm               varchar(50)          not null/* ����ҽ������ */,
    sszdm                varchar(20)          not null/* �����߹��� */,
    sszqm                varchar(50)          not null/* ������ǩ�� */,
    ysqmrq               datetime             not null/* ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SSTYS_NSSSS     ֪���֪��Ϣ������ͬ����_��ʵʩ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SSTYS_NSSSS') )
 create table  DC_ZQGZXX_SSTYS_NSSSS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    nssbm                varchar(64)          not null/* ��ʵʩ�������������� */,
    nssczmc              varchar(128)         not null/* ��ʵʩ�������������� */,
    nssrq                datetime             not null/* ��ʵʩ��������������ʱ�� */,
    sszz                 nvarchar(500)        not null/* ����ָ�� */,
    ssjjz                nvarchar(100)        not null/* ��������֢ */,
    ssfs                 varchar(30)          not null/* ������ʽ */,
    nmzdm                varchar(2)           not null/* ��ʵʩ���������� */,
    nmzffmc              varchar(30)          not null/* ��ʵʩ���������� */,
    sqzb                 nvarchar(1000)       not null/* ��ǰ׼�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SSTYS_SQZD     ֪���֪��Ϣ������ͬ����_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SSTYS_SQZD') )
 create table  DC_ZQGZXX_SSTYS_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sqzd                 varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SXZLTYS     ֪���֪��Ϣ����Ѫ����ͬ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SXZLTYS') )
 create table  DC_ZQGZXX_SXZLTYS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(64)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    tysbh                varchar(20)          not null/* ֪��ͬ������ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    sxsdm                char(1)              not null/* ��Ѫʷ��ʶ���� */,
    sxzz                 nvarchar(500)        not null/* ��Ѫָ�� */,
    sxpzdm               varchar(2)           not null/* ��ѪƷ�ִ��� */,
    sxpzmc               varchar(50)          not null/* ��ѪƷ������ */,
    sxqjcjg              nvarchar(200)        not null/* ��Ѫǰ�йؼ����Ŀ����� */,
    sxfs                 varchar(50)          not null/* ��Ѫ��ʽ */,
    nsxrq                datetime             not null/* �ⶨ��Ѫ����ʱ�� */,
    sxblhg               nvarchar(500)        not null/* ��Ѫ���ռ����ܷ����Ĳ������ */,
    yljgyj               nvarchar(2000)       not null/* ҽ�ƻ������ */,
    hzdlryj              nvarchar(2000)       not null/* ����/������������� */,
    hzdlrqm              varchar(50)          not null/* ����/����������ǩ�� */,
    dlrhzgxdm            varchar(50)          not null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrhzgxmc            varchar(50)          not null/* �����������뻼�ߵĹ�ϵ���� */,
    hzdlrqmrq            datetime             not null/* ����/����������ǩ������ʱ�� */,
    ysbm                 varchar(20)          not null/* ҽʦ���� */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    ysqmrq               datetime             not null/* ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SXZLTYS_JBZD     ֪���֪��Ϣ����Ѫ����ͬ����_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SXZLTYS_JBZD') )
 create table  DC_ZQGZXX_SXZLTYS_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_SXZLTYS_SXS     ֪���֪��Ϣ����Ѫ����ͬ����_��Ѫʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_SXZLTYS_SXS') )
 create table  DC_ZQGZXX_SXZLTYS_SXS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sxsmc                varchar(32)          not null/* ��Ѫʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_TSJCZLTYS     ֪���֪��Ϣ�������鼰��������ͬ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_TSJCZLTYS') )
 create table  DC_ZQGZXX_TSJCZLTYS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    mjzh                 varchar(10)          not null/* �ţ�������� */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    tysbh                varchar(20)          not null/* ֪��ͬ������ */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    jczlxmmc             varchar(100)         not null/* �����鼰����������Ŀ���� */,
    jczlmd               nvarchar(100)        not null/* �����鼰��������Ŀ�� */,
    jczlbfz              nvarchar(1000)       null/* �����鼰�������ƿ�������Ĳ���֢������ */,
    tdfa                 nvarchar(1000)       null/* ������� */,
    hzdlrqm              varchar(50)          not null/* ����/����������ǩ�� */,
    hzdlrgxdm            varchar(2)           not null/* �����������뻼�ߵĹ�ϵ���� */,
    hzdlrgxmc            varchar(128)         not null/* �����������뻼�ߵĹ�ϵ���� */,
    dlrqmrq              datetime             not null/* ����/����������ǩ������ʱ�� */,
    ysbm                 varchar(20)          not null/* ҽ������ */,
    ysqm                 varchar(50)          not null/* ҽʦǩ�� */,
    ysqmrq               datetime             not null/* ҽʦǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZQGZXX_TSJCZLTYS_JBZD     ֪���֪��Ϣ�������鼰��������ͬ����_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZQGZXX_TSJCZLTYS_JBZD') )
 create table  DC_ZQGZXX_TSJCZLTYS_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY     ������ҳ��סԺ������ҳ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY') )
 create table  DC_ZYBA_BASY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgzzjgdm           varchar(10)          not null/* סԺ������ʶ */,
    yljgzzjgmc           varchar(70)          not null/* סԺ�������� */,
    ylfffsdm             varchar(2)           not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    ylfffsmc             varchar(50)          not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    jkkh                 varchar(18)          not null/* �������� */,
    zycs                 numeric(3)           not null/* סԺ���� */,
    bah                  varchar(18)          not null/* ������ */,
    xm                   varchar(50)          not null/* ���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 not null/* �������� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    gjdm                 varchar(3)           not null/* �������� */,
    gjmc                 varchar(64)          not null/* �������� */,
    xsecstzg             numeric(4)           null/* �������������أ�g�� */,
    xserytzg             numeric(4)           null/* ��������Ժ���أ�g�� */,
    csd_s                varchar(70)          not null/* ������-ʡ����������ֱϽ�У� */,
    csd_cs               varchar(70)          not null/* ������-�У��������ݣ� */,
    csd_xq               varchar(70)          not null/* ������-�أ����� */,
    jg_s                 varchar(70)          not null/* ����ʡ */,
    jg_cs                varchar(70)          not null/* ������� */,
    mzdm                 varchar(3)           not null/* ���� */,
    mzmc                 varchar(50)          not null/* �������� */,
    sfzjlbdm             varchar(2)           not null/* ���֤�������� */,
    sfzjlbmc             varchar(50)          not null/* ���֤��������� */,
    hzsfzjhm             varchar(18)          not null/* �������֤������ */,
    zylbdm               varchar(2)           null/* ְҵ������ */,
    zylbmc               varchar(18)          null/* ְҵ������� */,
    hyzkdm               varchar(2)           null/* ����״������ */,
    hyzkmc               varchar(18)          null/* ����״������ */,
    xzz_s                varchar(70)          not null/* ��סַ-ʡ����������ֱϽ�У� */,
    xzz_cs               varchar(70)          not null/* ��סַ-�У��������ݣ� */,
    xzz_xq               varchar(70)          not null/* ��סַ-�أ����� */,
    xzz_jd               varchar(70)          not null/* ��סַ-�磨�򡢽ֵ����´��� */,
    xzz_xz               varchar(70)          not null/* ��סַ-�壨�֡�·��Ū�ȣ� */,
    xzz_mphm             varchar(70)          not null/* ��סַ-���ƺ��� */,
    dhhm                 varchar(20)          not null/* �绰���� */,
    xzz_yzbm             numeric(6)           not null/* ��סַ-�������� */,
    hkdz_s               varchar(70)          not null/* ���ڵ�ַ-ʡ����������ֱϽ�У� */,
    hkdz_cs              varchar(70)          not null/* ���ڵ�ַ-�У��������ݣ� */,
    hkdz_xq              varchar(70)          not null/* ���ڵ�ַ-�أ����� */,
    hkdz_xz              varchar(70)          not null/* ���ڵ�ַ-�磨�򡢽ֵ����´��� */,
    hkdz_c               varchar(70)          not null/* ���ڵ�ַ-�壨�֡�·��Ū�ȣ� */,
    hkdz_mphm            varchar(70)          not null/* ���ڵ�ַ-���ƺ��� */,
    hkdz_yzbm            numeric(6)           not null/* ���ڵ�ַ-�������� */,
    gzdwmc               varchar(70)          not null/* ������λ���� */,
    gzdwdz_s             varchar(70)          not null/* ������λ��ַ-ʡ����������ֱϽ�У� */,
    gzdwdz_cs            varchar(70)          not null/* ������λ��ַ-�У��������ݣ� */,
    gzdwdz_xq            varchar(70)          not null/* ������λ��ַ-�أ����� */,
    gzdwdz_xz            varchar(70)          not null/* ������λ��ַ-�磨�򡢽ֵ����´��� */,
    gzdwdz_c             varchar(70)          not null/* ������λ��ַ-�壨�֡�·��Ū�ȣ� */,
    gzdwdz_mphm          varchar(70)          not null/* ������λ��ַ-���ƺ��� */,
    gzdwdhhm             varchar(20)          not null/* ������λ�绰���� */,
    gzdwdz_yzbm          numeric(6)           not null/* ������λ��ַ-�������� */,
    lxrxm                varchar(50)          not null/* ��ϵ������ */,
    lxryhzdgxdm          varchar(2)           not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    lxryhzdgxmc          varchar(50)          not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    lxrdz_s              varchar(70)          not null/* ��ϵ�˵�ַ-ʡ����������ֱϽ�У� */,
    lxrdz_cs             varchar(70)          not null/* ��ϵ�˵�ַ-�У��������ݣ� */,
    lxrdz_xq             varchar(70)          not null/* ��ϵ�˵�ַ-�أ����� */,
    lxrdz_xz             varchar(70)          not null/* ��ϵ�˵�ַ-�磨�򡢽ֵ����´��� */,
    lxrdz_c              varchar(70)          not null/* ��ϵ�˵�ַ-�壨�֡�·��Ū�ȣ� */,
    lxrdz_mphm           varchar(70)          not null/* ��ϵ�˵�ַ-���ƺ��� */,
    lxrdhhm              varchar(20)          not null/* ��ϵ�˵绰���� */,
    rytjdm               varchar(2)           not null/* ��Ժ;������ */,
    rytjmc               varchar(20)          not null/* ��Ժ;������ */,
    ryrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    rykbdm               varchar(11)          not null/* ��Ժ�Ʊ���� */,
    rykbmc               varchar(50)          not null/* ��Ժ�Ʊ� */,
    rybf                 varchar(10)          not null/* ��Ժ���� */,
    zkkb                 varchar(50)          null/* ת�ƿƱ� */,
    cyrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    cykbdm               varchar(10)          not null/* ��Ժ�Ʊ���� */,
    cykbmc               varchar(50)          not null/* ��Ժ�Ʊ� */,
    cybf                 varchar(10)          not null/* ��Ժ���� */,
    sjzyts               numeric(4)           not null/* ʵ��סԺ���� */,
    sszddwbyyjbbm        varchar(64)          not null/* �����ж����ⲿԭ�򼲲����� */,
    sszddwbyyjbmc        varchar(128)         not null/* �����ж����ⲿԭ�򼲲����� */,
    swhzsjbz             char(1)              null/* ��������ʬ���־ */,
    aboxxdm              varchar(2)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(18)          not null/* ABOѪ������ */,
    rhxxdm               varchar(2)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(18)          not null/* RhѪ������ */,
    kzrdm                varchar(20)          not null/* �����ι��� */,
    kzrqm                varchar(50)          not null/* ������ǩ�� */,
    zrfzrysqm            varchar(50)          not null/* ���Σ������Σ�ҽʦǩ�� */,
    zzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zyysdm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zrhsdm               varchar(20)          not null/* ���λ�ʿ���� */,
    zrhsqm               varchar(50)          not null/* ���λ�ʿǩ�� */,
    jxysdm               varchar(20)          not null/* ����ҽʦ���� */,
    jxysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    sxysdm               varchar(20)          not null/* ʵϰҽʦ���� */,
    sxysqm               varchar(50)          not null/* ʵϰҽʦǩ�� */,
    bydm                 varchar(20)          not null/* ����Ա���� */,
    bym                  varchar(50)          not null/* ����Աǩ�� */,
    bazldm               varchar(2)           not null/* ������������ */,
    bazlmc               varchar(100)         not null/* ������������ */,
    zkysdm               varchar(20)          not null/* �ʿ�ҽʦ���� */,
    zkysqm               varchar(50)          not null/* �ʿ�ҽʦǩ�� */,
    zkhsdm               varchar(20)          not null/* �ʿػ�ʿ���� */,
    zkhsqm               varchar(50)          not null/* �ʿػ�ʿǩ�� */,
    zkrq                 date                 not null/* �ʿ����� */,
    lyfsdm               varchar(2)           not null/* ��Ժ��ʽ���� */,
    lyfsmc               varchar(100)         not null/* ��Ժ��ʽ���� */,
    njsyljgdm            varchar(20)          not null/* �����ҽ�ƻ������� */,
    njsyljgmc            varchar(70)          not null/* �����ҽ�ƻ������� */,
    cy31dnzzybz          char(1)              not null/* ��Ժ31d����סԺ��־ */,
    cy31dnzzymd          varchar(100)         null/* ��Ժ31d����סԺĿ�� */,
    lnsshzryqhmsj_d      numeric(5)           not null/* ­�����˻�����Ժǰ����ʱ��-d */,
    lnsshzryqhmsj_h      numeric(2)           not null/* ­�����˻�����Ժǰ����ʱ��-h */,
    lnsshzryqhmsj_min    numeric(2)           not null/* ­�����˻�����Ժǰ����ʱ��-min */,
    lnsshzryhhmsj_d      numeric(5)           not null/* ­�����˻�����Ժ�����ʱ��-d */,
    lnsshzryhhmsj_h      numeric(2)           not null/* ­�����˻�����Ժ�����ʱ��-h */,
    lnsshzryhhmsj_min    numeric(2)           not null/* ­�����˻�����Ժ�����ʱ��-min */,
    zyzfy                numeric(10,2)        not null/* סԺ�ܷ��� */,
    zyzfy_zfje           numeric(10,2)        not null/* סԺ�ܷ���-�Ը���� */,
    zhylfwl_ybylfwf      numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ��ҽ�Ʒ���� */,
    zhylfwl_ybzlczf      numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ�����Ʋ����� */,
    zhylfwl_hlf          numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-����� */,
    zhylfwl_qtfy         numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-�������� */,
    zdl_blzdf            numeric(10,2)        not null/* �����-������Ϸ� */,
    zdl_syszdf           numeric(10,2)        not null/* �����-ʵ������Ϸ� */,
    zdl_yxxzdf           numeric(10,2)        not null/* �����-Ӱ��ѧ��Ϸ� */,
    zdl_lczdxmf          numeric(10,2)        not null/* �����-�ٴ������Ŀ�� */,
    zll_fsszlxmf         numeric(10,2)        not null/* ������-������������Ŀ�� */,
    zll_fsszlxmf_lcwlzlf numeric(10,2)        not null/* ������-������������Ŀ��-�ٴ��������Ʒ� */,
    zll_sszlf            numeric(10,2)        not null/* ������-�������Ʒ� */,
    zll_sszlf_mzf        numeric(10,2)        not null/* ������-�������Ʒ�-����� */,
    zll_sszlf_ssf        numeric(10,2)        not null/* ������-�������Ʒ�-������ */,
    kfl_kff              numeric(10,2)        not null/* ������-������ */,
    zyl_zyzlf            numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ� */,
    xyl_xyf              numeric(10,2)        not null/* ��ҩ��-��ҩ�� */,
    xyl_xyf_kjywfy       numeric(10,2)        not null/* ��ҩ��-��ҩ��-����ҩ����� */,
    zyl_zchenyf          numeric(10,2)        not null/* ��ҩ��-�г�ҩ�� */,
    zyl_zcyf             numeric(10,2)        not null/* ��ҩ��-�в�ҩ�� */,
    xyhxyzpl_xf          numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-Ѫ�� */,
    xyhxyzpl_bdblzpf     numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-�׵�������Ʒ�� */,
    xyhxyzpl_qdblzpf     numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-�򵰰�����Ʒ�� */,
    xyhxyzpl_nxyzlzpf    numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-��Ѫ��������Ʒ�� */,
    xyhxyzpl_xbyzlzpf    numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-ϸ����������Ʒ�� */,
    hcl_jcyycxyyclf      numeric(10,2)        not null/* �Ĳ���-�����һ����ҽ�ò��Ϸ� */,
    hcl_zlyycxyyclf      numeric(10,2)        not null/* �Ĳ���-������һ����ҽ�ò��Ϸ� */,
    hcl_ssyycxyyclf      numeric(10,2)        not null/* �Ĳ���-������һ����ҽ�ò��Ϸ� */,
    qtl_qtf              numeric(10,2)        not null/* ������-������ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_BLZD     ������ҳ��סԺ������ҳ_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_BLZD') )
 create table  DC_ZYBA_BASY_BLZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    blhm                 varchar(18)          not null/* ����� */,
    blzdmc               varchar(128)         not null/* ����������� */,
    blzdjbbm             varchar(64)          not null/* ������ϼ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_CYQTZD     ������ҳ��סԺ������ҳ_��Ժ�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_CYQTZD') )
 create table  DC_ZYBA_BASY_CYQTZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyzd_qtzdmc          varchar(128)         not null/* ��Ժ���-����������� */,
    cyzd_qtzdjbbm        varchar(64)          not null/* ��Ժ���-������ϼ������� */,
    cyzd_qtzdrybqdm      varchar(64)          not null/* ��Ժ���-���������Ժ������� */,
    cyzd_qtzdrybqmc      varchar(128)         not null/* ��Ժ���-���������Ժ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_CYZYZD     ������ҳ��סԺ������ҳ_��Ժ��Ҫ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_CYZYZD') )
 create table  DC_ZYBA_BASY_CYZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyzd_zyzdmc          varchar(128)         not null/* ��Ժ���-��Ҫ������� */,
    cyzd_zyzdjbbm        varchar(64)          not null/* ��Ժ���-��Ҫ��ϼ������� */,
    cyzd_zyzdrybqdm      varchar(64)          not null/* ��Ժ���-��Ҫ�����Ժ������� */,
    cyzd_zyzdrybqmc      varchar(128)         not null/* ��Ժ���-��Ҫ�����Ժ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_GMS     ������ҳ��סԺ������ҳ_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_GMS') )
 create table  DC_ZYBA_BASY_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywgmbz               char(1)              null/* ҩ�������־ */,
    gmyw                 varchar(1000)        null/* ����ҩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_MJZD     ������ҳ��סԺ������ҳ_�ż����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_MJZD') )
 create table  DC_ZYBA_BASY_MJZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    mjzzdmc              varchar(128)         not null/* �ţ�������������� */,
    mjzzdjbbm            varchar(64)          not null/* �ţ���������ϼ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBA_BASY_SS     ������ҳ��סԺ������ҳ_����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBA_BASY_SS') )
 create table  DC_ZYBA_BASY_SS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ssjczbm              varchar(64)          null/* �������������� */,
    ssjczrq              datetime             null/* �������������� */,
    ssjbdm               varchar(2)           null/* ����������� */,
    ssjbmc               varchar(50)          null/* ������������ */,
    ssjczmc              varchar(128)         null/* �������������� */,
    sszdm                varchar(20)          null/* �����߹��� */,
    sszxm                varchar(50)          null/* ���������� */,
    yzdm                 varchar(20)          null/* �������� */,
    yzxm                 varchar(50)          null/* �������� */,
    ezdm                 varchar(20)          null/* �������� */,
    ezxm                 varchar(50)          null/* �������� */,
    ssqklbdm             varchar(2)           null/* �����п������� */,
    ssqklbmc             varchar(100)         null/* �����п�������� */,
    qkyhdjdm             varchar(2)           null/* �п����ϵȼ����� */,
    qkyhdjmc             varchar(100)         null/* �п����ϵȼ����� */,
    mzfsdm               varchar(2)           null/* ����ʽ���� */,
    mzfsmc               varchar(50)          null/* ����ʽ���� */,
    mzysdm               varchar(20)          null/* ����ҽʦ���� */,
    mzysxm               varchar(50)          null/* ����ҽʦ���� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_CYJL     סԺ���̼�¼����Ժ��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_CYJL') )
 create table  DC_ZYBCJL_CYJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zyszjcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    cyqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    cyrq                 datetime             not null/* ��Ժ����ʱ�� */,
    cyzztz               nvarchar(1000)       not null/* ��Ժʱ֢״������ */,
    czzyzhmc             varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    czzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    cyyz                 nvarchar(1000)       not null/* ��Ժҽ�� */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_CYJL_CYXYZD     סԺ���̼�¼����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_CYJL_CYXYZD') )
 create table  DC_ZYBCJL_CYJL_CYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czxyzdmc             varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    czxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_CYJL_CYZYZD     סԺ���̼�¼����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_CYJL_CYZYZD') )
 create table  DC_ZYBCJL_CYJL_CYZYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    czzybmmc             varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    czzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_CYJL_RYXYZD     סԺ���̼�¼����Ժ��¼_��Ժ��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_CYJL_RYXYZD') )
 create table  DC_ZYBCJL_CYJL_RYXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ryzdbm               varchar(64)          not null/* ��Ժ��ϱ��� */,
    ryzdmc               varchar(128)         not null/* ��Ժ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_CYJL_RYZD_FZJC     סԺ���̼�¼����Ժ��¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_CYJL_RYZD_FZJC') )
 create table  DC_ZYBCJL_CYJL_RYZD_FZJC (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    yxfzjcjg             nvarchar(1000)       null/* ���Ը�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_HZJL     סԺ���̼�¼�������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_HZJL') )
 create table  DC_ZYBCJL_HZJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    dzsqdbh              varchar(20)          null/* �������뵥��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    blgy                 nvarchar(200)        not null/* ����ժҪ */,
    fzjcjg               nvarchar(1000)       null/* ��������� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zlgcmc               nvarchar(1000)       not null/* ���ƹ������� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    hzlx                 varchar(50)          not null/* �������� */,
    hzyy                 nvarchar(200)        not null/* ����ԭ�� */,
    hzmd                 nvarchar(50)         not null/* ����Ŀ�� */,
    hzsqysdm             varchar(20)          not null/* ��������ҽʦ���� */,
    hzsqysqm             varchar(50)          not null/* ��������ҽʦǩ�� */,
    hzsqksdm             varchar(10)          not null/* ����������Ҵ��� */,
    hzsqks               varchar(50)          not null/* ����������� */,
    hzsqyljgdm           varchar(10)          not null/* ��������ҽ�ƻ������� */,
    hzsqyljgmc           varchar(70)          not null/* ��������ҽ�ƻ������� */,
    hzyj                 nvarchar(2000)       not null/* ������� */,
    hzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    hzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    hzksdm               varchar(10)          not null/* ������Ҵ��� */,
    hzksmc               varchar(50)          not null/* ����������� */,
    hzyljgdm             varchar(10)          not null/* ����ҽʦ����ҽ�ƻ������� */,
    hzysyljgmc           varchar(70)          not null/* ����ҽʦ����ҽ�ƻ������� */,
    hzszyljgdm           varchar(10)          not null/* ��������ҽ�ƻ������� */,
    hzszyljgmc           varchar(70)          not null/* ��������ҽ�ƻ������� */,
    hzrq                 datetime             not null/* ��������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_HZJL_XYZD     סԺ���̼�¼�������¼_��ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_HZJL_XYZD') )
 create table  DC_ZYBCJL_HZJL_XYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    xyzdmc               varchar(128)         not null/* ��ҽ������� */,
    xyzdbm               varchar(64)          not null/* ��ҽ��ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_HZJL_ZYBM     סԺ���̼�¼�������¼_��ҽ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_HZJL_ZYBM') )
 create table  DC_ZYBCJL_HZJL_ZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    zybmmc               varchar(128)         null/* ��ҽ�������� */,
    zybmdm               varchar(64)          null/* ��ҽ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_HZJL_ZYZH     סԺ���̼�¼�������¼_��ҽ֤��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_HZJL_ZYZH') )
 create table  DC_ZYBCJL_HZJL_ZYZH (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    zyzhmc               varchar(128)         null/* ��ҽ֤������ */,
    zyzhdm               varchar(64)          null/* ��ҽ֤����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_JDXJ     סԺ���̼�¼���׶�С��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_JDXJ') )
 create table  DC_ZYBCJL_JDXJ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(18)          not null/* סԺ�ű�ʶ */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(10)          not null/* ��Ժ�������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 null/* ���߳������� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    xjrq                 datetime             not null/* С������ʱ�� */,
    zs                   nvarchar(100)        not null/* ���� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    rzxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    rzxyzd               varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    rzzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    rzzybm               varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    rzzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    rzzyzh               varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    yznr                 nvarchar(1000)       null/* ҽ������ */,
    zlgcms               nvarchar(2000)       null/* ���ƹ������� */,
    mqqk                 nvarchar(2000)       not null/* Ŀǰ��� */,
    mqzdxyzdbm           varchar(64)          not null/* Ŀǰ���-��ҽ��ϱ��� */,
    mqzdxyzd             varchar(128)         not null/* Ŀǰ���-��ҽ������� */,
    mqzdzybmdm           varchar(64)          null/* Ŀǰ���-��ҽ�������� */,
    mqzdzybm             varchar(128)         null/* Ŀǰ���-��ҽ�������� */,
    mqzdzyzhdm           varchar(64)          null/* Ŀǰ���-��ҽ֤����� */,
    mqzdzyzh             varchar(128)         null/* Ŀǰ���-��ҽ֤������ */,
    jhzlfa               nvarchar(1000)       not null/* ������Ʒ��� */,
    ysbm                 varchar(20)          not null/* ǩ���˹��� */,
    ysqm                 varchar(50)          not null/* ǩ�������� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_JJBJL     סԺ���̼�¼�����Ӱ��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_JJBJL') )
 create table  DC_ZYBCJL_JJBJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(18)          not null/* סԺ�ű�ʶ */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(10)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    zs                   nvarchar(100)        not null/* ���� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    rzxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    rzxyzd               varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    rzzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    rzzybm               varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    rzzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    rzzyzh               varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zlgcms               nvarchar(2000)       null/* ���ƹ������� */,
    mqqk                 nvarchar(2000)       not null/* Ŀǰ��� */,
    mqzdxyzdbm           varchar(64)          not null/* Ŀǰ���-��ҽ��ϱ��� */,
    mqzdxyzd             varchar(128)         not null/* Ŀǰ���-��ҽ������� */,
    mqzdzybmdm           varchar(64)          null/* Ŀǰ���-��ҽ�������� */,
    mqzdzybm             varchar(128)         null/* Ŀǰ���-��ҽ�������� */,
    mqzdzyzhdm           varchar(64)          null/* Ŀǰ���-��ҽ֤����� */,
    mqzdzyzh             varchar(128)         null/* Ŀǰ���-��ҽ֤������ */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    jbzljh               nvarchar(2000)       not null/* �Ӱ����Ƽƻ� */,
    jbrq                 datetime             not null/* ��������ʱ�� */,
    jbysbm               varchar(20)          not null/* ����ҽ������ */,
    jbzqm                varchar(50)          not null/* ����ҽ��ǩ�� */,
    jbsj                 datetime             not null/* �Ӱ�����ʱ�� */,
    ysbm                 varchar(20)          not null/* ҽ������ */,
    ysxm                 varchar(20)          not null/* ҽ������ */,
    jbrdm                varchar(20)          not null/* �Ӱ��߹��� */,
    jbrqm                varchar(50)          not null/* �Ӱ���ǩ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_QJJL     סԺ���̼�¼�����ȼ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_QJJL') )
 create table  DC_ZYBCJL_QJJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(18)          not null/* סԺ�ű�ʶ */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(10)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    bqbhqk               nvarchar(1000)       not null/* ����仯��� */,
    qjcs                 nvarchar(1000)       not null/* ���ȴ�ʩ */,
    qjksrq               datetime             not null/* ���ȿ�ʼ����ʱ�� */,
    qjjsrq               datetime             not null/* ���Ƚ�������ʱ�� */,
    zysx                 nvarchar(1000)       null/* ע������ */,
    cjtlrymd             varchar(100)         not null/* �μ�������Ա���� */,
    cjqjrydm             varchar(100)         null/* �μ�������Ա���� */,
    cjqjrymd             varchar(500)         null/* �μ�������Ա���� */,
    zyzwlbdm             varchar(4)           null/* רҵ����ְ�������� */,
    zyzwlbmc             varchar(50)          null/* רҵ����ְ��������� */,
    ysbm                 varchar(20)          not null/* ǩ���˹��� */,
    ysqm                 varchar(50)          not null/* ǩ�������� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_QJJL_JBZD     סԺ���̼�¼�����ȼ�¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_QJJL_JBZD') )
 create table  DC_ZYBCJL_QJJL_JBZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jbzdmc               varchar(500)         not null/* ����������� */,
    jbzdbm               varchar(100)         not null/* ������ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_QJJL_JCJY     סԺ���̼�¼�����ȼ�¼_���/����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_QJJL_JCJY') )
 create table  DC_ZYBCJL_QJJL_JCJY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    jcjyxmmc             varchar(500)         null/* ���/������Ŀ���� */,
    jcjyjg               nvarchar(1000)       null/* ���/������ */,
    jcjyjgdm             varchar(2)           null/* ���/���������� */,
    jcjydljg             numeric(14,4)        null/* ���/���鶨����� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_QJJL_SSCZ     סԺ���̼�¼�����ȼ�¼_��������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_QJJL_SSCZ') )
 create table  DC_ZYBCJL_QJJL_SSCZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ssczbm               varchar(64)          not null/* �������������� */,
    ssczmc               varchar(128)         not null/* �������������� */,
    ssczbwdm             varchar(64)          not null/* ����������Ŀ�겿λ���� */,
    ssczbwmc             varchar(128)         not null/* ����������Ŀ�겿λ���� */,
    jrwdm                varchar(64)          null/* ��������� */,
    jrwmc                varchar(128)         null/* ���������� */,
    czff                 nvarchar(2000)       not null/* �������� */,
    czcs                 numeric(3)           not null/* �������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_RCBCJL     סԺ���̼�¼���ճ����̼�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_RCBCJL') )
 create table  DC_ZYBCJL_RCBCJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfmc                 varchar(10)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    jlrq                 datetime             not null/* ��¼����ʱ�� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա�˵�� */,
    csrq                 date                 not null/* ���߳������� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    zybc                 nvarchar(2000)       not null/* סԺ���� */,
    yznr                 nvarchar(1000)       null/* ҽ������ */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    bzlzms               nvarchar(1000)       null/* ��֤������ϸ���� */,
    zyzwlbdm             varchar(2)           null/* רҵ����ְ�������� */,
    zyzwlbmc             varchar(20)          null/* רҵ����ְ��������� */,
    ysbm                 varchar(20)          not null/* ҽ������ */,
    ysqm                 varchar(50)          not null/* ҽ������ */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_RCBCJL_ZYSZGCJG     סԺ���̼�¼���ճ����̼�¼_��ҽ����۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_RCBCJL_ZYSZGCJG') )
 create table  DC_ZYBCJL_RCBCJL_ZYSZGCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SCBCJL     סԺ���̼�¼���״β��̼�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SCBCJL') )
 create table  DC_ZYBCJL_SCBCJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* סԺ������Ժ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* סԺ������Ժ�������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ��Ժ������ */,
    bfmc                 varchar(50)          not null/* ��Ժ�������� */,
    bch                  varchar(10)          not null/* ������ */,
    jlrq                 datetime             not null/* ��¼����ʱ�� */,
    hzxm                 varchar(64)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* ���֤�� */,
    xbdm                 varchar(2)           not null/* �����Ա���� */,
    xbmc                 varchar(16)          not null/* �����Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    zs                   nvarchar(100)        not null/* ���� */,
    bltd                 nvarchar(2000)       not null/* �����ص� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    zdyjdm               nvarchar(100)        null/* ������ݴ��� */,
    zdyj                 nvarchar(1000)       not null/* ������� */,
    czxyzdbm             varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    czxyzd               varchar(128)         not null/* �������-��ҽ������� */,
    czzybmdm             varchar(64)          null/* �������-��ҽ�������� */,
    czzybm               varchar(128)         null/* �������-��ҽ�������� */,
    czzyzhdm             varchar(64)          null/* �������-��ҽ֤����� */,
    czzyzh               varchar(128)         null/* �������-��ҽ֤������ */,
    jzxyzdbm             varchar(64)          not null/* �������-��ҽ��ϱ��� */,
    jzxyzdmc             varchar(128)         not null/* �������-��ҽ������� */,
    jzzybmdm             varchar(64)          null/* �������-��ҽ�������� */,
    jzzybmmc             varchar(128)         null/* �������-��ҽ�������� */,
    jzzyzhbm             varchar(64)          null/* �������-��ҽ֤����� */,
    jzzyzhmc             varchar(128)         null/* �������-��ҽ֤������ */,
    zljh                 nvarchar(2000)       not null/* ���Ƽƻ� */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η� */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    sjysbm               varchar(20)          not null/* �ϼ�ҽʦ���� */,
    sjysqm               varchar(50)          not null/* �ϼ�ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SHSCBCJL     סԺ���̼�¼�������״β��̼�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SHSCBCJL') )
 create table  DC_ZYBCJL_SHSCBCJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    birth                datetime             not null/* ���߳������� */,
    lxdh                 varchar(50)          not null/* ��ϵ�绰 */,
    hyzkdm               varchar(20)          not null/* ���߻���״������ */,
    hyzk                 varchar(50)          not null/* ���߻���״�� */,
    mzdm                 varchar(20)          not null/* ������� */,
    mz                   varchar(50)          not null/* ���� */,
    hkszd                varchar(50)          null/* �������ڵ� */,
    csdz                 varchar(500)         null/* ������ַ */,
    gzdw                 varchar(50)          null/* ������λ���� */,
    gzdwdz               varchar(500)         null/* �����ص� */,
    gzdwdh               varchar(70)          null/* ������λ�绰 */,
    jgd                  varchar(50)          null/* ����� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    jlrq                 datetime             not null/* ��¼����ʱ�� */,
    ssczbm               varchar(64)          not null/* �������������� */,
    ssmc                 varchar(128)         not null/* �������� */,
    ssmbbwdm             varchar(64)          not null/* ����Ŀ�겿λ���� */,
    ssbwmc               varchar(128)         not null/* ����Ŀ�겿λ���� */,
    ssrq                 datetime             not null/* ��������ʱ�� */,
    mzffdm               varchar(64)          not null/* ���������� */,
    mzffmc               varchar(128)         not null/* ���������� */,
    ssgc                 nvarchar(2000)       not null/* �������� */,
    zdyjdm               nvarchar(1000)       not null/* ������ݱ��� */,
    zdyj                 nvarchar(1000)       not null/* ����������� */,
    zysx                 nvarchar(1000)       null/* ע������ */,
    ysbm                 varchar(20)          not null/* ǩ���˹��� */,
    ysqm                 varchar(50)          not null/* ǩ�������� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    jzkssj               datetime             not null/* (��Ժ)���￪ʼʱ�� */,
    jzjssj               datetime             not null/* (��Ժ)�������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SHSCBCJL_SHZD     סԺ���̼�¼�������״β��̼�¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SHSCBCJL_SHZD') )
 create table  DC_ZYBCJL_SHSCBCJL_SHZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    shzdmc               varchar(128)         not null/* ����������� */,
    shzdbm               varchar(64)          not null/* ������ϱ��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SJYSCFJL     סԺ���̼�¼���ϼ�ҽʦ�鷿��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SJYSCFJL') )
 create table  DC_ZYBCJL_SJYSCFJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(64)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    cfrq                 datetime             not null/* �鷿����ʱ�� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    csrq                 date                 not null/* �������� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա�˵�� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    cfjl                 nvarchar(2000)       not null/* �鷿��¼ */,
    bzlzms               nvarchar(1000)       null/* ��֤������ϸ���� */,
    yznr                 nvarchar(1000)       null/* ҽ������ */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    yljh                 nvarchar(2000)       not null/* ���Ƽƻ� */,
    jlrbm                varchar(20)          not null/* ��¼�˹��� */,
    jlrqm                varchar(50)          not null/* ��¼��ǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SJYSCFJL_ZYSZGCJG     סԺ���̼�¼���ϼ�ҽʦ�鷿��¼_��ҽ����۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SJYSCFJL_ZYSZGCJG') )
 create table  DC_ZYBCJL_SJYSCFJL_ZYSZGCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SQTL     סԺ���̼�¼����ǰ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SQTL') )
 create table  DC_ZYBCJL_SQTL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tlrq                 datetime             not null/* ��������ʱ�� */,
    tldd                 varchar(50)          not null/* ���۵ص� */,
    zcrbm                varchar(100)         not null/* �����˹��� */,
    zcrxm                varchar(500)         not null/* ���������� */,
    tlrybm               varchar(100)         not null/* �μ�������Ա���� */,
    cjtlmd               varchar(500)         not null/* �μ�������Ա���� */,
    zyzwlbdm             varchar(4)           not null/* רҵ����ְ�������� */,
    zyzwlbmc             varchar(50)          not null/* רҵ����ְ��������� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    ssczmc               varchar(128)         not null/* ��ʵʩ�������������� */,
    ssczbm               varchar(64)          not null/* ��ʵʩ�������������� */,
    ssmbbwdm             varchar(64)          not null/* ��ʵʩ����Ŀ�겿λ���� */,
    ssbwmc               varchar(128)         not null/* ��ʵʩ����Ŀ�겿λ���� */,
    ssczrq               datetime             not null/* ��ʵʩ��������������ʱ�� */,
    mzffdm               varchar(64)          not null/* ��ʵʩ���������� */,
    mzffmc               varchar(128)         not null/* ��ʵʩ���������� */,
    ssyd                 nvarchar(200)        not null/* ����Ҫ�� */,
    sqzb                 nvarchar(1000)       not null/* ��ǰ׼�� */,
    sszz                 nvarchar(500)        not null/* ����ָ�� */,
    ssfa                 nvarchar(1000)       not null/* �������� */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    tlyj                 nvarchar(2000)       not null/* ������� */,
    tljl                 nvarchar(2000)       not null/* ���۽��� */,
    sszbm                varchar(20)          null/* �����߹��� */,
    sszqm                varchar(50)          null/* ������ǩ�� */,
    mzysbm               varchar(20)          null/* ����ҽʦ���� */,
    mzsqm                varchar(50)          null/* ����ҽʦǩ�� */,
    ysbm                 varchar(20)          not null/* ǩ���˹��� */,
    ysqm                 varchar(50)          not null/* ǩ�������� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SQTL_SQZD     סԺ���̼�¼����ǰ����_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SQTL_SQZD') )
 create table  DC_ZYBCJL_SQTL_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SQXJ     סԺ���̼�¼����ǰС��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SQXJ') )
 create table  DC_ZYBCJL_SQXJ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    xjrq                 datetime             not null/* С������ʱ�� */,
    blzy                 nvarchar(200)        not null/* ����ժҪ */,
    zdyjdm               varchar(100)         not null/* ������ݴ��� */,
    zdyj                 nvarchar(1000)       not null/* ����������� */,
    gmsbz                char(1)              not null/* ����ʷ��־ */,
    fzjcjg               nvarchar(1000)       not null/* ��������� */,
    sssyz                nvarchar(100)        not null/* ������Ӧ֤ */,
    ssjjz                nvarchar(100)        not null/* ��������֢ */,
    sszz                 nvarchar(500)        not null/* ����ָ�� */,
    hzyj                 nvarchar(2000)       null/* ������� */,
    ssczbm               varchar(64)          not null/* ��ʵʩ�������������� */,
    ssczmc               varchar(128)         not null/* ��ʵʩ�������������� */,
    ssmbbwdm             varchar(64)          not null/* ��ʵʩ����Ŀ�겿λ���� */,
    ssbwmc               varchar(128)         not null/* ��ʵʩ����Ŀ�겿λ���� */,
    ssczrq               datetime             not null/* ��ʵʩ��������������ʱ�� */,
    mzffdm               varchar(64)          not null/* ��ʵʩ���������� */,
    mzffmc               varchar(128)         not null/* ��ʵʩ���������� */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    ssyd                 nvarchar(200)        not null/* ����Ҫ�� */,
    sqzb                 nvarchar(1000)       not null/* ��ǰ׼�� */,
    sszbm                varchar(20)          not null/* �����߹��� */,
    sszqm                varchar(50)          not null/* ������ǩ�� */,
    ysbm                 varchar(20)          null/* ǩ���˹��� */,
    ysqm                 varchar(50)          null/* ǩ�������� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SQXJ_GMS     סԺ���̼�¼����ǰС��_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SQXJ_GMS') )
 create table  DC_ZYBCJL_SQXJ_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    gms                  nvarchar(1000)       null/* ����ʷ */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SQXJ_SQZD     סԺ���̼�¼����ǰС��_��ǰ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SQXJ_SQZD') )
 create table  DC_ZYBCJL_SQXJ_SQZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    sqzdbm               varchar(64)          not null/* ��ǰ��ϱ��� */,
    sqzdmc               varchar(128)         not null/* ��ǰ������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SWBLTLJL     סԺ���̼�¼�������������ۼ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SWBLTLJL') )
 create table  DC_ZYBCJL_SWBLTLJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(10)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tlrq                 datetime             not null/* ��������ʱ�� */,
    tldddm               varchar(20)          not null/* ���۵ص���� */,
    tldd                 varchar(50)          not null/* ���۵ص����� */,
    zcrbm                varchar(100)         not null/* �����˹��� */,
    zcrxm                varchar(500)         not null/* ���������� */,
    tlrybm               varchar(100)         not null/* �μ�������Ա���� */,
    cjtlmd               varchar(500)         not null/* �μ�������Ա���� */,
    zyzwlbdm             varchar(10)          not null/* רҵ����ְ�������� */,
    zyzwlbmc             varchar(50)          not null/* רҵ����ְ��������� */,
    zjswyymc             varchar(128)         not null/* ֱ������ԭ������ */,
    zjswyybm             varchar(64)          not null/* ֱ������ԭ����� */,
    swtljl               nvarchar(2000)       not null/* �������ۼ�¼ */,
    zcrzjyj              nvarchar(2000)       not null/* �������ܽ���� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SWBLTLJL_SWZD     סԺ���̼�¼�������������ۼ�¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SWBLTLJL_SWZD') )
 create table  DC_ZYBCJL_SWBLTLJL_SWZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    swzdbm               varchar(100)         not null/* ������ϱ��� */,
    swzdmc               varchar(500)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SWJL     סԺ���̼�¼��������¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SWJL') )
 create table  DC_ZYBCJL_SWJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zzjgdm               varchar(10)          not null/* ҽ�ƻ�����֯�������� */,
    zzjgmc               varchar(70)          not null/* ҽ�ƻ�����֯�������� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bfmc                 varchar(50)          not null/* �������� */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    ryzdbm               varchar(64)          not null/* ��Ժ��ϱ��� */,
    ryzdmc               varchar(128)         not null/* ��Ժ������� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    swrq                 datetime             not null/* ��������ʱ�� */,
    zjswyymc             varchar(128)         not null/* ֱ������ԭ������ */,
    zjswyybm             varchar(64)          not null/* ֱ������ԭ����� */,
    swzdmc               varchar(128)         not null/* ����������� */,
    swzdbm               varchar(64)          not null/* ������ϱ��� */,
    jstysjbz             char(1)              not null/* �����Ƿ�ͬ��ʬ����ʱ�־ */,
    zyysbm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    qmrq                 datetime             not null/* ǩ������ʱ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SWJL_RYZD     סԺ���̼�¼��������¼_��Ժ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SWJL_RYZD') )
 create table  DC_ZYBCJL_SWJL_RYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ryzdbm               varchar(64)          not null/* ��Ժ��ϱ��� */,
    ryzdmc               varchar(128)         not null/* ��Ժ������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_SWJL_SWZD     סԺ���̼�¼��������¼_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_SWJL_SWZD') )
 create table  DC_ZYBCJL_SWJL_SWZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    swzdmc               varchar(128)         not null/* ����������� */,
    swzdbm               varchar(64)          not null/* ������ϱ��� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_YNBLTLJL     סԺ���̼�¼�����Ѳ������ۼ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_YNBLTLJL') )
 create table  DC_ZYBCJL_YNBLTLJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    rybfmc               varchar(50)          not null/* ��Ժ�������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    tlrq                 datetime             not null/* ��������ʱ�� */,
    tldddm               varchar(20)          not null/* ���۵ص���� */,
    tldd                 varchar(50)          not null/* ���۵ص� */,
    tlrybm               varchar(100)         not null/* ������Ա���� */,
    cjtlrmd              varchar(500)         not null/* �μ�������Ա���� */,
    zcrbm                varchar(100)         not null/* �����˹��� */,
    zcrxm                varchar(500)         not null/* ���������� */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա�˵�� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tlyj                 nvarchar(2000)       not null/* ������� */,
    bzlzms               nvarchar(1000)       null/* ��֤������ϸ���� */,
    zycfyznr             nvarchar(1000)       null/* ��ҩ����ҽ������ */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    zcrzjyj              nvarchar(2000)       null/* �������ܽ���� */,
    ysbm                 varchar(20)          not null/* ǩ���˹��� */,
    ysqm                 varchar(50)          not null/* ǩ�������� */,
    zzysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zrysbm               varchar(20)          not null/* ����ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_YNBLTLJL_ZYSZGCJG     סԺ���̼�¼�����Ѳ������ۼ�¼_��ҽ����۲���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_YNBLTLJL_ZYSZGCJG') )
 create table  DC_ZYBCJL_YNBLTLJL_ZYSZGCJG (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYBCJL_ZKJL     סԺ���̼�¼��ת�Ƽ�¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYBCJL_ZKJL') )
 create table  DC_ZYBCJL_ZKJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    zyh                  varchar(64)          not null/* סԺ�ű�ʶ */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    rybfmc               varchar(50)          not null/* ��Ժ�������� */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    hzcsrq               datetime             null/* ���߳������� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    ryrq                 datetime             not null/* ��Ժ����ʱ�� */,
    zs                   nvarchar(100)        not null/* ���� */,
    ryqk                 nvarchar(2000)       not null/* ��Ժ��� */,
    zyszgcjg             nvarchar(1000)       null/* ��ҽ������۲��� */,
    rzxyzdbm             varchar(64)          not null/* ��Ժ���-��ҽ��ϱ��� */,
    rzxyzd               varchar(128)         not null/* ��Ժ���-��ҽ������� */,
    rzzybmdm             varchar(64)          null/* ��Ժ���-��ҽ�������� */,
    rzzybm               varchar(128)         null/* ��Ժ���-��ҽ�������� */,
    rzzyzhdm             varchar(64)          null/* ��Ժ���-��ҽ֤����� */,
    rzzyzh               varchar(128)         null/* ��Ժ���-��ҽ֤������ */,
    zfbm                 varchar(20)          null/* �����η����� */,
    zzzf                 nvarchar(100)        null/* �����η����� */,
    zlgcms               nvarchar(2000)       not null/* ���ƹ������� */,
    mqqk                 nvarchar(2000)       not null/* Ŀǰ��� */,
    mqzdxyzdbm           varchar(64)          not null/* Ŀǰ���-��ҽ��ϱ��� */,
    mqzdxyzd             varchar(128)         not null/* Ŀǰ���-��ҽ������� */,
    mqzdzybmdm           varchar(64)          null/* Ŀǰ���-��ҽ�������� */,
    mqzdzybm             varchar(128)         null/* Ŀǰ���-��ҽ�������� */,
    mqzdzyzhdm           varchar(64)          null/* Ŀǰ���-��ҽ֤����� */,
    mqzdzyzh             varchar(128)         null/* Ŀǰ���-��ҽ֤������ */,
    zkmd                 nvarchar(200)        not null/* ת��Ŀ�� */,
    zrzljh               nvarchar(2000)       not null/* ת�����Ƽƻ� */,
    zycfyznr             nvarchar(1000)       null/* ��ҩ����ҽ������ */,
    zyjzff               nvarchar(100)        null/* ��ҩ���󷽷� */,
    zyyyff               nvarchar(100)        null/* ��ҩ��ҩ���� */,
    zysx                 nvarchar(1000)       not null/* ע������ */,
    zkjllx               char(1)              not null/* ת�Ƽ�¼���� */,
    zkjllxmc             varchar(20)          not null/* ת�Ƽ�¼�������� */,
    zcrq                 datetime             not null/* ת������ʱ�� */,
    zcksdm               varchar(10)          not null/* ת�����Ҵ��� */,
    zcks                 varchar(50)          not null/* ת���������� */,
    zcysbm               varchar(20)          not null/* ת��ҽʦ���� */,
    zcysqm               varchar(50)          not null/* ת��ҽʦǩ�� */,
    zrrq                 datetime             not null/* ת������ʱ�� */,
    zrksdm               varchar(10)          not null/* ת����Ҵ��� */,
    zrks                 varchar(50)          not null/* ת��������� */,
    zrysbm               varchar(20)          not null/* ת��ҽʦ���� */,
    zrysqm               varchar(50)          not null/* ת��ҽʦǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYYZ_ZYYZ     סԺҽ����סԺҽ��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYYZ_ZYYZ') )
 create table  DC_ZYYZ_ZYYZ (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    ksdm                 varchar(10)          not null/* ���Ҵ��� */,
    ksmc                 varchar(50)          not null/* �������� */,
    bqdm                 varchar(10)          not null/* �������� */,
    bqmc                 varchar(50)          not null/* �������� */,
    zyh                  varchar(50)          not null/* סԺ�ű�ʶ */,
    bfh                  varchar(10)          not null/* ������ */,
    bch                  varchar(10)          not null/* ������ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    nls                  numeric(3)           not null/* ���䣨�꣩ */,
    nly                  varchar(8)           null/* ���䣨�£� */,
    tzkg                 numeric(6,2)         not null/* ���أ�kg�� */,
    yzlbdm               varchar(2)           not null/* ҽ�������� */,
    yzlbmc               varchar(50)          not null/* ҽ��������� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYYZ_ZYYZ_YZMX     סԺҽ����סԺҽ��_ҽ����ϸ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYYZ_ZYYZ_YZMX') )
 create table  DC_ZYYZ_ZYYZ_YZMX (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          not null/* ��Դ��¼��� */,
    dzsqdbh              varchar(20)          not null/* �������뵥��� */,
    cfypzh               varchar(50)          not null/* ����ҩƷ��� */,
    yzxmlxdm             varchar(2)           not null/* ҽ����Ŀ���ʹ��� */,
    yzxmlxmc             varchar(50)          not null/* ҽ����Ŀ�������� */,
    yzxmnr               varchar(100)         not null/* ҽ����Ŀ���� */,
    yzjhksrqsj           datetime             not null/* ҽ���ƻ���ʼ����ʱ�� */,
    yzjhjsrqsj           datetime             not null/* ҽ���ƻ���������ʱ�� */,
    yzbzxx               varchar(100)         null/* ҽ����ע��Ϣ */,
    yzklzdm              varchar(20)          not null/* ҽ�������߹��� */,
    yzklzqm              varchar(50)          not null/* ҽ��������ǩ�� */,
    yzklrqsj             datetime             not null/* ҽ����������ʱ�� */,
    yzklksdm             varchar(11)          not null/* ҽ���������ұ��� */,
    yzklksmc             varchar(50)          not null/* ҽ�������������� */,
    yzshrdm              varchar(20)          not null/* ҽ������˹��� */,
    yzshrqm              varchar(50)          not null/* ҽ�������ǩ�� */,
    yzshrqsj             datetime             not null/* ҽ���������ʱ�� */,
    hdyzhsdm             varchar(20)          not null/* �˶�ҽ����ʿ���� */,
    hdyzhsqm             varchar(50)          not null/* �˶�ҽ����ʿǩ�� */,
    yzhdrqsj             datetime             not null/* ҽ���˶�����ʱ�� */,
    yzzxzdm              varchar(20)          not null/* ҽ��ִ���߹��� */,
    yzzxzqm              varchar(50)          not null/* ҽ��ִ����ǩ�� */,
    yzzxrqsj             datetime             not null/* ҽ��ִ������ʱ�� */,
    yzzxksdm             varchar(20)          not null/* ҽ��ִ�п��ұ��� */,
    yzzxksmc             varchar(50)          not null/* ҽ��ִ�п������� */,
    yzzxzt               varchar(50)          not null/* ҽ��ִ��״̬ */,
    yztzrqsj             datetime             not null/* ҽ��ֹͣ����ʱ�� */,
    tzyzzdm              varchar(20)          not null/* ֹͣҽ���߹��� */,
    tzyzzqm              varchar(50)          not null/* ֹͣҽ����ǩ�� */,
    yzqxrqsj             datetime             not null/* ҽ��ȡ������ʱ�� */,
    qxyzzdm              varchar(20)          not null/* ȡ��ҽ���߹��� */,
    qxyzzqm              varchar(50)          not null/* ȡ��ҽ����ǩ�� */,
    
   

    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY     ������ҳ����ҽסԺ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY') )
 create table  DC_ZYZYBA_BASY (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    yljgzzjgdm           varchar(10)          not null/* ҽ�ƻ������� */,
    yljgzzjgmc           varchar(70)          not null/* ҽ�ƻ������� */,
    ylfffsdm             varchar(2)           not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    ylfffsmc             varchar(50)          not null/* ҽ�Ƹ��ѷ�ʽ���� */,
    jmjkkh               varchar(18)          not null/* ���񽡿����� */,
    zycs                 numeric(3)           not null/* סԺ���� */,
    bah                  varchar(18)          not null/* ������ */,
    zyh                  varchar(20)          not null/* סԺ�� */,
    xm                   varchar(50)          not null/* ���� */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 not null/* �������� */,
    nls                  numeric(3)           not null/* ���䣨�£� */,
    nly                  varchar(8)           null/* ���䣨�꣩ */,
    gjdm                 varchar(3)           not null/* �������� */,
    gjmc                 varchar(100)         not null/* �������� */,
    xsecstzg             numeric(4)           null/* �������������أ�g�� */,
    xserytzg             numeric(4)           null/* ��������Ժ���أ�g�� */,
    csd_s                varchar(70)          not null/* ������-ʡ����������ֱϽ�У� */,
    csd_cs               varchar(70)          not null/* ������-�У��������ݣ� */,
    csd_xq               varchar(70)          not null/* ������-�أ����� */,
    jg_s                 varchar(70)          not null/* ����-ʡ����������ֱϽ�У� */,
    jg_cs                varchar(70)          not null/* ����-�У��������ݣ� */,
    mzdm                 varchar(2)           not null/* ���� */,
    mzmc                 varchar(50)          not null/* �������� */,
    hzsfzjlbdm           varchar(2)           not null/* �������֤�������� */,
    hzsfzjlbmc           varchar(64)          not null/* �������֤��������� */,
    hzsfzjhm             varchar(18)          not null/* �������֤������ */,
    zylbdm               varchar(2)           null/* ְҵ������ */,
    zylbmc               varchar(18)          null/* ְҵ������� */,
    hyzkdm               varchar(2)           not null/* ����״������ */,
    hyzkmc               varchar(18)          not null/* ����״������ */,
    xzz_s                varchar(70)          not null/* ��סַ-ʡ����������ֱϽ�У� */,
    xzz_cs               varchar(70)          not null/* ��סַ-�У��������ݣ� */,
    xzz_xq               varchar(70)          not null/* ��סַ-�أ����� */,
    xzz_xz               varchar(70)          not null/* ��סַ-�磨�򡢽ֵ����´��� */,
    xzz_c                varchar(70)          not null/* ��סַ-�壨�֡�·��Ū�ȣ� */,
    xzz_mphm             varchar(70)          not null/* ��סַ-���ƺ��� */,
    dhhm                 varchar(20)          not null/* �绰���� */,
    xzz_yzbm             numeric(6)           not null/* ��סַ-�������� */,
    hkdz_s               varchar(70)          not null/* ���ڵ�ַ-ʡ����������ֱϽ�У� */,
    hkdz_cs              varchar(70)          not null/* ���ڵ�ַ-�У��������ݣ� */,
    hkdz_xq              varchar(70)          not null/* ���ڵ�ַ-�أ����� */,
    hkdz_xz              varchar(70)          not null/* ���ڵ�ַ-�磨�򡢽ֵ����´��� */,
    hkdz_c               varchar(70)          not null/* ���ڵ�ַ-�壨�֡�·��Ū�ȣ� */,
    hkdz_mphm            varchar(70)          not null/* ���ڵ�ַ-���ƺ��� */,
    hkdz_yzbm            numeric(6)           not null/* ���ڵ�ַ-�������� */,
    gzdwmc               varchar(70)          not null/* ������λ���� */,
    gzdwdz_s             varchar(70)          not null/* ������λ��ַ-ʡ����������ֱϽ�У� */,
    gzdwdz_cs            varchar(70)          not null/* ������λ��ַ-�У��������ݣ� */,
    gzdwdz_xq            varchar(70)          not null/* ������λ��ַ-�أ����� */,
    gzdwdz_xz            varchar(70)          not null/* ������λ��ַ-�磨�򡢽ֵ����´��� */,
    gzdwdz_c             varchar(70)          not null/* ������λ��ַ-�壨�֡�·��Ū�ȣ� */,
    gzdwdz_mphm          varchar(70)          not null/* ������λ��ַ-���ƺ��� */,
    gzdwdhhm             varchar(20)          not null/* ������λ�绰���� */,
    gzdwdz_yzbm          numeric(6)           not null/* ������λ��ַ-�������� */,
    lxrxm                varchar(50)          not null/* ��ϵ������ */,
    lxryhzdgxdm          varchar(2)           not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    lxryhzdgxmc          varchar(50)          not null/* ��ϵ���뻼�ߵĹ�ϵ���� */,
    lxrdz_s              varchar(70)          not null/* ��ϵ�˵�ַ-ʡ����������ֱϽ�У� */,
    lxrdz_cs             varchar(70)          not null/* ��ϵ�˵�ַ-�У��������ݣ� */,
    lxrdz_xq             varchar(70)          not null/* ��ϵ�˵�ַ-�أ����� */,
    lxrdz_xz             varchar(70)          not null/* ��ϵ�˵�ַ-�磨�򡢽ֵ����´��� */,
    lxrdz_c              varchar(70)          not null/* ��ϵ�˵�ַ-�壨�֡�·��Ū�ȣ� */,
    lxrdz_mphm           varchar(70)          not null/* ��ϵ�˵�ַ-���ƺ��� */,
    lxrdhhm              varchar(20)          not null/* ��ϵ�˵绰���� */,
    rytjdm               varchar(2)           not null/* ��Ժ;������ */,
    rytjmc               varchar(20)          not null/* ��Ժ;������ */,
    zllbdm               varchar(2)           not null/* ���������� */,
    zllbmc               varchar(100)         not null/* ����������� */,
    ryrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    rykbdm               varchar(11)          not null/* ��Ժ�Ʊ���� */,
    rykb                 varchar(50)          not null/* ��Ժ�Ʊ����� */,
    rybf                 varchar(10)          not null/* ��Ժ���� */,
    zkkb                 varchar(50)          null/* ת�ƿƱ� */,
    cyrqsj               datetime             not null/* ��Ժ����ʱ�� */,
    cykbdm               varchar(11)          not null/* ��Ժ�Ʊ���� */,
    cykbmc               varchar(50)          not null/* ��Ժ�Ʊ� */,
    cybf                 varchar(10)          not null/* ��Ժ���� */,
    sjzyts               numeric(4)           not null/* ʵ��סԺ���� */,
    sslcljbzdm           varchar(2)           not null/* ʵʩ�ٴ�·����־���� */,
    sslcljbzmc           varchar(50)          not null/* ʵʩ�ٴ�·����־���� */,
    syyljgzyzjbz         char(1)              null/* ʹ��ҽ�ƻ�����ҩ�Ƽ���־ */,
    syzyzlsbbz           char(1)              null/* ʹ����ҽ�����豸��־ */,
    syzyzljsbz           char(1)              null/* ʹ����ҽ���Ƽ�����־ */,
    bzshbz               char(1)              null/* ��֤ʩ����־ */,
    sszddwbyyjbbm        varchar(64)          not null/* �����ж����ⲿԭ�򼲲����� */,
    sszddwbyyjbmc        varchar(128)         not null/* �����ж����ⲿԭ�� */,
    swhzsjbz             char(1)              null/* ��������ʬ���־ */,
    aboxxdm              varchar(2)           not null/* ABOѪ�ʹ��� */,
    aboxxmc              varchar(8)           not null/* ABOѪ������ */,
    rhxxdm               varchar(2)           not null/* RhѪ�ʹ��� */,
    rhxxmc               varchar(8)           not null/* RhѪ������ */,
    kzrdm                varchar(20)          not null/* �����ι��� */,
    kzrqm                varchar(50)          not null/* ������ǩ�� */,
    zrfzrysdm            varchar(20)          not null/* ���Σ������Σ�ҽʦ���� */,
    zrfzrysqm            varchar(50)          not null/* ���Σ������Σ�ҽʦǩ�� */,
    zzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    zzysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    zyysdm               varchar(20)          not null/* סԺҽʦ���� */,
    zyysqm               varchar(50)          not null/* סԺҽʦǩ�� */,
    zrhsdm               varchar(20)          not null/* ���λ�ʿ���� */,
    zrhsqm               varchar(50)          not null/* ���λ�ʿǩ�� */,
    jxysdm               varchar(20)          not null/* ����ҽʦ���� */,
    jxysqm               varchar(50)          not null/* ����ҽʦǩ�� */,
    sxysdm               varchar(20)          not null/* ʵϰҽʦ���� */,
    sxysqm               varchar(50)          not null/* ʵϰҽʦǩ�� */,
    bydm                 varchar(20)          not null/* ����Ա���� */,
    bym                  varchar(50)          not null/* ����Աǩ�� */,
    bazldm               varchar(2)           not null/* ������������ */,
    bazlmc               varchar(50)          not null/* ������������ */,
    zkysdm               varchar(20)          not null/* �ʿ�ҽʦ���� */,
    zkysqm               varchar(50)          not null/* �ʿ�ҽʦǩ�� */,
    zkhsdm               varchar(20)          not null/* �ʿػ�ʿ���� */,
    zkhsqm               varchar(50)          not null/* �ʿػ�ʿǩ�� */,
    zkrq                 date                 not null/* �ʿ����� */,
    ssjczbm              varchar(64)          not null/* �������������� */,
    ssjczrq              datetime             not null/* �������������� */,
    ssjbdm               varchar(2)           not null/* ����������� */,
    ssjbmc               varchar(50)          not null/* ������������ */,
    ssjczmc              varchar(128)         not null/* �������������� */,
    sszdm                varchar(20)          not null/* �����߹��� */,
    sszxm                varchar(50)          not null/* ���������� */,
    yzdm                 varchar(20)          not null/* �������� */,
    yzxm                 varchar(50)          not null/* �������� */,
    ezdm                 varchar(20)          not null/* �������� */,
    ezxm                 varchar(50)          not null/* �������� */,
    ssqklbdm             varchar(2)           not null/* �����п������� */,
    ssqklbmc             varchar(100)         not null/* �����п�������� */,
    qkyhdjdm             varchar(2)           not null/* �п����ϵȼ����� */,
    qkyhdjmc             varchar(100)         not null/* �п����ϵȼ����� */,
    mzffdm               numeric(2)           not null/* ���������� */,
    mzffmc               varchar(50)          not null/* ���������� */,
    mzysdm               varchar(20)          not null/* ����ҽʦ���� */,
    mzysxm               varchar(50)          not null/* ����ҽʦ���� */,
    lyfsdm               varchar(2)           not null/* ��Ժ��ʽ���� */,
    lyfsmc               varchar(100)         not null/* ��Ժ��ʽ���� */,
    njsyljgdm            varchar(20)          null/* �����ҽ�ƻ������� */,
    njsyljgmc            varchar(70)          null/* �����ҽ�ƻ������� */,
    cy31dnzzybz          char(1)              not null/* ��Ժ31d����סԺ��־ */,
    cy31dnzzymd          varchar(100)         null/* ��Ժ31d����סԺĿ�� */,
    lnsshzryqhmsj_d      numeric(5)           not null/* ­�����˻�����Ժǰ����ʱ��-d */,
    lnsshzryqhmsj_h      numeric(2)           not null/* ­�����˻�����Ժǰ����ʱ��-h */,
    lnsshzryqhmsj_min    numeric(2)           not null/* ­�����˻�����Ժǰ����ʱ��-min */,
    lnsshzryhhmsj_d      numeric(5)           not null/* ­�����˻�����Ժ�����ʱ��-d */,
    lnsshzryhhmsj_h      numeric(2)           not null/* ­�����˻�����Ժ�����ʱ��-h */,
    lnsshzryhhmsj_min    numeric(2)           not null/* ­�����˻�����Ժ�����ʱ��-min */,
    zyzfy                numeric(10,2)        not null/* סԺ�ܷ��� */,
    zyzfy_zfje           numeric(10,2)        not null/* סԺ�ܷ���-�Ը���� */,
    zhylfwl_ybylfwf      numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ��ҽ�Ʒ���� */,
    zhylfwl_ybylfwf_zybzlzf numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ��ҽ�Ʒ����-��ҽ��֤���η� */,
    zhylfwl_ybylfwf_zybzlzhzf numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ��ҽ�Ʒ����-��ҽ��֤���λ���� */,
    zhylfwl_ybzlczf      numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-һ�����Ʋ����� */,
    zhylfwl_hlf          numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-����� */,
    zhylfwl_qtfy         numeric(10,2)        not null/* �ۺ�ҽ�Ʒ�����-�������� */,
    zdl_blzdf            numeric(10,2)        not null/* �����-������Ϸ� */,
    zdl_syszdf           numeric(10,2)        not null/* �����-ʵ������Ϸ� */,
    zdl_yxxzdf           numeric(10,2)        not null/* �����-Ӱ��ѧ��Ϸ� */,
    zdl_lczdxmf          numeric(10,2)        not null/* �����-�ٴ������Ŀ�� */,
    zll_fsszlxmf         numeric(10,2)        not null/* ������-������������Ŀ�� */,
    zll_fsszlxmf_lcwlzlf numeric(10,2)        not null/* ������-������������Ŀ��-�ٴ��������Ʒ� */,
    zll_sszlf            numeric(10,2)        not null/* ������-�������Ʒ� */,
    zll_sszlf_mzf        numeric(10,2)        not null/* ������-�������Ʒ�-����� */,
    zll_sszlf_ssf        numeric(10,2)        not null/* ������-�������Ʒ�-������ */,
    kfl_kff              numeric(10,2)        not null/* ������-������ */,
    zyl_zyzdf            numeric(10,2)        not null/* ��ҽ��-��ҽ��Ϸ� */,
    zyl_zyzlf            numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ� */,
    zyl_zyzlf_zywzf      numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-��ҽ���η� */,
    zyl_zyzlf_zygsf      numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-��ҽ���˷� */,
    zyl_zyzlf_zcyjff     numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-�����ķ��� */,
    zyl_zyzlf_zytnzlf    numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-��ҽ�������Ʒ� */,
    zyl_zyzlf_zygczlf    numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-��ҽ�س����Ʒ� */,
    zyl_zyzlf_zytszlf    numeric(10,2)        not null/* ��ҽ��-��ҽ���Ʒ�-��ҽ�������Ʒ� */,
    zyl_zyqtf            numeric(10,2)        not null/* ��ҽ��-��ҽ������ */,
    zyl_zyqtf_zytsdpjgf  numeric(10,2)        not null/* ��ҽ��-��ҽ������-��ҽ�������ӹ��� */,
    zyl_zyqtf_bzssf      numeric(10,2)        not null/* ��ҽ��-��ҽ������-��֤ʩ�ŷ� */,
    xyl_xyf              numeric(10,2)        not null/* ��ҩ��-��ҩ�� */,
    xyl_xyf_kjywfy       numeric(10,2)        not null/* ��ҩ��-��ҩ��-����ҩ����� */,
    zyl_zchenyf          numeric(10,2)        not null/* ��ҩ��-�г�ҩ�� */,
    zyl_zcyf_yljgzyzjf   numeric(10,2)        not null/* ��ҩ��-�г�ҩ��-ҽ�ƻ�����ҩ�Ƽ��� */,
    zyl_zcyf             numeric(10,2)        not null/* ��ҩ��-�в�ҩ�� */,
    xyhxyzpl_xf          numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-Ѫ�� */,
    xyhxyzpl_bdblzpf     numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-�׵�������Ʒ�� */,
    xyhxyzpl_qdblzpf     numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-�򵰰�����Ʒ�� */,
    xyhxyzpl_nxyzlzpf    numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-��Ѫ��������Ʒ�� */,
    xyhxyzpl_xbyzlzpf    numeric(10,2)        not null/* ѪҺ��ѪҺ��Ʒ��-ϸ����������Ʒ�� */,
    hcl_jcyycxyyclf      numeric(10,2)        not null/* �Ĳ���-�����һ����ҽ�ò��Ϸ� */,
    hcl_zlyycxyyclf      numeric(10,2)        not null/* �Ĳ���-������һ����ҽ�ò��Ϸ� */,
    hcl_ssyycxyyclf      numeric(10,2)        not null/* �Ĳ���-������һ����ҽ�ò��Ϸ� */,
    qtl_qtf              numeric(10,2)        not null/* ������-������ */,
    
   
    
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_BLZD     ������ҳ����ҽסԺ����_�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_BLZD') )
 create table  DC_ZYZYBA_BASY_BLZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    blhm                 varchar(18)          not null/* ����� */,
    blzdjbbm             varchar(64)          not null/* ������ϼ������� */,
    blzdmc               varchar(128)         not null/* ����������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_CYXYQTZD     ������ҳ����ҽסԺ����_��Ժ��ҽ�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_CYXYQTZD') )
 create table  DC_ZYZYBA_BASY_CYXYQTZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyxyzd_qtzdjbbm      varchar(64)          not null/* ��Ժ��ҽ���-������ϼ������� */,
    cyxyzd_qtzdmc        varchar(128)         not null/* ��Ժ��ҽ���-����������� */,
    cyxyzd_qtzd_rybqdm   varchar(64)          not null/* ��Ժ��ҽ���-�������-��Ժ������� */,
    cyxyzd_qtzd_rybqmc   varchar(128)         not null/* ��Ժ��ҽ���-�������-��Ժ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_CYXYZZD     ������ҳ����ҽסԺ����_��Ժ��ҽ��Ҫ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_CYXYZZD') )
 create table  DC_ZYZYBA_BASY_CYXYZZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyxyzd_zyzdmc        varchar(128)         not null/* ��Ժ��ҽ���-��Ҫ������� */,
    cyxyzd_zyzdjbbm      varchar(64)          not null/* ��Ժ��ҽ���-��Ҫ��ϼ������� */,
    cyxyzd_zyzd_rybqdm   varchar(64)          not null/* ��Ժ��ҽ���-��Ҫ���-��Ժ������� */,
    cyxyzd_zyzd_rybqmc   varchar(128)         not null/* ��Ժ��ҽ���-��Ҫ���-��Ժ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_CYZYBM     ������ҳ����ҽסԺ����_��Ժ��ҽ�������                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_CYZYBM') )
 create table  DC_ZYZYBA_BASY_CYZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyzyzd_zbbm          varchar(64)          not null/* ��Ժ��ҽ���-�������� */,
    cyzyzd_zbmc          varchar(128)         not null/* ��Ժ��ҽ���-�������� */,
    cyzyzd_zb_rybqdm     varchar(64)          not null/* ��Ժ��ҽ���-����-��Ժ������� */,
    cyzyzd_zb_rybqmc     varchar(128)         not null/* ��Ժ��ҽ���-����-��Ժ�������� */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_CYZYZH     ������ҳ����ҽסԺ����_��Ժ��ҽ�����֤                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_CYZYZH') )
 create table  DC_ZYZYBA_BASY_CYZYZH (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    cyzyzd_zzbm          varchar(64)          not null/* ��Ժ��ҽ���-��֤���� */,
    cyzyzd_zzmc          varchar(128)         not null/* ��Ժ��ҽ���-��֤���� */,
    cyzyzd_zz_rybqdm     varchar(64)          not null/* ��Ժ��ҽ���-��֤-��Ժ������� */,
    cyzyzd_zz_rybqmc     varchar(128)         not null/* ��Ժ��ҽ���-��֤-��Ժ�������� */,
    
   
    
    
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_GMS     ������ҳ����ҽסԺ����_����ʷ                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_GMS') )
 create table  DC_ZYZYBA_BASY_GMS (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    ywgmbz               char(1)              not null/* ҩ�������־ */,
    gmyw                 varchar(1000)        not null/* ����ҩ�� */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_MJZXYZD     ������ҳ����ҽסԺ����_�ż�����ҽ���                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_MJZXYZD') )
 create table  DC_ZYZYBA_BASY_MJZXYZD (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    mjzzdxyzdjbbm        varchar(64)          not null/* �ţ���������ϣ���ҽ��ϣ��������� */,
    mjzzdxyzdmc          varchar(128)         not null/* �ţ���������ϣ���ҽ��ϣ����� */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_MJZZYBM     ������ҳ����ҽסԺ����_�ż�����ҽ����                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_MJZZYBM') )
 create table  DC_ZYZYBA_BASY_MJZZYBM (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    mjzzdzyzdbmbm        varchar(64)          not null/* �ţ���������ϣ���ҽ��ϣ��������� */,
    mjzzdzyzdmc          varchar(128)         not null/* �ţ���������ϣ���ҽ��ϣ����� */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZYZYBA_BASY_MJZZYZH     ������ҳ����ҽסԺ����_�ż�����ҽ֢��                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZYZYBA_BASY_MJZZYZH') )
 create table  DC_ZYZYBA_BASY_MJZZYZH (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    zyjlxh               varchar(64)          null/* ����ԭ��¼��� */,
    mjzzdzyzhzhbm        varchar(64)          not null/* �ţ���������ϣ���ҽ֤��֤����� */,
    mjzzdzyzhmc          varchar(128)         not null/* �ţ���������ϣ���ҽ֤������ */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go

/*========================================================================*/
 /* DC_ZZYJL_ZZYJL     ת(��)Ժ��¼��ת���Ժ��¼                                                                                                  */
 /*========================================================================*/
 if not exists 
(select 1 from sysobjects 
where id = object_id('DC_ZZYJL_ZZYJL') )
 create table  DC_ZZYJL_ZZYJL (    
    xh                   numeric(12)          identity(1, 1)/* ���  */,
    yljgdm               varchar(20)          not null/* ҽ�ƻ�������  */,
    jzlsh                varchar(64)          not null/* ������ˮ�� */,
    patid                varchar(64)          not null/* ����patid */,
    jzlb                 varchar(2)           not null/* ������� */,
    yjlxh                varchar(64)          not null/* Դ��¼��� */,
    jkkh                 varchar(18)          not null/* ���񽡿����� */,
    mjzh                 varchar(18)          null/* �ż���� */,
    zyh                  varchar(64)          null/* סԺ�ű�ʶ */,
    hzxm                 varchar(50)          not null/* �������� */,
    sfzhm                varchar(18)          not null/* �������֤�ű�ʶ */,
    xbdm                 varchar(2)           not null/* �Ա���� */,
    xbmc                 varchar(16)          not null/* �Ա����� */,
    csrq                 date                 not null/* �������� */,
    gms                  nvarchar(1000)       not null/* ����ʷ */,
    jbs                  nvarchar(1000)       not null/* ����ʷ */,
    sss                  nvarchar(1000)       not null/* ����ʷ */,
    zzrq                 datetime             not null/* ת�Ժ������ */,
    zzyy                 nvarchar(100)        not null/* ת��ԭ�� */,
    zzjl                 varchar(2000)        not null/* ת���¼ */,
    ysbm                 varchar(20)          not null/* ת��ҽʦ���� */,
    zzysxm               varchar(50)          not null/* ת��ҽʦ���� */,
    jbzdbm               varchar(64)          not null/* ������ϱ��� */,
    jbzd                 varchar(128)         not null/* ����������� */,
    zdrq                 date                 not null/* ������� */,
    zdyljgdm             varchar(10)          not null/* ���ҽ�ƻ������� */,
    zdjgmc               nvarchar(70)         null/* ��ϻ������� */,
    xgzz                 nvarchar(1000)       null/* ���֢״ */,
    zyzlcs               nvarchar(1000)       null/* ��Ҫ���ƴ�ʩ */,
    fzjcjg               varchar(1000)        null/* ��������� */,
    ssczbm               varchar(64)          null/* �������������� */,
    ssjczmc              varchar(128)         null/* �������������� */,
    ssczksrq             datetime             null/* ������������ʼ����ʱ�� */,
    zlfa                 nvarchar(1000)       null/* ���Ʒ��� */,
    czjh                 nvarchar(1000)       null/* ���üƻ� */,
    jkwtpg               nvarchar(2000)       null/* ������������ */,
    kfcszd               nvarchar(100)        null/* ������ʩָ�� */,
    zcjgdm               varchar(10)          not null/* ת��ҽ�ƻ������� */,
    zcjgmc               varchar(70)          not null/* ת��ҽ�ƻ������� */,
    zcjgksdm             varchar(20)          not null/* ת��ҽ�ƻ����ƴ��� */,
    zcjgksmc             varchar(50)          not null/* ת��ҽ�ƻ��������� */,
    zryljgdm             varchar(10)          not null/* ת��ҽ�ƻ������� */,
    zrjgmc               varchar(70)          not null/* ת��ҽ�ƻ������� */,
    zrjgksdm             varchar(20)          not null/* ת��ҽ�ƻ������Ҵ��� */,
    zrjgksmc             varchar(50)          not null/* ת��ҽ�ƻ����������� */,
	[isNew] [bit] NULL,
	[gxrqtimestr] [varchar](50) NULL,
	[timetempstr] [varbinary](8) NULL,
	[createtime] [datetime] NULL,
	[gxrq] [datetime] NOT NULL,
	[timetemp] [timestamp] NULL,
	[sys_id] [varchar](50) NOT NULL,
	[lsnid] [bigint] NULL,
	[isdelete] [varchar](10) NULL  
	)
go
