package com.example.demo.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.user.entity.SysUser;
import com.example.demo.user.mapper.SysUserMapper;
import com.example.demo.user.request.SysUserDTO;
import com.example.demo.user.response.SysUserVO;
import com.example.demo.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author mazh
 * @since 2023-07-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
   @Resource
   private SysUserMapper sysUserMapper;


    @Override
    public void add(SysUserDTO  req) {
         SysUser sysUser = BeanUtil.copyProperties(req, SysUser.class);
         sysUserMapper.insert(sysUser);
    }

    @Override
    public void update(SysUserDTO req) {
        LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaQuery();
       // .eq(SysUser::getBabyId, req.getBabyId());
        SysUser sysUser = BeanUtil.copyProperties(req, SysUser.class);
        sysUserMapper.update( sysUser ,wrapper);

    }

    @Override
    public List<SysUserVO> list(SysUserDTO req) {
        LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaQuery();
        // .eq(SysUser::getBabyId, req.getBabyId());
        List<SysUser> sysUserList = sysUserMapper.selectList(wrapper);
        List<SysUserVO> list = BeanUtil.copyToList(sysUserList, SysUserVO.class);
        return list;
    }

}
