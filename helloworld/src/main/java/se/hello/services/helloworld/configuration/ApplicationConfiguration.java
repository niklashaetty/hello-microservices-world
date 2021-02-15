package se.hello.services.helloworld.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import utils.filter.RequestLoggingFilterConfiguration;

@Configuration
@Import(
        RequestLoggingFilterConfiguration.class
)
public class ApplicationConfiguration {


}
