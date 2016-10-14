package api;

import controllers.SportController;
import exceptions.InvalidFieldException;
import exceptions.SportExistException;

public class SportResource {
    public void createSport(String sport) throws InvalidFieldException, SportExistException {
        this.validateField(sport);
        new SportController().createSport(sport);
    }

    private void validateField(String field) throws InvalidFieldException, SportExistException {
        if (field == null || field.isEmpty()) {
            throw new InvalidFieldException(field);
        }else if(new SportController().existSport(field)){
            throw new SportExistException();
        }
    }
}
