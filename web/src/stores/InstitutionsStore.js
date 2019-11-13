
import {decorate, observable} from "mobx";
const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev

const states = {LOADING:"LOAD", DONE:"DONE", FAILED:"FAILED"}


export default class InstitutionsStore{
state = states.DONE;

    vuggestuer = [];



    constructor() {
        //Loading data when it when the store is initialized.
        this.fetchItem();
    }

//Todo: find out why this is called only when npm restarts
//The fetchcall
    fetchItem (){

        this.state = states.LOADING;
        fetch(baseUrl + "rest/mongo/getKGardenQuery")
        .then((response)=> {
            console.log(response);
            response.json().then((json)=> {

                console.log(this.test)
                this.vuggestuer = json;
                this.state = states.DONE;
            })
        })
        .catch((error)=>{
            console.log(error.status)
            this.state = states.FAILED;
            //this.vuggestuer = ["loading failed, kindergarden not found :C. The servers is likely down."]
        });
    }



}







decorate(InstitutionsStore,{
    vuggestuer:observable,

});

export const institution = new InstitutionsStore();