package com.voidshell.BM.acBook.service;

import com.voidshell.BM.acBook.dao.BillMapper;
import com.voidshell.BM.acBook.dao.BookMapper;
import com.voidshell.BM.acBook.dao.UserMapper;
import com.voidshell.BM.acBook.dao.UserReleMapper;
import com.voidshell.BM.acBook.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserReleMapper userReleMapper;

    /**
     * 新增账本
     * @param book
     * @param user
     * @return
     */
    public Book addBook(Book book,User user){
        if(book==null||user==null)return null;
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andWxUserIdPrEqualTo(user.getId()).andBookNameEqualTo(book.getBookName().trim());
        List<Book> list =  bookMapper.selectByExample(bookExample);
        if(list.size()>0)return null;
        book.setId(UUID.randomUUID().toString().replaceAll("-",""));
        book.setBookName(book.getBookName().trim());
        book.setCreatedBy(user.getId());
        book.setCreatedTime(new Date());
        book.setWxUserIdPr(user.getId());
        book.setStatus(1);
        if(bookMapper.insert(book)==1){
            return book;
        }else{
            return null;
        }
    }

    /**
     * 逻辑删除账本
     * @param bookId
     * @param user
     * @return
     */
    public Integer delBook(String bookId,User user){
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if(book==null)return null;
        book.setStatus(-1);
        book.setUpdatedBy(user.getId());
        book.setUpdatedTime(new Date());
        return bookMapper.updateByPrimaryKey(book);
    }

    /**
     * 修改账本信息
     * @param book
     * @param user
     * @return
     */
    public Integer updateBook(Book book,User user){

        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andWxUserIdPrEqualTo(user.getId()).andBookNameEqualTo(book.getBookName().trim());
        List<Book> list =  bookMapper.selectByExample(bookExample);
        if(list.size()<1)return null;
        book.setUpdatedBy(user.getId());
        book.setUpdatedTime(new Date());
        return bookMapper.updateByPrimaryKey(book);
    }

    /**
     * 获取该用户所有账本
     * @param user
     * @return
     */
    public List<Book> selectBook(User user){
        if(user == null)return null;
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andWxUserIdPrEqualTo(user.getId()).andStatusEqualTo(1);
        return bookMapper.selectByExample(bookExample);
    }

    /**
     * 获取所有参与账本
     * @param user
     * @return
     */
    public List<Book> selectBookBySubUser(User user){
        if(user==null)return null;
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andStatusEqualTo(1).andUserIdEqualTo(user.getId());
        List<UserRele> releList = userReleMapper.selectByExample(userReleExample);
        List<Book> bookList = new ArrayList<>();
        releList.forEach(r->{
            Book book= bookMapper.selectByPrimaryKey(r.getBookId());
            if(book!=null&&book.getStatus()==1){
                bookList.add(book);
            }
        });
        return bookList;
    }

    /**
     * 判断该账本是否属于该用户
     * @param bookId
     * @param userId
     * @return
     */
    public boolean checkUserAndBook(String bookId,String userId){
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if(book.getWxUserIdPr().equals(userId))return true;
        return false;
    }

    /**
     * 判断是否是该账本的参与用户
     * @param bookId
     * @param userId
     * @return
     */
    public boolean checkSubUserAndBook(String bookId,String userId){
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andStatusEqualTo(1).andBookIdEqualTo(bookId);
        List<UserRele> list = userReleMapper.selectByExample(userReleExample);
        if(list.size()<1)return false;
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getUserId().equals(userId)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取账本基本信息
     * @param bookId
     * @return
     */
    public Book getBook(String bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }
}
