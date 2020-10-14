package academyapi.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BugJira {
	private Map<String, Object> fields = new HashMap<String, Object>();
	private Map<String, Object> fields2 = new HashMap<String, Object>();
	private String key;
	private String summary;
	private String description;
	private String name;
	private Map<String,Object> project= new HashMap<String, Object>();
	private Map<String,Object>issueType = new HashMap<String, Object>();
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Map<String,Object> getFields2() {
		return fields2;
	}
	public void setFields() {
		fields.put("project", project);
		fields.put("summary", summary);
		fields.put("description", description);
		fields.put("issuetype", issueType);
		
	}
	public void setFields(String body) {
		fields.put("fields", body);
	
	}
	
	public void setFields2() {
		fields2.put("fields", fields);
		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Map<String,Object> getIssueType() {
		return issueType;
	}
	public void setIssueType() {
	  issueType.put("name", name);
	}
	public Map<String,Object> getProject() {
		return project;
	}
	public void setProject() {
		project.put("key", key);
		
	}
	
	

}
