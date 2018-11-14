package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.EmrQtbljlk;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-27-14 17:27:52
*/
@Repository
public interface EmrQtbljlkDao {

    public int insertEmrQtbljlk(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public int updateEmrQtbljlk(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public int deleteEmrQtbljlk(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public EmrQtbljlk selectEmrQtbljlk(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public Object selectEmrQtbljlkCount(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public List<EmrQtbljlk> selectEmrQtbljlkList(EmrQtbljlk emrQtbljlk) throws DataAccessException;

    public List<EmrQtbljlk> selectEmrQtbljlkPaginatedList(EmrQtbljlk emrMxmcmlk) throws DataAccessException;

    //获取匹配的ID
    String selectEmrQtbljlkId(EmrQtbljlk t);

    String selectEmrBrzdqk(EmrQtbljlk changeCToE);
}