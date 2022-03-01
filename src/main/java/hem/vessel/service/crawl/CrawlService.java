package hem.vessel.service.crawl;

import hem.vessel.dto.ResultDto;
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

    public List<ResultDto> test1(){
        List<ResultDto> shippingCompanyDtoList = new ArrayList<>();

        for(int i=0; i<10; i++){
            ResultDto shippingCompanyDto = new ResultDto();
            shippingCompanyDto.setName("선사 " + i);
            shippingCompanyDto.setRoute("경로 "+ i);
            shippingCompanyDtoList.add(shippingCompanyDto);
        }

        return shippingCompanyDtoList;
    }

    public List<ResultDto> test2(String keyword) throws IOException {
        final String COMPANY_NAME = "PanOcean";
        List<ResultDto> shippingCompanyDtoList = new ArrayList<>();
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

            ResultDto shippingCompanyDto = new ResultDto();
            shippingCompanyDto.setName(COMPANY_NAME);
            shippingCompanyDto.setVessel(vesselName);
            shippingCompanyDtoList.add(shippingCompanyDto);

        }

        return shippingCompanyDtoList;
    }
}
