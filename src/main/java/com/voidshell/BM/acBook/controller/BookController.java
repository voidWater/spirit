package com.voidshell.BM.acBook.controller;

import com.voidshell.BM.acBook.Const;
import com.voidshell.BM.acBook.HttpResult;
import com.voidshell.BM.acBook.pojo.Book;
import com.voidshell.BM.acBook.pojo.Item;
import com.voidshell.BM.acBook.pojo.User;
import com.voidshell.BM.acBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("add")
    public HttpResult addItem(Book book, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        book = bookService.addBook(book,user);
        if(book==null)return HttpResult.error();
        return HttpResult.success("新增成功",book);
    }

    @RequestMapping("del")
    public HttpResult delBook(String bookId, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(!bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(bookService.delBook(bookId,user)==1){
            return HttpResult.success();
        }else{
            return HttpResult.error();
        }
    }

    @RequestMapping("update")
    public HttpResult updateBook(Book book, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(bookService.checkUserAndBook(book.getId(),user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        if(bookService.updateBook(book,user)==1){
            return HttpResult.success();
        }else{
            return HttpResult.error();
        }
    }

    @RequestMapping("queryByUser")
    public HttpResult queryByUser(Book book, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        List<Book> result = new ArrayList<>();
        List<Book> list = bookService.selectBook(user);
        List<Book> sublist = bookService.selectBookBySubUser(user);
        result.addAll(list);
        result.addAll(sublist);
        if(result==null){
            return HttpResult.error();
        }else{
            return HttpResult.success(""+result.size(),result);
        }
    }

    @RequestMapping("getBook")
    public HttpResult getBook(String bookId, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(bookService.checkUserAndBook(bookId,user.getId()))return HttpResult.error(Const.ResponseErrorCode.NO_PERMISSION,"没有该book权限");
        Book book = bookService.getBook(bookId);
        if(book==null)return HttpResult.error();
        return HttpResult.success("获取成功",book);
    }


}
