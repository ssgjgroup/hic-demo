package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjlSwzyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:56
*/
@Repository
public interface DcRyjlRyswjlSwzyzdDao {

    public int insertDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public int updateDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public int deleteDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public DcRyjlRyswjlSwzyzd selectDcRyjlRyswjlSwzyzd(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public Object selectDcRyjlRyswjlSwzyzdCount(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public List<DcRyjlRyswjlSwzyzd> selectDcRyjlRyswjlSwzyzdList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;

    public List<DcRyjlRyswjlSwzyzd> selectDcRyjlRyswjlSwzyzdPageList(DcRyjlRyswjlSwzyzd dcRyjlRyswjlSwzyzd) throws DataAccessException;
}