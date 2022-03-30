package com.pxxy.wandering.blog.service.impl;

import com.pxxy.wandering.blog.entity.po.UserPo;
import com.pxxy.wandering.blog.mapper.UserMapper;
import com.pxxy.wandering.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-30 03:49:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

}
