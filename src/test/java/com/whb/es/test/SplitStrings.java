package com.whb.es.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 子表
 * @author LENOVO
 *
 */
public class SplitStrings {
	public static void main(String[] args) {
		String zb = "ANMR_ZQGZXX_QTZQTYS";
		String bmz = "DC_ZQGZXX_QTZQTYS_JBZD";
		String bzds = "xh         |          numeric(12)     _     identity(1 1)/* 序号  */,\n" +
				"\t\tyljgdm       |        varchar(20)       _   not null/* 医疗机构代码  */,\n" +
				"\t\tyjlxh        |        varchar(64)       _   not null/* 源记录序号 */,\n" +
				"\t\tzyjlxh       |        varchar(64)       _   null/* 主表原纪录序号 */,\n" +
				"\t\tjbzdbm       |        varchar(64)       _   not null/* 疾病诊断编码 */,\n" +
				"\t\tjbzd         |        varchar(128)      _   not null/* 疾病诊断名称 */,";
		String [] bzd = bzds.trim().split(",");
		String create_tempTable = "create table #"+ bmz +"( \r\n";
		for (int i = 0; i < bzd.length; i++) {
			create_tempTable = create_tempTable + bzd[i].replace("_","").replace("|", "").toString() + ",";
		}
		create_tempTable = create_tempTable + "\r\n" +
				"    isNew               bit                  NULL,\r\n" + 
				"    createtime          datetime             NULL,\r\n" + 
				"    gxrq                datetime             NOT NULL,\r\n" + 
				"    sys_id              varchar(50)          NOT NULL,\r\n" + 
				"    lsnid               bigint               NULL,\r\n" + 
				"    isdelete            varchar(8)           NULL";
		create_tempTable = create_tempTable + "\r\n" + ")" + "\r\n";
		System.out.println(create_tempTable);
		
		String insert_tempTalbe = "insert into #"+ bmz + "\r\n" + "select \r\n   @yljgdm, a.yjlxh+ltrim(rtrim(Str(_0.id))), a.yjlxh,";
		String [] bzd1 = bzds.trim().replace(" ","").split(",");
		StringBuffer sb1 = new StringBuffer();
		List temp2 = new ArrayList();
		List temp3 = new ArrayList();
		for(int i = 2; i < bzd1.length; i++) {
			String [] st = bzd1[i].toString().split("\\|");
			String [] strs = new String [] {"xh","yljgdm","yjlxh","zyjlxh","jzlsh"};
			List<String> list1 = Arrays.asList(strs);
			if(!list1.contains(st[0].split("_")[0].toString().trim())) {
				temp2.add(st[0].split("_")[0].toString());
			}
			if(!list1.contains(st[0].split("_")[0].toString().trim())) {
				temp3.add(st[1].split("_")[0].toString());
			}
		}
		for (int i = 0; i < temp2.size(); i++) {
			sb1.append("convert("+temp3.get(i)+",_"+i+".value),");
		}
		insert_tempTalbe = insert_tempTalbe + sb1.toString() + "1,getdate(),getdate(),'EMR',0,'0' \r\nfrom " + "\r\n" + "   #"+ zb +" as a\r\n";
		StringBuffer sb2 = new StringBuffer();
		for (int i = 0; i < temp2.size(); i++) {
			sb2.append("CROSS APPLY dbo.fn_com_split_ext(a.").append(temp2.get(i).toString().trim()).append(", ").append("@regex)").append(" _"+i+"\r\n");
		}
		System.out.printf(insert_tempTalbe.toString() + sb2.toString());
		String aere = "    where 1 = 1";
		for(int j = 1; j < temp2.size(); j++) {
			if(j == temp2.size() - 1) {
				aere = aere + " and _"+"0.id = "+ "_"+j+".id";
			}else {
				aere = aere + " and _"+"0.id = "+ "_"+j+".id";
			}
		}
		System.out.println(aere.trim() + "\r\n");
		String mergeInto = "Merge Into "+bmz+" _target\r\n" +
				"using #"+bmz+" _source\r\n" +
				"on(_target.yjlxh = _source.yjlxh)\r\n" +
				" When Matched Then\r\n" +
				"  Update set \r\n";
		String [] bzd2 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd2.length; i++) {
			String [] st = bzd2[i].toString().split("\\|");
			String whs = st[0].split("_")[0].toString().trim();
			String temp1 = "   _target." + whs +"=" + "_source." + whs;
			mergeInto = mergeInto + temp1 + ",\r\n";
		}
		System.out.print(mergeInto.trim() + "\r\n");
		String mergeInto1 = "   _target.gxrq=getdate() \r\n "
						+"When Not Matched By Target Then \r\n";
		String ins = "  Insert (";
		String [] bzd3 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd3.length; i++) {
			String [] st = bzd3[i].toString().split("\\|");
			ins = ins + st[0].split("_")[0].toString().trim() + ",";
		}
		ins = ins + "isNew,createtime,gxrq,sys_id,lsnid,isdelete)\r\n";
		System.out.print(mergeInto1 + ins);
		String mergeInto2 = "  values (";
		String [] bzd4 = bzds.trim().replace(" ","").split(",");
		for(int i = 1; i < bzd4.length; i++) {
			String [] st = bzd4[i].toString().split("\\|");
			mergeInto2 = mergeInto2 + "_source." + st[0].split("_")[0].toString().trim() + ",";
		}
		mergeInto2 = mergeInto2 + "_source.isNew,_source.createtime,_source.gxrq,_source.sys_id,_source.lsnid,_source.isdelete);\r\n" + "drop table #" + bmz;
		System.out.println(mergeInto2.toString());
		
	}
}
