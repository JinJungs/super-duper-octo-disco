package hem.vessel.service;

import hem.vessel.entity.ShippingCompanyDto;
import hem.vessel.repository.ShippingCompanyDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingCompanyService {
    @Autowired
    ShippingCompanyDtoRepository repository;

    public List<ShippingCompanyDto> findAll() {
        List<ShippingCompanyDto> shippingCompanyList = new ArrayList<>();
        repository.findAll().forEach(e -> shippingCompanyList.add(e));
        return shippingCompanyList;
    }

    public Optional<ShippingCompanyDto> findById(String companyCode) {
        Optional<ShippingCompanyDto> shippingCompanyDto = repository.findById(companyCode);
        return shippingCompanyDto;
    }

    public void deleteById(String companyCode){
        repository.deleteById(companyCode);
    }

    public ShippingCompanyDto save(ShippingCompanyDto shippingCompanyDto) {
        repository.save(shippingCompanyDto);
        return shippingCompanyDto;
    }

    public void updateById(String companyCode, ShippingCompanyDto shippingCompanyDto){
        Optional<ShippingCompanyDto> e = repository.findById(companyCode);

        if(e.isPresent()){
            e.get().setCompanyCode(shippingCompanyDto.getCompanyCode());
            e.get().setCompanyName(shippingCompanyDto.getCompanyName());
            repository.save(shippingCompanyDto);
        }
    }
}
