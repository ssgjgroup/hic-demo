package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlCyxyzd;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_CYXYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:44
*/
public interface DcRyjlRcyjlCyxyzdService {

    public int createDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public int modifyDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public int removeDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public DcRyjlRcyjlCyxyzd getDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public int getDcRyjlRcyjlCyxyzdCount(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public List<DcRyjlRcyjlCyxyzd> getDcRyjlRcyjlCyxyzdList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);

    public List<DcRyjlRcyjlCyxyzd> getDcRyjlRcyjlCyxyzdPageList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd);
}