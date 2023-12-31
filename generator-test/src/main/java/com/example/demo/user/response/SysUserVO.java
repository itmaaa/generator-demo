package  com.example.demo.user.response;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * SysUserVO 请求返回对象
 * @author mazh
 * @since 2023-07-04
 */
@Getter
@Setter
@ApiModel(value = "SysUserVO 请求返回对象")
public class SysUserVO {


     @ApiModelProperty(value = "用户ID")
     private Long userId;


     @ApiModelProperty(value = "部门ID")
     private Long deptId;


     @ApiModelProperty(value = "登录账号")
     private String loginName;


     @ApiModelProperty(value = "用户昵称")
     private String userName;


     @ApiModelProperty(value = "用户类型（00系统用户 01注册用户）")
     private String userType;


     @ApiModelProperty(value = "用户邮箱")
     private String email;


     @ApiModelProperty(value = "手机号码")
     private String phonenumber;


     @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
     private String sex;


     @ApiModelProperty(value = "头像路径")
     private String avatar;


     @ApiModelProperty(value = "密码")
     private String password;


     @ApiModelProperty(value = "盐加密")
     private String salt;


     @ApiModelProperty(value = "帐号状态（0正常 1停用）")
     private String status;


     @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
     private String delFlag;


     @ApiModelProperty(value = "最后登录IP")
     private String loginIp;


     @ApiModelProperty(value = "最后登录时间")
     private Date loginDate;


     @ApiModelProperty(value = "密码最后更新时间")
     private Date pwdUpdateDate;


     @ApiModelProperty(value = "创建者")
     private String createBy;


     @ApiModelProperty(value = "创建时间")
     private Date createTime;


     @ApiModelProperty(value = "更新者")
     private String updateBy;


     @ApiModelProperty(value = "更新时间")
     private Date updateTime;


     @ApiModelProperty(value = "备注")
     private String remark;

}
