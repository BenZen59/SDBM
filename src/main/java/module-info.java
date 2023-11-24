module fr.bz.sdbm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires lombok;

    opens fr.bz.sdbm to javafx.fxml;
    exports fr.bz.sdbm;
}