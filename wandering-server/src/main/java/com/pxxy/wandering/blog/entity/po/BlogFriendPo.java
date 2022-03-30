package com.pxxy.wandering.blog.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-30 03:49:29
 */
@Getter
@Setter
@TableName("blog_friend")
@ApiModel(value = "BlogFriendPo对象", description = "")
public class BlogFriendPo {

    @ApiModelProperty("友链主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("友链昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("友链描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("友链站点")
    @TableField("website")
    private String website;

    @ApiModelProperty("友链头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("友链状态")
    @TableField("status")
    private String status;

    @ApiModelProperty("点击次数")
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


}
