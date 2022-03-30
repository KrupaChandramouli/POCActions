/**
 * 
 */
package poc.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.patient.model.FormattedWaveformModel;
import poc.patient.service.PatientDataService;

/**
 * @author 1013744
 *
 */

@RestController
@RequestMapping("/patient")
public class PatientDataServiceController {

	@Autowired
	private PatientDataService patientDataService;

	/**
	 * @return
	 */
	@GetMapping(value = "/patientlist")
	public List<String> getPatientNameList() {
		return patientDataService.getPatientNameList();
	}

	/**
	 * @param patientId
	 * @param fromTime
	 * @param toTIme
	 * @return
	 */
	@GetMapping(value = "/waveform")
	public List<FormattedWaveformModel> getWaveForm(@RequestParam(required = true, name = "patientId") String patientId,
			@RequestParam(required = true, name = "fromTime") long fromTime,
			@RequestParam(required = true, name = "toTIme") long toTIme) {
		return patientDataService.getWaveForm(patientId, fromTime, toTIme);
	}
	
	
	@GetMapping(value = "/waveform/{patientId}")
	public List<FormattedWaveformModel> getWaveForm(@RequestParam(required = true, name = "patientId") String patientId) {
		return patientDataService.getWaveForm(patientId);
	}
	
	

	/**
	 * @return
	 */
	@GetMapping(value = "/test")
	public String getTest() {
		return "ok";
	}
}
