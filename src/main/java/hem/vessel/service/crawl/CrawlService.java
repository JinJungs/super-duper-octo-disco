package hem.vessel.service.crawl;

import hem.vessel.dto.VesselCompanyDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlService {

    public List<VesselCompanyDto> test1(){
        List<VesselCompanyDto> vesselCompanyDtoList = new ArrayList<>();

        for(int i=0; i<10; i++){
            VesselCompanyDto vesselCompanyDto = new VesselCompanyDto();
            vesselCompanyDto.setName("선사 " + i);
            vesselCompanyDto.setRoute("경로 "+ i);
            vesselCompanyDtoList.add(vesselCompanyDto);
        }

        return vesselCompanyDtoList;
    }

    public List<VesselCompanyDto> test2(String keyword) throws IOException {
        final String COMPANY_NAME = "PanOcean";
        List<VesselCompanyDto> vesselCompanyDtoList = new ArrayList<>();
        String URL = "https://container.panocean.com/HP3102/hp3102.stx?vessel_name=";

        if(keyword == null) {
            keyword = "POS TOKYO";
        }

        // 크롤링 구현
        // 선박이름을 해당 사이트에서 조회한 결과를 가져옴 (like 로 조회)
        // TODO 정확하게 해당 선박 이름이 필요하다면 로직을 수정할 필요가 있음
        Document doc = Jsoup.connect(URL+keyword).get();
        Elements elem = doc.select("table[id='jqTblShipList']>tbody>tr");

        for(Element e: elem) {
            String vesselName = e.select("td").get(1).text();

            VesselCompanyDto vesselCompanyDto = new VesselCompanyDto();
            vesselCompanyDto.setName(COMPANY_NAME);
            vesselCompanyDto.setVessel(vesselName);
            vesselCompanyDtoList.add(vesselCompanyDto);

        }

        return vesselCompanyDtoList;
    }
}
