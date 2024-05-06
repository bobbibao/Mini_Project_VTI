import React, {useState, useEffect} from 'react';
import GroupServices from '../api/groupServices';
import Table from '../components/Table';
import styled from 'styled-components';
import Modal from '../components/Modal';

function Group(){
    const [groups, setGroups] = useState([]);
    const [groupName, setGroupName] = useState("");
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [checked, setChecked] = useState([]);

    useEffect(() => {
        GroupServices.getGroups().then(data => {
            setGroups(data);
        });
    }
    , []);

    const handleAdd = () => {
        setIsModalOpen(true);
    }
    const closeModal = () => {
        setIsModalOpen(false);
    };
    const handleEdit = (id) => {
        GroupServices.getGroup(id).then(data => {
            setGroupName(data.groupName);
            setIsModalOpen(true);
        });
    }

    const handleDelete = () => {
        GroupServices.deleteManyGroups({ groupIds: checked }).then(data => {
            setGroups(groups.filter(group => !checked.includes(group.groupId)));
            setChecked([]);
        });
    }

    const handleDeleteOne = (id) => {
        GroupServices.deleteGroup(id).then(data => {
            setGroups(groups.filter(group => group.groupId !== id));
        });
    }

    const handleSubmit = () => {
        if (groupName) {
            GroupServices.addGroup({ groupName }).then(data => {
                setGroups([...groups, data]);
            });
            setGroupName("");
            setIsModalOpen(false);
        }
    }

    return (
        <div>
        <h1>Group</h1>
            <ButtonContainer>
                <button onClick={handleAdd}>Add</button>
                <button onClick={handleDelete}>Delete</button>
            </ButtonContainer>

            <Table>
                <Table.Header>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actions</th>
                </Table.Header>
                <Table.Body>
                    {groups.map(group => (
                        <tr key={group.groupId}>
                            <td>{group.groupId}</td>
                            <td>{group.groupName}</td>
                            <td>
                                <button onClick={() => handleEdit(group.groupId)}>Edit</button>
                                <button onClick={() => handleDeleteOne(group.groupId)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </Table.Body>
            </Table>
            <Modal isModalOpen={isModalOpen} handleSubmit={handleSubmit}>
                <ModalHeader>
                    <h2>Add User</h2>
                    <button onClick={closeModal}>Close</button>
                </ModalHeader>
                    <div>
                        <label>Name</label>
                        <input type="text" value={groupName} onChange={e => setGroupName(e.target.value)} />
                    </div>
                    {/* <button onClick={handleSubmit}>Submit</button> */}
            </Modal>
        </div>
    );
}

export default Group;

const ButtonContainer = styled.div`
    margin-bottom: 20px;
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

const ModalHeader = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
`;
