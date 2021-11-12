package co.com.example_lambda.my.function.service;

import co.com.example_lambda.my.function.model.request.Request;
import co.com.example_lambda.my.function.model.response.Response;

public interface ILambdaService {
  /**
   * Recupera los archivos del almacenamiento remoto y prepara la invocación del servicio de terceros.
   * @param request
   * @return response
   */
  Response get(Request request);
}
