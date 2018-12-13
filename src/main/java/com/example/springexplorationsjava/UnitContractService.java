package com.example.springexplorationsjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UnitContractService {

    @Autowired
    private UnitContractRepository unitContractRepository;

    @Autowired
    private LineRepository lineRepository;

    // private List<LineEntity> lines = new ArrayList<>();

    private List<UnitContractEntity> unitContractEntities = new ArrayList<>(Arrays.asList(
            new UnitContractEntity("unitId0", "callWord0", "aircraftType0", "standardConventionalLoad0", "USA",
                    "USAF", LocalDate.of(12, 9, 2), LocalDate.of(12, 10, 2),
                     "JBLM", "no restrictions"),
            new UnitContractEntity("unitId1", "callWord1", "aircraftType1", "standardConventionalLoad1", "USA",
                    "USAF", LocalDate.of(12, 10, 9), LocalDate.of(12, 10, 2),
                     "JBLM", "no restrictions")
    )
    );

    private boolean isNative = false;

    public List<UnitContractEntity> getAllUnitContracts() {
        if (isNative)
            return unitContractEntities;
        else {
            List<UnitContractEntity> unitContractEntities = new ArrayList<>();
            unitContractRepository.findAll().forEach(unitContractEntities::add);

            return unitContractEntities;
        }
    }

    //    public UnitContractEntity getTopic(String id) {
//        if (isNative)
//            return unitContractEntities.stream().filter(unitContractEntity -> unitContractEntity.getId().equals(id)).findFirst().get();
//        else
//            return unitContractRepository.findById(id).get();
//    }
//
//    public void addUnitContract(UnitContractEntity unitContractEntity) {
//        if (isNative) {
//            unitContractEntities.add(unitContractEntity);
//        } else {
//            unitContractRepository.save(unitContractEntity);
//        }
//    }
//
//    public void updateTopic(String id, UnitContractEntity unitContract) {
//        if (isNative) {
//            for (int i = 0; i < unitContractEntities.size(); i++) {
//                if (unitContractEntities.get(i).getId().equals(id)) {
//                    System.out.println("gets here");
//                    unitContractEntities.set(i, unitContract);
//                    return;
//                }
//            }
//        } else {
//            unitContractRepository.save(unitContract);
//        }
//    }
//
//    public void deleteTopic(String id) {
//        if (isNative) {
//            unitContractEntities.removeIf(t->t.getId().equals(id));
//        } else {
//            unitContractRepository.deleteById(id);
//        }
//    }

//    @Override
//    public void run(String... arg0) throws Exception {
//        clearData();
//        saveData();
//        showData();
//    }

    public void clearData(){
        unitContractRepository.deleteAll();
        lineRepository.deleteAll();
    }



    /**
     * Save Company objects that include Product list
     */
//    private void saveDataWithApproach1(){
//        Company apple = new Company("Apple");
//        Company samsung = new Company("Samsung");
//
//        Product iphone7 = new Product("Iphone 7", apple);
//        Product iPadPro = new Product("IPadPro", apple);
//
//        Product galaxyJ7 = new Product("GalaxyJ7", samsung);
//        Product galaxyTabA = new Product("GalaxyTabA", samsung);
//
//        apple.setProducts(new HashSet<Product>(){{
//            add(iphone7);
//            add(iPadPro);
//        }});
//
//        samsung.setProducts(new HashSet<Product>(){{
//            add(galaxyJ7);
//            add(galaxyTabA);
//        }});
//
//        // save companies
//        companyRepository.save(apple);
//        companyRepository.save(samsung);
//    }


    /**
     * Save company first (not include product list). Then saving products which had attached a company for each.
     */
    public void addUnitContract(UnitContractEntity unitContractEntity){

        /*
         * Firstly persist companies (not include product list)
         */
        if (unitContractEntity != null) {
            unitContractRepository.save(unitContractEntity);
            unitContractEntity.getLineEntities().forEach(line -> lineRepository.save(line));

        } else {
            UnitContractEntity apple = new UnitContractEntity("unitId0", "callWord0", "aircraftType0", "standardConventionalLoad0", "USA",
                    "USAF", LocalDate.of(12, 9, 2), LocalDate.of(12, 10, 2),
                    "JBLM", "no restrictions");

            UnitContractEntity samsung = new UnitContractEntity("unitId1", "callWord1", "aircraftType1", "standardConventionalLoad1", "USA",
                    "USAF", LocalDate.of(12, 10, 9), LocalDate.of(12, 10, 2),
                    "JBLM", "no restrictions");

            //save companies
            unitContractRepository.save(apple);
            unitContractRepository.save(samsung);

            /*
             * Then store products with had persisted companies.
             */
            LineEntity iphone7 = new LineEntity(LocalTime.of(12, 0), LocalTime.of(13, 0), 0.0, 2, apple);
            LineEntity iPadPro = new LineEntity(LocalTime.of(12, 0), LocalTime.of(13, 0), 0.0, 2, apple);

            LineEntity galaxyJ7 = new LineEntity(LocalTime.of(12, 0), LocalTime.of(13, 0), 0.0, 2, samsung);
            LineEntity galaxyTabA = new LineEntity(LocalTime.of(12, 0), LocalTime.of(13, 0), 0.0, 2, samsung);

            //
            //
            //        // save products
            lineRepository.save(iphone7);
            lineRepository.save(iPadPro);

            lineRepository.save(galaxyJ7);
            lineRepository.save(galaxyTabA);
        }


    }

    private void showData(){
//        // get All data
//        List<UnitContractEntity> companyLst = unitContractRepository.findAll();
//        List<LineEntity> productLst = lineRepository.findAll();

        System.out.println("===================Product List:==================");
        unitContractRepository.findAll().forEach(System.out::println);

        System.out.println("===================Company List:==================");
        lineRepository.findAll().forEach(System.out::println);
    }


}
