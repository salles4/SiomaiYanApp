
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Salles
 */
public class ImageTemplateNoSclr extends JComponent {

    private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }
    
    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (icon != null) {
            int width = getWidth();
            int height = getHeight();

            Graphics2D g2_img = (Graphics2D) grphcs;
            //Composite composite = g2_img.getComposite();
            g2_img.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2_img.drawImage(toImage(icon), 0, 0, width, height, null);
            //g2_img.setComposite(composite);
            //g2_img.dispose();
        }
        super.paintComponent(grphcs);
    }
}
