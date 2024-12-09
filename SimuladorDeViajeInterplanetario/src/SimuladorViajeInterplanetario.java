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
    static void seleccionarNave() {
        System.out.println("\nLista de Naves Espaciales:");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("%d. %s (Velocidad: %.0f km/h)\n", i + 1, naves[i], velocidades[i]);
        }

        System.out.print("Seleccione una nave: ");
        int seleccion = sc.nextInt() - 1;

        if (seleccion >= 0 && seleccion < naves.length) {
            naveSeleccionada = seleccion;
            System.out.printf("Has seleccionado la nave %s. Velocidad máxima: %.0f km/h.\n", naves[seleccion], velocidades[seleccion]);

            System.out.print("Ingrese la cantidad de pasajeros: ");
            cantidadPasajeros = sc.nextInt();
            if (cantidadPasajeros > 0) {
                System.out.printf("Cantidad de pasajeros registrada: %d.\n", cantidadPasajeros);
            } else {
                System.out.println("Cantidad inválida. Intente nuevamente.");
                cantidadPasajeros = 0;
            }
        } else {
            System.out.println("Selección inválida.");
        }
    }

    static void iniciarViaje() {
        if (planetaSeleccionado == -1 || naveSeleccionada == -1) {
            System.out.println("Debe seleccionar un planeta y una nave antes de iniciar el viaje.");
            return;
        }

        double distancia = distancias[planetaSeleccionado];
        double velocidad = velocidades[naveSeleccionada];
        double duracionHoras = distancia / velocidad;
        double duracionDias = duracionHoras / 24;

        System.out.printf("\nIniciando el viaje al planeta %s con la nave %s.\n", planetas[planetaSeleccionado], naves[naveSeleccionada]);
        System.out.printf("Distancia: %.0f km. Velocidad: %.0f km/h.\n", distancia, velocidad);
        System.out.printf("Duración estimada del viaje: %.2f días.\n", duracionDias);

        // Simular progreso del viaje
        for (int progreso = 0; progreso <= 100; progreso += 10) {
            System.out.printf("Progreso del viaje: %d%% completado.\n", progreso);

            if (progreso == 0) {
                System.out.println("Inicio del viaje...");
            } else if (progreso == 50) {
                System.out.println("Mitad del camino alcanzada.");
            } else if (progreso == 100) {
                System.out.println("Llegada al destino. ¡Has alcanzado el planeta!");
            }

            try {
                Thread.sleep(1000); // Pausa de 1 segundo para simular el progreso
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación.");
            }
        }
    }

}
