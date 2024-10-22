package com.dyj.web.client;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.backend.ContentType;
import com.dyj.common.domain.DyResult;
import com.dyj.web.domain.query.BaseQuery;
import com.dyj.web.domain.vo.BaseVo;
import com.dyj.web.domain.vo.TicketVo;
import com.dyj.web.domain.vo.MicAppDevtoolLegalVo;
import com.dyj.web.interceptor.ClientTokenInterceptor;

/**
 * @author danmo
 * @date 2024-04-11 17:29
 **/
@BaseRequest(baseURL = "${domain}", contentType = ContentType.APPLICATION_JSON)
public interface ToolsClient {

    /**
     * 小程序接口能力
     * @param query 基本信息
     * @param micAppId 小程序id
     * @return DyResult<MicAppDevtoolLegalVo>
     */
    @Get(value = "${micAppDevtoolLegal}", interceptor = ClientTokenInterceptor.class)
    DyResult<MicAppDevtoolLegalVo> micAppDevtoolLegal(@Var("query") BaseQuery query, @Query("micapp_id") String micAppId);

    /**
     *模拟webhook事件
     */
    @Post(value = "${webhookEventSend}", interceptor = ClientTokenInterceptor.class)
    DyResult<BaseVo> webhookEventSend(@Var("query") BaseQuery query, @Body("event_type") String eventType);

    /**
     * 获取jsb_ticket
     */
    @Get(value = "${getJsbTicket}", interceptor = ClientTokenInterceptor.class)
    DyResult<TicketVo> getJsbTicket(@Var("query") BaseQuery query);

    /**
     * 获取 open_ticket
     */
    @Get(value = "${getOpenTicket}", interceptor = ClientTokenInterceptor.class)
    DyResult<TicketVo> getOpenTicket(@Var("query") BaseQuery query);
}
