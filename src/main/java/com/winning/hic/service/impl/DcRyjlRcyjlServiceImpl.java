package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcRyjlRcyjl;  

import com.winning.hic.dao.hdw.DcRyjlRcyjlDao;  

import com.winning.hic.service.DcRyjlRcyjlService;  


/**
* @author HLHT
* @title DC_RYJL_RCYJL
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:43
*/
@Service
public class DcRyjlRcyjlServiceImpl implements  DcRyjlRcyjlService {

    @Autowired
    private DcRyjlRcyjlDao dcRyjlRcyjlDao;

    public int createDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.insertDcRyjlRcyjl(dcRyjlRcyjl);
    }

    public int modifyDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.updateDcRyjlRcyjl(dcRyjlRcyjl);
    }

    public int removeDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.deleteDcRyjlRcyjl(dcRyjlRcyjl);
    }

    public DcRyjlRcyjl getDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.selectDcRyjlRcyjl(dcRyjlRcyjl);
    }

    public int getDcRyjlRcyjlCount(DcRyjlRcyjl dcRyjlRcyjl){
        return (Integer)this.dcRyjlRcyjlDao.selectDcRyjlRcyjlCount(dcRyjlRcyjl);
    }

    public List<DcRyjlRcyjl> getDcRyjlRcyjlList(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.selectDcRyjlRcyjlList(dcRyjlRcyjl);
    }

    public List<DcRyjlRcyjl> getDcRyjlRcyjlPageList(DcRyjlRcyjl dcRyjlRcyjl){
        return this.dcRyjlRcyjlDao.selectDcRyjlRcyjlPageList(dcRyjlRcyjl);
    }
}