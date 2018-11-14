package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjlRyxyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:54
*/
@Repository
public interface DcRyjlRyswjlRyxyzdDao {

    public int insertDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public int updateDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public int deleteDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public DcRyjlRyswjlRyxyzd selectDcRyjlRyswjlRyxyzd(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public Object selectDcRyjlRyswjlRyxyzdCount(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public List<DcRyjlRyswjlRyxyzd> selectDcRyjlRyswjlRyxyzdList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;

    public List<DcRyjlRyswjlRyxyzd> selectDcRyjlRyswjlRyxyzdPageList(DcRyjlRyswjlRyxyzd dcRyjlRyswjlRyxyzd) throws DataAccessException;
}