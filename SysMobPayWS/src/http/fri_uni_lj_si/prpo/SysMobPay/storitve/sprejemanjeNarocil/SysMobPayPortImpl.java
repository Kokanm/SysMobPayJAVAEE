package http.fri_uni_lj_si.prpo.SysMobPay.storitve.sprejemanjeNarocil;


import javax.jws.WebService;

import http.fri_uni_lj_si.prpo.SysMobPay.storitve.sprejemanjeNarocil.SysMobPayPort;

@WebService(serviceName = "SprejemanjeNarocil", endpointInterface = "si.uni_lj.fri.prpo.spletnanarocila.storitve.sprejemanjenarocil.SprejemanjeNarocilPort", targetNamespace = "http://fri.uni-lj.si/prpo/spletnaNarocila/storitve/sprejemanjeNarocil")
public class SysMobPayPortImpl implements SysMobPayPort {
	public si.uni_lj.fri.prpo.SysMobPay.sporocila.SysMobPayOdgovorSporocilo sprejmiNarocila(
			si.uni_lj.fri.prpo.SysMobPay.sporocila.SysMobPaySporocilo input) {
		return null;
	}
}