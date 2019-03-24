package win.amos698.sweettools.mrepository.repo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Lover extends Base {

    @Column(nullable = false)
    private Long bid;

    @Column(nullable = false)
    private Long gid;
}
