package fwq.hdsx.com.lccdemo;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import fwq.hdsx.com.lccdemo.Users;
import fwq.hdsx.com.lccdemo.infoType;
import fwq.hdsx.com.lccdemo.infos;

import fwq.hdsx.com.lccdemo.UsersDao;
import fwq.hdsx.com.lccdemo.infoTypeDao;
import fwq.hdsx.com.lccdemo.infosDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig usersDaoConfig;
    private final DaoConfig infoTypeDaoConfig;
    private final DaoConfig infosDaoConfig;

    private final UsersDao usersDao;
    private final infoTypeDao infoTypeDao;
    private final infosDao infosDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        usersDaoConfig = daoConfigMap.get(UsersDao.class).clone();
        usersDaoConfig.initIdentityScope(type);

        infoTypeDaoConfig = daoConfigMap.get(infoTypeDao.class).clone();
        infoTypeDaoConfig.initIdentityScope(type);

        infosDaoConfig = daoConfigMap.get(infosDao.class).clone();
        infosDaoConfig.initIdentityScope(type);

        usersDao = new UsersDao(usersDaoConfig, this);
        infoTypeDao = new infoTypeDao(infoTypeDaoConfig, this);
        infosDao = new infosDao(infosDaoConfig, this);

        registerDao(Users.class, usersDao);
        registerDao(infoType.class, infoTypeDao);
        registerDao(infos.class, infosDao);
    }
    
    public void clear() {
        usersDaoConfig.getIdentityScope().clear();
        infoTypeDaoConfig.getIdentityScope().clear();
        infosDaoConfig.getIdentityScope().clear();
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public infoTypeDao getInfoTypeDao() {
        return infoTypeDao;
    }

    public infosDao getInfosDao() {
        return infosDao;
    }

}
