package ru.fedul0x.assemblyline.filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import ru.fedul0x.assemblyline.filter.target.WaveFileNameFilterTarget;
import ru.fedul0x.assemblyline.filter.target.WaveDataFilterTarget;

/**
 * Фильтр для открытия wav-файла
 *
 * @author eqlbin, Ivashin Alexey
 */
public class OpenWaveFileFilter extends Filter<WaveFileNameFilterTarget, WaveDataFilterTarget> {

    @Override
    public boolean filtrate() throws FileNotFoundException, UnsupportedAudioFileException, IOException {
        File file = new File(initData.fileName);
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        WaveDataFilterTarget fd = filtratedData;
        fd.audioFormat = ais.getFormat();
        // количество кадров в файле
        fd.framesCount = ais.getFrameLength();
        // размер сэмпла в байтах
        fd.sampleSize = fd.audioFormat.getSampleSizeInBits() / 8;
        // размер данных в байтах
        fd.dataLength = fd.framesCount * fd.audioFormat.getSampleSizeInBits() * fd.audioFormat.getChannels() / 8;
        fd.data = new byte[(int)fd.dataLength];
        ais.read(filtratedData.data);
        return true;
    }
}
