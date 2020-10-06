package Unidad1;
import java.awt.*;
import javax.swing.*;
import static Unidad1.InterfaceView.Open;
import static Unidad1.InterfaceView.Save;
import static Unidad1.InterfaceView.Encrypt;
import static Unidad1.InterfaceView.Decrypt;

public class View extends JFrame implements InterfaceView{
    private final JTextArea text;
    private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;
    private final JButton openJButton;
    private final JTextField fileName;
    
    public View(){
        super("Vigenère cipher");
        JPanel fileJPanel;
        JLabel lblFile;
        JPanel buttonJPanel;
        BorderLayout layout;
        layout = new BorderLayout(30,20);//30 20
        setLayout(layout);
        fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        lblFile = new JLabel("Text file: ");
        lblFile.setToolTipText("File to open");
        fileJPanel.add(lblFile);
        fileName = new JTextField(20);
        fileJPanel.add(fileName);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10,15);
        add(new JScrollPane(text), BorderLayout.CENTER);
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(4,1));
        openJButton = new JButton(Open);
        buttonJPanel.add(openJButton);
        encryptJButton = new JButton(Encrypt);
        buttonJPanel.add(encryptJButton);
        decryptJButton = new JButton(Decrypt);
        buttonJPanel.add(decryptJButton);
        saveJButton = new JButton(Save);
        buttonJPanel.add(saveJButton);
        add(buttonJPanel, BorderLayout.EAST);
    }
    
    @Override
    public String getFileName(){
        return fileName.getText();
    }
    
    @Override
    public String getText(){
        return text.getText();
    }
    
    @Override
    public void setText(String s){
        text.setText(s);
    }
    
    @Override
    public void setController(Controller c){
        openJButton.addActionListener(c);
        saveJButton.addActionListener(c);
        encryptJButton.addActionListener(c);
        decryptJButton.addActionListener(c);
    }

}
