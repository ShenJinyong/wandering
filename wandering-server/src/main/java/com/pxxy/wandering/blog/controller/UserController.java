package com.pxxy.wandering.blog.controller;

import com.pxxy.wandering.blog.entity.dto.UserDto;
import com.pxxy.wandering.blog.entity.po.BlogTypePo;
import com.pxxy.wandering.blog.entity.po.UserPo;
import com.pxxy.wandering.blog.entity.vo.BlogTypeVo;
import com.pxxy.wandering.blog.entity.vo.UserVo;
import com.pxxy.wandering.blog.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-30 03:49:29
 */
@RestController
@RequestMapping("/blog/userPo")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @PostMapping("/create")
    public void create(@RequestBody UserDto userDto){
        userService.save(new UserPo().formUserDto(userDto));
    }

    @GetMapping("/selectAll")
    public List<UserVo> selectAll(){
        return userService.selectAll();
    }

}
