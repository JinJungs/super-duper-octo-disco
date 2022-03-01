package hem.vessel.service;

import hem.vessel.entity.ServiceRouteUrlInfoDto;
import hem.vessel.repository.ServiceRouteUrlInfoDtoRepository;
import hem.vessel.repository.ServiceRouteUrlInfoDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRouteUrlInfoService {
    @Autowired
    ServiceRouteUrlInfoDtoRepository repository;

    public List<ServiceRouteUrlInfoDto> findAll() {
        List<ServiceRouteUrlInfoDto> shippingCompanyList = new ArrayList<>();
        repository.findAll().forEach(e -> shippingCompanyList.add(e));
        return shippingCompanyList;
    }

    public Optional<ServiceRouteUrlInfoDto> findById(String companyCode) {
        Optional<ServiceRouteUrlInfoDto> shippingCompanyDto = repository.findById(companyCode);
        return shippingCompanyDto;
    }

    public void deleteById(String companyCode){
        repository.deleteById(companyCode);
    }

    public ServiceRouteUrlInfoDto save(ServiceRouteUrlInfoDto shippingCompanyDto) {
        repository.save(shippingCompanyDto);
        return shippingCompanyDto;
    }

    public void updateById(String companyCode, ServiceRouteUrlInfoDto shippingCompanyDto){
        Optional<ServiceRouteUrlInfoDto> e = repository.findById(companyCode);

        if(e.isPresent()){
            e.get().setCompanyCode(shippingCompanyDto.getCompanyCode());
            e.get().setUrl(shippingCompanyDto.getUrl());
            e.get().setSelector(shippingCompanyDto.getSelector());
            e.get().setMethod(shippingCompanyDto.getMethod());
            e.get().setEtc1(shippingCompanyDto.getEtc1());
            e.get().setEtc2(shippingCompanyDto.getEtc2());
            repository.save(shippingCompanyDto);
        }
    }
}
