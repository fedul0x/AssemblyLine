package ru.fedul0x.wavepredict.assemblyline.filter.target;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class for representarion result of filter work
 *
 * Абстрактная сущность для предоставления результатов работы фильтра {@code Filter},
 * наследуется для того, чтобы фильтр мог получить исходные данные для своих
 * вычислений и отдать свои данные обратно в конвеер
 *
 * @author Ivashin Alexey
 */
public abstract class FilterTarget<DataStorage> {

    protected List<DataStorage> dataStorages = new LinkedList();
    protected List<Boolean> isProcessed = new LinkedList();
    protected Boolean finished = false;
    private int currentStorageNumber = -1;

    public FilterTarget() {
        this.finished = false;
    }

    public <T extends FilterTarget> T addArgument(DataStorage arg) {
        if (arg != null) {
            dataStorages.add(arg);
            isProcessed.add(true);
        } else {
            throw new NullPointerException("Невозможно добавить аргумент со значением null");
        }
        return (T) this;
    }

    public <T extends FilterTarget> T addArgument(DataStorage arg, Boolean enabled) {
        addArgument(arg);
        if (enabled != null && enabled == true) {
            isProcessed.add(true);
        } else {
            isProcessed.add(false);
        }
        return (T) this;
    }

    public <T extends FilterTarget> T removeLastArgument() {
        if (!dataStorages.isEmpty()) {
            dataStorages.remove(dataStorages.size() - 1);
            isProcessed.remove(dataStorages.size() - 1);
        }
        return (T) this;
    }

    public <T extends FilterTarget> T removeArgument(int pos) {
        if (!dataStorages.isEmpty() && pos < dataStorages.size() && pos >= 0) {
            dataStorages.remove(pos);
            isProcessed.remove(pos);
        }
        return (T) this;
    }

    public DataStorage getStorage(int pos) throws IllegalArgumentException {
        if (!dataStorages.isEmpty() && pos < dataStorages.size() && pos >= 0) {
            return dataStorages.get(pos);
        } else {
            throw new IllegalArgumentException("Значение с указанным номером " + String.valueOf(pos) + " не существует");
        }
    }
    public int getStorageLength() throws IllegalArgumentException {
        return dataStorages.size();
    }

    /////////=================
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public DataStorage getCurrentStorage() {
        if (currentStorageNumber != -1) {
            return dataStorages.get(currentStorageNumber);
        } else {
            throw new IllegalArgumentException("Текущего хранилища не назначено");
        }
    }

    public void setCurrentStorageNumber(int pos) throws IllegalArgumentException {
        if (!dataStorages.isEmpty() && pos < dataStorages.size() && pos >= 0) {
            currentStorageNumber = pos;
        } else {
            throw new IllegalArgumentException("Значение с указанным номером " + String.valueOf(pos) + " не существует");
        }
    }

    public int getCurrentStorageNumber() throws IllegalArgumentException {
        return currentStorageNumber;
    }
}
