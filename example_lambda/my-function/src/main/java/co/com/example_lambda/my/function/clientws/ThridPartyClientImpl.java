package co.com.example_lambda.my.function.clientws;

import co.com.example_lambda.my.function.model.thirdparty.Issue;
import co.com.example_lambda.my.function.model.thirdparty.IssueStatus;

import javax.inject.Singleton;

@Singleton
public class ThridPartyClientImpl implements IThirdPartyClient{

  @Override
  public IssueStatus postIssue(Issue issue) {
    //TODO implementar acceso a almacenamiento remoto.
    return null;
  }
}
