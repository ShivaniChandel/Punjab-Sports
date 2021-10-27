package com.punjab.sports.BaseClass;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class FragmentUtils {

    /**
     * Variables
     */

    private static FragmentUtils instance;
    private String TAG = FragmentUtils.class.getSimpleName();

    private FragmentUtils() {
    }

    public static synchronized FragmentUtils getInstance() {
        return instance == null ? instance = new FragmentUtils()
                : instance;
    }

    /**
     * This method is used to replaceFragment with another fragment
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void replaceFragment(FragmentActivity activity, int replaceId, Fragment fragment,
                                      String tag, boolean isBackStack) {
        ValidationsUtils mValidationsUtils = ValidationsUtils.getInstance();

        Log.i(TAG, "activity ============= Fragmrnts"+activity);

        if (activity == null)
            return;
        FragmentTransaction ft = activity.getSupportFragmentManager()
                .beginTransaction();
        //   ft.setCustomAnimations(R.anim.left_anim, R.anim.right_anim);
        Log.i(TAG, "Change ============= Fragmrnts");
        if (!mValidationsUtils.isEmptyOrNull(tag)) {
            ft.replace(replaceId, fragment, tag);
        } else {
            ft.replace(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();

    }


    /**
     * This method is used to addFragment for the first time
     *
     * @param replaceId   Set id of the view on which fragment is to replaced
     * @param fragment    fragment which is to called
     * @param tag         Set tag if needed otherwise set null
     * @param isBackStack Set true if need backStack else false
     */
    public final void addFragment(FragmentActivity activity, int replaceId, Fragment fragment,
                                  String tag, boolean isBackStack) {
        ValidationsUtils mValidationsUtils = ValidationsUtils.getInstance();
        if (activity == null)
            return;
        FragmentTransaction ft = activity.getSupportFragmentManager()
                .beginTransaction();
        //    ft.setCustomAnimations(R.anim.left_anim, R.anim.right_anim);
        if (!mValidationsUtils.isEmptyOrNull(tag)) {
            ft.add(replaceId, fragment, tag);
        } else {
            ft.add(replaceId, fragment);
        }
        if (isBackStack) {
            ft.addToBackStack(tag);
        }
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }

    /**
     * This method is used to popFragment from stack
     */
    public final void popFragment(FragmentActivity activity, int replaceId) {
        if (activity == null)
            return;
        if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            FragmentTransaction fragTrans = activity
                    .getSupportFragmentManager().beginTransaction();
            //      fragTrans.setCustomAnimations(R.anim.r_t_l, R.anim.l_t_r);
            fragTrans.remove(activity.getSupportFragmentManager()
                    .findFragmentById(replaceId));
            fragTrans.commitAllowingStateLoss();
            activity.getSupportFragmentManager().popBackStackImmediate();
        }
    }

    /**
     * This method is used to popFragment from stack
     */
    public final void popFragment(FragmentActivity activity, String tag) {
        if (activity == null)
            return;
        if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            FragmentTransaction fragTrans = activity
                    .getSupportFragmentManager().beginTransaction();
            fragTrans.remove(activity.getSupportFragmentManager()
                    .findFragmentByTag(tag));
            fragTrans.commitAllowingStateLoss();
            activity.getSupportFragmentManager().popBackStackImmediate();
        }
    }

    /**
     * This method is used to clear all the fragments from stack
     */
    public final void clearBackStack(FragmentActivity activity) {
        try {
            if (activity == null)
                return;
            FragmentManager fm = activity.getSupportFragmentManager();
            for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                String fragTag = fm.getBackStackEntryAt(i).getName();
                Fragment fragment = fm.findFragmentByTag(fragTag);
                FragmentTransaction fragTrans = activity
                        .getSupportFragmentManager().beginTransaction();
                fragTrans.remove(fragment);
                fragTrans.commitAllowingStateLoss();
                fm.popBackStack();
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to remove all the stack in async
     */
    public final void clearAllStack(FragmentActivity activity) {
        if (activity == null)
            return;
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * This method is used to remove all the stack in sync
     */
    public final void clearAllStackImmediate(FragmentActivity activity) {
        if (activity == null)
            return;
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * This method is used to get the top fragmnet on the stack
     *
     * @return {@link Fragment}
     */
    public final Fragment getTopFragmentStack(FragmentActivity activity) {
        if (activity == null)
            return null;
        FragmentManager fm = activity.getSupportFragmentManager();
        Fragment fragment = null;
        for (int entry = 0; entry < fm.getBackStackEntryCount(); entry++) {
            fragment = fm.findFragmentByTag(fm.getBackStackEntryAt(entry)
                    .getName());
        }
        return fragment;
    }

    /**
     * This method is used to get List of backstack fragments
     *
     * @return {@link List}
     */
    public final List<String> getStackList(FragmentActivity activity) {
        if (activity == null)
            return null;
        List<String> stackList = new ArrayList<String>();
        stackList.clear();
        FragmentManager fm = activity.getSupportFragmentManager();
        for (int entry = 0; entry < fm.getBackStackEntryCount(); entry++) {
            stackList.add(fm.getBackStackEntryAt(entry).getName());
        }
        return stackList;
    }

    /**
     * This method is used to get the fragment
     *
     * @param id set UniqueId
     * @return {@link Fragment}
     */
    public Fragment getFragment(FragmentActivity activity, int id) {
        if (activity == null)
            return null;
        return activity.getSupportFragmentManager().findFragmentById(id);
    }

    /**
     * This method is used to get the fragment
     *
     * @param tag set UniqueTag
     * @return {@link Fragment}
     */
    public Fragment getFragment(FragmentActivity activity, String tag) {
        if (activity == null)
            return null;
        return activity.getSupportFragmentManager().findFragmentByTag(tag);
    }

    /**
     * **************************************************************************
     * This method is used to find fragment by its Id
     *
     * @param id set the id of fragment
     * @return {@link Fragment}
     * <p/>
     * **************************************************************************
     */
    public final Fragment findFragmentById(FragmentActivity activity, int id) {
        if (activity == null)
            return null;
        return activity.getSupportFragmentManager().findFragmentById(id);
    }

    /**
     * **************************************************************************
     * This method is used to find fragment by its TAG
     *
     * @return {@link Fragment}
     * <p/>
     * **************************************************************************
     */
    public final Fragment findFragmentByTag(FragmentActivity activity, String tag) {
        if (activity == null)
            return null;
        return activity.getSupportFragmentManager().findFragmentByTag(tag);
    }
}
