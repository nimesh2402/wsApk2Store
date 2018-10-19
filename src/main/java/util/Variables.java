package util;

public class Variables {
	// Base
	
	String type;
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplication_name() {
		return application_name;
	}

	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	public String getApplication_website() {
		return application_website;
	}

	public void setApplication_website(String application_website) {
		this.application_website = application_website;
	}

	public String[] getApplication_phone_screens() {
		return application_phone_screens;
	}

	public void setApplication_phone_screens(String[] application_phone_screens) {
		this.application_phone_screens = application_phone_screens;
	}

	public String getApplication_phone() {
		return application_phone;
	}

	public void setApplication_phone(String application_phone) {
		this.application_phone = application_phone;
	}

	public String getApplication_email_address() {
		return application_email_address;
	}

	public void setApplication_email_address(String application_email_address) {
		this.application_email_address = application_email_address;
	}

	public String getApplication_privacy_policy() {
		return application_privacy_policy;
	}

	public void setApplication_privacy_policy(String application_privacy_policy) {
		this.application_privacy_policy = application_privacy_policy;
	}

	public String getApplication_short_description() {
		return application_short_description;
	}

	public void setApplication_short_description(String application_short_description) {
		this.application_short_description = application_short_description;
	}

	public String getApplication_full_description() {
		return application_full_description;
	}

	public void setApplication_full_description(String application_full_description) {
		this.application_full_description = application_full_description;
	}

	public String getApplication_icon() {
		return application_icon;
	}

	public void setApplication_icon(String application_icon) {
		this.application_icon = application_icon;
	}

	public String getApplication_email_address_Step2() {
		return application_email_address_Step2;
	}

	public void setApplication_email_address_Step2(String application_email_address_Step2) {
		this.application_email_address_Step2 = application_email_address_Step2;
	}

	public String getApplication_confirm_email_address_Step2() {
		return application_confirm_email_address_Step2;
	}

	public void setApplication_confirm_email_address_Step2(String application_confirm_email_address_Step2) {
		this.application_confirm_email_address_Step2 = application_confirm_email_address_Step2;
	}

	public String getApplication_category_Step2() {
		return application_category_Step2;
	}

	public void setApplication_category_Step2(String application_category_Step2) {
		this.application_category_Step2 = application_category_Step2;
	}

	String user_id;	
	String id;

	// Step 1

	String application_name="";
	String application_website="";
	String[] application_phone_screens;
	String application_phone;
	String application_email_address;
	String application_privacy_policy;
	String application_short_description;
	String application_full_description;
	String application_icon;
	public String getApplication_type() {
		return application_type;
	}

	public void setApplication_type(String application_type) {
		this.application_type = application_type;
	}

	public String getApplication_category() {
		return application_category;
	}

	public void setApplication_category(String application_category) {
		this.application_category = application_category;
	}

	public String getApplication_banner() {
		return application_banner;
	}

	public void setApplication_banner(String application_banner) {
		this.application_banner = application_banner;
	}

	String application_type;
	String application_category;
	String application_banner;
	
	
	// Step 2
	String application_email_address_Step2;
	String application_confirm_email_address_Step2;
	String application_category_Step2;

public Variables() {
	
}





public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
}
