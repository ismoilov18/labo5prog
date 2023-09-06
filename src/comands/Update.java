package comands;

import modals.People;
import modals.Dragon;

import java.util.Objects;

public class Update extends Command {
    public Update() {
        super("update id {element}", "Обновить значение элемента коллекции, id которого равен заданному", true, true);
    }

    @Override
    public void execute() {
        try {
            Integer id = Integer.valueOf(getArgument());

            for (Dragon p : People.people) {
                if (Objects.equals(p.getId(), id)) {
                    Dragon dragon = InputDataForm.inputTemporaryPerson();
                    if(dragon != null) {
                        p.update(dragon);
                        System.out.println("Информация пользователя с ID " + id + " успешно обновлены");
                        SaveTMP.execute();
                        People.setWasChange();
                    }
                    else System.out.println("!!! Ошибка !!!");

                    return;
                }
            }

            System.out.println("!!! Пользователь с таким ID не найден !!!");
        } catch (NumberFormatException ex) {
            System.out.println("!!! Неверный формат аргумента !!!");
        }
    }
}
