/* classe principal do projeto */

package control;


import view.CustomSplashScreen;
import view.Login;

public class Main {


    public static void main(String[] args) {

         loading();

        new Login();



    }


    //metodo para trabalhar com chamda da classe de splash
    //loading nome pq sera o que vai carregar o logotipo antes de iniciar

    static void loading() {
        CustomSplashScreen.splashInit();

        for (int i = 0; i < 50; i++) {
            CustomSplashScreen.splashProgress(i * 2);
            try {
                Thread.sleep(2);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }


    }

}


