package filter;

import model.TUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter extends HttpServlet implements Filter {

    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//获得过滤器当前拦截的请求,该请求必须获得reqeust和response的内置对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //无论是否需要，习惯上必须设置reqeust和response的中文字符集编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获得拦截的请求的url
        String url = request.getServletPath();
        //System.out.println(url);

        //设置只对部分扩展名的请求URL进行拦截
        int pos = url.lastIndexOf("."); //从url后面查找"."的位置
        String suffixName = url.substring(pos, url.length());
        //System.out.println(suffixName);

        HttpSession session = request.getSession();
        TUser loginUser = (TUser) session.getAttribute("loginuser");

        if (suffixName.equals(".do") || suffixName.equals(".jsp")) {
            //只对后缀名为.do和.jsp的请求进行拦截
            //接下来只对满足条件的url才予以放行
            if (url.endsWith("index.do") || url.endsWith("index.jsp") ||
                    url.endsWith("fruitinfo.do") || url.endsWith("fruitinfo.jsp")) {
                //以上servlet和jsp无论有没有登录，都放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (url.endsWith("login.jsp") || url.endsWith("login.do")) {
                if (loginUser == null || loginUser.getUserid() == null) {
                    //以上jsp和servlet当用户是未登录游客时才放行
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("index.do");//不满足条件则跳回主页
                }
            } else if (url.endsWith("logout.do")) {
                if (loginUser != null && loginUser.getUserid() != null) {
                    //以上jsp和servlet当用户是登录后才放行
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("index.do");//不满足条件则跳回主页
                }
            } else if (url.endsWith("editfruit.jsp") || url.endsWith("editfruit.do")
                    || url.endsWith("savefruit.do") || url.endsWith("deletefruit.do")) {
                if (loginUser != null && loginUser.getRolecode() == 1) {
                    //以上jsp和servlet当用户是登录后,且是管理员才放行
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("index.do");//不满足条件则跳回主页
                }
            }
        } else {
            //其它的url一律放行通过
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
