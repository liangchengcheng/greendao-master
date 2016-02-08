package fwq.hdsx.com.lccdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class twoTableDialogTypeItemFragment extends DialogFragment {


    public interface txtClickListener
    {
        void OntxtClickListener(int flag,long typeId,int postion);
    }

    private long typeId;
    private int postion;

    public twoTableDialogTypeItemFragment(long typeId,int postion) {
        this.typeId = typeId;
        this.postion = postion;
    }

    private TextView txt_twotable_typeitem_edit;
    private TextView txt_twotable_typeitem_delete;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_twotable_typeitem_edit = (TextView)view.findViewById(R.id.txt_twotable_typeitem_edit);
        txt_twotable_typeitem_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtClickListener txtClick = (txtClickListener)getActivity();
                txtClick.OntxtClickListener(1,typeId,postion);
            }
        });
        txt_twotable_typeitem_delete = (TextView)view.findViewById(R.id.txt_twotable_typeitem_delete);
        txt_twotable_typeitem_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtClickListener txtClick = (txtClickListener)getActivity();
                txtClick.OntxtClickListener(0,typeId,postion);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_twotable_typeitemdialog,container);

        return view;
    }
}