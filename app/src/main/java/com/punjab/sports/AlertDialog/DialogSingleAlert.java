package com.punjab.sports.AlertDialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.punjab.sports.Activitys.Register;
import com.punjab.sports.BaseClass.BaseFragment;
import com.punjab.sports.R;


public class DialogSingleAlert extends CustomBaseDialog {

    /**
     * View
     */
    private View inflate;

    /**
     * Widgets
     */
    TextView label;
    private TextView  message,ok,cancel;


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
    public DialogSingleAlert(Context context, FragmentActivity activityContext, boolean isCancelable) {
        super(context, activityContext);

        inflate = LayoutInflater.from(context).inflate(
                R.layout.dialog_single_alert, null);
        setContentView(inflate);

        label = inflate
                .findViewById(R.id.label);
        message = inflate
                .findViewById(R.id.message);
        ok = inflate.findViewById(R.id.ok);



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
    public void show(String msg, String button1, String title,
                     int icon, final int id,
                     final BaseFragment.OnDoubleOptionAlertClickListener listener) {
        message.setText(msg);
        ok.setText(button1);
        label.setText(title);
        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();
                listener.onDoubleOptionAlertOkClick(id);

            }
        });

        super.show();
    }
/*public interface OnDoubleOptionAlertClickListener  {
        void onDoubleOptionAlertOkClick(int id);

        void onDoubleOptionAlertCancelClick(int id);
    }*/
}
