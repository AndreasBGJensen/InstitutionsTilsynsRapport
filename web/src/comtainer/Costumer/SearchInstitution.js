import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import {Link} from "react-router-dom"

class SearchInstitution extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            fiels : {
                adress:'',
                zipcode:''},

            searchError: {},
            adresses:[],
        };
    }

    onSubmit=(evt)=>{
        const adresses = [...this.state.adresses];
        const field = this.state.fiels
        const fieldError = this.validate(field);
        this.setState({searchError:fieldError});
        evt.preventDefault();

        if(Object.keys(fieldError).length) return;


        this.setState({
            fields:adresses.concat(field),
            fiels :{
                adress:field.adress,
                zipcode:field.zipcode,

            }
        });
  console.log(this.state.fiels)

    }

    validate=(fiels)=>{
        const errors={};
        if(!fiels.adress) errors.adress = "Adress required";
        if(!fiels.zipcode) errors.zipcode ="Zipcode required";

        return errors;

    };

    onInputChange = (event) => {

        const field = this.state.fiels;
        field[event.target.name] = event.target.value;
        this.setState({user: field});
        console.log('Handle change' +event.target.name);
        console.log('Handle change' +this.state.fiels.adress);
        console.log('Handle change' +this.state.fiels.zipcode);
    };

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <input
                        name="adress"
                        placeholder="Adresse"
                        value={this.state.adress}
                        onChange={this.onInputChange}
                    />
                    <span style={{color:'red'}}>{this.state.searchError.adress}</span>
                    <br/>
                    <input
                        name="zipcode"
                        placeholder="post nr"
                        value={this.state.zipcode}
                        onChange={this.onInputChange}
                    />
                    <span style={{color:'red'}}>{this.state.searchError.zipcode}</span>
                    <br/>


                    <Link to ={{
                        pathname: "/searchResults",
                        state:{
                            name: "Hello"
                        }

                    }} >
                        <input type="submit"/>
                    </Link>


                </form>

            </div>
            )
        }
    }


export default SearchInstitution