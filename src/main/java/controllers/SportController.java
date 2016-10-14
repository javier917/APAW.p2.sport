package controllers;

import daos.DaoFactory;
import entities.Sport;

public class SportController {
    public void createSport(String sport) {
        DaoFactory.getFactory().getSportDao().create(new Sport(sport));
    }
    
    public boolean existSport(String sport){
        if (DaoFactory.getFactory().getSportDao().read(sport) == null) {
            return false;
        }else{
            return true;
        }
    }
}
