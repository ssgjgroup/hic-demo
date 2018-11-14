package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.DcZqgzxxBwztzs;  

import com.winning.hic.dao.hdw.DcZqgzxxBwztzsDao;  

import com.winning.hic.service.DcZqgzxxBwztzsService;  


/**
* @author HLHT
* @title DC_ZQGZXX_BWZTZS
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-42-14 13:42:57
*/
@Service
public class DcZqgzxxBwztzsServiceImpl implements  DcZqgzxxBwztzsService {

    @Autowired
    private DcZqgzxxBwztzsDao dcZqgzxxBwztzsDao;

    public int createDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.insertDcZqgzxxBwztzs(dcZqgzxxBwztzs);
    }

    public int modifyDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.updateDcZqgzxxBwztzs(dcZqgzxxBwztzs);
    }

    public int removeDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.deleteDcZqgzxxBwztzs(dcZqgzxxBwztzs);
    }

    public DcZqgzxxBwztzs getDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.selectDcZqgzxxBwztzs(dcZqgzxxBwztzs);
    }

    public int getDcZqgzxxBwztzsCount(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return (Integer)this.dcZqgzxxBwztzsDao.selectDcZqgzxxBwztzsCount(dcZqgzxxBwztzs);
    }

    public List<DcZqgzxxBwztzs> getDcZqgzxxBwztzsList(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.selectDcZqgzxxBwztzsList(dcZqgzxxBwztzs);
    }

    public List<DcZqgzxxBwztzs> getDcZqgzxxBwztzsPageList(DcZqgzxxBwztzs dcZqgzxxBwztzs){
        return this.dcZqgzxxBwztzsDao.selectDcZqgzxxBwztzsPageList(dcZqgzxxBwztzs);
    }
}