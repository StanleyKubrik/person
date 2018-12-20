package control;

import model.H2Bd;
import model.JSonParser;
import model.Person;
import model.TableContract;
import model.filereader.FileReader;
import model.filereader.FileReaderContract;
import org.json.JSONException;
import view.factory.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller implements IControler, DialogCreate.DialogCreateCallBack,
        DialogUpdate.DialogUpdateCallBack, DialogDelete.DialogDeleteCallBack, DialogSearch.DialogSearchCallBack {
    // То что обновляет таблицу
    private TableContract tableContract;
    // Интерфейс фабрики
    private IDialogFactory iDialogFactory;

    public Controller(TableContract tableContract) {
        // Получаем то что обновляет таблицу из панели
        this.tableContract = tableContract;
    }

    @Override
    public void create() {
        // получаем диалог create передаем каллбек в фабричный метод и команду по которой фабрика поймет что спечь
        iDialogFactory = FactoryDialog.getInstance().factoryMethod(this,"create");
        //подключаем диалог
        iDialogFactory.setModal(true);
        //Отображаем диалог
        iDialogFactory.setVisible(true);
    }

    @Override
    public void read() {
        //tableContract.setAllValue(Mock.getInstance().read());
        tableContract.setAllValue(H2Bd.getInstance().read());
    }

    @Override
    public void update() {
        iDialogFactory = FactoryDialog.getInstance().factoryMethod(this,"update");
        iDialogFactory.setModal(true);
        iDialogFactory.setVisible(true);
    }

    @Override
    public void delete() {
        iDialogFactory = FactoryDialog.getInstance().factoryMethod(this,"delete");
        iDialogFactory.setModal(true);
        iDialogFactory.setVisible(true);
    }

    @Override
    public void search() {
        iDialogFactory = FactoryDialog.getInstance().factoryMethod(this, "search");
        iDialogFactory.setModal(true);
        iDialogFactory.setVisible(true);
    }

    @Override
    public void imp() throws IOException, SQLException, JSONException {
        JSonParser jSonParser = new JSonParser();
        List<Person> list = jSonParser.fromJSon(new FileReader().reader());
        H2Bd.getInstance().delete();
        H2Bd.getInstance().create(list);
        tableContract.setAllValue(list);
    }

    @Override
    public void exp() throws IOException, JSONException {
        FileReaderContract fileReaderContract = new FileReader();
        fileReaderContract.writer(new JSonParser().toJSon(H2Bd.getInstance().read()));
    }

    @Override
    public void callBackCreate(Person person) {
        // обновляем таблицу, записываем в БД
        H2Bd.getInstance().create(person);
        //Mock.getInstance().create(person);
        tableContract.setValue(person);
    }

    @Override
    public void callBackUpdate(Person person) throws SQLException {
        // обновляем таблицу на изменение
        //Mock.getInstance().updateUI(person);
        H2Bd.getInstance().update(person);
        tableContract.setUpdateValue(person);
    }

    @Override
    public void callBackDelete(long id) throws SQLException {
        //Mock.getInstance().delete(id);
        H2Bd.getInstance().delete(id);
        tableContract.delValue(id);
    }

    @Override
    public void callBackSearch(Long id, String fname, String lname, Long age) throws SQLException {
        H2Bd.getInstance().search(id, fname, lname, age);
        tableContract.setValue(H2Bd.getInstance().search(id));
    }

    @Override
    public Person eventUpdate(long id) throws SQLException {
        //return Mock.getInstance().update(id);
        return H2Bd.getInstance().search(id);
    }
}