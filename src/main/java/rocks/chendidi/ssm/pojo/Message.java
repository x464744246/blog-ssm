package rocks.chendidi.ssm.pojo;

/**
 * Created by lenov0 on 2016/7/13.
 */
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhangjk on 2016/1/15.
 */
public class Message implements Serializable {
    private Status status;
    private String statusMsg = "";
    private ArrayList<Integer> errorKys;
    private String error = "";

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public ArrayList<Integer> getErrorKys() {
        return errorKys;
    }

    public void setErrorKys(ArrayList<Integer> errorKys) {
        this.errorKys = errorKys;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
