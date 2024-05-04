import React, { useEffect, useState } from 'react';
import UserServices from '../api/userServices';
import Table from '../components/Table';
function User() {
    const [users, setUsers] = useState([]);
    useEffect(() => {
        UserServices.getAllUsers().then(data => {
            setUsers(data);
        });
    }, []);
    return (
        <div>
            <h1>Users</h1>
            <Table>
                <Table.Header>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Role</th>
                </Table.Header>
                <Table.Body>
                    {
                        users.map(user => (
                            <tr key={user.id}>
                                <td>{user.id}</td>
                                <td>{user.username}</td>
                                <td>{user.fullname}</td>
                                <td>{user.email}</td>
                                <td>{user.role}</td>
                            </tr>
                        ))
                    }
                </Table.Body>
            </Table>
        </div>
    );
}


export default User;