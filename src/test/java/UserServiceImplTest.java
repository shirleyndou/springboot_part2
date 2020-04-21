import ch.qos.logback.classic.spi.IThrowableProxy;
import com.springapp.Main;
import com.springapp.User;
import com.springapp.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Main.class)
class UserServiceImplTest {

    @Autowired
   public UserService userService;

    @Test
    void addUser() {
        String name = userService.addUser(1, "shirley", "ndou");
        assertEquals("shirley", name);
    }
  @Test
    void removeUser() {
        //Can't test a void function
    }

   /* @Test
    void getUser() {
        User user = new User();
        user.setName("shirley");
        user.setSurname("ndou");
        user.setId(1);
        assertEquals(user.getId(),  userService.getUser(1));

    }*/

    @Test
    void getUser(){
        String name1 = userService.getUser(1);
        String name2 = userService.getUser(2);
        String name3 = userService.getUser(3);

        System.out.println(name1 + " " + name2 + " " + name3);

    }
    private URL base;

    @LocalServerPort
    private int port;

    public void setUserService() throws Exception {
        this.base = new URL("hhtp://localhost" + port);
    }

    @Autowired
    private TestRestTemplate template;
    @Test
    public void shouldAuthenticate(){
       /* String name = userService.addUser(1,"shirley", "ndou");
        System.out.println(name);*/
        ResponseEntity<String> response = template.withBasicAuth("spring", "secret").getForEntity(base.toString(), String.class);
    }

}
