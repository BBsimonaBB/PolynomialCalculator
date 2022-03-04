import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserText {
    private String input;

    public UserText(String input) {
        this.input = input;
    }

    public String getInput(String inPolinom1) {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int alegOperand(String s)
    {
        if(s.indexOf("+",1) == -1) return s.indexOf("-",1);
        else if (s.indexOf("-",1) == -1) return s.indexOf("+",1);
        else
            return Math.min(s.indexOf("+",1), s.indexOf("-",1));
    }
    public int cautIcs(String s)
    {
        if(s.indexOf("^") == s.indexOf("x") + 1) //daca am putere
            return alegOperand(s)-1;
        else return s.indexOf("x");
    }
    public Polinom convertUserText() throws InvalidTextException{
        if (!input.equals("")) {
            UserText u = new UserText(input);
            int piece = cautIcs(input);
            Polinom p = new Polinom(new ArrayList<>());
            while (piece > -1) {
                u.verifyText();
                Monomial m = new Monomial(0, 0);
                m.recognizeMonoid(input.substring(0, piece + 1));
                p.polinom.add(m);
                input = input.substring(piece + 1); //asta e un monoid!!
                piece = cautIcs(input);
            }
            if (!input.equals("")) {
                u.verifyText();
                Monomial m = new Monomial(0, 0);
                p.polinom.add(m.recognizeMonoid(input));
            }
            p.arrange();
            return p;
        } else return null;
    }
    public void verifyText() throws InvalidTextException
    {
        String s = "[a-zA-Z]x";
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[-+*^][-+*^]";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "x[0-9]+";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[0-9]+x";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[a-wyzA-WYZ][~`!@#$%&()_=}{|?><,]";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
    }
}
