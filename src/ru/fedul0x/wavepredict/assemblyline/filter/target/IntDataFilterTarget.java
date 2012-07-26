package ru.fedul0x.wavepredict.assemblyline.filter.target;

import javax.sound.sampled.AudioFormat;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 * Результат для хранения данных wav-файла в целочисленом виде для фильтра {@code WaveDataToIntFormFilter}
 *
 * @author Ivashin Alexey
 */
public class IntDataFilterTarget extends FilterTarget<WaveDataObject<Integer>> {

    public IntDataFilterTarget() {
    }

   public AudioFormat getAudioFormat() {
        return getCurrentStorage().audioFormat;
    }

    public void setAudioFormat(AudioFormat audioFormat) {
        getCurrentStorage().audioFormat = audioFormat;
    }

    public Integer[] getData() {
        return getCurrentStorage().data;
    }

    public void setData(Integer[] data) {
        getCurrentStorage().data = data;
    }

    public long getDataLength() {
        return getCurrentStorage().dataLength;
    }

    public void setDataLength(long dataLength) {
        getCurrentStorage().dataLength = dataLength;
    }

    public long getFramesCount() {
        return getCurrentStorage().framesCount;
    }

    public void setFramesCount(long framesCount) {
        getCurrentStorage().framesCount = framesCount;
    }

    public int getSampleSize() {
        return getCurrentStorage().sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        getCurrentStorage().sampleSize = sampleSize;
    }
}
