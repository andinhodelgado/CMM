package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.update

import br.com.usinasantafe.cmm.features.domain.repositories.stable.AtividadeRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateAtividadeImpl @Inject constructor(
    private val atividadeRepository: AtividadeRepository
): UpdateAtividade {

    override suspend fun invoke(contador: Int, qtde: Int): Flow<ResultUpdateDataBase> {
        return flow {
            var contUpdateAtividade = contador
            emit(ResultUpdateDataBase(++contUpdateAtividade, "Limpando Dados da Tabela Atividade", qtde))
            atividadeRepository.deleteAllAtividade()
            emit(ResultUpdateDataBase(++contUpdateAtividade, "Recebendo Dados da Tabela Atividade", qtde))
            atividadeRepository.recoverAllAtividade()
                .collect{ result ->
                    result.onSuccess { ativList ->
                        emit(ResultUpdateDataBase(++contUpdateAtividade, "Salvandos Dados da Tabela Atividade", qtde))
                        atividadeRepository.addAllAtividade(ativList)
                    }
                }
        }
    }

}