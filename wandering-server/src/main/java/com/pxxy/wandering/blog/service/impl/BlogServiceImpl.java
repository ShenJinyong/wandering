package com.pxxy.wandering.blog.service.impl;

import com.pxxy.wandering.blog.entity.po.BlogPo;
import com.pxxy.wandering.blog.mapper.BlogMapper;
import com.pxxy.wandering.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
