package ru.fedul0x.wavepredict.assemblyline.filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FileNameFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.DataFilterTarget;
import ru.fedul0x.wavepredict.common.WaveDataObject;
import ru.fedul0x.wavepredict.common.reflection.ReflectionUtils;

/**
 * Фильтр для открытия wav-файла
 *
 * @author eqlbin, Ivashin Alexey
 */
public class OpenWaveFileFilter extends Filter<FileNameFilterTarget, DataFilterTarget> {

    public OpenWaveFileFilter() {
        super();
    }
    

    public OpenWaveFileFilter(FileNameFilterTarget initData) throws InvalidFilterTargetTypeException, NullFilterException {
        super(initData);
    }

    @Override
    protected boolean filtrate(Object initStorage, Object filtratedStorage) throws UnsupportedAudioFileException, IOException{
        String fileName = (String)initStorage;
        WaveDataObject<Byte> wdo = (WaveDataObject<Byte>)filtratedStorage;
        File file = new File(fileName);
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        wdo.audioFormat = ais.getFormat();
        // количество кадров в файле
        wdo.framesCount = ais.getFrameLength();
        // размер сэмпла в байтах
        wdo.sampleSize = wdo.audioFormat.getSampleSizeInBits() / 8;
        // размер данных в байтах
        wdo.dataLength = wdo.framesCount * wdo.audioFormat.getSampleSizeInBits() * wdo.audioFormat.getChannels() / 8;
        wdo.data = new Byte[(int)wdo.dataLength];
        byte[] data0 = new byte[(int)wdo.dataLength];
        ais.read(data0);
        for (int i=0; i<(int)wdo.dataLength; i++)
        {
            wdo.data[i] = data0[i];
        }
        return true;
    }

    @Override
    protected boolean filtrateAll(FileNameFilterTarget initData, DataFilterTarget filtratedData) throws Exception {
        return true;
    }
    


}
