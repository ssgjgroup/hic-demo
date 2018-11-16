package com.whb.es.test;
/**
 * 主表
 * @author LENOVO
 *
 */
public class SplitString {
	public static void main(String[] args) {
		String bmz = "DC_ZYBCJL_SQTL";
		String bzds = "xh             |      numeric(12)    _      identity(1 1)/* 序号  */,\n" +
				"    yljgdm         |      varchar(20)    _      not null/* 医疗机构代码  */,\n" +
				"    jzlsh          |      varchar(64)    _      not null/* 就诊流水号 */,\n" +
				"    patid          |      varchar(64)    _      not null/* 患者patid */,\n" +
				"    zyh            |      varchar(64)    _      not null/* 住院号标识 */,\n" +
				"    yjlxh          |      varchar(64)    _      not null/* 源记录序号 */,\n" +
				"    ksdm           |      varchar(10)    _      not null/* 科室代码 */,\n" +
				"    ksmc           |      varchar(50)    _      not null/* 科室名称 */,\n" +
				"    bqdm           |      varchar(10)    _      not null/* 病区代码 */,\n" +
				"    bqmc           |      varchar(50)    _      not null/* 病区名称 */,\n" +
				"    bfh            |      varchar(10)    _      not null/* 病房号 */,\n" +
				"    bfmc           |      varchar(50)    _      not null/* 病房名称 */,\n" +
				"    bch            |      varchar(10)    _      not null/* 病床号 */,\n" +
				"    hzxm           |      varchar(50)    _      not null/* 患者姓名 */,\n" +
				"    sfzhm          |      varchar(18)    _      not null/* 患者身份证号标识 */,\n" +
				"    xbdm           |      varchar(2)     _      not null/* 性别代码 */,\n" +
				"    xbmc           |      varchar(16)    _      not null/* 性别名称 */,\n" +
				"    nls            |      numeric(3)     _      not null/* 年龄（岁） */,\n" +
				"    nly            |      varchar(8)     _      null/* 年龄（月） */,\n" +
				"    tlrq           |      datetime       _      not null/* 讨论日期时间 */,\n" +
				"    tldd           |      varchar(50)    _      not null/* 讨论地点 */,\n" +
				"    zcrbm          |      varchar(100)   _      not null/* 主持人工号 */,\n" +
				"    zcrxm          |      varchar(500)   _      not null/* 主持人姓名 */,\n" +
				"    tlrybm         |      varchar(100)   _      not null/* 参加讨论人员工号 */,\n" +
				"    cjtlmd         |      varchar(500)   _      not null/* 参加讨论人员名单 */,\n" +
				"    zyzwlbdm       |      varchar(4)     _      not null/* 专业技术职务类别代码 */,\n" +
				"    zyzwlbmc       |      varchar(50)    _      not null/* 专业技术职务类别名称 */,\n" +
				"    ryrq           |      datetime       _      not null/* 入院日期时间 */,\n" +
				"    ssczmc         |      varchar(128)   _      not null/* 拟实施手术及操作名称 */,\n" +
				"    ssczbm         |      varchar(64)    _      not null/* 拟实施手术及操作编码 */,\n" +
				"    ssmbbwdm       |      varchar(64)    _      not null/* 拟实施手术目标部位代码 */,\n" +
				"    ssbwmc         |      varchar(128)   _      not null/* 拟实施手术目标部位名称 */,\n" +
				"    ssczrq         |      datetime       _      not null/* 拟实施手术及操作日期时间 */,\n" +
				"    mzffdm         |      varchar(64)    _      not null/* 拟实施麻醉方法代码 */,\n" +
				"    mzffmc         |      varchar(128)   _      not null/* 拟实施麻醉方法名称 */,\n" +
				"    ssyd           |      nvarchar(200)  _      not null/* 手术要点 */,\n" +
				"    sqzb           |      nvarchar(1000) _      not null/* 术前准备 */,\n" +
				"    sszz           |      nvarchar(500)  _      not null/* 手术指征 */,\n" +
				"    ssfa           |      nvarchar(1000) _      not null/* 手术方案 */,\n" +
				"    zysx           |      nvarchar(1000) _      not null/* 注意事项 */,\n" +
				"    tlyj           |      nvarchar(2000) _      not null/* 讨论意见 */,\n" +
				"    tljl           |      nvarchar(2000) _      not null/* 讨论结论 */,\n" +
				"    sszbm          |      varchar(20)    _      null/* 手术者工号 */,\n" +
				"    sszqm          |      varchar(50)    _      null/* 手术者签名 */,\n" +
				"    mzysbm         |      varchar(20)    _      null/* 麻醉医师工号 */,\n" +
				"    mzsqm          |      varchar(50)    _      null/* 麻醉医师签名 */,\n" +
				"    ysbm           |      varchar(20)    _      not null/* 签名人工号 */,\n" +
				"    ysqm           |      varchar(50)    _      not null/* 签名人姓名 */,\n" +
				"    qmrq           |      datetime       _      not null/* 签名日期时间 */,";
		String [] bzd = bzds.trim().split(",");
		String createHlhtTemp = "select * into #"+bmz.replace("DC_", "HLHT_") +" from " + bmz.replace("DC_", "HLHT_")+" where STATUS = 0;\r\n";
		System.out.println(createHlhtTemp);
		String create_tempTable = "create table #"+ bmz +"( \r\n";
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
