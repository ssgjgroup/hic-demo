package com.winning.hic.service;

import java.util.List;  

import com.winning.hic.model.AmerZcjlDcjl;
import com.winning.hic.model.MbzDataCheck;


/**
* @author HLHT
* @title AMER_ZCJL_DCJL
* @email Winning Health
* @package com.winning.hic.service
* @date 2018-13-08 20:13:23
*/
public interface AmerZcjlDcjlService {

    public int createAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl);

    public int modifyAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl);

    public int removeAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl);

    public AmerZcjlDcjl getAmerZcjlDcjl(AmerZcjlDcjl amerZcjlDcjl);

    public int getAmerZcjlDcjlCount(AmerZcjlDcjl amerZcjlDcjl);

    public List<AmerZcjlDcjl> getAmerZcjlDcjlList(AmerZcjlDcjl amerZcjlDcjl);

    public List<AmerZcjlDcjl> getAmerZcjlDcjlPageList(AmerZcjlDcjl amerZcjlDcjl);

    MbzDataCheck interfaceAmerZcjlDcjlService(MbzDataCheck entity);
}