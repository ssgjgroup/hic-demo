package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlRyxyzd;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_RYXYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:45
*/
public interface DcRyjlRcyjlRyxyzdService {

    public int createDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public int modifyDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public int removeDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public DcRyjlRcyjlRyxyzd getDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public int getDcRyjlRcyjlRyxyzdCount(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public List<DcRyjlRcyjlRyxyzd> getDcRyjlRcyjlRyxyzdList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);

    public List<DcRyjlRcyjlRyxyzd> getDcRyjlRcyjlRyxyzdPageList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd);
}