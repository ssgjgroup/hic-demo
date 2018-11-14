package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlRyxyzd;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlRyxyzdDao;  

import com.winning.hic.service.DcRyjlRyswjlRyxyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_RYXYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:54
*/
@Service
public class DcRyjlRyswjlRyxyzdServiceImpl implements  DcRyjlRyswjlRyxyzdService {

    @Autowired
    private DcRyjlRyswjlRyxyzdDao dcRyjlRyswjlRyxyzdDao;

    public int createDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.insertDcRyjlRyswjlRyxyzd(dcRyjlRyswjlRyxyzd);
    }

    public int modifyDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.updateDcRyjlRyswjlRyxyzd(dcRyjlRyswjlRyxyzd);
    }

    public int removeDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.deleteDcRyjlRyswjlRyxyzd(dcRyjlRyswjlRyxyzd);
    }

    public DcRyjlRyswjlRyxyzd getDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.selectDcRyjlRyswjlRyxyzd(dcRyjlRyswjlRyxyzd);
    }

    public int getDcRyjlRyswjlRyxyzdCount(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return (Integer)this.dcRyjlRyswjlRyxyzdDao.selectDcRyjlRyswjlRyxyzdCount(dcRyjlRyswjlRyxyzd);
    }

    public List<DcRyjlRyswjlRyxyzd> getDcRyjlRyswjlRyxyzdList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.selectDcRyjlRyswjlRyxyzdList(dcRyjlRyswjlRyxyzd);
    }

    public List<DcRyjlRyswjlRyxyzd> getDcRyjlRyswjlRyxyzdPageList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd){
        return this.dcRyjlRyswjlRyxyzdDao.selectDcRyjlRyswjlRyxyzdPageList(dcRyjlRyswjlRyxyzd);
    }
}