package win.amos698.sweettools.wishingwell.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import win.amos698.sweettools.wishingwell.repo.model.Wish;

public interface WishRepo extends JpaRepository<Wish, Long> {

    @Query(value = "SELECT * FROM (SELECT * FROM wish WHERE user_id=:userId) as n ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Wish pickOne(@Param("userId") long userId);

    @Modifying
    @Query(value = "UPDATE WISH SET used=0 WHERE id=:wishId", nativeQuery = true)
    void deleteWish(@Param("wishId") long wishId);
}
