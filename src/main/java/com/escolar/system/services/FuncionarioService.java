package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Cargo;
import com.escolar.system.domain.Cidade;
import com.escolar.system.domain.Funcionario;
import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.GrauInstrucao;
import com.escolar.system.domain.enums.PosGraduacao;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.escolar.system.dtos.FuncionarioDTO;
import com.escolar.system.repositories.FuncionarioRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CidadeService cidadeSrevice;

	@Autowired
	private CargoService cargoService;

	public Funcionario findById(Long id) {
		Optional<Funcionario> objFunc = funcionarioRepository.findById(id);
		return objFunc.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Funcionario.class.getName()));
	}

	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	public Funcionario create(FuncionarioDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return fromDTO(objDTO);
	}

	private Funcionario fromDTO(FuncionarioDTO objDTO) {
		Funcionario newObj = new Funcionario();

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
		Cidade cid = cidadeSrevice.findById(objDTO.getCidade());
		newObj.setCidade(cid);
		newObj.setDataAdmissao(objDTO.getDataAdmissao());
		newObj.setDataDemissao(objDTO.getDataDemissao());
		newObj.setCtps(objDTO.getCtps());
		newObj.setSerieCtps(objDTO.getSerieCtps());
		newObj.setPis(objDTO.getPis());
		newObj.setGrauInstrucao(GrauInstrucao.toEnum(objDTO.getGrauInstrucao()));
		newObj.setTipoPosGraduacao(objDTO.getTipoPosGraduacao());
		newObj.setPosGraduacao(PosGraduacao.toEnum(objDTO.getPosGraduacao()));

		Cargo car = cargoService.findById(objDTO.getCargo());
		newObj.setCargo(car);

		newObj.setTurnos(objDTO.getTurnos());
		newObj.setDisciplinas(objDTO.getDisciplinas());
		newObj.setTurmas(objDTO.getTurmas());

		return funcionarioRepository.save(newObj);
	}

	public Funcionario update(Long id, @Valid FuncionarioDTO objDto) {
		Funcionario oldObj = findById(id);

		if (findByCPF(objDto) != null && findByCPF(objDto).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setNome(objDto.getNome());
		oldObj.setMae(objDto.getMae());
		oldObj.setPai(objDto.getPai());
		oldObj.setDataNascimento(objDto.getDataNascimento());
		oldObj.setDataCadastro(objDto.getDataCadastro());
		oldObj.setLogradouro(objDto.getLogradouro());
		oldObj.setComplemento(objDto.getComplemento());
		oldObj.setNumero(objDto.getNumero());
		oldObj.setBairro(objDto.getBairro());
		oldObj.setCep(objDto.getCep());
		oldObj.setNacionalidade(objDto.getNacionalidade());
		oldObj.setEmail(objDto.getEmail());
		oldObj.setTelefone1(objDto.getTelefone1());
		oldObj.setTelefone2(objDto.getTelefone2());
		oldObj.setRg(objDto.getRg());
		oldObj.setOrgaoEmissor(objDto.getOrgaoEmissor());
		oldObj.setCpf(objDto.getCpf());
		oldObj.setReligiao(objDto.getReligiao());
		oldObj.setSexo(Sexo.toEnum(objDto.getSexo()));
		oldObj.setStatus(Status.toEnum(objDto.getStatus()));
		oldObj.setEstadoCivil(EstadoCivil.toEnum(objDto.getEstadoCivil()));
		oldObj.setTipoSanguinio(TipoSanguinio.toEnum(objDto.getTipoSanguinio()));
		Cidade cidU = cidadeSrevice.findById(objDto.getCidade());
		oldObj.setCidade(cidU);
		oldObj.setDataAdmissao(objDto.getDataAdmissao());
		oldObj.setDataDemissao(objDto.getDataDemissao());
		oldObj.setCtps(objDto.getCtps());
		oldObj.setSerieCtps(objDto.getSerieCtps());
		oldObj.setPai(objDto.getPis());
		oldObj.setGrauInstrucao(GrauInstrucao.toEnum(objDto.getGrauInstrucao()));
		oldObj.setTipoPosGraduacao(objDto.getTipoPosGraduacao());
		Cargo carU = cargoService.findById(objDto.getCargo());
		oldObj.setCargo(carU);

		oldObj.setTurnos(objDto.getTurnos());
		oldObj.setDisciplinas(objDto.getDisciplinas());
		oldObj.setTurmas(objDto.getTurmas());

		return funcionarioRepository.save(oldObj);
	}

	public void delete(Long id) {
		Funcionario obj = findById(id);
		if (obj.getDisciplinas().size() > 0 
				|| obj.getTurmas().size() > 0 
				|| obj.getTurnos().size() > 0
				|| obj.getSalarios().size() > 0) {
			throw new DataIntegratyViolationException("Funcionario possui Dados ligado a ele e não pode ser deletado!");
		}
		funcionarioRepository.deleteById(id);

	}

	// METODO DE EXCESSÃO PARA CPF JA CADASTRADO
	private Funcionario findByCPF(FuncionarioDTO objDTO) {
		Funcionario objFun = funcionarioRepository.findByCPF(objDTO.getCpf());
		if (objFun != null) {
			return objFun;
		}
		return null;
	}

}
