import com.springapp.Main;
import com.springapp.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {
    @LocalServerPort
    private int port;

    @Autowired
    public TestRestTemplate template;
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

    @Test
    void getUser(){
        String name1 = userService.getUser(1);
        String name2 = userService.getUser(2);
        String name3 = userService.getUser(3);

        System.out.println(name1 + " " + name2 + " " + name3);

    }

    private URL base;

    @BeforeEach
    public void urlLink()throws Exception{
        this.base=new URL("http://localhost:"+port);
    }

    @Test
    //testing to show that your username and password actually work
    public void shouldAuthenticate()throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("shirley","150696#ts").getForEntity(base.toString(),String.class);
    }
}
