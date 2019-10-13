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
public class Lover extends Base {

    @Column(nullable = false)
    private long bid;

    @Column(nullable = false)
    private long gid;

    public Lover(long bid, long gid) {
        this.bid = bid;
        this.gid = gid;
    }

}
