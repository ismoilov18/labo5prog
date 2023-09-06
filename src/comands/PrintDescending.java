package comands;

import modals.People;
import modals.Dragon;

import java.util.Collections;
import java.util.TreeSet;

public class PrintDescending extends Command {
    public PrintDescending() {
        super("print_descending", "Вывести элементы коллекции в порядке убывания", false, false);
    }

    @Override
    public void execute() {
        TreeSet<Dragon> tree_set = new TreeSet<>(Collections.reverseOrder());
        tree_set.addAll(People.people);

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
