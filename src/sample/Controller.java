package sample;

import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private ListView<Worker> employeeListView;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private CheckBox isActiveCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue<? extends Worker> ov, Worker old_val, Worker new_Val) ->
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                        firstNameText.setText(((Employee) selectedItem).firstName);
                        lastNameText.setText(((Employee) selectedItem).lastName);
                        isActiveCheckBox.setSelected(((Employee) selectedItem).isActive);

                }
        );


        ObservableList<Worker> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        employee1.firstName = "Celine";
        employee1.lastName = "Dion";
        Employee employee2 = new Employee();
        employee2.firstName = "John";
        employee2.lastName = "Denver";
        items.add(employee1);
        items.add(employee2);

        for(int i = 0; i < 10; i++)
        {
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);

        }

        Staff staff1 = new Staff();
        staff1.firstName = "Generic";
        staff1.lastName = "Staff";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "Generic";
        faculty1.lastName = "Faculty";

        items.add(staff1);
        items.add(faculty1);
    }
}
