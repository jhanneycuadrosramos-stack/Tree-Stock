// Logica del arbol binario de busqueda
public class ArbolInventario {

    Producto raiz; // aquí guardo la raíz del árbol

    // método para insertar un producto de forma recursiva
    public Producto insertarRecursivo(Producto actual, int id, String nombre) {

        // si el nodo está vacío, creo uno nuevo
        if (actual == null) {
            return new Producto(id, nombre);
        }

        // si el id es menor, se va a la izquierda
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } 
        // si es mayor, se va a la derecha
        else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }

        return actual;
    }

    // método principal para insertar
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    // recorrido inorden (muestra ordenado)
    public void inorden(Producto nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo); // izquierda
            System.out.println("ID: " + nodo.id + " - Nombre: " + nodo.nombre); // raíz
            inorden(nodo.derecho); // derecha
        }
    }

    // mostrar inventario completo
    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println("Inventario vacío.");
        } else {
            inorden(raiz);
        }
    }

    // buscar un producto por id
    public Producto buscarRecursivo(Producto actual, int id) {

        // si no existe o lo encuentro
        if (actual == null || actual.id == id) {
            return actual;
        }

        // buscar en izquierda
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        } 
        // buscar en derecha
        else {
            return buscarRecursivo(actual.derecho, id);
        }
    }

    // método para mostrar resultado de búsqueda
    public void buscar(int id) {
        Producto encontrado = buscarRecursivo(raiz, id);

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.nombre);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}