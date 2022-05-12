package edu.sabanciuniv.mts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MTController {
	
	private MoneyTransferService moneyTransferService;
	private LogService logService;
	
	@Autowired
	public MTController(MoneyTransferService moneyTransferService, LogService logService) {
		super();
		this.moneyTransferService = moneyTransferService;
		this.logService = logService;
	}

	
	
	@GetMapping(value = "/LogService/getLogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transfer> findAllTransfers() {
		return logService.findAll();
	}
	
	
	@PostMapping(value = "/MoneyTransferService/transfer/{senderIban}/{receiverIban}/{amount}")
	public ResponseEntity<Transfer> createTransaction(@PathVariable("senderIban") int senderIban, @PathVariable("receiverIban") int receiverIban, @PathVariable("amount") double amount) {
		Transfer savedT = moneyTransferService.createTransfer(senderIban, receiverIban, amount);
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(savedT);
	}
}
