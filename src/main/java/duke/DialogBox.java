package duke;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img, boolean isUser) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);

        if (isUser) {
            dialog.setStyle("-fx-background-color: #ffe4e1;" +
                            "-fx-border-color: #b0b0b0;" +
                            "-fx-background-radius: 20;" +
                            "-fx-border-radius: 20;" +
                            "-fx-border-width: 2;" +
                            "-fx-padding: 10 15 10 15;" +
                            "-fx-text-fill: #000000;" +
                            "-fx-font-size: 14px;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0.3, 0, 2);");
            setAlignment(Pos.TOP_RIGHT);
        } else {
            dialog.setStyle("-fx-background-color: #f5f5dc;" +
                            "-fx-border-color: #a1887f;" +
                            "-fx-background-radius: 20;" +
                            "-fx-border-radius: 20;" +
                            "-fx-border-width: 2;" +
                            "-fx-padding: 10 15 10 15;" +
                            "-fx-text-fill: #000000;" +
                            "-fx-font-size: 14px;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0.3, 0, 2);");
            flip();
        }
    }

    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, true);
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        return new DialogBox(text, img, false);
    }
}