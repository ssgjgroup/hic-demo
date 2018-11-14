package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRyswjl;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:54
*/
@Repository
public interface DcRyjlRyswjlDao {

    public int insertDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public int updateDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public int deleteDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public DcRyjlRyswjl selectDcRyjlRyswjl(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public Object selectDcRyjlRyswjlCount(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public List<DcRyjlRyswjl> selectDcRyjlRyswjlList(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;

    public List<DcRyjlRyswjl> selectDcRyjlRyswjlPageList(DcRyjlRyswjl dcRyjlRyswjl) throws DataAccessException;
}