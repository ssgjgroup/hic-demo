package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlRyzyzd;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_RYZYZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:55
*/
public interface DcRyjlRyswjlRyzyzdService {

    public int createDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public int modifyDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public int removeDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public DcRyjlRyswjlRyzyzd getDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public int getDcRyjlRyswjlRyzyzdCount(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public List<DcRyjlRyswjlRyzyzd> getDcRyjlRyswjlRyzyzdList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);

    public List<DcRyjlRyswjlRyzyzd> getDcRyjlRyswjlRyzyzdPageList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd);
}