package ru.fedul0x.assemblyline.filter;

import ru.fedul0x.assemblyline.filter.component.FilterViewComponent;
import ru.fedul0x.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.assemblyline.filter.exception.NullFilterException;

/**
 * Filter for data processing
 * 
 * Абстрактная сущность фильтра для обработки данных
 * @author Ivashin Alexey
 */
//TODO Передавать тип исходных и фильтрованных данных через джинерик???

//TODO Входные и выходные данные на основе делегирования
public abstract class Filter {
    /*
     * Ссылка на исходные данные
     */
    private FilterTarget initData;
    /*
     * Тип исходных данных
     */
    private Class initType;
    /*
     * Ссылка на результат
     */
    private FilterTarget filtratedData;
    /*
     * Тип результата
     */
    private Class filtratedType;
    /*
     * Компоненты для отображения результатов работы фильтра
     */
    private FilterViewComponent view;   

    public void Filter() {
    }

    public Class getFiltratedType() {
        return filtratedType;
    }

    public void setFiltratedType(Class filtratedType) throws NullFilterException {
        if (filtratedType == null)
            throw new NullFilterException("Значение типа null не может быть использовано в качестве типа результата");
        this.filtratedType = filtratedType;
    }

    public Class getInitType() {
        return initType;
    }

    public void setInitType(Class initType) throws NullFilterException {
        if (initType == null)
            throw new NullFilterException("Значение типа null не может быть использовано в качестве типа исходных данных");
        this.initType = initType;
    }

    public void setInitData(FilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        if (initData == null)
            throw new NullFilterException("Значение null не может быть использовано в качестве исходных данных");
        //TODO Добавить проверку на корректность типа исходных данных
//        if (initData instanceof initType) {
//            throw new InvalidFilterTargetTypeException("Невеный тип исходных данных");
//        }
        this.initData = initData;
    }

    public FilterTarget getFiltrateData() {
        return filtratedData;
    }
    
    public abstract boolean filtrate();
    
}
