package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcRyjlRcyjl;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:43
*/
@Repository
public interface DcRyjlRcyjlDao {

    public int insertDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public int updateDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public int deleteDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public DcRyjlRcyjl selectDcRyjlRcyjl(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public Object selectDcRyjlRcyjlCount(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public List<DcRyjlRcyjl> selectDcRyjlRcyjlList(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;

    public List<DcRyjlRcyjl> selectDcRyjlRcyjlPageList(DcRyjlRcyjl dcRyjlRcyjl) throws DataAccessException;
}