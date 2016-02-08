package fwq.hdsx.com.lccdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class Twotable_info_adpter extends BaseAdapter {

    private List<infos> list_info;
    private LayoutInflater inflater;

    public Twotable_info_adpter(Context context, List<infos> list_info) {
        this.inflater = LayoutInflater.from(context);
        this.list_info = list_info;
    }

    @Override
    public int getCount() {
        return list_info.size();
    }

    @Override
    public Object getItem(int position) {
        return list_info.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        infoDetail iDetail;
        if(convertView==null) {
            iDetail = new infoDetail();
            convertView = inflater.inflate(R.layout.activty_twotable_detail_lv_item,null);
            iDetail.title = (TextView)convertView.findViewById(R.id.txt_twotable_detail_item_title);
            iDetail.author = (TextView)convertView.findViewById(R.id.txt_twotable_detail_item_author);
            iDetail.content = (TextView)convertView.findViewById(R.id.txt_twotable_detail_item_content);

            convertView.setTag(iDetail);
        }else {
            iDetail = (infoDetail)convertView.getTag();
        }

        iDetail.title.setText(list_info.get(position).getInfoTitle());
        iDetail.author.setText(list_info.get(position).getInfoType().getInfoName() + "-" + list_info.get(position).getInfoAuthor());
        iDetail.content.setText(list_info.get(position).getInfoContent());

        return convertView;
    }

    class infoDetail {
        TextView title;
        TextView author;
        TextView content;
    }
}
