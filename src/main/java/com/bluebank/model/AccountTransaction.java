package main.java.com.bluebank.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TBL_ACCOUNT_TRANSACTIONS")
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACC_TRANS_ID")
	private Long id;
	@Version
	private Long version;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private Calendar transactionDate;
	private String accNumberTo;
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "ACCOUNT_FROM_ID", referencedColumnName = "ACCOUNT_ID")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private String accNumberFrom;

	public AccountTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountTransaction(BigDecimal amount, Calendar transactionDate, String accNumberTo, String accNumberFrom) {
		super();
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.accNumberTo = accNumberTo;
		this.accNumberFrom = accNumberFrom;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Calendar getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccNumberTo() {
		return accNumberTo;
	}

	public void setAccNumberTo(String accNumberTo) {
		this.accNumberTo = accNumberTo;
	}

	public String getAccNumberFrom() {
		return accNumberFrom;
	}

	public void setAccNumberFrom(String accNumberFrom) {
		this.accNumberFrom = accNumberFrom;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AccountTransaction [id=" + id + ", version=" + version + ", amount=" + amount + ", transactionDate="
				+ transactionDate + ", accNumberTo=" + accNumberTo + ", accNumberFrom=" + accNumberFrom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNumberFrom == null) ? 0 : accNumberFrom.hashCode());
		result = prime * result + ((accNumberTo == null) ? 0 : accNumberTo.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountTransaction other = (AccountTransaction) obj;
		if (accNumberFrom == null) {
			if (other.accNumberFrom != null)
				return false;
		} else if (!accNumberFrom.equals(other.accNumberFrom))
			return false;
		if (accNumberTo == null) {
			if (other.accNumberTo != null)
				return false;
		} else if (!accNumberTo.equals(other.accNumberTo))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
