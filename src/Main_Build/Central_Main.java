package Main_Build;

import Model.Md;
import Controller.Ctr;
import View.Vw;

public class Central_Main {
    public static void main(String[] args) {
        RunMVC();
    }
    
    private static void RunMVC(){
        Vw View = new Vw();
        Md Model = new Md();
        Ctr Controller = new Ctr(View, Model);
        Controller.SendCtrollerObject(Controller);
        View.setVisible(true);
    }
}
