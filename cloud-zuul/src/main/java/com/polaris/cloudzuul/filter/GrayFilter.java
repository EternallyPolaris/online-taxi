package com.polaris.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.polaris.cloudzuul.dao.CommonGrayRuleDaoCustom;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class GrayFilter extends ZuulFilter {

    @Autowired
    private CommonGrayRuleDaoCustom commonGrayRuleDaoCustom;

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 查库

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        int userId = Integer.parseInt(request.getHeader("userId"));

        // 金丝雀
        if (userId == 1) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "v1");
        // 普通用户
        } else if (userId == 2) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "v2");
        }
        return null;
    }
}
