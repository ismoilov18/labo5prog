package comands;

import modals.People;
import modals.Dragon;

import java.util.HashSet;

public class Show extends Command {
    public Show() {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении", false, false);
    }

    @Override
    public void execute() {
        HashSet<Dragon> people = People.people;
        if(people.size() > 0) {
            for (Dragon dragon : people) {
                System.out.println(dragon.getId() + " | " +
                        dragon.getName() + " | " +
                        dragon.getCoordinates().getCoordinates() + " | " +
                        dragon.getCreationDate() + " | " +
                        dragon.getAge() + " | " +
                        dragon.getDiscription() + " | " +
                        dragon.getNationality() + " | " +
                        ((dragon.getLocation() == null) ? null : dragon.getLocation().getLocation()));
            }
        }
        else {
            System.out.println("Коллекция пуста!");
        }
    }
}
