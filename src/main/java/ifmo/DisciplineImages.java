package ifmo;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Named
@ApplicationScoped
public class DisciplineImages {
    @EJB
    private DisciplineService service;

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String disciplineId = context.getExternalContext().getRequestParameterMap().get("id");
            Discipline discipline = service.findById(Long.valueOf(disciplineId));
            return new DefaultStreamedContent(new ByteArrayInputStream(discipline.getImage()));
        }
    }
}




