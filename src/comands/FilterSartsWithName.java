package comands;

import modals.People;
import modals.Dragon;

public class FilterSartsWithName extends Command {
    public FilterSartsWithName() {
        super("filter_starts_with_name", "Вывести элементы, значение поля name которых начинается с заданной подстроки", true, false);
    }

    @Override
    public void execute() {
        for (Dragon dragon : People.people) {
            if(dragon.getName().startsWith(getArgument())){
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
}
