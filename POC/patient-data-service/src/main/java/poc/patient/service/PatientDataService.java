/**
 * 
 */
package poc.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poc.patient.model.FormattedWaveformModel;
import poc.patient.repository.PatientRepository;

/**
 * @author 1013744
 *
 */

public interface PatientDataService {

	/**
	 * @return
	 */
	public List<String> getPatientNameList();

	/**
	 * @param patientId
	 * @param fromTime
	 * @param toTIme
	 * @return
	 */
	public List<FormattedWaveformModel> getWaveForm(String patientId, long fromTime, long toTIme);
	
	/**
	 * @param patientId
	 * @return
	 */
	public List<FormattedWaveformModel> getWaveForm(String patientId);
}