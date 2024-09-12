package com.floor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.entity.Floor;
import com.floor.service.FloorServ;

@RestController
@RequestMapping("/floor")
public class FloorController {

    @Autowired
private FloorServ floorServ;

    @PostMapping
    public ResponseEntity<Floor> saveFloor(@RequestBody Floor floor){


        Floor floors = this.floorServ.createFloor(floor);

        return ResponseEntity.status(HttpStatus.CREATED).body(floors);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Void> delFloor(@PathVariable("id") int id){

        this.floorServ.DelFloor(id);

        return ResponseEntity.noContent().build();
    }

}
