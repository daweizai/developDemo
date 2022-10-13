package com.hundsun.extoperatemonitordome.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/10 20:31
 */
@Data
@TableName("OperateMonitorResul")
public class ExecuteOperateMonitorResultDto {

    @ApiModelProperty("监控项id")
    private Integer itemCode;

    @ApiModelProperty("产品代码")
    private String fundCode;

    @ApiModelProperty("业务日期")
    private String businessDate;

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
