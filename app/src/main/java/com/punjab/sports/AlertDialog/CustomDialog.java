package com.punjab.sports.AlertDialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.punjab.sports.R;


public class CustomDialog extends CustomBaseDialog {

    /**
     * View
     */
    private View inflate;

    /**
     * Widgets
     */
    TextView label;
    private TextView  message;
    ImageView cancel;


    /**
     * ***********************************************************************************************
     * <p/>
     * <p/>
     * This is the constructor used to initialize the view of the dialog
     * <p/>
     * <p/>
     * ************************************************************************************************
     */


    @SuppressLint("InflateParams")
    public CustomDialog(Context context, FragmentActivity activityContext, boolean isCancelable) {
        super(context, activityContext);

        inflate = LayoutInflater.from(context).inflate(
                R.layout.customdialogview, null);
        setContentView(inflate);

        label = inflate
                .findViewById(R.id.label);
        message = inflate
                .findViewById(R.id.message);
        cancel = inflate.findViewById(R.id.cancel);



        setCanceledOnTouchOutside(isCancelable);
        setCancelable(true);


    }

    /**
     * ******************************************************************************************
     * This method is used to override the show method of the dialog and handle
     * the callbacks for ok and cancel button
     * <p/>
     * <p/>
     * *******************************************************************************************
     */
    public void show(String msg,String title) {
        message.setText(msg);
        label.setText(title);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();


            }
        });

        super.show();
    }

}

