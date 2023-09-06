package comands;

import modals.People;
import modals.Dragon;

public class RemoveLower extends Command {
    public RemoveLower() {
        super("remove_lower {element}", "Удалить из коллекции все элементы, меньшие, чем заданный", false, true);
    }

    @Override
    public void execute() {
        if(People.people.size() > 0) {
            Dragon dragon = InputDataForm.inputTemporaryPerson();

            if(dragon != null) {
                int removeCount = 0;
                for (Dragon p : People.people) {
                    if(p.compareTo(dragon) < 0) {
                        People.people.remove(p);
                        removeCount++;
                    }
                }

                System.out.println("Удалено " + removeCount + " колекции.");
                if(removeCount > 0) {
                    SaveTMP.execute();
                    People.setWasChange();
                }
            }
            else System.out.println("!!! Ошибка !!!");

        }
        else System.out.println("Элемент не с чем сравнивать. Коллекция пуста.");
    }
}
