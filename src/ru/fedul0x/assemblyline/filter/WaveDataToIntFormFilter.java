package ru.fedul0x.assemblyline.filter;

import ru.fedul0x.assemblyline.filter.target.WaveIntDataFilterTarget;
import java.util.Arrays;
import ru.fedul0x.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.assemblyline.filter.target.WaveDataFilterTarget;

/**
 * Фильтр для преобразования {@code WaveData} в целочисленную форму
 *
 * @author Ivashin Alexey
 */
public class WaveDataToIntFormFilter extends Filter<WaveDataFilterTarget, WaveIntDataFilterTarget> {

    public WaveDataToIntFormFilter() {
        super();
        
    }
    public WaveDataToIntFormFilter(WaveDataFilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        super(initData);
    }

    @Override
    public boolean filtrate() {
        byte[] data = initData.data;
//        filtratedData = new WaveIntDataFilterTarget();
        int[] intData = filtratedData.data;
        if (data != null) {
            if (initData.audioFormat.getSampleSizeInBits() == 16) {
                long nlengthInSamples= data.length / 2;
                filtratedData.dataLength = nlengthInSamples;
                
                intData = new int[(int) nlengthInSamples];
                if (initData.audioFormat.isBigEndian()) {
                    for (int i = 0; i < nlengthInSamples; i++) {
                        int MSB = (int) data[2 * i];
                        int LSB = (int) data[2 * i + 1];
                        intData[i] = MSB << 8 | (255 & LSB);
                    }
                } else {
                    for (int i = 0; i < nlengthInSamples; i++) {
                        int LSB = (int) data[2 * i];
                        int MSB = (int) data[2 * i + 1];
                        intData[i] = MSB << 8 | (255 & LSB);
                    }
                }
            } else if (initData.audioFormat.getSampleSizeInBits() == 8) {
                int nlengthInSamples = data.length;
                intData = new int[nlengthInSamples];
                if (initData.audioFormat.getEncoding().toString().startsWith("PCM_SIGN")) {
                    for (int i = 0; i < data.length; i++) {
                        intData[i] = data[i];
                    }
                } else {
                    for (int i = 0; i < data.length; i++) {
                        intData[i] = data[i] - 128;
                    }
                }
            }
        }
        return true;
    }
}
