(this.webpackJsonpweb=this.webpackJsonpweb||[]).push([[0],{59:function(e,t,n){e.exports=n(95)},64:function(e,t,n){},65:function(e,t,n){},95:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),l=n(20),s=n.n(l),o=(n(64),n(6)),c=n(7),i=n(9),u=n(8),m=n(10),h=(n(65),n(66),n(24)),p=(n(27),function(e){function t(){return Object(o.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("a",{href:"rest/campusnet/login"},"login med campusnet")}}]),t}(r.a.Component)),E=n(23),v=function(e){function t(){var e,n;Object(o.a)(this,t);for(var a=arguments.length,r=new Array(a),l=0;l<a;l++)r[l]=arguments[l];return(n=Object(i.a)(this,(e=Object(u.a)(t)).call.apply(e,[this].concat(r)))).state={user:{name:"",email:"",username:""},userError:{},brugere:[]},n.onInputChange=function(e){var t=n.state.user;t[e.target.name]=e.target.value,n.setState({user:t}),console.log("Handle change"+e.target.name)},n.onSubmit=function(e){var t=Object(E.a)(n.state.brugere),a=n.state.user,r=n.validate(a);n.setState({userError:r}),e.preventDefault(),Object.keys(r).length||(n.setState({brugere:t.concat(a),user:{name:a.name,email:a.email,username:a.username}}),console.log(n.state.user))},n.validate=function(e){var t={};return e.name||(t.name="Username required"),e.email||(t.email="Email required"),e.username||(t.username="Username required"),t},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"username",placeholder:"username",value:this.state.user.username,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.username),r.a.createElement("br",null),r.a.createElement("input",{name:"email",placeholder:"email",type:"email",value:this.state.user.email,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.email),r.a.createElement("br",null),r.a.createElement("input",{placeholder:"name",name:"name",type:"text",value:this.state.user.name,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.userError.name),r.a.createElement("br",null),r.a.createElement("input",{type:"submit"})))}}]),t}(r.a.Component),d=n(15),g=n(18),f="",b=function(e){function t(e){var n;return Object(o.a)(this,t),(n=Object(i.a)(this,Object(u.a)(t).call(this,e))).onSubmit=function(e){var t=Object(E.a)(n.state.adresses),a=n.state.fiels,r=n.validate(a);n.setState({searchError:r}),e.preventDefault(),Object.keys(r).length||(n.setState({fields:t.concat(a),fiels:{vejnavn:a.vejnavn,postNr:a.postNr}}),console.log(n.state.fiels),fetch(f+"rest/institution",{method:"GET",body:JSON.stringify(n.fiels),headers:{"Content-Type":"application/json"}}).then((function(e){e.text().then((function(e){console.log("Got Token: "+e)}))})))},n.validate=function(e){var t={};return e.adress||(t.adress="Adress required"),e.zipcode||(t.zipcode="Zipcode required"),t},n.onInputChange=function(e){var t=n.state.fiels;t[e.target.name]=e.target.value,n.setState({user:t}),console.log("Handle change"+e.target.name),console.log("Handle change"+n.state.fiels.vejnavn),console.log("Handle change"+n.state.fiels.postNr)},n.state={fiels:{vejnavn:"",postNr:""},searchError:{},adresses:[]},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"vejnavn",placeholder:"Adresse",value:this.state.vejnavn,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.adress),r.a.createElement("br",null),r.a.createElement("input",{name:"postNr",placeholder:"post nr",value:this.state.postNr,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.zipcode),r.a.createElement("br",null),r.a.createElement(d.b,{to:{pathname:"/searchResults",state:{name:"Hello"}}},r.a.createElement("input",{type:"submit"}))))}}]),t}(r.a.Component),j=n(36),O=n(3),y={LOADING:"LOAD",DONE:"DONE",FAILED:"FAILED"},N=function(){function e(){Object(o.a)(this,e),this.state=y.DONE,this.vuggestuer=[],this.fetchItem()}return Object(c.a)(e,[{key:"fetchItem",value:function(){var e=this;this.state=y.LOADING,fetch("rest/institution/all").then((function(t){console.log(t),t.json().then((function(t){e.test=t,console.log(e.test),e.vuggestuer=t,e.state=y.DONE}))})).catch((function(t){console.log(t),e.state=y.FAILED}))}}]),e}();Object(O.g)(N,{vuggestuer:O.l});var C=new N,I=function(e){var t=e.list;return r.a.createElement("ul",null,t.map((function(e,t){return r.a.createElement(k,{key:t,item:e})})))},k=Object(h.a)((function(e){var t=e.item;return r.a.createElement("div",null,r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,t.navn))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null,"object"==typeof t.indstsers?r.a.createElement("div",null,t.tilsynsPath.map((function(e,n){return r.a.createElement("div",null,r.a.createElement("a",{href:t.link[n]},t.tilsynsPath[n]),")}")}))):null))),r.a.createElement("td",null,r.a.createElement("tr",null,r.a.createElement("div",null," venteliste ",t.venteliste))))})),D=function(e){function t(e){var n;return Object(o.a)(this,t),(n=Object(i.a)(this,Object(u.a)(t).call(this,e))).state={user:"",loading:""},console.log(e.location.state),n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("ul",null,r.a.createElement("p",null,C.state),r.a.createElement(I,{list:C.vuggestuer}),r.a.createElement("br",null)))}}]),t}(r.a.Component),S=n(55);var T=function(){return r.a.createElement("div",null,r.a.createElement("h1",null,"This is the landingPage"),r.a.createElement(d.b,{to:{pathname:"/searchResults"}},r.a.createElement(S.a,null," Se Tilsyn ")))},H=n(26),L=n(25),F=function(e){function t(){return Object(o.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(H.a,{bg:"light",expand:"lg"},r.a.createElement(H.a.Brand,{href:"#/"},"Tilsyn.dk"),r.a.createElement(H.a.Toggle,{"aria-controls":"basic-navbar-nav"}),r.a.createElement(H.a.Collapse,{id:"basic-navbar-nav"},r.a.createElement(L.a,{className:"mr-auto"},r.a.createElement(L.a.Link,{href:"#home"},"Home"),r.a.createElement(L.a.Link,{href:"https://www.kk.dk/indhold/s%C3%B8g-og-skriv-dit-barn-op-til-vuggestue-og-dagpleje"},"Opskrivning til vuggestue"),r.a.createElement(L.a.Link,{href:"#login"},"Log Ind"),r.a.createElement(L.a.Link,{href:"#admin"},"Admin")))))}}]),t}(r.a.Component),w=n(35),A=n.n(w),G={FETCHING:"Loading",FAILED_TO_FETCH:"failed",FETCHING_DONE:"Done Loading",FETCHING_IDLE:"Idle"},_=function(){function e(){Object(o.a)(this,e),this.state=G.FETCHING_IDLE,this.vejnavn="",this.postNr="",this.response=""}return Object(c.a)(e,[{key:"doUpdate",value:function(){var e=this;this.state=G.FETCHING,A.a.post("rest/institution/update",{vejnavn:this.vejnavn,postNr:this.postNr},{headers:{authorization:localStorage.getItem("jwt-token")}}).then((function(t){console.log(t),e.response=JSON.stringify(t),e.state=G.FETCHING_DONE,C.fetchItem()})).catch((function(t){e.state=G.FAILED_TO_FETCH,console.log(t)}))}}]),e}();Object(O.g)(_,{state:O.l,vejnavn:O.l,postNr:O.l,response:O.l});var B=new _,q={FETCHING:"Loading",FAILED_TO_FETCH:"failed",FETCHING_DONE:"Done Loading"},x=function(e){function t(e){var n;return Object(o.a)(this,t),(n=Object(i.a)(this,Object(u.a)(t).call(this,e))).onSubmit=function(e){n.buttonClickEvent(),B.response="",console.log("ON SUBMIT: "+n.state.fiels);var t=Object(E.a)(n.state.adresses),a=n.state.fiels,r=n.validate(a);n.setState({searchError:r}),e.preventDefault(),Object.keys(r).length||(n.setState({fields:t.concat(a),fiels:{vejnavn:a.vejnavn,postNr:a.postNr}}),B.vejnavn=n.state.fiels.vejnavn,B.postNr=n.state.fiels.postNr,B.doUpdate(),console.log(n.state.fiels))},n.validate=function(e){var t={};return e.vejnavn||(t.adress="vejnavn required"),e.postNr||(t.zipcode="post nr required"),t},n.onInputChange=function(e){var t=n.state.fiels;t[e.target.name]=e.target.value,n.setState({user:t}),console.log("Handle change"+e.target.name),console.log("Handle change"+n.state.fiels.vejnavn),console.log("Handle change"+n.state.fiels.postNr)},n.state={fiels:{vejnavn:"",postNr:""},searchError:{},adresses:[],process:q.FETCHING_DONE,response:"",neterror:""},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"buttonClickEvent",value:function(){document.getElementById("submitButton").style.display=!1}},{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("form",{onSubmit:this.onSubmit},r.a.createElement("input",{name:"vejnavn",placeholder:"Adresse",value:this.state.vejnavn,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.vejnavn),r.a.createElement("br",null),r.a.createElement("input",{name:"postNr",placeholder:"post nr",value:this.state.postNr,onChange:this.onInputChange}),r.a.createElement("span",{style:{color:"red"}},this.state.searchError.postNr),r.a.createElement("br",null),r.a.createElement("input",{id:"submitButton",type:"submit"})),r.a.createElement("p",null,B.state),r.a.createElement("br",null),r.a.createElement("h1",null,B.response))}}]),t}(r.a.Component),z=Object(h.a)(x),U=function(e){function t(){return Object(o.a)(this,t),Object(i.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement(j.a,null,r.a.createElement(F,null),r.a.createElement(d.a,null,r.a.createElement(g.c,null,r.a.createElement(g.a,{exact:!0,path:"/",component:T}),r.a.createElement(g.a,{path:"/register",component:v}),r.a.createElement(g.a,{path:"/login",component:p}),r.a.createElement(g.a,{path:"/search",component:b}),r.a.createElement(g.a,{path:"/searchResults",component:D}),r.a.createElement(g.a,{path:"/admin",component:z}))))}}]),t}(r.a.Component),J=Object(h.a)(U);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));s.a.render(r.a.createElement(d.a,null,r.a.createElement(J,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[59,1,2]]]);
//# sourceMappingURL=main.00a8149a.chunk.js.map