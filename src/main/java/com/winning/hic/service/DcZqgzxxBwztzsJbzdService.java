package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.DcZqgzxxBwztzsJbzd;  


/**
* @author HLHT
* @title DC_ZQGZXX_BWZTZS_JBZD
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-42-14 13:42:58
*/
public interface DcZqgzxxBwztzsJbzdService {

    public int createDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public int modifyDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public int removeDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public DcZqgzxxBwztzsJbzd getDcZqgzxxBwztzsJbzd(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public int getDcZqgzxxBwztzsJbzdCount(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public List<DcZqgzxxBwztzsJbzd> getDcZqgzxxBwztzsJbzdList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);

    public List<DcZqgzxxBwztzsJbzd> getDcZqgzxxBwztzsJbzdPageList(DcZqgzxxBwztzsJbzd dcZqgzxxBwztzsJbzd);
}