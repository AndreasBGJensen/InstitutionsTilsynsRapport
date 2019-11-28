import React from 'react'
import {institution} from '../../stores/InstitutionsStore'


//Adding itmes to the list.
const List = ({ list }) => (
    <ul>
        {list.map((item,key) => (
            <ListItem key={key} item={item} />
        ))}
    </ul>
);

//Designing the table
const ListItem = ({ item }) => (
   <div>
    <td>
    <tr>
        <div>{item.navn}</div>
    </tr>
   </td>


       <td>
           <tr>
               <div>
                   {
                   (typeof(item.indstsers)=="object"?
                       <div>
                           {
                               item.indstsers.map((subRowdata,j)=>
                                   <div>
                                       {subRowdata.tilsyn}
                                   </div>
                               )

                           }

                       </div>
                           :
                       null)
                   }

               </div>
           </tr>
       </td>


       <td>
           <tr>
               <div> venteliste {item.venteliste}</div>
           </tr>
       </td>



       <td>
           <tr>
               <div><a href={item.link}>{item.link}</a></div>
           </tr>
       </td>
   </div>


);






class InstitutionView extends React.Component {
    constructor(props) {
        super(props);
            this.state= {
                user: '',
                loading: ''
            }
    console.log(props.location.state)

    }






    render() {
        //debugger
        return(
        <div>

            <ul>
                <p>{institution.state}</p>
                <List list={institution.vuggestuer}/>
                <br/>
            </ul>
        </div>
        )
    }
}

export default InstitutionView