package co.com.example_lambda.my.function.model.request;

import io.micronaut.core.annotation.Introspected;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

/**
  Request: representa un evento generico
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {
  String reqId;
  String idNumber;
  IdType idType;
  List<Image> images;
}
