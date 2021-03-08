package com.jwt.ocrrabbitmqesdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 拼音是客户要求的字段，这个demo就不改了
 */
@Data
@Document(indexName = "archives")
public class Archive {
    /**
     * Id
     */
    @Id
    private Integer Id;
    /**
     * 全宗号
     */
    @Field(type = FieldType.Text)
    private String zh;
    /**
     * 目录号
     */
    @Field(type = FieldType.Text)
    private String mlh;
    /**
     * 归档年度
     */
    @Field(type = FieldType.Text)
    private String gdnd;
    /**
     * 门类
     */
    @Field(type = FieldType.Text)
    private String ml;
    /**
     * 保管期限
     */
    @Field(type = FieldType.Text)
    private String bgqx;
    /**
     * 件号
     */
    @Field(type = FieldType.Integer)
    private Integer jh;
    /**
     * 载体数量
     */
    @Field(type = FieldType.Integer)
    private Integer ztsl;
    /**
     * 档号
     */
    @Field(type = FieldType.Text)
    private String dh;
    /**
     * 文号
     */
    @Field(type = FieldType.Text)
    private String wjbh;
    /**
     * 密级
     */
    @Field(type = FieldType.Text)
    private String mj;
    /**
     * 题名
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String tm;
    /**
     * 文件形成时间
     */
    @Field(type = FieldType.Text)
    private String wjxcsj;
    /**
     * 文件到期时间
     */
    @Field(type = FieldType.Text)
    private String wjdqsj;
    /**
     * 责任者
     */
    @Field(type = FieldType.Text)
    private String zrz;
    /**
     * 存放位置描述
     */
    @Field(type = FieldType.Text)
    private String cfwzms;
    /**
     * 主题词或关键词
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String ztc;
    /**
     * 备注
     */
    @Field(type = FieldType.Text)
    private String bz;
    /**
     * 文件地址
     */
    @Field(type = FieldType.Text)
    private String fileAddress;
    /**
     * 是否删除 0 (新增、修改) 1删除
     */
    @Field(type = FieldType.Integer)
    private Integer isDeleted;
}
