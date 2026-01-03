package menu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimiterParser {
    private static final String DELIMITER = ",";

    public List<String> parseCoachNames(String input) {
        validateBlankAndNull(input);
        input = input.trim();
        String[] parts = input.split(DELIMITER);
        List<String> coaches = new ArrayList<>(Arrays.asList(parts));

        return coaches.stream().map(String::trim).collect(Collectors.toList());
    }

    public List<String> parseFoods(String input) {
        input = input.trim();
        String[] parts = input.split(DELIMITER);

        return new ArrayList<>(Arrays.asList(parts));
    }

    private static void validateBlankAndNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("코치 이름 입력이 비어있습니다.");
        }
    }
}
