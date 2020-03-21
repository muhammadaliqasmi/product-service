
package com.qasmi.market.productservice.product;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;

import com.qasmi.market.productservice.test.AbstractIntegrationTest;

/**
 * {@link ProductRepositoryTest} implements repository integration test cases for
 * {@link ProductRepository}.
 * 
 * @author Muhammad Ali Qasmi
 */
@UsingDataSet(locations = "products.bson")
public class ProductRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @ShouldMatchDataSet(location = "products_after_create.bson")
    public void shouldCreateNewProduct() throws Exception {
        final Product product = new Product("food.meat", "cow");
        productRepository.save(product);
    }

    @Test
    public void shouldFindAllProducts() throws Exception {
        final List<Product> products = productRepository.findAll();
        assertThat(products, hasSize(4));
        assertFirstProduct(products.get(0));
        assertSecondProduct(products.get(1));
        assertThirdProduct(products.get(2));
        assertFourthProduct(products.get(3));
    }

    @Test
    public void shouldFindProductById() throws Exception {
        final ObjectId id = new ObjectId("5e630da326b3592f69cb39f2");
        final Product product = productRepository.findById(id).get();
        assertFirstProduct(product);
    }

    @Test
    @ShouldMatchDataSet(location = "products_after_update.bson")
    public void shouldUpdateProductById() throws Exception {
        final ObjectId id = new ObjectId("5e630da326b3592f69cb39f2");
        final Product product = productRepository.findById(id).get();
        product.setDescription("This is an apple.");
        productRepository.save(product);
    }

    @Test
    @ShouldMatchDataSet(location = "products_after_delete.bson")
    public void shouldDeleteProductById() throws Exception {
        final ObjectId id = new ObjectId("5e630da326b3592f69cb39f2");
        productRepository.deleteById(id);
    }

    private void assertFirstProduct(final Product product) {
        assertThat(product, is(notNullValue()));
        assertThat(product.getId(), is("5e630da326b3592f69cb39f2"));
        assertThat(product.getCategory(), is("food.fruits"));
        assertThat(product.getName(), is("apple"));
        assertThat(product.getDescription(), is(nullValue()));
    }

    private void assertSecondProduct(final Product product) {
        assertThat(product, is(notNullValue()));
        assertThat(product.getId(), is("5e630db326b3592f69cb39f3"));
        assertThat(product.getCategory(), is("food.fruits"));
        assertThat(product.getName(), is("mango"));
        assertThat(product.getDescription(), is(nullValue()));
    }

    private void assertThirdProduct(final Product product) {
        assertThat(product, is(notNullValue()));
        assertThat(product.getId(), is("5e630e0f26b3592f69cb39f4"));
        assertThat(product.getCategory(), is("food.vegetables"));
        assertThat(product.getName(), is("carrot"));
        assertThat(product.getDescription(), is(nullValue()));
    }

    private void assertFourthProduct(final Product product) {
        assertThat(product, is(notNullValue()));
        assertThat(product.getId(), is("5e630e3526b3592f69cb39f5"));
        assertThat(product.getCategory(), is("food.vegetables"));
        assertThat(product.getName(), is("potato"));
        assertThat(product.getDescription(), is(nullValue()));
    }
}
