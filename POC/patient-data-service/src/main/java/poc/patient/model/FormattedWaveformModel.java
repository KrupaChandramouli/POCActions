package poc.patient.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("waveform_tr_tbl")
public class FormattedWaveformModel {

	@PrimaryKey
	private String id;
	@Column
	private String patientname;
	@Column
	private String reference;
	@Column
	private String mdccode;
	@Column
	private String effectivedatetime;
	@Column
	private long effectiveTime;
	@Column
	private double period;
	@Column
	private int dimensions;
	@Column
	private String data;
	@Column
	private String devicereference;
	@Column
	private double factor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMdccode() {
		return mdccode;
	}

	public void setMdccode(String mdccode) {
		this.mdccode = mdccode;
	}

	public String getEffectivedatetime() {
		return effectivedatetime;
	}

	public void setEffectivedatetime(String effectivedatetime) {
		this.effectivedatetime = effectivedatetime;
	}

	public double getPeriod() {
		return period;
	}

	public void setPeriod(double period) {
		this.period = period;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDevicereference() {
		return devicereference;
	}

	public void setDevicereference(String devicereference) {
		this.devicereference = devicereference;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}
	public long getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(long effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

}
