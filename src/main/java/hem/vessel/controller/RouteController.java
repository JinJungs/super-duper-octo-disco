package hem.vessel.controller;

import hem.vessel.cnst.VsUrlCnst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {

    @GetMapping(value = VsUrlCnst.TO_ROUTE)
    public ModelAndView toVessel(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("route");

        return modelAndView;
    }
}
