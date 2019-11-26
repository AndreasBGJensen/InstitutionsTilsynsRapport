import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'

const baseUrl = process.env.NODE_ENV === 'development' ?  "http://localhost:8080/":""; //Check if dev




export class LogIn extends React.Component{

    /*constructor() {
        super();
        //Loading data when it when the store is initialized.
        this.fetchItem();
    }

    fetchItem(){
        fetch(baseUrl + "rest/campusnet/login")
            .then(()=> {
                //console.log(response)
            })
            .catch((error)=>{
                console.log(error)

            });
    }*/

    render() {

        return <a href={baseUrl+"rest/campusnet/login"}>login med campusnet</a>
    }

    /*
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
    }*/
}

export default LogIn