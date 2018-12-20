package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSonParser {
    public String toJSon(List<Person> personList) throws JSONException {
        JSONArray jsonArray = new JSONArray(personList);
        return jsonArray.toString();
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < personList.size(); i++) {
//            jsonArray.put(new JSONObject().put(String.valueOf(personList.get(i).getId()), personList.get(i)));
//        }
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("data", jsonArray);
//        return jsonObject.toString();
    }

    public List<Person> fromJSon(String json) throws JSONException {
        List<Person> personList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            personList.add(new Person(object.getLong("id"),
                    object.getInt("index"),
                    object.getString("fname"),
                    object.getString("lname"),
                    object.getLong("age")));
        }
        return personList;
    }
}