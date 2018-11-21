package com.winning.hic.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;  

import com.winning.hic.model.MbzOperateLog;  

import com.winning.hic.dao.cmdatacenter.MbzOperateLogDao;  

import com.winning.hic.service.MbzOperateLogService;  


/**
* @author HLHT
* @title MBZ_OPERATE_LOG
* @email Winning Health
* @package com.winning.hic.service.impl
* @date 2018-28-21 11:28:16
*/
@Service
public class MbzOperateLogServiceImpl implements  MbzOperateLogService {

    @Autowired
    private MbzOperateLogDao mbzOperateLogDao;

    public int createMbzOperateLog(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.insertMbzOperateLog(mbzOperateLog);
    }

    public int modifyMbzOperateLog(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.updateMbzOperateLog(mbzOperateLog);
    }

    public int removeMbzOperateLog(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.deleteMbzOperateLog(mbzOperateLog);
    }

    public MbzOperateLog getMbzOperateLog(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.selectMbzOperateLog(mbzOperateLog);
    }

    public int getMbzOperateLogCount(MbzOperateLog mbzOperateLog){
        return (Integer)this.mbzOperateLogDao.selectMbzOperateLogCount(mbzOperateLog);
    }

    public List<MbzOperateLog> getMbzOperateLogList(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.selectMbzOperateLogList(mbzOperateLog);
    }

    public List<MbzOperateLog> getMbzOperateLogPageList(MbzOperateLog mbzOperateLog){
        return this.mbzOperateLogDao.selectMbzOperateLogPageList(mbzOperateLog);
    }
}