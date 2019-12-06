
import ReactDOM from 'react-dom';
import App from './App';
import '@testing-library/jest-dom/extend-expect';
import { render } from '@testing-library/react';
import {HashRouter} from "react-router-dom";
import React from "react";

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<HashRouter><App /></HashRouter>, div);
  ReactDOM.unmountComponentAtNode(div);
});


test('Silly test',()=>{
  expect(2+2).toBe(4);
});


it('renders welcome message', () => {
  const { getByText } = render(<App />);
  expect(getByText('This is the landingPage')).toBeInTheDocument();
});



