package Issue;
import java.util.Date;

public class Issue {
	
	private String name;
	private String description;
	private Date deliveryDate;
	private Integer points;
	private Date assignedDate;
	
	public Issue(String name, String description, Date deliveryDate, Integer points) {
		this.setName(name);
		this.setDescription(description);
		this.setDeliveryDate(deliveryDate);
		this.setPoints(points);
		this.setAssignedDate(new Date());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
}
