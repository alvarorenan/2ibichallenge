package com.challenge2ibi.alvaro.controller;

import com.challenge2ibi.alvaro.model.country;
import com.challenge2ibi.alvaro.repository.countryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.spi.SelectorProvider;
import java.util.List;

@RestController
@RequestMapping("/country")
public class countryController {


    @Autowired
    private countryRepository countryRepository;

    @GetMapping
    public List<country> list() {
        return countryRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public country get(@PathVariable Long id) {
        return countryRepository.findById(id).get();
        //example of a GET request: http://localhost:8080/country/1
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public country create(@RequestBody final country country) {
        //body example: {"name":"Spain","capital":"Madrid","region":"Europe","subregion":"Southern Europe","area":505992.0}
        return countryRepository.saveAndFlush(country);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        countryRepository.deleteById(id);
    }

    //make a PUT request to update a country
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public country update(@PathVariable Long id, @RequestBody country country) {
        //because this is a PATCH, we only want to update values that are passed in. A PUT would
        //replace all values in the database
        //example: {"name":"Spain","capital":"Madrid","region":"Europe","subregion":"Southwest Europe","area":505992.0}
        //another country:
        country existingCountry = countryRepository.findById(id).get();
        if (country.getName() != null) {
            existingCountry.setName(country.getName());
        }
        if (country.getCapital() != null) {
            existingCountry.setCapital(country.getCapital());
        }
        if (country.getRegion() != null) {
            existingCountry.setRegion(country.getRegion());
        }
        if (country.getSubregion() != null) {
            existingCountry.setSubregion(country.getSubregion());
        }
        if (country.getArea() != 0) {
            existingCountry.setArea(country.getArea());
        }
        return countryRepository.saveAndFlush(existingCountry);
    }

    //order by name, region, subregion, capital, area
    @GetMapping
    @RequestMapping("/order")
    public List<country> order(@RequestParam String order) {
        return switch (order) {
            case "name" -> countryRepository.findAll(Sort.by("name").ascending());
            case "region" -> countryRepository.findAll(Sort.by("region").ascending());
            case "subregion" -> countryRepository.findAll(Sort.by("subregion").ascending());
            case "capital" -> countryRepository.findAll(Sort.by("capital").ascending());
            case "area" -> countryRepository.findAll(Sort.by("area").ascending());
            default -> countryRepository.findAll();
        };
    }

}
