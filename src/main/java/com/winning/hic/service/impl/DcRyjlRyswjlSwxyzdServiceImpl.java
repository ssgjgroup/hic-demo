package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlSwxyzd;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlSwxyzdDao;  

import com.winning.hic.service.DcRyjlRyswjlSwxyzdService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_SWXYZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:55
*/
@Service
public class DcRyjlRyswjlSwxyzdServiceImpl implements  DcRyjlRyswjlSwxyzdService {

    @Autowired
    private DcRyjlRyswjlSwxyzdDao dcRyjlRyswjlSwxyzdDao;

    public int createDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.insertDcRyjlRyswjlSwxyzd(dcRyjlRyswjlSwxyzd);
    }

    public int modifyDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.updateDcRyjlRyswjlSwxyzd(dcRyjlRyswjlSwxyzd);
    }

    public int removeDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.deleteDcRyjlRyswjlSwxyzd(dcRyjlRyswjlSwxyzd);
    }

    public DcRyjlRyswjlSwxyzd getDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.selectDcRyjlRyswjlSwxyzd(dcRyjlRyswjlSwxyzd);
    }

    public int getDcRyjlRyswjlSwxyzdCount(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return (Integer)this.dcRyjlRyswjlSwxyzdDao.selectDcRyjlRyswjlSwxyzdCount(dcRyjlRyswjlSwxyzd);
    }

    public List<DcRyjlRyswjlSwxyzd> getDcRyjlRyswjlSwxyzdList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.selectDcRyjlRyswjlSwxyzdList(dcRyjlRyswjlSwxyzd);
    }

    public List<DcRyjlRyswjlSwxyzd> getDcRyjlRyswjlSwxyzdPageList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd){
        return this.dcRyjlRyswjlSwxyzdDao.selectDcRyjlRyswjlSwxyzdPageList(dcRyjlRyswjlSwxyzd);
    }
}