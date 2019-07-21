package win.amos.sweettools.iam.repo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class User extends Base {

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column
    private String intro;

    @Column
    private String avator;

    @Column(nullable = false)
    private Integer tag;

    @Column(nullable = false)
    private Integer used = 1;

}
