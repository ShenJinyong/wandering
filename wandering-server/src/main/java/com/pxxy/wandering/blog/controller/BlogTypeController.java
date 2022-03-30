package com.pxxy.wandering.blog.controller;

import com.pxxy.wandering.blog.entity.po.BlogTypePo;
import com.pxxy.wandering.blog.entity.vo.BlogTypeVo;
import com.pxxy.wandering.blog.service.impl.BlogTypeServiceImpl;
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
@RequestMapping("/blog/blogTypePo")
public class BlogTypeController {

    @Resource
    private BlogTypeServiceImpl blogTypeService;

    @PostMapping("/create")
    public void create(@RequestParam("String") String typeName){
        BlogTypePo blogTypePo = new BlogTypePo();
        blogTypePo.setTypeName(typeName);
        blogTypeService.save(blogTypePo);
    }

    @GetMapping("/selectAll")
    public List<BlogTypeVo> selectAll(){
        return blogTypeService.selectAll();
    }
}
