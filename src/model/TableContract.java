package model;

import java.util.List;

public interface TableContract {
    void setAllValue(List<Person> list);
    void setValue(Person pers);
    void setUpdateValue(Person pers);
    void delValue(long id);
}
