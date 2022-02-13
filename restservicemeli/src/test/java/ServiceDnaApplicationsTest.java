import com.meli.service.ServiceDnaApplications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Clase para los test unitarias de la
 * ServiceDnaApplications.
 *
 * @author eduardo guerere
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceDnaApplications.class)
public class ServiceDnaApplicationsTest {

    @Test
    public void contextLoads() {
        ServiceDnaApplications.main(new String[]{
        });
    }
}