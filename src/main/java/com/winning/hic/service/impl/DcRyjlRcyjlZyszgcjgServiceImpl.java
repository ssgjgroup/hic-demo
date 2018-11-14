package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjlZyszgcjg;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlZyszgcjgDao;  

import com.winning.hic.service.DcRyjlRcyjlZyszgcjgService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL_ZYSZGCJG
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:52
*/
@Service
public class DcRyjlRcyjlZyszgcjgServiceImpl implements  DcRyjlRcyjlZyszgcjgService {

    @Autowired
    private DcRyjlRcyjlZyszgcjgDao dcRyjlRcyjlZyszgcjgDao;

    public int createDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.insertDcRyjlRcyjlZyszgcjg(dcRyjlRcyjlZyszgcjg);
    }

    public int modifyDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.updateDcRyjlRcyjlZyszgcjg(dcRyjlRcyjlZyszgcjg);
    }

    public int removeDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.deleteDcRyjlRcyjlZyszgcjg(dcRyjlRcyjlZyszgcjg);
    }

    public DcRyjlRcyjlZyszgcjg getDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.selectDcRyjlRcyjlZyszgcjg(dcRyjlRcyjlZyszgcjg);
    }

    public int getDcRyjlRcyjlZyszgcjgCount(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return (Integer)this.dcRyjlRcyjlZyszgcjgDao.selectDcRyjlRcyjlZyszgcjgCount(dcRyjlRcyjlZyszgcjg);
    }

    public List<DcRyjlRcyjlZyszgcjg> getDcRyjlRcyjlZyszgcjgList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.selectDcRyjlRcyjlZyszgcjgList(dcRyjlRcyjlZyszgcjg);
    }

    public List<DcRyjlRcyjlZyszgcjg> getDcRyjlRcyjlZyszgcjgPageList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg){
        return this.dcRyjlRcyjlZyszgcjgDao.selectDcRyjlRcyjlZyszgcjgPageList(dcRyjlRcyjlZyszgcjg);
    }
}