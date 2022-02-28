package hem.vessel.controller;

import hem.vessel.cnst.VsUrlCnst;
import hem.vessel.service.crawl.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    CrawlService crawlService;

    @GetMapping(value = VsUrlCnst.TO_HOME)
    public ModelAndView toHome(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");

        return modelAndView;
    }

}
