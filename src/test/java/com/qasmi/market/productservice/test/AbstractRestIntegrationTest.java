package com.qasmi.market.productservice.test;

import static org.apache.commons.io.FileUtils.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.qasmi.market.productservice.config.SimpleCORSFilter;

/**
 * Base class for REST integration tests that use {@link MockMvc}
 *
 * @author Muhammad Ali Qasmi
 * @since 0.0.1
 */
@AutoConfigureMockMvc
@EnableWebMvc
public abstract class AbstractRestIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected MockMvc mockMvc;
    
    @Autowired
    private SimpleCORSFilter simpleCORSFilter;
    
    @Override
    public void before() {
        super.before();
        this.mockMvc = webAppContextSetup(this.wac).addFilters(simpleCORSFilter).build();
    }
    
    /**
     * Reads file and returns its content as string
     *
     * @param fileName must not be {@literal null}
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    protected String readFile(final String fileName) throws FileNotFoundException,
            IOException {
        Assert.notNull(fileName, "fileName is required.");
        return readFileToString(ResourceUtils.getFile(appendClasspath(fileName)), //
                Charset.defaultCharset());
    }

}
