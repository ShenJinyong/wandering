package com.pxxy.wandering.blog.service.impl;

import com.pxxy.wandering.blog.entity.po.BlogTagPo;
import com.pxxy.wandering.blog.entity.po.BlogTypePo;
import com.pxxy.wandering.blog.entity.vo.BlogTagVo;
import com.pxxy.wandering.blog.mapper.BlogTagMapper;
import com.pxxy.wandering.blog.mapper.BlogTypeMapper;
import com.pxxy.wandering.blog.service.BlogTagService;
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
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTagPo> implements BlogTagService {

    @Resource
    private BlogTagMapper blogTagMapper;

    public List<BlogTagVo> setAll(){
        List<BlogTagPo> blogTagPos = blogTagMapper.selectList(null);
        if(CollectionUtils.isEmpty(blogTagPos)){
            return null;
        }
        return blogTagPos.stream().map(BlogTagVo::formBlogTagPo).collect(Collectors.toList());
    }

}
