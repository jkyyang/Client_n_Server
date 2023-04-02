package src.main.java.com.dataStructure;

public class registrationRequestMsg extends Message{
    /**
     * HEADER
     * - totalLength 4B = 58
     * - commandID 4B = 1
     * 
     * BODY
     * - userName 20B OctetString
     * - passwd 30B OctetString
     * */ 
    
    public registrationRequestMsg(){
        super();
    }
    public registrationRequestMsg(String msg){
        super(msg);
    }
    
    
}
