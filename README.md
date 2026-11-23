# PocketAgenda

Case Técnico da disciplina Desenvolvimento para Dispositivos Móveis: um app Android em Java para gerenciar compromissos.

## Como executar

1. Abra a pasta `PocketAgenda` no Android Studio (File > Open).
2. Espere o Gradle sincronizar e rode o app no emulador ou no celular (minSdk 24).

## O que foi implementado

| Etapa | Implementação |
|---|---|
| 1. Layout e Interface | `activity_main.xml` tem o título (`TextView`), o botão `btnAbrirCadastro` (`Button`) e a lista de compromissos (`TextView`). `activity_cadastro.xml` tem um título (`TextView`), os campos `edtTitulo` e `edtData` (`EditText`) e o botão `btnSalvar` (`Button`). |
| 2. Navegação via Intent | Em `MainActivity`, o clique em "Adicionar Novo Compromisso" cria `new Intent(MainActivity.this, CadastroActivity.class)` e chama `startActivity(intent)`. |
| 3. Captura e Validação | Em `CadastroActivity`, o app lê o texto com `getText().toString().trim()` e valida com `isEmpty()`. Se um campo estiver vazio, mostra um `Toast` e um erro no próprio campo e para com `return`. Se tudo estiver preenchido, salva, mostra o `Toast` de sucesso e fecha a tela com `finish()`. |
| 4. Execução e Estabilidade | O projeto compila sem erros (`assembleDebug`). Os compromissos salvos aparecem na tela principal ao voltar (`onResume`). |

## Estrutura

```
app/src/main/java/com/exemplo/pocketagenda/
├── MainActivity.java            tela principal e navegação
├── CadastroActivity.java        captura e validação dos campos
├── Compromisso.java             modelo (título e data)
└── CompromissoRepository.java   lista em memória da sessão
```
