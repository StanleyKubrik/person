package control;

import model.H2Bd;
import model.Mock;
import model.Person;
import model.TableContract;
import view.factory.*;

import java.sql.SQLException;


public class Controler  implements IControler, DialogCreate.DialogCreateCallBack,
        DialogUpdate.DialogUpdateCallBack, DialogDelete.DialogDeleteCallBack {
    //То что обновляет таблицу
    private TableContract tabelConfig;
    // Интерфейс фабрики
    private IDialogFactory iDialogFactory;



    public Controler(TableContract tabelConfig) {
        // Получаем то что обновляет таблицу из панели
        this.tabelConfig = tabelConfig;

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
        //tabelConfig.setAllValue(Mock.getInstance().read());
        tabelConfig.setAllValue(H2Bd.getInstance().read());
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
    public void callBackCreate(Person person) {
        // обновляем таблицу , записываем в БД
        H2Bd.getInstance().create(person);
        //Mock.getInstance().create(person);
        tabelConfig.setValue(person);
    }

    @Override
    public void callBackUpdate(Person person) throws SQLException {
        // обновляем таблицу на изменение
        //tabelConfig.setUpdateValue(Mock.getInstance().updateUI(person));
        H2Bd.getInstance().update(person);
        tabelConfig.setUpdateValue(person);
    }

    @Override
    public void callBackDelete(long id) throws SQLException {
        tabelConfig.delValue(id);
        //Mock.getInstance().delete(id);
        H2Bd.getInstance().delete(id);
    }

    @Override
    public Person eventUpdate(long id) throws SQLException {
        //return Mock.getInstance().update(id);
        return H2Bd.getInstance().search(id);
    }
}