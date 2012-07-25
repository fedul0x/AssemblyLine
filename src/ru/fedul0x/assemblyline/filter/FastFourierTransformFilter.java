package ru.fedul0x.assemblyline.filter;

import ru.fedul0x.assemblyline.filter.target.WaveIntDataFilterTarget;

/**
 * Фильтр для осуществления быстрого преобразования Фурье
 *
 * @author Ivashin Alexey
 */
public class FastFourierTransformFilter extends Filter<WaveIntDataFilterTarget, WaveIntDataFilterTarget> {

    @Override
    public boolean filtrate() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
