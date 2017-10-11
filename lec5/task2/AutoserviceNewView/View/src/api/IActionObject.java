package api;

import com.senlaCourse.autoservice.api.controller.IController;

public interface IActionObject {
    void execute(IController controller);
    void navigateTo (Integer index);
}

