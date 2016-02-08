package fwq.hdsx.com.lccdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TwoTableActivity extends AppCompatActivity implements OneTableDialogFragment.addUserOnClickListener,
        OneTableItemDialogFragment.EditUserOnClickListener{

    private Toolbar toolbar;

    private ListView lv_oneTable;
    private List<Users> list_user;
    private OneTableAdapter adapter;

    private DbService service;
    private OneTableItemDialogFragment oneItemDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_table);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("表单的操作");

        setSupportActionBar(toolbar);
        service=DbService.getInstance(this);
        initControls();
        initData();
    }

    private void initData(){
        list_user=new ArrayList<>();
        list_user=service.loadAllNoteByOrder();
        adapter=new OneTableAdapter(this,list_user);
        lv_oneTable.setAdapter(adapter);
    }

    /**
     * 初始化控件
     */
    private void initControls(){
        lv_oneTable= (ListView) findViewById(R.id.lv_oneTable);
        lv_oneTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(TwoTableActivity.this,list_user.get(position).getUName() + "--" +
                        list_user.get(position).getId(),Toast.LENGTH_SHORT).show();

                oneItemDialog = new OneTableItemDialogFragment(list_user.get(position).getId(),position);
                oneItemDialog.show(getFragmentManager(),"编辑");
            }
        });
    }

    @Override
    public void onEditUserOnClick(long id, int position, int flag) {
        if (flag==0){
            service.deleteNote(id);
            adapter.notifyDataSetChanged();
            oneItemDialog.dismiss();
        }else{
            Users updateUser=service.loadNote(id);
            OneTableDialogFragment fragment=new OneTableDialogFragment(updateUser.getId(),updateUser.getUName(),updateUser.getUSex(),
                    updateUser.getUAge(), updateUser.getUTelphone(),1);
            oneItemDialog.dismiss();
            fragment.show(getFragmentManager(),"修改");
        }
    }

    @Override
    public void onAddUserOnClick(long id, String uName, String uSex, String uAge, String uTel, int flag) {
        Users user=new Users();
        if (flag==1){
            user.setId(id);
        }
        user.setUSex(uSex);
        user.setUTelphone(uTel);
        user.setUName(uName);
        if (flag==0){
            if (service.saveNote(user)>0){
                list_user.add(0,user);
                adapter.notifyDataSetChanged();
            }
        }else{
            if (service.saveNote(user)>0){
                int num=0;
                for (Users u:list_user){
                    if (u.getId()==id){
                        list_user.remove(num);
                        list_user.add(num,user);
                        break;
                    }
                    num++;
                }
                adapter.notifyDataSetChanged();
            }
        }
    }
}
