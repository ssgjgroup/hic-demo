package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjlZyszgcjg;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlZyszgcjgDao;  

import com.winning.hic.service.DcRyjlRyswjlZyszgcjgService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL_ZYSZGCJG
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:56
*/
@Service
public class DcRyjlRyswjlZyszgcjgServiceImpl implements  DcRyjlRyswjlZyszgcjgService {

    @Autowired
    private DcRyjlRyswjlZyszgcjgDao dcRyjlRyswjlZyszgcjgDao;

    public int createDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.insertDcRyjlRyswjlZyszgcjg(dcRyjlRyswjlZyszgcjg);
    }

    public int modifyDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.updateDcRyjlRyswjlZyszgcjg(dcRyjlRyswjlZyszgcjg);
    }

    public int removeDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.deleteDcRyjlRyswjlZyszgcjg(dcRyjlRyswjlZyszgcjg);
    }

    public DcRyjlRyswjlZyszgcjg getDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.selectDcRyjlRyswjlZyszgcjg(dcRyjlRyswjlZyszgcjg);
    }

    public int getDcRyjlRyswjlZyszgcjgCount(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return (Integer)this.dcRyjlRyswjlZyszgcjgDao.selectDcRyjlRyswjlZyszgcjgCount(dcRyjlRyswjlZyszgcjg);
    }

    public List<DcRyjlRyswjlZyszgcjg> getDcRyjlRyswjlZyszgcjgList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.selectDcRyjlRyswjlZyszgcjgList(dcRyjlRyswjlZyszgcjg);
    }

    public List<DcRyjlRyswjlZyszgcjg> getDcRyjlRyswjlZyszgcjgPageList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg){
        return this.dcRyjlRyswjlZyszgcjgDao.selectDcRyjlRyswjlZyszgcjgPageList(dcRyjlRyswjlZyszgcjg);
    }
}