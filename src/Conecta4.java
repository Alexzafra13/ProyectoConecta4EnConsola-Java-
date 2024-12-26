import java.util.Scanner;

public class Conecta4 {

 //Valores de la dimensión del tablero, los pongo final, para que no se pueda alterar valores
public static final int columnas = 7;
public static final int filas = 6;

    static String[][] tablero = new String[filas][columnas];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        String fichajugador = "X";
        String fichamaquina = "O";
        boolean ganar = true;

        //1. Iniciamos tablero vacío
        iniciarTablero();

        //2. Aquí empieza la partida con un bucle hasta terminar
        while (!ganar){

            imprimirTablero();


        }



    }
    public static void iniciarTablero(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = " "; // Iniciar todos los huecos con espacio para empezar partida
            }
        }
    }
    public static void imprimirTablero(){

        for (int j = 0; j < filas; j++) {
            System.out.print("  " + (j + 1) + " ");
        }
        System.out.println();
    }


    }


