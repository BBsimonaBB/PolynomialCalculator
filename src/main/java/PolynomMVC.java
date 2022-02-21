import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

    public class PolynomMVC {
        public static void main(String[] args) {
            PolynomModel model = new PolynomModel();
            PolynomView view = new PolynomView( model );
            PolynomController controller = new PolynomController(model, view);
            view.setVisible(true);
        }
    }

