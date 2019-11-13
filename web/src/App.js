import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';

import {observer} from "mobx-react";
import InstitutionsStore from "./stores/InstitutionsStore";
import LogIn from "./comtainer/Costumer/LogIn";
import Register from "./comtainer/Costumer/Register"
import {HashRouter as Router,Route} from "react-router-dom";
import SearchInstitution from "./comtainer/Costumer/SearchInstitution"

import {Switch} from "react-router-dom"
import Container from "react-bootstrap/Container";
import institutionView from "./comtainer/Costumer/InstitutionView"



class App extends React.Component{

render()
    {
        return (




            <Container>
                <Router>
                    <Switch>
                        <Route exact path={"/"} component={LandingPage}/>
                        <Route path={"/register"} component={Register}/>
                        <Route path={"/login"} component={LogIn}/>
                        <Route path={"/search"} component={SearchInstitution}/>
                        <Route path={"/searchResults"} component={institutionView}/>
                    </Switch>
                </Router>
            </Container>
        )
    }

}

export default observer(App);
