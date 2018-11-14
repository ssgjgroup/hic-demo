package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlSwzyzd;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlSwzyzdDao;  

import com.winning.hic.service.DcRyjlRyswjlSwzyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_SWZYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:56
*/
@Service
public class DcRyjlRyswjlSwzyzdServiceImpl implements  DcRyjlRyswjlSwzyzdService {

    @Autowired
    private DcRyjlRyswjlSwzyzdDao dcRyjlRyswjlSwzyzdDao;

    public int createDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.insertDcRyjlRyswjlSwzyzd(dcRyjlRyswjlSwzyzd);
    }

    public int modifyDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.updateDcRyjlRyswjlSwzyzd(dcRyjlRyswjlSwzyzd);
    }

    public int removeDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.deleteDcRyjlRyswjlSwzyzd(dcRyjlRyswjlSwzyzd);
    }

    public DcRyjlRyswjlSwzyzd getDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.selectDcRyjlRyswjlSwzyzd(dcRyjlRyswjlSwzyzd);
    }

    public int getDcRyjlRyswjlSwzyzdCount(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return (Integer)this.dcRyjlRyswjlSwzyzdDao.selectDcRyjlRyswjlSwzyzdCount(dcRyjlRyswjlSwzyzd);
    }

    public List<DcRyjlRyswjlSwzyzd> getDcRyjlRyswjlSwzyzdList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.selectDcRyjlRyswjlSwzyzdList(dcRyjlRyswjlSwzyzd);
    }

    public List<DcRyjlRyswjlSwzyzd> getDcRyjlRyswjlSwzyzdPageList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd){
        return this.dcRyjlRyswjlSwzyzdDao.selectDcRyjlRyswjlSwzyzdPageList(dcRyjlRyswjlSwzyzd);
    }
}