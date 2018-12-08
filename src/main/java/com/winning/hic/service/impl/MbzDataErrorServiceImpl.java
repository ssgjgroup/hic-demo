package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.MbzDataError;  

import com.winning.hic.dao.cmdatacenter.MbzDataErrorDao;  

import com.winning.hic.service.MbzDataErrorService;  


/**
* @author ISC [Implementation service center]
* @title MBZ_DATA_ERROR
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-07-08 16:07:19
*/
@Service
public class MbzDataErrorServiceImpl implements  MbzDataErrorService {

    @Autowired
    private MbzDataErrorDao mbzDataErrorDao;

    public int createMbzDataError(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.insertMbzDataError(mbzDataError);
    }

    public int modifyMbzDataError(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.updateMbzDataError(mbzDataError);
    }

    public int removeMbzDataError(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.deleteMbzDataError(mbzDataError);
    }

    public MbzDataError getMbzDataError(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.selectMbzDataError(mbzDataError);
    }

    public int getMbzDataErrorCount(MbzDataError mbzDataError){
        return (Integer)this.mbzDataErrorDao.selectMbzDataErrorCount(mbzDataError);
    }

    public List<MbzDataError> getMbzDataErrorList(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.selectMbzDataErrorList(mbzDataError);
    }

    public List<MbzDataError> getMbzDataErrorPageList(MbzDataError mbzDataError){
        return this.mbzDataErrorDao.selectMbzDataErrorPageList(mbzDataError);
    }
}