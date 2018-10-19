package model;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginMessage implements Parcelable {

    /**
     * message : 请求成功
     * data : {"username":"管理员","sessionId":"E86296FCF51CAC83F44B1579BEAE67AC"}
     * code : 200
     */

    private String message;
    private DataBean data;
    private String code;

    protected LoginMessage(Parcel in) {
        message = in.readString();
        code = in.readString();
    }

    public static final Creator<LoginMessage> CREATOR = new Creator<LoginMessage>() {
        @Override
        public LoginMessage createFromParcel(Parcel in) {
            return new LoginMessage(in);
        }

        @Override
        public LoginMessage[] newArray(int size) {
            return new LoginMessage[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeString(code);
    }

    public static class DataBean implements Parcelable{
        /**
         * username : 管理员
         * sessionId : E86296FCF51CAC83F44B1579BEAE67AC
         */

        private String username;
        private String sessionId;

        protected DataBean(Parcel in) {
            username = in.readString();
            sessionId = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(username);
            parcel.writeString(sessionId);
        }
    }
}
