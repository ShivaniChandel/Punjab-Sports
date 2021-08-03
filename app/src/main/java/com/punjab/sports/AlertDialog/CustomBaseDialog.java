package com.punjab.sports.AlertDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.fragment.app.FragmentActivity;

/**
 * This is custom dialog due to use its default overrided methods
 *
 * @author amit.singh
 */
public class CustomBaseDialog extends Dialog implements DialogInterface.OnDismissListener {
    private Context context;

    private FragmentActivity activityContext;

    public FragmentActivity getActivityContext() {
        return activityContext;
    }

    public CustomBaseDialog(Context context, FragmentActivity activityContext) {
        super(context);
        // TODO Auto-generated constructor stub
        this.activityContext = activityContext;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }


    @Override
    public void onDismiss(DialogInterface dialogInterface) {

    }
}
