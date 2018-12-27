/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @author shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class WebResponse<T> {

    /**
     * 返回的状态
     */
    private Integer code;
    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public static WebResponse success() {
        return new WebResponse(0, "操作成功", null);
    }

    public static <T> WebResponse<T> success(T data) {
        return new WebResponse(0, "操作成功", data);
    }

    public static WebResponse fail(String msg) {
        if (!StringUtils.isEmpty(msg)) {
            return new WebResponse(-1, msg, null);
        }
        return new WebResponse(-1, "操作失败", null);
    }

}
