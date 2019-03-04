package lt.bit.spring.controllers;

import lt.bit.spring.dao.AddressDAO;
import lt.bit.spring.dao.PersonDAO;
import lt.bit.spring.db.Address;
import lt.bit.spring.db.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/address/")
public class AddressController {

    @Autowired
    AddressDAO addressDAO;

    @Autowired
    PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(
            // Required to show addresses for specific person
            @RequestParam(name = "personId", required = false) String personId
    ) {
        Person person = null;
        try {
            person = personDAO.getOne(new Integer(personId));
        } catch (Exception ex) {
            // personId was not provided - should be reported as error
            // personId could not be parsed and converted to number - should be reported as error
        }
        if (person == null) {
            // personId was not provided - should be reported as error earlier
            // personId could not be parsed and converted to number - should be reported as error earlier
            // personId was ok but there is no record with specified id - should be reported as error
            // In this simple example: for all error cases redirect to person list view
            return new ModelAndView("redirect:../");
        }
        ModelAndView mv = new ModelAndView("addressList");
        mv.addObject("person", person);
        mv.addObject("addressList", person.getAddressList());
        return mv;
    }

    @RequestMapping(path = "edit", method = RequestMethod.GET)
    public ModelAndView edit(
            // Required for editting an existing address
            @RequestParam(name = "id", required = false) String id,
            // Required for creating new address
            @RequestParam(name = "personId", required = false) String personId
            // If both provided and address record is found by id - personId is disregarded
    ) {
        Address address = null;
        try {
            // First we try to find an existing address by id
            address = addressDAO.getOne(new Integer(id));
        } catch (Exception ex) {
            // id was not provided - normal flow for new address
            // id was provided but could not be parsed and converted to number - should be reported as an error
        }
        // Here we should check if id was provided but corresponding address record was not found in database
        // then report an error.
        // For this example we will treat it as a normal new address entry flow.

        // Finding a person to whom this address belongs
        Person person = null;
        if (address != null) {
            // For existing address - just retrieve related object
            person = address.getPerson();
        } else {
            address = new Address();
            // For new address find a person by provided personId parameter
            try {
                person = personDAO.getOne(new Integer(personId));
            } catch (Exception ex) {
                // personId was not provided - should be reported as an error
                // personId was provided but could not be parsed an converted to number - should be reported as an error
            }
        }
        if (person == null) {
            // personId was not provided - should be reported as error earlier
            // personId could not be parsed and converted to number - should be reported as error earlier
            // personId was ok but there is no record with specified id - should be reported as error
            // In this simple example: for all error cases redirect to adddress list view which in turn will
            // redirect to person list view because there is no provided personId
            return new ModelAndView("redirect:../");
        }
        ModelAndView mv = new ModelAndView("addressEdit");
        mv.addObject("person", person);
        mv.addObject("address", address);
        return mv;
    }

    @RequestMapping(path = "save", method = RequestMethod.POST)
    @Transactional
    public String save(
            // Required for updating an existing address
            @RequestParam(name = "id", required = false) String id,
            // Required for creating new address
            @RequestParam(name = "personId", required = false) String personId,
            // If both provided and address record is found by id - personId is disregarded

            @RequestParam(name = "address", required = false) String addr,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "postalCode", required = false) String postalCode
    ) {
        Address address = null;
        try {
            // First we try to find an existing address by id
            address = addressDAO.getOne(new Integer(id));
        } catch (Exception ex) {
            // id was not provided - normal flow for new address
            // id was provided but could not be parsed and converted to number - should be reported as an error
        }
        // Here we should check if id was provided but corresponding address record was not found in database
        // then report an error.
        // For this example we will treat it as a normal new address entry flow.
        if (address == null) {
            // Crearing new address
            address = new Address();
        }
        if (address.getPerson() == null) {
            // For new addresses we have to find a person object to whom this address should belong.
            try {
                Person person = personDAO.getOne(new Integer(personId));
                address.setPerson(person);
            } catch (Exception ex) {
                // personId was not provided for new address - should be reported as an error
                // personId was provided but could not be parsed an converted to number - should be reported as an error
            }
        }
        if (address.getPerson() == null) {
            // personId was not provided for new address - should be reported as an error earlier
            // personId was provided but could not be parsed an converted to number - should be reported as an error earlier
            // Person was not found by provided personId - should be reported as an error
            // for this example for all error cases just redirect back to address list
            // which in turn will redirect to person list because there is no provided personId
            return "redirect:./";
        }
        // Setting properties for object
        address.setAddress(addr);
        address.setCity(city);
        address.setPostalCode(postalCode);
        // Saving object to DB
        addressDAO.save(address);
        // Redirecting to list of addresses for specified person
        return "redirect:./?personId=" + address.getPerson().getId();
    }

    @RequestMapping(path = "delete", method = RequestMethod.GET)
    @Transactional
    public String delete(
            @RequestParam(name = "id") String id
    ) {
        Integer personId = null;
        try {
            Address address = addressDAO.getOne(new Integer(id));
            personId = address.getPerson().getId();
            addressDAO.delete(address);
        } catch (Exception ex) {
            // Here can be three possibilities:
            // - id was not passed - should be reported as error;
            // - passed id string could not be converted to number - should be reported as an error;
            // - id was ok but record was not found in database - should be reported as an error.
            // In this simple example all error cases will result in no operation.
        }
        if (personId == null) {
            // if address was not found and deleted (this variable will be null)
            // redirect back to address list which in turn will redirect to person list
            // because there is no provided personId
            return "redirect:./";
        }
        // Redirecting to list of addresses for specified person
        return "redirect:./?personId=" + personId;
    }
}
