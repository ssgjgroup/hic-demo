package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.DcZqgzxxBwztzsJbzd;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-42-14 13:42:58
*/
@Repository
public interface DcZqgzxxBwztzsJbzdDao {

    public int insertDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public int updateDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public int deleteDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public DcZqgzxxBwztzsJbzd selectDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public Object selectDcZqgzxxBwztzsJbzdCount(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public List<DcZqgzxxBwztzsJbzd> selectDcZqgzxxBwztzsJbzdList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;

    public List<DcZqgzxxBwztzsJbzd> selectDcZqgzxxBwztzsJbzdPageList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd) throws DataAccessException;
}