import React from 'react'


class Register extends React.Component {

    state = {
        user: {
            name: '',
            email: '',
            username: ''
        },
        userError: {},
        brugere:[],
    };



    onInputChange = (event) => {

        const field = this.state.user;
        field[event.target.name] = event.target.value;
        this.setState({user: field});
        console.log('Handle change' +event.target.name);
    };


    onSubmit=(evt)=>{
        const brugere = [...this.state.brugere];
       const field = this.state.user;
       const fieldError = this.validate(field);
       this.setState({userError:fieldError});
        evt.preventDefault();

        if(Object.keys(fieldError).length) return;


       this.setState({
           brugere:brugere.concat(field),
           user :{
               name:field.name,
               email:field.email,
               username:field.username
           }
       });


        console.log(this.state.user)

    }

    validate=(user)=>{
        const errors={};
        if(!user.name) errors.name = "Username required";
        if(!user.email) errors.email ="Email required";
        if(!user.username) errors.username ="Username required";
        return errors;

    };



    render(){
        return(

            <div>
                <form onSubmit={this.onSubmit}>
                    <input
                        name="username"
                        placeholder="username"
                        value={this.state.user.username}
                        onChange={this.onInputChange}
                    />

                    <span style={{color:'red'}}>{this.state.userError.username}</span>
                    <br/>

                    <input
                        name="email"
                        placeholder="email"
                        type='email'
                        value={this.state.user.email}
                        onChange={this.onInputChange}
                    />

                    <span style={{color:'red'}}>{this.state.userError.email}</span>
                    <br/>

                    <input
                        placeholder="name"
                        name="name"
                        type='text'
                        value={this.state.user.name}
                        onChange={this.onInputChange}
                    />
                    <span style={{color:'red'}}>{this.state.userError.name}</span>
                    <br/>
                    <input type="submit"/>
                </form>

            </div>

        )
    }
}

export default Register
