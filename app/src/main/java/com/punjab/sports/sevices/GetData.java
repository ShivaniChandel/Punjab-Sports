package com.punjab.sports.sevices;


import com.punjab.sports.ModelClasses.CenterAccToSport;
import com.punjab.sports.ModelClasses.CoachAccToCentre;
import com.punjab.sports.ModelClasses.SportsAppliedFor;
import com.punjab.sports.ModelClasses.SportsDistrict;
import com.punjab.sports.ModelClasses.SubCategoryTospoSport;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetData {


    /*--------REGISTRATION---------*/

    @POST("Registration")
    @FormUrlEncoded
    Call<registeration> getregister(@Field("SportsAppliedFor.SportID") String SportID,
                                    @Field("SportCenterID") String SportCenterID,
                                    @Field("SportSubCategory") String SportSubCategory,
                                    @Field("UserID") String UserID,
                                    @Field("Gender") String Gender,
                                    @Field("DOB") String DOB,
                                    @Field("AadhaarNo") String AadhaarNo,
                                    @Field("Diet") String Diet,
                                    @Field("FatherName") String FatherName,
                                    @Field("MotherName") String MotherName,
                                    @Field("FatherOccupation") String FatherOccupation,
                                    @Field("Class") String Class,
                                    @Field("BloodGroup") String BloodGroup,
                                    @Field("Address") String Address,
                                    @Field("GuardianContact") String GuardianContact,
                                    @Field("Nationality") String Nationality,
                                    @Field("Caste") String Caste,
                                    @Field("Phone") String Phone,
                                    @Field("Email") String Email,
                                    @Field("City") String City,
                                    @Field("State") String State,
                                    @Field("Country") String Country,
                                    @Field("Status") String Status,
                                    @Field("ProfileImage") String ProfileImage,
                                    @Field("DOR") String DOR,
                                    @Field("SportArea") String SportArea,
                                    @Field("AgeGroup") String AgeGroup,
                                    @Field("Name") String Name,
                                    @Field("UserType") String UserType,
                                    @Field("UsersMaster.UserName") String UserName,
                                    @Field("UsersMaster.Password") String Password,
                                    @Field("PlayerID") String PlayerID,
                                    @Field("CoachesAssigned.CoachID") String CoachID,
                                    @Field("SportsAchievements") String Beginner

    );

    /*--------SportsAppliedFor---------*/

    @GET("SportsAppliedFor")
    Call<List<SportsAppliedFor>> getSportsAppliedFor();


    /*--------CenterAccToSport---------*/

    @GET("CenterAccToSport")
    Call<List<CenterAccToSport>> getCenterAccToSport(@Query("SportId") String SportId,@Query("districtID") String districtID,@Query("SportsSubCategory") String subCatID);


    /*--------SubCategoryTospoSport---------*/

    @GET("SubCategoryTospoSport")
    Call<List<SubCategoryTospoSport>> getSubCategoryTospoSport(@Query("SportId") String SportId);

    /*--------CoachAccToCentre---------*/

    @GET("CoachAccToCentre")
    Call<List<CoachAccToCentre>> getCoachAccToCentre(@Query("CenterId") String CenterId,@Query("Sportid") String Sportid,@Query("SportsSubCategory") String SportsSubCategory);


    /*--------SportsDistrict---------*/

    @GET("SportsDistrict")
    Call<List<SportsDistrict>> getSportsDistrict();


}
