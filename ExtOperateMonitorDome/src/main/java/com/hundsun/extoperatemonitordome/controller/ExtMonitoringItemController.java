package com.hundsun.extoperatemonitordome.controller;

import com.hundsun.extoperatemonitordome.dto.ExecuteOperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.dto.OperateMonitorDto;
import com.hundsun.extoperatemonitordome.dto.OperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.sercice.OperateMonitorResulService;
import com.hundsun.extoperatemonitordome.sercice.TsCheckItemInfoService;
import com.hundsun.extoperatemonitordome.util.ResponseData;
import com.hundsun.extoperatemonitordome.vo.ExecuteICheckItemResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/10 13:46
 */
@Api(tags = "外部监控项业务接口")
@RestController
@Slf4j
public class ExtMonitoringItemController {

    @Autowired
    OperateMonitorResulService extMonitoringItemService;

    @Autowired
    TsCheckItemInfoService tsCheckItemInfoService;

    @PostMapping("/addItemInfo")
    @ApiOperation(value = "新增监控项")
    @ApiImplicitParam(name = "operateMonitorDto", value = "新增监控项对象", dataType = "operateMonitorDto", dataTypeClass = OperateMonitorResultDto.class, paramType = "query")
    public ResponseData<String> addItemInfo(@RequestBody OperateMonitorDto operateMonitorDto) {
        return tsCheckItemInfoService.addItemInfo(operateMonitorDto);
    }


    @ApiOperation(value = "删除监控项")
    @PostMapping("/deleteItemInfo")
    @ApiImplicitParam(name = "itemCode", value = "监控项id", dataType = "integer", dataTypeClass = Integer.class, paramType = "query")
    public ResponseData<String> deleteItemInfo(Integer itemCode) {
        return tsCheckItemInfoService.deleteItemInfo(itemCode);
    }

    @ApiOperation(value = "查询监控项")
    @PostMapping("/listExtOperateMonitor")
    public ResponseData<List<OperateMonitorDto>> listExtOperateMonitor() {
        return tsCheckItemInfoService.listExtOperateMonitor();
    }

    @ApiOperation(value = "执行监控项检查并返回结果接口")
    @PostMapping("/dealExtOperateMonitor")
    @ApiImplicitParam(name = "executeICheckItemResultVo", value = "新增监控项检查结果对象",  dataType = "executeICheckItemResultVo",
            dataTypeClass = ExecuteICheckItemResultVo.class, paramType = "body")
    public ResponseData<List<OperateMonitorResultDto>> dealExtOperateMonitor(@RequestBody ExecuteICheckItemResultVo executeICheckItemResultVo) {
        return extMonitoringItemService.dealExtOperateMonitor(executeICheckItemResultVo.getFundCode(),executeICheckItemResultVo.getItemId(),
                executeICheckItemResultVo.getBusinessDate(),executeICheckItemResultVo.getIndicator1(),executeICheckItemResultVo.getIndicator2());
    }

    @ApiOperation(value = "新增执行监控项检查结果接口")
    @PostMapping("/addDealExtOperateMonitorResult")
    @ApiImplicitParam(name = "executeOperateMonitorResultDtoList", value = "新增监控项检查结果对象",  dataType = "ExecuteOperateMonitorResultDto",
            dataTypeClass = ExecuteOperateMonitorResultDto.class, paramType = "body",allowMultiple = true)
    public ResponseData<String> addDealExtOperateMonitorResult(@RequestBody List<ExecuteOperateMonitorResultDto> executeOperateMonitorResultDtoList) {
        return extMonitoringItemService.addDealExtOperateMonitorResult(executeOperateMonitorResultDtoList);
    }

    @ApiOperation(value = "删除执行监控项检查结果接口")
    @PostMapping("/deleteDealExtOperateMonitorResult")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fundCode", value = "产品代码", dataType = "string", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "itemCode", value = "监控项id", dataType = "integer", dataTypeClass = Integer.class, paramType = "query"),
            @ApiImplicitParam(name = "businessDate", value = "业务日期", dataType = "string", dataTypeClass = String.class,paramType = "query"),
    })
    public ResponseData<String> deleteDealExtOperateMonitorResult( String fundCode, Integer itemCode, String businessDate) {
        return extMonitoringItemService.deleteDealExtOperateMonitorResult(itemCode, businessDate, fundCode);
    }
}
