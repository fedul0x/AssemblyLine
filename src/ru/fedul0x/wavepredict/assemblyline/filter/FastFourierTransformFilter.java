package ru.fedul0x.wavepredict.assemblyline.filter;

import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;

/**
 * Фильтр для осуществления быстрого преобразования Фурье
 *
 * @author Ivashin Alexey
 */
public class FastFourierTransformFilter extends Filter<IntDataFilterTarget, IntDataFilterTarget> {

    @Override
    public boolean filtrate() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
