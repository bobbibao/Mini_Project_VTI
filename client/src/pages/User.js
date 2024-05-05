import React, { useEffect, useState } from 'react';
import UserServices from '../api/userServices';
import Table from '../components/Table';
import styled from 'styled-components';
import Modal from '../components/Modal';

function User() {
    const [users, setUsers] = useState([]);
    const [username, setUsername] = useState("");
    const [fullname, setFullname] = useState("");
    const [email, setEmail] = useState("");
    const [isModalOpen, setIsModalOpen] = useState(false);

    useEffect(() => {
        UserServices.getAllUsers().then(data => {
            setUsers(data);
        });
    }, []);

    const handleAdd = () => {
        setIsModalOpen(true);
    };
    
    const closeModal = () => {
        setIsModalOpen(false);
    };
    const handleDelete = () => {
        console.log('Delete');
    };

    const handleSubmit = () => {
        UserServices.addUser({ username, password: fullname, email }).then(data => {
            setUsers([...users, data]);
        });
        setUsername("");
        setFullname("");
        setEmail("");
        setIsModalOpen(false);
    }
    return (
        <div>
            <h1>Users</h1>
            <ButtonContainer>
                <button onClick={handleAdd}>Add</button>
                <button onClick={handleDelete}>Delete</button>
            </ButtonContainer>

            <Table>
                <Table.Header>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th className="checkbox"></th>
                </Table.Header>
                <Table.Body>
                    {
                        users.map(user => (
                            <tr key={user.userId}>
                                <td>{user.userId}</td>
                                <td>{user.username}</td>
                                <td>{user.fullname}</td>
                                <td>{user.email}</td>
                                <td>{user.role}</td>
                                <td className="checkbox">
                                    <input type="checkbox" />
                                </td>
                            </tr>
                        ))
                    }
                </Table.Body>
            </Table>
            <Modal isModalOpen={isModalOpen} handleSubmit={handleSubmit}>
                <ModalHeader>
                    <h2>Add User</h2>
                    <button onClick={closeModal}>Close</button>
                </ModalHeader>
                <div>
                    <label>Username</label>
                    <input value={username} type="text" onChange={(e) => setUsername(e.target.value)} />
                </div>
                <div>
                    <label>Fullname</label>
                    <input value={fullname} type="text" onChange={(e) => setFullname(e.target.value)} />
                </div>
                <div>
                    <label>Email</label>
                    <input value={email} type="text" onChange={(e) => setEmail(e.target.value)} />
                </div>
            </Modal>

        </div>
    );
}

const ModalHeader = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
`;
const ButtonContainer = styled.div`
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
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
`;

export default User;