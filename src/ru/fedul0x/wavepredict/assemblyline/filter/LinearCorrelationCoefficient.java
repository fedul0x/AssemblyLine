package ru.fedul0x.wavepredict.assemblyline.filter;

import ru.fedul0x.wavepredict.assemblyline.filter.target.FloatDataFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 * Linear Correlation Coefficient
 *
 * @author Ivashin Alexey
 */
public class LinearCorrelationCoefficient extends Filter<IntDataFilterTarget, FloatDataFilterTarget> {

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
            filtratedData.addArgument(new WaveDataObject<Float>());
            filtratedData.getStorage(i - 1).data = new Float[(int) coeffNum];
            filtratedData.getStorage(i - 1).dataLength = coeffNum;
            float yAvr = averageCalculation(other.data, other.dataLength);
            for (int k = 0; k < coeffNum; k++) {
                float numerator = 0;
                float denominator = 0;
                float coeff = 0;
                for (int j = 0; j < pattern.dataLength; j++) {
                    x = pattern.data[j];
                    y = other.data[j + k];
                    numerator = numerator + (x - xAvr) * (y - yAvr);
                    denominator = (float) (denominator + Math.pow(x - xAvr, 2) * Math.pow(y - yAvr, 2));
                }
                coeff = (float) (numerator / Math.sqrt(denominator));
                filtratedData.getStorage(i - 1).data[k] = coeff;
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
