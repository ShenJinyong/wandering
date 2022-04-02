package com.pxxy.wandering.blog.service.impl;

import com.pxxy.wandering.blog.entity.po.BlogPo;
import com.pxxy.wandering.blog.entity.vo.BlogTagVo;
import com.pxxy.wandering.blog.entity.vo.BlogVo;
import com.pxxy.wandering.blog.entity.vo.UserVo;
import com.pxxy.wandering.blog.mapper.BlogMapper;
import com.pxxy.wandering.blog.service.BlogService;
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
 * @since 2022-03-30 03:49:28
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, BlogPo> implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    public List<BlogVo> selectAll(){
        List<BlogPo> blogPos = blogMapper.selectList(null);
        if(CollectionUtils.isEmpty(blogPos)){
            return null;
        }
        return blogPos.stream().map(BlogVo::formBlogPo).collect(Collectors.toList());
    }
}
