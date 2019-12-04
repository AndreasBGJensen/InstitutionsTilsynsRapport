import React from 'react';
import {Link} from "react-router-dom";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";

function LandingPage(){

    return(
        <div>
            <h1>This is the landingPage</h1>

            <Link to ={{//Linking to search results
                pathname: "/searchResults",

            }} >
                <Button> Se Tilsyn </Button>
            </Link>

        </div>


    )



}

export default LandingPage