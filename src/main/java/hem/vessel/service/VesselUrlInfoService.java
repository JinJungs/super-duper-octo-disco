package hem.vessel.service;

import hem.vessel.entity.VesselUrlInfoDto;
import hem.vessel.repository.VesselUrlInfoDtoRepository;
import hem.vessel.repository.VesselUrlInfoDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VesselUrlInfoService {
    @Autowired
    VesselUrlInfoDtoRepository repository;

    public List<VesselUrlInfoDto> findAll() {
        List<VesselUrlInfoDto> shippingCompanyList = new ArrayList<>();
        repository.findAll().forEach(e -> shippingCompanyList.add(e));
        return shippingCompanyList;
    }

    public Optional<VesselUrlInfoDto> findById(String companyCode) {
        Optional<VesselUrlInfoDto> shippingCompanyDto = repository.findById(companyCode);
        return shippingCompanyDto;
    }

    public void deleteById(String companyCode){
        repository.deleteById(companyCode);
    }

    public VesselUrlInfoDto save(VesselUrlInfoDto shippingCompanyDto) {
        repository.save(shippingCompanyDto);
        return shippingCompanyDto;
    }

    public void updateById(String companyCode, VesselUrlInfoDto shippingCompanyDto){
        Optional<VesselUrlInfoDto> e = repository.findById(companyCode);

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
