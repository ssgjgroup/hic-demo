package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlRyzyzd;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlRyzyzdDao;  

import com.winning.hic.service.DcRyjlRcyjlRyzyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_RYZYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:51
*/
@Service
public class DcRyjlRcyjlRyzyzdServiceImpl implements  DcRyjlRcyjlRyzyzdService {

    @Autowired
    private DcRyjlRcyjlRyzyzdDao dcRyjlRcyjlRyzyzdDao;

    public int createDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.insertDcRyjlRcyjlRyzyzd(dcRyjlRcyjlRyzyzd);
    }

    public int modifyDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.updateDcRyjlRcyjlRyzyzd(dcRyjlRcyjlRyzyzd);
    }

    public int removeDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.deleteDcRyjlRcyjlRyzyzd(dcRyjlRcyjlRyzyzd);
    }

    public DcRyjlRcyjlRyzyzd getDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.selectDcRyjlRcyjlRyzyzd(dcRyjlRcyjlRyzyzd);
    }

    public int getDcRyjlRcyjlRyzyzdCount(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return (Integer)this.dcRyjlRcyjlRyzyzdDao.selectDcRyjlRcyjlRyzyzdCount(dcRyjlRcyjlRyzyzd);
    }

    public List<DcRyjlRcyjlRyzyzd> getDcRyjlRcyjlRyzyzdList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.selectDcRyjlRcyjlRyzyzdList(dcRyjlRcyjlRyzyzd);
    }

    public List<DcRyjlRcyjlRyzyzd> getDcRyjlRcyjlRyzyzdPageList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd){
        return this.dcRyjlRcyjlRyzyzdDao.selectDcRyjlRcyjlRyzyzdPageList(dcRyjlRcyjlRyzyzd);
    }
}