package ru.fedul0x.wavepredict.assemblyline.filter;

import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;

/**
 * Фильтр для осуществления быстрого преобразования Фурье
 *
 * @author Ivashin Alexey
 */
public class FastFourierTransformFilter extends Filter<IntDataFilterTarget, IntDataFilterTarget> {

    @Override
    protected boolean filtrate(Object initStorage, Object filtratedStorage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean filtrateAll(IntDataFilterTarget initData, IntDataFilterTarget filtratedData) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
