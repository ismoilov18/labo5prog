package comands;

import modals.People;
import modals.Dragon;

import java.util.TreeSet;

public class PrintAscending extends Command {
    public PrintAscending() {
        super("print_ascending", "Вывести элементы коллекции в порядке возрастания", false, false);
    }

    @Override
    public void execute() {
        TreeSet<Dragon> tree_set = new TreeSet<>(People.people);

        for (Dragon dragon : tree_set) {
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
}
