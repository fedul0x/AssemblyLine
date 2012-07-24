package ru.fedul0x.assemblyline.conveyor;

import java.util.LinkedList;
import java.util.List;
import ru.fedul0x.assemblyline.filter.Filter;
import ru.fedul0x.assemblyline.filter.FilterTarget;
import ru.fedul0x.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.assemblyline.filter.exception.NullFilterException;

/**
 * Conveyor for filter grouping
 *
 * Конвеер предназначен для последовательного соединения нескольких фильтров
 * воедино
 *
 * @author Ivashin Alexey
 */
public class Conveyor {
    /*
     * Список для хранения всех фильтрво конвеера
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

    Conveyor addFilter(Filter filter) throws NullFilterException, InvalidFilterTargetTypeException {
        if (filter == null) {
            throw new NullFilterException("Недопустимо использование значения null");
        }
        if (last == null) {
            filters.add(filter);

        }
        if (last.getFiltratedType() == filter.getInitType()) {
            filters.add(filter);
        } else {
            throw new InvalidFilterTargetTypeException("Неверные типы для соединяемых фильтров");
        }
        last = filter;
        return this;
    }
    /*
     * Добавление фильтра на позицию {@code position} в конвеер
     */

    Conveyor addFilter(Filter filter, int position) throws NullFilterException, InvalidFilterTargetTypeException, UnsupportedOperationException {
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

    public FilterTarget start(FilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        if (filters.isEmpty()) {
            return initData;
        }
        FilterTarget buf = initData;
        for (int i = 0; i < filters.size(); i++) {
            filters.get(i).setInitData(buf);
            if (filters.get(i).filtrate()) {
                buf = filters.get(i).getFiltrateData();
            } else {
                //TODO Добавить выброс исключения для случая, когда один из конвееров отработал с ошибкой
                break;
            }
        }
        return filters.get(filters.size() - 1).getFiltrateData();
    }
    //TODO добавить unit-tests
}
