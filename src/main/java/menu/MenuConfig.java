package menu;

import menu.controller.InputHandler;
import menu.controller.IteratorInputTemplate;
import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuConfig {

    private InputView inputView;
    private OutputView outputView;
    private IteratorInputTemplate iteratorInputTemplate;
    private InputHandler inputHandler;
    private MenuController menuController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public IteratorInputTemplate iteratorInputTemplate() {
        if (iteratorInputTemplate == null) {
            iteratorInputTemplate = new IteratorInputTemplate(outputView());
        }
        return iteratorInputTemplate;
    }

    public InputHandler iteratorInputHandler() {
        if (inputHandler == null) {
            inputHandler = new InputHandler(inputView(), iteratorInputTemplate());
        }
        return inputHandler;
    }

    public MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController(iteratorInputHandler(), outputView());
        }
        return menuController;
    }
}
