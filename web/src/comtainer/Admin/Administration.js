import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import {Link} from "react-router-dom"
import axios from 'axios';
import {institution} from "../../stores/InstitutionsStore";
const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev

const status = {FETCHING:"Loading", FAILED_TO_FETCH:"failed", FETCHING_DONE:"Done Loading"};


class Administration extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            fiels : {
                vejnavn:'',
                postNr:''},

            searchError: {},
            adresses:[],
            process: status.FETCHING_DONE,
            response: "",
            neterror:""
        };
    }

buttonClickEvent(){
        const button = document.getElementById("submitButton");
        button.style.display = false;
}

    onSubmit=(evt)=>{
        this.buttonClickEvent();
        this.state.process = status.FETCHING;
console.log("ON SUBMIT: "+this.state.fiels)
        const adresses = [...this.state.adresses];
        const field = this.state.fiels;
        const fieldError = this.validate(field);
        this.setState({searchError:fieldError});
        evt.preventDefault();

        if(Object.keys(fieldError).length) return;

//Here I set the state for the input.
        this.setState({
            fields:adresses.concat(field),
            fiels :{
                vejnavn:field.vejnavn,
                postNr:field.postNr,

            }
        });
        console.log(this.state.fiels)


axios.post(baseUrl + "rest/institution/update", {

        vejnavn: this.state.fiels.vejnavn,
        postNr: this.state.fiels.postNr

    }, {
    headers: {
        'authorization': localStorage.getItem("jwt-token")
    }
})
    .then(res => {

        console.log(res)
        this.setState({response:JSON.stringify(res)});
        institution.fetchItem();

    })
        .catch(error => {
            this.setState({neterror: JSON.stringify(error)});
            this.setState({process: status.FAILED_TO_FETCH});
            console.log(error)
        })

    }


//Validates if there is an input
    validate=(fiels)=>{
        const errors={};
        if(!fiels.vejnavn) errors.adress = "vejnavn required";
        if(!fiels.postNr) errors.zipcode ="post nr required";

        return errors;

    };

    //This function updates every time a key have been stroke
    onInputChange = (event) => {

        const field = this.state.fiels;
        field[event.target.name] = event.target.value;
        this.setState({user: field});
        console.log('Handle change' +event.target.name);
        console.log('Handle change' +this.state.fiels.vejnavn);
        console.log('Handle change' +this.state.fiels.postNr);
    };





    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <input
                        name="vejnavn"
                        placeholder="Adresse"
                        value={this.state.vejnavn}
                        onChange={this.onInputChange}
                    />
                    <span style={{color:'red'}}>{this.state.searchError.vejnavn}</span>
                    <br/>
                    <input
                        name="postNr"
                        placeholder="post nr"
                        value={this.state.postNr}
                        onChange={this.onInputChange}
                    />
                    <span style={{color:'red'}}>{this.state.searchError.postNr}</span>
                    <br/>



                        <input id="submitButton" type="submit"/>

                </form>

                <p>{this.state.process}</p>

                <br/>
                <h1>{this.state.response}</h1>
                <h1>{this.state.error}</h1>

            </div>

        )
    }
}


export default Administration