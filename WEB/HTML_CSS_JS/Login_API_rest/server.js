const express = require('express');
const app = express();
const path = require('path');

// Define o diretório público para servir arquivos estáticos
app.use(express.static(path.join(__dirname, 'public')));

// Rota para enviar o arquivo HTML
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Inicia o servidor
const port = 3100;
app.listen(port, () => {
  console.log(`Servidor está executando em http://localhost:${port}`);
});
