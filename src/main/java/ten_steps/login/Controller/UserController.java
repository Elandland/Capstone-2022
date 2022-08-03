package ten_steps.login.Controller;

import ten_steps.login.dto.ResponseDTO;
import ten_steps.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tensteps/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("completeAll");
        responseDTO.setRes(userService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "findOne", method  = RequestMethod.POST)
    public ResponseEntity<?> findOne(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("completeOne");
        responseDTO.setRes(userService.findOne());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}

