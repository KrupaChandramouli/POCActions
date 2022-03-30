/**
 * 
 */
package poc.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.patient.model.FormattedWaveformModel;
import poc.patient.repository.PatientRepository;
import poc.patient.service.PatientDataService;

/**
 * @author 1013744
 *
 */
@Service
public class PatientDataServiceImpl implements PatientDataService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<String> getPatientNameList() {
		return patientRepository.getPatientNameList();
	}

	@Override
	public List<FormattedWaveformModel> getWaveForm(String patientId, long fromTime, long toTIme) {
		return patientRepository.getWaveForm(patientId, fromTime, toTIme);
	}

	@Override
	public List<FormattedWaveformModel> getWaveForm(String patientId) {
		return patientRepository.getWaveForm(patientId);
	}

}
