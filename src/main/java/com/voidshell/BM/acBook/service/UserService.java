package com.voidshell.BM.acBook.service;

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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserReleMapper userReleMapper;

    @Autowired
    private BookMapper bookMapper;

    /**
     * 根据openid获取用户
     * @param openid
     * @return
     */
    public User getUserByOpenId(String openid){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andOpenIdEqualTo(openid);
        List<User> list = userMapper.selectByExample(userExample);
        if(list==null||list.size()!=1)return null;
        return list.get(0);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public User addUser(User user){
        if(user.getOpenId()==null)return null;
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        user.setCreatedBy("self");
        user.setCreatedTime(new Date());
        if(userMapper.insert(user)==1){
            return getUserByOpenId(user.getOpenId());
        }else{
            return null;
        }
    }

    /**
     * 增加账本参与人
     * @param bookId
     * @param userId
     * @param subUserId
     * @return
     */
    public Integer addSubUser(String bookId,String userId,String subUserId,String auth){
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(subUserId);
        List<UserRele> list = userReleMapper.selectByExample(userReleExample);
        if(list.size()>0){
            if(list.get(0).getStatus()==-1){
                list.get(0).setStatus(1);
                return userReleMapper.updateByPrimaryKey(list.get(0));
            }else{
                return 0;
            }
        }else{
            UserRele userRele = new UserRele();
            userRele.setId(UUID.randomUUID().toString().replaceAll("-",""));
            userRele.setUserId(subUserId);
            userRele.setBookId(bookId);
            userRele.setAuth(auth);

            userRele.setCreatedBy(userId);
            userRele.setCreatedTime(new Date());
            userRele.setStatus(1);
            return userReleMapper.insert(userRele);
        }
    }

    /**
     * 逻辑删除账本参与人
     * @param bookId
     * @param userId
     * @param subUserId
     * @return
     */
    public Integer delSubUser(String bookId,String userId,String subUserId){
        if(!bookService.checkUserAndBook(bookId,userId))return null;
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(subUserId);
        List<UserRele> list = userReleMapper.selectByExample(userReleExample);
        if(list.size() < 1)return null;
        list.get(0).setStatus(-1);
        return userReleMapper.updateByPrimaryKey(list.get(0));
    }

    /**
     * 修改账本参与人权限
     * @param bookId
     * @param userId
     * @param subUserId
     * @param auth
     * @return
     */
    public Integer changeSubUserAuth( String bookId,String userId,String subUserId,String auth){
        if(!bookService.checkUserAndBook(bookId,userId))return null;
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andBookIdEqualTo(bookId).andUserIdEqualTo(userId).andStatusEqualTo(1);
        List<UserRele> list = userReleMapper.selectByExample(userReleExample);
        if(list.size()==1){
            list.get(0).setAuth(auth);
            return userReleMapper.updateByPrimaryKey(list.get(0));
        }
        return 0;
    }

    /**
     * 获取账本所有参与用户
     * @param bookId
     * @return
     */
    public List<User> getAllSubUser(String bookId){
        List<User> userList = new ArrayList<>();
        //账户管理人
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if(book==null)return null;
        User pr_user = userMapper.selectByPrimaryKey(book.getWxUserIdPr());
        if(pr_user==null)return null;
        userList.add(pr_user);
        //参与人
        UserReleExample userReleExample = new UserReleExample();
        userReleExample.createCriteria().andBookIdEqualTo(bookId).andStatusEqualTo(1);
        List<UserRele> releList = userReleMapper.selectByExample(userReleExample);
        releList.forEach(r->{
            User u = userMapper.selectByPrimaryKey(r.getUserId());
            if(u!=null){
                userList.add(u);
            }
        });
        return userList;
    }
}
