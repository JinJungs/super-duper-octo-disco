package hem.vessel.repository;

import hem.vessel.entity.VesselUrlInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VesselUrlInfoDtoRepository extends JpaRepository<VesselUrlInfoDto, String> {
}