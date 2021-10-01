package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Cidade;
import com.escolar.system.domain.Responsavel;
import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.dtos.ResponsavelDTO;
import com.escolar.system.repositories.ResponsavelRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Autowired
	private CidadeService cidadeSrevice;

	public Responsavel findById(Long id) {
		Optional<Responsavel> objRes = responsavelRepository.findById(id);
		return objRes.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Responsavel.class.getName()));
	}

	public List<Responsavel> findAll() {
		return responsavelRepository.findAll();
	}

	public Responsavel create(ResponsavelDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return fromDTO(objDTO);
	}

	private Responsavel fromDTO(ResponsavelDTO objDTO) {
		Responsavel newObj = new Responsavel();

		newObj.setId(objDTO.getId());
		newObj.setNome(objDTO.getNome());
		newObj.setMae(objDTO.getMae());
		newObj.setPai(objDTO.getPai());
		newObj.setDataNascimento(objDTO.getDataNascimento());
		newObj.setDataCadastro(objDTO.getDataCadastro());
		newObj.setLogradouro(objDTO.getLogradouro());
		newObj.setComplemento(objDTO.getComplemento());
		newObj.setNumero(objDTO.getNumero());
		newObj.setBairro(objDTO.getBairro());
		newObj.setCep(objDTO.getCep());
		newObj.setNacionalidade(objDTO.getNacionalidade());
		newObj.setEmail(objDTO.getEmail());
		newObj.setTelefone1(objDTO.getTelefone1());
		newObj.setTelefone2(objDTO.getTelefone2());
		newObj.setRg(objDTO.getRg());
		newObj.setOrgaoEmissor(objDTO.getOrgaoEmissor());
		newObj.setCpf(objDTO.getCpf());
		newObj.setReligiao(objDTO.getReligiao());
		newObj.setSexo(Sexo.toEnum(objDTO.getSexo()));
		newObj.setStatus(Status.toEnum(objDTO.getStatus()));
		newObj.setEstadoCivil(EstadoCivil.toEnum(objDTO.getEstadoCivil()));
		newObj.setGrauParentesco(objDTO.getGrauParentesco());
		newObj.setObservacao(objDTO.getObservacao());
		newObj.setAlunos(objDTO.getAlunos());
		Cidade cid = cidadeSrevice.findById(objDTO.getCidade());
		newObj.setCidade(cid);

		return responsavelRepository.save(newObj);
	}

	public Responsavel update(Long id, @Valid ResponsavelDTO objDTO) {
		Responsavel oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		oldObj.setMae(objDTO.getMae());
		oldObj.setPai(objDTO.getPai());
		oldObj.setDataNascimento(objDTO.getDataNascimento());
		oldObj.setDataCadastro(objDTO.getDataCadastro());
		oldObj.setLogradouro(objDTO.getLogradouro());
		oldObj.setComplemento(objDTO.getComplemento());
		oldObj.setNumero(objDTO.getNumero());
		oldObj.setBairro(objDTO.getBairro());
		oldObj.setCep(objDTO.getCep());
		oldObj.setNacionalidade(objDTO.getNacionalidade());
		oldObj.setEmail(objDTO.getEmail());
		oldObj.setTelefone1(objDTO.getTelefone1());
		oldObj.setTelefone2(objDTO.getTelefone2());
		oldObj.setRg(objDTO.getRg());
		oldObj.setOrgaoEmissor(objDTO.getOrgaoEmissor());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setReligiao(objDTO.getReligiao());
		oldObj.setSexo(Sexo.toEnum(objDTO.getSexo()));
		oldObj.setStatus(Status.toEnum(objDTO.getStatus()));
		oldObj.setEstadoCivil(EstadoCivil.toEnum(objDTO.getEstadoCivil()));
		oldObj.setGrauParentesco(objDTO.getGrauParentesco());
		oldObj.setObservacao(objDTO.getObservacao());
		oldObj.setAlunos(objDTO.getAlunos());
		Cidade cidU = cidadeSrevice.findById(objDTO.getCidade());
		oldObj.setCidade(cidU);
		return responsavelRepository.save(oldObj);
	}

	public void delete(Long id) {
		Responsavel obj = findById(id);
		if (obj.getAlunos().size() > 0) {
			throw new DataIntegratyViolationException("Responsavel possui Aluno ligado a ele e não pode ser deletado!");
		}
		responsavelRepository.deleteById(id);

	}

	// METODO DE EXCESSÃO PARA CPF JA CADASTRADO
	private Responsavel findByCPF(ResponsavelDTO objDTO) {
		Responsavel objRes = responsavelRepository.findByCPF(objDTO.getCpf());
		if (objRes != null) {
			return objRes;
		}
		return null;
	}

}
