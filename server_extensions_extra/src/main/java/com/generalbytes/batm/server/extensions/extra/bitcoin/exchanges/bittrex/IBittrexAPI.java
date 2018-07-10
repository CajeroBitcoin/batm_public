package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bittrex;

import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bittrex.dto.BtResponseTickerDto;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bittrex.dto.BtResponseCurrenciesDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/v1.1")
@Produces(MediaType.APPLICATION_JSON)
@SuppressWarnings("all")
public interface IBittrexAPI {

    @GET
    @Path("/public/getcurrencies")
    BtResponseCurrenciesDto getCurrencies();

    @GET
    @Path("/public/getticker")
    BtResponseTickerDto getTicker(@QueryParam("market")String market);

    @GET
    @Path("/account/getbalance")
    Map<String, Object> getBalance(@HeaderParam("apisign") String apisign, @QueryParam("apikey") String apiKey, @QueryParam("currency") String currency, @QueryParam("nonce") String nonce);

    @GET
    @Path("/account/withdraw")
    Map<String, Object> withdraw(@HeaderParam("apisign") String apisign, @QueryParam("apikey") String apiKey, @QueryParam("currency") String currency, @QueryParam("quantity") int quantity, @QueryParam("address") String address, @QueryParam("nonce") String nonce);
}
