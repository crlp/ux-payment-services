package bcp.bootcamp.uxpaymentservice.repositories.impl;

import bcp.bootcamp.uxpaymentservice.repositories.OperationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
@Repository
public class OperationRepositoryImpl implements OperationRepository {

    private final WebClient client;

    public OperationRepositoryImpl(WebClient.Builder builder,
                                   @Value( "${application.urlBsPaymentService:http://localhost:/payment-services}" ) String urlApiAuthors){
        log.info("urlApiAuthors = " + urlApiAuthors);

        // Configurar Response timeout
        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5));
        this.client = builder.baseUrl(urlApiAuthors)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }
}
