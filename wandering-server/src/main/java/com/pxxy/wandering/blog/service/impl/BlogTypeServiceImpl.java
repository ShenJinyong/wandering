package com.pxxy.wandering.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxxy.wandering.blog.entity.po.BlogTypePo;
import com.pxxy.wandering.blog.entity.vo.BlogTypeVo;
import com.pxxy.wandering.blog.mapper.BlogTypeMapper;
import com.pxxy.wandering.blog.service.BlogTypeService;
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
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogTypePo> implements BlogTypeService {

    @Resource
    private BlogTypeMapper blogTypeMapper;

    public List<BlogTypeVo> selectAll(){
        List<BlogTypePo> blogTypePos = blogTypeMapper.selectList(null);
        if (CollectionUtils.isEmpty(blogTypePos)){
            return null;
        }
        return blogTypePos.stream().map(BlogTypeVo::formBlogTypePo).collect(Collectors.toList());
    }
}
