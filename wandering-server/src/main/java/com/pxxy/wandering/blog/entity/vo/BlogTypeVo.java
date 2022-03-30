package com.pxxy.wandering.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pxxy.wandering.blog.entity.po.BlogTypePo;
import com.pxxy.wandering.blog.util.IConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog_type")
@Builder
@ApiModel(value = "BlogTypeVo对象", description = "博客类型")
public class BlogTypeVo {

    @ApiModelProperty("类型主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("类型名称")
    @TableField("type_name")
    private String typeName;

    /**
     * 根据 PO 创建 VO 对象
     * */
    public static BlogTypeVo formBlogTypePo(BlogTypePo blogTypePo){
        return new Converter().convertToVO(blogTypePo);
    }

    private static class Converter implements IConverter<BlogTypePo,BlogTypeVo>{

        @Override
        public BlogTypeVo convertToVO(BlogTypePo blogTypePo) {
            final BlogTypeVo blogTypeVo = new BlogTypeVo();
            BeanUtils.copyProperties(blogTypePo,blogTypeVo);
            return blogTypeVo;
        }
    }

}
