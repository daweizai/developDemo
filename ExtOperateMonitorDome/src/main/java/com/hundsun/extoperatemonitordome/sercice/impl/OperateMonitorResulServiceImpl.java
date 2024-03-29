package com.hundsun.extoperatemonitordome.sercice.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hundsun.extoperatemonitordome.datasource.dao.OperateMonitorResulMapper;
import com.hundsun.extoperatemonitordome.datasource.entity.TsExecuteOperateMonitorResult;
import com.hundsun.extoperatemonitordome.dto.ExecuteOperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.dto.OperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.sercice.OperateMonitorResulService;
import com.hundsun.extoperatemonitordome.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 * 外部heduix
 *
 * @author daweizai36273
 * @date 2022/10/10 13:47
 */
@Service
@Slf4j
public class OperateMonitorResulServiceImpl implements OperateMonitorResulService {

    @Autowired
    OperateMonitorResulMapper operateMonitorResulMapper;

    @Override
    public ResponseData<String> addDealExtOperateMonitorResult(List<ExecuteOperateMonitorResultDto> executeOperateMonitorResultDtoList) {
        ResponseData<String> responseData = new ResponseData<>();
        if (CollectionUtil.isEmpty(executeOperateMonitorResultDtoList)){
           return responseData.error("入参为空");
        }
        int count = 0;
        for (ExecuteOperateMonitorResultDto executeOperateMonitorResultDto : executeOperateMonitorResultDtoList) {
            TsExecuteOperateMonitorResult tsExecuteOperateMonitorResult = new TsExecuteOperateMonitorResult();
            BeanUtils.copyProperties(executeOperateMonitorResultDto, tsExecuteOperateMonitorResult);
            count += operateMonitorResulMapper.insert(tsExecuteOperateMonitorResult);
        }
        if (count > 0){
            responseData.setReturnData("新增成功");
        }else {
            responseData.setReturnData("新增失败");
        }
        return responseData;
    }

    @Override
    public ResponseData<List<OperateMonitorResultDto>> dealExtOperateMonitor(String fundCode, String itemId, String businessDate, String indicator1, String indicator2) {
        ResponseData<List<OperateMonitorResultDto>> responseData = new ResponseData<>();
        List<String> dateValueList = new ArrayList<>();
        if (StringUtils.isNotBlank(indicator1)){
            dateValueList.add(indicator1);
        }
        if (StringUtils.isNotBlank(indicator2)){
            dateValueList.add(indicator2);
        }
        LambdaQueryWrapper<TsExecuteOperateMonitorResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TsExecuteOperateMonitorResult::getFundCode, fundCode)
                    .and(i ->i.eq(TsExecuteOperateMonitorResult::getItemCode, itemId))
                .and(i-> i.eq(TsExecuteOperateMonitorResult::getBusinessDate, businessDate));
        if (CollectionUtil.isNotEmpty(dateValueList)){
            queryWrapper.and(i -> i.in(TsExecuteOperateMonitorResult::getDataValue, dateValueList));
        }
        List<TsExecuteOperateMonitorResult> resultList = operateMonitorResulMapper.selectList(queryWrapper);
        if (resultList.isEmpty()){
            return responseData;
        }
        List<OperateMonitorResultDto> operateMonitorResultDtoList = new ArrayList<>();
        resultList.forEach(obj -> {
            OperateMonitorResultDto operateMonitorResultDto = new OperateMonitorResultDto();
            BeanUtils.copyProperties(obj, operateMonitorResultDto);
            operateMonitorResultDtoList.add(operateMonitorResultDto);
        });
        responseData.setReturnData(operateMonitorResultDtoList);
        return responseData;
    }



    @Override
    public ResponseData<String> deleteDealExtOperateMonitorResult(Integer itemCode, String businessDate, String fundCode) {
        ResponseData<String> responseData = new ResponseData<>();
        try {
            if (itemCode == null){
                throw new RuntimeException("itemCode不能为空");
            }
            if (StringUtils.isNotBlank(businessDate)){
                throw new RuntimeException("businessDate不能为空");
            }
            if (StringUtils.isNotBlank(fundCode)){
                throw new RuntimeException("fundCode不能为空");
            }
            LambdaQueryWrapper<TsExecuteOperateMonitorResult> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TsExecuteOperateMonitorResult::getFundCode, fundCode)
                    .and(i ->i.eq(TsExecuteOperateMonitorResult::getItemCode, itemCode))
                    .and(i-> i.eq(TsExecuteOperateMonitorResult::getBusinessDate, businessDate));
            int remove = operateMonitorResulMapper.delete(queryWrapper);
            if (remove > 0){
                responseData.setReturnData("删除成功");
            }
        } catch (RuntimeException e) {
            responseData.setReturnCode("-1");
            responseData.setReturnMsg(e.getMessage());
        }
        return responseData;
    }


}
