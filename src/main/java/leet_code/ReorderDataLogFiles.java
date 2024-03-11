package leet_code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

public class ReorderDataLogFiles {

    public static void main(String[] args) {

    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.stream(logs)
                .map(log -> {

                    int index = log.indexOf(' ');
                    if ()

                    return new LogDto(log.split(" ")[0],)
                })


    }




    private static class LogDto{
        private String id;
        private String log;
        private LogType logType;

        public LogDto(String id, String log, LogType logType) {
            this.id = id;
            this.log = log;
            this.logType = logType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLog() {
            return log;
        }

        public void setLog(String log) {
            this.log = log;
        }

        public LogType getLogType() {
            return logType;
        }

        public void setLogType(LogType logType) {
            this.logType = logType;
        }
    }
    private enum LogType{
        DIGIT,LETTER;
    }
}
