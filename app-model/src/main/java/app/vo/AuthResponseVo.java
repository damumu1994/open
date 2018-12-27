package app.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 *
 * @author shen
 * @Date 2017/8/24 13:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponseVo implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    /**
     * jwt token
     */
    private String token;

    /**
     * 用于客户端混淆md5加密
     */
    private String randomKey;


}
