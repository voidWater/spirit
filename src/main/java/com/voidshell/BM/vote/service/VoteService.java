package com.voidshell.BM.vote.service;

import com.voidshell.BM.vote.dao.WxHistoryVoteMapper;
import com.voidshell.BM.vote.dao.WxVoteItemMapper;
import com.voidshell.BM.vote.dao.WxVoteMapper;
import com.voidshell.BM.vote.dao.WxVotingMapper;
import com.voidshell.BM.vote.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VoteService {

    @Autowired
    private WxVoteMapper voteMapper;
    @Autowired
    private WxVoteItemMapper voteItemMapper;
    @Autowired
    private WxVotingMapper votingMapper;
    @Autowired
    private WxHistoryVoteMapper wxHistoryVoteMapper;

    /**
     * 保存vote
     * @param openId
     * @param vote
     * @return
     */
    public String saveVote(String openId,WxVote vote){
        vote.setOpenid(openId);
        vote.setId(UUID.randomUUID().toString());
        vote.setCreatedate(new Date());
        int flag = voteMapper.insert(vote);
        if(flag==1){
            for (int i = 0;i<vote.getList().length;i++){
                WxVoteItem item = new WxVoteItem();
                item.setId(UUID.randomUUID().toString());
                item.setVoteId(vote.getId());
                item.setVoteItem(vote.getList()[i]);
                voteItemMapper.insert(item);
            }
            return voteMapper.selectByPrimaryKey(vote.getId()).getId();
        }else{
            return "0";
        }
    }

    /**
     * 根据id获取vote
     * @param id
     * @return
     */
    public WxVote getVoteById(String id){
        WxVote vote = new WxVote();
        vote.setId(id);
        System.out.println(id);
        return voteMapper.selectByPrimaryKey(vote.getId());
    }

    /**
     * 根据voteId获取item
     * @param id
     * @return
     */
    public List<WxVoteItem> getVoteItemByVoteId(String id){
        WxVoteItemExample wxVoteItemExample = new WxVoteItemExample();
        wxVoteItemExample.createCriteria().andVoteIdEqualTo(id);
        return voteItemMapper.selectByExample(wxVoteItemExample);
    }

    /**
     * 获取我发起的
     * @param openId
     * @return
     */
    public List<WxVote> getVoteByOpenId(String openId){
        WxVoteExample voteExample = new WxVoteExample();
        voteExample.createCriteria().andOpenidEqualTo(openId);
        List<WxVote> list = voteMapper.selectByExample(voteExample);
        return list;
    }

    /**
     * 获取我参与的
     * @param openId
     * @return
     */
    public List<WxHistoryVote> getVoteByOpenId2(String openId){
        WxHistoryVoteExample historyVoteExample = new WxHistoryVoteExample();
        historyVoteExample.createCriteria().andOpenidEqualTo(openId);
        List<WxHistoryVote> list = wxHistoryVoteMapper.selectByExample(historyVoteExample);
        return list;
    }

    /**
     * 投票
     * @param voteId
     * @param openId
     * @param voteItemId
     * @return
     */
    public int voting(String voteId,String openId,String voteItemId){
        WxVoting voting = new WxVoting();
        voting.setId(UUID.randomUUID().toString());
        voting.setOpenid(openId);
        voting.setVoteId(voteId);
        voting.setVoteItemId(voteItemId);
        voting.setVotedate(new Date());
        if(votingMapper.insert(voting)==1){
            WxVote vote = new WxVote();
            vote.setId(voteId);
            WxVote wxVote= voteMapper.selectByPrimaryKey(vote.getId());
            WxHistoryVote historyVote = new WxHistoryVote();
            historyVote.setId(UUID.randomUUID().toString());
            historyVote.setTitle(vote.getTitle());
            historyVote.setDes(vote.getDes());
            historyVote.setOpenid(openId);
            historyVote.setVoteId(voteId);
            return wxHistoryVoteMapper.insert(historyVote);
        }else{
            return 0;
        }
    }
}
