package Response.Select_Pharmacy_ByPrescriptionID_pojo;

public class Data {
    private String address;
    private String state;
    private String phone_number;
    private String country_code;
    private String delivery_option;
    private String pharmacy_id = null;
    private String pharmacy_name = null;
    private String pharmacy_code = null;
    private String expected_delivery_date;


    // Getter Methods

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getDelivery_option() {
        return delivery_option;
    }

    public String getPharmacy_id() {
        return pharmacy_id;
    }

    public String getPharmacy_name() {
        return pharmacy_name;
    }

    public String getPharmacy_code() {
        return pharmacy_code;
    }

    public String getExpected_delivery_date() {
        return expected_delivery_date;
    }

    // Setter Methods

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setDelivery_option(String delivery_option) {
        this.delivery_option = delivery_option;
    }

    public void setPharmacy_id(String pharmacy_id) {
        this.pharmacy_id = pharmacy_id;
    }

    public void setPharmacy_name(String pharmacy_name) {
        this.pharmacy_name = pharmacy_name;
    }

    public void setPharmacy_code(String pharmacy_code) {
        this.pharmacy_code = pharmacy_code;
    }

    public void setExpected_delivery_date(String expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }
}
