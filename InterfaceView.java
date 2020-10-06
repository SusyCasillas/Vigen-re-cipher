package Unidad1;

public interface InterfaceView {
    
    void setController(Controller c);
    public String getFileName();
    public String getText();
    public void setText(String s);
    
    static final String Open = "Open";
    static final String Save = "Save";
    static final String Encrypt = "Encrypt";
    static final String Decrypt = "Decrypt";
}
