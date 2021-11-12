package co.com.example_lambda.my.function.model.thirdparty;

import io.micronaut.core.annotation.Introspected;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Issue {
}
