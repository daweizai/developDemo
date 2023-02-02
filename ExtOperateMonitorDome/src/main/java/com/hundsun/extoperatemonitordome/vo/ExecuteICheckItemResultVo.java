package com.hundsun.extoperatemonitordome.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 功能说明:
 *
 * @author daweizai36273
 * @date 2022/10/14 20:16
 */
@Data
public class ExecuteICheckItemResultVo {
    @ApiModelProperty("产品代码")
    private String fundCode;

    @ApiModelProperty("检查项编号")
    private String itemId;

    @ApiModelProperty("业务日期, 格式yyyyMMdd")
    private String businessDate;

    @ApiModelProperty("阈值1")
    private String indicator1;

    @ApiModelProperty("阈值2")
    private String indicator2;
}
