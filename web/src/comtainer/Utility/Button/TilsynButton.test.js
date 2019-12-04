import React from 'react'
import ReactDOM from 'react-dom'
import TilsynButton from "./TilsynButton"
import {render} from "@testing-library/react"
import "jest-dom/extend-expect"

it("render button without crasching", ()=> {
    const div = document.createElement("div");
    ReactDOM.render(<TilsynButton lable="Se Tilsyn"/>,div)
})


/*it('render correct button', () => {
    const { getByTestId } = render(<TilsynButton lable="Se Tilsyn"/>);

  expect(getByTestId('tilsynButton')).toBe('Se Tilsyn');

})*/