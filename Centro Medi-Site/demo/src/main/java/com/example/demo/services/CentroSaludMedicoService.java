package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CentroSaludMedicoModel;
import com.example.demo.models.CentroSaludModel;
import com.example.demo.models.TimeslotModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.CentroSaludMedicoRepository;
import com.example.demo.repositories.CentroSaludRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class CentroSaludMedicoService {

	
	@Autowired
	CentroSaludMedicoRepository centroSaludMedicoRepository;
	
	public ArrayList<UsuarioModel> verUsuarios(Long id){
		ArrayList<CentroSaludMedicoModel> csms= (ArrayList<CentroSaludMedicoModel> )centroSaludMedicoRepository.findAll();
		for(CentroSaludMedicoModel csm:csms ) {
			if(csm.getCentroSaludMedicoModelid()==id) {
				ArrayList<UsuarioModel> usuarioModel = (ArrayList<UsuarioModel>) csm.getUsuarioModel();
				return usuarioModel;
			}
		}
		return null;
	}
	
	
}
