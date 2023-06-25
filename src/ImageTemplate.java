


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JComponent;
import org.imgscalr.Scalr;

/**
 *
 * @author Salles
 */
public class ImageTemplate extends JComponent{
    private Icon icon;
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }
    private Image toImage(Icon icon) {
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        int width = getWidth();
        int height = getHeight();
        java.awt.Graphics2D g2d = bufferedImage.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        bufferedImage = Scalr.resize(bufferedImage, width, height);
        return bufferedImage;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (icon != null) {
            int width = getWidth();
            int height = getHeight();
            
            Graphics2D g2_img = (Graphics2D) grphcs;
            
            g2_img.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2_img.drawImage(toImage(icon), 0, 0, width, height, null);
            
        }
        super.paintComponent(grphcs);
    }
}
