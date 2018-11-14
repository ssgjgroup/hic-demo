package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlCyxyzd;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlCyxyzdDao;  

import com.winning.hic.service.DcRyjlRcyjlCyxyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_CYXYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:44
*/
@Service
public class DcRyjlRcyjlCyxyzdServiceImpl implements  DcRyjlRcyjlCyxyzdService {

    @Autowired
    private DcRyjlRcyjlCyxyzdDao dcRyjlRcyjlCyxyzdDao;

    public int createDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.insertDcRyjlRcyjlCyxyzd(dcRyjlRcyjlCyxyzd);
    }

    public int modifyDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.updateDcRyjlRcyjlCyxyzd(dcRyjlRcyjlCyxyzd);
    }

    public int removeDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.deleteDcRyjlRcyjlCyxyzd(dcRyjlRcyjlCyxyzd);
    }

    public DcRyjlRcyjlCyxyzd getDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.selectDcRyjlRcyjlCyxyzd(dcRyjlRcyjlCyxyzd);
    }

    public int getDcRyjlRcyjlCyxyzdCount(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return (Integer)this.dcRyjlRcyjlCyxyzdDao.selectDcRyjlRcyjlCyxyzdCount(dcRyjlRcyjlCyxyzd);
    }

    public List<DcRyjlRcyjlCyxyzd> getDcRyjlRcyjlCyxyzdList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.selectDcRyjlRcyjlCyxyzdList(dcRyjlRcyjlCyxyzd);
    }

    public List<DcRyjlRcyjlCyxyzd> getDcRyjlRcyjlCyxyzdPageList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd){
        return this.dcRyjlRcyjlCyxyzdDao.selectDcRyjlRcyjlCyxyzdPageList(dcRyjlRcyjlCyxyzd);
    }
}