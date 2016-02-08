package fwq.hdsx.com.lccdemo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public class DbService {

    private static final String TAG=DbService.class.getSimpleName();
    private static DbService instance;
    private static Context appContext;
    private DaoSession mDaosession;
    private UsersDao usersDao;
    private infosDao infoDao;
    private infoTypeDao typeDao;

    private DbService(){}

    public static DbService getInstance(Context context){
        if (instance==null){
            instance=new DbService();
            if (appContext==null){
                appContext=context.getApplicationContext();
            }
            instance.mDaosession=MyApplication.getDaoSession(context);
            instance.usersDao=instance.mDaosession.getUsersDao();
            instance.infoDao=instance.mDaosession.getInfosDao();
            instance.typeDao=instance.mDaosession.getInfoTypeDao();
        }
        return instance;
    }

    /**
     * 根据id获取用户信息
     * @param id id
     * @return 用户信息
     */
    public Users loadNote(long id){
        if (!TextUtils.isEmpty(id+"")){
            return usersDao.load(id);
        }
        return null;
    }

    /**
     * 获取全部的用户信息
     * @return 全部的用户信息
     */
    public List<Users>loadAllNoteByOrder(){
        return usersDao.queryBuilder().orderDesc(UsersDao.Properties.Id).list();
    }

    /**
     * 根据查询条件,返回数据列表
     * @param where        条件
     * @param params       参数
     * @return             数据列表
     */
    public List<Users> queryNote(String where, String... params){
        return usersDao.queryRaw(where, params);
    }

    /**
     * 保存用户的信息
     * @param users 用户信息
     * @return 是否保存成功
     */
    public long saveNote(Users users){
        return usersDao.insertOrReplace(users);
    }

    /**
     * 批量插入或修改用户信息
     * @param list      用户信息列表
     */
    public void saveNoteLists(final List<Users> list){
        if(list == null || list.isEmpty()){
            return;
        }
        usersDao.getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<list.size(); i++){
                    Users user = list.get(i);
                    usersDao.insertOrReplace(user);
                }
            }
        });
    }


    /**
     * 删除所有数据
     */
    public void deleteAllNote(){
        usersDao.deleteAll();
    }

    /**
     * 根据id,删除数据
     * @param id      用户id
     */
    public void deleteNote(long id){
        usersDao.deleteByKey(id);
        Log.i(TAG, "delete");
    }

    /**
     * 根据用户类,删除信息
     * @param user 用户信息类
     */
    public void deleteNote(Users user){
        usersDao.delete(user);
    }

    public Long saveInfoType(infoType iType){
        return typeDao.insertOrReplace(iType);
    }

    public void deleteInfoType(long id){
        typeDao.load(id).delete();
    }

    public List<infoType> getAllInfoTypeList(){
        return typeDao.queryBuilder().orderDesc(infoTypeDao.Properties.Id).list();
    }

    public  infoType getInfoType(long id){
        return typeDao.load(id);
    }

    public List<infos> getInfoByTypeId(long typeid){
        return typeDao.load(typeid).getInfoes();
    }

    public long saveInfo(infos info){
        return infoDao.insertOrReplace(info);
    }

    public List<infos> getAllInfos(){
        return infoDao.loadAll();
    }

    public List<infos> getInfosBypageSize(long typeid,int pageNum,int pageSize){
        return infoDao.queryBuilder().where(infosDao.Properties.TypeId.eq(typeid))
                .offset(1).limit(pageSize).list();
    }

}
