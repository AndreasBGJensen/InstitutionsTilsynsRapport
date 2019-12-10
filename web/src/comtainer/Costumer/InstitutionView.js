import React from 'react'
import {institution} from '../../stores/InstitutionsStore'
import {observer} from "mobx-react";


//Adding itmes to the list.
const List = observer(({ list }) => (
    <ul>
        {list.map((item,key) => (
            <ListItem key={key} item={item} />
        ))}
    </ul>
));

//Designing the table
const ListItem = observer(({ item }) => (
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
                               item.tilsynsPath.map((indsats,j)=>(
                                   <div>

                                           <a href={item.link[j+1]}>{item.tilsynsPath[j]}</a>


                                       )}


                                   </div>
                               ))

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
   </div>


));







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

export default observer(InstitutionView)