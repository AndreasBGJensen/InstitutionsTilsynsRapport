import React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'


class NavBar extends React.Component {


    render(){
        return (
        <div>
            <Navbar bg="light" expand="lg" >
                <Navbar.Brand href={"#/"}>Tilsyn.dk</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="https://www.kk.dk/indhold/s%C3%B8g-og-skriv-dit-barn-op-til-vuggestue-og-dagpleje">Opskrivning til vuggestue</Nav.Link>

                        <Nav.Link href="#login">Log Ind</Nav.Link>
                        <Nav.Link href="#admin">Admin</Nav.Link>

                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </div>



        )

    }



}

export default NavBar