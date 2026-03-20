import { useState, FormEvent } from "react";
import Api from "../../servico/servicoApi";

interface Props {
  tarefaId: number;
  isOpen: boolean;
  onFechar: () => void;
  onSucesso?: () => void;
}

export default function ModalCadastroItem({ tarefaId, isOpen, onFechar, onSucesso }: Props) {
  const [nome, setNome] = useState("");
  const [descricao, setDescricao] = useState("");
  const [erro, setErro] = useState<string | null>(null);

  if (!isOpen) return null;

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setErro(null);

    Api.post("/itens", { nome, descricao, tarefaId })
      .then(() => {
        setNome("");
        setDescricao("");
        onFechar(); 
        if (onSucesso) onSucesso(); 
      })
      .catch((err) => {
        alert("Erro ao criar item! Verifique o console para mais detalhes.");
      });
  };

  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
      <div className="bg-white p-6 rounded shadow-lg w-full max-w-md">
        <h2 className="text-lg font-bold mb-4">Cadastrar Item</h2>

        {erro && <p className="text-red-500 mb-2">{erro}</p>}

        <form onSubmit={handleSubmit} className="flex flex-col gap-3">
          <input
            type="text"
            placeholder="Nome do item"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            className="border p-2 rounded"
            required
          />
          <input
            type="text"
            placeholder="Descrição do item"
            value={descricao}
            onChange={(e) => setDescricao(e.target.value)}
            className="border p-2 rounded"
            required
          />

          <div className="flex justify-end gap-2 mt-2">
            <button
              type="button"
              onClick={onFechar}
              className="px-4 py-2 rounded border hover:bg-gray-100"
            >
              Cancelar
            </button>
            <button
              type="submit"
              className="px-4 py-2 rounded bg-blue-500 text-white hover:bg-blue-600"
            >
              Cadastrar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
