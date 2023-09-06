package comands;
import modals.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputDataForm {

    public static ArrayList<String> executeScriptData = new ArrayList<>(7);

    public static Dragon inputTemporaryPerson(){
        Dragon dragon;
        if(executeScriptData.size() > 0) {
            dragon = executeScript("inputTemporaryPerson");
        }
        else {
            dragon = new Dragon(
                    -1,
                    inputName(),
                    inputCoordinates(),
                    java.time.LocalDateTime.now(),
                    inputAge(),
                    inputDiscription(),
                    inputNationality(),
                    inputLocation()
            );
        }

        return dragon;
    }
    public static Dragon input(){
        Dragon dragon;
        if(executeScriptData.size() > 0) {
            dragon = executeScript("input");
        }
        else {
            dragon = new Dragon(
                    inputName(),
                    inputCoordinates(),
                    inputAge(),
                    inputDiscription(),
                    inputNationality(),
                    inputLocation()
            );
        }
        return dragon;
    }

    private static Dragon executeScript(String input) {
        String name;
        Coordinates coordinates;
        Integer age;
        java.time.LocalDateTime birthday;
        String discription;
        Country nationality;
        Location location;

        try {
            System.out.println("Введите имя: " + executeScriptData.get(0));
            if (executeScriptData.get(0).length() > 0) name = executeScriptData.get(0);
            else throw new Exception();

            System.out.println("Введите координаты (формат: X;Y (X, Y - целые числа)): " + executeScriptData.get(1));
            coordinates = new Coordinates(executeScriptData.get(1));

            System.out.println("Введите рост: " + executeScriptData.get(2));
            age = Integer.parseInt(executeScriptData.get(2));
            if(age < 1) throw new Exception();

            System.out.println("Введите день рождения (может быть пустым, формат: гггг-мм-дд чч:мм:сс): " + executeScriptData.get(3));
            birthday = (executeScriptData.get(3).equals("")) ? null : LocalDateTime.parse(executeScriptData.get(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("Введите описание, " + executeScriptData.get(4));
            if (executeScriptData.get(0).length() > 0) discription = executeScriptData.get(0);
            else throw new Exception();
            System.out.println("Выберите национальность (может быть пустым, варианты: " + executeScriptData.get(5));
            nationality = (executeScriptData.get(5).equals("")) ? null : Country.valueOf(executeScriptData.get(5));

            System.out.println("Введите локацию (может быть пустым, формат: X;Y;Z (X, Z - целые числа, Y - вещественное число)): " + executeScriptData.get(6));
            location = (executeScriptData.get(6).equals("")) ? null : new Location(executeScriptData.get(6));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        if(input.equals("input"))
            return new Dragon(name, coordinates, age, discription, nationality, location);
        else
            return new Dragon(-1, name, coordinates, java.time.LocalDateTime.now(), age, discription, nationality, location);
    }

    public static String inputName() {
        String name = null;
        String input = "";
        Scanner inputReader = new Scanner(System.in);

        while(name == null || name.length() < 1) {
            System.out.print("Введите имя: ");
            input = inputReader.nextLine();
            name = input;
            if(name.length() < 1) System.out.println("!!! Поле не может быть пустым !!!");
        }
        return name;
    }
    public static Coordinates inputCoordinates(){
        Coordinates coordinates = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите координаты (формат: X;Y (X, Y - целые числа)): ");
                input = inputReader.nextLine();
                coordinates = new Coordinates(input);
            } catch (NumberFormatException ex) {
                System.out.println("!!! Некорректный формат !!!");
                error = true;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("!!! Введите X и Y !!!");
                error = true;
            }
        }
        return coordinates;
    }
    public static Integer inputAge(){
        Integer age = 0;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите рост: ");
                input = inputReader.nextLine();
                age = Integer.parseInt(input);
                if(age < 1) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("!!! Введите целое число больше 0 !!!");
                error = true;
            }
        }
        return age;
    }
    public static String inputDiscription() {
        String discriptiom = null;
        String input = "";
        Scanner inputReader = new Scanner(System.in);

        while (discriptiom == null || discriptiom.length() < 1) {
            System.out.print("Введите описание: ");
            input = inputReader.nextLine();
            discriptiom = input;
            if (discriptiom.length() < 1) System.out.println("!!! Поле не может быть пустым !!!");
        }
        return discriptiom;
    }
    public static Country inputNationality(){
        Country nationality = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Выберите национальность (может быть пустым, варианты: ");
                for (Country c : Country.values()) {
                    System.out.print(c.name() + " ");
                }
                System.out.print("): ");

                input = inputReader.nextLine();
                nationality = (input.equals("")) ? null : Country.valueOf(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("!!! Ведена строка не из списка !!!");
                error = true;
            }
        }
        return nationality;
    }
    public static Location inputLocation(){
        Location location = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите локацию (может быть пустым, формат: X;Y;Z (X, Z - целые числа, Y - вещественное число)): ");
                input = inputReader.nextLine();
                location = (input.equals("")) ? null : new Location(input);
            } catch (NumberFormatException ex) {
                System.out.println("!!! Некорректный формат !!!");
                error = true;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("!!! Введите X, Y и Z !!!");
                error = true;
            }
        }
        return location;
    }
}
