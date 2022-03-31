package com.pxxy.wandering.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pxxy.wandering.blog.entity.po.BlogTagPo;
import com.pxxy.wandering.blog.util.IConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@TableName("blog_tag")
@ApiModel(value = "BlogTagVo对象", description = "")
public class BlogTagVo {

    @ApiModelProperty("标签主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("标签名字")
    @TableField("tag_name")
    private String tagName;

    /**
     * 根据 PO 创建 VO 对象
     * */
    public static BlogTagVo formBlogTagPo(BlogTagPo blogTagPo){
        return new Converter().convertToVo(blogTagPo);
    }

    private static class Converter implements IConverter<BlogTagPo,BlogTagVo>{

        @Override
        public BlogTagVo convertToVo(BlogTagPo blogTagPo) {
            BlogTagVo blogTagVo = new BlogTagVo();
            BeanUtils.copyProperties(blogTagPo,blogTagVo);
            return blogTagVo;
        }
    }
}
