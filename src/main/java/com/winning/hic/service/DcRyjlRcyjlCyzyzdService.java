package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlCyzyzd;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_CYZYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:45
*/
public interface DcRyjlRcyjlCyzyzdService {

    public int createDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public int modifyDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public int removeDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public DcRyjlRcyjlCyzyzd getDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public int getDcRyjlRcyjlCyzyzdCount(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public List<DcRyjlRcyjlCyzyzd> getDcRyjlRcyjlCyzyzdList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);

    public List<DcRyjlRcyjlCyzyzd> getDcRyjlRcyjlCyzyzdPageList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd);
}