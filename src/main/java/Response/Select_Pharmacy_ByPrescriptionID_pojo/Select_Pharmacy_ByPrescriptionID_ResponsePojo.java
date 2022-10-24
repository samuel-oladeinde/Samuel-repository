package Response.Select_Pharmacy_ByPrescriptionID_pojo;

public class Select_Pharmacy_ByPrescriptionID_ResponsePojo {

        private String status;
        private String message;
        Data DataObject;

        public Data getDataObject() {
            return DataObject;
        }

        public void setDataObject(Data dataObject) {
            DataObject = dataObject;
        }
// Getter Methods

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public Data getData() {
            return DataObject;
        }

        // Setter Methods

        public void setStatus(String status) {
            this.status = status;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setData(Data dataObject) {
            this.DataObject = dataObject;
        }
    }

