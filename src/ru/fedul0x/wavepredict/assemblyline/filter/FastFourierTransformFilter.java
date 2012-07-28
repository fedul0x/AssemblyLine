package ru.fedul0x.wavepredict.assemblyline.filter;

import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FloatDataFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;

/**
 * Фильтр для осуществления быстрого преобразования Фурье
 *
 * @author Ivashin Alexey
 */
public class FastFourierTransformFilter extends Filter<IntDataFilterTarget, FloatDataFilterTarget> {

    public FastFourierTransformFilter() {
        super();
    }

    public FastFourierTransformFilter(IntDataFilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        super(initData);
    }

    @Override
    protected boolean filtrate(Object initStorage, Object filtratedStorage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean filtrateAll(IntDataFilterTarget initData, FloatDataFilterTarget filtratedData) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
