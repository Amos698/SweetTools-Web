package win.amos698.sweettools.mrepository.repo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Wish extends Base {

    @Column(nullable = false)
    private String giftName;

    @Column
    private String giftImg;

    @Column(nullable = false)
    private String giftDesc;

}
