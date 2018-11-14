package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRyswjl;  

import com.winning.hic.dao.hdw.DcRyjlRyswjlDao;  

import com.winning.hic.service.DcRyjlRyswjlService;  


/**
* @author HLHT
* @title DC_RYJL_RYSWJL
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:54
*/
@Service
public class DcRyjlRyswjlServiceImpl implements  DcRyjlRyswjlService {

    @Autowired
    private DcRyjlRyswjlDao dcRyjlRyswjlDao;

    public int createDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.insertDcRyjlRyswjl(dcRyjlRyswjl);
    }

    public int modifyDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.updateDcRyjlRyswjl(dcRyjlRyswjl);
    }

    public int removeDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.deleteDcRyjlRyswjl(dcRyjlRyswjl);
    }

    public DcRyjlRyswjl getDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.selectDcRyjlRyswjl(dcRyjlRyswjl);
    }

    public int getDcRyjlRyswjlCount(DcRyjlRyswjl dcRyjlRyswjl){
        return (Integer)this.dcRyjlRyswjlDao.selectDcRyjlRyswjlCount(dcRyjlRyswjl);
    }

    public List<DcRyjlRyswjl> getDcRyjlRyswjlList(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.selectDcRyjlRyswjlList(dcRyjlRyswjl);
    }

    public List<DcRyjlRyswjl> getDcRyjlRyswjlPageList(DcRyjlRyswjl dcRyjlRyswjl){
        return this.dcRyjlRyswjlDao.selectDcRyjlRyswjlPageList(dcRyjlRyswjl);
    }
}