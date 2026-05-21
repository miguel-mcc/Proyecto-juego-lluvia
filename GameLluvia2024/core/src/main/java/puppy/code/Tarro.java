package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Tarro implements Colisionable {
    private Rectangle bucket;
    private Texture bucketImage;
    private Sound sonidoHerido;
    
    // ¡BORRAMOS LAS VARIABLES VIDAS Y PUNTOS DE AQUÍ!
    private int velx = 400;
    private boolean herido = false;
    private int tiempoHeridoMax = 50;
    private int tiempoHerido;
    
    private final int SCREEN_WIDTH = 800;
    private final int BUCKET_WIDTH = 64;
    private final int BUCKET_HEIGHT = 64;

    public Tarro(Texture tex, Sound ss) {
        this.bucketImage = tex;
        this.sonidoHerido = ss;
    }

    @Override
    public Rectangle getArea() {
        return bucket;
    }

    // Ahora delegamos la suma de puntos al Singleton
    public void sumarPuntos(int pp) {
        GameManager.getInstancia().sumarPuntos(pp);
    }

    public void crear() {
        bucket = new Rectangle();
        bucket.x = (SCREEN_WIDTH / 2f) - (BUCKET_WIDTH / 2f);
        bucket.y = 20;
        bucket.width = BUCKET_WIDTH;
        bucket.height = BUCKET_HEIGHT;
    }

    // Delegamos la pérdida de vida al Singleton
    public void dañar() {
        GameManager.getInstancia().restarVida();
        herido = true;
        tiempoHerido = tiempoHeridoMax;
        sonidoHerido.play();
    }

    public void dibujar(SpriteBatch batch) {
        if (!herido) {
            batch.draw(bucketImage, bucket.x, bucket.y);
        } else {
            batch.draw(bucketImage, bucket.x, bucket.y + MathUtils.random(-5, 5));
            tiempoHerido--;
            if (tiempoHerido <= 0) {
                herido = false;
            }
        }
    }

    public void actualizarMovimiento() {
        // Movimiento desde teclado
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            bucket.x -= velx * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            bucket.x += velx * Gdx.graphics.getDeltaTime();
        }

        // Encapsulamiento de límites (Que no se salga de los bordes)
        if (bucket.x < 0) {
            bucket.x = 0;
        }
        if (bucket.x > SCREEN_WIDTH - BUCKET_WIDTH) {
            bucket.x = SCREEN_WIDTH - BUCKET_WIDTH;
        }
    }

    public void destruir() {
        bucketImage.dispose();
    }

    public boolean estaHerido() {
        return herido;
    }
}