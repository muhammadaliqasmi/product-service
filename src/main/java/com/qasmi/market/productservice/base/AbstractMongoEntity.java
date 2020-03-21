package com.qasmi.market.productservice.base;

import org.springframework.data.annotation.Id;

/**
 * Base class for Mongo entity implementations.
 *
 * @author Muhammad Ali Qasmi
 * @since 1.0.0
 */
public abstract class AbstractMongoEntity {

    @Id
    private String id;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract boolean equals(Object object);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract int hashCode();

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract String toString();

}
