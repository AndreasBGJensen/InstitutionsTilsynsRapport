(this.webpackJsonpweb=this.webpackJsonpweb||[]).push([[0],{48:function(e,t,a){e.exports=a(69)},53:function(e,t,a){},54:function(e,t,a){},69:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),l=a(19),s=a.n(l),c=(a(53),a(6)),i=a(7),o=a(11),u=a(10),m=a(12),h=(a(54),a(55),a(47)),d=(a(30),function(e){function t(){return Object(c.a)(this,t),Object(o.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement("a",{href:"rest/campusnet/login"},"login med campusnet")}}]),t}(r.a.Component)),E=a(27),p=function(e){function t(){var e,a;Object(c.a)(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return(a=Object(o.a)(this,(e=Object(u.a)(t)).call.apply(e,[this].concat(r)))).state={user:{name:"",email:"",username:""},userError:{},brugere:[]},a.onInputChange=function(e){var t=a.state.user;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name)},a.onSubmit=function(e){var t=Object(E.a)(a.state.brugere),n=a.state.user,r=a.validate(n);a.setState({userError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({brugere:t.concat(n),user:{name:n.name,email:n.email,username:n.username}}),console.log(a.state.user))},a.validate=function(e){var t={};return e.name||(t.name="Username required"),e.email||(t.email="Email required"),e.username||(t.username="Username required"),t},a}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"username",placeholder:"username",value:this.state.user.username,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.username),r.a.createElement("br",null),r.a.createElement("input",{name:"email",placeholder:"email",type:"email",value:this.state.user.email,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.email),r.a.createElement("br",null),r.a.createElement("input",{placeholder:"name",name:"name",type:"text",value:this.state.user.name,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.name),r.a.createElement("br",null),r.a.createElement("input",{type:"submit"})))}}]),t}(r.a.Component),g=a(14),b=a(17),v=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(o.a)(this,Object(u.a)(t).call(this,e))).onSubmit=function(e){var t=Object(E.a)(a.state.adresses),n=a.state.fiels,r=a.validate(n);a.setState({searchError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({fields:t.concat(n),fiels:{adress:n.adress,zipcode:n.zipcode}}),console.log(a.state.fiels))},a.validate=function(e){var t={};return e.adress||(t.adress="Adress required"),e.zipcode||(t.zipcode="Zipcode required"),t},a.onInputChange=function(e){var t=a.state.fiels;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name),console.log("Handle change"+a.state.fiels.adress),console.log("Handle change"+a.state.fiels.zipcode)},a.state={fiels:{adress:"",zipcode:""},searchError:{},adresses:[]},a}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"adress",placeholder:"Adresse",value:this.state.adress,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.adress),r.a.createElement("br",null),r.a.createElement("input",{name:"zipcode",placeholder:"post nr",value:this.state.zipcode,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.zipcode),r.a.createElement("br",null),r.a.createElement(g.b,{to:{pathname:"/searchResults",state:{name:"Hello"}}},r.a.createElement("input",{type:"submit"}))))}}]),t}(r.a.Component),f=a(33),O=a(3),j={LOADING:"LOAD",DONE:"DONE",FAILED:"FAILED"},y=function(){function e(){Object(c.a)(this,e),this.state=j.DONE,this.vuggestuer=[],this.fetchItem()}return Object(i.a)(e,[{key:"fetchItem",value:function(){var e=this;this.state=j.LOADING,fetch("rest/institution/all").then((function(t){console.log(t),t.json().then((function(t){e.test=t,console.log(e.test),e.vuggestuer=t,e.state=j.DONE}))})).catch((function(t){console.log(t),e.state=j.FAILED}))}}]),e}();Object(O.g)(y,{vuggestuer:O.l});var k=new y,C=function(e){var t=e.list;return r.a.createElement("ul",null,t.map((function(e,t){return r.a.createElement(I,{key:t,item:e})})))},I=function(e){var t=e.item;return r.a.createElement("div",null,r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.navn))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,"object"==typeof t.indstsers?r.a.createElement("div",null,t.tilsynsPath.map((function(e,a){return r.a.createElement("div",null,r.a.createElement("a",{href:t.link[a]},t.tilsynsPath[a]),")}")}))):null))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null," venteliste ",t.venteliste))))},w=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(o.a)(this,Object(u.a)(t).call(this,e))).state={user:"",loading:""},console.log(e.location.state),a}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("ul",null,r.a.createElement("p",null,k.state),r.a.createElement(C,{list:k.vuggestuer}),r.a.createElement("br",null)))}}]),t}(r.a.Component),S=a(43);var D=function(){return r.a.createElement("div",null,r.a.createElement("h1",null,"This is the landingPage"),r.a.createElement(g.b,{to:{pathname:"/search"}},r.a.createElement(S.a,null," Se Tilsyn ")))},L=a(23),z=a(22),A=function(e){function t(){return Object(c.a)(this,t),Object(o.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(L.a,{bg:"light",expand:"lg"},r.a.createElement(L.a.Brand,{href:"#/"},"Tilsyn.dk"),r.a.createElement(L.a.Toggle,{"aria-controls":"basic-navbar-nav"}),r.a.createElement(L.a.Collapse,{id:"basic-navbar-nav"},r.a.createElement(z.a,{className:"mr-auto"},r.a.createElement(z.a.Link,{href:"#home"},"Home"),r.a.createElement(z.a.Link,{href:"https://www.kk.dk/indhold/s%C3%B8g-og-skriv-dit-barn-op-til-vuggestue-og-dagpleje"},"Opskrivning til vuggestue"),r.a.createElement(z.a.Link,{href:"#login"},"Log Ind"),r.a.createElement(z.a.Link,{href:"#register"},"Registrer dig")))))}}]),t}(r.a.Component),N=function(e){function t(){return Object(c.a)(this,t),Object(o.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(i.a)(t,[{key:"render",value:function(){return r.a.createElement(f.a,null,r.a.createElement(A,null),r.a.createElement(g.a,null,r.a.createElement(b.c,null,r.a.createElement(b.a,{exact:!0,path:"/",component:D}),r.a.createElement(b.a,{path:"/register",component:p}),r.a.createElement(b.a,{path:"/login",component:d}),r.a.createElement(b.a,{path:"/search",component:v}),r.a.createElement(b.a,{path:"/searchResults",component:w}))))}}]),t}(r.a.Component),H=Object(h.a)(N);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(r.a.createElement(g.a,null,r.a.createElement(H,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[48,1,2]]]);
//# sourceMappingURL=main.a09cdcb4.chunk.js.map