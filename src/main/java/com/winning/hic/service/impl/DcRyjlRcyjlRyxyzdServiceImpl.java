package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlRyxyzd;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlRyxyzdDao;  

import com.winning.hic.service.DcRyjlRcyjlRyxyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_RYXYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:45
*/
@Service
public class DcRyjlRcyjlRyxyzdServiceImpl implements  DcRyjlRcyjlRyxyzdService {

    @Autowired
    private DcRyjlRcyjlRyxyzdDao dcRyjlRcyjlRyxyzdDao;

    public int createDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.insertDcRyjlRcyjlRyxyzd(dcRyjlRcyjlRyxyzd);
    }

    public int modifyDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.updateDcRyjlRcyjlRyxyzd(dcRyjlRcyjlRyxyzd);
    }

    public int removeDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.deleteDcRyjlRcyjlRyxyzd(dcRyjlRcyjlRyxyzd);
    }

    public DcRyjlRcyjlRyxyzd getDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.selectDcRyjlRcyjlRyxyzd(dcRyjlRcyjlRyxyzd);
    }

    public int getDcRyjlRcyjlRyxyzdCount(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return (Integer)this.dcRyjlRcyjlRyxyzdDao.selectDcRyjlRcyjlRyxyzdCount(dcRyjlRcyjlRyxyzd);
    }

    public List<DcRyjlRcyjlRyxyzd> getDcRyjlRcyjlRyxyzdList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.selectDcRyjlRcyjlRyxyzdList(dcRyjlRcyjlRyxyzd);
    }

    public List<DcRyjlRcyjlRyxyzd> getDcRyjlRcyjlRyxyzdPageList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd){
        return this.dcRyjlRcyjlRyxyzdDao.selectDcRyjlRcyjlRyxyzdPageList(dcRyjlRcyjlRyxyzd);
    }
}