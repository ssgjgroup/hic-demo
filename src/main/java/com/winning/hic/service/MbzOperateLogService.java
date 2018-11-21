package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.MbzOperateLog;  


/**
* @author HLHT
* @title MBZ_OPERATE_LOG
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-12-21 16:12:42
*/
public interface MbzOperateLogService {

    public int createMbzOperateLog(MbzOperateLog mbzOperateLog);

    public int modifyMbzOperateLog(MbzOperateLog mbzOperateLog);

    public int removeMbzOperateLog(MbzOperateLog mbzOperateLog);

    public MbzOperateLog getMbzOperateLog(MbzOperateLog mbzOperateLog);

    public int getMbzOperateLogCount(MbzOperateLog mbzOperateLog);

    public List<MbzOperateLog> getMbzOperateLogList(MbzOperateLog mbzOperateLog);

    public List<MbzOperateLog> getMbzOperateLogPageList(MbzOperateLog mbzOperateLog);
}