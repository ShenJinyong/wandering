package com.pxxy.wandering.blog.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.util.Date;

import com.pxxy.wandering.blog.entity.dto.BlogDto;
import com.pxxy.wandering.blog.util.IConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * 
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-30 03:49:28
 */
@Getter
@Setter
@TableName("blog")
@ApiModel(value = "BlogPo对象", description = "")
public class BlogPo {

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

    @ApiModelProperty("乐观锁")
    @TableField("version")
    @Version
    private Integer version;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 根据 Dto 创建 Po 对象
     * */
    public static BlogPo formBogDto(BlogDto blogDto){
        return new Converter().convert(blogDto);
    }

    private static class  Converter implements IConverter<BlogDto,BlogPo> {

        @Override
        public BlogPo convert(BlogDto blogDto) {
            BlogPo blogPo = new BlogPo();
            BeanUtils.copyProperties(blogDto,blogPo);
            blogPo.setUserId("1509806809358680065");
            return blogPo;
        }
    }

}
