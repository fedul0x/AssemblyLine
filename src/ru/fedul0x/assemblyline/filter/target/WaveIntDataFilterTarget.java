package ru.fedul0x.assemblyline.filter.target;

import javax.sound.sampled.AudioFormat;
import ru.fedul0x.assemblyline.filter.target.FilterTarget;

/**
 * Результат для хранения данных wav-файла в целочисленом виде для фильтра {@code WaveDataToIntFormFilter}
 *
 * @author Ivashin Alexey
 */
public class WaveIntDataFilterTarget extends FilterTarget {

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
    public int[] data;
}
