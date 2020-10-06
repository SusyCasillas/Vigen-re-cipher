package Unidad1;

public class MVC {

    public static void main(String[] args) {
        View v = new View();
        Model m = new Model(v);
        Controller c = new Controller(m, v);
        c.run();
    }
}
