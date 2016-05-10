package pl.btbw.module.home;

import pl.btbw.core.BusinessException;

public class HomeService {

    public String getMessage(boolean exc) {
        if(exc) {
            throw new BusinessException("Some Problem with app");
        }
        return "Lorem Ipsum";
    }
}
