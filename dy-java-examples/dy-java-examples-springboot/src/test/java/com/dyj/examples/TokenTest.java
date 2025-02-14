package com.dyj.examples;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;
import com.dyj.common.service.IAgentTokenService;
import com.dyj.web.DyWebClient;
import com.dyj.web.domain.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author danmo
 * @date 2024-04-12 10:11
 **/
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DyJavaExamplesApplication.class)
public class TokenTest {

    private final String openId = "_000PVg69T4BivjAuETIkxHls3cNlJs2CVXm";
    /**
     *  https://open.douyin.com/platform/oauth/connect?client_key=aw0nkq98bbkdvq7d&response_type=code&scope=user_info,trial.whitelist&redirect_uri=https://www.douyin.com
     *  授权连接获取code
     */

    /**
     * 获取access-token令牌
     */
    @Test
    public void accessToken() {
        String code = "b337e005809687127f4gjoql6fG6dsBDubUW";
        DyResult<AccessTokenVo> dyResult = DyWebClient.getInstance().accessToken(code);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 获取client-token令牌
     */
    @Test
    public void clientToken() {
        DyResult<ClientTokenVo> dyResult = DyWebClient.getInstance().clientToken();
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 刷新refresh-token令牌
     */
    @Test
    public void refreshToken() {
        DyResult<RefreshTokenVo> dyResult = DyWebClient.getInstance().refreshToken(openId);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

    /**
     * 刷新access-token令牌
     */
    @Test
    public void refreshAccessToken() {
        DyResult<RefreshAccessTokenVo> dyResult = DyWebClient.getInstance().refreshAccessToken(openId);
        System.out.println(JSONObject.toJSONString(dyResult));
    }

}
