import React from 'react';
import styled from 'styled-components';

const Content = ({ children }) => {
    return (
        <Container>
            {children}
        </Container>
    );
}

const Container = styled.main`
    flex: 1;
    padding: 1rem;
    width: 60%;
`;

export default Content;