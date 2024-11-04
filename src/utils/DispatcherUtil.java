package utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 提供使用请求分配方式打开网页的方法的工具类
 */
public class DispatcherUtil {
    /**
     * 使用请求分配方式打开weburl指定的网页
     * @param weburl  需要打开的网页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void openWeb(String weburl,HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(weburl);
        rd.forward(request,response);
    }

    /**
     * 使用请求转发方式打开错误信息页面errors.jsp，显式错误信息
     * @param errMsg  要在errors.jsp中显示的错误信息字符串
     * @param backUrl 在errors.jsp中返回上一页的url地址
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void openErrWeb(String errMsg, String backUrl,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errMsg",errMsg);
        request.setAttribute("backUrl",backUrl);
        RequestDispatcher rd = request.getRequestDispatcher("errors.jsp");
        rd.forward(request,response);
    }

}
