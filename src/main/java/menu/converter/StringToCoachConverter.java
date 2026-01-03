package menu.converter;

import menu.domain.Coach;

public class StringToCoachConverter implements Converter<String, Coach> {
    @Override
    public Coach convert(String name) {
        return new Coach(name);
    }
}
