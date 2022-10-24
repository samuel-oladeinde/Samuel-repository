package pojo.Constant;

import Base.TestBase;

public class Constant extends TestBase {

    public static String add_sms_template_EndPoint = "/basic-templates";
    public static String Update_sms_template_EndPoint = "/basic-templates";
    public static String Get_All_sms_template_EndPoint = "/basic-templates";
    public static String Get_sms_template_ID_EndPoint = "/basic-templates/6";
    public static String Get_sms_template_Invalid_ID_EndPoint = "/basic-templates/600";
    public static String Send_SMS_Template_EndPoint = "/notifications";
    public static String Delete_SMS_Template_EndPoint = "/basic-templates/";
    public static String Get_All_Doctor_Endpoint = "/tele-medicine-doctor-service/api/doctors";
    public static String Get_All_Consultation_Endpoint = "/tele-medicine-service/api/consultations";
    public static String Get_All_Enrollee_Favourite_Pharmacy_Endpoint = "/tele-medicine-service/api/enrollees-favorite-pharmacy";
    public static String Add_favourite_Pharmacy_Endpoint ="/tele-medicine-service/api/enrollees-favorite-pharmacy";
    public static String View_All_Doctors_Endpoint ="/tele-medicine-doctor-service/api/doctors/admin/get-all-doctors";
    public static String View_Doctor_Transaction_History_Endpoint ="/tele-medicine-doctor-service/api/consultations/wallet";
    public static String Get_Doctor_ByID_Endpoint ="/tele-medicine-doctor-service/api/doctors/admin/get-doctor";
    public static String Get_All_Banks_Endpoint ="/tele-medicine-doctor-service/api/banks";
    public static String Get_Doctor_Bank_Using_PersonReference_Endpoint ="/tele-medicine-doctor-service/api/doctors/person-ref";
    public static String Fund_Doctor_Wallet_Endpoint ="/tele-medicine-doctor-service/api/doctors";
    public static String Select_Pharmacy_ByPrescriptionID_Endpoint ="/tele-medicine-service/api/prescriptions/118/book-pharmacy";
    public static String Delete_Favourite_Pharmacy_Endpoint ="/tele-medicine-service/api/enrollees-favorite-pharmacy/16";
    public static String View_Enrollee_Consultation_History_ByConsultationID_Endpoint ="/tele-medicine-service/api/consultations";

    public static String View_All_Nps_Questions_Endpoint ="/tele-medicine-service/api/nps-question-banks";
    public static String View_Enrollee_Consultation_History_ByEnrolleeID_Endpoint ="/tele-medicine-service/api/consultations/history";

    public static String Approve_Dispute_Endpoint ="/tele-medicine-service/api/consultations";
    public static String Decline_Dispute_Endpoint ="/tele-medicine-service/api/consultations";
    public static String Enrollee_Accepts_ToCloseConsultation_Endpoint ="/tele-medicine-service/api/consultations";
    public static String Doctor_Signup_Endpoint ="/tele-medicine-doctor-service/api/mail/sign-up-link";
}


