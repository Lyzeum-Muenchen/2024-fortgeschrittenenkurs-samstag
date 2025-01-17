package de.lyzeum.programmieren.texteditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TextEditorController implements Initializable {
    @FXML
    public Button btnNew;
    @FXML
    public Button btnLoad;
    @FXML
    public Button btnSave;
    @FXML
    public TextArea txtContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onNewClick(ActionEvent actionEvent) {
        txtContent.setText("");
    }

    public void onLoadClick(ActionEvent actionEvent) {
        File selectedFile = new File(System.getProperty("user.dir")+"/notes.txt");
        String content = readContent(selectedFile);
        txtContent.setText(content);
    }

    public void onSaveClick(ActionEvent actionEvent) {
        File selectedFile = new File(System.getProperty("user.dir")+"/notes.txt");
        writeContent(selectedFile, txtContent.getText());
    }

    private String readContent(File file){
        if (file != null && file.exists()){
            try {
                Scanner in = new Scanner(new FileReader(file.getAbsolutePath()));
                StringBuilder content = new StringBuilder();
                boolean isFirstLine = true;
                while(in.hasNextLine()){
                    if (! isFirstLine) content.append("\n");
                    isFirstLine = false;
                    content.append(in.nextLine());
                }
                in.close();
                return content.toString();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }

    private void writeContent(File file, String content){
        if (file != null){
            try{
                PrintWriter writer = new PrintWriter(file.getAbsolutePath(), StandardCharsets.UTF_8);
                writer.print(content);
                writer.close();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}