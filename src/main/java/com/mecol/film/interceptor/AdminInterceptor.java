package com.mecol.film.interceptor;


import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if (session.getAttribute("admin")!=null){
            return true;
        }

        System.out.println("进入拦截器");
        response.sendRedirect(request.getContextPath()+"/adminlogin");
        return false;
    }
}
