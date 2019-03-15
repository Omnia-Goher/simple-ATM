
package atmfinal;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Error {

    public void display( String message) {
        Stage window = new Stage();
         String title;
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ATM - Machine");
        window.setMinWidth(500);

        Label label = new Label();
        label.setText(message);
        label.getStyleClass().add("Label4");
        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

      
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }

}


