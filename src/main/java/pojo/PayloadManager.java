package pojo;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import pojo.Add_Favourite_PharmacyTemplate.AddfavouritepharmacyRequest;
import pojo.Constant.Update_SMS_Template.Update_SMS_Template_Pojo;
import pojo.SMS_Template.sms_Template;
import pojo.Select_Pharmacy_ByPrescriptionID_Template.SelectPharmacyByPrescriptionIDRequest;
import pojo.doctor_signup_form.Signup_doctor_Request;

import java.util.List;

import static utility.Utility.fetchvalue;

public class PayloadManager {

    private static Gson gson = new Gson();

    public static String AuthorizationPayload() {
        return gson.toJson(LoginPojo.builder().login(fetchvalue("Email"))
                .password(fetchvalue("Password")).build());
    }

    public static String Add_SMS_Template_Payload() {
        return gson.toJson(sms_Template.builder().name(new Faker().app().name() + " " + new Faker().name().fullName())
                .content(new Faker().name().fullName()).build());
    }

    public static String Update_SMS_Template_Payload() {
        return gson.toJson(Update_SMS_Template_Pojo.builder().id(5).name(new Faker().app().name())
                .content(new Faker().name().fullName()).build());
    }
    public static String Add_Favourite_Pharmacy_Payload() {
        AddfavouritepharmacyRequest request = AddfavouritepharmacyRequest.builder()
                .name("testdemography")
                .pharmacyCode ("WHP103999")
                .enrolleeId (15)
                .build();
return gson.toJson(request);


    }


        public static String Signup_doctor_Request () {
          Signup_doctor_Request  request = pojo.doctor_signup_form.Signup_doctor_Request.builder().Emails(List.of("soladeinde@reliamcehmo.com")).build();

            return gson.toJson(request);
    }


    public static String SelectPharmacyByPrescriptionIDPayload() {
SelectPharmacyByPrescriptionIDRequest request = SelectPharmacyByPrescriptionIDRequest.builder()
        .phone_number("09152024416")
        .country_code("100001")
        .address("Nigeria")
        .state("Abuja")
        .delivery_option("HOME_DELIVERY")
        .expected_delivery_date("2022-08-24")
                .build();
        return gson.toJson(request);

    }

}



