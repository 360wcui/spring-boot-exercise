package com.example.springexplorationsjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnitContractController {

    @Autowired
    private UnitContractService unitContractService;

    @RequestMapping("/topics")
    public List<UnitContractEntity> getAllUnitContracts() {
        List<UnitContractEntity> list = unitContractService.getAllUnitContracts();

        System.out.println(list);
        return list;
    }

//    @RequestMapping("/topics/{id}")
//    public UnitContractEntity getTopic(@PathVariable String id) {
//        return unitContractService.getTopic(id);
//    }

    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void addUnitContract(@RequestBody String unitContractEntity) {
        unitContractService.addUnitContract(null);
    }

//    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
//    public void updateTopic(@RequestBody UnitContractEntity unitContract, @PathVariable String id) {
//        unitContractService.updateTopic(id, unitContract);
//    }
//
//    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
//    public void addTopic(@PathVariable String id) {
//        unitContractService.deleteTopic(id);
//    }

}
