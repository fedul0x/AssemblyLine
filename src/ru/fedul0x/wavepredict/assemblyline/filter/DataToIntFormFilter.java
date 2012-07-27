package ru.fedul0x.wavepredict.assemblyline.filter;

import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.IntDataFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.DataFilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 * Фильтр для преобразования {@code WaveData} в целочисленную форму
 *
 * @author Ivashin Alexey
 */
public class DataToIntFormFilter extends Filter<DataFilterTarget, IntDataFilterTarget> {
    
    public DataToIntFormFilter() {
        super();
        
    }
    
    public DataToIntFormFilter(DataFilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        super(initData);
    }
    
    @Override
    protected boolean filtrate(Object initStorage, Object filtratedStorage) throws UnsupportedAudioFileException, IOException {
        WaveDataObject<Byte> wdo = (WaveDataObject<Byte>) initStorage;
        WaveDataObject<Integer> wdoi = (WaveDataObject<Integer>) filtratedStorage;
        Byte[] data = wdo.data;
        Integer[] intData = wdoi.data;
        if (data != null) {
            if (wdo.audioFormat.getSampleSizeInBits() == 16) {
                long nlengthInSamples = data.length / 2;
                wdoi.dataLength = nlengthInSamples;
                
                intData = new Integer[(int) nlengthInSamples];
                if (wdo.audioFormat.isBigEndian()) {
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
            } else if (wdo.audioFormat.getSampleSizeInBits() == 8) {
                int nlengthInSamples = data.length;
                intData = new Integer[nlengthInSamples];
                if (wdo.audioFormat.getEncoding().toString().startsWith("PCM_SIGN")) {
                    for (int i = 0; i < data.length; i++) {
                        intData[i] = data[i].intValue();
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
    
    @Override
    protected boolean filtrateAll(DataFilterTarget initData, IntDataFilterTarget filtratedData) throws Exception {
        return true;
    }
}
