package algorithms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Test {

    static class Testing {
        private String value;

        public Testing(String ii) {
            value = ii;
        }

        public void updateValue() {
            value = value.toLowerCase();
        }

        @Override
        public String toString() {
            return "Testing{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<Testing> list = Arrays.asList(new Testing("II"), new Testing("JJ"), new Testing("HJ"));

        list.forEach(Testing::updateValue);

        System.out.println(list);

    }

}
