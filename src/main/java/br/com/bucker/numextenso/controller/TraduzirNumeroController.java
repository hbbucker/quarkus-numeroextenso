package br.com.bucker.numextenso.controller;

import br.com.bucker.numextenso.exceptions.ValorInvalidoException;
import br.com.bucker.numextenso.model.NumeroTraduzido;
import br.com.bucker.numextenso.service.TraduzirNumeroService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TraduzirNumeroController {

    @GET
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public NumeroTraduzido traduzirNumero(@PathParam("numero") Integer numero) throws ValorInvalidoException {
        return TraduzirNumeroService.traduzirNumero(numero);
    }
}