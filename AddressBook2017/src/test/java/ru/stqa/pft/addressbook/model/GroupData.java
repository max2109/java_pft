package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String id;//новый аттрибут для сравнения элементов
    private final String name; //аттрибуты
    private final String header; //аттрибуты
    private final String footer; //аттрибуты

    public GroupData( String name, String header, String footer) { //конструктор 2
        this.id = null;                                 //не принимает параметер
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String id, String name, String header, String footer) { //конструктор
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }


    public String getId() { return id; }     //новый аттрибут для сравнения элементов
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
