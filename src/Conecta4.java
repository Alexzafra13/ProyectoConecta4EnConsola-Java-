import java.util.Random;
import java.util.Scanner;
//Juego Conecta 4
public class Conecta4 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    // Variable de control
    static boolean fichaInsertada;


    //Valores de la dimensión del tablero, los pongo final, para que no se pueda alterar valores
    public static final int columnas = 7;
    public static final int filas = 6;

    static String[][] tablero = new String[filas][columnas];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        String fichajugador = "X";
        String fichamaquina = "O";
        boolean ganar;
        String partidanueva;


        System.out.println("""
                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
                █░██░██░██░██░██░██░██░██░██░░░░░░░░░░█
                █░██░██░██░██░██░██░██░██░██░░░░░░░░░░█
                █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                ░░█░░░░█▀▀▀█░█▀▀█░█▀▀▄░▀█▀░█▄░░█░█▀▀█░░
                ░░█░░░░█░░░█░█▄▄█░█░░█░░█░░█░█░█░█░▄▄░░
                ░░█▄▄█░█▄▄▄█░█░░█░█▄▄▀░▄█▄░█░░▀█░█▄▄█░░
                ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░""");

        System.out.println();

        System.out.println("""
                         ────────────────────────────────────────────────      \s
                ──────── │                 ┌─────────┐                  │───────
                \\                          │CONECTA-4│                         /
                 \\       │                 └─────────┘                  │     /\s
                 /       ────────────────────────────────────────────────     \\\s
                /__________)                                        (__________\\""");




        do {
            System.out.println("""
                Elija un modo de juego:
                1. Modo Fácil
                2. Modo Medio
                3. Modo Experto
                4. Modo Demencial
                """);

            menu = sc.nextInt();

            switch (menu) {


                case 1:

                    System.out.println("Modo Fácil");

                    ganar = false;

                    iniciarTablero();

                    // MODO FÁCIL
                    while (!ganar) {

                        //Turno del jugador
                        imprimirTablero();

                        insertarFicha(fichajugador);

                        ganar = verificarVictoria(fichajugador);

                        //Para cuando gana el jugador

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    .    ..:+$&&&&&&&&Xx$&&&&&&&&&&&&&&&&+ .;:.   \s
                                           :+ :;;;;;;:;++;;;;;;;:;;;;;;::x        \s
                                           .$                            $.       \s
                                           .$.      ··············      .$.       \s
                                           .&:      :¡HAS GANADO!:      :$ .      \s
                                         . .&.      ··············      ;X .;     \s
                                         :  $.                          ;$  :     \s
                                         ...&                            & ..     \s
                                           .Xx$& &&&$  &&&&&&$  .&& :&&$x$        \s
                                    .       ;$&x+&  & &&&&&&&&& &;&& &&&$;   ..   \s
                                    :     .:     & && && ¬ ¬ && & &&       :. .   \s
                                    .     . ..   && & &&& o && && &X    .:. ...   \s
                                          :;;.    &  &X &&&&& && &&     :  :.     \s
                                                  x&&  + $&    &&&      .::       \s
                                                    &&&&     &&&X                 \s
                                           .;;.        &  . +&    :.              \s
                                          .:  .     .  &&   &&  :  .     .;;;.    \s
                                        ... :;.     .  &&   && . :;.     .. ..    :
                                        . .:.       .  &&   &&  ..       .;+;.    ;
                                        ..            $& &+;&&                    :
                                                      && &;& &&                   \s
                                     .::...::......  ;& && &x&&  :.........;+:.   \s
                                    :.....:;;;;;;;:  && &  x& &+ ;;:;:...;+:...::::
                                    .   ...          & &.   &&&&         .  .  ...:
                                    ...::.  ..      &&;&     & &     .::. ..:...  \s
                                    :..    .......      :xXx & &   .. ...    .... \s
                                    :      :.  ...:&&&&X     & &&&...   ::     .: \s
                                                   +  $       & ..                \s
                                    &&&&&&&&&&&&&&&X   &&&&&&&   &&&&&&&&&&&&&&&&&&
                                    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&""");
                            break;
                        }
                        //Turno de la IA

                        imprimirTablero();

                        insertarFichaMaquina(fichamaquina);

                        ganar = verificarVictoria(fichamaquina);

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    ________________                                     \s
                                       |'-.--._ _________:                               \s
                                       |  /    |  __    __\\         +====================+
                                       | |  _  | [\\_\\= [\\_\\         |LA MAQUINA HA GANADO|
                                       | |.' '. \\.........|         +====================+
                                       | ( <)  ||:       :|_                             \s
                                        \\ '._.' | :.....: |_(o                           \s
                                         '-\\_   \\ .------./                              \s
                                         _   \\   ||.---.||  _                            \s
                                        / \\  '-._|/\\n~~\\n' | \\                           \s
                                       (| []=.--[===[()]===[) |                          \s
                                       <\\_/  \\_______/ _.' /_/                           \s
                                       ///            (_/_/                              \s
                                       |\\\\            [\\\\                                \s
                                       ||:|           | I|                               \s
                                       |::|           | I|                               \s
                                       ||:|           | I|                               \s
                                       ||:|           : \\:                               \s
                                       |\\:|            \\I|                               \s
                                       :/\\:            ([])                              \s
                                       ([])             [|                               \s
                                        ||              |\\_                              \s
                                       _/_\\_            [ -'-.__                         \s
                                      <]   \\>            \\_____.>                        \s
                                        \\__/                                             \s""");

                            break;
                        }


                    }
                    break;
                //------------------------------------------------------------------------------------------------------
                case 2:

                    System.out.println("Modo Medio");

                    ganar = false;

                    iniciarTablero();

                    // MODO MEDIO
                    while (!ganar) {

                        //Turno del jugador
                        imprimirTablero();

                        insertarFicha(fichajugador);

                        ganar = verificarVictoria(fichajugador);

                        //Para cuando gana el jugador

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    .    ..:+$&&&&&&&&Xx$&&&&&&&&&&&&&&&&+ .;:.   \s
                                           :+ :;;;;;;:;++;;;;;;;:;;;;;;::x        \s
                                           .$                            $.       \s
                                           .$.      ··············      .$.       \s
                                           .&:      :¡HAS GANADO!:      :$ .      \s
                                         . .&.      ··············      ;X .;     \s
                                         :  $.                          ;$  :     \s
                                         ...&                            & ..     \s
                                           .Xx$& &&&$  &&&&&&$  .&& :&&$x$        \s
                                    .       ;$&x+&  & &&&&&&&&& &;&& &&&$;   ..   \s
                                    :     .:     & && && ¬ ¬ && & &&       :. .   \s
                                    .     . ..   && & &&& o && && &X    .:. ...   \s
                                          :;;.    &  &X &&&&& && &&     :  :.     \s
                                                  x&&  + $&    &&&      .::       \s
                                                    &&&&     &&&X                 \s
                                           .;;.        &  . +&    :.              \s
                                          .:  .     .  &&   &&  :  .     .;;;.    \s
                                        ... :;.     .  &&   && . :;.     .. ..    :
                                        . .:.       .  &&   &&  ..       .;+;.    ;
                                        ..            $& &+;&&                    :
                                                      && &;& &&                   \s
                                     .::...::......  ;& && &x&&  :.........;+:.   \s
                                    :.....:;;;;;;;:  && &  x& &+ ;;:;:...;+:...::::
                                    .   ...          & &.   &&&&         .  .  ...:
                                    ...::.  ..      &&;&     & &     .::. ..:...  \s
                                    :..    .......      :xXx & &   .. ...    .... \s
                                    :      :.  ...:&&&&X     & &&&...   ::     .: \s
                                                   +  $       & ..                \s
                                    &&&&&&&&&&&&&&&X   &&&&&&&   &&&&&&&&&&&&&&&&&&
                                    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&""");
                            break;
                        }
                        //Turno de la IA

                        // Reiniciamos la condición en cada turno para que compruebe cada turno de nuevo
                        fichaInsertada = false;

                        imprimirTablero();

                        if (!fichaInsertada){
                            comprobarFilas(fichajugador, fichamaquina);
                        }

                        if (!fichaInsertada){
                            comprobarColumnas(fichajugador, fichamaquina);
                        }

                        if (!fichaInsertada) {
                            comprobarDiagonales(fichajugador, fichamaquina);
                        }

                        if (!fichaInsertada) {
                            // Solo insertar ficha si no se insertó en las funciones anteriores
                            insertarFichaMaquina(fichamaquina); }

                        ganar = verificarVictoria(fichamaquina);

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    ________________                                     \s
                                      |'-.--._ _________:                               \s
                                      |  /    |  __    __\\         +====================+
                                      | |  _  | [\\_\\= [\\_\\         |LA MAQUINA HA GANADO|
                                      | |.' '. \\.........|         +====================+
                                      | ( <)  ||:       :|_                             \s
                                       \\ '._.' | :.....: |_(o                           \s
                                        '-\\_   \\ .------./                              \s
                                        _   \\   ||.---.||  _                            \s
                                       / \\  '-._|/\\n~~\\n' | \\                           \s
                                      (| []=.--[===[()]===[) |                          \s
                                      <\\_/  \\_______/ _.' /_/                           \s
                                      ///            (_/_/                              \s
                                      |\\\\            [\\\\                                \s
                                      ||:|           | I|                               \s
                                      |::|           | I|                               \s
                                      ||:|           | I|                               \s
                                      ||:|           : \\:                               \s
                                      |\\:|            \\I|                               \s
                                      :/\\:            ([])                              \s
                                      ([])             [|                               \s
                                       ||              |\\_                              \s
                                      _/_\\_            [ -'-.__                         \s
                                     <]   \\>            \\_____.>                        \s
                                       \\__/                                             \s""");

                            break;
                        }


                    }
                    break;

                //-----------------------------------------------------------------------------------------------------
                case 3:
                    System.out.println("Modo Difícil");

                    ganar = false;

                    iniciarTablero();

                    // MODO DIFÍCIL

                    while (!ganar) {

                        //Turno del jugador
                        imprimirTablero();

                        insertarFicha(fichajugador);

                        ganar = verificarVictoria(fichajugador);

                        //Para cuando gana el jugador

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    .    ..:+$&&&&&&&&Xx$&&&&&&&&&&&&&&&&+ .;:.   \s
                                           :+ :;;;;;;:;++;;;;;;;:;;;;;;::x        \s
                                           .$                            $.       \s
                                           .$.      ··············      .$.       \s
                                           .&:      :¡HAS GANADO!:      :$ .      \s
                                         . .&.      ··············      ;X .;     \s
                                         :  $.                          ;$  :     \s
                                         ...&                            & ..     \s
                                           .Xx$& &&&$  &&&&&&$  .&& :&&$x$        \s
                                    .       ;$&x+&  & &&&&&&&&& &;&& &&&$;   ..   \s
                                    :     .:     & && && ¬ ¬ && & &&       :. .   \s
                                    .     . ..   && & &&& o && && &X    .:. ...   \s
                                          :;;.    &  &X &&&&& && &&     :  :.     \s
                                                  x&&  + $&    &&&      .::       \s
                                                    &&&&     &&&X                 \s
                                           .;;.        &  . +&    :.              \s
                                          .:  .     .  &&   &&  :  .     .;;;.    \s
                                        ... :;.     .  &&   && . :;.     .. ..    :
                                        . .:.       .  &&   &&  ..       .;+;.    ;
                                        ..            $& &+;&&                    :
                                                      && &;& &&                   \s
                                     .::...::......  ;& && &x&&  :.........;+:.   \s
                                    :.....:;;;;;;;:  && &  x& &+ ;;:;:...;+:...::::
                                    .   ...          & &.   &&&&         .  .  ...:
                                    ...::.  ..      &&;&     & &     .::. ..:...  \s
                                    :..    .......      :xXx & &   .. ...    .... \s
                                    :      :.  ...:&&&&X     & &&&...   ::     .: \s
                                                   +  $       & ..                \s
                                    &&&&&&&&&&&&&&&X   &&&&&&&   &&&&&&&&&&&&&&&&&&
                                    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&""");
                            break;
                        }
                        //Turno de la IA
                        fichaInsertada = false;

                        imprimirTablero();

                        if (!fichaInsertada){
                            preveerJugadaFila(fichajugador, fichamaquina);
                        }
                        if(!fichaInsertada){
                            comprobarFilas(fichajugador, fichamaquina);
                        }
                        if (!fichaInsertada){
                            comprobarColumnas(fichajugador, fichamaquina);
                        }
                        if (!fichaInsertada){
                            comprobarDiagonales(fichajugador, fichamaquina);
                        }


                        if (!fichaInsertada) {
                            // Solo insertar ficha si no se insertó en las funciones anteriores
                            insertarFichaMaquina(fichamaquina); }

                        ganar = verificarVictoria(fichamaquina);

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    ________________                                     \s
                                       |'-.--._ _________:                               \s
                                       |  /    |  __    __\\         +====================+
                                       | |  _  | [\\_\\= [\\_\\         |LA MAQUINA HA GANADO|
                                       | |.' '. \\.........|         +====================+
                                       | ( <)  ||:       :|_                             \s
                                        \\ '._.' | :.....: |_(o                           \s
                                         '-\\_   \\ .------./                              \s
                                         _   \\   ||.---.||  _                            \s
                                        / \\  '-._|/\\n~~\\n' | \\                           \s
                                       (| []=.--[===[()]===[) |                          \s
                                       <\\_/  \\_______/ _.' /_/                           \s
                                       ///            (_/_/                              \s
                                       |\\\\            [\\\\                                \s
                                       ||:|           | I|                               \s
                                       |::|           | I|                               \s
                                       ||:|           | I|                               \s
                                       ||:|           : \\:                               \s
                                       |\\:|            \\I|                               \s
                                       :/\\:            ([])                              \s
                                       ([])             [|                               \s
                                        ||              |\\_                              \s
                                       _/_\\_            [ -'-.__                         \s
                                      <]   \\>            \\_____.>                        \s
                                        \\__/                                             \s""");

                            break;
                        }


                    }

                    break;
                //-----------------------------------------------------------------------------------------------------

                case 4:

                    System.out.println("Modo Demencial");

                    ganar = false;

                    iniciarTablero();

                    // MODO DEMENCIAL

                    while (!ganar) {

                        //Turno del jugador
                        imprimirTablero();

                        insertarFicha(fichajugador);

                        ganar = verificarVictoria(fichajugador);

                        //Para cuando gana el jugador

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    .    ..:+$&&&&&&&&Xx$&&&&&&&&&&&&&&&&+ .;:.   \s
                                           :+ :;;;;;;:;++;;;;;;;:;;;;;;::x        \s
                                           .$                            $.       \s
                                           .$.      ··············      .$.       \s
                                           .&:      :¡HAS GANADO!:      :$ .      \s
                                         . .&.      ··············      ;X .;     \s
                                         :  $.                          ;$  :     \s
                                         ...&                            & ..     \s
                                           .Xx$& &&&$  &&&&&&$  .&& :&&$x$        \s
                                    .       ;$&x+&  & &&&&&&&&& &;&& &&&$;   ..   \s
                                    :     .:     & && && ¬ ¬ && & &&       :. .   \s
                                    .     . ..   && & &&& o && && &X    .:. ...   \s
                                          :;;.    &  &X &&&&& && &&     :  :.     \s
                                                  x&&  + $&    &&&      .::       \s
                                                    &&&&     &&&X                 \s
                                           .;;.        &  . +&    :.              \s
                                          .:  .     .  &&   &&  :  .     .;;;.    \s
                                        ... :;.     .  &&   && . :;.     .. ..    :
                                        . .:.       .  &&   &&  ..       .;+;.    ;
                                        ..            $& &+;&&                    :
                                                      && &;& &&                   \s
                                     .::...::......  ;& && &x&&  :.........;+:.   \s
                                    :.....:;;;;;;;:  && &  x& &+ ;;:;:...;+:...::::
                                    .   ...          & &.   &&&&         .  .  ...:
                                    ...::.  ..      &&;&     & &     .::. ..:...  \s
                                    :..    .......      :xXx & &   .. ...    .... \s
                                    :      :.  ...:&&&&X     & &&&...   ::     .: \s
                                                   +  $       & ..                \s
                                    &&&&&&&&&&&&&&&X   &&&&&&&   &&&&&&&&&&&&&&&&&&
                                    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&""");
                            break;
                        }
                        //Turno de la IA

                        fichaInsertada = false;

                        imprimirTablero();

                        if (!fichaInsertada){
                            priorizarVictoriaMaquina(fichamaquina);
                        }

                        if (!fichaInsertada){
                            preveerJugadaColumna(fichajugador, fichamaquina);
                        }
                        if (!fichaInsertada){
                            preveerJugadaFila(fichajugador, fichamaquina);
                        }

                        if (!fichaInsertada){
                            comprobarFilas(fichajugador, fichamaquina);
                        }
                        if (!fichaInsertada){
                            comprobarColumnas(fichajugador, fichamaquina);
                        }
                        if (!fichaInsertada){
                            comprobarDiagonales(fichajugador,fichamaquina);
                        }
                        comprobarDiagonales(fichajugador, fichamaquina);
                        if (!fichaInsertada) {
                            // Solo insertar ficha si no se insertó en las funciones anteriores
                            insertarFichaMaquina(fichamaquina); }

                        ganar = verificarVictoria(fichamaquina);

                        if (ganar) {

                            System.out.println();

                            System.out.println("La última jugada");

                            imprimirTablero();

                            System.out.println();

                            System.out.println("""
                                    ________________                                     \s
                                       |'-.--._ _________:                               \s
                                       |  /    |  __    __\\         +====================+
                                       | |  _  | [\\_\\= [\\_\\         |LA MAQUINA HA GANADO|
                                       | |.' '. \\.........|         +====================+
                                       | ( <)  ||:       :|_                             \s
                                        \\ '._.' | :.....: |_(o                           \s
                                         '-\\_   \\ .------./                              \s
                                         _   \\   ||.---.||  _                            \s
                                        / \\  '-._|/\\n~~\\n' | \\                           \s
                                       (| []=.--[===[()]===[) |                          \s
                                       <\\_/  \\_______/ _.' /_/                           \s
                                       ///            (_/_/                              \s
                                       |\\\\            [\\\\                                \s
                                       ||:|           | I|                               \s
                                       |::|           | I|                               \s
                                       ||:|           | I|                               \s
                                       ||:|           : \\:                               \s
                                       |\\:|            \\I|                               \s
                                       :/\\:            ([])                              \s
                                       ([])             [|                               \s
                                        ||              |\\_                              \s
                                       _/_\\_            [ -'-.__                         \s
                                      <]   \\>            \\_____.>                        \s
                                        \\__/                                             \s""");

                            break;
                        }


                    }

                    break;
                //-----------------------------------------------------------------------------------------------------


                default:

                    System.out.println("Inserte una opción válida por favor");

            }

            System.out.println("¿Quieres jugar otra partida? (sí/no)");

            partidanueva = sc.next();

            if (partidanueva.equalsIgnoreCase("sí")) {

                // Reiniciamos el tablero y las variables necesarias
                iniciarTablero();
                ganar = false;

                // Volver a mostrar el menú para seleccionar la dificultad
                System.out.println("""
                        Elija un modo de juego:
                        1. Modo Fácil
                        2. Modo Medio
                        3. Modo Experto
                        4. Modo Demencial
                        """);
                menu = sc.nextInt();

            }

        }while (partidanueva.equalsIgnoreCase("si"));


        System.out.println("¡Gracias por jugar!");

    }
    public static void priorizarVictoriaMaquina(String fichamaquina) {
        // Recorremos las celdas para ver las posibles jugadas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j].equals(" ")) {
                    // Verificamos si es una jugada válida (debe haber una ficha debajo o estar en la última fila vacía)
                    if (i == filas - 1 || !tablero[i + 1][j].equals(" ")) {
                        // Colocamos temporalmente la ficha para después verificar si ganaría
                        tablero[i][j] = fichamaquina;
                        // Si ganaría, la insertamos
                        if (verificarVictoria(fichamaquina)) {
                            fichaInsertada = true;
                            return;
                        }
                        // Pero si no, restauramos el tablero
                        tablero[i][j] = " ";
                    }
                }
            }
        }
    }

    public static void preveerJugadaFila(String fichajugador, String fichamaquina) {
        // Aquí comprobamos las filas de la parte baja del tablero hacia arriba
        for (int i = filas - 1; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                // Verificamos si hay 2 fichas consecutivas del jugador en la fila
                if (j + 1 < columnas && tablero[i][j].equals(fichajugador) && tablero[i][j + 1].equals(fichajugador)) {

                    // Bloquea hacia la derecha si la celda está vacía y no está "en el aire"
                    if (j + 2 < columnas && tablero[i][j + 2].equals(" ") &&
                            (i == filas - 1 || !tablero[i + 1][j + 2].equals(" "))) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i][j + 2] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }

                    // Bloquea hacia la izquierda si la celda está vacía y no está "en el aire"
                    if (j - 1 >= 0 && tablero[i][j - 1].equals(" ") &&
                            (i == filas - 1 || !tablero[i + 1][j - 1].equals(" "))) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i][j - 1] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }
                }
            }
        }
    }

    public static void preveerJugadaColumna(String fichajugador, String fichamaquina) {

        for (int j = 0; j < columnas; j++) {
            // Revisar de abajo hacia arriba en cada columna
            for (int i = filas - 1; i >= 0; i--) {

                // Verificar si hay 2 fichas consecutivas del jugador en la columna
                if (i - 1 >= 0 && tablero[i][j].equals(fichajugador) && tablero[i - 1][j].equals(fichajugador)) {

                    // Bloquear colocando la ficha de la máquina en la siguiente celda hacia abajo, si está vacía
                    if (i - 2 >= 0 && tablero[i - 2][j].equals(" ")) {
                        tablero[i - 2][j] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }
                }
            }
        }
    }


    public static void comprobarFilas(String fichajugador, String fichamaquina) {
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
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }

                    // Bloquea hacia la izquierda si la celda está vacía y no está "en el aire"
                    if (j - 1 >= 0 && tablero[i][j - 1].equals(" ") &&
                            // Verifica que no haya un espacio vacío debajo para que la ficha no quede "volando"
                            (i == filas - 1 || !tablero[i + 1][j - 1].equals(" "))) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i][j - 1] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }
                }
            }
        }
    }

    public static void comprobarColumnas(String fichajugador, String fichamaquina) {
        // Aquí comprobamos las columnas desde la parte baja del tablero hacia arriba
        for (int j = 0; j < columnas; j++) {
            for (int i = filas - 1; i >= 0; i--) {

                // Verificamos si hay 3 fichas consecutivas del jugador en la columna
                if (i + 2 < filas && tablero[i][j].equals(fichajugador)
                        && tablero[i + 1][j].equals(fichajugador) && tablero[i + 2][j].equals(fichajugador)) {

                    // Bloquea hacia arriba colocando la ficha en la celda superior si está vacía
                    if (i - 1 >= 0 && tablero[i - 1][j].equals(" ")) {
                        // Si se da alguna condición, la máquina bloqueará con una ficha
                        tablero[i - 1][j] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }

                    // No es necesario bloquear hacia abajo en columnas, ya que las fichas caen hacia abajo
                }
            }
        }
    }

    public static void comprobarDiagonales(String fichajugador, String fichamaquina) {
        // Aquí comprobamos las diagonales desde la parte baja del tablero hacia arriba
        for (int i = filas - 1; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {

                // Verificación de diagonales de arriba-izquierda a abajo-derecha
                if (i + 2 < filas && j + 2 < columnas && tablero[i][j].equals(fichajugador)
                        && tablero[i + 1][j + 1].equals(fichajugador) && tablero[i + 2][j + 2].equals(fichajugador)) {

                    // Bloquea hacia abajo-derecha si la celda está vacía y no está "en el aire"
                    if (i + 3 < filas && j + 3 < columnas && tablero[i + 3][j + 3].equals(" ")
                            && (i + 3 == filas - 1 || !tablero[i + 4][j + 3].equals(" "))) {
                        tablero[i + 3][j + 3] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }

                    // Bloquea hacia arriba-izquierda si la celda está vacía y no está "en el aire"
                    if (i - 1 >= 0 && j - 1 >= 0 && tablero[i - 1][j - 1].equals(" ")
                            && (i == filas - 1 || !tablero[i][j - 1].equals(" "))) {
                        tablero[i - 1][j - 1] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }
                }

                // Verificación de diagonales de abajo-izquierda a arriba-derecha
                if (i - 2 >= 0 && j + 2 < columnas && tablero[i][j].equals(fichajugador)
                        && tablero[i - 1][j + 1].equals(fichajugador) && tablero[i - 2][j + 2].equals(fichajugador)) {

                    // Bloquea hacia arriba-derecha si la celda está vacía y no está "en el aire"
                    if (i - 3 >= 0 && j + 3 < columnas && tablero[i - 3][j + 3].equals(" ")
                            && (i - 3 == filas - 1 || !tablero[i - 2][j + 3].equals(" "))) {
                        tablero[i - 3][j + 3] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
                        return;
                    }

                    // Bloquea hacia abajo-izquierda si la celda está vacía y no está "en el aire"
                    if (i + 1 < filas && j - 1 >= 0 && tablero[i + 1][j - 1].equals(" ")
                            && (i + 1 == filas - 1 || !tablero[i + 2][j - 1].equals(" "))) {
                        tablero[i + 1][j - 1] = fichamaquina;
                        // Si una función ha llegado a insertar ficha, esto actuaria como una variable de control
                        fichaInsertada = true;
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
                return;
            }
        }
    }
}


