package com.hundsun.extoperatemonitordome.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/13 16:47
 */
@Data
@TableName(value = "TS_Execute_Operate_Monitor_Result")
public class TsExecuteOperateMonitorResult  implements Serializable {

    /**
     * 监控项编号
     */
    @TableField(value = "itemCode")
    private Integer itemCode;
    /**
     * 产品代码
     */
    @TableField(value = "fundCode")
    private String fundCode;
    /**
     * 业务日期
     */
    @TableField(value = "businessDate")
    private String businessDate;

    /**
     * 记录编号
     */
    @TableField(value = "recordId")
    private String recordId;

    /**
     * 字段描述
     */
    @TableField(value = "dataName")
    private String dataName;

    /**
     * 字段值
     */
    @TableField(value = "dataValue")
    private String dataValue;

    /**
     * 字段展示顺序
     */
    @TableField(value = "dataOrder")
    private String dataOrder;
}
