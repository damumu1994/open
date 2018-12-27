package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:04
 */
@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            chain.doFilter(request, response);
            return;
        }

        if (request.getRequestURL().toString().indexOf("swagger") > 0 || request.getRequestURL().toString().indexOf("api-docs") > 0) {
            chain.doFilter(request, response);
            return;
        }

        if (request.getRequestURL().toString().endsWith("common/token")
                || request.getRequestURL().toString().endsWith("/test")
                || request.getRequestURL().toString().endsWith("/api/user/user/getAuthCode")
                || request.getRequestURL().toString().endsWith("/api/user/user/checkmobile")
                || request.getRequestURL().toString().endsWith("/api/user/user/register")
                || request.getRequestURL().toString().endsWith("/api/login/loginByMobilePassword")
                || request.getRequestURL().toString().endsWith("/api/user/user/resetUserPwdAuth")
                || request.getRequestURL().toString().endsWith("/api/login/loginByAuthCode")
                || request.getRequestURL().toString().endsWith("/api/user/user/resetUserPwd")
                || request.getRequestURL().toString().endsWith("/api/user/user/perfection")
                || request.getRequestURL().toString().endsWith("im/user/login")
                || request.getRequestURL().toString().endsWith("common/upload")
                || request.getRequestURL().toString().endsWith("common/uploads")
                || request.getRequestURL().toString().endsWith("web/version/list")
                || request.getRequestURL().toString().endsWith("authUser")) {
            chain.doFilter(request, response);
            return;
        }
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
//       WebResponse errorResponse = tokenValidate(requestHeader, jwtProperties.getSecret());
     //   if (errorResponse != null) {
     //    responseResult(response, errorResponse);

     //     return;
    //   }
        chain.doFilter(request, response);
    }

}