package com.blc.eventManagement.controller;

import com.blc.eventManagement.dto.CityDto;
import com.blc.eventManagement.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citys")
public class CityController {

    private CityService cityService;
    public CityController( CityService cityService){
        this.cityService=cityService;
    }

    // create city rest api
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        CityDto cityResponse = cityService.createCity(cityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityResponse);
    }

    @GetMapping()
    public List<CityDto> getAllCitys() {
        return cityService.getAllCitys();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto, @PathVariable(name = "id") long id) {
        CityDto cityResponse = cityService.updateCity(cityDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(cityResponse);

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable(name = "id") Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.status(HttpStatus.OK).body("City deleted successfully");

    }


}