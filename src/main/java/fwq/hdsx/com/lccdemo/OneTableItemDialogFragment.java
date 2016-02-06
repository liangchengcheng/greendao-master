package fwq.hdsx.com.lccdemo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class OneTableItemDialogFragment extends DialogFragment{

    /**
     *  用户id
     */
    private long id;

    /**
     * 在list中的编号
     */
    private int postion;

    private TextView txt_onetable_update;
    private TextView txt_onetable_delete;

    public interface EditUserOnClickListener{
        //flag标识 0标识的是删除，1标识的是修改
        void onEditUserOnClick(long id,int position,int flag);
    }

    public OneTableItemDialogFragment(long id,int postion) {
        this.id = id;
        this.postion = postion;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view=inflater.inflate(R.layout.fragment_onetable_itemdialog,container);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_onetable_update= (TextView) view.findViewById(R.id.txt_onetable_update);
        txt_onetable_delete= (TextView) view.findViewById(R.id.txt_onetable_delete);

        txt_onetable_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditUserOnClickListener listener= (EditUserOnClickListener) getActivity();
                listener.onEditUserOnClick(id,postion,1);
            }
        });

        txt_onetable_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditUserOnClickListener listener= (EditUserOnClickListener) getActivity();
                listener.onEditUserOnClick(id,postion,0);
            }
        });

    }
}
