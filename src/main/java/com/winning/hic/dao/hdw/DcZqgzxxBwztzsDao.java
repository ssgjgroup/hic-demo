package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcZqgzxxBwztzs;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:57
*/
@Repository
public interface DcZqgzxxBwztzsDao {

    public int insertDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public int updateDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public int deleteDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public DcZqgzxxBwztzs selectDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public Object selectDcZqgzxxBwztzsCount(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public List<DcZqgzxxBwztzs> selectDcZqgzxxBwztzsList(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;

    public List<DcZqgzxxBwztzs> selectDcZqgzxxBwztzsPageList(DcZqgzxxBwztzs dcZqgzxxBwztzs) throws DataAccessException;
}