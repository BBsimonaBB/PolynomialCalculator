
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
            String userInput = "";
            try {
                userInput = m_view.getInPolinom1();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());

            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }//end inner class MultiplyListener

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "", userInput2 = "";
            //try {
            userInput1 = m_view.getInPolinom1();
            Polinom p1 = m_model.makePolynom(userInput1);
                //m_model.addBy(userInput);
               // m_view.setTotal(m_model.getValue());

            userInput2 = m_view.getInPolinom2();
            Polinom p2 = m_model.makePolynom(userInput2);
            p2 = m_model.addBy(p1,p2);
            m_view.setTotal(p2.toString());
          //  } catch (NumberFormatException nfex) {
          //      m_view.showError("Bad input: '" + userInput + "'");
          //  }
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