package com.geekq.api.gateway.service.accesscontrol;
import org.springframework.stereotype.Service;

import com.geekq.api.gateway.model.Question;

@Service
public class AccessControlServiceQuestion extends AccessControlServiceUserOwned<Question> {

}