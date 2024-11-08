module com.example.newsrecommendationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;

    opens com.example.newsrecommendationsystem to javafx.fxml;
    exports com.example.newsrecommendationsystem;
}