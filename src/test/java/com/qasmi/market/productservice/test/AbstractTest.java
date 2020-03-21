package com.qasmi.market.productservice.test;

import static org.mockito.MockitoAnnotations.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Base class for all unit tests
 *
 * @author Muhammad Ali Qasmi
 * @since 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {

    /**
     * Log variable for all child classes. Uses LoggerFactory.getLogger(getClass()) from
     * slf4j Logging
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void before() {
        initMocks(this);
    }
    
    protected String appendClasspath(final String filename) {
        return String.format("classpath:%s/%s", //
                this.getClass().getPackage().getName().replace('.', '/'), filename);
    }

}
