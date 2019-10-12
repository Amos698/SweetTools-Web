package win.amos698.sweettools.wishingwell.repo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class Wish extends Base {

    @Column(nullable = false)
    private String wishName;

    @Column(nullable = false)
    private String wishDesc;

    @Column
    private String wishImg;

    @Column(nullable = false)
    private Integer userId;
}
