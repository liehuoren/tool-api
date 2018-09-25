package com.zhlzzz.tool.dto;

import com.zhlzzz.tool.enums.LanguageEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TranslateDto {

    @NotNull
    private String content;
    @NotNull
    private LanguageEnum from;
    @NotNull
    private LanguageEnum to;
}
