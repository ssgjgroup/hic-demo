package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlRyzyzd;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlRyzyzdDao;  

import com.winning.hic.service.DcRyjlRyswjlRyzyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_RYZYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:55
*/
@Service
public class DcRyjlRyswjlRyzyzdServiceImpl implements  DcRyjlRyswjlRyzyzdService {

    @Autowired
    private DcRyjlRyswjlRyzyzdDao dcRyjlRyswjlRyzyzdDao;

    public int createDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.insertDcRyjlRyswjlRyzyzd(dcRyjlRyswjlRyzyzd);
    }

    public int modifyDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.updateDcRyjlRyswjlRyzyzd(dcRyjlRyswjlRyzyzd);
    }

    public int removeDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.deleteDcRyjlRyswjlRyzyzd(dcRyjlRyswjlRyzyzd);
    }

    public DcRyjlRyswjlRyzyzd getDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.selectDcRyjlRyswjlRyzyzd(dcRyjlRyswjlRyzyzd);
    }

    public int getDcRyjlRyswjlRyzyzdCount(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return (Integer)this.dcRyjlRyswjlRyzyzdDao.selectDcRyjlRyswjlRyzyzdCount(dcRyjlRyswjlRyzyzd);
    }

    public List<DcRyjlRyswjlRyzyzd> getDcRyjlRyswjlRyzyzdList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.selectDcRyjlRyswjlRyzyzdList(dcRyjlRyswjlRyzyzd);
    }

    public List<DcRyjlRyswjlRyzyzd> getDcRyjlRyswjlRyzyzdPageList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd){
        return this.dcRyjlRyswjlRyzyzdDao.selectDcRyjlRyswjlRyzyzdPageList(dcRyjlRyswjlRyzyzd);
    }
}