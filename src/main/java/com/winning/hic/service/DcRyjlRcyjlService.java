package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjl;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:43
*/
public interface DcRyjlRcyjlService {

    public int createDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl);

    public int modifyDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl);

    public int removeDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl);

    public DcRyjlRcyjl getDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl);

    public int getDcRyjlRcyjlCount(DcRyjlRcyjl dcRyjlRcyjl);

    public List<DcRyjlRcyjl> getDcRyjlRcyjlList(DcRyjlRcyjl dcRyjlRcyjl);

    public List<DcRyjlRcyjl> getDcRyjlRcyjlPageList(DcRyjlRcyjl dcRyjlRcyjl);
}