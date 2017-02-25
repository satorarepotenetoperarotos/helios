package ifmo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

@Named
@ManagedBean
@ViewScoped
@RequestScoped
public class ListDisciplineBean {
    private List<Discipline> disciplinesList;

    @EJB
    DisciplineService disciplineService;

    @PostConstruct
    public void init() {
        disciplinesList = disciplineService.findAll();
    }

    public void delete(Long id) {
        disciplineService.delete(id);
        disciplinesList = disciplineService.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Запись удалена", null));
    }

    public void setDisciplinesList(List<Discipline> disciplineList) {
        this.disciplinesList = disciplineList;
    }

    public List<Discipline> getDisciplinesList() {
        return disciplinesList;
    }

}