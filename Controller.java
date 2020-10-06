package Unidad1;
import java.awt.event.*;
import javax.swing.*;

class Controller implements ActionListener{
    private Model modelo;
    private View vista;
    
    public Controller(Model m,View v){
        modelo = m;
        vista = v;
        vista.setController(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        switch(event.getActionCommand()){
            case InterfaceView.Open:
                modelo.setFileName(vista.getFileName());
                vista.setText(modelo.read(vista.getFileName()));
                break;
            case InterfaceView.Encrypt:
                modelo.encript();
                modelo.setContenido(vista.getText());
                break;
            case InterfaceView.Decrypt:
                modelo.decript();
                modelo.setContenido(vista.getText());
                break;
            case InterfaceView.Save:
                modelo.setFileName(vista.getFileName());
                modelo.setContenido(vista.getText());
                modelo.SaveFile(vista.getText());
                break;
            default:
                System.err.println("Undefined command");
                break;
        }
    }
    public void run(){
        vista.setBounds(500, 200, 600, 350);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(500,250);
        vista.setVisible(true);
    }
}
