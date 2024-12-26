import java.util.Scanner;

public class Conecta4 {
   static Scanner sc = new Scanner(System.in);

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

            insertarFicha(fichajugador);


        }



    }

    private static void insertarFicha(String ficha) {
        int columna;

        do {
            System.out.print("Ingresa el número de la columna para insertar ficha (1-7): ");

                columna = sc.nextInt() -1;

        }while (columna < 0 || columna >=7 || tablero[0][columna] !=" ");

        //Para replicar el efecto de gravedad de la ficha, cayendo en el hueco vacío de la columna seleccionada
        //Comprueba cada celda para ver si al estar vacía puede ser insertada
        for (int i = filas; i >=0; i--){
            if (tablero[i][columna] == " "){
                tablero[i][columna] = ficha;
            }
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
        // Para enumerar las columnas
        for (int i = 0; i < filas; i++) {
            System.out.print("  " + (i + 1) + " ");
        }
        System.out.println();

        for(int j = 0; j < filas; j++){
            System.out.println("----");
        }
        System.out.println("-");
    }

    }


