package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcZqgzxxBwztzs;  


/**
* @author HLHT
* @title DC_ZQGZXX_BWZTZS
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:57
*/
public interface DcZqgzxxBwztzsService {

    public int createDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public int modifyDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public int removeDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public DcZqgzxxBwztzs getDcZqgzxxBwztzs(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public int getDcZqgzxxBwztzsCount(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public List<DcZqgzxxBwztzs> getDcZqgzxxBwztzsList(DcZqgzxxBwztzs dcZqgzxxBwztzs);

    public List<DcZqgzxxBwztzs> getDcZqgzxxBwztzsPageList(DcZqgzxxBwztzs dcZqgzxxBwztzs);
}