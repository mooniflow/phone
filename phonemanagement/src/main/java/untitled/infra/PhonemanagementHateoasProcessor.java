package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PhonemanagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Phonemanagement>> {

    @Override
    public EntityModel<Phonemanagement> process(
        EntityModel<Phonemanagement> model
    ) {
        return model;
    }
}
