package tw.com.fcb.mimosa.examples.gettingstarted;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor

//@Data都已含上面這些
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


//對應db的某個table
@Entity
//預設的table名字 如class MyUser(my_user)
@Table(name = "USER")

public class User {
	@Id
	@GeneratedValue
	Long id;
	//設定欄位名稱
	@Column(name = "user_name")
    String name;
    int age;
    

    
    
}
