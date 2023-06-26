package com.scw.module.multitent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(path = "titenant-id")
@Service
public class MultitenantService {
	
	@Value("${tenant.properties.file}")
	private String tenantPath;

	private List<String> dsTenantId = new ArrayList<String>();

	@GetMapping("/_internal")
	public List<String> titenantIds()  {
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(tenantPath));
			TenantProperties[] TenantDatas = gson.fromJson(br, TenantProperties[].class);
			for (TenantProperties tenant : TenantDatas) {
				dsTenantId.add(tenant.getTenantId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTenantId;
	}
	
	public TenantProperties[] titenantDatas() {
		TenantProperties[] TenantDatas = null;
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(tenantPath));
			TenantDatas = gson.fromJson(br, TenantProperties[].class);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TenantDatas;
	}

}
