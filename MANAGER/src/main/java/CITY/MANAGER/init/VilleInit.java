package CITY.MANAGER.init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import CITY.MANAGER.dao.VilleDao;
import CITY.MANAGER.entity.Ville;


@Component
public class VilleInit {
    private VilleDao villeDao;

}