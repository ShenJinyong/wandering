package com.pxxy.wandering.core.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "DepartmentDto对象",description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @ApiModelProperty("父部门id")
    @TableField("pid")
    private String pid;

    @ApiModelProperty("部门名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("部门昵称")
    @TableField("nick_name")
    private String nickName;

}
