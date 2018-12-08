package com.winning.hic.dao.hdw;



import java.util.List;

import com.winning.hic.model.HlhtRyjlRcyjl;
import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.AmerZcjlDcjl;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-13-08 20:13:23
*/
@Repository
public interface AmerZcjlDcjlDao {

    public int insertAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public int updateAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public int deleteAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public AmerZcjlDcjl selectAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public Object selectAmerZcjlDcjlCount(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public List<AmerZcjlDcjl> selectAmerZcjlDcjlList(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    public List<AmerZcjlDcjl> selectAmerZcjlDcjlPageList(AmerZcjlDcjl amerZcjlDcjl) throws DataAccessException;

    List<AmerZcjlDcjl> selectAmerZcjlDcjlListByProc(AmerZcjlDcjl hlht);
}