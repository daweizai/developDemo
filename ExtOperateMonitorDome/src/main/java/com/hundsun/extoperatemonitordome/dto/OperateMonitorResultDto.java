package com.hundsun.extoperatemonitordome.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能说明:
 * 外部核对项检查结果实例
 *
 * @author daweizai36273
 * @date 2022/10/10 11:02
 */
@ApiModel(value = "外部核对项检查结果实例")
@Data
public class OperateMonitorResultDto {

    /**
     * 记录编号
     */
    @ApiModelProperty("记录编号")
    private String recordId;

    /**
     * 字段描述
     */
    @ApiModelProperty("字段描述")
    private String dataName;

    /**
     * 字段值
     */
    @ApiModelProperty("字段值")
    private String dataValue;

    /**
     * 字段展示顺序
     */
    @ApiModelProperty("字段展示顺序")
    private String dataOrder;

}
