package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import util.web.WebResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class ResponseUtil {

    public static void responseResult(HttpServletResponse response, WebResponse result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
