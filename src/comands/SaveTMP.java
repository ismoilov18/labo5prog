package comands;

import modals.People;
import modals.Dragon;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class SaveTMP {
    public static void execute() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((People.TMP_PATH))))) {
            String data = "";
            for (Dragon p: People.people) {
                StringBuilder name = new StringBuilder();
                char c;
                for (int i = 0; i < p.getName().length(); ++i) {
                    c = p.getName().charAt(i);
                    if(c == '\"') {
                        name.append("\"");
                    }
                    name.append(c);
                }
                data += p.getId() + ",\"" +
                        name + "\"," +
                        p.getCoordinates().getCoordinatesForCSV() + "," +
                        p.getCreationDate() + "," +
                        p.getAge() + "," +
                        ((p.getDiscription() + "," +
                        ((p.getNationality() == null) ? null : p.getNationality().name()) + "," +
                        ((p.getLocation() == null) ? null : p.getLocation().getLocationForCSV()) + "\n"));
            }
            writer.write(data);

        } catch (Exception ex) {}
    }
}
