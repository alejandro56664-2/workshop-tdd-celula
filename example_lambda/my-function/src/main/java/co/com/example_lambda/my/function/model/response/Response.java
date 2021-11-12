package co.com.example_lambda.my.function.model.response;

import io.micronaut.core.annotation.Introspected;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Introspected
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
  static final String SUCCESS = "success";
  static final String FAILURE = "failure";

  public static Response Success(Object content) {
    return new Response(SUCCESS, content, null);
  }

  public static Response Failure(Throwable cause) {
    return new Response(
      SUCCESS,
      null,
      Error.builder()
        .code(-1)
        .description(cause.getMessage()
        ).build()
    );
  }

  final String result;
  final Object content;
  final Error error;

  private Response(final String result, final Object content, final Error error) {
    this.result = result;
    this.content = content;
    this.error = error;
  }

  public boolean isSuccess() {
    return SUCCESS.equalsIgnoreCase(result);
  }

}
