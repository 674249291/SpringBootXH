package com.xj.xs.controller;

import com.xj.xs.dto.DemoDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * demo
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value="/demo") 
public class HelloController {

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<DemoDto> findDemoDtos() {
        List<DemoDto> list = new ArrayList<DemoDto>();
        list.add(new DemoDto(1, "张三"));
        return list;
    }

    @ApiOperation(value="创建用户", notes="根据DemoDto对象创建用户")
    @ApiImplicitParam(name = "demoDto", value = "用户详细实体demo", required = true, dataType = "DemoDto")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String addDemoDto(@RequestBody DemoDto demoDto) {
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public DemoDto getDemoDto(@PathVariable Long id) {
        return new DemoDto(2, "李四");
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "DemoDto")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String updateDemoDto(@PathVariable Long id, @RequestBody DemoDto user) {
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteDemoDtoById(@PathVariable Long id) {
        return "success";
    }
    
}