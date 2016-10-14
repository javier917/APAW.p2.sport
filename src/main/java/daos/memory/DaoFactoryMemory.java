package daos.memory;

import daos.DaoFactory;
import daos.SportDao;
import daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
		    userDao = new UserMemoryDao();
		}
		return userDao;
	}

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportMemoryDao();
        }
        return sportDao;
    }

}
