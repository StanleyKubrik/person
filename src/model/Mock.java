package model;

import java.util.ArrayList;
import java.util.List;

public final class Mock {
    private static Mock instance = null;
    private Long iD = 1L;
    private int index = 0;
    private List<Person> list;

    private Mock() {
        list = new ArrayList<>();
        //Long id, int index, String fname, String lname, Long age
        list.add(new Person(1L, 0, "Nikita", "Sukhonosov", 23L));
        list.add(new Person(2L, 1, "Yuriy", "Leshchenko", 25L));
        list.add(new Person(3L, 2, "Ira", "Fomina", 20L));
        list.add(new Person(4L, 3, "Petya", "Bahus", 20L));
        list.add(new Person(5L, 4, "Vitaliy", "Unnamed", 23L));
        list.add(new Person(6L, 5, "Alexandr", "Unnamed", 25L));
        list.add(new Person(7L, 6, "Dmitriy", "Penya", 23L));
        list.add(new Person(8L, 7, "Yuriy", "Boldyrev", 23L));
        list.add(new Person(9L, 8, "Igor", "Chaliy", 23L));
        list.add(new Person(10L, 9, "Kseniya", "Nakaznaya", 23L));
    }

    public static synchronized Mock getInstance() {
        if (instance == null) {
            instance = new Mock();

        }
        return instance;
    }

    //@NotNull
    public void create(Person person) {
        iD *= index + 1;
        person.setId(iD);
        person.setIndex(index);
        list.add(index, person);
        index++;
    }

    public List<Person> read() {
        return list != null ? list : new ArrayList<>();
    }

    public Person update(long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (i != 0) {
                    list.set(i, list.get(i));
                }
                return list.get(i);
            }
        }
        return null;
    }

    public Person updateUI(Person person) {
        list.get(person.getIndex()).setFname(person.getFname());
        list.get(person.getIndex()).setLname(person.getLname());
        list.get(person.getIndex()).setAge(person.getAge());
        return list.get(person.getIndex());
    }

    public void delete(long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }

}