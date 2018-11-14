package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlZyszgcjg;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_ZYSZGCJG
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:52
*/
public interface DcRyjlRcyjlZyszgcjgService {

    public int createDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public int modifyDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public int removeDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public DcRyjlRcyjlZyszgcjg getDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public int getDcRyjlRcyjlZyszgcjgCount(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public List<DcRyjlRcyjlZyszgcjg> getDcRyjlRcyjlZyszgcjgList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);

    public List<DcRyjlRcyjlZyszgcjg> getDcRyjlRcyjlZyszgcjgPageList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg);
}