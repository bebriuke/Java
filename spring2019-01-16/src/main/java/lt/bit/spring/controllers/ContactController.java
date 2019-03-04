package lt.bit.spring.controllers;

import lt.bit.spring.dao.ContactDAO;
import lt.bit.spring.dao.PersonDAO;
import lt.bit.spring.db.Contact;
import lt.bit.spring.db.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contact/")
public class ContactController {

    @Autowired
    ContactDAO contactDAO;

    @Autowired
    PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(
            // Required to show contacts for specific person
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
        ModelAndView mv = new ModelAndView("contactList");
        mv.addObject("person", person);
        mv.addObject("contactList", person.getContactList());
        return mv;
    }

    @RequestMapping(path = "edit", method = RequestMethod.GET)
    public ModelAndView edit(
            // Required for editting an existing contact
            @RequestParam(name = "id", required = false) String id,
            // Required for creating new contact
            @RequestParam(name = "personId", required = false) String personId
            // If both provided and contact record is found by id - personId is disregarded
    ) {
        Contact contact = null;
        try {
            // First we try to find an existing contact by id
            contact = contactDAO.getOne(new Integer(id));
        } catch (Exception ex) {
            // id was not provided - normal flow for new contact
            // id was provided but could not be parsed and converted to number - should be reported as an error
        }
        // Here we should check if id was provided but corresponding contact record was not found in database
        // then report an error.
        // For this example we will treat it as a normal new contact entry flow.

        // Finding a person to whom this contact belongs
        Person person = null;
        if (contact != null) {
            // For existing contact - just retrieve related object
            person = contact.getPerson();
        } else {
            contact = new Contact();
            // For new contact find a person by provided personId parameter
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
        ModelAndView mv = new ModelAndView("contactEdit");
        mv.addObject("person", person);
        mv.addObject("contact", contact);
        return mv;
    }

    @RequestMapping(path = "save", method = RequestMethod.POST)
    @Transactional
    public String save(
            // Required for updating an existing contact
            @RequestParam(name = "id", required = false) String id,
            // Required for creating new contact
            @RequestParam(name = "personId", required = false) String personId,
            // If both provided and contact record is found by id - personId is disregarded

            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "contact", required = false) String cont
    ) {
        Contact contact = null;
        try {
            // First we try to find an existing contact by id
            contact = contactDAO.getOne(new Integer(id));
        } catch (Exception ex) {
            // id was not provided - normal flow for new contact
            // id was provided but could not be parsed and converted to number - should be reported as an error
        }
        // Here we should check if id was provided but corresponding contact record was not found in database
        // then report an error.
        // For this example we will treat it as a normal new contact entry flow.
        if (contact == null) {
            // Crearing new contact
            contact = new Contact();
        }
        if (contact.getPerson() == null) {
            // For new contact we have to find a person object to whom this contact should belong.
            try {
                Person person = personDAO.getOne(new Integer(personId));
                contact.setPerson(person);
            } catch (Exception ex) {
                // personId was not provided for new contact - should be reported as an error
                // personId was provided but could not be parsed an converted to number - should be reported as an error
            }
        }
        if (contact.getPerson() == null) {
            // personId was not provided for new contact - should be reported as an error earlier
            // personId was provided but could not be parsed an converted to number - should be reported as an error earlier
            // Person was not found by provided personId - should be reported as an error
            // for this example for all error cases just redirect back to contact list
            // which in turn will redirect to person list because there is no provided personId
            return "redirect:./";
        }
        // Setting properties for object
        contact.setType(type);
        contact.setContact(cont);
        // Saving object to DB
        contactDAO.save(contact);
        // Redirecting to list of contacts for specified person
        return "redirect:./?personId=" + contact.getPerson().getId();
    }

    @RequestMapping(path = "delete", method = RequestMethod.GET)
    @Transactional
    public String delete(
            @RequestParam(name = "id") String id
    ) {
        Integer personId = null;
        try {
            Contact contact = contactDAO.getOne(new Integer(id));
            personId = contact.getPerson().getId();
            contactDAO.delete(contact);
        } catch (Exception ex) {
            // Here can be three possibilities:
            // - id was not passed - should be reported as error;
            // - passed id string could not be converted to number - should be reported as an error;
            // - id was ok but record was not found in database - should be reported as an error.
            // In this simple example all error cases will result in no operation.
        }
        if (personId == null) {
            // if contact was not found and deleted (this variable will be null)
            // redirect back to contact list which in turn will redirect to person list
            // because there is no provided personId
            return "redirect:./";
        }
        // Redirecting to list of contacts for specified person
        return "redirect:./?personId=" + personId;
    }
}
