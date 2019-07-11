package CITY.MANAGER.controller;

import CITY.MANAGER.entity.Quartier;
import CITY.MANAGER.entity.Ville;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomUtils;
import CITY.MANAGER.entity.Quartier;



import java.util.Arrays;

@RestController
public class controller {
int i;
int j;
    @Value("appName")
    String appName = new String ("Valeurs Immobilières");


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute ("appName", appName);
        return "home";
    }

    @GetMapping("/random")
    public Object[][] arrayController(Model model) {
        Object[][] newCity = new Object[30][30];
        ville (newCity);
        model.addAttribute ("Nouvelle Ville", newCity);
        return newCity;
    }


    public static void ville(Object[][] newCity) {
        String a = "";
        for(int i = 1; i < newCity.length; i++){

            for(int j = 0; newCity[i].length > j; j++){

                Quartier quartier= new Quartier("RTE",0,1,1,0,0);


                newCity[i][j] = quartier;
                System.out.println("i" +i +"j" +j);
                System.out.println(Arrays.deepToString(newCity));
            }
        }
    }
}

