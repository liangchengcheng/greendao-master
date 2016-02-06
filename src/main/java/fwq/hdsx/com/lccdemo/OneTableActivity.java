package fwq.hdsx.com.lccdemo;

import android.app.Activity;
import android.widget.ListView;
import android.widget.Toolbar;

public class OneTableActivity extends Activity implements OneTableDialogFragment.addUserOnClickListener,
        OneTableItemDialogFragment.EditUserOnClickListener{

    private Toolbar toolbar;

    private ListView lv_oneTable;
    private OneTableAdapter adapter;

    private DbService service;
    private OneTableItemDialogFragment oneTableItemDialogFragment;
    
    @Override
    public void onEditUserOnClick(long id, int position, int flag) {

    }

    @Override
    public void onAddUserOnClick(long id, String uName, String uSex, String uAge, String uTel, int flag) {

    }
}
