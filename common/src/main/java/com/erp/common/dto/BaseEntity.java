package com.erp.common.dto;

import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Map;

/**
 * 基础类
 */
public abstract class BaseEntity<T extends Model> extends Model {
    /**
     * 多余属性
     */
    @TableField(select = false,exist = false)
    private Dict extMap = Dict.create();

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public Object get(String key) {
        return extMap.get(key);
    }

    /**
     * 设置值
     * @param key
     * @param val
     */
    public void set(String key, Object val) {
        extMap.set(key, val);
    }


    public Map<String, Object> getTails() {
        return extMap;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
