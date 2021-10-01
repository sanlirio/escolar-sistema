package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Aluno;
import com.escolar.system.domain.Cidade;
import com.escolar.system.domain.enums.Alergia;
import com.escolar.system.domain.enums.DeficienciaFisica;
import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.escolar.system.domain.enums.UsaMedicamentos;
import com.escolar.system.dtos.AlunoDTO;
import com.escolar.system.repositories.AlunoRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CidadeService cidadeSrevice;

	public Aluno findById(Long id) {
		Optional<Aluno> objAlu = alunoRepository.findById(id);
		return objAlu.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Aluno.class.getName()));

	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno create(AlunoDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return fromDTO(objDTO);
	}

	private Aluno fromDTO(AlunoDTO objDTO) {
		Aluno newObj = new Aluno();

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
		newObj.setTipoSanguinio(TipoSanguinio.toEnum(objDTO.getTipoSanguinio()));
		newObj.setDeficienciaFisica(DeficienciaFisica.toEnum(objDTO.getDeficienciaFisica()));
		newObj.setAlergia(Alergia.toEnum(objDTO.getAlergia()));
		newObj.setUsaMedicamentos(UsaMedicamentos.toEnum(objDTO.getUsaMedicamentos()));
		newObj.setObservacao(objDTO.getObservacao());
		Cidade cid = cidadeSrevice.findById(objDTO.getCidade());
		newObj.setCidade(cid);

		newObj.setTipoAlergias(objDTO.getTipoAlergias());
		newObj.setTipoDeficiencias(objDTO.getTipoDeficiencias());
		newObj.setMedicamentos(objDTO.getMedicamentos());
		newObj.setResponsaveis(objDTO.getResponsaveis());

		return alunoRepository.save(newObj);
	}

	public Aluno update(Long id, @Valid AlunoDTO objDTO) {
		Aluno oldObj = findById(id);

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
		oldObj.setTipoSanguinio(TipoSanguinio.toEnum(objDTO.getTipoSanguinio()));
		oldObj.setDeficienciaFisica(DeficienciaFisica.toEnum(objDTO.getDeficienciaFisica()));
		oldObj.setAlergia(Alergia.toEnum(objDTO.getAlergia()));
		oldObj.setUsaMedicamentos(UsaMedicamentos.toEnum(objDTO.getUsaMedicamentos()));
		oldObj.setObservacao(objDTO.getObservacao());
		Cidade cidU = cidadeSrevice.findById(objDTO.getCidade());
		oldObj.setCidade(cidU);
		oldObj.setTipoAlergias(objDTO.getTipoAlergias());
		oldObj.setTipoDeficiencias(objDTO.getTipoDeficiencias());
		oldObj.setMedicamentos(objDTO.getMedicamentos());
		oldObj.setResponsaveis(objDTO.getResponsaveis());
		return alunoRepository.save(oldObj);
	}

	// METODO DE EXCESSÃO PARA CPF JA CADASTRADO
	private Aluno findByCPF(AlunoDTO objDTO) {
		Aluno objAlu = alunoRepository.findByCPF(objDTO.getCpf());
		if (objAlu != null) {
			return objAlu;
		}
		return null;
	}

	public void delete(Long id) {
		Aluno obj = findById(id);
		if (obj.getMensalidades().size() > 0 
				|| obj.getTipoAlergias().size() > 0
				|| obj.getTipoDeficiencias().size() > 0
				|| obj.getMedicamentos().size() > 0
				|| obj.getResponsaveis().size() > 0) {
			throw new DataIntegratyViolationException("Aluno possui Dados ligados a ele e não pode ser deletado!");
		}

	}
}
