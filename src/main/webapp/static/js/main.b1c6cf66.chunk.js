(this.webpackJsonpweb=this.webpackJsonpweb||[]).push([[0],{46:function(e,t,a){e.exports=a(67)},51:function(e,t,a){},52:function(e,t,a){},67:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),l=a(19),s=a.n(l),o=(a(51),a(6)),c=a(7),i=a(11),u=a(10),m=a(12),h=(a(52),a(53),a(45)),d=a(3),g={LOADING:"LOAD",DONE:"DONE",FAILED:"FAILED"},p=function(){function e(){Object(o.a)(this,e),this.state=g.DONE,this.vuggestuer=[],this.fetchItem()}return Object(c.a)(e,[{key:"fetchItem",value:function(){var e=this;this.state=g.LOADING,fetch("rest/mongo/test").then((function(t){console.log(t),t.json().then((function(t){e.test=t,console.log(e.test),e.vuggestuer=t,e.state=g.DONE}))})).catch((function(t){console.log(t),e.state=g.FAILED}))}}]),e}();Object(d.g)(p,{vuggestuer:d.l});var E=new p,f={LOGGING_IN:"Loading",LOGGEDOUT:"Logout",LOGGED_IN:"LoggedIn"},b=function(){function e(){Object(o.a)(this,e),this.state=f.LOGGEDOUT,this.token=null,this.logindata={username:"",password:""},this.token=localStorage.getItem("girafToken")}return Object(c.a)(e,[{key:"doLogin",value:function(){var e=this;this.state=f.LOGGING_IN,fetch("rest/login",{method:"POST",body:JSON.stringify(this.logindata),headers:{"Content-Type":"application/json"}}).then((function(t){t.text().then((function(t){console.log("Got Token: "+t),e.token=t,localStorage.setItem("girafToken",t),e.state=f.LOGGED_IN}))})).catch((function(){return e.state=f.LOGGEDOUT}))}}]),e}();Object(d.g)(b,{state:d.l,token:d.l,logindata:d.l});new b,a(29);var v=new b,O=function(e){function t(e){var a;return Object(o.a)(this,t),(a=Object(i.a)(this,Object(u.a)(t).call(this,e))).handleUsernameChange=function(e){a.setState({username:e.target.value}),console.log("Handle change"+a.state.username)},a.handlePasswordChange=function(e){a.setState({password:e.target.value}),console.log("Handle change"+a.state.password)},a.onSubmit=function(e){var t=a.state.username,n=a.state.password;a.setState({username:t}),a.setState({password:n}),v.logindata.username=a.state.username,v.logindata.password=a.state.password,v.doLogin(),e.preventDefault()},a.state={username:"",password:""},a}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("h1",null,"Login"),r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{placeholder:"Username",value:this.state.username,onChange:this.handleUsernameChange}),r.a.createElement("input",{placeholder:"password",value:this.state.password,onChange:this.handlePasswordChange}),r.a.createElement("input",{type:"submit"})))}}]),t}(r.a.Component),j=a(26),k=function(e){function t(){var e,a;Object(o.a)(this,t);for(var n=arguments.length,r=new Array(n),l=0;l<n;l++)r[l]=arguments[l];return(a=Object(i.a)(this,(e=Object(u.a)(t)).call.apply(e,[this].concat(r)))).state={user:{name:"",email:"",username:""},userError:{},brugere:[]},a.onInputChange=function(e){var t=a.state.user;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name)},a.onSubmit=function(e){var t=Object(j.a)(a.state.brugere),n=a.state.user,r=a.validate(n);a.setState({userError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({brugere:t.concat(n),user:{name:n.name,email:n.email,username:n.username}}),console.log(a.state.user))},a.validate=function(e){var t={};return e.name||(t.name="Username required"),e.email||(t.email="Email required"),e.username||(t.username="Username required"),t},a}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"username",placeholder:"username",value:this.state.user.username,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.username),r.a.createElement("br",null),r.a.createElement("input",{name:"email",placeholder:"email",type:"email",value:this.state.user.email,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.email),r.a.createElement("br",null),r.a.createElement("input",{placeholder:"name",name:"name",type:"text",value:this.state.user.name,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.name),r.a.createElement("br",null),r.a.createElement("input",{type:"submit"})))}}]),t}(r.a.Component),y=a(18),w=a(16),C=function(e){function t(e){var a;return Object(o.a)(this,t),(a=Object(i.a)(this,Object(u.a)(t).call(this,e))).onSubmit=function(e){var t=Object(j.a)(a.state.adresses),n=a.state.fiels,r=a.validate(n);a.setState({searchError:r}),e.preventDefault(),Object.keys(r).length||(a.setState({fields:t.concat(n),fiels:{adress:n.adress,zipcode:n.zipcode}}),console.log(a.state.fiels))},a.validate=function(e){var t={};return e.adress||(t.adress="Adress required"),e.zipcode||(t.zipcode="Zipcode required"),t},a.onInputChange=function(e){var t=a.state.fiels;t[e.target.name]=e.target.value,a.setState({user:t}),console.log("Handle change"+e.target.name),console.log("Handle change"+a.state.fiels.adress),console.log("Handle change"+a.state.fiels.zipcode)},a.state={fiels:{adress:"",zipcode:""},searchError:{},adresses:[]},a}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"adress",placeholder:"Adresse",value:this.state.adress,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.adress),r.a.createElement("br",null),r.a.createElement("input",{name:"zipcode",placeholder:"post nr",value:this.state.zipcode,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.zipcode),r.a.createElement("br",null),r.a.createElement(y.b,{to:{pathname:"/searchResults",state:{name:"Hello"}}},r.a.createElement("input",{type:"submit"}))))}}]),t}(r.a.Component),L=a(44);var I=function(e){var t=e.list;return r.a.createElement("ul",null,t.map((function(e,t){return r.a.createElement(S,{key:t,item:e})})))},S=function(e){var t=e.item;return r.a.createElement("div",null,r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.Navn))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.Adresse))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,r.a.createElement("a",{href:t.Link},t.Link)))))},G=function(e){function t(e){var a;return Object(o.a)(this,t),(a=Object(i.a)(this,Object(u.a)(t).call(this,e))).state={user:"",loading:""},console.log(e.location.state),a}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("ul",null,r.a.createElement("p",null,E.state),r.a.createElement(I,{list:E.vuggestuer}),r.a.createElement("br",null)))}}]),t}(r.a.Component);var D=function(){return r.a.createElement("div",null,r.a.createElement("h1",null,"This is the landingPage"))},N=a(23),T=a(22),A=function(e){function t(){return Object(o.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(N.a,{bg:"light",expand:"lg"},r.a.createElement(N.a.Brand,{href:"#/"},"Tilsyn.dk"),r.a.createElement(N.a.Toggle,{"aria-controls":"basic-navbar-nav"}),r.a.createElement(N.a.Collapse,{id:"basic-navbar-nav"},r.a.createElement(T.a,{className:"mr-auto"},r.a.createElement(T.a.Link,{href:"#home"},"Home"),r.a.createElement(T.a.Link,{href:"https://www.kk.dk/indhold/s%C3%B8g-og-skriv-dit-barn-op-til-vuggestue-og-dagpleje"},"Opskrivning til vuggestue"),r.a.createElement(T.a.Link,{href:"#login"},"Log Ind"),r.a.createElement(T.a.Link,{href:"#register"},"Registrer dig")))))}}]),t}(r.a.Component),z=function(e){function t(){return Object(o.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement(L.a,null,r.a.createElement(A,null),r.a.createElement(y.a,null,r.a.createElement(w.c,null,r.a.createElement(w.a,{exact:!0,path:"/",component:D}),r.a.createElement(w.a,{path:"/register",component:k}),r.a.createElement(w.a,{path:"/login",component:O}),r.a.createElement(w.a,{path:"/search",component:C}),r.a.createElement(w.a,{path:"/searchResults",component:G}))))}}]),t}(r.a.Component),H=Object(h.a)(z);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(r.a.createElement(y.a,null,r.a.createElement(H,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[46,1,2]]]);
//# sourceMappingURL=main.b1c6cf66.chunk.js.map