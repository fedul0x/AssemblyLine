package ru.fedul0x.assemblyline.filter.target;

/**
 * Abstract class for representarion result of filter work
 * 
 * Абстрактная сущность для предоставления результатов работы фильтра, 
 * наследуется для того, чтобы фильтр мог получить исходные данные для своих вычислений
 * и отдать свои данные обратно в конвеер
 * @author Ivashin Alexey
 */
public abstract class FilterTarget {

    private Boolean finished = false;

    public FilterTarget() {
        this.finished = false;
    }
    

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
