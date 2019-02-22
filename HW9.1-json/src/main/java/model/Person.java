package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sergey
 * created on 27.01.19.
 */
//implements Serializable - обязательное условие для сериализации
public class Person implements Serializable {
    public final int age;
    public final String name;
    public final Phone phone = new Phone(12, "322-22-33");
    public int[] array = new int[5];
    public List<String> list = new ArrayList<>();
    private transient final String hidden = "hiddenField"; //transient - поле будет пропущено при сериализации

    // Обратите внимание на то, сколько раз вызывается констурктор и сколько объектов создается
    public Person(int age, String name) {
        System.out.println("new Person");
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " age: " + age + " hidden:" + hidden;
    }
}