module com.example.newsrecommendationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    requires java.net.http;
    requires com.opencsv;
    requires java.sql;
    requires jbcrypt;
    requires com.google.gson;
    requires ai.djl.api;
    requires org.jsoup;
    requires lucene.core;
    requires lucene.queryparser;

    opens com.example.newsrecommendationsystem to javafx.fxml;
    exports com.example.newsrecommendationsystem;
    exports com.example.newsrecommendationsystem.Controller;
    opens com.example.newsrecommendationsystem.Controller to javafx.fxml;


}