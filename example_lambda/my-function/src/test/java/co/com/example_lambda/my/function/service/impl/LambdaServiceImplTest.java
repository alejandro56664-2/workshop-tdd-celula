package co.com.example_lambda.my.function.service.impl;

import co.com.example_lambda.my.function.clientws.IThirdPartyClient;
import co.com.example_lambda.my.function.config.ConfigRetriever;
import co.com.example_lambda.my.function.model.request.Request;
import co.com.example_lambda.my.function.model.response.Response;
import co.com.example_lambda.my.function.service.IStorageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LambdaServiceImplTest {

  @Mock IStorageService storageService;

  @Mock IThirdPartyClient clientws;

  @Mock ConfigRetriever configRetriever;

  @InjectMocks private static LambdaServiceImpl service;

  /* Requisitos funcionales:
   * - El servicio debe usar un cliente de s3 que recibe la url del archivo y devuelve el binario (ya está disponible la interfaz).
   * - El servicio debe usar un clientws que invoca el servicio de terceros (ya está disponible la interfaz).
   * - Debe cargar el umbral del score desde el parameter store (usando el ConfigRetriever).
   * - Debe construir el request para el servicio de terceros trayendo las imágenes del s3 y convertirlas en base64.
   * - Si la respuesta del servicio contiene un error, debe lanzar una excepción (la excepción ya está creada).
   * - Si la respuesta es correcta, debe comparar el umbral con el score obtenido. Si es mayor, responder que el usuario ha sido validado. Si la respuesta es menor, responder que el usuario es invalido.
   */

  /*
   Trate de asegurar que sus pruebas sigan los Principios F.I.R.S.T
     - Fast: la ejecución de la prueba debe ser rápida
     - Independent: no deben existir dependencias entre pruebas (evitar compartir información o estados)
     - Repeteable: las pruebas se deben repetir en cualquier momento o lugar(depender al minimo del ambiente de ejecución)
     - Self-validating: las pruebas contienen lo necesario para validar el concepto que se supone están validando.
     - Timely: las pruebas son oportunas, en el sentido de que agregan valor.
   */

  //TODO: Procure agregar siempre pruebas que agreguen valor para el negocio.
  @Test
  @DisplayName("Dummy Test")
  void executeTest() {
    // Se sugiere usar el patrón AAA para la escritura de pruebas. Es equivalente al given-when-then.
    // Siempre verifique si sigue los principios FIRST.

    //Arrange
    Request request = Request.builder().build();

    //Act
    Response result = service.createIssue(request);

    //Assert
    assertNotNull(result);
    //Considere agregar más validaciones para el resultado.
  }
}
