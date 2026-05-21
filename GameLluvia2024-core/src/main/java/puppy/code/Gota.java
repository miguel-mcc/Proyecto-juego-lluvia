package puppy.code;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota implements Colisionable {
    protected Rectangle area;
    protected Texture textura;
    protected EstrategiaMovimiento estrategia; // Aquí guardamos el algoritmo

    public Gota(float x, float y, Texture textura, EstrategiaMovimiento estrategia) {
        this.area = new Rectangle();
        this.area.x = x;
        this.area.y = y;
        this.area.width = 64;
        this.area.height = 64;
        this.textura = textura;
        this.estrategia = estrategia;
    }

    @Override
    public Rectangle getArea() {
        return area;
    }

    public void caer(float velocidad, float deltaTime) {
        // La gota ya no sabe cómo moverse, le pide a su estrategia que lo haga
        estrategia.mover(area, velocidad, deltaTime);
    }

    public void dibujar(SpriteBatch batch) {
        batch.draw(textura, area.x, area.y);
    }

    public abstract void alColisionar(Tarro tarro);
}