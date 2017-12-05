package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity
@Table (name = "group_list")

public class GroupData {
    @XStreamOmitField
    @Id
    @Column (name = "group_id")
    private int id = Integer.MAX_VALUE;     ;//новый аттрибут для сравнения элементов

    @Expose
    @Column (name = "group_name")
    private String name; //аттрибуты

    @Expose
    @Column (name = "group_header")
    @Type(type="text")
    private String header; //аттрибуты

    @Expose
    @Column (name = "group_footer")
    @Type(type="text")
    private String footer; //аттрибуты

//    public GroupData(String name, String header, String footer) { //конструктор 2
//        this.id                            //не принимает параметер
//
//        this.name = name;
//        this.header = header;
//        this.footer = footer;
//    }
//
//    public GroupData(int id, String name, String header, String footer) { //конструктор
//        this.id = id;
//        this.name = name;
//        this.header = header;
//        this.footer = footer;
//    }

    public int getId() { return id; }     //новый аттрибут для сравнения элементов

    public GroupData withId (int id) {
        this.id = id;
        return this;
    } //changing name of setter to --> withId



    public GroupData withHeader(String header) {
        this.header = header;
        return this;

    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupData withName(String name) { //void changing to GroupData
        this.name = name;
        return this; //с этой строкой метод будет возвращать тот объект в котором он вызван --> for fluent interface
    }

    public String getName() {
        return name;
    } //методы возвращающие аттрибуты
    public String getHeader() {
        return header;
    } //методы возвращающие аттрибуты
    public String getFooter() {
        return footer;
    } //методы возвращающие аттрибуты

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
