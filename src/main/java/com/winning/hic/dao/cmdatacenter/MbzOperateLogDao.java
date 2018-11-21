package com.winning.hic.dao.cmdatacenter;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.MbzOperateLog;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.cmdatacenter
* @date 2018-28-21 11:28:16
*/
@Repository
public interface MbzOperateLogDao {

    public int insertMbzOperateLog(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public int updateMbzOperateLog(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public int deleteMbzOperateLog(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public MbzOperateLog selectMbzOperateLog(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public Object selectMbzOperateLogCount(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public List<MbzOperateLog> selectMbzOperateLogList(MbzOperateLog mbzOperateLog) throws DataAccessException;

    public List<MbzOperateLog> selectMbzOperateLogPageList(MbzOperateLog mbzOperateLog) throws DataAccessException;
}