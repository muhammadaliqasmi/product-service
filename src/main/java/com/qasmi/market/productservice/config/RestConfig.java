package com.qasmi.market.productservice.config;

import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Houses all the rest related configurations
 *
 * @author Muhammad Ali Qasmi
 * @since 1.0.0
 */
@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureValidatingRepositoryEventListener(
            final ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator());
        validatingListener.addValidator("beforeSave", validator());
    }

    /**
     * creates {@link ValidatingMongoEventListener} configured with JSR-303
     * {@link Validator}
     *
     * @return returns ValidatingMongoEventListener
     */
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    /**
     * creates JSR-303 {@link Validator}
     *
     * @return returns LocalValidatorFactoryBean
     */
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * Cors Filter for spring-data-rest and controllers
     *
     * @return returns CorsFilter
     */
    @Order(0)
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(Long.MAX_VALUE);
        config.addExposedHeader(HttpHeaders.LOCATION);
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
