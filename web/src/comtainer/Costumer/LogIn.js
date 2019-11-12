import React from 'react';
import Button from "react-bootstrap/Button";
import {Form, InputGroup} from "react-bootstrap";
import {TokenStore} from "../../stores/TokenStore";
import 'bootstrap/dist/css/bootstrap.min.css'
const tokenStore = new TokenStore();




export class LogIn extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            username:'',
            password:''};
    }

    handleUsernameChange = (event) => {
        this.setState({username:event.target.value});
        console.log('Handle change' +this.state.username);
    };

    handlePasswordChange = (event) => {
        this.setState({password:event.target.value});
        console.log('Handle change' +this.state.password);
    };


    onSubmit=(evt)=>{
        const name =this.state.username;
        const password = this.state.password;
        this.setState({username:name})
        this.setState({password:password})
        tokenStore.logindata.username=this.state.username;
        tokenStore.logindata.password=this.state.password;
        tokenStore.doLogin();
        evt.preventDefault();
    }



    render() {

        return (

          <div>
              <h1>Login</h1>
                <form onSubmit={this.onSubmit}>
                    <input
                        placeholder="Username"
                        value={this.state.username}
                        onChange={this.handleUsernameChange}
                    />
                    <input
                        placeholder="password"
                        value={this.state.password}
                        onChange={this.handlePasswordChange}
                    />
                    <input type="submit"/>
                </form>

          </div>

        );
    }
}

export default LogIn