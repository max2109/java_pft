package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String name; //аттрибуты
    private final String header; //аттрибуты
    private final String footer; //аттрибуты

    public GroupData(String name, String header, String footer) { //конструктор
        this.name = name;
        this.header = header;
        this.footer = footer;
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
}
