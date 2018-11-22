package com.accenture.flowershop.fe.servlets.product;

import com.accenture.flowershop.be.entity.product.Product;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {
    public QProduct(Class<? extends Product> type, String variable) {
        super(type, variable);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata) {
        super(type, metadata);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, @Nullable PathInits inits) {
        super(type, metadata, inits);
    }
}
