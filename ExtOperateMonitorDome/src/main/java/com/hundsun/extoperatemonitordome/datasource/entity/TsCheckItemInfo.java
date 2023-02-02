package com.hundsun.extoperatemonitordome.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/13 16:53
 */
@Data
@TableName("ts_checkItemInfo")
public class TsCheckItemInfo {

    /**
     * 检查项编号
     */
    @TableField(value = "itemCode")
    private Integer itemCode;

    /**
     * 检查项名称
     */
    @TableField(value = "itemName")
    private String itemName;

    /**
     * 检查节点
     */
    @TableField(value = "checkPoint")
    private String checkPoint;

    /**
     * 检查类别
     */
    @TableField(value = "checkType")
    private String checkType;

    /**
     * 检查级别
     */
    @TableField(value = "alertLevel")
    private String alertLevel;

    /**
     * 是否公共
     */
    @TableField(value = "isPublic")
    private String isPublic;

    /**
     * 关联业务
     */
    @TableField(value = "relationBusiness")
    private String relationBusiness;

    /**
     * 菜单名称
     */
    @TableField(value = "menuName")
    private String menuName;

    /**
     * 检查项描述
     */
    @TableField(value = "checkDesc")
    private String checkDesc;

    /**
     * 检查结果描述
     */
    @TableField(value = "resultDesc")
    private String resultDesc;

    /**
     * 阈值描述
     */
    @TableField(value = "indicatorDesc")
    private String indicatorDesc;

    /**
     * 阈值1
     */
    @TableField(value = "indicator1")
    private String indicator1;

    /**
     * 阈值2
     */
    @TableField(value = "indicator2")
    private String indicator2;
}
