package fwq.hdsx.com.lccdemo;

import fwq.hdsx.com.lccdemo.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "INFOS".
 */
public class infos implements java.io.Serializable {

    private Long id;
    private String infoTitle;
    private String infoAuthor;
    private String infoContent;
    private Long typeId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient infosDao myDao;

    private infoType infoType;
    private Long infoType__resolvedKey;


    public infos() {
    }

    public infos(Long id) {
        this.id = id;
    }

    public infos(Long id, String infoTitle, String infoAuthor, String infoContent, Long typeId) {
        this.id = id;
        this.infoTitle = infoTitle;
        this.infoAuthor = infoAuthor;
        this.infoContent = infoContent;
        this.typeId = typeId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getInfosDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoAuthor() {
        return infoAuthor;
    }

    public void setInfoAuthor(String infoAuthor) {
        this.infoAuthor = infoAuthor;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /** To-one relationship, resolved on first access. */
    public infoType getInfoType() {
        Long __key = this.typeId;
        if (infoType__resolvedKey == null || !infoType__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            infoTypeDao targetDao = daoSession.getInfoTypeDao();
            infoType infoTypeNew = targetDao.load(__key);
            synchronized (this) {
                infoType = infoTypeNew;
            	infoType__resolvedKey = __key;
            }
        }
        return infoType;
    }

    public void setInfoType(infoType infoType) {
        synchronized (this) {
            this.infoType = infoType;
            typeId = infoType == null ? null : infoType.getId();
            infoType__resolvedKey = typeId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
