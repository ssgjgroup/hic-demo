package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjlRyzyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:51
*/
@Repository
public interface DcRyjlRcyjlRyzyzdDao {

    public int insertDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public int updateDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public int deleteDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public DcRyjlRcyjlRyzyzd selectDcRyjlRcyjlRyzyzd(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public Object selectDcRyjlRcyjlRyzyzdCount(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public List<DcRyjlRcyjlRyzyzd> selectDcRyjlRcyjlRyzyzdList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;

    public List<DcRyjlRcyjlRyzyzd> selectDcRyjlRcyjlRyzyzdPageList(DcRyjlRcyjlRyzyzd dcRyjlRcyjlRyzyzd) throws DataAccessException;
}