package co.com.example_lambda.my.function.model.response;

import io.micronaut.core.annotation.Introspected;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Content {
  Boolean valid;
}
