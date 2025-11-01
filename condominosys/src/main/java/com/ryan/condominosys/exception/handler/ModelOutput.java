package com.ryan.condominosys.exception.handler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class ModelOutput {

    private OffsetDateTime timestamp;
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<PropertiesS> field;

    @Getter
    @Builder
    public static class PropertiesS {
        private String name;
        private String userMessage;

    }

}
