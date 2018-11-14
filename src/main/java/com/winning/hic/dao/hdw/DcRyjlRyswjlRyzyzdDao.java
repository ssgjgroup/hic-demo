package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjlRyzyzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:55
*/
@Repository
public interface DcRyjlRyswjlRyzyzdDao {

    public int insertDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public int updateDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public int deleteDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public DcRyjlRyswjlRyzyzd selectDcRyjlRyswjlRyzyzd(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public Object selectDcRyjlRyswjlRyzyzdCount(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public List<DcRyjlRyswjlRyzyzd> selectDcRyjlRyswjlRyzyzdList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;

    public List<DcRyjlRyswjlRyzyzd> selectDcRyjlRyswjlRyzyzdPageList(DcRyjlRyswjlRyzyzd dcRyjlRyswjlRyzyzd) throws DataAccessException;
}