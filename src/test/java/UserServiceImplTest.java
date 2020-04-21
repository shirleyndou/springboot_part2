import com.springapp.Main;
import com.springapp.User;
import com.springapp.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Main.class)
class UserServiceImplTest {

    @Autowired
   public UserService userService;

   /* @Test
    void addUser() {
        String name = userService.addUser(1, "shirley", "ndou");
        assertEquals("shirley", name);
    }
  @Test
    void removeUser() {
    }

    @Test
    void getUser() {
        User user = new User();
        user.setName("shirley");
        user.setSurname("ndou");
        user.setId(1);
        assertEquals(user.getId(),  userService.getUser(1));

    }*/
    @Test
    void addUser(){
        String name1 = userService.addUser(1, "shirley", "ndou");
        String name2 = userService.addUser(2, "shirley2", "ndou2");
        String name3 = userService.addUser(3, "shirley3", "ndou3");

        System.out.println(name1 + " " + name2 + " " + name3);
    }

}
