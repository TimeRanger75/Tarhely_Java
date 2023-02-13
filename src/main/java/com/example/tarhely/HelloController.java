package com.example.tarhely;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HelloController {

    @FXML
    private TableView tableTarhely;

    @FXML
    private TableColumn<Tarhely, Integer> id;
    @FXML
    private TableColumn<Tarhely,String> nev;
    @FXML
    private TableColumn<Tarhely, Integer> ar;
    @FXML
    private TableColumn<Tarhely, Integer> meret;

    @FXML
    private void initialize(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        meret.setCellValueFactory(new PropertyValueFactory<>("meret"));
        ar.setCellValueFactory(new PropertyValueFactory<>("ar"));
        Platform.runLater(()->{
            try {
                loadTarhely();
            }catch (IOException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Hiba történt az adatok..");
                alert.setContentText(e.getMessage());
                Platform.exit();
            }
        });
    }


    private void loadTarhely()throws IOException{
        Response response=RequestHandler.get(HelloApplication.BASE_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        Tarhely[] tarhelyek=converter.fromJson(content, Tarhely[].class);
        tableTarhely.getItems().clear();
        for(Tarhely tarhely: tarhelyek){
            tableTarhely.getItems().add(tarhely);
        }
    }
}