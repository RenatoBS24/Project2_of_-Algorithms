package Lists.Stack;

public class UndoRedoTest {
    public static void main(String[] args) {
        try {
            // Crear instancia de UndoRedo
            UndoRedo<String> undoRedo = new UndoRedo<>();

            // Agregar elementos
            System.out.println("Agregando elementos...");
            undoRedo.add("Primero");
            undoRedo.add("Segundo");
            undoRedo.add("Tercero");
            System.out.println("Elemento actual: " + undoRedo.getCurrent()); // Debería ser "Tercero"

            // Deshacer
            System.out.println("\nOperación de deshacer...");
            undoRedo.undo();
            System.out.println("Elemento actual después de deshacer: " + undoRedo.getCurrent()); // Debería ser "Segundo"

            // Deshacer nuevamente
            System.out.println("\nOperación de deshacer nuevamente...");
            undoRedo.undo();
            System.out.println("Elemento actual después del segundo deshacer: " + undoRedo.getCurrent()); // Debería ser "Primero"

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
