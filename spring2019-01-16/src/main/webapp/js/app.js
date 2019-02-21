$(() => {
    loadPersons(listPersons);
});

function listPersons(err, data) {
    const main = $("#main");
    main.empty();
    if (err) {
        alert("Failed to load person list\n" + err);
        main.append(`<button id="refresh">Refresh</button>`);
        $("#refresh").click(() => {
            loadPersons(listPersons);
        });
        return;
    }
    main.append(`<table id="list"></table>`);
    main.append(`<button id="newButton">New</button>`);
    main.append(`<button id="refreshButton">Refresh</button>`);
    $("#newButton").click((event) => {
        editPerson();
    });
    $("#refreshButton").click(() => {
        loadPersons(listPersons);
    });
    if (Array.isArray(data)) {
        const list = $("#list");
        for (let i = 0, l = data.length; i < l; i++) {
            const row = $("<tr>");
            let td = $("<td>");
            td.text(data[i].id);
            row.append(td);
            td = $("<td>");
            td.text(data[i].firstName);
            row.append(td);
            td = $("<td>");
            td.text(data[i].lastName);
            row.append(td);
            td = $("<td>");
            td.text(data[i].birthDate);
            row.append(td);
            td = $("<td>");
            td.text(data[i].salary);
            row.append(td);
            td = $("<td>");
            let button = $(`<button personId="${data[i].id}">Edit</button>`);
            button.click((event) => {
                loadPerson(event.target.getAttribute("personId"), editPerson);
            });
            td.append(button);
            row.append(td);
            td = $("<td>");
            button = $(`<button personId="${data[i].id}">Delete</button>`);
            button.click((event) => {
                deletePerson(event.target.getAttribute("personId"), () => {
                    loadPersons(listPersons);
                });
            });
            td.append(button);
            row.append(td);
            td = $("<td>");
            button = $(`<button personId="${data[i].id}">Addresses</button>`);
            button.click((event) => {
                loadAddresses(event.target.getAttribute("personId"), listAddresses);
            });
            td.append(button);
            row.append(td);
            td = $("<td>");
            button = $(`<button personId="${data[i].id}">Contacts</button>`);
            button.click((event) => {
                loadContacts(event.target.getAttribute("personId"), listContacts);
            });
            td.append(button);
            row.append(td);
            list.append(row);
        }
    }
}

function editPerson(err, person) {
    if (err) {
        alert("Failed to load person\n" + err);
        return loadPersons(listPersons);
    }
    const main = $("#main");
    main.empty();
    main.append(`<input id="id" type="hidden" value="${person ? person.id : ""}"></input>`);
    main.append(`First name: <input id="firstName" type="text" value="${person ? person.firstName : ""}"></input>`);
    main.append("<br></br>");
    main.append(`Last name: <input id="lastName" type="text" value="${person ? person.lastName : ""}"></input>`);
    main.append("<br></br>");
    let birthDate = (person) ? new Date(person.birthDate) : null;
    birthDate = (birthDate && !isNaN(birthDate.getTime())) ? birthDate.toISOString().substring(0, 10) : "";
    main.append(`Birth date: <input id="birthDate" type="date" value="${birthDate}"></input>`);
    main.append("<br></br>");
    main.append(`Salary: <input id="salary" type="text" value="${person ? person.salary : ""}"></input>`);
    main.append("<br></br>");
    main.append(`<button id="saveButton">Save</button>`);
    main.append(`<button id="cancelButton">Cancel</button>`);
    $("#saveButton").click(() => {
        const person = {
            id: $("#id").val(),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            birthDate: $("#birthDate").val(),
            salary: $("#salary").val()
        };
        savePerson(person, () => {
            loadPersons(listPersons);
        });
    });
    $("#cancelButton").click(() => {
        loadPersons(listPersons);
    });
}

function listAddresses(err, data, personId) {
    if (err) {
        alert("Failed to load person addresses list\n" + err);
        return loadPersons(listPersons);
    }
    if (typeof personId !== "number" || personId <= 0) {
        return loadPersons(listPersons);
    }
    const main = $("#main");
    main.empty();
    main.append(`<table id="list"></table>`);
    main.append(`<button id="newButton">New</button>`);
    main.append(`<button id="refreshButton">Refresh</button>`);
    main.append(`<button id="backButton">Back</button>`);
    $("#newButton").click((event) => {
        editAddress(null, null, personId);
    });
    $("#refreshButton").click(() => {
        loadAddresses(personId, listAddresses);
    });
    $("#backButton").click(() => {
        loadPersons(listAddresses);
    });
    if (Array.isArray(data)) {
        const list = $("#list");
        for (let i = 0, l = data.length; i < l; i++) {
            const row = $("<tr>");
            let td = $("<td>");
            td.text(data[i].id);
            row.append(td);
            td = $("<td>");
            td.text(data[i].address);
            row.append(td);
            td = $("<td>");
            td.text(data[i].city);
            row.append(td);
            td = $("<td>");
            td.text(data[i].postalCode);
            row.append(td);
            td = $("<td>");
            let button = $(`<button personId="${personId}" addressId="${data[i].id}">Edit</button>`);
            button.click((event) => {
                loadAddress(event.target.getAttribute("personId"), event.target.getAttribute("addressId"), editAddress);
            });
            td.append(button);
            row.append(td);
            td = $("<td>");
            button = $(`<button personId="${personId}" addressId="${data[i].id}">Delete</button>`);
            button.click((event) => {
                deleteAddress(event.target.getAttribute("personId"), event.target.getAttribute("addressId"), () => {
                    loadAddresses(personId, listAddresses);
                });
            });
            td.append(button);
            row.append(td);
            list.append(row);
        }
    }
}

function editAddress(err, address, personId) {
    if (err) {
        alert("Failed to load person address\n" + err);
        return loadPersons(listPersons);
    }
    if (typeof personId !== "number" || personId <= 0) {
        return loadPersons(listPersons);
    }
    const main = $("#main");
    main.empty();
    main.append(`<input id="id" type="hidden" value="${address ? address.id : ""}"></input>`);
    main.append(`Address: <input id="address" type="text" value="${address ? address.address : ""}"></input>`);
    main.append("<br></br>");
    main.append(`City: <input id="city" type="text" value="${address ? address.city : ""}"></input>`);
    main.append("<br></br>");
    main.append(`Postal code: <input id="postalCode" type="text" value="${address ? address.postalCode : ""}"></input>`);
    main.append("<br></br>");
    main.append(`<button id="saveButton">Save</button>`);
    main.append(`<button id="cancelButton">Cancel</button>`);
    $("#saveButton").click(() => {
        const address = {
            id: $("#id").val(),
            address: $("#address").val(),
            city: $("#city").val(),
            postalCode: $("#postalCode").val()
        };
        saveAddress(personId, address, () => {
            loadAddresses(personId, listAddresses);
        });
    });
    $("#cancelButton").click(() => {
        loadAddresses(personId, listAddresses);
    });
}

function listContacts(err, data, personId) {
    if (err) {
        alert("Failed to load person contacts list\n" + err);
        return loadPersons(listPersons);
    }
    if (typeof personId !== "number" || personId <= 0) {
        return loadPersons(listPersons);
    }
    const main = $("#main");
    main.empty();
    main.append(`<table id="list"></table>`);
    main.append(`<button id="newButton">New</button>`);
    main.append(`<button id="refreshButton">Refresh</button>`);
    main.append(`<button id="backButton">Back</button>`);
    $("#newButton").click((event) => {
        editContact(null, null, personId);
    });
    $("#refreshButton").click(() => {
        loadContacts(personId, listContacts);
    });
    $("#backButton").click(() => {
        loadPersons(listAddresses);
    });
    if (Array.isArray(data)) {
        const list = $("#list");
        for (let i = 0, l = data.length; i < l; i++) {
            const row = $("<tr>");
            let td = $("<td>");
            td.text(data[i].id);
            row.append(td);
            td = $("<td>");
            td.text(data[i].type);
            row.append(td);
            td = $("<td>");
            td.text(data[i].contact);
            row.append(td);
            td = $("<td>");
            let button = $(`<button personId="${personId}" contactId="${data[i].id}">Edit</button>`);
            button.click((event) => {
                loadContact(event.target.getAttribute("personId"), event.target.getAttribute("contactId"), editContact);
            });
            td.append(button);
            row.append(td);
            td = $("<td>");
            button = $(`<button personId="${personId}" contactId="${data[i].id}">Delete</button>`);
            button.click((event) => {
                deleteContact(event.target.getAttribute("personId"), event.target.getAttribute("contactId"), () => {
                    loadContacts(personId, listContacts);
                });
            });
            td.append(button);
            row.append(td);
            list.append(row);
        }
    }
}

function editContact(err, contact, personId) {
    if (err) {
        alert("Failed to load person contact\n" + err);
        return loadPersons(listPersons);
    }
    if (typeof personId !== "number" || personId <= 0) {
        return loadPersons(listPersons);
    }
    const main = $("#main");
    main.empty();
    main.append(`<input id="id" type="hidden" value="${contact ? contact.id : ""}"></input>`);
    main.append(`Type: <input id="type" type="text" value="${contact ? contact.type : ""}"></input>`);
    main.append("<br></br>");
    main.append(`Contact: <input id="contact" type="text" value="${contact ? contact.contact : ""}"></input>`);
    main.append("<br></br>");
    main.append(`<button id="saveButton">Save</button>`);
    main.append(`<button id="cancelButton">Cancel</button>`);
    $("#saveButton").click(() => {
        const contact = {
            id: $("#id").val(),
            type: $("#type").val(),
            contact: $("#contact").val()
        };
        saveContact(personId, contact, () => {
            loadContacts(personId, listContacts);
        });
    });
    $("#cancelButton").click(() => {
        loadContacts(personId, listContacts);
    });
}
