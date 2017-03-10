package gui;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import model.Patient;

/**
 * FXML Controller class
 *
 * @author joosiika
 * @param <E>
 */
public class SideBarListViewGUI<E> extends TitledPane implements SideBarListView_IF<E> {

    @FXML
    private ListView<E> listView;
    @FXML
    private TitledPane pane;
    
    private final String title;
    private FXMLLoader loader;
    private ObservableList<E> list;
    private SideBarGUI_IF sideBar;
    
    public SideBarListViewGUI(String title) {
        this.title = title;
        try {
            loader = new FXMLLoader(getClass().getResource("SideBarListView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            this.pane.setText(this.title);
        } catch (IOException ex) {
            // handle exception
        }
    }
    
    @Override
    public void setList(List<E> list) {
        this.list = FXCollections.observableArrayList(list);
        this.listView.setItems(this.list);
    }

    @Override
    public TitledPane getTitledPane() {
        return this.pane;
    }

    @Override
    public ListView getListView() {
        return this.listView;
    }

    @Override
    public E getSelection() {
        return this.listView.getSelectionModel().getSelectedItem();
    }
    
    @Override
    public void filter(String filter){
        FilteredList<E> filteredList = new FilteredList( p -> true);
        filteredList.setPredicate(generic -> {
            if (filter == null) {
                return true;
            }
            if(generic instanceof Patient){
            if (((Patient) generic).getFirstName().toLowerCase().contains(filter)) {
                return true;
            }
            else if (((Patient) generic).getLastName().toLowerCase().contains(filter)) {
                return true;
            }
            else if (((Patient) generic).getSSN().toLowerCase().contains(filter)) {
                return true;
            }
            return false;
            }
            return false;
        });
    }
    
}
