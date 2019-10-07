package com.generalassembly;

import java.util.ArrayList;

public class History {
    private ArrayList<String> history;

    public History() {
        history = new ArrayList<String>();
    }
    public void saveResults(String... lines) {
        for(String line: lines) {
            this.history.add(line);
        }
        this.history.add("-------------------------");
    }

    public void print() {
        IO.shared().lineBreak();
        IO.shared().lineBreak();
        IO.shared().out("HISTORY:");
        for(String line: this.history) {
            IO.shared().out(line);
        }
        IO.shared().lineBreak();
        IO.shared().lineBreak();

    }
}
