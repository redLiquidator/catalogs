package egovframework.msa.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogs")
public class CatalogsController {
	private static final Logger log = LoggerFactory.getLogger(CatalogsController.class);
	@Autowired
	public CustomerApiService customerApiService;

	public CatalogsController(CustomerApiService customerApiService) {
		this.customerApiService = customerApiService;
	}

	@GetMapping(path = "/customerinfo/{customerId}")
	public String getCustomerInfo(@PathVariable String customerId) {
		String customerInfo = customerApiService.getCustomerDetail(customerId);
		log.info("response customerInfo : " + customerInfo);
		return String.format("[Customer id = %s at %s %s ]", customerId, System.currentTimeMillis(), customerInfo);
	}
}
