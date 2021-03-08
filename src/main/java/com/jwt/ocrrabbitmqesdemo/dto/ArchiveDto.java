package com.jwt.ocrrabbitmqesdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 拼音是客户要求的字段，这个demo就不改了
 */
@Data
public class ArchiveDto {
    /**
     * Id
     */
    @ApiModelProperty(notes = "Id", example = "1")
    private Integer Id;
    /**
     * 全宗号
     */
    @ApiModelProperty(notes = "全宗号", example = "2")
    private String qzh;
    /**
     * 目录号
     */
    @ApiModelProperty(notes = "目录号", example = "3")
    private String mlh;
    /**
     * 归档年度
     */
    @ApiModelProperty(notes = "归档年度", example = "2021")
    private String gdnd;
    /**
     * 门类
     */
    @ApiModelProperty(notes = "门类", example = "门类")
    private String ml;
    /**
     * 保管期限
     */
    @ApiModelProperty(notes = "保管期限", example = "2030")
    private String bgqx;
    /**
     * 件号
     */
    @ApiModelProperty(notes = "件号", example = "20211111")
    private Integer jh;
    /**
     * 载体数量
     */
    @ApiModelProperty(notes = "载体数量", example = "22")
    private Integer ztsl;
    /**
     * 档号
     */
    @ApiModelProperty(notes = "档号", example = "20212222")
    private String dh;
    /**
     * 文号
     */
    @ApiModelProperty(notes = "文号", example = "文号1232")
    private String wjbh;
    /**
     * 密级
     */
    @ApiModelProperty(notes = "密级", example = "一级")
    private String mj;
    /**
     * 题名
     */
    @ApiModelProperty(notes = "题名", example = "题名")
    private String tm;
    /**
     * 文件形成时间
     */
    @ApiModelProperty(notes = "文件形成时间", example = "2021-3-5")
    private String wjxcsj;
    /**
     * 文件到期时间
     */
    @ApiModelProperty(notes = "文件到期时间", example = "2021-4-5")
    private String wjdqsj;
    /**
     * 责任者
     */
    @ApiModelProperty(notes = "责任者", example = "张三")
    private String zrz;
    /**
     * 存放位置描述
     */
    @ApiModelProperty(notes = "存放位置描述", example = "一档案室")
    private String cfwzms;
    /**
     * 主题词或关键词
     */
    @ApiModelProperty(notes = "主题词或关键词", example = "科技、IT、大数据")
    private String ztc;
    /**
     * 备注
     */
    @ApiModelProperty(notes = "备注", example = "备注")
    private String bz;
    /**
     * 文件地址
     */
    @ApiModelProperty(notes = "文件地址", example = "文件地址")
    private String fileAddress;
    /**
     * 是否删除 0 (新增、修改) 1删除
     */
    @ApiModelProperty(notes = "是否删除 0 (新增、修改) 1删除", example = "0")
    private Integer isDeleted;
}
