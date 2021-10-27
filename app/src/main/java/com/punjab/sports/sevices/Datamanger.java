package com.punjab.sports.sevices;

import android.util.Log;


import com.punjab.sports.ModelClasses.CenterAccToSport;
import com.punjab.sports.ModelClasses.CoachAccToCentre;
import com.punjab.sports.ModelClasses.SportsAppliedFor;
import com.punjab.sports.ModelClasses.SportsDistrict;
import com.punjab.sports.ModelClasses.SubCategoryTospoSport;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Datamanger {


    String TAG = "Datamanger";
    private GetData mService;
    private GetData mService2;


    public Datamanger() {
        mService = ApiUtils.createService(GetData.class);
        mService2 = ApiUtils2.createService(GetData.class);
    }


    /*-------------------GET ALL EVENTS---------------------------*/

    public interface getregister {
        void onSucess(registeration response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getregister(final getregister callback,
                            String PlayerID,
                            String UserID,
                            String Gender,
                            String DOB,
                            String AadhaarNo,
                            String Diet,
                            String FatherName,
                            String MotherName,
                            String FatherOccupation,
                            String Class,
                            String BloodGroup,
                            String Address,
                            String GuardianContact,
                            String Nationality,
                            String Caste,
                            String Phone,
                            String Email,
                            String City,
                            String State,
                            String Country,
                            String Status,
                            String ProfileImage,
                            String DOR,
                            String SportArea,
                            String AgeGroup,
                            String Name,
                            String UserType,
                            String UserName,
                            String Password,
                            String Beginner,
                            String CoachID,
                            String SportsAppliedFor,String Scenter,String ssubcat
    ) {

        mService = ApiUtils.createService(GetData.class);

        mService.getregister(SportsAppliedFor,Scenter,ssubcat, UserID,
                Gender,
                DOB,
                AadhaarNo,
                Diet,
                FatherName,
                MotherName,
                FatherOccupation,
                Class,
                BloodGroup,
                Address,
                GuardianContact,
                Nationality,
                Caste,
                Phone,
                Email,
                City,
                State,
                Country,
                Status,
                ProfileImage,
                DOR,
                SportArea,
                AgeGroup,
                Name,
                UserType,
                UserName,
                Password,
                PlayerID,
                CoachID,
                Beginner

        ).enqueue(new Callback<registeration>() {
            @Override
            public void onResponse(Call<registeration> call, Response<registeration> response) {

                try {

                    Log.i(TAG, "======message=====" + response.isSuccessful());
                    if (response.isSuccessful()) {


                        Log.i(TAG, "======MMindis=====" + response.body().getMessage());

                        //  List<homedata> dataArrayList = response.body();
                        if (response.body().getStatus().equalsIgnoreCase("success")){
                            callback.onSucess(response.body());
                        } else{
                           callback.onFailure(response.body().getMessage());

                        }



                    } else {
                        Log.i(TAG, "======message===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======message===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<registeration> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }

    /*-------------------SportsAppliedFor---------------------------*/
    public interface getSportsAppliedFormanager {
        void onSucess(List<SportsAppliedFor> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getSportsAppliedFor(final getSportsAppliedFormanager callback) {

        mService = ApiUtils.createService(GetData.class);

        mService.getSportsAppliedFor().enqueue(new Callback<List<SportsAppliedFor>>() {
            @Override
            public void onResponse(Call<List<SportsAppliedFor>> call, Response<List<SportsAppliedFor>> response) {

                try {

                    Log.i(TAG, "======SportsAppliedFor=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.onSucess(response.body());

                    } else {
                        Log.i(TAG, "======SportsAppliedFor===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SportsAppliedFor===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SportsAppliedFor>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------CenterAccToSport---------------------------*/
    public interface getCenterAccToSportmanager {
        void CenterAcc(List<CenterAccToSport> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getCenterAccToSport(final getCenterAccToSportmanager callback, String SportId, String districtID, String subCatID) {

        mService = ApiUtils.createService(GetData.class);

        mService.getCenterAccToSport(SportId,districtID,subCatID).enqueue(new Callback<List<CenterAccToSport>>() {
            @Override
            public void onResponse(Call<List<CenterAccToSport>> call, Response<List<CenterAccToSport>> response) {

                try {

                    Log.i(TAG, "======CenterAccToSport=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.CenterAcc(response.body());

                    } else {
                        Log.i(TAG, "======CenterAccToSport===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======CenterAccToSport===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<CenterAccToSport>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------CoachAccToCentre---------------------------*/
    public interface getCoachAccToCentremanager {
        void CoachAcc(List<CoachAccToCentre> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getCoachAccToCentre(final getCoachAccToCentremanager callback, String CenterId,String SportId,String subCatID,String DistrictId) {

        mService = ApiUtils.createService(GetData.class);

        mService.getCoachAccToCentre(CenterId,SportId,subCatID,DistrictId).enqueue(new Callback<List<CoachAccToCentre>>() {
            @Override
            public void onResponse(Call<List<CoachAccToCentre>> call, Response<List<CoachAccToCentre>> response) {

                try {

                    Log.i(TAG, "======CoachAccToCentre=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.CoachAcc(response.body());

                    } else {
                        Log.i(TAG, "======CoachAccToCentre===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======CoachAccToCentre===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<CoachAccToCentre>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------SportsAppliedFor---------------------------*/
    public interface getSubCategoryTospoSportmanager {
        void SubCategoryTos(List<SubCategoryTospoSport> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getSubCategoryTospoSport(final getSubCategoryTospoSportmanager callback, String SportId) {

        mService = ApiUtils.createService(GetData.class);

        mService.getSubCategoryTospoSport(SportId).enqueue(new Callback<List<SubCategoryTospoSport>>() {
            @Override
            public void onResponse(Call<List<SubCategoryTospoSport>> call, Response<List<SubCategoryTospoSport>> response) {

                try {

                    Log.i(TAG, "======SubCategoryTospoSport=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.SubCategoryTos(response.body());

                    } else {
                        Log.i(TAG, "======SubCategoryTospoSport===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SubCategoryTospoSport===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SubCategoryTospoSport>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }

 /*-------------------SportsDistrict---------------------------*/
    public interface getSportsDistrictmanager {
        void SubDist(List<SportsDistrict> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getSportsDistrict(final getSportsDistrictmanager callback) {

        mService = ApiUtils.createService(GetData.class);

        mService.getSportsDistrict().enqueue(new Callback<List<SportsDistrict>>() {
            @Override
            public void onResponse(Call<List<SportsDistrict>> call, Response<List<SportsDistrict>> response) {

                try {

                    Log.i(TAG, "======SportsDistrict=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.SubDist(response.body());

                    } else {
                        Log.i(TAG, "======SportsDistrict===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SportsDistrict===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SportsDistrict>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }
//////////////////////////////////////////////////PIS////////////////////////////////////////////////////////////////////////////////



    /*-------------------GET ALL EVENTS---------------------------*/

    public interface getpisregister {
        void onSucess(registeration response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getpisregister(final getpisregister callback,
                            String PlayerID,
                            String UserID,
                            String Gender,
                            String DOB,
                            String AadhaarNo,
                            String Diet,
                            String FatherName,
                            String MotherName,
                            String FatherOccupation,
                            String Class,
                            String BloodGroup,
                            String Address,
                            String GuardianContact,
                            String Nationality,
                            String Caste,
                            String Phone,
                            String Email,
                            String City,
                            String State,
                            String Country,
                            String Status,
                            String ProfileImage,
                            String DOR,
                            String SportArea,
                            String AgeGroup,
                            String Name,
                            String UserType,
                            String UserName,
                            String Password,
                            String Beginner,
                            String CoachID,
                            String SportsAppliedFor,String Scenter,String ssubcat
    ) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getregister(SportsAppliedFor,Scenter,ssubcat, UserID,
                Gender,
                DOB,
                AadhaarNo,
                Diet,
                FatherName,
                MotherName,
                FatherOccupation,
                Class,
                BloodGroup,
                Address,
                GuardianContact,
                Nationality,
                Caste,
                Phone,
                Email,
                City,
                State,
                Country,
                Status,
                ProfileImage,
                DOR,
                SportArea,
                AgeGroup,
                Name,
                UserType,
                UserName,
                Password,
                PlayerID,
                CoachID,
                Beginner

        ).enqueue(new Callback<registeration>() {
            @Override
            public void onResponse(Call<registeration> call, Response<registeration> response) {

                try {

                    Log.i(TAG, "======message=====" + response.isSuccessful());
                    if (response.isSuccessful()) {


                        Log.i(TAG, "======MMindis=====" + response.body().getMessage());

                        //  List<homedata> dataArrayList = response.body();
                        if (response.body().getStatus().equalsIgnoreCase("success")){
                            callback.onSucess(response.body());
                        } else{
                            callback.onFailure(response.body().getMessage());

                        }



                    } else {
                        Log.i(TAG, "======message===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======message===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<registeration> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }
    /*-------------------PISportsAppliedFor---------------------------*/
    public interface getPISportsAppliedFormanager {
        void onSucess(List<SportsAppliedFor> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getPISportsAppliedFor(final getPISportsAppliedFormanager callback) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getSportsAppliedFor().enqueue(new Callback<List<SportsAppliedFor>>() {
            @Override
            public void onResponse(Call<List<SportsAppliedFor>> call, Response<List<SportsAppliedFor>> response) {

                try {

                    Log.i(TAG, "======SportsAppliedFor=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.onSucess(response.body());

                    } else {
                        Log.i(TAG, "======SportsAppliedFor===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SportsAppliedFor===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SportsAppliedFor>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------PISCenterAccToSport---------------------------*/
    public interface getPISCenterAccToSportmanager {
        void CenterAcc(List<CenterAccToSport> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getPISCenterAccToSport(final getPISCenterAccToSportmanager callback, String SportId, String districtID, String subCatID) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getCenterAccToSport(SportId,districtID,subCatID).enqueue(new Callback<List<CenterAccToSport>>() {
            @Override
            public void onResponse(Call<List<CenterAccToSport>> call, Response<List<CenterAccToSport>> response) {

                try {

                    Log.i(TAG, "======CenterAccToSport=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.CenterAcc(response.body());

                    } else {
                        Log.i(TAG, "======CenterAccToSport===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======CenterAccToSport===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<CenterAccToSport>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------CoachAccToCentre---------------------------*/
    public interface getPISCoachAccToCentremanager {
        void CoachAcc(List<CoachAccToCentre> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getPISCoachAccToCentre(final getPISCoachAccToCentremanager callback, String CenterId,String SportId,String subCatID,String DistrictId) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getCoachAccToCentre(CenterId,SportId,subCatID,DistrictId).enqueue(new Callback<List<CoachAccToCentre>>() {
            @Override
            public void onResponse(Call<List<CoachAccToCentre>> call, Response<List<CoachAccToCentre>> response) {

                try {

                    Log.i(TAG, "======CoachAccToCentre=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.CoachAcc(response.body());

                    } else {
                        Log.i(TAG, "======CoachAccToCentre===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======CoachAccToCentre===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<CoachAccToCentre>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }


    /*-------------------SportsAppliedFor---------------------------*/
    public interface getPISubCategoryTospoSportmanager {
        void SubCategoryTos(List<SubCategoryTospoSport> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getPISubCategoryTospoSport(final getPISubCategoryTospoSportmanager callback, String SportId) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getSubCategoryTospoSport(SportId).enqueue(new Callback<List<SubCategoryTospoSport>>() {
            @Override
            public void onResponse(Call<List<SubCategoryTospoSport>> call, Response<List<SubCategoryTospoSport>> response) {

                try {

                    Log.i(TAG, "======SubCategoryTospoSport=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.SubCategoryTos(response.body());

                    } else {
                        Log.i(TAG, "======SubCategoryTospoSport===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SubCategoryTospoSport===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SubCategoryTospoSport>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }

    /*-------------------PISportsDistrict---------------------------*/
    public interface getPISportsDistrictmanager {
        void SubDist(List<SportsDistrict> response);

        void onFailure(String message);

        void noCase(String message);
    }


    public void getPISportsDistrict(final getPISportsDistrictmanager callback) {

        mService2 = ApiUtils2.createService(GetData.class);

        mService2.getSportsDistrict().enqueue(new Callback<List<SportsDistrict>>() {
            @Override
            public void onResponse(Call<List<SportsDistrict>> call, Response<List<SportsDistrict>> response) {

                try {

                    Log.i(TAG, "======SportsDistrict=====" + response.isSuccessful());
                    if (response.isSuccessful()) {
                        //  List<homedata> dataArrayList = response.body();
                        callback.SubDist(response.body());

                    } else {
                        Log.i(TAG, "======SportsDistrict===2==" + response.message());

                        callback.onFailure(response.message());
                    }

                } catch (Exception e) {
                    Log.i(TAG, "======SportsDistrict===3==" + response.message());
                    e.printStackTrace();
                    callback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<List<SportsDistrict>> call, Throwable t) {
                Log.i(TAG, "======onFailure=====" + t.getMessage());
                callback.noCase(t.getMessage());
            }

        });

    }

}