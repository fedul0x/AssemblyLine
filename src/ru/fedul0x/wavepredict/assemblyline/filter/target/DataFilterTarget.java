package ru.fedul0x.wavepredict.assemblyline.filter.target;

import javax.sound.sampled.AudioFormat;
import ru.fedul0x.wavepredict.common.WaveDataObject;

/**
 * Результат для хранения данных wav-файла
 *
 * @author Ivashin Alexey
 */
public class DataFilterTarget extends FilterTarget<WaveDataObject<Byte>> {

    public DataFilterTarget() {
    }
//НИже муть
    public AudioFormat getAudioFormat() {
        return getCurrentStorage().audioFormat;
    }

    public void setAudioFormat(AudioFormat audioFormat) {
        getCurrentStorage().audioFormat = audioFormat;
    }

    public Byte[] getData() {
        return getCurrentStorage().data;
    }

    public void setData(Byte[] data) {
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
