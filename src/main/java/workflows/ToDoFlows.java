package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ToDoFlows extends CommonOps {

    @Step("Add New Task")
    public static void addNewTask(String taskName){
        UIActions.updateText(toDoMain.field_createTask,taskName);
        UIActions.sendKey(toDoMain.field_createTask, Keys.RETURN);


    }
    @Step("Count number of task ")
    public static int countNmTask(){
        return toDoMain.listTask.size();


    }
    @Step("Delete all tasks ")
    public static void deleteAllTasks(){

        for (int i =0 ; i< toDoMain.listTask.size();i++){

            UIActions.mouseHover(toDoMain.btn_x.get(i));
            UIActions.click(toDoMain.btn_x.get(i));
        }

    }
}
