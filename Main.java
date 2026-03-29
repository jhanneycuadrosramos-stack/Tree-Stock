import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArbolInventario arbol = new ArbolInventario();

        int opcion;

        // menú principal
        do {
            System.out.println("\n-TREE STOCK-");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    // registrar producto
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    arbol.insertar(id, nombre);
                    System.out.println("Producto registrado.");
                    break;

                case 2:
                    // mostrar inventario
                    arbol.mostrarInventario();
                    break;

                case 3:
                    // buscar producto
                    System.out.print("Ingrese ID a buscar: ");
                    int buscarId = scanner.nextInt();
                    arbol.buscar(buscarId);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}