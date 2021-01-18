package com.erp.common.dto;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

public abstract class BaseController<T> {
    private static final String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(new SimpleDateFormat(DATE_FORMATE), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(java.math.BigDecimal.class, new BaseControllerExtentBigDecimal());
    }
}

