module fr.bz.sdbm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires static lombok;

    opens fr.bz.sdbm to javafx.fxml;
    opens fr.bz.sdbm.metier to javafx.base;
    exports fr.bz.sdbm;
}