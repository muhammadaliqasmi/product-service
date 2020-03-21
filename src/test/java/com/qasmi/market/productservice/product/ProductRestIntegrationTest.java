
package com.qasmi.market.productservice.product;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.qasmi.market.productservice.test.AbstractRestIntegrationTest;

@UsingDataSet(locations = "products.bson")
public class ProductRestIntegrationTest extends AbstractRestIntegrationTest {

    @Autowired
    private ObjectMapper mapper;

    @Test
    @ShouldMatchDataSet(location = "products_after_create.bson")
    public void shouldCreateNewProduct() throws Exception {
        final Product product = new Product("food.meat", "cow");
        mockMvc.perform(post("/products") //
                .contentType(MediaType.APPLICATION_JSON) //
                .content(mapper.writeValueAsString(product))) //
                .andExpect(status().isCreated()); //
    }

    @Test
    public void shouldFindAllProducts() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk()) //
                .andExpect(jsonPath("$._embedded.products[*]", //
                        hasSize(4))) //
                .andExpect(jsonPath("$._embedded.products[0].category", //
                        is("food.fruits"))) //
                .andExpect(jsonPath("$._embedded.products[0].name", //
                        is("apple"))) //
                .andExpect(jsonPath("$._embedded.products[0].description", //
                        is(nullValue()))) //
                .andExpect(jsonPath("$._embedded.products[1].category", //
                        is("food.fruits"))) //
                .andExpect(jsonPath("$._embedded.products[1].name", //
                        is("mango"))) //
                .andExpect(jsonPath("$._embedded.products[1].description", //
                        is(nullValue()))) //
                .andExpect(jsonPath("$._embedded.products[2].category", //
                        is("food.vegetables"))) //
                .andExpect(jsonPath("$._embedded.products[2].name", //
                        is("carrot"))) //
                .andExpect(jsonPath("$._embedded.products[2].description", //
                        is(nullValue()))) //
                .andExpect(jsonPath("$._embedded.products[3].category", //
                        is("food.vegetables"))) //
                .andExpect(jsonPath("$._embedded.products[3].name", //
                        is("potato"))) //
                .andExpect(jsonPath("$._embedded.products[3].description", //
                        is(nullValue())));
    }

}
