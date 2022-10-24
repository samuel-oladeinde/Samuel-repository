package Response.Add_Favourite_Pharmacy;

public class Add_Favourite_Pharmacy_Response_Pojo {


        private String status;
        private String message;
       private Data DataObject;


        // Getter Methods

        public Data getDataObject() {
            return DataObject;
        }

        public void setDataObject(Data dataObject) {
            DataObject = dataObject;
        }

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






