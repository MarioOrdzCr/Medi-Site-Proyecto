package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CentroSaludModel;
import com.example.demo.repositories.CentroSaludRepository;

import Config.CompararCitas;
import Config.ComprarCS;

@Service
public class CentroSaludService {

	@Autowired
	CentroSaludRepository centroSaludRepository;
	
	public ArrayList<CentroSaludModel> verCSUrgencias(){
		ArrayList<CentroSaludModel> cs= (ArrayList<CentroSaludModel>) centroSaludRepository.findAll();
		ArrayList<CentroSaludModel> csAux= new ArrayList<CentroSaludModel>();
		for(CentroSaludModel centro: cs) {
			if(centro.isUrgencias()) {
				csAux.add(centro);
			}
		}
		java.util.Collections.sort(csAux, new ComprarCS());
		return csAux;
	}
	
}
