package com.punjab.sports.BaseClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.punjab.sports.AlertDialog.DialogSingleAlert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public abstract class BaseFragment extends Fragment {


    String TAG = "CAPIC";


    protected FragmentUtils mFragmentUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

    }

    public void setBackButtonFunctionality() {

        getActivity()
                .onBackPressed();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub




        mFragmentUtils = FragmentUtils.getInstance();
        return initUI(inflater, container);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void Shared(){


    }

    public boolean isOnline(Context context) {
        boolean mConnected;
        try {
            Log.e(TAG, "Detect Connection");
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            mConnected = networkInfo != null && networkInfo.isAvailable()
                    && networkInfo.isConnected();

        } catch (Exception e) {

            mConnected = false;
            e.printStackTrace();
        }
        Log.e(TAG, "mConnected = " + mConnected);
        return mConnected;

    }


    protected abstract View initUI(LayoutInflater inflater, ViewGroup container);


    /**
     * This is interface for double option dialogs
     */
    public interface OnDoubleOptionAlertClickListener {
        void onDoubleOptionAlertOkClick(int id);

        void onDoubleOptionAlertCancelClick(int id);
    }

    public void customDoubleOptionAlert(Context context, String msg, String button1, String title, int icon, final int id,
                                        boolean isCancelable, final OnDoubleOptionAlertClickListener listener) {

        // show the alert dialog
        DialogSingleAlert alert = new DialogSingleAlert(context,
                (FragmentActivity) context, isCancelable);
        alert.show(msg, button1, title, icon, id, listener);

    }


    /**
     * This method is used to replaceFragment with another fragment
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    protected final void replaceFragment(int replaceId, Fragment fragment,
                                         String tag, boolean isBackStack) {
        if (mFragmentUtils == null) {
            mFragmentUtils = FragmentUtils.getInstance();
        }
        /*if (getActivity() != null) {
            mApplicationUtils.showHideKeyboard(getActivity(), false);
        }*/
        mFragmentUtils.replaceFragment(getActivity(), replaceId, fragment, tag, isBackStack);

    }

    protected final void addFragment(int replaceId, Fragment fragment,
                                         String tag, boolean isBackStack) {
        if (mFragmentUtils == null) {
            mFragmentUtils = FragmentUtils.getInstance();
        }
        /*if (getActivity() != null) {
            mApplicationUtils.showHideKeyboard(getActivity(), false);
        }*/
        mFragmentUtils.addFragment(getActivity(), replaceId, fragment, tag, isBackStack);

    }
    /**
     * This method is used to get various types of date or time according to the rquirement
     */

    public static final int CURRENT_DATE_TIME = 0;
    public static final int CURRENT_DATE = 1;
    public static final int CURRENT_TIME = 2;
    public static final int ONLY_DATE = 3;
    public static final int ONLY_TIME = 4;
    public static final int ONLY_DATE_NORWEGIAN = 5;
    public static final int DATE_TIME_NORWEGIAN = 6;
    public static final int T_TYPE_ONLY_DATE = 7;
    public static final int T_TYPE__DATE_AND_TIME = 8;
    public static final int TICKS = 9;

    @SuppressLint("SimpleDateFormat")
    public String getDateAndTime(int type, String dateValue,
                                 String currentFormat, String requiredFormat) {
        String date = "";
        SimpleDateFormat sdf;
        if (!ValidationsUtils.getInstance().isEmptyOrNull(dateValue)) {
            // Get Current Date
            if (type == CURRENT_DATE) {
                if (TextUtils.isEmpty(requiredFormat)) {
                    requiredFormat = "dd.MM.yyyy";
                }
                sdf = new SimpleDateFormat(requiredFormat, Locale.ENGLISH);
                date = sdf.format(new Date());
            }
            // Get Current Time
            if (type == CURRENT_TIME) {
                if (TextUtils.isEmpty(requiredFormat)) {
                    requiredFormat = "hh:mm:ss";
                }
                sdf = new SimpleDateFormat(requiredFormat, Locale.ENGLISH);
                date = sdf.format(new Date());
            }
            // Get Current Date and Time
            if (type == CURRENT_DATE_TIME) {
                if (TextUtils.isEmpty(requiredFormat)) {
                    requiredFormat = "dd.MM.yyyy hh:mm:ss";
                }
                sdf = new SimpleDateFormat(requiredFormat, Locale.ENGLISH);
                date = sdf.format(new Date());
            }
            // Change Date Format
            if (type == ONLY_DATE) {
                sdf = new SimpleDateFormat(currentFormat);
                Date tempDate;
                try {
                    tempDate = sdf.parse(dateValue);
                    if (TextUtils.isEmpty(requiredFormat)) {
                        requiredFormat = "dd.MM.yyyy";
                    }
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            requiredFormat);
                    String formattedDate = dateFormat.format(tempDate);
                    date = formattedDate;
                } catch (ParseException e) {
                    date = dateValue;
                    e.printStackTrace();
                }
            }
            // Change Time Format
            if (type == ONLY_TIME) {
                sdf = new SimpleDateFormat(currentFormat);
                Date tempDate;
                try {
                    tempDate = sdf.parse(dateValue);
                    SimpleDateFormat dateFormat;
                    if (TextUtils.isEmpty(requiredFormat)) {
                        requiredFormat = "hh:mm a";
                    }
                    dateFormat = new SimpleDateFormat(
                            requiredFormat);
                    String formattedDate = dateFormat.format(tempDate);
                    date = formattedDate;
                } catch (ParseException e) {
                    date = dateValue;
                    e.printStackTrace();
                }
            }
            // Change Date Format to Norwegian
            if (type == ONLY_DATE_NORWEGIAN) {
                sdf = new SimpleDateFormat(currentFormat);
                Date tempDate;
                try {
                    tempDate = sdf.parse(dateValue);
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd.MM.yyyy");
                    String formattedDate = dateFormat.format(tempDate);
                    date = formattedDate;
                } catch (ParseException e) {
                    date = dateValue;
                    e.printStackTrace();
                }
            }
            // Change Date and Time Format to Norwegian
            if (type == DATE_TIME_NORWEGIAN) {
                sdf = new SimpleDateFormat(currentFormat);
                Date tempDate;
                try {
                    tempDate = sdf.parse(dateValue);
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "dd.MM.yyyy hh:mm a");
                    String formattedDate = dateFormat.format(tempDate);
                    date = formattedDate;
                } catch (ParseException e) {
                    date = dateValue;
                    e.printStackTrace();
                }
            }
            // Change T type date to only date or date and time format
            if (type == T_TYPE_ONLY_DATE
                    || type == T_TYPE__DATE_AND_TIME) {
                sdf = new SimpleDateFormat(currentFormat);
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                try {
                    Date tempDate = sdf.parse(dateValue.split("T")[0]);
                    Date tempTime = sdf.parse(dateValue.split("T")[1]);
                    if (TextUtils.isEmpty(requiredFormat)) {
                        requiredFormat = "dd.MM.yyyy";
                    }
                    SimpleDateFormat formattedDate = new SimpleDateFormat(
                            requiredFormat);
                    SimpleDateFormat formattedTime = new SimpleDateFormat(
                            "hh:mm a");
                    String formattedDateValue = formattedDate.format(tempDate);
                    String formattedTimeValue = formattedTime.format(tempTime);
                    date = formattedDateValue;
                    if (type == T_TYPE__DATE_AND_TIME) {
                        date = date + "\t" + formattedTimeValue;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            // Change ticks to required format
            if (type == TICKS) {
                // Create a DateFormatter object for displaying date in
                // specified
                // format.
                dateValue = dateValue.substring(6, dateValue.length() - 7);
                long dateInMilliSecondsFormat = Long.parseLong(dateValue);
                if (TextUtils.isEmpty(requiredFormat)) {
                    requiredFormat = "dd.MM.yyyy hh:mm a";
                }
                SimpleDateFormat formatter = new SimpleDateFormat(
                        requiredFormat);
                // Create a calendar object that will convert the date and time
                // value in
                // milliseconds to date.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(dateInMilliSecondsFormat);
                date = formatter.format(calendar.getTime());

            }
        }
        return date;
    }
}
