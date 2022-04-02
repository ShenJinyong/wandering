package com.pxxy.wandering.blog.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("blog")
@ApiModel(value = "BlogDto对象", description = "")
public class BlogDto {

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


}