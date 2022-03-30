package poc.patient.repository.impl;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import poc.patient.model.FormattedWaveformModel;
import poc.patient.repository.PatientRepository;

/**
 * @author 1013744
 *
 */
@Repository
public class PatientRepositoryImpl implements PatientRepository, CassandraRepository<FormattedWaveformModel, String> {

	/**
	 * 
	 */
	@Autowired
	private CassandraOperations cassandraTemplate;
	
	/**
	 *
	 */
	@Override
	public List<FormattedWaveformModel> getWaveForm(String patientId) {
		return cassandraTemplate.select(
				Query.query(Criteria.where("patientname").is(patientId)).withAllowFiltering(),FormattedWaveformModel.class);
	}

	/**
	 *
	 */
	@Override
	public List<String> getPatientNameList() {
		List<FormattedWaveformModel> list = cassandraTemplate.select(Query.empty(), FormattedWaveformModel.class);
		List<String> patientNames = list.stream().map(p -> p.getPatientname()).distinct().collect(Collectors.toList());
		return patientNames;
	}

	/**
	 *
	 */
	@Override
	public List<FormattedWaveformModel> getWaveForm(String patientId, long fromTime, long toTIme) {
		return cassandraTemplate.select(
				Query.query(Criteria.where("patientname").is(patientId))
						.and(Criteria.where("effectiveTime").gte(fromTime))
						.and(Criteria.where("effectiveTime").lte(toTIme)).withAllowFiltering(),
				FormattedWaveformModel.class);
	}

	/**
	 *
	 */
	@Override
	public List<FormattedWaveformModel> getLaterTimeData(float timeDuration, ChronoUnit unit) {

		return null;
	}

	@Override
	public <S extends FormattedWaveformModel> S save(S entity) {
		return cassandraTemplate.insert(entity);
	}

	@Override
	public Optional<FormattedWaveformModel> findById(String id) {

		return null;
	}

	@Override
	public boolean existsById(String id) {

		return false;
	}

	@Override
	public long count() {

		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(FormattedWaveformModel entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends FormattedWaveformModel> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends FormattedWaveformModel> List<S> saveAll(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormattedWaveformModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FormattedWaveformModel> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slice<FormattedWaveformModel> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FormattedWaveformModel> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FormattedWaveformModel> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
