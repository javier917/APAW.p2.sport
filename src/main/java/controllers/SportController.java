package controllers;

import daos.DaoFactory;
import entities.Sport;

public class SportController {
    public void createSport(String sport) {
        DaoFactory.getFactory().getSportDao().create(new Sport(sport));
    }
}
