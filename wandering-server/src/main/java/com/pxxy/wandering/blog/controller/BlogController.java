package com.pxxy.wandering.blog.controller;

import com.pxxy.wandering.blog.entity.dto.BlogDto;
import com.pxxy.wandering.blog.entity.po.BlogPo;
import com.pxxy.wandering.blog.service.impl.BlogServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-30 03:49:28
 */
@RestController
@RequestMapping("/blog/blogPo")
public class BlogController {

    @Resource
    private BlogServiceImpl blogService;

    @PostMapping("create")
    public void create(@RequestBody BlogDto blogDto) {
        blogService.save(new BlogPo().formBogDto(blogDto));
    }

}