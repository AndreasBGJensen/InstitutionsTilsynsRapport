import React from 'react'

function List_institutionView ({list}){

    const List = ({ list }) => (
        <ul>
            {list.map((item,key) => (
                <ListItem key={key} item={item} />
            ))}
        </ul>
    )

//Designing the table
    const ListItem = ({ item }) => (
        <div>
            <td>
                <tr>
                    <div>{item.Navn}</div>
                </tr>
            </td>
            <td>
                <tr>
                    <div>{item.Adresse}</div>
                </tr>
            </td>
            <td>
                <tr>
                    <div><a href={item.Link}>{item.Link}</a></div>

                </tr>
            </td>
        </div>


    );
render()
    {
        return (

            <div>
            List
            </div>
        )
    }






}

export default List_institutionView