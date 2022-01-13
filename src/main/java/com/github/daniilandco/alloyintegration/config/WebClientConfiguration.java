package com.github.daniilandco.alloyintegration.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfiguration {
    @Value("${auth.token}")
    private String AUTHORIZATION;
    @Value("${api.url}")
    private String BASE_URL;
    public static final int TIMEOUT = 1000;

    @Bean
    public WebClient webClientWithTimeout() {
        final var tcpClient = TcpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT).doOnConnected(connection -> {
            connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
            connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
        });

        return WebClient.builder().baseUrl(BASE_URL).defaultHeaders(httpHeaders -> {
            // set `content-type` header
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            // set `accept` header
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            // set authorization
            httpHeaders.setBasicAuth(AUTHORIZATION);
        }).clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient))).build();
    }
}
