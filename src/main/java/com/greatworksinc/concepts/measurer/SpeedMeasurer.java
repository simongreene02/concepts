package com.greatworksinc.concepts.measurer;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.greatworksinc.concepts.linkedlist.LinkedList;
import com.greatworksinc.concepts.measurer.commands.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpeedMeasurer {
    //TODO: Finish methods in class.
    private static final Logger log = LoggerFactory.getLogger(SpeedMeasurer.class);
    public static void main(String[] args) {
        ImmutableList<String> baseList = Initalizer.createImmutableList(1000);
        int firstIndex = 0;
        int middleIndex = baseList.size()/2;
        int lastIndex = baseList.size()-1;
        Command[] commandList = new Command[12];
        for (int i = 0; i < 3; i++) {
            commandList[i*4+0] = new DeleteCommand(new int [] {firstIndex, middleIndex, lastIndex}[i]);
            commandList[i*4+1] = new InsertCommand(new int [] {firstIndex, middleIndex, lastIndex}[i], UUID.randomUUID().toString());
            commandList[i*4+2] = new RetrieveCommand(new int [] {firstIndex, middleIndex, lastIndex}[i]);
            commandList[i*4+3] = new SearchCommand(baseList.get(new int [] {firstIndex, middleIndex, lastIndex}[i]));
        }
        Duration[][] timeTable = measureOperations(baseList, commandList);
        System.out.println(String.format("%45s %10s %10s %10s", "command name", "arrayList", "linkedList", "delta"));
        for (int i = 0; i < timeTable.length; i++) {
            String formattedResult = String.format("%45s %10d %10d %10d", commandList[i].getName(), timeTable[i][0].getNano(), timeTable[i][1].getNano(), timeTable[i][1].getNano()-timeTable[i][0].getNano());
            System.out.println(formattedResult);
        }
    }
    private static Duration[][] measureOperations(ImmutableList<String> baseList, Command[] commandList) {
        Duration[][] timeTable = new Duration[commandList.length][2];
        for (int i = 0; i < commandList.length; i++) {
            log.info("starting command " + (i+1));
            ArrayList<String> arrayList = Initalizer.cloneArrayList(baseList);
            Stopwatch stopwatch = Stopwatch.createStarted();
            commandList[i].execute(arrayList);
            stopwatch.stop(); // optional
            timeTable[i][0] = stopwatch.elapsed();
            LinkedList linkedList = Initalizer.cloneLinkedList(baseList);
            stopwatch = Stopwatch.createStarted();
            commandList[i].execute(linkedList);
            stopwatch.stop(); // optional
            timeTable[i][1] = stopwatch.elapsed();
        }
        return timeTable;
    }
}
