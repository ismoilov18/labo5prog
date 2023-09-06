package comands;

import modals.People;
import modals.Dragon;

public class AddIfMin extends Command {
    public AddIfMin() {
        super("add_if_min {element}", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", false, true);
    }

    @Override
    public void execute() {
        if(People.people.size() > 0) {

            Dragon dragon = InputDataForm.inputTemporaryPerson();
            if(dragon != null) {
                Dragon minDragon = People.people.iterator().next();
                for(Dragon p : People.people) {
                    if(minDragon.compareTo(p) > 0) {
                        minDragon = p;
                    }
                }

                if(minDragon.compareTo(dragon) > 0) {
                    dragon.setIdToLast();
                    People.people.add(dragon);
                    System.out.println("Элемент успешно добавлен.");
                    SaveTMP.execute();
                    People.setWasChange();
                }
                else System.out.println("Не удалось добавить элемент.");
            }

            else System.out.println("!!! Ошибка !!!");

        }
        else System.out.println("Элемент не с чем сравнивать. Коллекция пуста.");
    }
}
