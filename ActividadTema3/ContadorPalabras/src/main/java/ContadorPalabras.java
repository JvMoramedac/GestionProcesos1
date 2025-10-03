
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContadorPalabras {
    public static void main(String[] args) {

        //Creamos el isr y el br para interactuar con los archivos
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String Linea = null;
        //Estructura try catch para la ejecución
        try {
            int[] numeros;
            //Bucle para convertir los numeros
            while ((Linea = br.readLine()) != null) {

                //Crea el array para guardar los numeros individualmente
                String[] Dato = Linea.split(" ");

                //Creamos el array con la longitud del array con los numeros
                numeros = new int[Dato.length];

                //Convertimos a numeros los String guardados como números
                for (int i = 0; i < numeros.length; i++) {
                    numeros[i] = Integer.parseInt(Dato[i]);
                }
                Arrays.sort(numeros);
                for (int i = 0; i < numeros.length; i++) {
                    System.out.print(numeros[i] + " ");
                }
                System.out.println("");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
                isr.close();
            } catch (IOException e2) {
                System.out.println("Error en ordenarNumeros.");
            }
        }


    }


}