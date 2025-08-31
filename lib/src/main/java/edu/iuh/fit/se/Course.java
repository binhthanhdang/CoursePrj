package edu.iuh.fit.se;

 /**
 * @description: My Introduction
 * @author: Dang Thanh Binh
 * @version: 1.0
 * @created: Aug 31, 2025 11:41:06 AM
 */
public class Course {
	private int credit;
    private String department, id, title;
    
	public Course() {
		super();
	}
	
	

	/**
	 * @param credit
	 * @param department
	 * @param id
	 * @param title
	 */
	public Course(String id,  String title, int credit, String department) {
		setId(id);
        setTitle(title);
        setCredit(credit);
        setDepartment(department);
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 * @throws IllegalArgumentException
	 */
	public void setCredit(int credit) {
		if(credit <= 0) {
			throw new IllegalArgumentException("Course credit: Credit must be greater than 0");
		}
		this.credit = credit;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 * @throws IllegalArgumentException
	 */
	public void setId(String id) {
		if(id == null || id.length() < 3) {
            throw new IllegalArgumentException("Course id: ID must have at least 3 characters");
        }
        if(!id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Course id: ID must contain only letters or digits");
        }
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 * @throws IllegalArgumentException
	 */
	public void setTitle(String title) {
		if(title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title: Title must not be empty");
        }
		this.title = title;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", credit=" + credit + ", department=" + department + "]";
	}
    
    
    
}
