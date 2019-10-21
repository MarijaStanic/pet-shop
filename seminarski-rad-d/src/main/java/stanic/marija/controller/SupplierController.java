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

import stanic.marija.model.Supplier;
import stanic.marija.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public ResponseEntity<List<Supplier>> getSalesUnits() {
		List<Supplier> suppliers = supplierService.getSuppliers();
		if (suppliers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
	}

	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public ResponseEntity<Void> createSalesUnit(@RequestBody Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/supplier{id}", method = RequestMethod.PUT)
	public ResponseEntity<Supplier> updateSalesUnit(@PathVariable("id") int id, @RequestBody Supplier supplier) {
		Supplier updatedSupplier = supplierService.updateSupplier(supplier);
		return new ResponseEntity<Supplier>(updatedSupplier, HttpStatus.OK);
	}

	@RequestMapping(value = "/supplier{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Supplier> deleteSalesUnit(@PathVariable("id") int id) {
		supplierService.deleteSupplierById(id);
		return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);
	}
}
