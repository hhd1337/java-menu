package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.converter.StringToCoachConverter;
import menu.domain.Coach;
import menu.util.DelimiterParser;
import menu.view.InputView;

public class InputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate inputTemplate;

    public InputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.inputTemplate = iteratorInputTemplate;
    }

    public List<Coach> inputCoachNames() {
        StringToCoachConverter converter = new StringToCoachConverter();
        DelimiterParser parser = new DelimiterParser();
        return inputTemplate.execute(
                inputView::inputCoachNames,
                value -> {
                    value = value.trim();

                    List<Coach> coaches = new ArrayList<>();
                    // parse
                    List<String> parsedNames = parser.parseCoachNames(value);
                    // validate
                    validateCoachesInput(parsedNames);

                    for (String name : parsedNames) {
                        coaches.add(converter.convert(name));
                    }
                    return coaches;
                }
        );
    }

    public void validateCoachesInput(List<String> parsedNames) {
        //예외1) 입력한 코치의 인원수가 2명에서 5명 사이가 아닐 경우
        if (parsedNames.size() < 2) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (5 < parsedNames.size()) {
            throw new IllegalArgumentException("코치는 최대 5명 이하 입력해야 합니다.");
        }
        //예외2) 코치 각자의 이름이 2글자에서 4글자 사이가 아닐 경우
        parsedNames.forEach(coachName -> {
            int length = coachName.length();
            if (length < 2 || length > 4) {
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
            }
        });
    }
}