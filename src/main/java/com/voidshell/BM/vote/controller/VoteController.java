package com.voidshell.BM.vote.controller;

import com.voidshell.BM.vote.pojo.WxVote;
import com.voidshell.BM.vote.pojo.WxVoteItem;
import com.voidshell.BM.vote.service.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vote")
@Api(tags="投票")
public class VoteController {

    public String openId = "23423424sdsasfdsad234214sdfsafasf";

    @Autowired
    private VoteService voteService;

    @PostMapping("create")
    @ApiOperation(value="创建投票",notes="创建投票")
    public String createVote(WxVote vote){
        System.out.println(vote.getTitle());
        return voteService.saveVote(openId,vote);
    }

    @GetMapping("get")
    @ApiOperation(value="获取投票",notes="根据vote的id获取投票")
    public WxVote getVoteById(String id){
        WxVote wxVote = voteService.getVoteById(id);
        return wxVote;
    }

    @GetMapping("getItem")
    @ApiOperation(value="获取投票",notes="根据vote的id获取投票")
    public List<WxVoteItem> getVoteItemById(String id){

        return voteService.getVoteItemByVoteId(id);
    }

    @GetMapping("getList")
    @ApiOperation(value="获取投票列表",notes="根据openid获取投票")
    public List<WxVote> getVoteListByOpenId(String openId){

        return voteService.getVoteByOpenId(openId);
    }

}
