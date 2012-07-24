package ru.fedul0x.assemblyline.filter.target;

import javax.sound.sampled.AudioFormat;

/**
 * Результат для хранения данных wav-файла
 *
 * @author Ivashin Alexey
 */
public class WaveDataFilterTarget extends FilterTarget {
    //TODO Преобразовать в универсальный объект, хранящий массивы любого типа
    //На джинериках сделать легко создаваемые обертки для результатов работы фильтра
    
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
    public byte[] data;
}
