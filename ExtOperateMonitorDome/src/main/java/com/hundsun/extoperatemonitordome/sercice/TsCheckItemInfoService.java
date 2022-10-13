package com.hundsun.extoperatemonitordome.sercice;

import com.hundsun.extoperatemonitordome.dto.OperateMonitorDto;
import com.hundsun.extoperatemonitordome.util.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/13 17:04
 */
public interface TsCheckItemInfoService{


    /**
     * 功能描述:
     *
     * @param operateMonitorDto
     * @return com.hundsun.extoperatemonitordome.util.ResponseData<java.lang.String>
     */
    ResponseData<String> addItemInfo(@RequestBody OperateMonitorDto operateMonitorDto);

    /**
     * 功能描述:
     *
     * @param itemCode
     * @return com.hundsun.extoperatemonitordome.util.ResponseData<java.lang.String>
     */
    ResponseData<String> deleteItemInfo(Integer itemCode);

    /**
     * 功能描述:
     * 获取外部监控项基本信息
     *
     * @return com.hundsun.fam.vo.ResponseData<java.util.List < com.hundsun.fam.dto.commonfacade.OperateMonitorDto>>
     */
    ResponseData<List<OperateMonitorDto>> listExtOperateMonitor();

}
