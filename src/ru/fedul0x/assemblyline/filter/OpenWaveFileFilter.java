package ru.fedul0x.assemblyline.filter;

import ru.fedul0x.assemblyline.filter.target.FileNameFilterTarget;
import ru.fedul0x.assemblyline.filter.target.FilterTarget;

/**
 * Фильтр для открытия wav-файла
 * 
 * @author Ivashin Alexey
 */
public class OpenWaveFileFilter extends Filter<FileNameFilterTarget, FilterTarget>{

    @Override
    public boolean filtrate() {
        //TODO Добавить действие по открытию wav-файла и помещения его в результат работы фильтра
        return true;
        
    }
    
    
}
