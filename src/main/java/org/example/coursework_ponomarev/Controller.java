package org.example.coursework_ponomarev;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {

    public Button registerButton;
    public TableView<RegistrationRecord> tableView;
    public TableColumn<RegistrationRecord, String> columnModel;
    public TableColumn<RegistrationRecord, String> columnCategory;
    public TableColumn<RegistrationRecord, String> columnFuelType;
    public TableColumn<RegistrationRecord, String> columnTechInspectionDate;

    public TextField documentNumberField;
    public DatePicker issueDatePicker;
    public DatePicker expirationDatePicker;
    public ComboBox<String> categoryOwnerComboBox;
    public TextField ownerNameField;
    public TextField ownerAddressField;
    @FXML
    private TextField modelField;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private TextField fuelTypeField;
    @FXML
    private DatePicker techInspectionDatePicker;

    private final ObservableList<RegistrationRecord> registrationRecords = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        categoryOwnerComboBox.getItems().addAll("Физическое лицо", "Юридическое лицо");
        categoryComboBox.getItems().addAll("Автомобиль", "Грузовик", "Мотоцикл"); // Добавляем варианты категорий

        // Настройка колонок таблицы
        columnModel.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVehicle().getModel()));
        columnCategory.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVehicle().getCategory()));
        columnFuelType.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVehicle().getFuelType()));
        columnTechInspectionDate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVehicle().getTechInspectionDate()).asString());


        // Установка данных в таблицу
        tableView.setItems(registrationRecords);
    }

    @FXML
    private void registerVehicle(ActionEvent event) {
        String model = modelField.getText();
        String category = categoryComboBox.getValue(); // Получаем значение из ComboBox
        String categoryOwner = categoryOwnerComboBox.getValue();
        String fuelType = fuelTypeField.getText();
        LocalDate techInspectionDate = techInspectionDatePicker.getValue();

        Document document = new Document(documentNumberField.getText(), issueDatePicker.getValue(), expirationDatePicker.getValue());

        Owner owner;
        Vehicle vehicle;

        switch (categoryOwner) {
            case "Физическое лицо":
                owner = new IndividualOwner(ownerNameField.getText(), ownerAddressField.getText());
                break;
            case "Юридическое лицо":
                owner = new LegalEntityOwner(ownerNameField.getText(), ownerAddressField.getText());
                break;
            default:
                throw new IllegalArgumentException("Неизвестная категория лиц: " + category);
        }

        switch (category) {
            case "Автомобиль":
                vehicle = new Car(model, category, fuelType, techInspectionDate, owner, document);
                break;
            case "Грузовик":
                vehicle = new Truck(model, category, fuelType, techInspectionDate, owner, document);
                break;
            case "Мотоцикл":
                vehicle = new Motorcycle(model, category, fuelType, techInspectionDate, owner, document);
                break;
            default:
                throw new IllegalArgumentException("Неизвестная категория транспортного средства: " + category);
        }

        // Проверка заполнения полей
        if (model.isEmpty() || fuelType.isEmpty() || techInspectionDate == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Пожалуйста, заполните все обязательные поля перед добавлением транспортного средства.");
            alert.showAndWait();
            return;
        }

        // Создание записи регистрации
        RegistrationRecord record = new RegistrationRecord(vehicle, owner);

        // Добавление записи в таблицу
        registrationRecords.add(record);

        // Очищаем форму для нового ввода
        clearForm();

        // Сообщение об успешной регистрации
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setContentText("Транспортное средство успешно зарегистрировано!");
        successAlert.showAndWait();
    }

    private void clearForm() {
        modelField.clear();
        categoryComboBox.getSelectionModel().clearSelection();
        fuelTypeField.clear();
        techInspectionDatePicker.setValue(null);
        categoryOwnerComboBox.getSelectionModel().clearSelection();
        ownerNameField.clear();
        ownerAddressField.clear();
        documentNumberField.clear();
        issueDatePicker.setValue(null);
        expirationDatePicker.setValue(null);
    }
}