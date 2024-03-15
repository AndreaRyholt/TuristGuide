package tourism;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tourism.controller.TouristController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TuristGuideApplicationTests {



	@Autowired //skal der Autowired før alle klasserne, eller kan man skrive dem alle herunder?
	private TouristController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
