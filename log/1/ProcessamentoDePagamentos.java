import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessamentoDePagamentos {

    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

    public static void main(String[] args) {
        // Resultados fixos: 1=erro, 0=sucesso, 2=pendente
        int[] resultados = {1, 0, 0, 1, 2};

        for (int i = 0; i < resultados.length; i++) {
            int numeroPagamento = i + 1;
            logger.info("Iniciando o processamento do pagamento {}", numeroPagamento);

            try {
                Thread.sleep(1000); // Simula tempo de processamento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Erro de interrupção durante o pagamento {}", numeroPagamento);
                continue;
            }

            switch (resultados[i]) {
                case 0:
                    logger.info("Pagamento {} processado com sucesso.", numeroPagamento);
                    break;
                case 1:
                    logger.error("Erro ao processar o pagamento {}: Falha na transação.", numeroPagamento);
                    break;
                case 2:
                    logger.warn("Pagamento {} está pendente. Aguardando confirmação.", numeroPagamento);
                    break;
            }
        }

        logger.info("Processamento de pagamentos concluído.");
    }
}
