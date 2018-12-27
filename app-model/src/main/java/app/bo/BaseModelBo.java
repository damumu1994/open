package app.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("公共模块")
public class BaseModelBo {
    private Integer page = 1;
    private Integer rows = 10;
    @ApiModelProperty("顺序")
    private Integer paramOrder;
   // @ApiModelProperty("部门ID")
    //private String departId;
    @ApiModelProperty("用户id，如果是修改或者新增，这个参数必传")
    private String userId;
    private Date createDate;
    private Date updateDate;
    private String createBy;
    private String modifyBy;


}
