package app.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Administrator
 * @Date: 2018/11/8 0008 11:04
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("注册或登录传递的参数")
public class UserBo {
    @ApiModelProperty("用户账号")
    private String username;
    @ApiModelProperty("用户头像地址")
    private String headUrl;
    @ApiModelProperty("注册手机")
    private String moblie;
    @ApiModelProperty("登录密码")
    private String password;
}
