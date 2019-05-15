package com.github.myself.service.impl;

import com.github.myself.common.AppMessage;
import com.github.myself.common.HttpService;
import com.github.myself.common.ServerResponse;
import com.github.myself.common.TokenCache;
import com.github.myself.entity.User;
import com.github.myself.mapper.UserMapper;
import com.github.myself.service.IUserService;
import com.github.myself.utl.MD5Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by MySelf on 2019/5/14.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse getToken(String code) {
        String[] results = new String[2];
        JSONArray wxResult = null;
        String openid = null;
        String session_key = null;
        String wxLoginUrl = AppMessage.WXURL+"appid="+AppMessage.APPID+"&secret="+AppMessage.APPSECRET+"&js_code="+code+"&grant_type="+AppMessage.GRANTTYPE;
        String result = HttpService.sendGet(wxLoginUrl);
        if(StringUtils.isEmpty(result)){
            return ServerResponse.createByErrorMessage("获取session_key及openID时异常，微信内部错误");
        }else{
            wxResult = JSONArray.fromObject("["+result+"]");
            if(wxResult == null){
                return ServerResponse.createByErrorMessage("获取session_key及openID时异常，微信内部错误");
            }else{
                if(wxResult.size()>0){
                    for(int i = 0; i < wxResult.size(); i++){
                        JSONObject item = wxResult.getJSONObject(i);//遍历 jsonarray 数组，把每一个对象转成 json 对象
                        try{
                            Object errCode = item.get("errcode");
                        }catch (Exception e){
                            e.printStackTrace();
                            return ServerResponse.createByErrorMessage("请求失败返回ERRCODE");
                        }
                        session_key = (String)item.get("session_key");
                        System.out.println("session_key"+session_key);
                        openid =(String)item.get("openid");
                        if(openid != null){
                            break;
                        }
                    }
                }
            }
        }
        results=grantToken(openid,wxResult);
        JSONObject object = new JSONObject();
        object.put("token",results[0]);
        object.put("userid",results[1]);
        JSONArray tokenJSON = new JSONArray();
        tokenJSON.add(object);
        TokenCache.setKey("token_"+results[1],results[0]);
        //System.out.println(tokenJSON);
        return ServerResponse.createBySuccess(tokenJSON);
    }

    @Override
    public ServerResponse verifyToken(String token) {
        return null;
    }

    @Override
    public boolean verifyTokenCache(String token_key, String token) {
        return false;
    }

    @Override
    public ServerResponse getUserHostry(Integer userId) {
        return null;
    }

    /**
     * 创建Token
     * @param openid
     * @param wxResult
     * @return
     */
    private String[] grantToken(Object openid,JSONArray wxResult){
        String[] results = new String[2];
        //获取openid
        Integer userId = null;
        String wxOpenid = (String)openid;
        //数据库查看，是否存在openid，如果存在则不处理，如果不存在就新增一条用户数据
        User user = userMapper.selectByOpenId(wxOpenid);
        if ( user != null ){
            userId = user.getUserId();
        } else {
            User userNew = new User();
            userNew.setOpenid(wxOpenid);
            int effectedNum = userMapper.insert(userNew);
            if (effectedNum > 0){
                User newUser = userMapper.selectByOpenId(wxOpenid);
                userId = newUser.getUserId();
            }
        }
        //生成令牌准备缓存数，写入缓存
        JSONArray result = prepareCacheValue(wxResult,userId);
        String token = saveToCache(result,userId);
        //把令牌返回到客户端去 key:令牌、value：wxResult、uid、scope
        results[0] = token;
        results[1] = userId.toString();
        return results;
    }

    /**
     * 确定返回的登录信息
     * @param result
     * @param userId
     * @return
     */
    private JSONArray prepareCacheValue(JSONArray result,Integer userId){
        JSONObject object = new JSONObject();
        object.put("userid",userId);
        object.put("scope",AppMessage.SCOPE_USER);
        result.add(object);
        return result;
    }


    /**
     * 存入缓存信息
     * @param result
     * @param userId
     * @return
     */
    private String saveToCache(JSONArray result,Integer userId){
        Integer next = userId * AppMessage.SCOPE_USER;
        String strNext = next.toString();
        String key = UUID.randomUUID().toString() + MD5Util.MD5EncodeUtf8(strNext);
        String exprieIn = AppMessage.TOKEN_EXPIRE_IN.toString();
        String value = result.toString();
        TokenCache.setKey("key",key);
        TokenCache.setKey("exprie_in",exprieIn);
        TokenCache.setKey("value",value);
        return key;
    }
}
