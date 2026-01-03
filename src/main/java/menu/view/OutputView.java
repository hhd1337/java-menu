package menu.view;

import menu.util.ErrorMessage;

public class OutputView {

    public void printErrorMessage(Exception exception) {
        System.out.println(ErrorMessage.PREFIX + exception.getMessage());
    }

    public void printServiceStartHeader() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");

    }

    public void printCoachNameInputPrompt() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }
}
