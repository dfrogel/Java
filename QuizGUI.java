import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class QuizGUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;
        int escolha = JOptionPane.YES_OPTION;
        do {
             // Definir as categorias
            String[] categorias = {"Tecnologia", "HiLab", "Gerais", "Benefícios"};

            // Perguntas e respostas do Quiz por categoria 
            String[][] Tecnologia = {
                {    "\nEsse é um quiz sobre Tecnologia e linguagem de programação! Vamos lá? \n\nQual a linguagem de alto nível mais utilizada atualmente?\n",
                    "1) C++", "2) Phyton", "3) PHP", "2"
                },
                {
                    "\nQual a melhor linguagem para gerenciamento de dados?\n",
                    "1) C#", "2) Java", "3) SQL", "3"
                },
                {
                    "\nQual a linguagem utilizada para desenvolver aplicativos em flutter?\n",
                    "1) Dart", "2) Java", "3) PHP", "1"
                },
                {
                    "\nO que significa IA?\n",
                    "1) Inteligencia Artificial", "2) Interação Ativa", "3) Índice Alto", "1"
                },
                {
                    "\nO que significa POO?\n",
                    "1) Programa Online e Offline", "2) Programação Orientada a Objetos", "3) Prática Oriunda de Objetos", "2"
                }
            };
            String[][] HiLab = {
                {
                    "\nEsse é um quiz sobre a empresa HiLab. Vamos testar seu conhecimento? \n\nSão valores da HiLab, exceto:\n",
                    "1) Família", "2) Sustentáveis", "3) Inovadores", "1"
                },
                {
                    "\nQuais destes são pilares da HiLab?\n",
                    "1) Acessibilidade Informação e Amizade", "2) Cuidado Praticidade e Alegria", "3) Agilidade Simplicidade e Acessibilidade", "3"
                },
                {
                    "\nQual o propósito da empresa?\n",
                    "1) Democratizar o acesso à saúde", "2) Facilitar amostras de sangue", "3) Criar testes laboratoriais tecnológicos", "1"
                },
                {
                    "\nA HiLab é composta (em porcentagem) por quantas mulheres no time de tecnologia?\n",
                    "1) 15", "2) 30", "3) 50", "2"
                },
                {
                    "\nSer Hier é ser:\n",
                    "1) Alguém diferente", "2) Quem a empresa quiser", "3) Quem você é", "3"
                }
            };
            String[][] Benefícios = {
                {
                    "\nEsse é um quiz sobre os benefícios de ser um Hier!! Vamos ao quiz? \n\nSão benefícios HiLab, exceto:\n",
                    "1) Day Off no aniversário", "2) Horário flexível", "3) Home Office", "3"
                },
                {
                    "\nQual é a resposta verdadeira?\n",
                    "1) O VT e VA tem desconto em folha", "2) Somente o VT tem desconto em folha", "3) O VT e o VA não tem desnconto em folha", "3"
                },
                {
                    "\nÉ proporcionado pela HiLab, exceto:\n",
                    "1) Natação", "2) Ginástica Laboral", "3) Yoga", "1"
                },
                {
                    "\nQual o plano de saúde proporcionado para o Hier:\n",
                    "1) Amil", "2) Unimed", "3) Bradesco", "2"
                },
                {
                    "\nQual é um benefício diferente e divertido da HiLab?\n",
                    "1) Horta orgânica colaborativa", "2) Clube do tricô", "3) Tarde do livro", "1"
                }
            };
            String[][] Gerais = {
                {
                    "\nEsse quiz vai testar seus conhecimentos gerais, será que você consegue? \n\nEm que ano começou a segunda guerra mundial?\n",
                    "1) 1939", "2) 1945", "3) 1930", "1"
                },
                {
                    "\nQuantos elementos químicos a tabela periódica possui atualmente?\n",
                    "1) 103", "2) 92", "3) 118", "3"
                },
                {
                    "\nOnde fica localizado o Vale do Silício?\n",
                    "1) Seattle", "2) San Francisco", "3) Houston", "2"
                },
                {
                    "\nQuem pintou o quadro 'Monalisa'?\n",
                    "1) Pablo Picasso", "2) Vicent Van Gogh", "3) Leonardo Da Vinci", "3"
                },
                {
                    "\nQual é o tipo sanguíneo considerado doador universal?\n",
                    "1) Tipo O", "2) Tipo A", "3) Tipo AB", "1"
                }
            };
            
            // Perguntar qual categoria o usuário quer jogar
            int category = JOptionPane.showOptionDialog(null, "Bem-Vindo(a) ao Quiz!! \nQual categoria você gostaria de jogar?", "Escolha a categoria", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, categorias, categorias[0]);
            JOptionPane.showMessageDialog(null, "Você escolheu a categoria " + categorias[category]);
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i+1) + ". " + categorias[i]);
            }

            int categoriaEscolhida = category;
            
            // Selecionar a matriz de perguntas e respostas correta
            String[][] perguntasErespostas;
            switch (categoriaEscolhida) {
                case 0:
                    perguntasErespostas = Tecnologia;
                    break;
                case 1:
                    perguntasErespostas = HiLab;
                    break;
                case 2:
                    perguntasErespostas = Gerais;
                    break;
                case 3:
                    perguntasErespostas = Benefícios;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Categoria inválida. Tente novamente!");
                    continue;
            }

            // Jogar o quiz para a categoria selecionada
            int pontuacao = 0;

            // Apresentar cada pergunta ao usuário
            for (String[] pergunta : perguntasErespostas) {
                JOptionPane.showMessageDialog(null, pergunta[0]);
                String[] opcoes = Arrays.copyOfRange(pergunta, 1, pergunta.length - 1);
                int respostaCorreta = Integer.parseInt(pergunta[pergunta.length - 1]);
                int respostaUsuario = JOptionPane.showOptionDialog(null, "Escolha a resposta correta", "Pergunta",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                if (respostaUsuario == respostaCorreta - 1) {
                    JOptionPane.showMessageDialog(null, "Resposta correta!");
                    pontuacao++;
                } else {
                    JOptionPane.showMessageDialog(null, "Resposta incorreta!");
                }
            }
            // Apresentar a pontuação do usuário ao final do quiz e perguntar se gostaria de jogar novamente
                 escolha = JOptionPane.showConfirmDialog(null, "Parabéns! Você finalizou o quiz e obteve " + pontuacao + " pontos de um total de " + perguntasErespostas.length + ".\n\nDeseja jogar novamente?");
        }   // se a resposta for negativa finaliza o quiz
            while (escolha == JOptionPane.YES_OPTION);

            JOptionPane.showMessageDialog(null, "Obrigada por jogar o Quiz! Até a próxima ;)");

            }
    }    

            