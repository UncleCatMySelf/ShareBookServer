package com.github.myself.controller.wechat;

import com.github.myself.common.ServerResponse;
import com.github.myself.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
