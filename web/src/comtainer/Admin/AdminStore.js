
import {decorate, observable} from "mobx";
import axios from "axios";
import {institution} from "../../stores/InstitutionsStore";
const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev

const status = {FETCHING:"Loading", FAILED_TO_FETCH:"failed", FETCHING_DONE:"Done Loading",FETCHING_IDLE:"Idle"};


class AdminStore{
    state = status.FETCHING_IDLE;
    vejnavn = "";
    postNr = "";
    response = "";

doUpdate(){
    this.state = status.FETCHING
    axios.post(baseUrl + "rest/institution/update", {

    vejnavn: this.vejnavn,
    postNr: this.postNr

    }, {
        headers: {
            'authorization': localStorage.getItem("jwt-token")
        }
    })
    .then(res => {

        console.log(res)
        this.response=JSON.stringify(res);
        this.state = status.FETCHING_DONE;
        institution.fetchItem();

    })
        .catch(error => {

            this.state = status.FAILED_TO_FETCH;
            console.log(error)
        })
    }
}







decorate(AdminStore,{
    state:observable,
    vejnavn:observable,
    postNr:observable,
    response:observable


});

export const adminStore = new AdminStore();