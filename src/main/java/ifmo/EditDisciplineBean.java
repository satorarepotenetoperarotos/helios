package ifmo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class EditDisciplineBean {
    private Discipline discipline;

    @EJB
    DisciplineService disciplineService;

    private void addMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    @PostConstruct
    public void init() {
        String stringId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        discipline = (stringId != null) ? disciplineService.findById(Long.valueOf(stringId)) : new Discipline();
    }

    public boolean isNewDiscipline() {
        return discipline.getId() == null;
    }

    public void update() {
        discipline = disciplineService.update(discipline);
        addMessage("Запись изменена");
    }

    public void add() {
        discipline = disciplineService.add(discipline);
        addMessage("Запись добавлена");
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}