package pojo.Select_Pharmacy_ByPrescriptionID_Template;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Builder
public class SelectPharmacyByPrescriptionIDRequest {

        private String phone_number;
        private String country_code;
        private String address;
        private String state;
        private String delivery_option;
        private String expected_delivery_date;

        }


