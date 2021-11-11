package co.com.example_lambda.my.function.architecture;
 
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class LayeredArchitectureTest {

  @Test
  void layerDependenciesAreRespected() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("co.com.example_lambda.my.function");

    ArchRule layer_dependencies_are_respected = layeredArchitecture()
        //TODO recuerde eliminar los comentarios o agregarlos cuando agregue componentes de backend.
        .layer("Controllers").definedBy("co.com.example_lambda.my.function.controller..")
        .layer("Services").definedBy("co.com.example_lambda.my.function.service..")
        //.layer("Backend").definedBy("co.com.example_lambda.my.function.backend..")

        .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
        .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers");
        //.whereLayer("Backend").mayOnlyBeAccessedByLayers("Services");

    layer_dependencies_are_respected.check(importedClasses);

  }
}