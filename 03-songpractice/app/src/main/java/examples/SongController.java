package examples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SongController {
  @FXML
  TextField urlText;
  @FXML
  TextField nameText;
  @FXML
  TextField artistText;
  @FXML
  TextField userText;
  @FXML
  TextField tagsText;
  

  @FXML
    void doAdd(ActionEvent event) throws Exception {
    	//String BASE_URL = "https://api.apispreadsheets.com/data";
  	//String FILE_ID = "fzMynCiZEOH4NYK5";
        Song song = new Song(urlText.getText(),
                             nameText.getText(),
                             artistText.getText(),
                             userText.getText(),
                             tagsText.getText());
        System.out.println(song);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("New song created!");
        //String urlstr = BASE_URL + "/" + FILE_ID + "/";
        SongSheetRepository songo = new SongSheetRepository();
        songo.create(song);
        alert.showAndWait();
    }
}

/*  public void create(Song song) throws Exception {

    String urlstr = BASE_URL + "/" + FILE_ID + "/"; // see apispreadsheets.com

    int responseCode = this.sendPostRequest(urlstr, new Gson().toJson(song));
    if (responseCode != HttpURLConnection.HTTP_CREATED) {
      System.out.println("Unexpected POST (create) response code: " + responseCode);
    }
  }*/
