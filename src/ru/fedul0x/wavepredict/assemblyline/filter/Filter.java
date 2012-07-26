package ru.fedul0x.wavepredict.assemblyline.filter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.component.FilterViewComponent;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.common.reflection.ReflectionUtils;

/**
 * Filter for data processing
 *
 * Абстрактная сущность фильтра для обработки данных
 *
 * @author Ivashin Alexey
 */
//TODO Входные и выходные данные на основе делегирования???
public abstract class Filter<initType extends FilterTarget, filtratedType extends FilterTarget> {

    public Filter() {
        try {
            filtratedData = (filtratedType) getFiltratedType().newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//TODO Убрать исключения
    //Что значит final метод?
    public Filter(initType initData) throws InvalidFilterTargetTypeException, NullFilterException {
        try {
            filtratedData = (filtratedType) getFiltratedType().newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
        setInitData(initData);
        
    }
    /*
     * Ссылка на исходные данные
     */
    protected initType initData = null;
    /*
     * Ссылка на результат
     */
    protected filtratedType filtratedData = null;
    /*
     * Компоненты для отображения результатов работы фильтра???
     */
    private FilterViewComponent view;

    public void Filter() {
    }

    public Class getInitType() {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), 0);
    }

    public Class getFiltratedType() {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), 1);
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

    public FilterTarget getInitData() {
        return initData;
    }

    public FilterTarget getFiltrateData() {
        return filtratedData;
    }

    public abstract boolean filtrate() throws Exception;
}
