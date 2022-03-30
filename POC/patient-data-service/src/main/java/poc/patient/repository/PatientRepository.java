/**
 * 
 */
package poc.patient.repository;

import java.time.temporal.ChronoUnit;
import java.util.List;

import poc.patient.model.FormattedWaveformModel;

/**
 * @author 1013744
 *
 */

public interface PatientRepository {

	public List<String> getPatientNameList();

	public List<FormattedWaveformModel> getWaveForm(String patientId, long fromTime, long toTIme);
	
	public List<FormattedWaveformModel> getWaveForm(String patientId);
	
	public List<FormattedWaveformModel> getLaterTimeData(float timeDuration,ChronoUnit unit);

}
