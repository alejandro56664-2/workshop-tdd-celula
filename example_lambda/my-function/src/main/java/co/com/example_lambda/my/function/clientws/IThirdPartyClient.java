package co.com.example_lambda.my.function.clientws;

import co.com.example_lambda.my.function.model.thirdparty.Issue;
import co.com.example_lambda.my.function.model.thirdparty.IssueStatus;

/**
 * Permite consumir la API de terceros
 */
public interface IThirdPartyClient {
  /**
   * Crea un 'Issue' en el servicio de terceros. Iniciando la validación del usuario
   * @param issue contiene la información de una persona para ser validada.
   * @return IssueStatus
   */
  IssueStatus createIssue(Issue issue);

}
