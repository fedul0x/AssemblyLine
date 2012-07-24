package ru.fedul0x.assemblyline.filter.target;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Исходные данные для открытия файла
 *
 * @author Ivashin Alexey
 */
public class WaveFileNameFilterTarget extends FilterTarget {

    public String fileName;

    public WaveFileNameFilterTarget() {
    }

    public WaveFileNameFilterTarget(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if ((file.isFile()) && (file.exists())) {
            this.fileName = fileName;
        } else {
            throw new FileNotFoundException("Указанный файлы " + fileName + " не найден");
        }
    }
}
