package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjlRyxyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:45
*/
@Repository
public interface DcRyjlRcyjlRyxyzdDao {

    public int insertDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public int updateDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public int deleteDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public DcRyjlRcyjlRyxyzd selectDcRyjlRcyjlRyxyzd(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public Object selectDcRyjlRcyjlRyxyzdCount(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public List<DcRyjlRcyjlRyxyzd> selectDcRyjlRcyjlRyxyzdList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;

    public List<DcRyjlRcyjlRyxyzd> selectDcRyjlRcyjlRyxyzdPageList(DcRyjlRcyjlRyxyzd dcRyjlRcyjlRyxyzd) throws DataAccessException;
}