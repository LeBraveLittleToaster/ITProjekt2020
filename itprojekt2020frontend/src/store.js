import { observable, computed, decorate, action } from 'mobx';
import { persist } from 'mobx-persist';

export class AppStore {
    isHydrated = undefined;
    token = undefined;
    lastname = undefined;
    firstname = undefined;
    street = undefined;
    plz = undefined;
    postcode = undefined;
    cityname = undefined
    userID = undefined;
    crDate = undefined;
    roleID = undefined;
    loginname = undefined

    constructor() {
        console.log("Creating store")
    }
    setIsHydrated(isHydrated){
        this.isHydrated = isHydrated;
    }

    setUserTokenAndLoginname(token, loginname) {
        this.token = token;
        this.loginname = loginname;
        
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
    isHydrated: observable,
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
    
    setIsHydrated: action,
    setUserTokenAndLoginname: action,
    setUser: action,
    setPatient: action,
    
});