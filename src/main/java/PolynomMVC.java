
    public class PolynomMVC {
        public static void main(String[] args) {
            PolynomModel model = new PolynomModel();
            PolynomView view = new PolynomView( model );
            PolynomController controller = new PolynomController(model, view);
            view.setVisible(true);
        }
    }

