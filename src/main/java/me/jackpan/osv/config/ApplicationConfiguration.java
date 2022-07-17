package me.jackpan.osv.config;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {
    @Value(value = "${github.api.personal-access-token}")
    private String githubApiToken;

    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("https://api.github.com/graphql")
                .build();
        return HttpGraphQlClient.builder(webClient)
                .headers(headers -> headers.setBearerAuth(githubApiToken))
                .build();
    }
}
