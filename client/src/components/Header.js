import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
const Header = () => {
    return (
        
        <Container>
            <h1>API ROUTE VTi</h1>
            <Nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/users">User</Link>
                    </li>
                    <li>
                        <Link to="/groups">Group</Link>
                    </li>
                </ul>
            </Nav>
        </Container>

    );
}

const Container = styled.header`
    background-color: #333;
    color: white;
    padding: 1rem;
    text-align: center;
    width: 100%;
`;

const Nav = styled.nav`
    ul {
        display: flex;
        justify-content: center;
        list-style: none;
        padding: 0;
    }
    li {
        margin: 0 1rem;
    }
    a {
        color: white;
        text-decoration: none;
    }
`;

export default Header;