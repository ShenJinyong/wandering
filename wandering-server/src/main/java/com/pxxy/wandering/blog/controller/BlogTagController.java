package com.pxxy.wandering.blog.controller;

import com.pxxy.wandering.blog.entity.po.BlogTagPo;
import com.pxxy.wandering.blog.entity.vo.BlogTagVo;
import com.pxxy.wandering.blog.service.impl.BlogTagServiceImpl;
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
@RequestMapping("/blog/blogTagPo")
public class BlogTagController {

    @Resource
    private BlogTagServiceImpl blogTagService;

    @PostMapping("/create")
    public void create(@RequestParam("String") String tagName){
        BlogTagPo blogTypePo = new BlogTagPo();
        blogTypePo.setTagName(tagName);
        blogTagService.save(blogTypePo);
    }

    @GetMapping("/selectAll")
    public List<BlogTagVo> selectAll(){
        return blogTagService.setAll();
    }
}
