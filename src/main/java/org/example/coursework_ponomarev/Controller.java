package org.example.coursework_ponomarev;


import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private TextField textFieldModel;
    @FXML
    private ComboBox<String> comboBoxCategory;
    @FXML
    private ComboBox<String> comboBoxFuelType;
    @FXML
    private DatePicker datePickerTechInspectionDate;
    @FXML
    private Button buttonAdd;
    @FXML
    private TableView<VehicleRecord> tableView;
    @FXML
    private TableColumn<VehicleRecord, String> columnModel;
    @FXML
    private TableColumn<VehicleRecord, String> columnCategory;
    @FXML
    private TableColumn<VehicleRecord, String> columnFuelType;
    @FXML
    private TableColumn<VehicleRecord, LocalDate> columnTechInspectionDate;

    private final ObservableList<VehicleRecord> vehicleRecords = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        columnModel.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTransport().getModel()));
        columnCategory.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTransport().getCategory()));
        columnFuelType.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTransport().getFuelType()));
        columnTechInspectionDate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTransport().getTechInspectionDate()));
        comboBoxCategory.getItems().addAll("A", "B", "C");
        comboBoxFuelType.getItems().addAll("Бензин", "Дизель", "Электричество");
        tableView.setItems(vehicleRecords);
    }

    public Controller() {
        this.comboBoxCategory = new ComboBox<String>();
        this.comboBoxFuelType = new ComboBox<String>();


    }


    @FXML
    private void handleAdd(ActionEvent event) {
        String model = textFieldModel.getText();
        String category = comboBoxCategory.getValue();
        String fuelType = comboBoxFuelType.getValue();
        LocalDate techInspectionDate = datePickerTechInspectionDate.getValue();

        if (!model.isEmpty() && category != null && fuelType != null && techInspectionDate != null) {
            Transport transport = new Transport(model, category, fuelType, techInspectionDate);
            List<Owner> owners = new ArrayList<>();
            owners.add(new PhysicalOwner("Иванов Иван Иванович", "Москва, ул. Ленина, д. 1", "1234 567890"));
            VehicleRecord record = new VehicleRecord(transport, owners);
            vehicleRecords.add(record);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Пожалуйста, заполните все поля.");
            alert.showAndWait();
        }
    }

    private void clearFields() {
        textFieldModel.clear();
        comboBoxCategory.getSelectionModel().clearSelection();
        comboBoxFuelType.getSelectionModel().clearSelection();
        datePickerTechInspectionDate.setValue(null);
    }
}