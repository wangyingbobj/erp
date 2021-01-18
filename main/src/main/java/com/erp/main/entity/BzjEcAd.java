package com.erp.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.erp.common.dto.BaseEntity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 广告表
 * </p>
 *
 * @author 帅帅
 * @since 2021-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="BzjEcAd对象", description="广告表")
public class BzjEcAd extends BaseEntity<BzjEcAd> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "媒体路径")
    private String mediaUrl;

    @ApiModelProperty(value = "媒体类型 1产品 2活动 3静态图片(无跳转)")
    private String mediaType;

    @ApiModelProperty(value = "投放日期")
    private Date putinDate;

    @ApiModelProperty(value = "失效日期")
    private Date expiryDate;

    @ApiModelProperty(value = "投放状态")
    private String putinState;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "广告位id")
    private Integer positionId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "操作人id")
    private Integer optUserId;

    @ApiModelProperty(value = "跳转路径")
    private String toUrl;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
