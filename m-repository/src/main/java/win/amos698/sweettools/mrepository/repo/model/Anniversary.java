package win.amos698.sweettools.mrepository.repo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Anniversary extends Base {

    @Column(nullable = false)
    private String anniversaryName;

    @Column(nullable = false)
    private Date anniversaryDay;

    @Column(nullable = false)
    private String anniversaryDesc;
}
