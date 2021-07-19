
package beans.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable{
    
    private String name;
    private List<TaskBean> tasks;

    public UserBean() {
        this.tasks = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tasks
     */
    public List<TaskBean> getTasks() {
        return tasks;
    }

    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<TaskBean> tasks) {
        this.tasks = tasks;
    }
    
    public void addTask(TaskBean t){
        this.tasks.add(t);
    }
    
    public void removeTask(int index){
        if(index>=0 && index<=this.tasks.size())
            this.tasks.remove(index);
    }
    
}
