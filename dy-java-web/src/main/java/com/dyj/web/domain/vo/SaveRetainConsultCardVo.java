package com.dyj.web.domain.vo;

import com.alibaba.fastjson.JSONObject;
import com.dyj.common.domain.DyResult;

/**
 * @author danmo
 * @date 2024-04-09 16:56
 **/
public class SaveRetainConsultCardVo extends DyResult<BaseVo> {

    private String card_id;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }


}
