package fwq.hdsx.com.lccdemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


public class twoTableDialogTypeFragment extends DialogFragment {


    private String typeName;
    private long typeId;
    private int postion;

    private String btnText;

    public twoTableDialogTypeFragment(long typeId,String typeName,int postion) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.postion = postion;
    }

    public interface addInfoTypeOnClickListener
    {
        void OnaddInfoTypeOnClickListener(String typeName,long typeId,int postion);
    }

    private EditText edit_twotable_typeName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_twotable_dialog, null);

        edit_twotable_typeName = (EditText)view.findViewById(R.id.edit_twotable_typeName);
        edit_twotable_typeName.setText(typeName);

        if(typeId!=0)
        {
            btnText = "修改";
        }else
        {
            btnText = "添加";
        }

        builder.setView(view)
                .setTitle("添加新闻类别")
                .setPositiveButton(btnText,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                addInfoTypeOnClickListener addtype = (addInfoTypeOnClickListener)getActivity();
                                addtype.OnaddInfoTypeOnClickListener(edit_twotable_typeName.getText().toString(),typeId,postion);
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edit_twotable_typeName.setText("");
                            }
                        });

        return builder.show();
    }
}
