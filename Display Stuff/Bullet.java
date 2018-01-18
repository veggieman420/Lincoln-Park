import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet {

    private int x, y;
    private BufferedImage bulletTexture;
    private float bulletSpeed = 0.1f;

    public Bullet(String bulletTexturePath, String dir, int x, int y) {
        this.x = x;
        this.y = y;
        try {
            bulletTexture = ImageIO.read(new File(bulletTexturePath));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void drawBullet(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(bulletTexture, x, y, null);
    }

    public void shootBullet(Graphics g, String dir) {
        switch (dir) {
        case "left":
            while (x > -32) {
                x -= bulletSpeed * GamePanel.delta;
                drawBullet(g);
            }
            break;
        case "right":
            while (x < 700) {
                x += bulletSpeed * GamePanel.delta;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            break;
        case "up":
            while (y > -32) {
                y -= bulletSpeed * GamePanel.delta;
                drawBullet(g);
            }
            break;
        case "down":
            while (y < 480) {
                y += bulletSpeed * GamePanel.delta;
                drawBullet(g);
            }
            break;
        }
    }

}