package utils.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingFilterConfiguration {

    @Bean
    public RequestLoggingFilter logFilter() {
        RequestLoggingFilter filter = new RequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setBeforeMessagePrefix("");
        filter.setIncludeHeaders(true);
        return filter;
    }
}
