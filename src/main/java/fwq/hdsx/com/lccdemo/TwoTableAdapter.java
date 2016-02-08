package fwq.hdsx.com.lccdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TwoTableAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<infoType> list_type;

    public TwoTableAdapter(Context context, List<infoType>list_type){
        this.inflater=LayoutInflater.from(context);
        this.list_type=list_type;
    }

    @Override
    public int getCount() {
        return list_type.size();
    }

    @Override
    public Object getItem(int position) {
        return list_type.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        twoTableType tType;
        if (convertView==null){
            tType=new twoTableType();
            convertView=inflater.inflate(R.layout.activity_twotable_lv_item,null);
            tType.typeName= (TextView) convertView.findViewById(R.id.txt_twotable_item_typeName);
            convertView.setTag(tType);
        }else{
            tType= (twoTableType) convertView.getTag();
        }
        tType.typeName.setText(list_type.get(position).getInfoName());
        return convertView;
    }

    public class twoTableType{
        TextView typeName;
    }

}
