package api;

import exceptions.InvalidFieldException;

public class SportResource {
    public void createSport(String sport) {
        this.validateField(sport);
        new SportController.createSport(sport);
    }

    private void validateField(String field) throws InvalidFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidFieldException(field);
        }
    }
}
