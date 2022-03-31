package com.pxxy.wandering.blog.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("blog_tag")
@ApiModel(value = "BlogTagDto对象", description = "")
public class BlogTagDto {

    @ApiModelProperty("标签主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("标签名字")
    @TableField("tag_name")
    private String tagName;

}
