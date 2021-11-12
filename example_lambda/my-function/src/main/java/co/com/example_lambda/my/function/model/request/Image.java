package co.com.example_lambda.my.function.model.request;

import io.micronaut.core.annotation.Introspected;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.net.URL;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {
  String name;
  URL url;
}
