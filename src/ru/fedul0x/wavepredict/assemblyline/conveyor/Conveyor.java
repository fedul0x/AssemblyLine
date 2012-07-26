package ru.fedul0x.wavepredict.assemblyline.conveyor;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.fedul0x.assemblyline.filter.Filter;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;

/**
 * Conveyor for filter grouping
 *
 * Конвеер предназначен для последовательного соединения нескольких фильтров
 * воедино
 *
 * @author Ivashin Alexey
 */
//TODO Добавить разветвление и объединение потоков фильтров (конвеер конвееров, те (-----([=====])----)) , где круглые скобки - отдельные конвейеры фильтры
public class Conveyor {
    /*
     * Список для хранения всех фильтров конвейера
     */

    private List<Filter> filters = new LinkedList<>();
    /*
     * Последний элемент списка, для более эффективного добавления фильтров
     */
    private Filter last = null;

    public Conveyor() {
    }
    /*
     * Добавление фильтра в конец конвеера
     */

    public Conveyor addFilter(Filter filter) throws NullFilterException, InvalidFilterTargetTypeException {
        if (filter == null) {
            throw new NullFilterException("Недопустимо использование значения null");
        }
        if (last == null) {
            filters.add(filter);
            last = filter;
            return this;
        }
        if (last.getFiltratedType() == filter.getInitType()) {
            filters.add(filter);
        } else {
            throw new InvalidFilterTargetTypeException("Неверные типы для соединяемых фильтров");
        }
        last = filter;
        return this;
    }
    /**
     * Добавление фильтра на позицию {@code position} в конвеер
     */

    public Conveyor addFilter(Filter filter, int position) throws NullFilterException, InvalidFilterTargetTypeException, UnsupportedOperationException {
        if (position >= 0) {
            throw new UnsupportedOperationException("Not yet implement");
        }

        //TODO Проверять аргумент position на превышение размера
//        if (position >= 0) {
        //TODO Вставить исключение типа "неверный аргумент"
        //throw new 
//        }
        if ((last == null) || (position == filters.size() - 1)) {
            addFilter(filter);
            return this;
        }
        Filter next = filters.get(position);
        Filter prev = null;
        if (position - 1 >= 0) {
            prev = filters.get(position - 1);
        }
        if (prev == null) {
            if (filter.getFiltratedType() == next.getInitType()) {
                filters.add(position, filter);
            } else {
                throw new InvalidFilterTargetTypeException("Неверные типы для соединяемых фильтров");
            }
        } else if ((filter.getFiltratedType() == next.getInitType()) && (prev.getFiltratedType() == filter.getInitType())) {
            filters.add(position, filter);
        } else {
            throw new InvalidFilterTargetTypeException("Неверные типы для соединяемых фильтров");
        }
        return this;
    }

    //TODO Добавить функциональность по удалению фильтра по его номеру
    public void removeFilter(int position) {
        throw new UnsupportedOperationException("Not yet implement");
    }
    /*
     * Зупускает конвейер без исходных данных для первого фильтра
     */
//TODO Добавить проверку первого фильтра на наличие исходных данных
    
    public FilterTarget start() throws InvalidFilterTargetTypeException, NullFilterException {
        if (filters.isEmpty()) {
            return null;
        }
        
        FilterTarget buf = filters.get(0).getInitData();
        for (int i = 0; i < filters.size(); i++) {
            filters.get(i).setInitData(buf);
            try {
                if (filters.get(i).filtrate()) {
                    buf = filters.get(i).getFiltrateData();
                } else {
                    //TODO Добавить выброс исключения для случая, когда один из конвееров отработал с ошибкой
                    break;
                }
            } catch (Exception ex) {
                //TODO Изменить реакцию на исключительную ситуацию
                Logger.getLogger(Conveyor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filters.get(filters.size() - 1).getFiltrateData();
    } 
    
    /*
     * Зупускает конвейер с исходными данными для первого фильтра в конвейере
     */
    public FilterTarget start(FilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        if (filters.isEmpty()) {
            return initData;
        }
        FilterTarget buf = initData;
        for (int i = 0; i < filters.size(); i++) {
            filters.get(i).setInitData(buf);
            try {
                if (filters.get(i).filtrate()) {
                    buf = filters.get(i).getFiltrateData();
                } else {
                    //TODO Добавить выброс исключения для случая, когда один из конвееров отработал с ошибкой
                    break;
                }
            } catch (Exception ex) {
                //TODO Изменить реакцию на исключительную ситуацию
                Logger.getLogger(Conveyor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filters.get(filters.size() - 1).getFiltrateData();
    }
    //TODO добавить unit-tests
}
