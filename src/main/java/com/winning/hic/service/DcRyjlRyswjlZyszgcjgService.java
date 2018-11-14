package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlZyszgcjg;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_ZYSZGCJG
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:56
*/
public interface DcRyjlRyswjlZyszgcjgService {

    public int createDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public int modifyDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public int removeDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public DcRyjlRyswjlZyszgcjg getDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public int getDcRyjlRyswjlZyszgcjgCount(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public List<DcRyjlRyswjlZyszgcjg> getDcRyjlRyswjlZyszgcjgList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);

    public List<DcRyjlRyswjlZyszgcjg> getDcRyjlRyswjlZyszgcjgPageList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg);
}