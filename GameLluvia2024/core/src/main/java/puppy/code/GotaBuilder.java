package puppy.code;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaBuilder {
    private float x, y;
    private Texture textura;
    private EstrategiaMovimiento estrategia;
    private Sound sonido;
    private int tipo; // 1 = Buena, 2 = Mala

    public GotaBuilder() {
        // Valores por defecto
        this.x = 0;
        this.y = 480;
        this.tipo = 1; // Gota buena por defecto
    }

    // Los métodos retornan "this" para poder encadenarlos
    public GotaBuilder setPosicion(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public GotaBuilder setTextura(Texture textura) {
        this.textura = textura;
        return this;
    }

    public GotaBuilder setEstrategia(EstrategiaMovimiento estrategia) {
        this.estrategia = estrategia;
        return this;
    }

    public GotaBuilder setSonido(Sound sonido) {
        this.sonido = sonido;
        return this;
    }

    public GotaBuilder setTipo(int tipo) {
        this.tipo = tipo;
        return this;
    }

    // El metodo que ensambla el objeto final
    public Gota build() {
        if (tipo == 2) {
            return new GotaMala(x, y, textura, estrategia);
        } else {
            return new GotaBuena(x, y, textura, sonido, estrategia);
        }
    }
}