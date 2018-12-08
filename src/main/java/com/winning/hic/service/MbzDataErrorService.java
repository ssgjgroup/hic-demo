package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.MbzDataError;  


/**
* @author ISC [Implementation service center]
* @title MBZ_DATA_ERROR
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-07-08 16:07:19
*/
public interface MbzDataErrorService {

    public int createMbzDataError(MbzDataError mbzDataError);

    public int modifyMbzDataError(MbzDataError mbzDataError);

    public int removeMbzDataError(MbzDataError mbzDataError);

    public MbzDataError getMbzDataError(MbzDataError mbzDataError);

    public int getMbzDataErrorCount(MbzDataError mbzDataError);

    public List<MbzDataError> getMbzDataErrorList(MbzDataError mbzDataError);

    public List<MbzDataError> getMbzDataErrorPageList(MbzDataError mbzDataError);
}