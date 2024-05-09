package egovframework.msa.sample;

import org.springframework.stereotype.Service;

@Service
public class CustomerApiServiceImpl implements CustomerApiService {
 @Override
 public String getCustomerDetail(String customerId) {
 return customerId;
 }
}