package log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {
    private static final List<String> logList = new ArrayList<>();

    public static void addLog(String log) {
        logList.add(log);
        System.out.println(log);
    }

    public static List<String> getLogList() {
        return new ArrayList<>(Collections.unmodifiableList(logList));
    }
}
