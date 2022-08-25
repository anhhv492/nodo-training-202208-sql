package com.example.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    String message;

    private List<JavaClazz> clazzes;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message ="Call from setter: "+ message;
    }

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }
    public void printMessage(){
        System.out.println("your message: "+message);
    }

    private void initMessage(){
        System.out.println("calling init method...");
        message="from init method: say hello bean!";
    }

    private void relase(){
        if(message==null){
            System.out.println("message is null");
        }

    }
    public HelloClazz(){
        message="from constructor: say hello everyone!";
    }

    public HelloClazz(int person){
        message="from constructor: say hello to "+person+" person(s)!";
    }

    public HelloClazz(HelloClazz clazz){
        message=clazz.message;
    }
    @Override
    public void destroy() throws Exception {
        if(message==null){
            System.out.println("message is null");
        }
    }

}
