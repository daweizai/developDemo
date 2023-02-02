package com.hundsun.extoperatemonitordome.sercice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hundsun.extoperatemonitordome.datasource.dao.TsCheckItemInfoMapper;
import com.hundsun.extoperatemonitordome.datasource.entity.TsCheckItemInfo;
import com.hundsun.extoperatemonitordome.dto.OperateMonitorDto;
import com.hundsun.extoperatemonitordome.sercice.TsCheckItemInfoService;
import com.hundsun.extoperatemonitordome.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/13 17:05
 */
@Service
@Slf4j
public class TsCheckItemInfoServiceImpl implements TsCheckItemInfoService {

    @Autowired
    TsCheckItemInfoMapper tsCheckItemInfoMapper;

    @Override
    public ResponseData<String> addItemInfo(OperateMonitorDto operateMonitorDto) {
        ResponseData<String> responseData = new ResponseData<>();
        try {
            if (operateMonitorDto == null) {
                throw new RuntimeException("入参不能为空");
            }
            TsCheckItemInfo tsCheckItemInfo = new TsCheckItemInfo();
            BeanUtils.copyProperties(operateMonitorDto, tsCheckItemInfo);
            int count = tsCheckItemInfoMapper.insert(tsCheckItemInfo);
            if (count > 0) {
                responseData.setReturnData("新增成功");
            }
        } catch (RuntimeException e) {
            responseData.setReturnCode("-1");
            responseData.setReturnMsg(e.getMessage());
            log.error("新增异常",e);
        }
        return responseData;
    }

    @Override
    public ResponseData<String> deleteItemInfo(Integer itemCode) {
        ResponseData<String> responseData = new ResponseData<>();
        try {
            if (itemCode == null) {
                throw new RuntimeException("itemCode不能为空");
            }
            LambdaQueryWrapper<TsCheckItemInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TsCheckItemInfo::getItemCode, itemCode);
            int remove = tsCheckItemInfoMapper.delete(queryWrapper);
            if (remove > 0) {
                responseData.setReturnData("删除成功");
            }
        } catch (RuntimeException e) {
            responseData.setReturnCode("-1");
            responseData.setReturnMsg(e.getMessage());
        }
        return responseData;
    }

    @Override
    public ResponseData<List<OperateMonitorDto>> listExtOperateMonitor() {
        ResponseData<List<OperateMonitorDto>> responseData = new ResponseData<>();
        try {
            List<TsCheckItemInfo> tsCheckItemInfoList = tsCheckItemInfoMapper.selectList(null);
            List<OperateMonitorDto> operateMonitorDtoList = new ArrayList<>();
            if (!tsCheckItemInfoList.isEmpty()) {
                tsCheckItemInfoList.forEach(obj -> {
                    OperateMonitorDto operateMonitorDto = new OperateMonitorDto();
                    BeanUtils.copyProperties(obj, operateMonitorDto);
                    operateMonitorDtoList.add(operateMonitorDto);
                });
            }
            responseData.setReturnData(operateMonitorDtoList);
        } catch (RuntimeException e) {
            responseData.setReturnCode("-1");
            responseData.setReturnMsg(e.getMessage());
            log.error("查询异常",e);

        }
        return responseData;
    }
}
