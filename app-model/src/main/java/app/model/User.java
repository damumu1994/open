package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    /**
     * 登录账号
     */
    @Column
    private String username;
    @Column
    private  Double weght;
    /**
     * 密码
     */
    @Column

    private String password;
    @Column
    private String nickName;
    @Column
    private Double height;
    /**
     * 性别，0是未知，1是男，0是女，其他值为未知
     */
    private String pid;
    private Integer integral;
    @Column
    private Integer sex;
    /**
     * 真实姓名
     */
    @Column
    private String realName;
    /**
     * 头像地址
     */
    @Column
    private String headUrl;
    /**
     * 联系电话
     */
    @Column
    private String mobile;
    /**
     * 生日
     */
    @Column
    private Date birthday;
    @Column
    private String address;
    @Column
    private  String rongToken;
    @Column
    private String familyTies;

    /**
     * 备注
     */
    @Column
    private String remark;
    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    @Column
    private Integer deleteStatus =0 ;
    /**
     * 创建人
     */
    @Column
    private String createBy;
    /**
     * 积分
     */

    /**
     * 创建时间
     */
    @Column
    private Date createDate;
    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 修改时间
     */
    @Column
    private Date modifyDate;
    /**
     * 历史数据状态，默认是0，0是当前最新数据，1是历史修改数据
     */
    @Column
    private Integer validStatus;
    /**
     * 历史修改历史编号
     */
    @Column
    private String hisCode;

    private Double nakedWeight;
    private Double pureHight;
}
