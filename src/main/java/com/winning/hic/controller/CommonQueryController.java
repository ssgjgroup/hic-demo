package com.winning.hic.controller;

import java.util.HashMap;
import java.util.Map;

import com.winning.hic.base.utils.Base64Utils;
import com.winning.hic.base.utils.XmlFormatter;
import com.winning.hic.model.support.Row;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MbzDictInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Created with IntelliJ IDEA.
 * Description: 通用控制类
 * User: LENOVO
 * Date: 2018-07-26
 * Time: 13:55
 */
@RestController
public class CommonQueryController extends BaseController {

    @ApiOperation(value = "/common/dict",notes = "根据字典类型加载字典值")
    @ApiImplicitParam(
            name = "字典代码(dictCode)",value = "dictInfo",required = true,
            dataType = "MbzDictInfo"
    )
    @PostMapping(value = "/common/dict")
    public Map<String, Object> getDictListByDictCode(MbzDictInfo dictInfo){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        result.put("data", getFacade().getMbzDictInfoService().getMbzDictInfoList(dictInfo));
        return result;
    }

    @ApiOperation(value = "/common/ptList",notes = "加载显示CIS子集病历代码信息")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "字典代码(dictCode)",value = "dictInfo",required = true,
                    dataType = "MbzDictInfo"),
            @ApiImplicitParam( name = "分页参数",value = "row",required = true,
                    dataType = "Row")
        }
    )
    @GetMapping(value = "/common/ptList")
    public Map<String, Object> getBldmListForCIS(MbzDictInfo dictInfo, Row row){
        dictInfo.setDictCode("platformTableName");
        dictInfo.setRow(row);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        result.put("total", getFacade().getMbzDictInfoService().getMbzDictInfoCount(dictInfo));
        result.put("rows", getFacade().getMbzDictInfoService().getMbzDictInfoPageList(dictInfo));
        return result;
    }

    @ApiOperation(value = "/common/saveOrUpdate",notes = "修改CIS子集病历代码信息")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "字典代码(dictCode)",value = "dictInfo",required = true,
                    dataType = "MbzDictInfo")
    }
    )
    @PostMapping(value = "/common/saveOrUpdate")
    public Map<String, Object> saveOrUpdateBldm(MbzDictInfo dictInfo){
        getFacade().getMbzDictInfoService().modifyMbzDictInfo(dictInfo);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        return result;
    }

    @ApiOperation(value = "/blnr/parse",notes = "病历内容解析")
    @ApiImplicitParams({
            @ApiImplicitParam( name = "病历内容",value = "blnr",required = true,
                    dataType = "string")
        })
    @PostMapping(value = "/blnr/parse")
    @ResponseBody
    public Map<String, Object> parseBlnr(String blnr) throws Exception {
        blnr = blnr.substring(3);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", Constants.SUCCESS);
        result.put("data", XmlFormatter.format(Base64Utils.unzipEmrXml(blnr)));
        return result;
    }
}
