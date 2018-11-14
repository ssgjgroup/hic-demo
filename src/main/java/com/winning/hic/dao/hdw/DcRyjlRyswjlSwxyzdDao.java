package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjlSwxyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:55
*/
@Repository
public interface DcRyjlRyswjlSwxyzdDao {

    public int insertDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public int updateDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public int deleteDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public DcRyjlRyswjlSwxyzd selectDcRyjlRyswjlSwxyzd(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public Object selectDcRyjlRyswjlSwxyzdCount(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public List<DcRyjlRyswjlSwxyzd> selectDcRyjlRyswjlSwxyzdList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;

    public List<DcRyjlRyswjlSwxyzd> selectDcRyjlRyswjlSwxyzdPageList(DcRyjlRyswjlSwxyzd dcRyjlRyswjlSwxyzd) throws DataAccessException;
}