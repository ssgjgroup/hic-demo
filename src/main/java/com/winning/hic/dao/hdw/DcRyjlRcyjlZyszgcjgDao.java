package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjlZyszgcjg;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:52
*/
@Repository
public interface DcRyjlRcyjlZyszgcjgDao {

    public int insertDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public int updateDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public int deleteDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public DcRyjlRcyjlZyszgcjg selectDcRyjlRcyjlZyszgcjg(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public Object selectDcRyjlRcyjlZyszgcjgCount(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public List<DcRyjlRcyjlZyszgcjg> selectDcRyjlRcyjlZyszgcjgList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;

    public List<DcRyjlRcyjlZyszgcjg> selectDcRyjlRcyjlZyszgcjgPageList(DcRyjlRcyjlZyszgcjg dcRyjlRcyjlZyszgcjg) throws DataAccessException;
}