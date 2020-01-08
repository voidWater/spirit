package com.voidshell.BM.lotte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class LotteHtmlController {

    @RequestMapping("soc")
    public String web(){
        return "websocket.html";
    }
}
