package app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author shen
 * @since 2018-07-13
 */
@ApiModel("新增用户")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddSysUserVo {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "登录账号不能为空")
    @ApiModelProperty("登录账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("身高")
    private Double height;
    @ApiModelProperty("体重")
    private Double weight;
    @ApiModelProperty("性别，0是未知，1是男，0是女，其他值为未知")
    private Integer sex;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("头像地址")
    private String headUrl;
    @NotEmpty(message = "请填写联系方式")
    @ApiModelProperty("联系电话")
    private String mobile;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("家庭组")
    private String familyTies;
    @ApiModelProperty("家庭住址")
    private String address;
    @ApiModelProperty("备注")
    private String remark;

}
