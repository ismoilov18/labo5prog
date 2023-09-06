package modals;

import java.time.LocalDateTime;

public class Dragon implements Comparable<Dragon>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0
    private String discription; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    private static Integer lastId = 0;

    public Dragon(Integer id,
                  String name,
                  Coordinates coordinates,
                  java.time.LocalDateTime creationDate,
                  Integer age,
                  String discription,
                  Country nationality,
                  Location location){
        setId(id);
        this.creationDate = creationDate;
        update(name, coordinates, age, discription, nationality, location);
    }

    public Dragon(String name,
                  Coordinates coordinates,
                  Integer age,
                  String discription,
                  Country nationality,
                  Location location){
        this.id = ++lastId;
        this.creationDate = java.time.LocalDateTime.now();
        update(name, coordinates, age, discription, nationality, location);
    }

    private void setId(Integer id){
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public void setIdToLast(){
        this.id = ++lastId;
    }
    public void update(String name,
                       Coordinates coordinates,
                       Integer age,
                       String discription,
                       Country nationality,
                       Location location){
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.discription = discription;
        this.nationality = nationality;
        this.location = location;

    }

    public void update(Dragon p){
        update(p.getName(),
                p.getCoordinates(),
                p.getAge(),
                p.getDiscription(),
                p.getNationality(),
                p.getLocation());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getAge() {
        return age;
    }

    public String getDiscription() {
        return discription;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Dragon p) {
        return (int) (this.name.compareTo(p.getName()) +
                (this.coordinates.hashCode() - p.coordinates.hashCode()) +
                (this.age - p.age));
    }

}