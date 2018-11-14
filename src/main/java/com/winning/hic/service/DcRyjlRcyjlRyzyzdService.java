package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlRyzyzd;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_RYZYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:51
*/
public interface DcRyjlRcyjlRyzyzdService {

    public int createDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public int modifyDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public int removeDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public DcRyjlRcyjlRyzyzd getDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public int getDcRyjlRcyjlRyzyzdCount(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public List<DcRyjlRcyjlRyzyzd> getDcRyjlRcyjlRyzyzdList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);

    public List<DcRyjlRcyjlRyzyzd> getDcRyjlRcyjlRyzyzdPageList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd);
}