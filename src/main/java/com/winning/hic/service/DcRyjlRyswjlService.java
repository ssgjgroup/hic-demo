package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjl;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:54
*/
public interface DcRyjlRyswjlService {

    public int createDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl);

    public int modifyDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl);

    public int removeDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl);

    public DcRyjlRyswjl getDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl);

    public int getDcRyjlRyswjlCount(DcRyjlRyswjl dcRyjlRyswjl);

    public List<DcRyjlRyswjl> getDcRyjlRyswjlList(DcRyjlRyswjl dcRyjlRyswjl);

    public List<DcRyjlRyswjl> getDcRyjlRyswjlPageList(DcRyjlRyswjl dcRyjlRyswjl);
}