package CITY.MANAGER;




import CITY.MANAGER.controller.controller;


class matrice {
    public static void main(String[] args) {

       /* ArrayList<Integer> tab = new ArrayList<>(100);
        int length = 0;

        while (length < 100) {
            int x = RandomUtils.nextInt(1, 8);


            tab.add(x);
            length += 1;
*/
        Object[][] tableau = new Object[30][30];
        controller.ville(tableau);

    }
}

