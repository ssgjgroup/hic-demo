package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjlCyxyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:44
*/
@Repository
public interface DcRyjlRcyjlCyxyzdDao {

    public int insertDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public int updateDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public int deleteDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public DcRyjlRcyjlCyxyzd selectDcRyjlRcyjlCyxyzd(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public Object selectDcRyjlRcyjlCyxyzdCount(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public List<DcRyjlRcyjlCyxyzd> selectDcRyjlRcyjlCyxyzdList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;

    public List<DcRyjlRcyjlCyxyzd> selectDcRyjlRcyjlCyxyzdPageList(DcRyjlRcyjlCyxyzd dcRyjlRcyjlCyxyzd) throws DataAccessException;
}