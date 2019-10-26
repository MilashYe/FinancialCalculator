package kpi.studying.coursework.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import kpi.studying.coursework.entity.CostEntity;
import kpi.studying.coursework.services.CostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/costs")
public class CostsController {

    @Autowired
    private CostsService costsService;

    @PostMapping("/costs/upload")
    public String uploadCost(@RequestBody String json) {
        costsService.saveNewCostFromJson(json);
        return "ok";
    }

    @PostMapping("/cost/removeCost")
    public String removeCost(@RequestAttribute String name) {
        costsService.removeCostByName(name);
        return "ok";
    }

    @GetMapping("/costs")
    public List<CostEntity> getAllCosts() {
        return costsService.findAll();
    }
}
