package daos.memory;

import daos.SportDao;
import entities.Sport;

public class SportMemoryDao extends GenericMemoryDao<Sport> implements SportDao {

    @Override
    protected String getId(Sport entity) {
        return entity.getSport();
    }

    @Override
    protected void setId(Sport entity, String id) {
       entity.setSport(id);
        
    }

}
