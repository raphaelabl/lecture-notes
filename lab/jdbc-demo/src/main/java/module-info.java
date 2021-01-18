module at.htl.survey {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.derby.client;
    requires org.apache.derby.commons;
    requires org.apache.derby.tools;
    requires org.mybatis;

    //opens at.htl.finoview.view to javafx.fxml;
    //exports at.htl.finoview.view;
    exports at.htl.finoview.controller;
    exports at.htl.finoview.model;
}
