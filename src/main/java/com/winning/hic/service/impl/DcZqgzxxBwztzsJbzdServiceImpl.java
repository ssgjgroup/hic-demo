package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcZqgzxxBwztzsJbzd;  

import com.winning.hic.dao.hdw.DcZqgzxxBwztzsJbzdDao;  

import com.winning.hic.service.DcZqgzxxBwztzsJbzdService;  


/**
* @author HLHT
* @title DC_ZQGZXX_BWZTZS_JBZD
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:58
*/
@Service
public class DcZqgzxxBwztzsJbzdServiceImpl implements  DcZqgzxxBwztzsJbzdService {

    @Autowired
    private DcZqgzxxBwztzsJbzdDao dcZqgzxxBwztzsJbzdDao;

    public int createDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.insertDcZqgzxxBwztzsJbzd(dcZqgzxxBwztzsJbzd);
    }

    public int modifyDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.updateDcZqgzxxBwztzsJbzd(dcZqgzxxBwztzsJbzd);
    }

    public int removeDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.deleteDcZqgzxxBwztzsJbzd(dcZqgzxxBwztzsJbzd);
    }

    public DcZqgzxxBwztzsJbzd getDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.selectDcZqgzxxBwztzsJbzd(dcZqgzxxBwztzsJbzd);
    }

    public int getDcZqgzxxBwztzsJbzdCount(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return (Integer)this.dcZqgzxxBwztzsJbzdDao.selectDcZqgzxxBwztzsJbzdCount(dcZqgzxxBwztzsJbzd);
    }

    public List<DcZqgzxxBwztzsJbzd> getDcZqgzxxBwztzsJbzdList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.selectDcZqgzxxBwztzsJbzdList(dcZqgzxxBwztzsJbzd);
    }

    public List<DcZqgzxxBwztzsJbzd> getDcZqgzxxBwztzsJbzdPageList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd){
        return this.dcZqgzxxBwztzsJbzdDao.selectDcZqgzxxBwztzsJbzdPageList(dcZqgzxxBwztzsJbzd);
    }
}