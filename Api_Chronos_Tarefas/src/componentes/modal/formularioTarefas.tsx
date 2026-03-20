import { useState, FormEvent } from "react";
import Api from "../../servico/servicoApi"; // seu serviço Axios

interface Props {
  isOpen: boolean;
  onFechar: () => void;
  onSucesso?: () => void;
}

export default function ModalCadastroTarefa({ isOpen, onFechar, onSucesso }: Props) {
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const [responsavel, setResponsavel] = useState("");
  const [prazo, setPrazo] = useState("");
  const [status, setStatus] = useState("");
  const [erro, setErro] = useState<string | null>(null);

  if (!isOpen) return null;

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    setErro(null);

    const dadosTarefa = { titulo, descricao, responsavel, prazo, status };

    Api.post("/tarefas", dadosTarefa)
      .then(() => {
        setTitulo("");
        setDescricao("");
        setResponsavel("");
        setPrazo("");
        setStatus("");

        onFechar();
        if (onSucesso) onSucesso();
      })
      .catch((err) => {
        console.error("Erro ao criar tarefa:", err.response?.data || err.message);
        setErro("Erro ao criar tarefa!");
        alert("Erro ao criar tarefa! Verifique os dados e tente novamente.");
      });
  };

  return (
    <div className="fixed inset-0 flex items-center justify-center z-50">
      <div
        className="absolute inset-0 bg-black opacity-50"
        onClick={onFechar} 
      ></div>

      <div className="relative bg-white p-6 rounded shadow-lg w-full max-w-lg z-10">
        <h2 className="text-lg font-bold mb-4">Cadastrar Tarefa</h2>

        {erro && <p className="text-red-500 mb-2">{erro}</p>}

        <form onSubmit={handleSubmit} className="flex flex-col gap-3">
          <input
            type="text"
            placeholder="Título"
            value={titulo}
            onChange={(e) => setTitulo(e.target.value)}
            className="border p-2 rounded"
            required
          />
          <input
            type="text"
            placeholder="Descrição"
            value={descricao}
            onChange={(e) => setDescricao(e.target.value)}
            className="border p-2 rounded"
            required
          />
          <input
            type="text"
            placeholder="Responsável"
            value={responsavel}
            onChange={(e) => setResponsavel(e.target.value)}
            className="border p-2 rounded"
            required
          />
          <input
            type="date"
            placeholder="Prazo"
            value={prazo}
            onChange={(e) => setPrazo(e.target.value)}
            className="border p-2 rounded"
            required
          />
          <select
            value={status}
            onChange={(e) => setStatus(e.target.value)}
            className="border p-2 rounded"
            required
          >
            <option value="">Selecione o status</option>
            <option value="Pendente">Pendente</option>
            <option value="Em andamento">Em andamento</option>
            <option value="Concluída">Concluída</option>
          </select>

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
