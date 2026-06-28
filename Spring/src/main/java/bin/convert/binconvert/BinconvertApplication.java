package bin.convert.binconvert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"}, allowedHeaders = "*")
@RestController
@RequestMapping("/api")
@SpringBootApplication
public class BinconvertApplication {

	@RequestMapping("/")
	String home() {
		return "Welcome to the Binary COnverter";
	}

	@PostMapping("/get-data")
    public ResponseEntity<ValueResponse<Number>> recieveDataFromFrontend(@RequestBody DataRequest request) {
        System.out.println("Recieved value: " + request.getData());
        System.out.println("Recieved fmt:" + request.getToFmt());
        try {
            String input = request.getData();

            String convertedValue = convertValue(input, request.getToFmt());
            return ResponseEntity.ok(new ValueResponse<Number>(convertedValue, request.getToFmt()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bad news sailor!");
            return ResponseEntity.badRequest().build();
        }

    }

	public String convertValue(String input, String toFmt) {
        if (toFmt == null) {
            return "this operation is not valid. Please try again";
        }

        else if ("base10".equalsIgnoreCase(toFmt)) {
            String newVal = BinaryCOnverter.toDecimal(input);
            return String.valueOf(newVal);
        }

        else if ("binary".equalsIgnoreCase(toFmt) || "decimal".equalsIgnoreCase(toFmt) || "deciaml".equalsIgnoreCase(toFmt)) {
            int converted = Integer.parseInt(input);
            return BinaryCOnverter.toBinary(converted);
        }

        return "this operation is not valid. Please try again";
    }




	public static void main(String[] args) {
		SpringApplication.run(BinconvertApplication.class, args);
	}

}
