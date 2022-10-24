package Response.Add_Favourite_Pharmacy;

public class Data {
    private String createdDate;
    private String lastModifiedDate;
    private float id;
    private String name;
    private String pharmacyCode;
    private float enrolleeId;


    // Getter Methods

    public String getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPharmacyCode() {
        return pharmacyCode;
    }

    public float getEnrolleeId() {
        return enrolleeId;
    }

    // Setter Methods

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPharmacyCode(String pharmacyCode) {
        this.pharmacyCode = pharmacyCode;
    }

    public void setEnrolleeId(float enrolleeId) {
        this.enrolleeId = enrolleeId;
    }
}
