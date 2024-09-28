# ola-devops-me

Projeto de Aprendizado

Criando pipeline


IAM
-
- Criar uma role para o EC2
  - AmazonS3ReadOnlyAccess
  - AWSCodeDeployRole

- Criar uma role para o CodeDeploy
  - AWSCodeDeployRole

EC2
-
- Criar instancia
- Instalar Agent do Codedeploy e ambiente Java


Codepipeline
- 
- nova pipeline
- -> definir nome -> v2 ->  substituida -> nova função/role de serviço
- -> origem  [ github2 -> conectar ao github -> escolher repositório -> escolher branch -> clone completo ]
- -> trigger [ nenhum filtro -> tipo de evento = push . ]

Codedeploy-

- Criar aplicativo
- nome do aplicativo -> plataforma = ec2/onPremisses
- associar role criada
- tipo de implantação > no local
- Configuração de ambiente > escolher[Instâncias do Amazon EC2]
  - dar um nome a chave e no valor, apontar para o instancia que deseja implantar
  - Configuração de implantação >-AllAtOnce










