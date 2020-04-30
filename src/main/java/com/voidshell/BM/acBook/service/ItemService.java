package com.voidshell.BM.acBook.service;

import com.voidshell.BM.acBook.dao.ItemMapper;
import com.voidshell.BM.acBook.pojo.Item;
import com.voidshell.BM.acBook.pojo.ItemExample;
import com.voidshell.BM.acBook.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private BookService bookService;

    /**
     * 增加选项
     * @param item
     * @param user
     * @return
     */
    public Integer addItem(Item item, User user){
        item.setId(UUID.randomUUID().toString().replaceAll("-",""));
        item.setUpdatedTime(new Date());
        item.setCreatedTime(new Date());
        item.setCreatedBy(user.getId());
        item.setStatus(1);
        if(item.getInOrEx()==null)item.setInOrEx(0);
        return itemMapper.insert(item);
    }

    /**
     * 逻辑删除选项
     * @param itemId
     * @return
     */
    public Integer delItem(String itemId){
        Item item = itemMapper.selectByPrimaryKey(itemId);
        if(item==null)return 1;
        item.setStatus(-1);
        return itemMapper.updateByPrimaryKey(item);
    }

    /**
     * 更新选项
     * @param item
     * @return
     */
    public Integer updateItem(Item item,User user){
        item.setUpdatedTime(new Date());
        item.setUpdatedBy(user.getId());
        return itemMapper.updateByPrimaryKeySelective(item);
    }

    /**
     * 获取该账本所有选项
     * @param bookId
     * @param inOrEx
     * @return
     */
    public List<Item> selectItem(String bookId,Integer inOrEx){
        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andBookIdEqualTo(bookId).andStatusEqualTo(1);
        return itemMapper.selectByExample(itemExample);
    }


}
