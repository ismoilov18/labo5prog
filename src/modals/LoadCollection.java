package modals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LoadCollection {
    public static void load(File file) {
        String fileName = file.getName();
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        {
            dict.put("tmp.csv", new ArrayList<String>(Arrays.asList(
                    "Идёт восстановление коллекции ",
                    "Коллекций успешно восстановлены. Восстановлено ",
                    "Ошибка восстановлении ")));
            dict.put("data.csv", new ArrayList<String>(Arrays.asList(
                    "Идёт загрузка коллекции ",
                    "Коллекций успешно загружена. Добавлено ",
                    "Ошибка загрузки ")));
        }
        try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            System.out.println(dict.get(fileName).get(0) + file.getAbsolutePath());
            String nextLine;
            Dragon dragon;

            ArrayList<String> errors = new ArrayList<>();
            while ((nextLine = inputStreamReader.readLine()) != null) {
                dragon = csvToPerson(nextLine);
                if(dragon != null) People.people.add(dragon);
                else errors.add(nextLine);
            }

            System.out.println(dict.get(fileName).get(1) + People.people.size() + " элементов.");

            if(errors.size() > 0) {
                System.out.println(dict.get(fileName).get(2) + errors.size() + " коллекций:");
                for (String e: errors) {
                    System.out.println("- " + e);
                }
            }
        }
        catch (Exception e) {

        }
    }

    public static Dragon csvToPerson(String str){
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        boolean brackets = false;
        char current_symbol;
        for(int i = 0; i < str.length(); i++) {
            current_symbol = str.charAt(i);
            if(current_symbol == '\"') {
                if(!brackets || (i + 1 != str.length() && str.charAt(i + 1) != '\"')) {
                    brackets = !brackets;
                    continue;
                }

                else if(i + 1 != str.length() && str.charAt(i + 1) == '\"') {
                    i++;
                }
                else {
                    return null;
                }
            }
            else if(current_symbol == ',' && !brackets) {
                ans.add(tmp.toString());
                tmp = new StringBuilder();
                continue;
            }
            tmp.append(current_symbol);

        }
        ans.add(tmp.toString());
        if(ans.size() < 9) return null;

        try {
            Integer id = Integer.valueOf(ans.get(0));
            String name = ans.get(1);
            Coordinates coordinates = new Coordinates(ans.get(2));
            java.time.LocalDateTime creationDate = LocalDateTime.parse(ans.get(3));
            Integer age = Integer.parseInt(ans.get(4));
            String discription = ans.get(6);
            Country nationality = (ans.get(7).equals("null")) ? null : Country.valueOf(ans.get(7));
            Location location = (ans.get(8).equals("null")) ? null : new Location(ans.get(8));

            return new Dragon(id, name, coordinates, creationDate, age, discription, nationality, location);
        }
        catch (Exception e) {
            return null;
        }
    }
}
