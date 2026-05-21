package puppy.code;

public class GameManager {
    // 1. La única instancia de la clase (estática y privada)
    private static GameManager instancia;
    
    // Variables globales del juego
    private int puntos;
    private int vidas;
    
    // 2. Constructor privado: nadie puede hacer "new GameManager()" desde afuera
    private GameManager() {
        this.puntos = 0;
        this.vidas = 3;
    }
    
    // 3. Método estático que devuelve la instancia única
    public static GameManager getInstancia() {
        if (instancia == null) {
            instancia = new GameManager(); // Se crea solo la primera vez
        }
        return instancia;
    }

    // --- Getters y Setters normales ---
    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    public int getVidas() {
        return vidas;
    }

    public void restarVida() {
        this.vidas--;
    }
 // Método para reiniciar la partida
    public void reiniciar() {
        this.puntos = 0;
        this.vidas = 3;
    }
}