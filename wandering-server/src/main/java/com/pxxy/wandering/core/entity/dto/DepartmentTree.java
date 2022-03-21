package com.pxxy.wandering.core.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "DepartmentTree对象",description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentTree {

    @ApiModelProperty("部门主键")
    private String id;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("父部门id")
    private String pid;

    @ApiModelProperty("子部门")
    private List<DepartmentTree> childTree;
}
