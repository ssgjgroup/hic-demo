package com.whb.es.test;
/**
 * 主表
 * @author LENOVO
 *
 */
public class SplitString {
	public static void main(String[] args) {
		String bmz = "DC_MJZBL_JZLGBL";
		String bzds = "xh            |       numeric(12)     _     identity(1 1)/* 序号  */,\n" +
				"    yljgdm        |       varchar(20)     _     not null/* 医疗机构代码  */,\n" +
				"    jzlsh         |       varchar(64)     _     not null/* 就诊流水号 */,\n" +
				"    patid         |       varchar(64)     _     not null/* 患者patid */,\n" +
				"    zyh           |       varchar(64)     _     not null/* 住院号 */,\n" +
				"    yjlxh         |       varchar(64)     _     not null/* 源记录序号 */,\n" +
				"    zzjgdm        |       varchar(10)     _     not null/* 医疗机构组织机构代码 */,\n" +
				"    zzjgmc        |       varchar(70)     _     not null/* 医疗机构组织机构名称 */,\n" +
				"    mjzh          |       varchar(64)     _     not null/* 门急诊号 */,\n" +
				"    ksdm          |       varchar(10)     _     not null/* 科室代码 */,\n" +
				"    ksmc          |       varchar(50)     _     not null/* 科室名称 */,\n" +
				"    hzxm          |       varchar(64)     _     not null/* 患者姓名 */,\n" +
				"    sfzhm         |       varchar(18)     _     not null/* 身份证号 */,\n" +
				"    xbdm          |       varchar(2)      _     not null/* 性别代码 */,\n" +
				"    xbmc          |       varchar(16)     _     not null/* 性别名称 */,\n" +
				"    csrq          |       date            _     not null/* 出生日期 */,\n" +
				"    nls           |       numeric(3)      _     not null/* 年龄（岁） */,\n" +
				"    nly           |       varchar(8)      _     null/* 年龄（月） */,\n" +
				"    jzrqsj        |       datetime        _     not null/* 就诊日期时间 */,\n" +
				"    czbzdm        |       varchar(2)      _     not null/* 初诊标志代码 */,\n" +
				"    czbzmc        |       varchar(18)     _     not null/* 初诊标志名称 */,\n" +
				"    srgcsrq       |       datetime        _     not null/* 收入观察室日期时间 */,\n" +
				"    zs            |       nvarchar(100)   _     not null/* 主诉 */,\n" +
				"    xbs           |       nvarchar(2000)  _     not null/* 现病史 */,\n" +
				"    jws           |       nvarchar(1000)  _     not null/* 既往史 */,\n" +
				"    tgjc          |       nvarchar(500)   _     not null/* 体格检查 */,\n" +
				"    zyszgcjg      |       nvarchar(1000)  _     null/* 中医“四诊”观察结果 */,\n" +
				"    fzjcxm        |       nvarchar(100)   _     null/* 辅助检查项目 */,\n" +
				"    fzjcjg        |       nvarchar(1000)  _     null/* 辅助检查结果 */,\n" +
				"    xyzdbm        |       varchar(64)     _     not null/* 初步诊断-西医诊断编码 */,\n" +
				"    xyzdmc        |       varchar(128)    _     not null/* 初步诊断-西医诊断名称 */,\n" +
				"    zybmdm        |       varchar(64)     _     not null/* 初步诊断-中医病名代码 */,\n" +
				"    zybmmc        |       varchar(128)    _     not null/* 初步诊断-中医病名名称 */,\n" +
				"    zyzhdm        |       varchar(64)     _     not null/* 初步诊断-中医证候代码 */,\n" +
				"    zyzhmc        |       varchar(128)    _     not null/* 初步诊断-中医证候名称 */,\n" +
				"    bzyj          |       nvarchar(100)   _     null/* 辨证依据 */,\n" +
				"    zfbm          |       varchar(20)     _     null/* 治则治法代码 */,\n" +
				"    zzzf          |       nvarchar(100)   _     null/* 治则治法 */,\n" +
				"    yzxmlx        |       varchar(2)      _     not null/* 医嘱项目类型代码 */,\n" +
				"    yzxmlxmc      |       sysname         _     not null/* 医嘱项目类型名称 */,\n" +
				"    yzxmnr        |       nvarchar(100)   _     not null/* 医嘱项目内容 */,\n" +
				"    yzbzxx        |       nvarchar(100)   _     not null/* 医嘱备注信息 */,\n" +
				"    yzklksdm      |       varchar(10)     _     not null/* 医嘱开立代码 */,\n" +
				"    yzklks        |       varchar(50)     _     not null/* 医嘱开立科室 */,\n" +
				"    yzklzdm       |       varchar(20)     _     not null/* 医嘱开立者工号 */,\n" +
				"    yzklzqm       |       varchar(50)     _     not null/* 医嘱开立者签名 */,\n" +
				"    yzklrq        |       datetime        _     not null/* 医嘱开立日期时间 */,\n" +
				"    yzshzdm       |       varchar(20)     _     not null/* 医嘱审核者工号 */,\n" +
				"    yzshzqm       |       varchar(50)     _     not null/* 医嘱审核者签名 */,\n" +
				"    yzshrq        |       datetime        _     not null/* 医嘱审核日期时间 */,\n" +
				"    yzzxksdm      |       varchar(10)     _     not null/* 医嘱执行代码 */,\n" +
				"    yzzxks        |       varchar(50)     _     not null/* 医嘱执行科室 */,\n" +
				"    yzzxzdm       |       varchar(20)     _     not null/* 医嘱执行者工号 */,\n" +
				"    yzzxzqm       |       varchar(50)     _     not null/* 医嘱执行者签名 */,\n" +
				"    yzzxrq        |       datetime        _     not null/* 医嘱执行日期时间 */,\n" +
				"    yzjhjsrq      |       datetime        _     not null/* 医嘱计划结束日期时间 */,\n" +
				"    yzzxzt        |       varchar(50)     _     not null/* 医嘱执行状态 */,\n" +
				"    qxyzzdm       |       varchar(20)     _     not null/* 取消医嘱者工号 */,\n" +
				"    qxyzzqm       |       varchar(50)     _     not null/* 取消医嘱者签名 */,\n" +
				"    yzqxrq        |       datetime        _     not null/* 医嘱取消日期时间 */,\n" +
				"    dzsqdbh       |       varchar(50)     _     not null/* 电子申请单编号 */,\n" +
				"    jzlgbcjl      |       nvarchar(2000)  _     not null/* 急诊留观病程记录 */,\n" +
				"    qjksrq        |       datetime        _     not null/* 抢救开始日期时间 */,\n" +
				"    qjjsrq        |       datetime        _     not null/* 抢救结束日期时间 */,\n" +
				"    jzqjjl        |       nvarchar(2000)  _     not null/* 急诊抢救记录 */,\n" +
				"    jlrqsj        |       datetime        _     not null/* 记录日期时间 */,\n" +
				"    zysx          |       nvarchar(1000)  _     not null/* 注意事项 */,\n" +
				"    cjqjrydm      |       varchar(100)    _     not null/* 参加抢救人员名单代码 */,\n" +
				"    cjqjrymd      |       varchar(500)    _     not null/* 参加抢救人员名单 */,\n" +
				"    zyjszwlb      |       varchar(8)      _     not null/* 专业技术职务类别代码 */,\n" +
				"    zyjszwlbmc    |       varchar(64)     _     not null/* 专业技术职务类别名称 */,\n" +
				"    hzqxdm        |       varchar(2)      _     not null/* 患者去向代码 */,\n" +
				"    hzqxmc        |       varchar(18)     _     not null/* 患者去向名称 */,\n" +
				"    zrysbm        |       varchar(20)     _     not null/* 责任医师工号 */,\n" +
				"    zrysqm        |       varchar(50)     _     not null/* 责任医师姓名 */,\n" +
				"    ysbm          |       varchar(20)     _     not null/* 签名医师工号 */,\n" +
				"    ysqm          |       varchar(50)     _     not null/* 签名医师名称 */,";
		String [] bzd = bzds.trim().split(",");
		String createHlhtTemp = "-- 创建临时表 \n select * into #"+bmz.replace("DC_", "HLHT_") +" from " + bmz.replace("DC_", "HLHT_")+" where STATUS = 0;\n";
		System.out.println(createHlhtTemp);
		String create_tempTable = "-- 主表操作 \n create table #"+ bmz +"( \r\n";
		for (int i = 0; i < bzd.length; i++) {
			create_tempTable = create_tempTable + bzd[i].replace("_","").replace("|", "").toString() + ",";
		}
		create_tempTable = create_tempTable + "\r\n" +
				"    isNew                bit                  NULL,\r\n" + 
				"    createtime           datetime             NULL,\r\n" + 
				"    gxrq                 datetime             NOT NULL,\r\n" + 
				"    sys_id               varchar(50)          NOT NULL,\r\n" + 
				"    lsnid                bigint               NULL,\r\n" + 
				"    isdelete             varchar(8)           NULL";
		create_tempTable = create_tempTable + "\r\n" + ")" + "\r\n";
		System.out.println(create_tempTable);
		
		String insert_tempTalbe = "insert into #"+ bmz + "\r\n" + "select @yljgdm,\r\n";
		String [] bzd1 = bzds.trim().replace(" ","").split(",");
		StringBuffer sb1 = new StringBuffer();
		for(int i = 2; i < bzd1.length; i++) {
			String [] st = bzd1[i].toString().split("\\|");
			String awer = st[1].split("_")[0].toString().replace(" ","").trim();
			String awer1 = st[0].split("_")[0].toString().replace(" ","").trim();
			sb1.append("       CONVERT(").append(awer).append(", \t").append(awer1).append("),\n");
		}
		insert_tempTalbe = insert_tempTalbe + sb1.toString() + "       1,\r\n       getdate(),\r\n       getdate(),\r\n       'EMR',\r\n       0,\r\n       '0' \r\nfrom #" + bmz.replace("DC_", "HLHT_") + "\r\n\r\n";
		System.out.printf("%s",insert_tempTalbe.toString());
		
		String mergeInto = "Merge Into "+bmz+" _target\r\n" + 
				"using #"+bmz+ " _source\r\n" + 
				"on(_target.yjlxh = _source.yjlxh)\r\n" + 
				"When Matched Then\r\n" +
				" Update set \r\n";
		String [] bzd2 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd2.length; i++) {
			String [] st = bzd2[i].toString().split("\\|");
			String whs = st[0].split("_")[0].toString().trim();
			String temp1 = "      _target." + whs +"=" + "_source." + whs;
			mergeInto = mergeInto + temp1 + ",\r\n";
		}
		System.out.print(mergeInto);
		String mergeInto1 = "      _target.gxrq=getdate()\r\n "
						+"When Not Matched By Target Then \r\n  Insert (";
		String [] bzd3 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd3.length; i++) {
			String [] st = bzd3[i].toString().split("\\|");
			mergeInto1 = mergeInto1 + st[0].split("_")[0].toString().trim() + ",";
		}
		System.out.print(mergeInto1);
		String mergeInto2 =  "isNew,createtime,gxrq,sys_id,lsnid,isdelete)\r\n"+ "  values (";
		
		String [] bzd4 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd4.length; i++) {
			String [] st = bzd4[i].toString().split("\\|");
			mergeInto2 = mergeInto2 + "_source." + st[0].split("_")[0].toString().trim() + ",";
		}
		mergeInto2 = mergeInto2 + "_source.isNew,_source.createtime,_source.gxrq,_source.sys_id,_source.lsnid,_source.isdelete);\r\n" + "drop table #" + bmz;
		System.out.println(mergeInto2.toString());
	}
}
