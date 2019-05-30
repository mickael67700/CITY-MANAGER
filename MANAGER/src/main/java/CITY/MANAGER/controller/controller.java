package CITY.MANAGER.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomUtils;

@RestController
public class controller {

    @Value("Valeurs Immobilières")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute ("appName", appName);
        return "home";
    }

    @GetMapping("/random")
    public Object[][] arrayController(Model model) {
        Object[][] matrice = new Object[30][30];
        ville (matrice);
        model.addAttribute ("matrice", matrice);
        return matrice;
    }


    public static void ville(Object[][] matrice) {
        String a = new String();
        for(int i = 0; i < matrice.length; i++){

            for(int j = 0; matrice[i].length > j; j++){
                int x = RandomUtils.nextInt(1, 9);

                if (x == 1) { a="RIV";}
                if (x == 2) { a="RES";}
                if (x == 3) { a="RTE";}
                if (x == 4) { a="RTB";}
                if (x == 5) { a="ECL";}
                if (x == 6) { a="COM";}
                if (x == 7) { a="POL";}
                if (x == 8) { a="FOR";}
                if (x == 9) { a="EGL";}
                if (x ==10) { a="HOP";}

                matrice[i][j] = a;

                //System.out.println(Arrays.deepToString(matrice));
            }
        }
    }
}

