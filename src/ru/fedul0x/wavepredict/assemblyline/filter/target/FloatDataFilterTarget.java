package ru.fedul0x.wavepredict.assemblyline.filter.target;

import ru.fedul0x.wavepredict.assemblyline.filter.target.FilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 *
 * @author Ivashin Alexey
 */
public class FloatDataFilterTarget extends FilterTarget<WaveDataObject<Float>> {

    public FloatDataFilterTarget() {
    }
    
    public void print()
    {
        for (int i = 0; i < dataStorages.get(0).dataLength; i++) {
            System.out.println(dataStorages.get(0).data[i]);
        }
    }

    @Override
    public Class getStorageType() {
        return WaveDataObject.class;
    }
}
