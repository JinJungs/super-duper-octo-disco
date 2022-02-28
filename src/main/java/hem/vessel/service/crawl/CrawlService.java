package hem.vessel.service.crawl;

import hem.vessel.dto.VesselCompanyDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlService {

    public List<VesselCompanyDto> test1(){
        List<VesselCompanyDto> shipCompanyList = new ArrayList<>();

        for(int i=0; i<10; i++){
            VesselCompanyDto vesselCompanyDto = new VesselCompanyDto();
            vesselCompanyDto.setName("선사 " + i);
            vesselCompanyDto.setRoute("경로 "+ i);
            shipCompanyList.add(vesselCompanyDto);
        }

        return shipCompanyList;
    }
}
