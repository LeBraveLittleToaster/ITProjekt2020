import { observable, computed, decorate, action } from 'mobx';
import { persist } from 'mobx-persist';

export class AppStore {
    token = undefined;
    lastname = "loading lastnam";
    firstname = "loading firstname";
    street = "loading street";
    plz = "loading plz";
    postcode = "loading postcode";
    cityname = "loading cityname"
    userID = "loading userID";
    crDate = undefined;
    roleID = "loading roleID";
    loginname = "loading loginname"

    constructor() {
        console.log("Creating store")
    }

    setUserTokenAndLoginname(token, loginname) {
        if (token !== null && token !== undefined) {
            this.token = token;
        }
        if (loginname !== null && loginname !== undefined) {
            this.loginname = loginname;
        }
    }

    setPatient(lastname, firstname, street, plz, postcode, cityname) {
        if (lastname !== null && lastname !== undefined) {
            this.lastname = lastname;
        }
        if (firstname !== null && firstname !== undefined) {
            this.firstname = firstname;
        }
        if (street !== null && street !== undefined) {
            this.street = street;
        }
        if (plz !== null && plz !== undefined) {
            this.plz = plz;
        }
        if (postcode !== null && postcode !== undefined) {
            this.postcode = postcode;
        }
        if (cityname !== null && cityname !== undefined) {
            this.cityname = cityname;
        }
    }
    setUser(userID, crDate, roleID, loginname) {
        if (userID !== null && userID !== undefined) {
            this.userID = userID;
        }
        if (crDate !== null && crDate !== undefined) {
            this.crDate = crDate;
        }
        if (roleID !== null && roleID !== undefined) {
            this.roleID = roleID;
        }
        if (loginname !== null && loginname !== undefined) {
            this.loginname = loginname;
        }
    }
}

decorate(AppStore, {
    token : [persist, observable],
    lastname : [persist, observable],
    firstname : [persist, observable],
    street : [persist, observable],
    plz : [persist, observable],
    postcode : [persist, observable],
    cityname : [persist, observable],
    userID : [persist, observable],
    crDate : [persist, observable],
    roleID : [persist, observable],
    loginname : [persist, observable],
    
    setUserTokenAndLoginname: action,
    setUser: action,
    setPatient: action,
    
});