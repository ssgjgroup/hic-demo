package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlCyzyzd;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlCyzyzdDao;  

import com.winning.hic.service.DcRyjlRcyjlCyzyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_CYZYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:45
*/
@Service
public class DcRyjlRcyjlCyzyzdServiceImpl implements  DcRyjlRcyjlCyzyzdService {

    @Autowired
    private DcRyjlRcyjlCyzyzdDao dcRyjlRcyjlCyzyzdDao;

    public int createDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.insertDcRyjlRcyjlCyzyzd(dcRyjlRcyjlCyzyzd);
    }

    public int modifyDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.updateDcRyjlRcyjlCyzyzd(dcRyjlRcyjlCyzyzd);
    }

    public int removeDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.deleteDcRyjlRcyjlCyzyzd(dcRyjlRcyjlCyzyzd);
    }

    public DcRyjlRcyjlCyzyzd getDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.selectDcRyjlRcyjlCyzyzd(dcRyjlRcyjlCyzyzd);
    }

    public int getDcRyjlRcyjlCyzyzdCount(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return (Integer)this.dcRyjlRcyjlCyzyzdDao.selectDcRyjlRcyjlCyzyzdCount(dcRyjlRcyjlCyzyzd);
    }

    public List<DcRyjlRcyjlCyzyzd> getDcRyjlRcyjlCyzyzdList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.selectDcRyjlRcyjlCyzyzdList(dcRyjlRcyjlCyzyzd);
    }

    public List<DcRyjlRcyjlCyzyzd> getDcRyjlRcyjlCyzyzdPageList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd){
        return this.dcRyjlRcyjlCyzyzdDao.selectDcRyjlRcyjlCyzyzdPageList(dcRyjlRcyjlCyzyzd);
    }
}