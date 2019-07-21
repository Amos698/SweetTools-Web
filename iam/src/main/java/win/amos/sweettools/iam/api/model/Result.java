package win.amos.sweettools.iam.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    private String token;

    private String code;

    private String msg;

    private T data;

    public static Result getErrorResult(String errorCode, String errorMsg) {
        return new Result<>(null, errorCode, errorMsg, null);
    }
}
