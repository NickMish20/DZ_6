package DZ_6;

public class Notebook {
    
    String name;
    int ram;
    int memory;
    String os;
    String color;
    Notebook(String name,int ram, int memory, String os, String color){
        this.name = name;
        this.ram = ram;
        this.memory = memory;
        this.os = os;
        this.color = color;
    }
    void printNotebookes(Notebook n){
        System.out.printf("Название: %s,\tОЗУ %d,\tпамять ЖД %d,\tОС %s,\tцвет %s \n", name, ram, memory, os, color);
    }
}