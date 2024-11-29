import java.util.Scanner;

public class SimuladorViajeInterplanetario {

    // Arrays para planetas y sus distancias desde la Tierra (en km)
    static String[] planetas = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno"};
    static double[] distancias = {91700000, 41400000, 78300000, 628730000, 1275000000};

    // Arrays para naves espaciales y sus velocidades (en km/h)
    static String[] naves = {"Nave Explorer", "Nave Voyager", "Nave Speedster"};
    static double[] velocidades = {50000, 75000, 100000}; // Velocidad en km/h

    static Scanner sc = new Scanner(System.in);
    static int planetaSeleccionado = -1;
    static int naveSeleccionada = -1;
    static int cantidadPasajeros = 0;

    public static void main(String[] args) {
        boolean salir = false;

        System.out.println("¡Bienvenido al Simulador de Viaje Interplanetario!");

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> seleccionarPlaneta();
                case 2 -> seleccionarNave();
                case 3 -> iniciarViaje();
                case 4 -> {
                    System.out.println("Saliendo del simulador. ¡Adiós!");
                    salir = true;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar simulación del viaje");
        System.out.println("4. Salir del programa");
        System.out.print("Seleccione una opción: ");
    }

    static void seleccionarPlaneta() {
        System.out.println("\nLista de Planetas:");
        for (int i = 0; i < planetas.length; i++) {
            System.out.printf("%d. %s (%.0f km)\n", i + 1, planetas[i], distancias[i]);
        }

        System.out.print("Seleccione un planeta destino: ");
        int seleccion = sc.nextInt() - 1;

        if (seleccion >= 0 && seleccion < planetas.length) {
            planetaSeleccionado = seleccion;
            System.out.printf("Has seleccionado el planeta %s. Distancia desde la Tierra: %.0f km.\n", planetas[seleccion], distancias[seleccion]);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    // Funcion para seleccionar nave espacial


}
