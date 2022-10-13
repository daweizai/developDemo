package com.hundsun.extoperatemonitordome.datasource.entity;

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
    private Integer itemCode;

    /**
     * 检查项名称
     */
    private String itemName;

    /**
     * 检查节点
     */
    private String checkPoint;

    /**
     * 检查类别
     */
    private String checkType;

    /**
     * 检查级别
     */
    private String alertLevel;

    /**
     * 是否公共
     */
    private String isPublic;

    /**
     * 关联业务
     */
    private String relationBusiness;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 检查项描述
     */
    private String checkDesc;

    /**
     * 检查结果描述
     */
    private String resultDesc;

    /**
     * 阈值描述
     */
    private String indicatorDesc;

    /**
     * 阈值1
     */
    private String indicator1;

    /**
     * 阈值2
     */
    private String indicator2;
}
