package win.amos698.sweettools.mrepository.repo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Lover extends Base {

    @Column(nullable = false)
    private Long bid;

    @Column(nullable = false)
    private Long gid;
}
