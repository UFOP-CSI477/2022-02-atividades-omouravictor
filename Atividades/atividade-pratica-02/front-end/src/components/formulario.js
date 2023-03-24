import styled from "styled-components";
import axios from "axios";
import { toast } from "react-toastify";
import React, { useEffect, useRef } from "react";

const AreaDeEntrada = styled.div`
  color: white;
  flex-direction: column;
  display: flex;
`;

const Titulo = styled.label``;

const Botao = styled.button`
  height: 42px;
  border: none;
  cursor: pointer;
  background-color: white;
  padding: 10px;
  color: black;
`;

const ContainerFormulario = styled.form`
  display: flex;
  gap: 10px;
  flex-wrap: wrap;
  align-items: flex-end;
  padding: 20px;
  background-color: black;
  box-shadow: 0px 0px 5px #ccc;
`;

const Formulario = ({ onEdit, setOnEdit }) => {
  const ref = useRef();

  useEffect(() => {
    if (onEdit) {
      const atual = ref.current;

      atual.tipoSanguineo = onEdit.tipoSanguineo;
      atual.estado = onEdit.estado;
      atual.pessoa = onEdit.pessoa;
      atual.cidade = onEdit.cidade;
      atual.localColeta = onEdit.localColeta;
    }
  }, [onEdit]);

  const Entrada = styled.input`
  height: 40px;
  border: 1px solid #bbb;
  width: 120px;
  padding: 0 10px;
`;
  
  const manipularEnviar = async (e) => {
    e.preventDefault();

    const cad = ref.current;

    if (onEdit) {
      await axios
        .put("http://localhost:8081/" + onEdit.id, {
            estado: cad.estado.value,
            pessoa: cad.pessoa.value,
            cidade: cad.cidade.value,
            local: cad.local.value,
            tipoSanguineo: cad.tipoSanguineo.value
        })
        .then(({ data }) => toast.success(data))
        .catch(({ data }) => toast.error(data));
    } else {
      await axios
        .post("http://localhost:8081", {
            estado: cad.estado.value,
            pessoa: cad.pessoa.value,
            cidade: cad.cidade.value,
            local: cad.local.value,
            tipoSanguineo: cad.tipoSanguineo.value
        })
        .then(({ data }) => toast.success(data))
        .catch(({ data }) => toast.error(data));
    }

    cad.tipoSanguineo.value = "";
    cad.pessoa.value = "";
    cad.estado.value = "";
    cad.local.value = "";
    cad.cidade.value = "";

    setOnEdit(null);
  };

  return (
    <ContainerFormulario ref={ref} onSubmit={manipularEnviar}>
      <AreaDeEntrada>
        <Titulo>Nome Completo</Titulo>
        <Entrada pessoa="pessoa"/>
      </AreaDeEntrada>
      <AreaDeEntrada>
        <Titulo>Local de Coleta</Titulo>
        <Entrada local="local"/>
      </AreaDeEntrada>
      <AreaDeEntrada>
        <Titulo>Tipo Sanguíneo</Titulo>
        <Entrada tipoSanguineo="tipoSanguineo"/>
      </AreaDeEntrada>
        <AreaDeEntrada>
            <Titulo>Estado</Titulo>
            <Entrada estado="estado" />
        </AreaDeEntrada>
        <AreaDeEntrada>
            <Titulo>Cidade</Titulo>
            <Entrada cidade="cidade"/>
        </AreaDeEntrada>
      <Botao type="submit">Salvar</Botao>
    </ContainerFormulario>
  );
};

export default Formulario;