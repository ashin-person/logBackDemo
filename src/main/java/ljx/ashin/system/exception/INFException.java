package ljx.ashin.system.exception;

/**
 * Created by Ashin Liang on 2017/10/23.
 */
public class INFException extends Exception {
    private static final long serialVersionUID = 1L;

    private String errCode = "";

    private String errReason = "";

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrReason(String errReason) {
        this.errReason = errReason;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrReason() {
        return errReason;
    }

    public INFException(String errCode, String errReason) {
        super("[" + errCode + "]" + errReason);
        this.errCode = errCode;
        this.errReason =errReason;
    }

    public INFException(String msg) {
        super(msg);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {


    }
}
