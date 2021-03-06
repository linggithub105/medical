package cn.ling.medicalview.web;

import cn.ling.medicalview.pojo.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 过滤视图 控制
 * 过滤器 登录
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取用户登录的会话
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse Response=(HttpServletResponse)servletResponse;
        Object object=request.getSession().getAttribute("user");
        System.out.println("--------------->进入过滤器 Filter  9:56");
        filterChain.doFilter(request, Response);
        //或者 object==null 进行重定向

        /*if(object!=null && (object instanceof User)){
            //用户 放行 进入登入成功界面
            filterChain.doFilter(request, Response);//放行命令
        }else{
            Response.sendRedirect(request.getContextPath()+"/login.jsp");
        }*/
    }

    @Override
    public void destroy() {

    }
}
