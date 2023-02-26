package cho.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user")

public class User {
	
	@Id
	@Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "user_mail")
	private String userMail;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;

}