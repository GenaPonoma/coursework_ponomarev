package org.example.coursework_ponomarev.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.coursework_ponomarev.model.Document;
import org.example.coursework_ponomarev.model.Owner;
import org.example.coursework_ponomarev.model.RegistrationRecord;
import org.example.coursework_ponomarev.model.Vehicle;
import org.example.coursework_ponomarev.crud.CRUDService;
import org.example.coursework_ponomarev.crud.RegistrationRecordService;

import java.time.LocalDate;

import static org.example.coursework_ponomarev.factory.OwnerFactory.createOwner;
import static org.example.coursework_ponomarev.factory.VehicleFactory.createVehicle;

public class Controller {

    // UI элементы
    @FXML private Button registerButton;
    @FXML private TableView<RegistrationRecord> tableView;
    @FXML private TableColumn<RegistrationRecord, String> columnModel;
    @FXML private TableColumn<RegistrationRecord, String> columnCategory;
    @FXML private TableColumn<RegistrationRecord, String> columnFuelType;
    @FXML private TableColumn<RegistrationRecord, String> columnTechInspectionDate;
    @FXML private ComboBox<String> transmissionComboBox;
    @FXML private TextField documentNumberField;
    @FXML private DatePicker issueDatePicker;
    @FXML private DatePicker expirationDatePicker;
    @FXML private ComboBox<String> categoryOwnerComboBox;
    @FXML private TextField ownerNameField;
    @FXML private TextField ownerAddressField;
    @FXML private TextField modelField;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private TextField fuelTypeField;
    @FXML private DatePicker techInspectionDatePicker;

    // Сервис для работы с записями
    private final CRUDService<RegistrationRecord> crudService = new RegistrationRecordService();

    // Список для хранения записей о регистрации
    private final ObservableList<RegistrationRecord> registrationRecords = FXCollections.observableArrayList(crudService.findAll());

    @FXML
    private void initialize() {
        // Инициализация ComboBox
        categoryOwnerComboBox.getItems().addAll("Физическое лицо", "Юридическое лицо");
        categoryComboBox.getItems().addAll("Автомобиль", "Грузовик", "Мотоцикл");

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
        // Получение данных из полей формы
        String model = modelField.getText();
        String category = categoryComboBox.getValue();
        String categoryOwner = categoryOwnerComboBox.getValue();
        String fuelType = fuelTypeField.getText();
        LocalDate techInspectionDate = techInspectionDatePicker.getValue();
        String documentNumber = documentNumberField.getText();
        LocalDate issueDate = issueDatePicker.getValue();
        LocalDate expirationDate = expirationDatePicker.getValue();
        String transmission = transmissionComboBox.getValue();

        // Проверка заполнения обязательных полей
        if (model.isEmpty() || fuelType.isEmpty() || techInspectionDate == null || documentNumber.isEmpty() || issueDate == null || expirationDate == null) {
            showAlert(Alert.AlertType.WARNING, "Пожалуйста, заполните все обязательные поля перед добавлением транспортного средства.");
            return;
        }
        // Создание документа
        Document document = new Document(documentNumber, issueDate, expirationDate);
        // Создание владельца в зависимости от выбранной категории
        Owner owner = createOwner(categoryOwner, ownerNameField.getText(), ownerAddressField.getText());
        // Создание транспортного средства в зависимости от выбранной категории
        Vehicle vehicle = createVehicle(category, model, fuelType, techInspectionDate, owner, document, transmission);
        // Создание записи регистрации
        RegistrationRecord record = new RegistrationRecord(vehicle, owner);
        // Добавление записи в таблицу через сервис
        crudService.create(record);
        registrationRecords.setAll(crudService.findAll());

        // Очистка формы
        clearForm();

        // Уведомление об успешной регистрации
        showAlert(Alert.AlertType.INFORMATION, "Транспортное средство успешно зарегистрировано!");
    }

    // Метод для отображения уведомлений
    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Метод для очистки формы
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