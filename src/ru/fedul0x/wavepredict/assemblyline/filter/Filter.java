package ru.fedul0x.wavepredict.assemblyline.filter;

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
public abstract class Filter<InitType extends FilterTarget, FiltratedType extends FilterTarget> {

    public Filter() {
        try {
            filtratedData = (FiltratedType) getFiltratedType().newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//TODO Убрать исключения
    //Что значит final метод?
    public Filter(InitType initData) throws InvalidFilterTargetTypeException, NullFilterException {
        try {
            filtratedData = (FiltratedType) getFiltratedType().newInstance();
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
    protected InitType initType = null;
    /*
     * Ссылка на результат
     */
    protected FiltratedType filtratedData = null;
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
//        if (wdo instanceof initType) {
//            throw new InvalidFilterTargetTypeException("Невеный тип исходных данных");
//        }
        this.initType = (InitType) initData;
    }

    public FilterTarget getInitData() {
        return initType;
    }

    public FilterTarget getFiltrateData() {
        return filtratedData;
    }

    public final boolean process() throws Exception {
        int n = initType.getStorageLength();
        int fn = filtratedData.getStorageLength();
        if (n> fn) {
            for (int i = 0; i < n - fn; i++) {
                filtratedData.addArgument(filtratedData.getStorageType().newInstance());
            }
        }
        for (int i = 0; i < n; i++) {

            filtrate(initType.getStorage(i), filtratedData.getStorage(i));
        }
        filtrateAll(initType, filtratedData);
        return true;
    }

    //TODO Как бы добавить сюда проверку типа или приведение типа, т.к. в filtrate приведется приводить
    protected abstract boolean filtrate(Object initStorage, Object filtratedStorage) throws Exception;

    protected abstract boolean filtrateAll(InitType initData, FiltratedType filtratedData) throws Exception;
}
