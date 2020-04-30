package com.voidshell.BM.acBook.controller;

import com.voidshell.BM.acBook.Const;
import com.voidshell.BM.acBook.HttpResult;
import com.voidshell.BM.acBook.pojo.Bill;
import com.voidshell.BM.acBook.pojo.User;
import com.voidshell.BM.acBook.service.BillService;
import com.voidshell.BM.acBook.service.BookService;
import com.voidshell.common.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController extends BaseController{

    @Autowired
    private BillService billService;
    @Autowired
    private BookService bookService;

    @PostMapping("add")
    public HttpResult addBill(String bookId, Bill bill, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId())||!bookService.checkSubUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        Bill bill1 = billService.addBill(bookId,bill,user);
        if(bill1==null){
            return HttpResult.error();
        }else{
            return HttpResult.success("新增成功",bill);
        }
    }
    @PostMapping("update")
    public HttpResult updateBill(Bill bill, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bill.getBookId(),user.getId())||!bookService.checkSubUserAndBook(bill.getBookId(),user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(billService.updateBill(bill,user)==1){
            return  HttpResult.success();
        }
        return HttpResult.error();
    }
    @GetMapping("del")
    public HttpResult delBill(Bill bill, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bill.getBookId(),user.getId())||!bookService.checkSubUserAndBook(bill.getBookId(),user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(billService.delBill(bill,user)==1){
            return  HttpResult.success();
        }
        return HttpResult.error();
    }
    @GetMapping("del")
    public HttpResult queryBill(String bookId ,String dateDur,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId())||!bookService.checkSubUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        List<Bill> list = billService.allBillByBook( bookId , dateDur);
        if(list==null){
            return HttpResult.error();
        }else{
            return HttpResult.success();
        }
    }
}
