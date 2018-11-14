package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlSwxyzd;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_SWXYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:55
*/
public interface DcRyjlRyswjlSwxyzdService {

    public int createDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public int modifyDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public int removeDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public DcRyjlRyswjlSwxyzd getDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public int getDcRyjlRyswjlSwxyzdCount(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public List<DcRyjlRyswjlSwxyzd> getDcRyjlRyswjlSwxyzdList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);

    public List<DcRyjlRyswjlSwxyzd> getDcRyjlRyswjlSwxyzdPageList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd);
}