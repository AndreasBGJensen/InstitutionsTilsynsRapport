import React from 'react'
import Columns from "./Columns";
import Row from 'react'

function Table({props}) {

    let rows = props;

    return (
        <table>
            <tbody>
            <tr>
                <Columns/>
            </tr>

            </tbody>

        </table>


    )

}

export default Table