import java.util.Random;
import java.util.Scanner;
//Juego Conecta 4
public class Conecta4 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    //Valores de la dimensión del tablero, los pongo final, para que no se pueda alterar valores
    public static final int columnas = 7;
    public static final int filas = 6;

    static String[][] tablero = new String[filas][columnas];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        String fichajugador = "X";
        String fichamaquina = "O";
        boolean ganar = false;

        //1. Iniciamos tablero vacío
        iniciarTablero();

        //2. Aquí empieza la partida con un bucle hasta terminar
        while (!ganar) {

            //Turno del jugador
            imprimirTablero();

            insertarFicha(fichajugador);

            ganar = verificarVictoria(fichajugador);

            //Para cuando gana el jugador

            if (ganar) {
                System.out.println("¡Has Ganado!");
                break;
            }
            //Turno de la IA

            imprimirTablero();

            comprobarColumnasFilasyDiagonal(fichajugador, fichamaquina);

            insertarFichaMaquina(fichamaquina);

            ganar = verificarVictoria(fichamaquina);

            if (ganar) {

                System.out.println("La Maquína ha ganado");

                break;
            }



        }


    }

    public static void comprobarColumnasFilasyDiagonal(String fichajugador, String fichamaquina) {
        // Aquí comprobamos las filas de la parte baja del tablero hacia arriba
        for (int i = filas - 1; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {

                // Verificamos si hay 3 fichas consecutivas del jugador en la fila para colocar una ficha delante o detrás
                if (j + 2 < columnas && tablero[i][j].equals(fichajugador)
                        && tablero[i][j + 1].equals(fichajugador) && tablero[i][j + 2].equals(fichajugador)) {

                    // Bloquea hacia la derecha si la celda está vacía y no está "en el aire"
                    if (j + 3 < columnas && tablero[i][j + 3].equals(" ") &&
                            // Verifica que no haya un espacio vacío debajo para que la ficha no quede "volando"
                            (i == filas - 1 || !tablero[i + 1][j + 3].equals(" "))) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i][j + 3] = fichamaquina;
                        return;
                    }

                    // Bloquea hacia la izquierda si la celda está vacía y no está "en el aire"
                    if (j - 1 >= 0 && tablero[i][j - 1].equals(" ") &&
                            // Verifica que no haya un espacio vacío debajo para que la ficha no quede "volando"
                            (i == filas - 1 || !tablero[i + 1][j - 1].equals(" "))) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i][j - 1] = fichamaquina;
                        return;
                    }
                }
            }
        }
    }


    public static void insertarFicha(String ficha) {
        int columna;

        do {
            System.out.print("Ingresa el número de la columna para insertar ficha (1-7): ");
            columna = sc.nextInt() - 1;
        } while (columna < 0 || columna >= 7 || !tablero[0][columna].equals(" "));

        //Para replicar el efecto de gravedad de la ficha, cayendo en el hueco vacío de la columna seleccionada
        //Comprueba cada celda para ver si al estar vacía puede ser insertada
        for (int i = filas - 1; i >= 0; i--) {
            if (tablero[i][columna].equals(" ")) {
                tablero[i][columna] = ficha;
                break;
            }
        }
    }


    public static void iniciarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = " "; // Iniciar todos los huecos con espacio para empezar partida
            }
        }
    }

    public static void imprimirTablero() {
        // Imprime los números de las columnas
        for (int i = 1; i <= columnas; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();

        // Imprime el tablero con líneas verticales
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("| " + tablero[i][j] + " ");
            }
            System.out.println("|");
        }

        // Línea final para cerrar el tablero
        for (int j = 0; j < columnas; j++) {
            System.out.print("----");
        }
        System.out.println("-");
    }


    public static boolean verificarVictoria(String ficha) {
        // Verifica filas y columnas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j + 3 < columnas &&
                        tablero[i][j].equals(ficha) && tablero[i][j + 1].equals(ficha) &&
                        tablero[i][j + 2].equals(ficha) && tablero[i][j + 3].equals(ficha)) {
                    return true;
                }
                if (i + 3 < filas &&
                        tablero[i][j].equals(ficha) && tablero[i + 1][j].equals(ficha) &&
                        tablero[i + 2][j].equals(ficha) && tablero[i + 3][j].equals(ficha)) {
                    return true;
                }
            }
        }

        // Verifica diagonales (de arriba-izquierda hacia abajo-derecha)
        for (int i = 0; i < filas - 3; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j].equals(ficha) && tablero[i + 1][j + 1].equals(ficha) &&
                        tablero[i + 2][j + 2].equals(ficha) && tablero[i + 3][j + 3].equals(ficha)) {
                    return true;
                }
            }
        }

        // Verifica diagonales (de abajo-izquierda a arriba-derecha)
        for (int i = 3; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (tablero[i][j].equals(ficha) && tablero[i - 1][j + 1].equals(ficha) &&
                        tablero[i - 2][j + 2].equals(ficha) && tablero[i - 3][j + 3].equals(ficha)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void insertarFichaMaquina(String ficha) {
        int columna;
        do {
            columna = rd.nextInt(columnas);
        } while (!tablero[0][columna].equals(" "));
        for (int i = filas - 1; i >= 0; i--) {
            if (tablero[i][columna].equals(" ")) {
                tablero[i][columna] = ficha;
                break;
            }
        }
    }
}


