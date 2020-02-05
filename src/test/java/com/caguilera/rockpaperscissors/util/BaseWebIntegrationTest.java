package com.caguilera.rockpaperscissors.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class BaseWebIntegrationTest {

    @LocalServerPort
    private int serverPort;

    @Value("${server.servlet.context-path}")
    private String springContextPath;

    protected String getUrl(String relativeUrl) {

        String sanitizedRelativeUrl = Optional.ofNullable(relativeUrl)
                .map(s -> s.startsWith("/") ? s.substring(1) : s)
                .orElse("");

        String ipAddress;
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String baseUrl = "http://" + ipAddress;

        String contextPath = this.springContextPath.endsWith("/") ?
                this.springContextPath :
                this.springContextPath + "/";

        return String.format("%s:%d%s%s", baseUrl, serverPort, contextPath, sanitizedRelativeUrl);
    }

    protected JsonMatcher hasSameContentAs(String jsonFilePath) {

        return JsonMatcher.hasSameContentAs(this.getClass(), jsonFilePath);
    }
}
