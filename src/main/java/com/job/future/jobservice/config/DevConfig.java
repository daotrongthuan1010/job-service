package com.job.future.jobservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Configuration
@Profile("dev")
@PropertySource("classpath:application.yml")
public class DevConfig {

}
