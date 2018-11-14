package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjlZyszgcjg;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:56
*/
@Repository
public interface DcRyjlRyswjlZyszgcjgDao {

    public int insertDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public int updateDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public int deleteDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public DcRyjlRyswjlZyszgcjg selectDcRyjlRyswjlZyszgcjg(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public Object selectDcRyjlRyswjlZyszgcjgCount(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public List<DcRyjlRyswjlZyszgcjg> selectDcRyjlRyswjlZyszgcjgList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;

    public List<DcRyjlRyswjlZyszgcjg> selectDcRyjlRyswjlZyszgcjgPageList(DcRyjlRyswjlZyszgcjg dcRyjlRyswjlZyszgcjg) throws DataAccessException;
}