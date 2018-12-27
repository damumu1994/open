package app.vo;

import app.model.SysUserPo;
import app.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author shen
 * @since 2018-07-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUserVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("登录账号")
    private String username;
    @ApiModelProperty("性别，0是未知，1是男，0是女，其他值为未知")
    private Integer sex;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("头像地址")
    private String headUrl;

    private String pid;
    private Integer integral;
    private Double height;
    private Double weight;

    @ApiModelProperty("联系电话")
    private String mobile;
    @ApiModelProperty("生日")
    private Date birthday;

    //-------------------
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("创建人")
    private String createBy;
    private String modifyBy;
    @ApiModelProperty("注册时间")
    private Date createDate;

    public static User transfer(User sysUserPo) {
        return User.builder()
                .userId(sysUserPo.getUserId())
                .username(sysUserPo.getUsername())
                .sex(sysUserPo.getSex())
                .height(sysUserPo.getHeight())
                .integral(sysUserPo.getIntegral())
                .pid(sysUserPo.getPid())
                .realName(sysUserPo.getRealName())
                .headUrl(sysUserPo.getHeadUrl())
                .mobile(sysUserPo.getMobile())
                .birthday(sysUserPo.getBirthday())
                .remark(sysUserPo.getRemark())
                .createBy(sysUserPo.getCreateBy())
                .modifyBy(sysUserPo.getModifyBy())
                .createDate(sysUserPo.getCreateDate())
                .build();
    }


}
