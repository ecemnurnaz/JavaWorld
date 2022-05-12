package edu.sabanciuniv.mts;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferService {

	private MTRepository mtRepository;
	
	@Autowired
	public MoneyTransferService(MTRepository mtRepository) {
		super();
		this.mtRepository = mtRepository;
	}
	
	public Transfer createTransfer(int senderIban, int receiverIban, double amount) {
		
		Transfer t1 = new Transfer(senderIban, receiverIban, amount, LocalDateTime.now());
		
		return mtRepository.save(t1);
	}
}
