function loadPersons(callback) {
    $.ajax({
        url: "rest/person",
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function loadPerson(id, callback) {
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not load person. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function savePerson(person, callback) {
    if (person === null || typeof person !== "object") {
        return callback(new Error("Can not save person. Invalid person object."));
    }
    // Make sure person.id is a number or null
    person.id = parseInt(person.id);
    if (isNaN(person.id) || person.id <= 0) {
        person.id = null;
    }
    const savePerson = {};
    if (person.firstName) {
        savePerson.firstName = "" + person.firstName;
    }
    if (person.lastName) {
        savePerson.lastName = "" + person.lastName;
    }
    // Converting value to Date object
    person.birthDate = new Date(person.birthDate);
    // If date is valid - create string representation of provided date
    if (!isNaN(person.birthDate.getTime())) {
        let year = `0000${person.birthDate.getFullYear()}`;
        year = year.substring(year.length - 4);
        let month = `00${person.birthDate.getMonth() + 1}`;
        month = month.substring(month.length - 2);
        let day = `00${person.birthDate.getDate()}`;
        day = day.substring(day.length - 2);
        savePerson.birthDate = `${year}-${month}-${day}T12:00:00.000Z`;
    }
    const salary = parseFloat(person.salary);
    if (!isNaN(salary)) {
        savePerson.salary = salary;
    }
    $.ajax({
        url: `rest/person${person.id ? `/${person.id}` : ""}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: person.id ? "PUT" : "POST",
        data: JSON.stringify(savePerson),
        success: (data) => {
            callback(null, data);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function deletePerson(id, callback) {
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not delete person. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "DELETE",
        success: (data) => {
            callback(null, data);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function loadAddresses(personId, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not load person addresses. Invalid person id: ${personId}`));
    }
    $.ajax({
        url: `rest/person/${personId}/address`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function loadAddress(personId, id, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not load person address. Invalid person id: ${personId}`));
    }
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not load person address. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${personId}/address/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function saveAddress(personId, address, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not save person address. Invalid person id: ${personId}`));
    }
    if (address === null || typeof address !== 'object') {
        return callback(new Error("Can not save person address. Invalid address object."));
    }
    // Make sure address.id is a number or null
    address.id = parseInt(address.id);
    if (isNaN(address.id) || address.id <= 0) {
        address.id = null;
    }
    const saveAddress = {};
    if (address.address) {
        saveAddress.address = "" + address.address;
    }
    if (address.city) {
        saveAddress.city = "" + address.city;
    }
    if (address.postalCode) {
        saveAddress.postalCode = "" + address.postalCode;
    }
    $.ajax({
        url: `rest/person/${personId}/address${address.id ? `/${address.id}` : ""}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: address.id ? "PUT" : "POST",
        data: JSON.stringify(saveAddress),
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function deleteAddress(personId, id, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not delete person address. Invalid person id: ${personId}`));
    }
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not delete person address. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${personId}/address/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "DELETE",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function loadContacts(personId, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not load person contacts. Invalid person id: ${personId}`));
    }
    $.ajax({
        url: `rest/person/${personId}/contact`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function loadContact(personId, id, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not load person contact. Invalid person id: ${personId}`));
    }
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not load person contact. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${personId}/contact/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "GET",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function saveContact(personId, contact, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not save person contact. Invalid person id: ${personId}`));
    }
    if (contact === null || typeof contact !== 'object') {
        return callback(new Error("Can not save person contact. Invalid contact object."));
    }
    // Make sure contact.id is a number or null
    contact.id = parseInt(contact.id);
    if (isNaN(contact.id) || contact.id <= 0) {
        contact.id = null;
    }
    const saveContact = {};
    if (contact.type) {
        saveContact.type = "" + contact.type;
    }
    if (contact.contact) {
        saveContact.contact = "" + contact.contact;
    }
    $.ajax({
        url: `rest/person/${personId}/contact${contact.id ? `/${contact.id}` : ""}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: contact.id ? "PUT" : "POST",
        data: JSON.stringify(saveContact),
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}

function deleteContact(personId, id, callback) {
    // Make sure personId is a number
    personId = parseInt(personId);
    if (isNaN(personId) || personId <= 0) {
        return callback(new Error(`Can not delete person contact. Invalid person id: ${personId}`));
    }
    // Make sure id is a number
    id = parseInt(id);
    if (isNaN(id) || id <= 0) {
        return callback(new Error(`Can not delete person contact. Invalid id: ${id}`));
    }
    $.ajax({
        url: `rest/person/${personId}/contact/${id}`,
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        type: "DELETE",
        success: (data) => {
            callback(null, data, personId);
        },
        error: (err) => {
            callback(err);
        }
    });
}
