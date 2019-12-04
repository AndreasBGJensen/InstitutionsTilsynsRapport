
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


//The fetchcall
    fetchItem (){
        //{headers:{"authorization":localStorage.getItem(("jwt-token"))}}
        //todo: the fetch statment is parsing the header in a wrong way.
        this.state = states.LOADING;
        console.log("the header passed from store:"+{headers:{"Authorization":"Bearer"+localStorage.getItem(("jwt-token"))}});
        fetch(baseUrl + "rest/institution/all",{headers:{'Authorization':"Bearer"+localStorage.getItem(('jwt-token'))}})
            .then((response)=> {
                console.log(response);
                response.json().then((json)=> {
                    this.test = json;
                    console.log(this.test)
                    this.vuggestuer = json;
                    this.state = states.DONE;
                })
            })
            .catch((error)=>{
                console.log(error)

                this.state = states.FAILED;
            });
    }



}







decorate(InstitutionsStore,{
    vuggestuer:observable,

});

export const institution = new InstitutionsStore();