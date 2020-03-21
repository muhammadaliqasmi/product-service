
package com.qasmi.market.productservice.test;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.*;

import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

/**
 * Base class for integration tests
 *
 * @author Muhammad Ali Qasmi
 * @since 0.0.1
 */
public abstract class AbstractIntegrationTest extends AbstractTest {

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule() //
            .defaultSpringMongoDb("product-service");

    @Autowired
    protected ApplicationContext context;

}
