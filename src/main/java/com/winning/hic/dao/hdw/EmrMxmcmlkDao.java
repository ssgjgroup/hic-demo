package com.winning.hic.dao.hdw;



import java.util.List;  

import org.springframework.dao.DataAccessException;  

import com.winning.hic.model.EmrMxmcmlk;  



import org.springframework.stereotype.Repository;
/**
* @author HLHT
* @title 模型名称目录库DAO接口
* @email Winning Health
* @package com.winning.hic.dao.hdw
* @date 2018-19-14 17:19:02
*/
@Repository
public interface EmrMxmcmlkDao {

    public int insertEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public int updateEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public int deleteEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public EmrMxmcmlk selectEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public Object selectEmrMxmcmlkCount(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public List<EmrMxmcmlk> selectEmrMxmcmlkList(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    public List<EmrMxmcmlk> selectEmrMxmcmlkPageList(EmrMxmcmlk emrMxmcmlk) throws DataAccessException;

    List<EmrMxmcmlk> selectEmrMxmcmlkParentList(EmrMxmcmlk emrMxmcmlk);

    List<EmrMxmcmlk> selectEmrMxmcmlkFirstChildList(EmrMxmcmlk mxmcmlk);
}