package com.github.myself.controller.wechat;

import com.github.myself.common.ServerResponse;
import com.github.myself.entity.UserInfo;
import com.github.myself.service.IUserService;
import com.github.myself.vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MySelf on 2019/5/14.
 */
@RestController
@RequestMapping("/api/v1/user/")
public class WxUserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("get_token")
    public ServerResponse getToken(String code){
        if (StringUtils.isEmpty(code)){
            return ServerResponse.createByErrorMessage("参数为空，请重新传递");
        }
        return iUserService.getToken(code);
    }

    @PostMapping("verify")
    public ServerResponse verify(String token){
        if (StringUtils.isEmpty(token)){
            return ServerResponse.createByErrorMessage("token参数错误，请重新传递");
        }
        return iUserService.verifyToken(token);
    }

    @PostMapping("save_user_info")
    public ServerResponse saveUserInfo(String userid,String avatarUrl,String city,String country,Integer gender,String nickName,String province){
        if (userid.isEmpty()){
            return ServerResponse.createByErrorMessage("参数错误，请重新传递");
        }
        UserInfo userInfo = new UserInfo(Integer.parseInt(userid),avatarUrl,city,country,gender,nickName,province);
        return iUserService.saveUserInfo(userid,userInfo);
    }

    @GetMapping("get_user_message")
    public ServerResponse<UserMessageVo> getUserMessage(String id , String token_key, @RequestHeader("token")String token){
        if (id != null && token_key != null && token != null){
            if (iUserService.verifyTokenCache(token_key,token)){
                return iUserService.getUserMessage(id);
            }
        }
        return ServerResponse.createByErrorMessage("参数传递错误");
    }

}
