package com.pxxy.wandering.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.pxxy.wandering.blog.entity.po.BlogPo;
import com.pxxy.wandering.blog.entity.po.UserPo;
import com.pxxy.wandering.blog.util.IConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@TableName("blog")
@ApiModel(value = "BlogVo对象", description = "")
public class BlogVo {

    @ApiModelProperty("博客主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("博客标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("博客首图")
    @TableField("firstPicture")
    private String firstPicture;

    @ApiModelProperty("博客摘要")
    @TableField("description")
    private String description;

    @ApiModelProperty("博客内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("博客状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("博客分类id")
    @TableField("type_id")
    private String typeId;

    @ApiModelProperty("博客标签id")
    @TableField("tag_id")
    private String tagId;

    @ApiModelProperty("博客作者id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("浏览次数")
    @TableField("views")
    private Integer views;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 根据 PO 创建 VO 对象
     */
    public static BlogVo formBlogPo(BlogPo blogPo){
        return new Converter().convert(blogPo);
    }

    private static class Converter implements IConverter<BlogPo,BlogVo> {

        @Override
        public BlogVo convert(BlogPo blogPo) {
            BlogVo blogVo = new BlogVo();
            BeanUtils.copyProperties(blogPo,blogVo);
            return blogVo;
        }
    }

}
