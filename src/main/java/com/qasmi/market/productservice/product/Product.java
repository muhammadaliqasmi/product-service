package com.qasmi.market.productservice.product;

import static com.qasmi.market.productservice.product.Product.*;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qasmi.market.productservice.base.AbstractMongoEntity;

/**
 * {@link Product} implements pojo for product.
 * 
 * @author Muhammad Ali Qasmi
 * @since 1.0.0
 */
@Document(collection = COLLECTION_NAME)
public class Product extends AbstractMongoEntity{

    public static final String COLLECTION_NAME = "products";
    
    @NotBlank(message = "Category is required.")
    private final String category;
    
    @NotBlank(message = "Name is required.")
    private final String name;
    
    private String description;
    
    /**
     * Creates instance of {@link Product}. 
     * Requires product's category and name. 
     * 
     * @param category Category of the product.
     * @param name Name of the product.
     */
    @JsonCreator
    public Product(@JsonProperty("category") final String category, //
            @JsonProperty("name") final String name) {
        this.category = category;
        this.name = name;
    }
    
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Product)) {
            return false;
        }
        final Product rhsObject = (Product) object;
        return new EqualsBuilder() //
                .append(getCategory(), rhsObject.getCategory()) //
                .append(getName(), rhsObject.getName()) //
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return new HashCodeBuilder() //
                .append(getCategory())
                .append(getName()) //
                .hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this) //
                .append("Category", getCategory()) //
                .append("Name", getName()) //
                .append("Description", getDescription()) //
                .toString();
    }

}
