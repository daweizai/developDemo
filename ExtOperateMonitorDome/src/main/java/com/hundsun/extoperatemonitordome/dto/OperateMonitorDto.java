package com.hundsun.extoperatemonitordome.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能说明:
 * 外部监控项基本信息实体
 *
 * @author daweizai36273
 * @date 2022/10/10 10:51
 */
@ApiModel(value = "监控项信息",description = "监控项信息")
@Data
public class OperateMonitorDto {

    /**
     * 检查项编号
     */
    @ApiModelProperty(value = "检查项编号")
    private Integer itemCode;

    /**
     * 检查项名称
     */
    @ApiModelProperty(value = "检查项名称")
    private String itemName;

    /**
     * 检查节点
     */
    @ApiModelProperty(value = "检查节点")
    private String checkPoint;

    /**
     * 检查类别
     */
    @ApiModelProperty(value = "检查类别")
    private String checkType;

    /**
     * 检查级别
     */
    @ApiModelProperty(value = "检查级别")
    private String alertLevel;

    /**
     * 是否公共
     */
    @ApiModelProperty(value = "是否公共")
    private String isPublic;

    /**
     * 关联业务
     */
    @ApiModelProperty(value = "关联业务")
    private String relationBusiness;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    /**
     * 检查项描述
     */
    @ApiModelProperty(value = "检查项描述")
    private String checkDesc;

    /**
     * 检查结果描述
     */
    @ApiModelProperty(value = "检查结果描述")
    private String resultDesc;

    /**
     * 阈值描述
     */
    @ApiModelProperty(value = "阈值描述")
    private String indicatorDesc;

    /**
     * 阈值1
     */
    @ApiModelProperty(value = "阈值1")
    private String indicator1;

    /**
     * 阈值2
     */
    @ApiModelProperty(value = "阈值2")
    private String indicator2;
}
