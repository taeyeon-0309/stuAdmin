package com.iu2java.interceptor;

import com.iu2java.pojo.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @title
 * @description 登录拦截器
 * @author admin
 * @updateTime
 * @throws
 */
@Component
public class Loginlnterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //获取请求路径
        String requestServletPath = request.getServletPath();
        System.out.println("当前请求路径为:" + requestServletPath);
        //判断管理员是否已登录
        if (requestServletPath.startsWith("/") && null == request.getSession().getAttribute("loginAdmin")) {
            request.getSession().setAttribute("amsg","请登录");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
            //判断用户是否已登录
        }else if (requestServletPath.startsWith("/") && null == request.getSession().getAttribute("loginUser")){
            request.getSession().setAttribute("umsg","请登录");
            response.sendRedirect(request.getContextPath() + "/ulogin");
            return false;
        }else {
            request.getSession().removeAttribute("amsg");
            request.getSession().removeAttribute("umsg");
            return true;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
