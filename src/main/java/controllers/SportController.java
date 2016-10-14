package controllers;

import exceptions.InvalidFieldException;

public class SportController {
    public void createSport(String sport) {
        DaoFactory.getFactory().getSportDao().create(new Sport(sport));
    }
}
