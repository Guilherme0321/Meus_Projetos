module com.scenecalculador.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.scripting;

    opens com.scenecalculador.calculadora to javafx.fxml;
    exports com.scenecalculador.calculadora;
}