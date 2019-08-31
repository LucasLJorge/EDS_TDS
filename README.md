# EDS_TDS
Projetos de simulação dirigida a eventos e a tempo

Time-driven simulation
- Inicializar o estado do sistema e o tempo de
simulação
- Enquanto a simulação não terminar 
1. Coletar estatísticas sobre o estado
corrente;
2. Executar os eventos que ocorreram entre o
último intervalo e o atual;
3. Incrementar o tempo de simulação;

Event Driven Simulation
- Inicializar o estado do sistema
- Inicializar a lista de eventos
- Enquanto a simulação não terminar
1. Coletar estatísticas sobre o estado
corrente;
2. Remover o primeiro evento da lista e
executá-lo;
3. Ajustar o tempo para o tempo desse
evento;

Os algritmos foram implementados usando ArrayList e suas métricas retiradas através de contadores de tempo.
