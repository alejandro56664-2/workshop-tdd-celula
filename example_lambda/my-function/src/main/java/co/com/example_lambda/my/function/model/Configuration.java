package co.com.example_lambda.my.function.model;

import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.net.URL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Configuration {
  private String appName;
  private URL thirdpartyEndpoint;
  private Double threshold;
}
