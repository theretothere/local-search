package sample;

import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import java.util.Observable;

public class Student {
    public int id;
    public String name;
    public int age;
    public String gender;

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public ObservableValue<String> getIdValue(){
        String idStr = String.valueOf(id);
        return new SimpleStringProperty(idStr);
    }

    public ObservableValue<String> getNameValue(){
        String s = String.valueOf(id);
        return new SimpleStringProperty(s);
    }

    public ObservableValue<String> getGenderValue(){
        String s = String.valueOf(gender);
        return new SimpleStringProperty(s);
    }

    public ObservableValue<String> getAgeValue(){
        String s = String.valueOf(age);
        return new SimpleStringProperty(s);
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
