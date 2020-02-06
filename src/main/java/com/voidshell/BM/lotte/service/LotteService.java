package com.voidshell.BM.lotte.service;

import com.voidshell.BM.lotte.dao.WxLotteItemMapper;
import com.voidshell.BM.lotte.dao.WxLotteMapper;
import com.voidshell.BM.lotte.dao.WxLuckParticMapper;
import com.voidshell.BM.lotte.dao.WxParticipantMapper;
import com.voidshell.BM.lotte.pojo.*;
import com.voidshell.common.utils.CharEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotteService {

    @Autowired
    WxLotteMapper wxLotteMapper;

    @Autowired
    WxLotteItemMapper wxLotteItemMapper;

    @Autowired
    WxParticipantMapper wxParticipantMapper;

    @Autowired
    WxLuckParticMapper wxLuckParticMapper;

    /**
     * 创建抽奖
     * @param wxLotte
     * @return
     */
    public int createLotte(WxLotte wxLotte){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        wxLotte.setId(id);
        wxLotte.setCreatetime(new Date());
        wxLotte.setUpdatetime(new Date());

        String code = createCode();
        WxLotteExample wxLotteExample = new WxLotteExample();
        WxLotteExample.Criteria c = wxLotteExample.createCriteria();
        c.andCodeEqualTo(code);
        while(wxLotteMapper.selectByExample(wxLotteExample).size()>0){
            code = createCode();
            c.andCodeEqualTo(code);
        }
        wxLotte.setCode(code);
        wxLotte.setStatus(1);
        if( wxLotteMapper.insert(wxLotte)==1){
            List<WxLotteItem> list = wxLotte.getList();
            for(int i = 0;i<list.size();i++){
                list.get(i).setId(UUID.randomUUID().toString().replaceAll("-",""));
                list.get(i).setLotteid(id);
                list.get(i).setCreatetime(new Date());
                list.get(i).setUpdatetime(new Date());
                wxLotteItemMapper.insert(list.get(i));
            }
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 获取参与人
     * @param id
     * @return
     */
    public List<WxParticipant> getP(String id) {
        WxParticipantExample wxParticipantExample = new WxParticipantExample();
        wxParticipantExample.createCriteria().andLotteidEqualTo(id);
        List<WxParticipant> list= wxParticipantMapper.selectByExample(wxParticipantExample);
        list.forEach(l->{
            l.setNikname(CharEncode.base64Decode(l.getNikname()));
        });
        return list;
    }
    /**
     * 修改抽奖
     * @param wxLotte
     * @return
     */
    public int updateLotte(WxLotte wxLotte) {
        wxLotte.setUpdatetime(new Date());
        if(wxLotteMapper.updateByPrimaryKey(wxLotte)==1){
            List<WxLotteItem> list = wxLotte.getList();
            for(int i = 0;i<list.size();i++){
                System.out.println(list.get(i).getId());
                if(list.get(i).getId()!=null&&!list.get(i).getId().equals("")){
                    list.get(i).setUpdatetime(new Date());
                    wxLotteItemMapper.updateByPrimaryKey(list.get(i));
                }else{
                    list.get(i).setId(UUID.randomUUID().toString().replaceAll("-",""));
                    list.get(i).setLotteid(wxLotte.getId());
                    list.get(i).setCreatetime(new Date());
                    list.get(i).setUpdatetime(new Date());
                    wxLotteItemMapper.insert(list.get(i));
                }
            }
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 获取抽奖码
     * @param lotteId
     * @return
     */
    public String getCode(String lotteId) {
        WxLotte wxLotte = wxLotteMapper.selectByPrimaryKey(lotteId);
        if(wxLotte.getStatus()==0){
            return "已无法加入";
        }
        return wxLotte.getCode();
    }

    /**
     * 加入抽奖
     * @param openId
     * @param nickName
     * @param avaUrl
     * @param code
     * @return
     */
    public String join(String openId,String nickName,String avaUrl,String code){
        WxLotteExample wxLotteExample = new WxLotteExample();
        wxLotteExample.createCriteria().andCodeEqualTo(code)
                .andStatusEqualTo(1);
        List<WxLotte> list= wxLotteMapper.selectByExample(wxLotteExample);
        if(list.size()==1){
            WxParticipantExample wxParticipantExample = new WxParticipantExample();
            wxParticipantExample.createCriteria().andOpenidEqualTo(openId)
                    .andLotteidEqualTo(list.get(0).getId());
            List<WxParticipant> list2 = wxParticipantMapper.selectByExample(wxParticipantExample);
            if(list2.size()==1){
                return list.get(0).getId();
            }

            WxParticipant wxParticipant = new WxParticipant();
            wxParticipant.setId(UUID.randomUUID().toString());
            wxParticipant.setOpenid(openId);
            wxParticipant.setLotteid(list.get(0).getId());
            wxParticipant.setNikname(CharEncode.base64Encode(nickName));
            wxParticipant.setAvaurl(avaUrl);
            if(wxParticipantMapper.insert(wxParticipant)==1){
                return list.get(0).getId();
            }
            return null;
        }
        return null;
    }

    /**
     * 操作
     * @param openId
     * @param lotteId
     * @param type
     * @param status
     * @return
     */
    public String operateLotte(String openId,String lotteId,String lotteItemId,String type,int status){

        System.out.println(openId);
        System.out.println(lotteId);
        System.out.println(lotteItemId);
        System.out.println(type);
        System.out.println(status);
        WxLotte wxLotte = wxLotteMapper.selectByPrimaryKey(lotteId);
        if(!wxLotte.getOpenid().equals(openId)){
            return "error";
        }
        if(type.equals("open")){
            wxLotte.setStatus(2);
            return wxLotteMapper.updateByPrimaryKey(wxLotte)+"";
        }
        if(type.equals("openItem")){
            WxLotteItem wxLotteItem = wxLotteItemMapper.selectByPrimaryKey(lotteItemId);
            if(wxLotteItem.getLotteid().equals(wxLotte.getId())){

                WxParticipantExample wxParticipantExample = new WxParticipantExample();
                wxParticipantExample.createCriteria().andLotteidEqualTo(wxLotte.getId());
                List<WxParticipant> list = wxParticipantMapper.selectByExample(wxParticipantExample);

                Set set = getLuckNum(wxLotteItem.getNum(),list.size());
                set.forEach(s->{
                    WxParticipant wxParticipant = list.get((int)s);
                    WxLuckPartic wxLuckPartic = new WxLuckPartic();
                    wxLuckPartic.setId(UUID.randomUUID().toString().replaceAll("-",""));
                    wxLuckPartic.setLotteid(wxLotte.getId());
                    wxLuckPartic.setItemname(wxLotteItem.getName());
                    wxLuckPartic.setParticid(wxParticipant.getId());
                    wxLuckPartic.setName(wxParticipant.getNikname());
                    wxLuckPartic.setLotteitemid(wxLotteItem.getId());
                    wxLuckParticMapper.insert(wxLuckPartic);
//                    wxParticipant.setLotteitemid(wxLotteItem.getId()+","+"&,"+wxParticipant.getLotteitemid());
//                    wxParticipantMapper.updateByPrimaryKeySelective(wxParticipant);
                });
                wxLotteItem.setStatus(3);
                wxLotteItemMapper.updateByPrimaryKey(wxLotteItem);
                return "success";
            }else{
                return "error";
            }
        }
        return "error";
    }

    /**
     * 获取我发起的
     * @param openId
     * @return
     */
    public List<WxLotte> selectByOpenId(String openId) {
        WxLotteExample wxItemExample = new WxLotteExample();
        wxItemExample.createCriteria().andOpenidEqualTo(openId);
        return wxLotteMapper.selectByExample(wxItemExample);
    }

    /**
     * 获取我加入的
     * @param openId
     * @return
     */
    public List<WxLotte> selectJoinByOpenId(String openId) {
        WxParticipantExample wxParticipantExample = new WxParticipantExample();
        wxParticipantExample.createCriteria().andOpenidEqualTo(openId);
        List<WxParticipant> list = wxParticipantMapper.selectByExample(wxParticipantExample);
        List<WxLotte> result = new ArrayList<>();
        list.forEach(l->{
            WxLotte wxLotte = wxLotteMapper.selectByPrimaryKey(l.getLotteid());
            if(wxLotte!=null){
                result.add(wxLotte);
            }
        });
        return result;
    }

    /**
     * 获取抽奖
     * @param id
     * @return
     */
    public WxLotte getLotteById(String id) {
        WxLotte wxLotte = wxLotteMapper.selectByPrimaryKey(id);
        if(wxLotte!=null){
            WxLotteItemExample wxLotteItemExample = new WxLotteItemExample();
            wxLotteItemExample.createCriteria().andLotteidEqualTo(wxLotte.getId());
            wxLotte.setList(wxLotteItemMapper.selectByExample(wxLotteItemExample));
            return wxLotte;
        }else{
            return null;
        }
    }

    /**
     * 获取获奖者
     * @param lotteId
     * @param lotteItemId
     * @return
     */
    public List<WxParticipant> getLuckPar(String lotteId, String lotteItemId) {
        WxLuckParticExample wxLuckParticExample = new WxLuckParticExample();
        wxLuckParticExample.createCriteria().andLotteidEqualTo(lotteId).andLotteitemidEqualTo(lotteItemId);
        List<WxLuckPartic>  lList= wxLuckParticMapper.selectByExample(wxLuckParticExample);
        List<WxParticipant> result = new ArrayList<>();
        lList.forEach(l->{
            WxParticipant wp= wxParticipantMapper.selectByPrimaryKey(l.getParticid());
            wp.setNikname(CharEncode.base64Decode(wp.getNikname()));
            result.add(wp);
        });
        return result;
    }

    public String delLotte(String id) {
        return wxLotteMapper.deleteByPrimaryKey(id)+"";
    }

    public String delLotteItem(String id) {
        return wxLotteItemMapper.deleteByPrimaryKey(id)+"";
    }



    /**
     * 生成6位随机数
     * @return
     */
    public String createCode(){
        String code = "0";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            code += r.nextInt(9)+""; // 生成[0,9]区间的整数
            System.out.print(code);
        }
        return code.toString();
    }

    /**
     * 获取幸运数字
     * @param num
     * @param limit
     * @return
     */
    public Set getLuckNum(int num , int limit){
        Random r = new Random();
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet<Integer>();

        while(set.size()<num){
            set.add(r.nextInt(limit-1));
        }
        return set;
    }


}
