package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlRyxyzd;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_RYXYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:54
*/
public interface DcRyjlRyswjlRyxyzdService {

    public int createDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public int modifyDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public int removeDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public DcRyjlRyswjlRyxyzd getDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public int getDcRyjlRyswjlRyxyzdCount(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public List<DcRyjlRyswjlRyxyzd> getDcRyjlRyswjlRyxyzdList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);

    public List<DcRyjlRyswjlRyxyzd> getDcRyjlRyswjlRyxyzdPageList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd);
}