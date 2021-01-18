package com.erp.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 分页参数
 */
@Data
@AllArgsConstructor
@SuppressWarnings("all")
public class Pagination<T>  {

    /** 当前页数 */
    @Builder.Default
    @ApiModelProperty(value = "当前页数", example = "1")
    private Integer pageNum=1;
    /** 每页页数 */
    @Builder.Default
    @ApiModelProperty(value = "每页页数", example = "10")
    private Integer pageSize=10;
    @Builder.Default
    @ApiModelProperty(value = "总条数", example = "10")
    private Long total;
    private Long recordsTotal;

    /**
     * 分页内容
     */
    @ApiModelProperty(value = "分页内容")
    private java.util.List<T> data;

    public Pagination() {

    }
    public Pagination(Integer pageNum1, Integer pageSize1){
        this.pageNum = defaultInt(pageNum1,this.pageNum);
        this.pageSize = defaultInt(pageNum,this.pageSize);
    }


    /**
     * 获取分页对象
     * @return
     */
    public Page page() {
        return new Page(defaultInt(pageNum,this.pageNum), defaultInt(pageNum,this.pageSize));
    }

    /***
     * 只会输入页数和页码
     * 当页数为空或<1 页数为1
     * 当页码为空或<1 页码为10
     * @param i
     * @param def
     * @return
     */
    private Integer defaultInt(Integer i,Integer def){
        if(i == null || i<=1)
            return def;
        else
            return i;
    }
}
