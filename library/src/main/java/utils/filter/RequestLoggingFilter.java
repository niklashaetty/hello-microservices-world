package utils.filter;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class RequestLoggingFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logger.info(message);
    }

     // Don't log after request
    @Override
    protected void afterRequest(HttpServletRequest request, String message) { }
}