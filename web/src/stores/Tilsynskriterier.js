import {decorate, observable} from "mobx";





export default class Tilsynskriterier {

gettilsynskriterier = [""]





}
decorate(tilsynskriterier,{
    state: observable,
    token: observable,
    logindata:observable

});
export const tilsynskriterier = new Tilsynskriterier();


