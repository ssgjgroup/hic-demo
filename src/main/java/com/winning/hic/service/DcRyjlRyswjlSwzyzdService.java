package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlSwzyzd;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_SWZYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:56
*/
public interface DcRyjlRyswjlSwzyzdService {

    public int createDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public int modifyDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public int removeDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public DcRyjlRyswjlSwzyzd getDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public int getDcRyjlRyswjlSwzyzdCount(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public List<DcRyjlRyswjlSwzyzd> getDcRyjlRyswjlSwzyzdList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);

    public List<DcRyjlRyswjlSwzyzd> getDcRyjlRyswjlSwzyzdPageList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd);
}