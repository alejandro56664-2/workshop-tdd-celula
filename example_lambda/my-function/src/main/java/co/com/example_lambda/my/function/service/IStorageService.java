package co.com.example_lambda.my.function.service;

import java.net.URL;
import java.util.Optional;

/**
 * Permite acceder al repositorio de archivos
 */
public interface IStorageService {

  /**
   * Permite obtener el contenido de un archivo almacenado en el almacén remoto.
   * @param url Url que indica la ubicación del archivo.
   * @return Optional<byte[]> (Opcional) si el archivo existe, trae el contenido del archivo.
   */
  Optional<byte[]> pullFile(URL url);
}
