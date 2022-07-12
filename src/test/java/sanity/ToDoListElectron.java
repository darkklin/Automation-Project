package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.ToDoFlows;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description = "Test01 - add new task")
    @Description("This test add new task and verify the list size  ")
    public void test01_createNewTask()  {
        ToDoFlows.addNewTask("Just Do it");
        Verifications.verifyNumber(ToDoFlows.countNmTask(),1);
    }

    @Test(description = "Test01 - add new tasks")
    @Description("This test add new task and verify the list size  ")
    public void test01_createNewTasks() {
        ToDoFlows.addNewTask("Just Do it");
        ToDoFlows.addNewTask("Just Do it");
        ToDoFlows.addNewTask("Just Do it");
        Verifications.verifyNumber(ToDoFlows.countNmTask(),3);

    }
}
