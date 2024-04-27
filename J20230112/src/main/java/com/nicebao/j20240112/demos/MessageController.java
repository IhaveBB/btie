package com.nicebao.j20240112.demos;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
	private List<MessageInfo> messageInfos = new ArrayList<>();
	@RequestMapping("/publish")
	public boolean publishMessage(MessageInfo messageInfo ){
		if(!StringUtils.hasLength(messageInfo.getFrom())
		|| !StringUtils.hasLength(messageInfo.getMessage() )
		|| !StringUtils.hasLength(messageInfo.getTo())){
			return false;
		}
		messageInfos.add(messageInfo);
		return true;
	}
	@RequestMapping("/getList")
	public List<MessageInfo> getList(){

		return messageInfos;
	}
}
