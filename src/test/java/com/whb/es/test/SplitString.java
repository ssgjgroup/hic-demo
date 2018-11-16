package com.whb.es.test;
/**
 * 主表
 * @author LENOVO
 *
 */
public class SplitString {
	public static void main(String[] args) {
		String bmz = "DC_BLGY_JBJKXX";
		String bzds = " xh           |        numeric(12)       _   identity(1 1)/* 序号 */,\n" +
				"    yljgdm       |        varchar(20)       _   not null/* 医疗机构代码 */,\n" +
				"    jzlsh        |        varchar(64)       _   not null/* 就诊流水号 */,\n" +
				"    patid        |        varchar(64)       _   not null/* 患者patid */,\n" +
				"    jzlb         |        varchar(2)        _   not null/* 就诊类别 */,\n" +
				"    yjlxh        |        varchar(64)       _   not null/* 源记录序号 */,\n" +
				"    hzxm         |        varchar(64)       _   not null/* 患者姓名 */,\n" +
				"    mjzh         |        varchar(64)       _   not null/* 门急诊号 */,\n" +
				"    zyh          |        varchar(64)       _   not null/* 住院号 */,\n" +
				"    xbdm         |        varchar(2)        _   not null/* 性别代码 */,\n" +
				"    xbmc         |        varchar(16)       _   not null/* 性别名称 */,\n" +
				"    sfzhm        |        varchar(18)       _   not null/* 患者身份证件号码 */,\n" +
				"    jkkh         |        varchar(18)       _   not null/* 居民健康卡号 */,\n" +
				"    aboxxdm      |        varchar(4)        _   not null/* ABO血型代码 */,\n" +
				"    aboxxmc      |        varchar(18)       _   not null/* ABO血型名称 */,\n" +
				"    rhxxdm       |        varchar(4)        _   not null/* Rh血型代码 */,\n" +
				"    rhxxmc       |        varchar(18)       _   not null/* Rh血型名称 */,\n" +
				"    sxs          |        nvarchar(1000)    _   not null/* 输血史 */,\n" +
				"    grs          |        nvarchar(1000)    _   not null/* 个人史 */,\n" +
				"    yjs          |        nvarchar(1000)    _   not null/* 月经史 */,";
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
