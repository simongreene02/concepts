package com.greatworksinc.concepts.measurer.commands;

import java.util.List;

public class InsertCommand implements Command {
    private final int index;
    private final String item;

    public InsertCommand(int index, String item) {
        this.index = index;
        this.item = item;
    }

    @Override
    public void execute(List<String> list) {
        list.add(index, item);
    }
}
