package win.amos698.sweettools.wishingwell.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import win.amos698.sweettools.wishingwell.repo.model.Lover;

public interface LoverRepo extends JpaRepository<Lover, Long> {

    @Query(value = "SELECT * FROM lover WHERE bid=:uid AND used=1", nativeQuery = true)
    Lover getLover(@Param("uid") long uid);

    @Modifying
    @Query(value = "UPDATE WISH SET used=0 WHERE bid=:uid AND used=1", nativeQuery = true)
    int deleteWish(@Param("uid") long uid);
}
