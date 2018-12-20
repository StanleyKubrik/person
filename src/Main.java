import com.google.gson.Gson;
import model.JSonParser;
import model.Person;
import org.json.JSONException;
import view.Frame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JSONException, FileNotFoundException {
        new Frame();
//        List<Person> list = new ArrayList<>();
//        //Long id, int index, String fname, String lname, Long age
//        list.add(new Person(1L, 0, "Nikita", "Sukhonosov", 23L));
//        list.add(new Person(2L, 1, "Yuriy", "Leshchenko", 25L));
//        list.add(new Person(3L, 2, "Ira", "Fomina", 20L));
//        list.add(new Person(4L, 3, "Petya", "Bahus", 20L));
//
//        System.out.println(new JSonParser().toJSon(list));
//
//        List<Person> people = new JSonParser().fromJSon(new JSonParser().toJSon(list));
//        System.out.println(people);
//        for (Person p : people) {
//            System.out.println(p);
//        }
    }
}