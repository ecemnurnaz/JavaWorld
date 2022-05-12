package edu.sabanciuniv.mts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

	private MTRepository mtRepository;
	
	@Autowired
	public LogService(MTRepository mtRepository) {
		super();
		this.mtRepository = mtRepository;
	}
	
	public List<Transfer> findAll(){
		return mtRepository.findAll();
	}
}
