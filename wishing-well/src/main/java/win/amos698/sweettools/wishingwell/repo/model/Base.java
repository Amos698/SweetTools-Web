package win.amos698.sweettools.wishingwell.repo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    private Long createTime;

    @LastModifiedDate
    private Long updateTime;

    @Column
    private String remark;

    @Column(nullable = false)
    private Integer used = 1;
}
