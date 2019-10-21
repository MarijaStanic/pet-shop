package stanic.marija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stanic.marija.model.SalesUnit;
import stanic.marija.model.User;
import stanic.marija.service.SalesUnitService;

@Controller
public class SalesUnitController {
	
	@Autowired
	SalesUnitService salesUnitService;
	
	@RequestMapping(value = "/sales-unit", method = RequestMethod.GET)
	public ResponseEntity<List<SalesUnit>> getSalesUnits(){
		List<SalesUnit> salesUnits = salesUnitService.getSalesUnits();
		if (salesUnits.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SalesUnit>>(salesUnits, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sales-unit", method = RequestMethod.POST)
    public ResponseEntity<Void> createSalesUnit(@RequestBody SalesUnit salesUnit) {  
		salesUnitService.saveSalesUnit(salesUnit);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/sales-unit{id}", method = RequestMethod.PUT)
    public ResponseEntity<SalesUnit> updateSalesUnit(@PathVariable("id") int id, @RequestBody  SalesUnit salesUnit) {
        SalesUnit updatedSalesUnit = salesUnitService.updateSalesUnit(salesUnit);
        return new ResponseEntity<SalesUnit>(updatedSalesUnit, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/sales-unit{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteSalesUnit(@PathVariable("id") int id) {

        SalesUnit salesUnit = salesUnitService.findById(id);
        if (salesUnit == null) {
            System.out.println("Unable to delete. Sales Unit with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        salesUnitService.deleteSalesUnitById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
