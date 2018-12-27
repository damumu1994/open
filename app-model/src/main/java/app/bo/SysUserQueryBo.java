package app.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUserQueryBo extends BaseModelBo {
    @ApiModelProperty("登录账号")
    private String username;
    @ApiModelProperty("真实姓名")
    private String realName;
}
