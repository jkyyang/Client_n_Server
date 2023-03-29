package src.dataStructure;

public class Message {
    String msg = null;
    Boolean reliable = false;

    public Message() {
//        reliable = false;
    }

    public Message(String msg) {
        this.msg = msg;
        setReliable();
    }

    public void setReliable() {
        this.reliable = true;
    }

    public String getMsg() {
        return msg;
    }

    public Boolean getReliable() {
        return reliable;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setReliable();    }
}
