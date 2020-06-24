import com.mana.spring.domain.User;
import com.mana.spring.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

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
        user.setUserFirstName("ADMIN2");
        user.setUserLastName("Doe");
        user.setUserEmail("admin@test.com");
        user.setUserPassword("test");

//        userController.registerAdminUser(user);
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

        userController.deactivateUser(user);
    }


    @Test
    public void updateUser() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
    }


    @Test
    public void updateUserPW() {
        User user = new User();
        user.setUserEmail("JDoe@gmail.com");
        user.setUserPassword("MyPassword121");
        userController.updatePassword(user);
    }

}
