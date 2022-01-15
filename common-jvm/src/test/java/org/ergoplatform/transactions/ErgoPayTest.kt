package org.ergoplatform.transactions

import org.ergoplatform.*
import org.junit.Assert.*
import org.junit.Test

class ErgoPayTest {

    @Test
    fun parseErgoPaySigningRequestFromUriTest() {
        isErgoMainNet = false

        val uri =
            "ergoPay:9AEBJmPrKJW357sXF3WsClhAxbyYRt1quzw3ch4Vy5sclX4AAAAAA4CU69wDAAjNAi3nJqP6BpQt0iKVlmBauTJATOOGNEcZtJYd7ZMGeyE6o4oFAADAhD0QBQQABAAONhACBJABCM0Ceb5mfvncu6xVoGKVzocLBwKb_NstzijZWfKBWxb4F5jqAtGSo5qMx6cBcwBzARABAgQC0ZaDAwGTo4zHsqVzAAABk8KypXMBAHRzAnMDgwEIze6sk7GlcwSjigUAAOaW4NLqAQAIzQKDM_n3RU-NX_c9usmDN2ftb8OobPCnPflGsy6pkn2Rl6OKBQAAzQKDM_n3RU-NX_c9usmDN2ftb8OobPCnPflGsy6pkn2Rl51PjGA="

        // ergoPay:0QMDCp28G2Gct69t0D-IMK8h0kKEjj7f49cAtGwvUtSOPesAAGPk-W6yjBzn2jPcoFiaufhsXy52IsuIQjiCCE_q8m9DAACuLv3AeVnq-cluQls7Kz_8-YsWGTDNCl9HiVzLMP4oNgAAAARRQIOhcPxzQHHAd0j_RElAYGZUMXvVFoZRIO1wKVKrG_n_BLk_9n7C3gSwVnXkGjjA-vQJ1Jn9NExtNOXppL7dzaVi_TpNypHLwgdakRo6WxG37YEAl7GsWlS3Yqh3sGKW1lsZOJnBVNdbw6VbLTwjEfCfArnW7S2skTyxDDgwgAOA3qDLBQAIzQKDM_n3RU-NX_c9usmDN2ftb8OobPCnPflGsy6pkn2Rl7WLBQEA8zkAwIQ9EAUEAAQADjYQAgSQAQjNAnm-Zn753LusVaBilc6HCwcCm_zbLc4o2VnygVsW-BeY6gLRkqOajMenAXMAcwEQAQIEAtGWgwMBk6OMx7KlcwAAAZPCsqVzAQB0cwJzA4MBCM3urJOxpXMEtYsFAADA7_HRyQIACM0CLecmo_oGlC3SIpWWYFq5MkBM44Y0Rxm0lh3tkwZ7ITq1iwUEAQECgNDbw_QCAPCB28P0AgPQ2JatAwDNAi3nJqP6BpQt0iKVlmBauTJATOOGNEcZtJYd7ZMGeyE6nU_NAi3nJqP6BpQt0iKVlmBauTJATOOGNEcZtJYd7ZMGeyE6nU_NAi3nJqP6BpQt0iKVlmBauTJATOOGNEcZtJYd7ZMGeyE6nU_QjAE=

        assertTrue(isErgoPaySigningRequest(uri))
        assertFalse(isErgoPaySigningRequest(""))

        val ergoPaySigningRequest = getErgoPaySigningRequest(uri)
        ergoPaySigningRequest.apply {
            assertNotNull(reducedTx)
            assertNull(message)
            assertNull(replyToUrl)
            assertNull(p2pkAddress)
            assertEquals(MessageSeverity.NONE, messageSeverity)

            val parsedTx = deserializeUnsignedTxOffline(reducedTx!!)
            assertNotNull(parsedTx)
        }

        // this will fetch information from ergo explorer, commented since server problems would break build
        // val txInfo = ergoPaySigningRequest.buildTransactionInfo(ErgoApiService.getOrInit(TestPreferencesProvider()))
        // assertNotNull(txInfo)
    }
}