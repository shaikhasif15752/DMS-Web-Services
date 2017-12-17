package com.admin.serv;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dao.ChangePasswordDAO;
import com.dev.mgm.bean.Admin;

@RestController
@RequestMapping("/AdminService")
public class ChangePasswordService {
	
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	public  void changePassword(@RequestBody Admin admin) {
		
		ChangePasswordDAO changePasswordDAO=new ChangePasswordDAO();
		changePasswordDAO.changePassword(admin);
	}
	/*@RequestMapping(value="/changepassword/view",method=RequestMethod.GET)
	public Admin changePass() {
		
		System.out.println("Working");
		ChangePasswordDAO changePasswordDAO=new ChangePasswordDAO();
		return new Admin();
	}
*/

}
