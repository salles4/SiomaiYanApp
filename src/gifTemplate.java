
import javax.swing.Icon;
import javax.swing.JComponent;


/**
 *
 * @author Salles
 */
public class gifTemplate extends JComponent{
        private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }
    
}
