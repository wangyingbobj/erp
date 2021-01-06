package com.erp.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class AuthTokenFilter extends ZuulFilter {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Value("${name}")
    private String name;

    @Override
    public String filterType() {
        // 在路由之前进行过滤
        System.out.println("在路由之前进行过滤"+name);
        return null;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    // 过滤的核心逻辑
    @Override
    public boolean shouldFilter() {
        return false;
    }

    // 过滤通过后要执行的方法
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}