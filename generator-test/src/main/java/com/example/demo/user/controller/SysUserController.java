package com.example.demo.user.controller;

import com.example.demo.common.CommonResp;
import com.example.demo.user.request.SysUserDTO;
import com.example.demo.user.response.SysUserVO;
import com.example.demo.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author mazh
 * @since 2023-07-04
 */
@RestController
@Api(tags = "用户信息表")
@RequestMapping("/user/sysUser")
public class SysUserController {

    @Resource
    private SysUserService  sysUserService;

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public CommonResp<Void> add(@RequestBody @Validated SysUserDTO req) {
       sysUserService.add(req);
       return CommonResp.success();
     }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public CommonResp<Void> update(@RequestBody @Validated SysUserDTO req) {
        sysUserService.update(req);
        return CommonResp.success();
     }

     @ApiOperation(value = "列表")
     @PostMapping("/list")
     public CommonResp<List<SysUserVO>> list(@RequestBody @Validated SysUserDTO req) {
       List<SysUserVO> list = sysUserService.list(req);
       return CommonResp.success(list);
    }

}
