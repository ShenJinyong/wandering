package com.pxxy.wandering.blog.service.impl;

import com.pxxy.wandering.blog.entity.po.UserPo;
import com.pxxy.wandering.blog.entity.vo.UserVo;
import com.pxxy.wandering.blog.mapper.UserMapper;
import com.pxxy.wandering.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private UserMapper userMapper;

    public List<UserVo> selectAll(){
        List<UserPo> userPos = userMapper.selectList(null);
        if(CollectionUtils.isEmpty(userPos)){
            return null;
        }
        return userPos.stream().map(UserVo::formUserPo).collect(Collectors.toList());
    }
}
