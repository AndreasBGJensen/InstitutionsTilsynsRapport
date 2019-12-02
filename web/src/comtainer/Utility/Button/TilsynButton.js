import Button from "react-bootstrap/Button";


function TilsynButton({lable}){

    return <Button data-testid="tilsynButton">{lable}</Button>

}

export default TilsynButton;