package puppy.code;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaBuena extends Gota {
    private Sound dropSound;

    public GotaBuena(float x, float y, Texture textura, Sound dropSound, EstrategiaMovimiento estrategia) {
        super(x, y, textura, estrategia);
        this.dropSound = dropSound;
    }

    @Override
    public void alColisionar(Tarro tarro) {
        tarro.sumarPuntos(10);
        dropSound.play();
    }
}