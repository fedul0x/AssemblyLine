package ru.fedul0x.wavepredict.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Wave-file processing class
 *
 * @author eqlbin, Ivashin Alexey
 */
public class WaveDataObject<Capsule> {
    /*
     * Формат аудио
     */

    public AudioFormat audioFormat;
    /*
     * Количество кадров в файле
     */
    public long framesCount;
    /*
     * Размер сэмпла в байтах
     */
    public int sampleSize;
    /*
     * Размер данных в байтах
     */
    public long dataLength;
    public Capsule[] data;
}
