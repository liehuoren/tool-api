package com.zhlzzz.tool.service.impl;

import com.zhlzzz.tool.dto.Param;
import com.zhlzzz.tool.dto.TranslateDto;
import com.zhlzzz.tool.service.TranslateService;
import com.zhlzzz.tool.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.*;


@Service
@Slf4j
public class TranslateServiceImpl implements TranslateService {

    private final static String HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private final static String APP_ID = "20180919000209275";

    private final static String KEY = "ynJjkx0s5EsGntZrh2jC";

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Object translate(TranslateDto dto) {
        try {
            Param params = buildParams(dto.getContent(), dto.getFrom().getCode(), dto.getTo().getCode());
            ResponseEntity<Object> response = null;
            String url = HOST + "?q=" + encode(params.getQ()) + "&from=" + params.getFrom() + "&to="
                    + params.getTo() + "&appid=" + APP_ID
                    + "&salt=" + params.getSalt() + "&sign=" + params.getSign();
            URI uri = new URI(url);
            response = restTemplate.getForEntity(uri, Object.class);
            return response.getBody();
        } catch (URISyntaxException var12) {
            var12.printStackTrace();
        }
        return null;
    }

    private Param buildParams(String query, String from, String to) {
        Param param = new Param();
        param.setQ(query);
        param.setFrom(from);
        param.setTo(to);
        param.setAppid(APP_ID);

        String salt = String.valueOf(System.currentTimeMillis());
        param.setSalt(salt);

        String src = APP_ID + query + salt + KEY;
        param.setSign(MD5.md5(src));

        return param;
    }

    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return input;
        }
    }

}
