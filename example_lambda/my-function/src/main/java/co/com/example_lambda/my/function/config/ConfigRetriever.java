package co.com.example_lambda.my.function.config;

import co.com.example_lambda.my.function.model.Configuration;
import co.com.example_lambda.my.function.enums.ParamKey;
import io.micronaut.core.annotation.Introspected;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;


@Introspected
@Singleton
@Slf4j
public class ConfigRetriever {
  Configuration config;

  public ConfigRetriever() {
    //TODO agregar código de inicialización
  }

  public Optional<Configuration> getConfiguration() {
    if(config == null){
      try {
        getParameters()
            .map(this::toConfiguration)
            .ifPresent(c -> config = c);
      } catch(Exception e ){
        log.error(e.getMessage());
      }
    }
    return Optional.ofNullable(config);
  }

  private Optional<Map<String, String>> getParameters() {
    List<String> paramKeys = Arrays.stream(ParamKey.values())
        .map(ParamKey::getValue)
        .collect(Collectors.toList());

    String functionName = ParamKey.FUNCTION_NAME.getValue();

    return Optional.ofNullable(getParamsMap(paramKeys, functionName));
  }

  private Map<String, String> getParamsMap(List<String> paramKeys, String functionName) {
    //TODO implementar con la dependencias a aws
    log.debug("Se consultan los parametros definidos por {} para la función: {}", paramKeys, functionName);
    return new HashMap<>();
  }

  private Configuration toConfiguration(Map<String, String> params) {
    return Configuration.builder()
        // TODO: Por favor agregue los parametros necesarios
        // TODO: agregar el parametro del umbral.
        .appName(params.get(ParamKey.FUNCTION_NAME.getValue()))
        .build();
  }
}
