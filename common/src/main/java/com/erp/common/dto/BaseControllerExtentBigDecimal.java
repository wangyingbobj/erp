package com.erp.common.dto;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

public class BaseControllerExtentBigDecimal extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Object value = getValue();
        return (value != null ? value.toString() : "");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || "".equals(text.trim())) {
            setValue(null);
        } else {
            String value = text.trim();
            if (value.indexOf(".") != -1) {
                setValue(BigDecimal.valueOf(Double.parseDouble(value)));
            } else {
                setValue(BigDecimal.valueOf(Long.parseLong(value)));
            }
        }
    }
}