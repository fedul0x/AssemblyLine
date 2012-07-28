package ru.fedul0x.wavepredict.assemblyline.filter;

import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FloatDataFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 * Linear Correlation Coefficient filter
 *
 * @author Ivashin Alexey
 */
public class LinearCorrelationCoefficientFilter extends Filter<IntDataFilterTarget, FloatDataFilterTarget> {

    public LinearCorrelationCoefficientFilter() {
        super();
    }

    public LinearCorrelationCoefficientFilter(IntDataFilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        super(initData);
    }

    @Override
    protected boolean filtrate(Object initStorage, Object filtratedStorage) throws Exception {
        return true;
    }

    @Override
    protected boolean filtrateAll(IntDataFilterTarget initData, FloatDataFilterTarget filtratedData) throws Exception {
        WaveDataObject<Integer> pattern = (WaveDataObject<Integer>) initData.getStorage(0);
        WaveDataObject<Integer> other;
        float xAvr = averageCalculation(pattern.data, pattern.dataLength);
        float x, y;
        for (int i = 1; i < initData.getStorageLength(); i++) {
            other = (WaveDataObject<Integer>) initData.getStorage(i);
            long coeffNum = other.dataLength - pattern.dataLength + 1;
            filtratedData.getStorage(i).data = new Float[(int) coeffNum];
            filtratedData.getStorage(i).dataLength = coeffNum;
            float yAvr = averageCalculation(other.data, other.dataLength);
            for (int k = 0; k < coeffNum; k++) {
                float numerator = 0;
                float den_1 = 0;
                float den_2 = 0;
                float denominator = 0;
                float coeff = 0;
                for (int j = 0; j < pattern.dataLength; j++) {
                    x = pattern.data[j];
                    y = other.data[j + k];
                    numerator = numerator + (x - xAvr) * (y - yAvr);
                    den_1 = (float) (den_1 + Math.pow(x - xAvr, 2));
                    den_2 = (float) (den_2 + Math.pow(y - yAvr, 2));
                }
                denominator = (float) Math.sqrt(den_1 * den_2);
                coeff = (float) (numerator / denominator);
                filtratedData.getStorage(i).data[k] = coeff;
            }
        }
        return true;
    }

    private float averageCalculation(Integer[] data, long length) {
        float avr = 0;
        for (int i = 0; i < length; i++) {
            avr += data[i];
        }
        return avr / length;

    }
}
