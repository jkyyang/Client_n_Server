/*
 * @Author: jiaqiyang jkyyang@foxmail.com
 * @Date: 2023-03-29 19:43:59
 * @LastEditors: jiaqiyang jkyyang@foxmail.com
 * @LastEditTime: 2023-04-02 00:55:42
 * @FilePath: /Client_n_Server/ClientProject/src/main/java/com/dataStructure/Message.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package src.main.java.com.dataStructure;


public class Message {
    /** 
     * Message Structure
     * header 
     *  - totalLength 4B uint32 
     *  - commandID 4B uint32 
     *          - 1 2 3 4
     * body
     * 
    */
    String msg = null;
    Boolean reliable = false;

    public Message() {
        // reliable = false;
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
        setReliable();
    }
}
