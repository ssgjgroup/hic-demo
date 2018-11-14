package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjlCyzyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:45
*/
@Repository
public interface DcRyjlRcyjlCyzyzdDao {

    public int insertDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public int updateDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public int deleteDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public DcRyjlRcyjlCyzyzd selectDcRyjlRcyjlCyzyzd(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public Object selectDcRyjlRcyjlCyzyzdCount(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public List<DcRyjlRcyjlCyzyzd> selectDcRyjlRcyjlCyzyzdList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;

    public List<DcRyjlRcyjlCyzyzd> selectDcRyjlRcyjlCyzyzdPageList(DcRyjlRcyjlCyzyzd dcRyjlRcyjlCyzyzd) throws DataAccessException;
}