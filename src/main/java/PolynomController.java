
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PolynomController {
    private PolynomModel m_model;
    private PolynomView m_view;

    //========================================================== constructor

    /**
     * Constructor
     */
    PolynomController(PolynomModel model, PolynomView view) {
        m_model = model;
        m_view = view;

        //... Add listeners to the view.
        view.addMultiplyListener(new MultiplyListener());
        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubstractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDerivateListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
        view.addClearListener(new ClearListener());
        view.addBtnNumberListener(new BtnNumberListener());
    }


////////////////////////////////////////// inner class MultiplyListener

    /**
     * When a mulitplication is requested.
     * 1. Get the user input number from the View.
     * 2. Call the model to mulitply by this number.
     * 3. Get the result from the Model.
     * 4. Tell the View to display the result.
     * If there was an error, tell the View to display it.
     */
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";
            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);

            userInput2 = m_view.getInPolinom2();
            Polinom p2 = m_model.makePolynom(userInput2);

            //p1 = m_model.multiplyBy(p1,p2);
            m_view.setTotal(m_model.multiplyBy(p1,p2).toString());
            }
        }
    //end inner class MultiplyListener

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";
            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);

            userInput2 = m_view.getInPolinom2();
            Polinom p2 = m_model.makePolynom(userInput2);
            System.out.println(p1);
            System.out.println(p2);
            p1 = m_model.addBy(p1,p2);
            m_view.setTotal(p1.toString());
        }
    }
    class SubstractListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";
            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);

            userInput2 = m_view.getInPolinom2();
            Polinom p2 = m_model.makePolynom(userInput2);

            p1 = m_model.substractBy(p1,p2);
            m_view.setTotal(p1.toString());
        }
    }class DerivateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";

            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);

            p1 = m_model.derivateBy(p1);
            m_view.setTotal(p1.toString());
            System.out.println(p1);
        }
    }
    class IntegrateListener implements  ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";

            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);

            p1 = m_model.integrateBy(p1);
            m_view.setTotal(p1.toString());
        }
    }
    class BtnNumberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();
           if(m_view.getCarePolinom().getSelectedItem() == "Polinom 1")
           {
               if(o.getName().equals("del")) {
                   int len = m_view.getInPolinom1().length();
                   if(len == 0)
                       len ++;
                   String sub = m_view.getInPolinom1().substring(0, len - 1);
                   m_view.setPolinom1(sub);
               }
               else
                   m_view.setPolinom1(m_view.getInPolinom1() + o.getName());
           }
           else {
               if(o.getName().equals("del")) {
                   int len = m_view.getInPolinom2().length();
                   if(len == 0)
                       len ++;
                   String sub = m_view.getInPolinom2().substring(0, len - 1);
                   m_view.setPolinom2(sub);
               }
               else
                     m_view.setPolinom2(m_view.getInPolinom2() + o.getName());
           }
        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}