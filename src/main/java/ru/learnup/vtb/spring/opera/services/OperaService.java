package ru.learnup.vtb.spring.opera.services;

import org.springframework.stereotype.Service;
import ru.learnup.vtb.spring.opera.model.Opera;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperaService {
    private final List<Opera> operaList = new ArrayList<>();

    public Opera getOperaByName(String operaName) {
        for (Opera opera : operaList) {
            if (opera.getName().equals(operaName)) {
                return opera;
            }
        }
        return null;
    }

    public void addOpera(String operaName, String operaDesc, String operaAgeCategory, int operaNumberTickets) {
        operaList.add(new Opera(operaName, operaDesc, operaAgeCategory, operaNumberTickets, new ArrayList<>()));
    }

    public void deleteOpera(String operaName) {
        operaList.remove(getOperaByName(operaName));
    }

    public void changeOpera(String oldOperaName, String operaName, String operaDesc, String operaAgeCategory, int operaNumberTickets) {
        deleteOpera(oldOperaName);
        addOpera(operaName, operaDesc, operaAgeCategory, operaNumberTickets);
    }

    public void printOperaList() {
        for (Opera opera : operaList) {
            System.out.println(opera.toString());
        }
    }


    public void buyOperaTicket(String operaName) {
        Opera opera = getOperaByName(operaName);
        if (opera != null) {
            opera.buyTicket();
        }
    }

    public void returnOperaTicket(String operaName) {
        Opera opera = getOperaByName(operaName);
        if (opera != null) {
            opera.returnTicket();
        }
    }
}
