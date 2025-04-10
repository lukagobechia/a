package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.projections.StaffInfo;
import ge.ibsu.demo.entities.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository()
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("select new ge.ibsu.demo.dto.projections.StaffInfo(c.first_name, c.last_name, c.address.address, c.address.postal_code) " +
            "from Staff c " +
            "where concat(c.first_name, ' ', c.last_name) like :searchValue")
    Page<StaffInfo> searchStaff(@Param("searchValue") String searchValue, Pageable pageable);

}
