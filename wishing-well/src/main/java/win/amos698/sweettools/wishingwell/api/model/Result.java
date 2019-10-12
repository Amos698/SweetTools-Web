package win.amos698.sweettools.wishingwell.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    private String code;

    private String msg;

    private T data;
}
