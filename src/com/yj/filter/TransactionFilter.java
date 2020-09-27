package com.yj.filter;

import com.yj.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yj
 * @create 2020-08-28 21:54
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JDBCUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给tomcat服务器统一展示友好提示页面
        }
    }

    @Override
    public void destroy() {

    }
}
