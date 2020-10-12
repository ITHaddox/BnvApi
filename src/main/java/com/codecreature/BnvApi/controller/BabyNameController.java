package com.codecreature.BnvApi.controller;

import com.codecreature.BnvApi.models.BabyName;
import com.codecreature.BnvApi.models.Message;
import com.codecreature.BnvApi.repository.BabyNameJpaRepository;
import com.codecreature.BnvApi.repository.UserJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({"/baby"})
public class BabyNameController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    private List<BabyName> babyNames = createList();

//    private List<BabyName> babyNames = getBabyNameList(username);

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    BabyNameJpaRepository babyNameJpaRepository;

    @CrossOrigin
    @GetMapping({"/greeting"})
    public Message welcomePage() {
        Message msg = new Message("Welcome!");
        return msg;
    }

    @GetMapping("/users/{username}/names")
    public List<BabyName> getAllNames(@PathVariable String username){
        return babyNameJpaRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/names/{id}")
    public BabyName getBabyName(@PathVariable String username, @PathVariable long id){
        return babyNameJpaRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/names/{id}")
    public ResponseEntity<Void> deleteBabyName(
            @PathVariable String username, @PathVariable long id){

        babyNameJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/names/{id}")
    public ResponseEntity<BabyName> updateBabyName(
            @PathVariable String username,
            @PathVariable long id, @RequestBody BabyName babyName){

        BabyName updatedBabyName = babyNameJpaRepository.save(babyName);

        return new ResponseEntity<BabyName>(babyName, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/names")
    public ResponseEntity<Void> createBabyName(
            @PathVariable String username, @RequestBody BabyName babyName){

        babyName.setUsername(username);
        BabyName createdBabyName = babyNameJpaRepository.save(babyName);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdBabyName.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


//    @PostMapping("/add/{username}/name")
//    public BabyName create(@PathVariable String username,
//                           @RequestBody String name
//                          ) {
//        logger.debug("crete new baby name reached");
//        BabyName babyName = new BabyName(username, name);
//        babyNameJpaRepository.update(babyName);
//        return babyName;
//    }



//    @GetMapping(produces = "application/json")
//    public List<BabyName> firstPage(){
//        return babyNames;
//    }

//    @DeleteMapping(path = {"/{id"})
//    public BabyName delete(@PathVariable("id") int id) {
//        BabyName deletedBabyName = null;
//        for (BabyName bn : babyNames) {
//            if (bn.getId().equals(id)) {
//                babyNames.remove(bn);
//                deletedBabyName = bn;
//                break;
//            }
//        }
//        return null;
//    }



//    private static List<BabyName> getBabyNameList(String username){
//        List<BabyName> tempBabyNames = new ArrayList<>();
//        tempBabyNames = babyNameJpaRepository.findAllNamesByUser(username);
//    }

//    private static List<BabyName> createList() {
//        List<BabyName> tempEmployees = new ArrayList<>();
//        BabyName emp1 = new BabyName();
//        emp1.setName("Harper");
//        emp1.setUsername("tyler");
//        emp1.setGirl(true);
//
//        BabyName emp2 = new BabyName();
//        emp2.setName("BillyBob");
//        emp2.setUsername("tyler");
//        emp2.setGirl(false);
//
//        BabyName emp3 = new BabyName();
//        emp3.setName("Fredrick");
//        emp3.setUsername("tyler");
//        emp3.setGirl(false);
//
//        BabyName emp4 = new BabyName();
//        emp4.setName("Shanaynay");
//        emp4.setUsername("tyler");
//        emp4.setGirl(true);
//
//        BabyName emp5 = new BabyName();
//        emp5.setName("Peter");
//        emp5.setUsername("kendra");
//        emp5.setGirl(false);
//
//        tempEmployees.add(emp1);
//        tempEmployees.add(emp2);
//        tempEmployees.add(emp3);
//        tempEmployees.add(emp4);
//        tempEmployees.add(emp5);
//        return tempEmployees;
//    }

}
