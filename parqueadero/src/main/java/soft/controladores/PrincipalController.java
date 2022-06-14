package soft.controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import soft.model.Registro;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    ModelFactoryController modelFactory = ModelFactoryController.getInstance();
    @FXML
    private TextField placaIngresoTxt;
    @FXML
    private TextField buscarRegistro;

    @FXML
    private ComboBox<String> comboTipo;

    @FXML
    private AnchorPane ingresoPane;

    @FXML
    private AnchorPane listaPane;

    @FXML
    private AnchorPane cobroPane;



    @FXML
    private TableView<Registro> tablaIngresos;

    @FXML
    private TableColumn<Registro, String> clFechaIngreso;

    @FXML
    private TableColumn<Registro, String> clPlaca;

    @FXML
    private TableColumn<Registro, String> clTipo;

    ObservableList<Registro>listaRegistros;
    ObservableList<Registro>filtroRegistros;

    @FXML
    void abrirIngreso(ActionEvent event) {

        ingresoPane.setVisible(true);
        cobroPane.setVisible(false);
        listaPane.setVisible(false);

    }

    @FXML
    void abrirSalida(ActionEvent event) {
        ingresoPane.setVisible(false);
        cobroPane.setVisible(true);
        listaPane.setVisible(false);

    }
    @FXML
    void listarVehiculos(ActionEvent event) {
        ingresoPane.setVisible(false);
        cobroPane.setVisible(false);
        listaPane.setVisible(true);
    }

    @FXML
    void calcularTotalSalida(ActionEvent event) {
        String mensaje = modelFactory.calcularTotalSalida(buscarRegistro.getText());
        JOptionPane.showMessageDialog(null, mensaje);
        listaRegistros.clear();
        listaRegistros.setAll(modelFactory.parqueadero.getRegistros());
        filtroRegistros.clear();
        filtroRegistros.setAll(listaRegistros);
        buscarRegistro.setText("");
        tablaIngresos.refresh();
    }

    @FXML
    void ingresarVehiculo(ActionEvent event) {
        if(comboTipo.getValue() ==null || placaIngresoTxt.getText().equalsIgnoreCase("")) JOptionPane.showMessageDialog(null, "Por Ingrese los datos completos");
        else {
            String mensaje = modelFactory.ingresarVehiculo(placaIngresoTxt.getText(), comboTipo.getValue());

            JOptionPane.showMessageDialog(null, mensaje);
            placaIngresoTxt.setText("");
            listaRegistros.clear();
            listaRegistros.setAll(modelFactory.parqueadero.getRegistros());
            tablaIngresos.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaRegistros = FXCollections.observableArrayList();
        filtroRegistros = FXCollections.observableArrayList();

        listaRegistros.setAll(modelFactory.parqueadero.getRegistros());
        this.clFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaTabla"));
        this.clPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.clTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tablaIngresos.setItems(listaRegistros);
        ObservableList<String> items = FXCollections.observableArrayList();

        items.addAll("turbo/Volqueta","moto","particular","camion");

        comboTipo.setItems(items);
    }


    public void filtrarPlacas(javafx.scene.input.KeyEvent keyEvent) {
        String filtroPlaca = buscarRegistro.getText();
        if(filtroPlaca.isEmpty()){
            this.tablaIngresos.setItems(listaRegistros);
        }else{
            this.filtroRegistros.clear();
            for(Registro registro : listaRegistros){
                if(registro.getPlaca().toLowerCase().contains(filtroPlaca)) {
                    this.filtroRegistros.add(registro);
                }
            }
            this.tablaIngresos.setItems(filtroRegistros);
        }
    }
}
