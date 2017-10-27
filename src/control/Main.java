/* classe principal do projeto */

package control;


import view.CustomSplashScreen;

public class Main {

    /*Manifest-Version: 1.0
SplashScreen-Image: logo.png
X-COMMENT: Main-Class will be added automatically by build*/


	public static void main(String[] args) {
       loading();



    }





    //metodo para trabalhar com chamda da classe de splash
    //loading nome pq sera o que vai carregar o logotipo antes de iniciar

    static void loading(){
        CustomSplashScreen.splashInit();

        for (int i = 0; i < 10; i++) {
            CustomSplashScreen.splashProgress(i * 20);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

	}


