package com.qasmi.market.productservice.product;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

/**
 * {@link ProductRepository} implements {@link MongoRepository} for {@link Product}.
 * 
 * @author Muhammad Ali Qasmi
 * @since 1.0.0
 */
public interface ProductRepository  extends MongoRepository<Product, ObjectId>,
QuerydslPredicateExecutor<Product>, QuerydslBinderCustomizer<QProduct>{
    
    /**
     * {@inheritDoc}
     */
    @Override
    default void customize(final QuerydslBindings bindings, final QProduct root) {
        bindings.bind(String.class).first((final StringPath path, final String value) -> {
            return path.equalsIgnoreCase(value);
        });
    }

}
