module com.lista.listagem {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
    requires java.sql;

    opens com.lista.listagem to javafx.fxml;
    exports com.lista.listagem;
}