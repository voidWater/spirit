package com.voidshell.BM.musicStudio.controller;

import com.voidshell.BM.musicStudio.dao.CxMapper;
import com.voidshell.BM.musicStudio.pojo.Cx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("ac")
@Controller
public class TemplateController {

    @Autowired
    CxMapper cxMapper;

    @RequestMapping("get")
    public String cx(Model model,String id){
        Cx cx = cxMapper.selectByPrimaryKey(Integer.valueOf(id));
        model.addAttribute("title",cx.getChildTitle());
        model.addAttribute("id",id);
        return "active.html";
    }
}
