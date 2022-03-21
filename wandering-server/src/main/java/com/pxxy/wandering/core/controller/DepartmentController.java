package com.pxxy.wandering.core.controller;

import com.pxxy.wandering.core.entity.dto.DepartmentDto;
import com.pxxy.wandering.core.entity.dto.DepartmentTree;
import com.pxxy.wandering.core.entity.po.DepartmentPo;
import com.pxxy.wandering.core.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈金勇
 * @since 2022-03-21 11:02:47
 */
@RestController
@RequestMapping("/core/departmentPo")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getTime")
    public Date getTime(){
        return new Date();
    }

    @PostMapping("/create")
    public String createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentPo departmentPo = new DepartmentPo();
        departmentPo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        BeanUtils.copyProperties(departmentDto,departmentPo);
        if(departmentService.save(departmentPo)){
            return "创建部门成功";
        }else{
            return "创建部门失败";
        }
    }

}
