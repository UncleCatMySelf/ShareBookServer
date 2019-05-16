package com.github.myself.service;

import com.github.myself.common.ServerResponse;
import com.github.myself.entity.UserInfo;
import com.github.myself.vo.UserMessageVo;

/**
 * Created by MySelf on 2019/5/14.
 */
public interface IUserService {

    ServerResponse getToken(String code);

    ServerResponse verifyToken(String token);

    ServerResponse saveUserInfo(String userid, UserInfo userInfo);

    ServerResponse<UserMessageVo> getUserMessage(String id);

    //ServerResponse getUserList(int pageNum, int pageSize);

    //ServerResponse getUserMessageList(int pageNum, int pageSize);

    //ServerResponse getUserHostoryList(Integer userId, int pageNum, int pageSize);

    boolean verifyTokenCache(String token_key, String token);

    //ServerResponse saveUserFault(String textarea, String check, String scene, String userid, CommonsMultipartFile faultImage);

    //ServerResponse getWxCode(String scene, String page);

    //ServerResponse<UserWalletVo> getUserWallet(String id);

    //ServerResponse<UserCardVo> getUserCardInfo(String id);

    //ServerResponse getUserFault(int pageNum, int pageSize);

    //ServerResponse getListCode(int pageNum, int pageSize);

    ServerResponse getUserHostry(Integer userId);

    //ServerResponse getHostryBook(Integer bookId, Integer hostryId);

    //ServerResponse addUserCommentsForBook(Integer hostryId, Integer score, String tArea);

    //ServerResponse backbook(String channelId, Integer userId);

    //boolean verifyHostry(String id);

    //ServerResponse getReviewLists(int pageNum, int pageSize);

    //ServerResponse reviewChangeTo(Integer id, String status);

    //ServerResponse reviewTo(String status, int pageNum, int pageSize);
}
