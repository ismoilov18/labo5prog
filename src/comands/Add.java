package comands;

import modals.People;
import modals.Dragon;

public class Add extends Command {
    public Add() {
        super("add {element}", "Добавить новый элемент в коллекцию", false, true);
    }

    @Override
    public void execute() {
        Dragon dragon = InputDataForm.input();
        if(dragon != null) {
            People.people.add(dragon);
            System.out.println("Добавлена в коллекцию.");
            SaveTMP.execute();
            People.setWasChange();
        }
        else System.out.println("!!! Ошибка !!!");
    }
}
