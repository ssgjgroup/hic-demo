package com.winning.hic.controller;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MbzOperateLog;
import com.winning.hic.model.support.Row;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.controller
 * @date: 2018-11-21 16:30
 */
@RestController
@RequestMapping("/operate")
public class MbzOperateLogController extends BaseController {

    @GetMapping(value = "/list",name = "显示数据抽取日志")
    @ResponseBody
    public Map<String, Object> operateLogList(MbzOperateLog log, Row row){
        log.setRow(row);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", getFacade().getMbzOperateLogService().getMbzOperateLogCount(log));
        result.put("status", Constants.SUCCESS);
        result.put("rows", getFacade().getMbzOperateLogService().getMbzOperateLogPageList(log));
        return result;
    }
}
