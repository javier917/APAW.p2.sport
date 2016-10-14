package daos.memory;

import java.util.HashMap;

import daos.SportDao;
import entities.Sport;

public class SportMemoryDao extends GenericMemoryDao<Sport> implements SportDao {
    public SportMemoryDao() {
        this.setMap(new HashMap<String, Sport>());
    }
    @Override
    protected String getId(Sport entity) {
        return entity.getSport();
    }

    @Override
    protected void setId(Sport entity, String id) {
       entity.setSport(id);
        
    }

}
