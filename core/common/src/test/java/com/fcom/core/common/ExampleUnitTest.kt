package com.fcom.core.common

import app.cash.turbine.test
import com.fcom.core.common.result.Result
import com.fcom.core.common.result.asResult
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test


class ResultKtTest {
    @Test
    fun is_Result_KT_Catches_Errors() = runTest {
        flow {
            emit(1)
            throw Exception("Test Pass")
        }
            .asResult()
            .test {
                assertEquals(Result.Loading, awaitItem())
                assertEquals(Result.Success(1), awaitItem())

                when (val errorResult = awaitItem()) {
                    is Result.Error -> assertEquals(
                        "Test Pass",
                        errorResult.throwable.message,
                    )

                    Result.Loading,
                    is Result.Success,
                    -> throw IllegalStateException(
                        "The flow should have emitted an Error Result",
                    )
                }

                awaitComplete()
            }
    }
}