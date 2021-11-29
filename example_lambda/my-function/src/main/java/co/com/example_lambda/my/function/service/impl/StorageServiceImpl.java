package co.com.example_lambda.my.function.service.impl;

import co.com.example_lambda.my.function.service.IStorageService;

import javax.inject.Singleton;
import java.net.URL;
import java.util.Optional;

@Singleton
public class StorageServiceImpl implements IStorageService {

  @Override
  public Optional<byte[]> pullFile(URL url) {
    //TODO implementar acceso a almacenamiento remoto.
    return Optional.empty();
  }
}
