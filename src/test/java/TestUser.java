import com.mana.spring.domain.User;
import com.mana.spring.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    @Autowired
    private UserController userController;

    @Test
    public void getAllUsers() {

        System.out.println(userController.getAllUsers(1));

    }

    @Test
    public void getUser() {

//        System.out.println(userController.getUserByEmail("nscoder8@gmail.com"));
    }

    @Test
    public void addNewUser() {
        User user = new User();
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserEmail("JDoe@gmail.com");
        user.setUserPassword("Welcome2");

        userController.registerUser(user);
    }

    @Test
    public void reregisterDeactivatedUser() {
        User user = new User();
        user.setUserFirstName("Bob");
        user.setUserLastName("Kearns");
        user.setUserEmail("JDoe@gmail.com");
        user.setUserPassword("Welcome2");

        userController.registerUser(user);
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setUserEmail("JDoe@gmail.com");

        userController.deleteUser(user);
    }


    @Test
    public void updateUser() {
        User user = new User();
        user.setUserFirstName("John");
        user.setUserLastName("Doe");
        user.setUserEmail("JDoe@gmail.com");
        userController.updateUser(user);
    }


    @Test
    public void updateUserPW() {
        User user = new User();
        user.setUserEmail("JDoe@gmail.com");
        user.setUserPassword("MyPassword121");
        userController.updatePassword(user);
    }

}
