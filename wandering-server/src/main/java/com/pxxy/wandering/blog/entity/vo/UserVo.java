package com.pxxy.wandering.blog.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.pxxy.wandering.blog.entity.po.UserPo;
import com.pxxy.wandering.blog.util.IConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@TableName("user")
@ApiModel(value = "UserVo对象", description = "")
public class UserVo {

    @ApiModelProperty("用户主键")
    @TableId("id")
    private String id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("用户状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 根据 PO 创建 VO 对象
     */
    public static UserVo formUserPo(UserPo userPo){
        return new Converter().convert(userPo);
    }

    private static class Converter implements IConverter<UserPo,UserVo> {

        @Override
        public UserVo convert(UserPo userPo) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userPo,userVo);
            return userVo;
        }
    }

}
