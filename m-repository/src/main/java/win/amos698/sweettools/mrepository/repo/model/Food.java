package win.amos698.sweettools.mrepository.repo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Food extends Base {

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private String foodDesc;

    @Column
    private String foodImg;
}
