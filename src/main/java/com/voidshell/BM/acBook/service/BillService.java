package com.voidshell.BM.acBook.service;

import com.voidshell.BM.acBook.dao.BillMapper;
import com.voidshell.BM.acBook.dao.BookMapper;
import com.voidshell.BM.acBook.pojo.Bill;
import com.voidshell.BM.acBook.pojo.BillExExample;
import com.voidshell.BM.acBook.pojo.BillExample;
import com.voidshell.BM.acBook.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BillService {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private BookService bookService;

    /**
     * 增加新的bill
     * @param bookId
     * @param bill
     * @param user
     * @return
     */
    public Bill addBill(String bookId,Bill bill,User user){
        if(user==null)return null;
        bill.setId(UUID.randomUUID().toString().replaceAll("-",""));
        bill.setBookId(bookId);
        bill.setCreatedBy(user.getId());
        bill.setCreatedTime(new Date());
        bill.setStatus(1);
        if(billMapper.insert(bill)==1){
            return bill;
        }
        return null;
    }

    /**
     * 逻辑删除bill
     * @param bill
     * @param user
     * @return
     */
    public Integer delBill(Bill bill,User user){
        if(user==null)return null;
        if(!bookService.checkUserAndBook(bill.getBookId(),user.getId())||!bookService.checkSubUserAndBook(bill.getBookId(),user.getId()))return null;
        bill.setStatus(-1);
        bill.setUpdatedBy(user.getId());
        bill.setUpdatedTime(new Date());
        return billMapper.updateByPrimaryKey(bill);
    }

    /**
     * 修改bill
     * @param bill
     * @param user
     * @return
     */
    public Integer updateBill(Bill bill,User user){
        if(user==null)return null;
        bill.setUpdatedBy(user.getId());
        bill.setUpdatedTime(new Date());
        return billMapper.updateByPrimaryKey(bill);
    }

    /**
     *
     * @param bookId
     * @param dateDur
     * @return
     */
    public List<Bill> allBillByBook(String bookId ,String dateDur){
        BillExample billExample = new BillExample();
        String[] dates = dateDur.split(",");
        billExample.createCriteria().andStatusEqualTo(1).andBookIdEqualTo(bookId).andCreatedByBetween(dates[0],dates[1]);
        return  billMapper.selectByExample(billExample);
    }
}
