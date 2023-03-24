import { FaTrash, FaEdit } from "react-icons/fa";
import styled from "styled-components";
import axios from "axios";
import { toast } from "react-toastify";
import React from "react";

export const Corpo = styled.tbody``;

export const Coluna = styled.th`
  border-bottom: inset;
  text-align: start;
  padding-bottom: 5px;
  color: white;
`;

export const Linha = styled.tr``;

const Tabela = styled.table`
  padding: 20px;
  max-width: 1120px;
  background-color: black;
  word-break: break-all;
  width: 100%;
  margin: 20px auto;
`;

export const Coluna2 = styled.td`
  width: ${(props) => (props.width ? props.width : "auto")};
  padding-top: 15px;
  text-align: ${(props) => (props.alignCenter ? "center" : "start")};
`;

export const Tread = styled.thead``;

const Grade = ({ users, setUsers, setOnEdit }) => {
  const manipularExcluir = async (id) => {
    await axios
      .delete("http://localhost:8081/" + id)
      .then(({ data }) => {
        const novoArray = users.filter((user) => user.id !== id);
        setUsers(novoArray);
        toast.success(data);
      })
      .catch(({ data }) => toast.error(data));

    setOnEdit(null);
  };

    const manipularEditar = (item) => {
        setOnEdit(item);
    };

  return (
    <Tabela>
      <Tread>
        <Linha>
          <Coluna>Nome Completo</Coluna>
          <Coluna>Local de Coleta</Coluna>
          <Coluna>Tipo Sanguíneo</Coluna>
          <Coluna>Estado</Coluna>
          <Coluna>Cidade</Coluna>
        </Linha>
      </Tread>
      <Corpo>
        {users.map((item, i) => (
          <Linha key={i}>
            <Coluna2 width="20%">{item.pessoa}</Coluna2>
            <Coluna2 width="20%">{item.local}</Coluna2>
            <Coluna2 width="20%">{item.tipoSanguineo}</Coluna2>
            <Coluna2 width="20%">{item.estado}</Coluna2>
            <Coluna2 width="20%">{item.cidade}</Coluna2>

            <Coluna2 alignCenter width="5%">
              <FaEdit onClick={() => manipularEditar(item)} />
            </Coluna2>

            <Coluna2 alignCenter width="5%">
              <FaTrash onClick={() => manipularExcluir(item.id)} />
            </Coluna2>
          </Linha>
        ))}
      </Corpo>
    </Tabela>
  );
};

export default Grade;