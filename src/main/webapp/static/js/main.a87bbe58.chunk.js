(this.webpackJsonpweb=this.webpackJsonpweb||[]).push([[0],{46:function(e,t,a){e.exports=a(67)},51:function(e,t,a){},52:function(e,t,a){},67:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),l=a(19),s=a.n(l),c=(a(51),a(6)),o=a(7),i=a(11),u=a(10),m=a(12),h=(a(52),a(53),a(45)),d=(a(29),function(e){function t(){return Object(c.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("a",{href:"rest/campusnet/login"},"login med campusnet")}}]),t}(r.a.Component)),p=a(26),E=function(e){function t(){var e,a;Object(c.a)(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return(a=Object(i.a)(this,(e=Object(u.a)(t)).call.apply(e,[this].concat(r)))).state={user:{name:"",email:"",username:""},userError:{},brugere:[]},a.onInputChange=function(e){var t=a.state.user;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name)},a.onSubmit=function(e){var t=Object(p.a)(a.state.brugere),n=a.state.user,r=a.validate(n);a.setState({userError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({brugere:t.concat(n),user:{name:n.name,email:n.email,username:n.username}}),console.log(a.state.user))},a.validate=function(e){var t={};return e.name||(t.name="Username required"),e.email||(t.email="Email required"),e.username||(t.username="Username required"),t},a}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"username",placeholder:"username",value:this.state.user.username,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.username),r.a.createElement("br",null),r.a.createElement("input",{name:"email",placeholder:"email",type:"email",value:this.state.user.email,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.email),r.a.createElement("br",null),r.a.createElement("input",{placeholder:"name",name:"name",type:"text",value:this.state.user.name,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.name),r.a.createElement("br",null),r.a.createElement("input",{type:"submit"})))}}]),t}(r.a.Component),g=a(18),b=a(16),f=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(i.a)(this,Object(u.a)(t).call(this,e))).onSubmit=function(e){var t=Object(p.a)(a.state.adresses),n=a.state.fiels,r=a.validate(n);a.setState({searchError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({fields:t.concat(n),fiels:{adress:n.adress,zipcode:n.zipcode}}),console.log(a.state.fiels))},a.validate=function(e){var t={};return e.adress||(t.adress="Adress required"),e.zipcode||(t.zipcode="Zipcode required"),t},a.onInputChange=function(e){var t=a.state.fiels;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name),console.log("Handle change"+a.state.fiels.adress),console.log("Handle change"+a.state.fiels.zipcode)},a.state={fiels:{adress:"",zipcode:""},searchError:{},adresses:[]},a}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"adress",placeholder:"Adresse",value:this.state.adress,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.adress),r.a.createElement("br",null),r.a.createElement("input",{name:"zipcode",placeholder:"post nr",value:this.state.zipcode,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.zipcode),r.a.createElement("br",null),r.a.createElement(g.b,{to:{pathname:"/searchResults",state:{name:"Hello"}}},r.a.createElement("input",{type:"submit"}))))}}]),t}(r.a.Component),v=a(44),O=a(3),j={LOADING:"LOAD",DONE:"DONE",FAILED:"FAILED"},y=function(){function e(){Object(c.a)(this,e),this.state=j.DONE,this.vuggestuer=[],this.fetchItem()}return Object(o.a)(e,[{key:"fetchItem",value:function(){var e=this;this.state=j.LOADING,fetch("rest/mongo/test").then((function(t){console.log(t),t.json().then((function(t){e.test=t,console.log(e.test),e.vuggestuer=t,e.state=j.DONE}))})).catch((function(t){console.log(t),e.state=j.FAILED}))}}]),e}();Object(O.g)(y,{vuggestuer:O.l});var k=new y,C=function(e){var t=e.list;return r.a.createElement("ul",null,t.map((function(e,t){return r.a.createElement(I,{key:t,item:e})})))},I=function(e){var t=e.item;return r.a.createElement("div",null,r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.Navn))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.Adresse))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,r.a.createElement("a",{href:t.Link},t.Link)))))},w=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(i.a)(this,Object(u.a)(t).call(this,e))).state={user:"",loading:""},console.log(e.location.state),a}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("ul",null,r.a.createElement("p",null,k.state),r.a.createElement(C,{list:k.vuggestuer}),r.a.createElement("br",null)))}}]),t}(r.a.Component);var L=function(){return r.a.createElement("div",null,r.a.createElement("h1",null,"This is the landingPage"))},D=a(23),S=a(22),A=function(e){function t(){return Object(c.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(D.a,{bg:"light",expand:"lg"},r.a.createElement(D.a.Brand,{href:"#/"},"Tilsyn.dk"),r.a.createElement(D.a.Toggle,{"aria-controls":"basic-navbar-nav"}),r.a.createElement(D.a.Collapse,{id:"basic-navbar-nav"},r.a.createElement(S.a,{className:"mr-auto"},r.a.createElement(S.a.Link,{href:"#home"},"Home"),r.a.createElement(S.a.Link,{href:"https://www.kk.dk/indhold/s%C3%B8g-og-skriv-dit-barn-op-til-vuggestue-og-dagpleje"},"Opskrivning til vuggestue"),r.a.createElement(S.a.Link,{href:"#login"},"Log Ind"),r.a.createElement(S.a.Link,{href:"#register"},"Registrer dig")))))}}]),t}(r.a.Component),z=function(e){function t(){return Object(c.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return r.a.createElement(v.a,null,r.a.createElement(A,null),r.a.createElement(g.a,null,r.a.createElement(b.c,null,r.a.createElement(b.a,{exact:!0,path:"/",component:L}),r.a.createElement(b.a,{path:"/register",component:E}),r.a.createElement(b.a,{path:"/login",component:d}),r.a.createElement(b.a,{path:"/search",component:f}),r.a.createElement(b.a,{path:"/searchResults",component:w}))))}}]),t}(r.a.Component),N=Object(h.a)(z);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(r.a.createElement(g.a,null,r.a.createElement(N,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[46,1,2]]]);
//# sourceMappingURL=main.a87bbe58.chunk.js.map