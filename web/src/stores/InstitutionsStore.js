
import {decorate, observable} from "mobx";
import {TokenStore} from "./TokenStore";
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
        const token = TokenStore.token;
        //{headers:{"authorization":localStorage.getItem(("jwt-token"))}}
        //todo: the fetch statment is parsing the header in a wrong way.
        this.state = states.LOADING;
        console.log("the header passed from store:"+{headers:{Authorization: localStorage.getItem(("portal-jwt-Token"))}});
        fetch(baseUrl + "rest/institution/all",{
            headers:{
                "Authorization": localStorage.getItem(("portal-jwt-Token"))
            }
        }).then((response)=> {
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