import React from 'react';
import styled from 'styled-components';
import Header from './Header';
import Content from './Content';
const Layout = ({ children }) => {
    return (
        
        <Container>
            <Header/>
            <Content>
                {children}
            </Content>
        </Container>

    );
};

const Container = styled.div`
    display: flex;
    flex-direction: column;
    height: 100vh;
    justify-content: center;
    align-items: center;
    padding: 2rem;
`;

export default Layout;