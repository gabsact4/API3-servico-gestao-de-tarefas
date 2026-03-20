import { useState } from "react";
import ModalCadastroItem from "../componentes/modal/formularioItem";
import ModalCadastroTarefa from "../componentes/modal/formularioTarefas";

export default function TelaTarefas() {
  const [modalItemAberto, setModalItemAberto] = useState(false);
  const [modalTarefaAberto, setModalTarefaAberto] = useState(false);

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4">Gerenciar Tarefas</h1>

      <button
        onClick={() => setModalItemAberto(true)}
        className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 mb-4 mr-2"
      >
        Novo Item
      </button>

      <button
        onClick={() => setModalTarefaAberto(true)}
        className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600 mb-4"
      >
        Nova Tarefa
      </button>

      <ModalCadastroItem
        tarefaId={1} 
        isOpen={modalItemAberto}
        onFechar={() => setModalItemAberto(false)}
        onSucesso={() => console.log("Item criado!")}
      />

      <ModalCadastroTarefa
        isOpen={modalTarefaAberto}
        onFechar={() => setModalTarefaAberto(false)}
        onSucesso={() => console.log("Tarefa criada!")}
      />
    </div>
  );
}
