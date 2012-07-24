package ru.fedul0x.assemblyline.filter;

import ru.fedul0x.assemblyline.filter.target.FilterTarget;
import ru.fedul0x.assemblyline.filter.component.FilterViewComponent;
import ru.fedul0x.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.assemblyline.filter.exception.NullFilterException;

/**
 * Filter for data processing
 *
 * Абстрактная сущность фильтра для обработки данных
 *
 * @author Ivashin Alexey
 */
//TODO Передавать тип исходных и фильтрованных данных через джинерик???
//TODO Входные и выходные данные на основе делегирования
public abstract class Filter<initType extends FilterTarget, filtrateType extends FilterTarget> {
    /*
     * Ссылка на исходные данные
     */

    private initType initData;
    /*
     * Ссылка на результат
     */
    private filtrateType filtratedData;
    
    /*
     * Компоненты для отображения результатов работы фильтра
     */
    private FilterViewComponent view;

    public void Filter() {
    }

    public Class getFiltratedType() {
        return filtratedData.getClass();
    }

    public Class getInitType() {
        return initData.getClass();
    }

    public void setInitData(FilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        if (initData == null) {
            throw new NullFilterException("Значение null не может быть использовано в качестве исходных данных");
        }
        //TODO Добавить проверку на корректность типа исходных данных
//        if (initData instanceof initType) {
//            throw new InvalidFilterTargetTypeException("Невеный тип исходных данных");
//        }
        this.initData = (initType) initData;
    }

    public FilterTarget getFiltrateData() {
        return filtratedData;
    }

    public abstract boolean filtrate();
}
