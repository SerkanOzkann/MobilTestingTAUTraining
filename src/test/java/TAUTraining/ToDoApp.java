package TAUTraining;

import TAUTraining.TestBase;
import org.junit.Test;

import java.net.MalformedURLException;

public class ToDoApp extends TestBase {
    CreateTaskPage createTaskPage ;
    TasksListPage tasksListPage;

    @Test
    public void test_add_task() throws MalformedURLException {
         Android_setUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing my course ASAP");
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }

}
