package com.punjab.sports.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;
import com.punjab.sports.AdapterClass.CenterAccToSportAdapter;
import com.punjab.sports.AdapterClass.CoachAccToCentreAdapter;
import com.punjab.sports.AdapterClass.SportsDistrictAdapter;
import com.punjab.sports.AdapterClass.SportsappliedforAdapter;
import com.punjab.sports.AlertDialog.DialogSingleAlert;
import com.punjab.sports.BaseClass.BaseFragment;
import com.punjab.sports.ModelClasses.CenterAccToSport;
import com.punjab.sports.ModelClasses.CoachAccToCentre;
import com.punjab.sports.ModelClasses.SportsAppliedFor;
import com.punjab.sports.ModelClasses.SportsDistrict;
import com.punjab.sports.ModelClasses.SubCategoryTospoSport;
import com.punjab.sports.R;
import com.punjab.sports.sevices.CustomProgressWheel;
import com.punjab.sports.sevices.Datamanger;
import com.punjab.sports.sevices.registeration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.text.TextUtils.isEmpty;

public class PISRegister extends AppCompatActivity implements Datamanger.getregister, BaseFragment.OnDoubleOptionAlertClickListener, Datamanger.getpisregister, Datamanger.getPISportsAppliedFormanager, Datamanger.getPISCenterAccToSportmanager, Datamanger.getPISCoachAccToCentremanager, Datamanger.getPISportsDistrictmanager, Datamanger.getPISubCategoryTospoSportmanager, MultiSpinnerListener {


    /*LOADER VARIABLE*/
    private CustomProgressWheel fragment_resources_link_progress_wheel;
    FrameLayout rlClick;
    TextView title_txt, register_btn;
    EditText name, Aadhaar, fathername, mothername, fathers_occupation, class_pc, blood_group, city, email, phone, emergency, username, passward, confpass, address;
    ImageView back_img;
    TextView dob;
    MultiSpinnerSearch msportscenter, msportssubcategory;
    Spinner gender_1, diet_1, statename, state, sportsappliedfor, sportssubcategory, sportscenter, coaches, sportsachive, sportsarea, caste;
    SportsappliedforAdapter adapter1;
    com.punjab.sports.AdapterClass.SubCategoryTospoSport adapter2;
    CenterAccToSportAdapter adapter3;
    CoachAccToCentreAdapter adapter4;
    SportsDistrictAdapter adapter5;

    List<SportsAppliedFor> response1;
    List<SubCategoryTospoSport> response2;
    List<CenterAccToSport> response3;
    List<CoachAccToCentre> response4;
    List<SportsDistrict> response5;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    boolean registervalue = false;
    String valueofstring = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        datamanager = new Datamanger();
        getpisregister = this;
        getPISportsAppliedFormanager = this;
        getPISCenterAccToSportmanager = this;
        getPISCoachAccToCentremanager = this;
        getPISportsDistrictmanager = this;
     //   registervalue = getIntent().getBooleanExtra("register", false);
        valueofstring = getIntent().getStringExtra("value");
     //   Log.i("TAG", "======registervalue=====" + registervalue);
        Log.i("TAG", "======valueofstring=====" + valueofstring);
        init();
    }

    /*API HITS*/
    private Datamanger datamanager;
    Datamanger.getpisregister getpisregister;
    Datamanger.getPISportsAppliedFormanager getPISportsAppliedFormanager;
    Datamanger.getPISCenterAccToSportmanager getPISCenterAccToSportmanager;
    Datamanger.getPISCoachAccToCentremanager getPISCoachAccToCentremanager;
    Datamanger.getPISportsDistrictmanager getPISportsDistrictmanager;

    @Override
    public void onSucess(registeration response) {
        try {

            Log.i("TAG", "======onSucess=====" + response);
            showloader(false);
            Intent i = new Intent(this, SuccessMessage.class);
            startActivity(i);


            //customDoubleOptionAlert(PISRegister.this, response.getMessage(), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSucess(List<SportsAppliedFor> response) {
        try {

            showloader(false);
// we pass our item list and context to our Adapter.
            Log.i("TAG", "======response sgsgno no=====" + response.size());


            response1.clear();
            multipledata.clear();
            multiplecenterdata.clear();

            // A text that will display in search hint.
            msportssubcategory.setSearchHint("--Select--");
            msportscenter.setSearchHint("--Select--");

            response4.clear();
            response1 = response;
            SportsAppliedFor sportsAppliedFor = new SportsAppliedFor();
            Log.i("TAG", "======SportName=====" + response1.size());


            sportsAppliedFor.setSportName("--Select--");
            sportsAppliedFor.setSportID("--Select--");
            response1.add(0, sportsAppliedFor);
            Log.i("TAG", "======SportName2=====" + response1.size());
            Log.i("TAG", "======response no no=====" + response.size());
            adapter1 = new SportsappliedforAdapter(this, response);
            sportsappliedfor.setAdapter(adapter1);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    List<KeyPairBoolData> multiplecenterdata;

    @Override
    public void CenterAcc(List<CenterAccToSport> response) {

        try {

            showloader(false);
            multiplecenterdata.clear();

            // A text that will display in search hint.
            msportscenter.setSearchHint("--Select--");
// we pass our item list and context to our Adapter.
         /*   response3.clear();
            response3 = response;

//            Log.i("TAG", "======getLocation=====" + response3.get(0).getLocation());

            CenterAccToSport centerAccToSport = new CenterAccToSport();
            centerAccToSport.setTcName("--Select--");
            centerAccToSport.setTcid("--Select--");
            response3.add(0, centerAccToSport);
            Log.i("TAG", "======getLocation2=====" + response3.get(0).getTcName());


            adapter3 = new CenterAccToSportAdapter(this, response);
            sportscenter.setAdapter(adapter3);
*/

            for (int i = 0; i < response.size(); i++) {
                Log.i("TAG", "======i=====" + i);
                Log.i("TAG", "======namemmmm=====" + response.get(i).getTcName().toString());
                KeyPairBoolData keyPairBoolData = new KeyPairBoolData();
                keyPairBoolData.setId(Long.parseLong(response.get(i).getTcid().toString()));
                keyPairBoolData.setName(response.get(i).getTcName().toString() + "," + response.get(i).getLocation().toString());
                multiplecenterdata.add(i, keyPairBoolData);
            }

            Log.i("TAG", "======multiplecenterdata.ssss=====" + multiplecenterdata.size());
            // Removed second parameter, position. Its not required now..
            // If you want to pass preselected items, you can do it while making listArray,
            // pass true in setSelected of any item that you want to preselect

            // msportscenter.setItems(multiplecenterdata, this);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    List<KeyPairBoolData> multipledata;

    @Override
    public void SubCategoryTos(List<SubCategoryTospoSport> response) {
        try {

            showloader(false);
// we pass our item list and context to our Adapter.
            //  response2.clear();
            multipledata.clear();

            // A text that will display in search hint.
            msportssubcategory.setSearchHint("--Select--");

//            Log.i("TAG", "======getSportsSubCategoryName=====" + response2.get(0).getSportsSubCategoryName());

           /* SubCategoryTospoSport subCategoryTospoSport = new SubCategoryTospoSport();
            subCategoryTospoSport.setSportsSubCategoryName("--Select--");
            subCategoryTospoSport.setSportID("--Select--");
            response2.add(0, subCategoryTospoSport);
            Log.i("TAG", "======getSportsSubCategoryName2=====" + response2.get(1).getSportsSubCategoryName());

            Log.i("TAG", "======response2.ssss=====" +response2.size());
            adapter2 = new com.punjab.sports.AdapterClass.SubCategoryTospoSport(this, response);
            sportssubcategory.setAdapter(adapter2);
           */


            for (int i = 0; i < response.size(); i++) {
                Log.i("TAG", "======i=====" + i);
                Log.i("TAG", "======namemmmm=====" + response.get(i).getSportsSubCategoryName().toString());
                KeyPairBoolData keyPairBoolData = new KeyPairBoolData();
                keyPairBoolData.setId(Long.parseLong(response.get(i).getSubCatID().toString()));
                keyPairBoolData.setName(response.get(i).getSportsSubCategoryName().toString());
                multipledata.add(i, keyPairBoolData);
            }

            Log.i("TAG", "======multipledata.ssss=====" + multipledata.size());
            // Removed second parameter, position. Its not required now..
            // If you want to pass preselected items, you can do it while making listArray,
            // pass true in setSelected of any item that you want to preselect


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void CoachAcc(List<CoachAccToCentre> response) {
        try {

            showloader(false);
// we pass our item list and context to our Adapter.
            response4.clear();
            response4 = response;
//            Log.i("TAG", "======getCoachName=====" + response4.get(0).getCoachName());

            CoachAccToCentre coachAccToCentre = new CoachAccToCentre();
            coachAccToCentre.setCoachName("--Select--");
            coachAccToCentre.setCoachID("--Select--");
            response4.add(0, coachAccToCentre);
            Log.i("TAG", "======getCoachName2=====" + response4.get(0).getCoachName());


            //if (response.size() > 0) {

            adapter4 = new CoachAccToCentreAdapter(this, response);
            coaches.setAdapter(adapter4);

           /* } else {

            }
*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void SubDist(List<SportsDistrict> response) {
        try {

            showloader(false);
// we pass our item list and context to our Adapter.


            multipledata.clear();
            multiplecenterdata.clear();
            response4.clear();
            response5.clear();

            response5 = response;

            // A text that will display in search hint.
            msportssubcategory.setSearchHint("--Select--");
            msportscenter.setSearchHint("--Select--");
            SportsDistrict sportsDistrict = new SportsDistrict();
            Log.i("TAG", "======sportsDistrict==g===" + response.size());


            sportsDistrict.setDistrictName("--Select--");
            sportsDistrict.setDistrictID("0");
            response5.add(0, sportsDistrict);


            Log.i("TAG", "======sportsDistrict=====" + response5.size());
            adapter5 = new SportsDistrictAdapter(this, response5);
            state.setAdapter(adapter5);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(String message) {
        try {

            Log.i("TAG", "======message=====" + message);
            showloader(false);
            customDoubleOptionAlert(PISRegister.this, message, "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void noCase(String message) {
        try {

            Log.i("TAG", "======message=====" + message);
            showloader(false);
            customDoubleOptionAlert(PISRegister.this, message, "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDoubleOptionAlertOkClick(int id) {

    }

    @Override
    public void onDoubleOptionAlertCancelClick(int id) {

    }


    public void showloader(boolean value) {
        Log.i("TAG", "======showloader=====" + value);
        if (value) {
            rlClick.setVisibility(View.VISIBLE);
            fragment_resources_link_progress_wheel.spin();
            fragment_resources_link_progress_wheel.setVisibility(View.VISIBLE);

        } else {
            fragment_resources_link_progress_wheel.stopSpinning();
            fragment_resources_link_progress_wheel.setVisibility(View.GONE);
            rlClick.setVisibility(View.GONE);
        }

    }


    // create array of Strings
    // and store name of courses
    String[] gender = {"Male", "Female"};
    String[] state_name = {"Punjab"};
    String[] Diet = {"Veg", "Non Veg"};
    String[] Achaviments = {"Beginner", "District", "State", "National games", "International", "Inter collage", "Inter university",};
    String[] SportsAre = {"School", "Open", "University"};
    String[] Cast = {"General", "SC", "ST", "OBC"};

    String sgender, sdiet, selected_state = "", sstate = "", sappiled = "", scategory = "", scentre = "", scoach = "", sachive, sarea, scast;


    public boolean validation() {
        boolean value = false;

        if (!isEmpty(name.getText().toString()) && !isEmpty(Aadhaar.getText().toString())
                && !isEmpty(fathername.getText().toString())
                && !isEmpty(mothername.getText().toString())
                && !isEmpty(dob.getText().toString())
                && !isEmpty(class_pc.getText().toString())
                && !isEmpty(city.getText().toString())
                && !isEmpty(sstate) && !isEmpty(scentre)
                && !isEmpty(scoach) && !isEmpty(sappiled)
                && !isEmpty(emergency.getText().toString()) && !isEmpty(username.getText().toString())
                && !isEmpty(passward.getText().toString()) && !isEmpty(confpass.getText().toString())
                && (confpass.getText().toString().equalsIgnoreCase(passward.getText().toString()))
                && !isEmpty(address.getText().toString())


        ) {
            Log.i("TAG", "=======in==========");

            value = true;
        } else {

            if (isEmpty(name.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.namenotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
                // mToastUtils.showSnackBar(LoginScreen.this,getResources().getString(R.string.enter_email_valid),true);
            } else if (isEmpty(Aadhaar.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.aadharnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(fathername.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.fathernotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(mothername.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.mothernotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(dob.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.donnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(class_pc.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.classnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(city.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.citynotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(sstate)) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.statenotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            }/* else if (isEmpty(phone.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.phonenotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            }*/ else if (isEmpty(emergency.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.emergencynotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(sappiled)) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.appliednotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(scentre)) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.centrenotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(scoach)) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.coachnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(username.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.usernotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(passward.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.passwordnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(confpass.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.confpassnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (!confpass.getText().toString().equalsIgnoreCase(passward.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.notmathch), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            } else if (isEmpty(address.getText().toString())) {
                value = false;
                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.addressnotfound), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, true, this);
            }

            Log.i("TAG", "=======out==========" + value);
        }

        return value;
    }


    public void init() {

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        response1 = new ArrayList<SportsAppliedFor>();
        response2 = new ArrayList<SubCategoryTospoSport>();
        response3 = new ArrayList<CenterAccToSport>();
        response4 = new ArrayList<CoachAccToCentre>();
        response5 = new ArrayList<SportsDistrict>();
        multipledata = new ArrayList<KeyPairBoolData>();
        multiplecenterdata = new ArrayList<KeyPairBoolData>();
        response1.clear();
        multipledata.clear();
        multiplecenterdata.clear();
        response4.clear();
        response5.clear();


        fragment_resources_link_progress_wheel = findViewById(R.id.fragment_resources_link_progress_wheel);
        rlClick = findViewById(R.id.rlClick);

        showloader(false);

        register_btn = findViewById(R.id.register_btn);
        title_txt = findViewById(R.id.title_txt);

        title_txt.setText(valueofstring);

        back_img = findViewById(R.id.back_img);

        dob = findViewById(R.id.dob);

        name = findViewById(R.id.name);
        Aadhaar = findViewById(R.id.Aadhaar);
        fathername = findViewById(R.id.fathername);
        mothername = findViewById(R.id.mothername);
        fathers_occupation = findViewById(R.id.fathers_occupation);
        class_pc = findViewById(R.id.class_pc);
        blood_group = findViewById(R.id.blood_group);
        city = findViewById(R.id.city);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        emergency = findViewById(R.id.emergency);
        username = findViewById(R.id.username);
        passward = findViewById(R.id.passward);
        confpass = findViewById(R.id.confpass);
        address = findViewById(R.id.address);

        gender_1 = findViewById(R.id.gender_1);
        diet_1 = findViewById(R.id.diet_1);
        state = findViewById(R.id.state);
        statename = findViewById(R.id.statename);
        sportsappliedfor = findViewById(R.id.sportsappliedfor);
        sportssubcategory = findViewById(R.id.sportssubcategory);
        sportscenter = findViewById(R.id.sportscenter);
        coaches = findViewById(R.id.coaches);
        sportsachive = findViewById(R.id.sportsachive);
        sportsarea = findViewById(R.id.sportsarea);
        caste = findViewById(R.id.caste);
        //Multiple spinner
        msportssubcategory = findViewById(R.id.msportssubcategory);
        msportscenter = findViewById(R.id.msportscenter);


// Pass true If you want searchView above the list. Otherwise false. default = true.
        msportssubcategory.setSearchEnabled(false);
        msportscenter.setSearchEnabled(false);

        // A text that will display in search hint.
        msportssubcategory.setSearchHint("--Select--");
        msportscenter.setSearchHint("--Select--");

        // Set text that will display when search result not found...
        msportssubcategory.setEmptyTitle("Not Data Found!");
        msportscenter.setEmptyTitle("Not Data Found!");

        // If you will set the limit, this button will not display automatically.
        msportssubcategory.setShowSelectAllButton(false);
        msportscenter.setShowSelectAllButton(false);

        //A text that will display in clear text button
        msportssubcategory.setClearText("Close & Clear");
        msportscenter.setClearText("Close & Clear");

        msportssubcategory.setItems(multipledata, PISRegister.this);

        msportscenter.setItems(multiplecenterdata, new MultiSpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> items) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).isSelected()) {
                        Log.i("========msportscenter==========", i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
                        sb.append(items.get(i).getId() + ",");

                    }
                }
                scentre = sb.toString();
                scentre = scentre.replaceAll(",$", "");
                Log.i("TAG", "======response1=====" + sb.toString());
                Log.i("TAG", "======response1=====" + scentre);

                try {
                    if (isOnline(getApplicationContext())) {

                        if (response4.size() > 0)
                            response4.clear();
                        if (sb.toString().length() > 0) {
                            showloader(true);
                            Log.i("TAG", "======scentre=====" + scentre);
                            datamanager.getPISCoachAccToCentre(PISRegister.this, scentre, sappiled, scategory,sstate);
                        }

                    } else {
                        customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        if (isOnline(getApplicationContext())) {
            showloader(true);
            datamanager.getPISportsDistrict(PISRegister.this);
        } else {
            showloader(false);
            customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
        }


        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                gender);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        gender_1.setAdapter(ad);

        ArrayAdapter diet
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Diet);
        diet.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        diet_1.setAdapter(diet);


        ArrayAdapter statead
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                state_name);
        statead.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        statename.setAdapter(statead);


        ArrayAdapter achice
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Achaviments);
        achice.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        sportsachive.setAdapter(achice);


        ArrayAdapter area
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                SportsAre);
        area.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        sportsarea.setAdapter(area);


        ArrayAdapter castad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Cast);
        castad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        caste.setAdapter(castad);


     /*   SportsDistrict sportsDistrict = new SportsDistrict();
        sportsDistrict.setDistrictID("0");
        sportsDistrict.setDistrictName("--Select--");
        response5.add(0, sportsDistrict);
        Log.i("TAG", "======response5HDHD=====" + response5.get(0).getDistrictName());


        adapter5 = new com.punjab.sports.AdapterClass.SportsDistrictAdapter(this, response5);
        state.setAdapter(adapter5);
*/

//        Log.i("TAG", "======getSportsSubCategoryName=====" + response2.get(0).getSportsSubCategoryName());
        ResetSpinners();


        gender_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sgender = gender_1.getSelectedItem().toString();
                Log.i("TAG", "======sgender=====" + sgender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        diet_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sdiet = diet_1.getSelectedItem().toString();
                Log.i("TAG", "======sdiet=====" + sdiet);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        statename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selected_state = statename.getSelectedItem().toString();
                Log.i("TAG", "======sdiet=====" + sdiet);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if (response5.size() > 0)
                        if (!response5.get(position).getDistrictName().toString().equalsIgnoreCase("--Select--")) {
                            multiplecenterdata.clear();
                            multipledata.clear();

                            // A text that will display in search hint.
                            msportssubcategory.setSearchHint("--Select--");
                            msportscenter.setSearchHint("--Select--");
                            response4.clear();
                            ResetSpinners();
                            sstate = response5.get(position).getDistrictID();
                            if (isOnline(getApplicationContext())) {
                                showloader(true);
                                datamanager.getPISportsAppliedFor(PISRegister.this);
                            } else {
                                showloader(false);
                                customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
                            }

                        }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i("TAG", "======sstate=====" + sstate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sportsappliedfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG", "======position=====" + position);
                Log.i("TAG", "======response4=====" + response4.size());
                Log.i("TAG", "======response1=====" + response1.get(position).getSportID());

                try {
                    if (!response1.get(position).getSportID().equalsIgnoreCase("--Select--"))
                        if (isOnline(getApplicationContext())) {

                            sappiled = response1.get(position).getSportID().toString();
                            Log.i("TAG", "======sappiled=====" + sappiled);
                            showloader(true);
                            multiplecenterdata.clear();
                            multipledata.clear();

                            // A text that will display in search hint.
                            msportssubcategory.setSearchHint("--Select--");
                            msportscenter.setSearchHint("--Select--");
                            response4.clear();
                            scategory = "";
                            ResetSpinners();
                            datamanager.getPISubCategoryTospoSport(PISRegister.this, String.valueOf(response1.get(position).getSportID()));
                            //  datamanager.getCenterAccToSport(PISRegister.this, String.valueOf(response1.get(position).getSportID()), sstate, scategory);

                        } else {
                            customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
                        }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


      /*  sportssubcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if (!response2.get(position).getSportsSubCategoryName().toString().equalsIgnoreCase("--Select--")) {
                        scategory = response2.get(position).getSubCatID().toString();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i("TAG", "======scategory=====" + scategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


        sportsarea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {

                    sarea = sportsarea.getSelectedItem().toString();

                    /*if (sportsarea.getSelectedItem().toString().equalsIgnoreCase("Open")) {
                        sarea = "2";
                    } else {
                        sarea = "1" +
                                "";
                    }*/
                    Log.i("TAG", "======position=====" + position);
                    Log.i("TAG", "======sarea=====" + sarea);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        coaches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG", "======response4hdhd=====" + response4.size());


                if (response4.size() > 0)
                    if (!response4.get(position).getCoachName().equalsIgnoreCase("--Select--")) {
                        scoach = response4.get(position).getCoachID().toString();
                        Log.i("TAG", "======scoach=====" + scoach);
                    } else {/*
                        CoachAccToCentre coachAccToCentre = new CoachAccToCentre();
                        coachAccToCentre.setCoachName("--Select--");
                        coachAccToCentre.setCoachID("--Select--");
                        response4.add(0, coachAccToCentre);
                        Log.i("TAG", "======getCoachName2=====" + response4.get(0).getCoachName());


                        adapter4 = new CoachAccToCentreAdapter(PISRegister.this, response4);
                        coaches.setAdapter(adapter4);
*/

                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sportsachive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sachive = sportsachive.getSelectedItem().toString();
                Log.i("TAG", "======sachive=====" + sachive);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

      /*  sportsarea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sarea = sportsachive.getSelectedItem().toString();
                Log.i("TAG", "======sarea=====" + sarea);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/

        caste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                scast = caste.getSelectedItem().toString();
                Log.i("TAG", "======scast=====" + scast);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(v);
            }
        });

    /*    sportscenter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG", "======position=====" + position);
                Log.i("TAG", "======response1=====" + response3.get(position).getTcid());

                try {
                    if (isOnline(getApplicationContext())) {

                        if (response4.size() > 0)
                            response4.clear();
                        if (!String.valueOf(response3.get(position).getTcid()).equalsIgnoreCase("--Select--")) {
                            showloader(true);
                            scentre = response3.get(position).getTcName() + "," + response3.get(position).getLocation();
                            Log.i("TAG", "======scentre=====" + scentre);
                            datamanager.getCoachAccToCentre(PISRegister.this, String.valueOf(response3.get(position).getTcid()));
                        }

                    } else {
                        customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  showloader(true);

                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = df.format(c);
                System.out.println("formattedDate=> " + formattedDate);

                if (validation())
                    if (isOnline(getApplicationContext())) {
                        showloader(true);


                        datamanager.getpisregister(PISRegister.this, "0",
                                "0",
                                sgender,
                                dob.getText().toString(),
                                Aadhaar.getText().toString(),
                                sdiet,
                                fathername.getText().toString(),
                                mothername.getText().toString(),
                                fathers_occupation.getText().toString(),
                                class_pc.getText().toString(),
                                blood_group.getText().toString(),
                                address.getText().toString(),
                                emergency.getText().toString(),
                                "Indian",
                                scast,
                                phone.getText().toString(),
                                email.getText().toString(),
                                city.getText().toString(),
                                selected_state,
                                "India",
                                "Approved",
                                "img12.jpg",
                                formattedDate,
                                sarea,
                                "U14",
                                name.getText().toString(),
                                "AP",
                                username.getText().toString(),
                                passward.getText().toString(),
                                sachive,
                                scoach,
                                sappiled,
                                scentre,
                                scategory);


                    } else {
                        customDoubleOptionAlert(PISRegister.this, getResources().getString(R.string.noNet), "Ok", "Khedo Punjab", R.mipmap.ic_launcher, 1, false, PISRegister.this);
                    }

            }
        });

    }


    public boolean isOnline(Context context) {
        boolean mConnected;
        try {
            Log.e("TAG", "Detect Connection");
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            mConnected = networkInfo != null && networkInfo.isAvailable()
                    && networkInfo.isConnected();

        } catch (Exception e) {

            mConnected = false;
            e.printStackTrace();
        }
        Log.e("TAG", "mConnected = " + mConnected);
        return mConnected;

    }

    public void customDoubleOptionAlert(Context context, String msg, String button1, String title, int icon, final int id,
                                        boolean isCancelable, final BaseFragment.OnDoubleOptionAlertClickListener listener) {

        // show the alert dialog
        DialogSingleAlert alert = new DialogSingleAlert(context,
                (FragmentActivity) context, isCancelable);
        alert.show(msg, button1, title, icon, id, listener);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        /*Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();*/
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dob.setText(new StringBuilder().append(day).append("-")
                .append(month).append("-").append(year));
    }


    public void ResetSpinners() {

        SubCategoryTospoSport subCategoryTospoSport = new SubCategoryTospoSport();
        subCategoryTospoSport.setSportsSubCategoryName("--Select--");
        subCategoryTospoSport.setSportID("--Select--");
        subCategoryTospoSport.setSubCatID("0");
        response2.add(0, subCategoryTospoSport);
        Log.i("TAG", "======getSportsSubCategoryName2=====" + response2.get(0).getSportsSubCategoryName());


        adapter2 = new com.punjab.sports.AdapterClass.SubCategoryTospoSport(this, response2);
        sportssubcategory.setAdapter(adapter2);


        //      Log.i("TAG", "======getTcName=====" + response3.get(0).getTcName());

        CenterAccToSport centerAccToSport = new CenterAccToSport();
        centerAccToSport.setTcName("--Select--");
        centerAccToSport.setTcid("--Select--");
        response3.add(0, centerAccToSport);
        Log.i("TAG", "======getTcName2=====" + response3.get(0).getTcName());

        adapter3 = new CenterAccToSportAdapter(this, response3);
        sportscenter.setAdapter(adapter3);


        // Log.i("TAG", "======getCoachName=====" + response4.get(0).getCoachName());

        CoachAccToCentre coachAccToCentre = new CoachAccToCentre();
        coachAccToCentre.setCoachName("--Select--");
        coachAccToCentre.setCoachID("--Select--");
        response4.add(0, coachAccToCentre);
        Log.i("TAG", "======getCoachName2=====" + response4.get(0).getCoachName());


        adapter4 = new CoachAccToCentreAdapter(this, response4);
        coaches.setAdapter(adapter4);

    }

    @Override
    public void onItemsSelected(List<KeyPairBoolData> items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isSelected()) {
                Log.i("=====ghy======", i + " : " + items.get(i).getName() + " : " + items.get(i).getId());
                sb.append(items.get(i).getId() + ",");

            }
        }


        scategory = sb.toString();
        scategory = scategory.replaceAll(",$", "");
        Log.i("TAG", "======sb=====" + sb.toString());
        Log.i("TAG", "======sappiled=====" + sappiled);
        Log.i("TAG", "======sstate=====" + sstate);

        multiplecenterdata.clear();

        // A text that will display in search hint.
        msportscenter.setSearchHint("--Select--");
        try {
            if (isOnline(getApplicationContext())) {
                showloader(true);
                datamanager.getPISCenterAccToSport(PISRegister.this, sappiled, sstate, scategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}