import React from 'react';
import styled from 'styled-components';

const Table = ({ children }) => {
    return (
        <StyledTable>
            {children}
        </StyledTable>
    );
}
Table.Header = ({ children }) => {
    return (
        <thead>
            <tr>
                {children}
            </tr>
        </thead>
    );
}

Table.Body = ({ children }) => {
    return (
        <tbody>
            {children}
        </tbody>
    );
}
const StyledTable = styled.table`
    border-collapse: collapse;
    width: 100%;
    & th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    & th {
        background-color: #f2f2f2;
    }
    & tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    & tr:hover {
        background-color: #f1f1f1;
    }
`;

export default Table; 