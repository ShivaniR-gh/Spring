package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Terminal {


    private int terminalNumber;
    private String terminalName;
    private String terminalPlace;
    private int terminalGateNumber;

    Terminal(){
        System.out.println("The default constructor has been invoked");
    }
    @Override
    public String toString() {
        return "Terminal{" +
                "terminalNumber=" + terminalNumber +
                ", terminalName='" + terminalName + '\'' +
                ", terminalPlace='" + terminalPlace + '\'' +
                ", terminalGateNumber=" + terminalGateNumber +
                '}';
    }


    public int getTerminalNumber() {
        return terminalNumber;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public int getTerminalGateNumber() {
        return terminalGateNumber;
    }

    public String getTerminalPlace() {
        return terminalPlace;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public void setTerminalNumber(int terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public void setTerminalGateNumber(int terminalGateNumber) {
        this.terminalGateNumber = terminalGateNumber;
    }

    public void setTerminalPlace(String terminalPlace) {
        this.terminalPlace = terminalPlace;
    }
}




