package com.example.demo.user.service;

import com.example.demo.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.user.request.SysUserDTO;
import com.example.demo.user.response.SysUserVO;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author mazh
 * @since 2023-07-04
 */
public interface SysUserService extends IService<SysUser> {

  void update(SysUserDTO req);

  void add(SysUserDTO req);

  List<SysUserVO> list(SysUserDTO req);

}
