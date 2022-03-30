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
@TableName("blog_type")
@ApiModel(value = "BlogTypeDto对象", description = "博客类型")
public class BlogTypeDto {

    @ApiModelProperty("类型主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("类型名称")
    @TableField("type_name")
    private String typeName;

}
