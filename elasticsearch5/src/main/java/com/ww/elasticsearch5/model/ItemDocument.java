package com.ww.elasticsearch5.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = ItemDocument.INDEXNAME, type = ItemDocument.TYPE,
        shards = 5, replicas = 1)
@Data
public class ItemDocument {

    public static final String INDEXNAME = "items";
    public static final String TYPE = "item";


    //商品唯一ID
    @Id
    @Field(type = FieldType.keyword)
    private String itemId;

    //类目
    @Field(type = FieldType.Integer)
    private Integer categoryId;

    //商品名称
    @Field(type = FieldType.text, index = false)
    private String itemName;

    //商品价格
    @Field(type = FieldType.Double)
    private Double itemPrice;

    //商品描述
    @Field(type = FieldType.text, searchAnalyzer = "ik", analyzer = "ik")
    private String itemDesc;

}

