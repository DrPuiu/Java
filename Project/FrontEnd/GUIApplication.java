package com.example.demo1;import com.example.demo1.BackEnd.Algorithms.Greedy;
import com.example.demo1.BackEnd.Input.CSVReader;
import com.example.demo1.BackEnd.Model.Event;
import com.example.demo1.BackEnd.Model.Problem;
import com.example.demo1.BackEnd.Model.Room;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GUIApplication extends Application {
    private List<Event> events;
    private Greedy greedy;
    private List<String> groups;

    @Override
    public void start(Stage primaryStage) {
        Button runGreedyButton = new Button("Run Greedy Algorithm");
        runGreedyButton.setOnAction(event -> runGreedyAlgorithm(primaryStage));
        runGreedyButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox layout = new VBox(20, runGreedyButton); // Add spacing between buttons
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void runGreedyAlgorithm(Stage primaryStage) {
        events = CSVReader.readCSV("./Events.csv");
        List<Room> rooms = CSVReader.readCSVRooms("./Rooms.csv");
        Problem problem = new Problem();
        problem.setEvents(events);
        problem.setRooms(rooms);
        greedy = new Greedy(problem);
        groups = getGroups();

        VBox layout = new VBox(10); // Add spacing between buttons
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        for (String group : groups) {
            Button button = new Button(group);
            button.setOnAction(event -> showEventsAndRoom(primaryStage, group));
            button.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold;");
            layout.getChildren().add(button);
        }

        Scene scene = new Scene(layout, 400, 550);
        primaryStage.setScene(scene);
    }

    private List<String> getGroups() {
        List<String> groupList = new ArrayList<>();
        for (Event event : events) {
            if (!groupList.contains(event.getGroup())) {
                groupList.add(event.getGroup());
            }
        }
        return groupList;
    }

    private void showEventsAndRoom(Stage primaryStage, String group) {
        List<Event> groupEvents = new ArrayList<>();
        List<Room> groupRooms = new ArrayList<>();
        for (Event event : events) {
            if (event.getGroup().equals(group)) {
                groupEvents.add(event);
                Room room = greedy.getSolution().getRoom(event);
                groupRooms.add(room);
            }
        }

        Stage stage = new Stage();
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        for (int i = 0; i < groupEvents.size(); i++) {
            Event event = groupEvents.get(i);
            Room room = groupRooms.get(i);
            Text eventText = new Text(event.toString() + " - Room: " + room);
            eventText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            layout.getChildren().add(eventText);
        }

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Events and Rooms for Group: " + group);
        stage.show();
    }
}
