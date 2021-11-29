package co.com.example_lambda.my.function.service.impl;

import co.com.example_lambda.my.function.clientws.IThirdPartyClient;
import co.com.example_lambda.my.function.model.request.Request;
import co.com.example_lambda.my.function.model.response.Content;
import co.com.example_lambda.my.function.model.response.Response;
import co.com.example_lambda.my.function.config.ConfigRetriever;
import co.com.example_lambda.my.function.service.ILambdaService;
import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.example_lambda.my.function.service.IStorageService;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class LambdaServiceImpl implements ILambdaService {

  @Inject ConfigRetriever configRetriever;

  @Inject IThirdPartyClient clientws;

  @Inject IStorageService storage;

  @Override
  public Response get(Request request) {
    configRetriever
        .getConfiguration()
        .ifPresent(c -> log.info("Configuración disponible: {}", c.toString()));

    return Response.Success(
      Content.builder().valid(true).build()
    );
  }
}
