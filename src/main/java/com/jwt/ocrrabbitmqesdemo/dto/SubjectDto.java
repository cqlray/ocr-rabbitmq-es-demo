package com.jwt.ocrrabbitmqesdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubjectDto {
    @ApiModelProperty(notes = "名称", example = "名称测试")
    private String title;
    @ApiModelProperty(notes = "发送人", example = "张三")
    private String sender;
    @ApiModelProperty(notes = "接收人", example = "李四")
    private String receiver;
    @ApiModelProperty(notes = "内容", example = "工作任务：1，2，3")
    private String content;
}
