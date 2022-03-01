package hem.vessel.repository;

import hem.vessel.entity.ShippingCompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCompanyDtoRepository extends JpaRepository<ShippingCompanyDto, String> {
}