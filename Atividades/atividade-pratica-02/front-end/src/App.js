import styled from "styled-components";
import Grade from "./components/grade";
import Formulario from "./components/formulario.js";
import { useEffect, useState } from "react";
import GlobalStyle from "./styles/cssGlobal";
import axios from "axios";

const Container = styled.div`
  gap: 10px;
  max-width: 800px;
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  align-items: center;
  width: 100%;
`;

function App() {
  const [usuarios, setUsuarios] = useState([]);
  const [aoEditar, setAoEditar] = useState(null);

  const obterUsuarios = async () => {
    try {
      const requisicao = await axios.get("http://localhost:8081");
      setUsuarios(requisicao.data.sort((a, b) => (a.nome > b.nome ? 1 : -1)));
    } catch (error) {
    }
  };

  useEffect(() => {  obterUsuarios(); }, [setUsuarios]);

  return (
    <>
      <Container>
        <Formulario onEdit={aoEditar} setOnEdit={setAoEditar} getUsers={obterUsuarios} />
        <Grade setOnEdit={setAoEditar} users={usuarios} setUsers={setUsuarios} />
      </Container>
      <GlobalStyle />
    </>
  );
}

export default App;