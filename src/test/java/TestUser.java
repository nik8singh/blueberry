import com.mana.spring.domain.User;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.service.EmailService;
import com.mana.spring.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ContextConfiguration({"classpath:test-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
    @Autowired
    private UserController userController;

    @Autowired
    private EmailService emailService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getAllUsers() throws Exception {

//        System.out.println(userController.getAllUsers(1));
        this.mockMvc.perform(get("/user/list/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void PasswordCheck() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("nik8singh@gmail.com");
        userDTO.setUserPassword("Welcome3");
        System.out.println(userController.checkoutLogin(userDTO));

//        System.out.println(userController.getUserByEmail("nscoder8@gmail.com"));
    }

    @Test
    public void addNewUser() {


        String[] firstName = {"John", "Kate", "Jacob", "Ian", "Scott", "Jonathan", "Carmen"};
        String[] lastName = {"Smith", "Taylor", "Zazeza", "Maillie", "Sin", "Sharma", "Doe"};
        String[] email = {"John@smith2.com", "Kate@taylor.com", "Jacob@Zazeza.gov", "Ian@Maillie.com", "Scott@Sin.net", "Jonathan@Sharma.com", "Carmen@Doe.gmail.com"};
        String[] pass = {"welcome1", "welcome1", "welcome1", "welcome1", "welcome1", "welcome1", "welcome1"};

        for (int i = 0; i < firstName.length; i++) {
            NewUserDTO user = new NewUserDTO();
            user.setUserFirstName(firstName[i]);
            user.setUserLastName(lastName[i]);
            user.setUserEmail(email[i]);
            user.setUserPassword(pass[i]);
            userController.registerAdminUser("testing", user);
        }
    }

    @Test
    public void reregisterDeactivatedUser() {
        User user = new User();
        user.setUserFirstName("Bob");
        user.setUserLastName("Kearns");
        user.setUserEmail("JDoe@gmail.com");
        user.setUserPassword("Welcome2");

//        userController.registerUser(user);
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
//        userController.updatePassword(user);
    }

    @Test
    public void getUserByEmail() {
        System.out.println(userController.getUserByEmail("nik8singh@gmail.com"));
    }

}
