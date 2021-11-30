package co.com.example_lambda.my.function.controller;

import co.com.example_lambda.my.function.model.request.Request;
import co.com.example_lambda.my.function.model.response.Response;
import co.com.example_lambda.my.function.service.ILambdaService;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Slf4j
public class LambdaController extends MicronautRequestHandler<Request, Response> {
  @Inject ILambdaService lambdaService;

  @Override
  public Response execute(final Request input) {
    log.info("Start consumer LambdaController");
    final Response client = lambdaService.createIssue(input);
    log.info("End consumer LambdaController");
    return client;
  }
}
