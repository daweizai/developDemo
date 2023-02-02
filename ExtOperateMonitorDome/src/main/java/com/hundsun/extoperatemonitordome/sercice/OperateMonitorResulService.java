package com.hundsun.extoperatemonitordome.sercice;

import com.hundsun.extoperatemonitordome.dto.ExecuteOperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.dto.OperateMonitorResultDto;
import com.hundsun.extoperatemonitordome.util.ResponseData;

import java.util.List;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/10 13:47
 */
public interface OperateMonitorResulService{


    /**
     * 功能描述:
     *
     * @param fundCode
     * @param itemId
     * @param businessDate
     * @param indicator1
     * @param indicator2
     * @return com.hundsun.extoperatemonitordome.util.ResponseData<java.util.List < com.hundsun.extoperatemonitordome.dto.OperateMonitorResultDto>>
     */
    ResponseData<List<OperateMonitorResultDto>> dealExtOperateMonitor(String fundCode, String itemId, String businessDate, String indicator1, String indicator2);


    /**
     * 功能描述:
     * 新增检查结果
     *
     * @param executeOperateMonitorResultDtoList
     * @return com.hundsun.extoperatemonitordome.util.ResponseData<java.lang.String>
     */
    ResponseData<String> addDealExtOperateMonitorResult(List<ExecuteOperateMonitorResultDto> executeOperateMonitorResultDtoList);

    /**
     * 功能描述:
     * 删除检查结果
     *
     * @param itemCode
     * @param businessDate
     * @param fundCode
     * @return com.hundsun.extoperatemonitordome.util.ResponseData<java.lang.String>
     */
    ResponseData<String> deleteDealExtOperateMonitorResult(Integer itemCode, String businessDate, String fundCode);
}
