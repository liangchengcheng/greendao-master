package fwq.hdsx.com.lccdemo;


import android.app.Application;
import android.content.Context;

public class MyApplication  extends Application{

    private static MyApplication mInstance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        if (mInstance==null){
            mInstance=this;
        }
    }

    /**
     * 获取DaoMaster
     */
    public static DaoMaster getDaoMaster(Context context){
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new THDevOpenHelper(context,"myDb",null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
