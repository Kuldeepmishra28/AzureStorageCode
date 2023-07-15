package nagarro.exitassignment.productCatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nagarro.exitassignment.productCatalogue.model.Pincode;
import nagarro.exitassignment.productCatalogue.model.Product;
import nagarro.exitassignment.productCatalogue.repo.PinCodeRepository;
import nagarro.exitassignment.productCatalogue.repo.ProductRepository;

@SpringBootApplication
public class ProductCatalogueApplication implements CommandLineRunner{

	
		
		@Autowired
		private ProductRepository productRepository;
		
		@Autowired
		private PinCodeRepository pincodeRepository;
		
		public void productData() {
			String[] img = {
					"https://rukminim1.flixcart.com/image/312/312/xif0q/mobile/k/t/2/11-pro-5g-rmx3771-realme-original-imagq6aszgmb4xja.jpeg?q=70",
					"https://rukminim1.flixcart.com/image/832/832/kp5sya80/screen-guard/tempered-glass/o/v/n/apple-macbook-air-m1-13-3-inch-lightwings-original-imag3gh5xftgbpg3.jpeg?q=70",
					"https://rukminim1.flixcart.com/image/312/312/xif0q/mobile/y/z/r/-original-imagkp8yzvqffyhc.jpeg?q=70",
					"https://rukminim1.flixcart.com/image/312/312/xif0q/mobile/0/3/4/-original-imagz3cuyhmc45pc.jpeg?q=70",
					"https://rukminim1.flixcart.com/image/312/312/xif0q/mobile/9/j/r/-original-imagjyhyaf7tdxnc.jpeg?q=70",
					};
			String[] name = {"Realme lite","Apple 2023 Macbook","Realme 10 Pro","Infinix series","Redmi A1"};
			String[] desc = {
					"\n"
					+ "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB\n"
					+ "16.0 cm (6.3 inch) Full HD+ Display\n"
					+ "16MP + 5MP | 25MP Front Camera\n"
					+ "4045 mAh Battery\n"
					+ "Qualcomm Snapdragon 710 Octa Core 2.2 GHz AIE Processor\n"
					+ "Dual Nano SIM Slot and Memory Card Slot\n"
					+ "VOOC Flash Charge 3.0",
					"\n"
					+ "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB\n"
					+ "16.0 cm (6.3 inch) Full HD+ Display\n"
					+ "16MP + 5MP | 25MP Front Camera\n"
					+ "4045 mAh Battery\n"
					+ "Qualcomm Snapdragon 710 Octa Core 2.2 GHz AIE Processor\n"
					+ "Dual Nano SIM Slot and Memory Card Slot\n"
					+ "VOOC Flash Charge 3.0",
					"\n"
					+ "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB\n"
					+ "16.0 cm (6.3 inch) Full HD+ Display\n"
					+ "16MP + 5MP | 25MP Front Camera\n"
					+ "4045 mAh Battery\n"
					+ "Qualcomm Snapdragon 710 Octa Core 2.2 GHz AIE Processor\n"
					+ "Dual Nano SIM Slot and Memory Card Slot\n"
					+ "VOOC Flash Charge 3.0",
					"\n"
					+ "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB\n"
					+ "16.0 cm (6.3 inch) Full HD+ Display\n"
					+ "16MP + 5MP | 25MP Front Camera\n"
					+ "4045 mAh Battery\n"
					+ "Qualcomm Snapdragon 710 Octa Core 2.2 GHz AIE Processor\n"
					+ "Dual Nano SIM Slot and Memory Card Slot\n"
					+ "VOOC Flash Charge 3.0",
					"\n"
					+ "4 GB RAM | 64 GB ROM | Expandable Upto 256 GB\n"
					+ "16.0 cm (6.3 inch) Full HD+ Display\n"
					+ "16MP + 5MP | 25MP Front Camera\n"
					+ "4045 mAh Battery\n"
					+ "Qualcomm Snapdragon 710 Octa Core 2.2 GHz AIE Processor\n"
					+ "Dual Nano SIM Slot and Memory Card Slot\n"
					+ "VOOC Flash Charge 3.0",
					};
			String[] brand = {"Realme","Apple","Realme","Infinix","Redmi"};
			String[] price = {"18,500 Rs.","75,000 Rs.","22,000","23,000 Rs.","17000.00 Rs."};

			for(int i=0;i<brand.length;i++) {
				Product product = new Product(i+1,img[i],name[i],desc[i],brand[i],price[i]);
				System.out.println(product.toString());
				productRepository.save(product);
			
			}
		}
		
		public void createPincode() {
			int[] pcode = {215015,215016,215017,215018,215019,215020,215021,215022,215023,215024};
			int[] dist = {15,25,35,45,55,65,75,85,95,105};
			
			for(int i=0;i<10;i++) {
				Pincode pincode = new Pincode(pcode[i],dist[i]);
				pincodeRepository.save(pincode);
			}
		}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productData();	
		createPincode();
	}

}
