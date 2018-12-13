package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Bd {
    private static H2Bd instance = null;

    private H2Bd() {
    }

    public static synchronized H2Bd getInstance() {
        if (instance == null) {
            instance = new H2Bd();
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Statement execute() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "").createStatement();
    }

    public Person search(long id) throws SQLException {
        ResultSet rs = execute().executeQuery("SELECT * FROM Person WHERE ID=" + id);
        rs.next();
        Person p = new Person(rs.getLong("ID"),
                rs.getString("FNAME"),
                rs.getString("LNAME"),
                rs.getLong("AGE"));
        return p;
    }

    public void create(Person person) {
        try {
            ResultSet rs = execute().executeQuery("SELECT MAX(id) FROM Person");
            rs.last();
            Long id = rs.getLong(1);
            person.setId(++id);
            execute().executeUpdate("insert into Person values(" + person.getId() +
                    ",'" + person.getFname() + "','" + person.getLname() + "'," + person.getAge() + ")");
            execute().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        try {
            ResultSet rs = execute().executeQuery("SELECT * FROM Person");
            while (rs.next()){
                personList.add(new Person(rs.getLong("ID"),
                        rs.getString("FNAME"),
                        rs.getString("LNAME"),
                        rs.getLong("AGE")));
            }
            execute().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public void update(Person person) throws SQLException {
        execute().executeUpdate("Update Person set fname='" + person.getFname()+"', " +
                "lname='" + person.getLname() + "', " +
                "age=" + person.getAge()+" " +
                "Where ID=" + person.getId());
        execute().close();
    }

    public void delete(long id) throws SQLException {
        execute().executeUpdate("DELETE FROM Person WHERE ID =" + id);
        execute().close();
    }
}