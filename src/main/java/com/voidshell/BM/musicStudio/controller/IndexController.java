package com.voidshell.BM.musicStudio.controller;


import com.voidshell.BM.musicStudio.dao.CxMapper;
import com.voidshell.BM.musicStudio.pojo.Cx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("musicStudio")
@Api(tags="简乐工作室")
public class IndexController {

    @Autowired
    CxMapper cxMapper;

    @PostMapping("save")
    @ResponseBody
    @ApiOperation(value="保存",notes="保存数据")
    public String save(@RequestBody Cx cx){
        if(cx.getId()!=null){
            return cxMapper.updateByPrimaryKey(cx)+"";
        }
        cxMapper.insert(cx);
        return cxMapper.insert(cx)+"";
    }

    @GetMapping("get")
    @ResponseBody
    @ApiOperation(value="获取当前活动",notes="获取当前活动")
    public Cx getById(String id){
        return cxMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @DeleteMapping("del")
    @ResponseBody
    @ApiOperation(value="删除",notes="删除活动")
    public String delById(String id){
        return cxMapper.deleteByPrimaryKey(Integer.valueOf(id))+"";
    }

    @GetMapping("all")
    @ResponseBody
    @ApiOperation(value="获取列表",notes="获取列表")
    public List<Cx> all(){
        return cxMapper.selectByExample(null);
    }
}
