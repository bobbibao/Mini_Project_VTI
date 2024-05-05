import React from 'react';
import styled from 'styled-components';

const Modal = ({ isModalOpen, handleSubmit, children }) => {
    return (
        <ModalContainer isModalOpen={isModalOpen}>
            <ModalContent>
                {children}
                <button onClick={handleSubmit}>Submit</button>
            </ModalContent>
        </ModalContainer>
    );
}

export default Modal;

const ModalContainer = styled.div`
    display: ${({ isModalOpen }) => isModalOpen ? 'flex' : 'none'};
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    justify-content: center;
    align-items: center;
    z-index: 999;
`;

const ModalContent = styled.div`
    background: white;
    padding: 20px;
    border-radius: 10px;
    width: 80%;
    max-width: 500px;
    position: relative;
    button {
        padding: 5px 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }

    div {
        margin-bottom: 20px;
        width: 100%;
        display: flex;
        justify-content: space-between;

        label {
            width: 30%;
            font-size: 18px;
        }

        input {
            width: 60%;
            padding: 5px;
            font-size: 18px;
        }
    }
`;

