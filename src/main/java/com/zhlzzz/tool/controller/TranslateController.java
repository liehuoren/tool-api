package com.zhlzzz.tool.controller;

import com.zhlzzz.tool.dto.TranslateDto;
import com.zhlzzz.tool.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @PostMapping(value = "/translate", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object translate(@RequestBody TranslateDto dto) {
        return translateService.translate(dto);
    }
}
