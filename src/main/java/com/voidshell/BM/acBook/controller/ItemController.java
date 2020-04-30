package com.voidshell.BM.acBook.controller;

import com.voidshell.BM.acBook.Const;
import com.voidshell.BM.acBook.HttpResult;
import com.voidshell.BM.acBook.pojo.Item;
import com.voidshell.BM.acBook.pojo.User;
import com.voidshell.BM.acBook.service.BookService;
import com.voidshell.BM.acBook.service.ItemService;
import com.voidshell.common.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController{

    @Autowired
    private ItemService itemService;
    @Autowired
    private BookService bookService;

    @RequestMapping("add")
    public HttpResult addItem(Item item, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(StringUtils.isBlank(item.getBookId())) return HttpResult.error(Const.ResponseErrorCode.ILLEGAL_ARGUMENT,"bookId 为空");
        if(!bookService.checkUserAndBook(item.getBookId(),user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");

        if(StringUtils.isNotBlank(item.getItemName())){
            item.setItemName(item.getItemName().trim());
        }else{
            return HttpResult.error(Const.ResponseErrorCode.ILLEGAL_ARGUMENT,"item name为空");
        }
        if(itemService.addItem(item,user)==1){
            return HttpResult.success();
        }else{
            return HttpResult.error();
        }
    }
    @RequestMapping("del")
    public HttpResult delItem(String itemId,String bookId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(itemService.delItem(itemId)==1){
            return HttpResult.success();
        }else{
            return HttpResult.error();
        }
    }
    @RequestMapping("update")
    public HttpResult updateItem(Item item,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(item.getBookId(),user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(itemService.updateItem(item,user)==1){
            return HttpResult.success();
        }else{
            return HttpResult.error();
        }
    }
    @RequestMapping("query")
    public HttpResult queryItem(String bookId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        List<Item> list = itemService.selectItem(bookId,null);
        if(list==null)return HttpResult.error();
        return HttpResult.error(""+list.size(),list);
    }
}
