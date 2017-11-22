package ljx.ashin.system.exception;

/**
 * 定义的错误信息
 * Created by Ashin Liang on 2017/10/23.
 */
public enum  InfError {
    VERIFICODENOTMATCH("019999", "验证码错误或有效期已过"),

    FiledInvalid("019998", "字段验证无效"),

    INVALIDA_SIGN("010054", "无效签名"),

    NO_SIGN("010016", "摘要字段不能为空"),
    CALL_CORE_CONNECT_FAIL("011009", "调用接口服务未连接"),

    respSuccess("000000", "成功");

    InfError(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    String code, reason;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
