package com.punjab.sports.BaseClass;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import java.util.Arrays;
import java.util.List;

public class ValidationsUtils {

    /**
     * Variables
     */
    private String TAG = ValidationsUtils.class.getSimpleName();
    private static ValidationsUtils instance;


    public final String[] SUPPORTED_GOOGLE_DOC_FORMATS = {".doc",
            ".docx", ".docm", ".dot", ".dotx", ".dotm", ".html", ".txt",
            ".rtf", ".odt", ".xls", ".xlsx", ".xlsm", ".xlt", ".xltx", ".xltm",
            ".ods", ".csv", ".tsv", ".tab", ".ppt", ".pptx", ".pptm", ".pps",
            ".ppsx", ".ppsm", ".pot", ".potx", ".potm", ".wmf", ".gif",
            ".pdf"};


    private ValidationsUtils() {
    }

    public static synchronized ValidationsUtils getInstance() {
        return instance == null ? instance = new ValidationsUtils()
                : instance;
    }

    /**
     * This method is used to detect internet connection.
     * <p/>
     * Returns true is internet is working and else returns false
     *
     * @return connected(boolean)
     */
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


    /**
     * Checks whether the given email address is valid.
     *
     * @param email represents the email address.
     * @return true if the email is valid, false otherwise.
     * @since 09-Feb-2009
     */
    public boolean isEmail(String email) {
        if (email == null) {
            return false;
        }

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    /**
     * Checks whether the given URL (website address) is valid.
     *
     * @param url represents the website address.
     * @return true if the email is valid, false otherwise.
     * @since 09-Feb-2009
     */
    public boolean isURL(String url) {
        if (url == null) {
            return false;
        }

        return Patterns.WEB_URL.matcher(url).matches();
    }

    /**
     * Uses androids android.telephony.PhoneNumberUtils to check if an phone
     * number is valid.
     *
     * @param number Phone number to check
     * @return true if the <code>number</code> is a valid phone number.
     */
    public boolean isValidPhoneNumber(String number) {
        if (number == null) {
            return false;
        } else {
            return PhoneNumberUtils.isGlobalPhoneNumber(number);
        }
    }


    /**
     * This method is used to check if the entered string is null, blank, or
     * "null"
     *
     * @param str set String to check
     * @return true if null else false
     */
    public boolean isEmptyOrNull(String str) {
        return !(!TextUtils.isEmpty(str) && !str.equals("null"));
    }


    /**
     * **************************************************************************
     * <p/>
     * This method is used to check if url is supported by Google Docs
     * <p/>
     * **************************************************************************
     */

    public boolean isGoogleDocsSupported(String url) {
        List<String> match = Arrays
                .asList(SUPPORTED_GOOGLE_DOC_FORMATS);
        boolean isGoogleDocsSupported = false;
        for (int i = 0; i < match.size(); i++) {
            if (!url.endsWith(match.get(i))) {
                isGoogleDocsSupported = false;
            } else {
                isGoogleDocsSupported = true;
                break;
            }
        }
        return isGoogleDocsSupported;
    }


    public boolean isOnlyZeroes(String checkForZeroes) {
        return checkForZeroes.matches("[0]+");
    }


}
