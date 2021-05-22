package com.day.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author easy_code
 * @since 2021-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderDetails对象", description="")
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单详情ID")
    @TableId(value = "order_details_id", type = IdType.AUTO)
    private Integer orderDetailsId;

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "单价")
    private Float unitPrice;

    @ApiModelProperty(value = "件")
    private Integer piece;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "金额")
    private Float money;


}
