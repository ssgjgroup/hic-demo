package com.whb.es.test;
/**
 * 主表
 * @author LENOVO
 *
 */
public class SplitString {
	public static void main(String[] args) {
		String bmz = "DC_ZYBCJL_SHSCBCJL";
		String bzds = "    xh                  | numeric(12)        _  identity(1 1)/* 序号  */,\r\n" + 
				"    yljgdm              | varchar(20)        _  not null/* 医疗机构代码  */,\r\n" + 
				"    jzlsh               | varchar(64)        _  not null/* 就诊流水号 */,\r\n" + 
				"    patid               | varchar(64)        _  not null/* 患者patid */,\r\n" + 
				"    zyh                 | varchar(64)        _  not null/* 住院号标识 */,\r\n" + 
				"    yjlxh               | varchar(64)        _  not null/* 源记录序号 */,\r\n" + 
				"    ksdm                | varchar(10)        _  not null/* 科室代码 */,\r\n" + 
				"    ksmc                | varchar(50)        _  not null/* 科室名称 */,\r\n" + 
				"    bqdm                | varchar(10)        _  not null/* 病区代码 */,\r\n" + 
				"    bqmc                | varchar(50)        _  not null/* 病区名称 */,\r\n" + 
				"    bfh                 | varchar(10)        _  not null/* 病房号 */,\r\n" + 
				"    bfmc                | varchar(50)        _  not null/* 病房名称 */,\r\n" + 
				"    bch                 | varchar(10)        _  not null/* 病床号 */,\r\n" + 
				"    hzxm                | varchar(50)        _  not null/* 患者姓名 */,\r\n" + 
				"    birth               | datetime           _  not null/* 患者出生日期 */,\r\n" + 
				"    lxdh                | varchar(50)        _  not null/* 联系电话 */,\r\n" + 
				"    hyzkdm              | varchar(20)        _  not null/* 患者婚姻状况代码 */,\r\n" + 
				"    hyzk                | varchar(50)        _  not null/* 患者婚姻状况 */,\r\n" + 
				"    mzdm                | varchar(20)        _  not null/* 民族代码 */,\r\n" + 
				"    mz                  | varchar(50)        _  not null/* 民族 */,\r\n" + 
				"    hkszd               | varchar(50)        _  null/* 户口所在地 */,\r\n" + 
				"    csdz                | varchar(500)       _  null/* 出生地址 */,\r\n" + 
				"    gzdw                | varchar(50)        _  null/* 工作单位名称 */,\r\n" + 
				"    gzdwdz              | varchar(500)       _  null/* 工作地点 */,\r\n" + 
				"    gzdwdh              | varchar(70)        _  null/* 工作单位电话 */,\r\n" + 
				"    jgd                 | varchar(50)        _  null/* 籍贯地 */,\r\n" + 
				"    sfzhm               | varchar(18)        _  not null/* 患者身份证号标识 */,\r\n" + 
				"    xbdm                | varchar(2)         _  not null/* 性别代码 */,\r\n" + 
				"    xbmc                | varchar(16)        _  not null/* 性别名称 */,\r\n" + 
				"    nls                 | numeric(3)         _  not null/* 年龄（岁） */,\r\n" + 
				"    nly                 | varchar(8)         _  null/* 年龄（月） */,\r\n" + 
				"    jlrq                | datetime           _  not null/* 记录日期时间 */,\r\n" + 
				"    ssczbm              | varchar(64)        _  not null/* 手术及操作编码 */,\r\n" + 
				"    ssmc                | varchar(128)       _  not null/* 手术名称 */,\r\n" + 
				"    ssmbbwdm            | varchar(64)        _  not null/* 手术目标部位编码 */,\r\n" + 
				"    ssbwmc              | varchar(128)       _  not null/* 手术目标部位名称 */,\r\n" + 
				"    ssrq                | datetime           _  not null/* 手术日期时间 */,\r\n" + 
				"    mzffdm              | varchar(64)        _  not null/* 麻醉方法代码 */,\r\n" + 
				"    mzffmc              | varchar(128)       _  not null/* 麻醉方法名称 */,\r\n" + 
				"    ssgc                | nvarchar(2000)     _  not null/* 手术过程 */,\r\n" + 
				"    zdyjdm              | nvarchar(1000)     _  not null/* 诊断依据编码 */,\r\n" + 
				"    zdyj                | nvarchar(1000)     _  not null/* 诊断依据名称 */,\r\n" + 
				"    zysx                | nvarchar(1000)     _  null/* 注意事项 */,\r\n" + 
				"    ysbm                | varchar(20)        _  not null/* 签名人工号 */,\r\n" + 
				"    ysqm                | varchar(50)        _  not null/* 签名人姓名 */,\r\n" + 
				"    qmrq                | datetime           _  not null/* 签名日期时间 */,\r\n" + 
				"    jzkssj              | datetime           _  not null/* (入院)就诊开始时间 */,\r\n" + 
				"    jzjssj              | datetime           _  not null/* (出院)就诊结束时间 */";
		String [] bzd = bzds.trim().split(",");
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
		insert_tempTalbe = insert_tempTalbe + sb1.toString() + "       1,\r\n       getdate(),\r\n       getdate(),\r\n       'EMR',\r\n       0,\r\n       '0' \r\nfrom " + bmz.replace("DC_", "HLHT_") + "\r\n\r\n";
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
