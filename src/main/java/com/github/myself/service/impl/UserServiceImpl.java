package com.github.myself.service.impl;

import com.github.myself.common.ServerResponse;
import com.github.myself.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by MySelf on 2019/5/14.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public ServerResponse getToken(String code) {
        return null;
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
}
