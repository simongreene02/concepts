package com.greatworksinc.concepts.measurer;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.greatworksinc.concepts.linkedlist.LinkedList;
import com.greatworksinc.concepts.measurer.commands.Command;
import com.greatworksinc.concepts.measurer.commands.DeleteCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SpeedMeasurer {
    //TODO: Finish methods in class.
    private static final Logger log = LoggerFactory.getLogger(SpeedMeasurer.class);
    public static void main(String[] args) {
        ImmutableList<String> baseList = Initalizer.createImmutableList(100000);
        int firstIndex = 0;
        int middleIndex = baseList.size()/2;
        int lastIndex = baseList.size()-1;
        Command[] commandList = new Command[12];
        commandList[0] =  new DeleteCommand(firstIndex);
        log.info("starting command");
        Stopwatch stopwatch = Stopwatch.createStarted();
        stopwatch.stop(); // optional
        Duration duration = stopwatch.elapsed();
        log.info("arrayList delete-last time: {}", duration.getNano());
    }
    private static Duration[][] measureDeleteOperation(ImmutableList<String> baseList, Command[] commandList) {
        Duration[][] timeTable = new Duration[commandList.length][2];
        ArrayList<String> arrayList = Initalizer.cloneArrayList(baseList);
        LinkedList linkedList = Initalizer.cloneLinkedList(baseList);
        Command command = new DeleteCommand(0);
        log.info("starting command");
        Stopwatch stopwatch = Stopwatch.createStarted();
        command.execute(arrayList);
        stopwatch.stop(); // optional
        Duration duration = stopwatch.elapsed();
        log.info("arrayList delete-last time: {}", duration.getNano());
    }
}
