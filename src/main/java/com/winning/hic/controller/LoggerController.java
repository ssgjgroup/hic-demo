package com.winning.hic.controller;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MbzDataError;
import com.winning.hic.model.support.Row;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensj
 * @title
 * @email chensj@winning.com.cn
 * @package com.winning.hic.controller
 * @date: 2018-12-10 20:54
 */
@RestController
@RequestMapping(value = "/logger")
public class LoggerController extends BaseController {

    @GetMapping(value = "/list")
    public Map<String, Object> loggerList(MbzDataError error, Row row){
        error.setRow(row);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", getFacade().getMbzDataErrorService().getMbzDataErrorCount(error));
        result.put("status", Constants.SUCCESS);
        result.put("rows", getFacade().getMbzDataErrorService().getMbzDataErrorPageList(error));
        return result;
    }
}
