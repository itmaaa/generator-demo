package  com.example.demo.user.request;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * SysUserDTO 请求参数对象
 * @author mazh
 * @since 2023-07-04
 */
@Getter
@Setter
@ApiModel(value = "SysUserDTO请求参数对象")
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

     @ApiModelProperty(value = "用户ID",required = true)
     @NotNull(message = "用户ID userId  字段不能为空")
     private Long userId;

     @ApiModelProperty(value = "部门ID",required = true)
     @NotNull(message = "部门ID deptId  字段不能为空")
     private Long deptId;

     @ApiModelProperty(value = "登录账号",required = true)
     @NotBlank(message = "登录账号 loginName 字段不能为空")
     private String loginName;

     @ApiModelProperty(value = "用户昵称",required = true)
     @NotBlank(message = "用户昵称 userName 字段不能为空")
     private String userName;

     @ApiModelProperty(value = "用户类型（00系统用户 01注册用户）",required = true)
     @NotBlank(message = "用户类型（00系统用户 01注册用户） userType 字段不能为空")
     private String userType;

     @ApiModelProperty(value = "用户邮箱",required = true)
     @NotBlank(message = "用户邮箱 email 字段不能为空")
     private String email;

     @ApiModelProperty(value = "手机号码",required = true)
     @NotBlank(message = "手机号码 phonenumber 字段不能为空")
     private String phonenumber;

     @ApiModelProperty(value = "用户性别（0男 1女 2未知）",required = true)
     @NotBlank(message = "用户性别（0男 1女 2未知） sex 字段不能为空")
     private String sex;

     @ApiModelProperty(value = "头像路径",required = true)
     @NotBlank(message = "头像路径 avatar 字段不能为空")
     private String avatar;

     @ApiModelProperty(value = "密码",required = true)
     @NotBlank(message = "密码 password 字段不能为空")
     private String password;

     @ApiModelProperty(value = "盐加密",required = true)
     @NotBlank(message = "盐加密 salt 字段不能为空")
     private String salt;

     @ApiModelProperty(value = "帐号状态（0正常 1停用）",required = true)
     @NotBlank(message = "帐号状态（0正常 1停用） status 字段不能为空")
     private String status;

     @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）",required = true)
     @NotBlank(message = "删除标志（0代表存在 2代表删除） delFlag 字段不能为空")
     private String delFlag;

     @ApiModelProperty(value = "最后登录IP",required = true)
     @NotBlank(message = "最后登录IP loginIp 字段不能为空")
     private String loginIp;

     @ApiModelProperty(value = "备注",required = true)
     @NotBlank(message = "备注 remark 字段不能为空")
     private String remark;

}
