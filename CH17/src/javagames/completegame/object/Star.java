package javagames.completegame.object;

import javagames.completegame.admin.GameConstants;
import javagames.util.Matrix3x3f;
import javagames.util.Vector2f;

import java.awt.*;

public class Star {
    private Vector2f position;
    private float velocity;

    public Star(Vector2f position, float velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Vector2f getPosition() {
        return position;
    }

    public float getVelocity() {
        return velocity;
    }

    public void update(float delta) {
        position.x = position.x - delta * velocity;
    }

    public boolean isOutOfWorld() {
        return position.x < -GameConstants.WORLD_WIDTH/2;
    }

    public void draw(Graphics2D g, Matrix3x3f view) {
        g.setColor(Color.WHITE);
        Vector2f newPos= view.mul(position);
        g.drawRect((int)newPos.x,(int) newPos.y, 1,1);
    }
}
