package ru.fedul0x.wavepredict.assemblyline;

import java.io.FileNotFoundException;
import ru.fedul0x.wavepredict.assemblyline.conveyor.Conveyor;
import ru.fedul0x.wavepredict.assemblyline.filter.OpenWaveFileFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.DataToIntFormFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FileNameFilterTarget;

/**
 *
 * @author Ivashin Alexey
 */
public class Main {
    
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidFilterTargetTypeException, NullFilterException {
        Conveyor conveyor1 = new Conveyor();
        FileNameFilterTarget ft = new FileNameFilterTarget("/home/fedul0x/NetBeansProjects/Зайцева ИВ 8 кашель.wav");
        OpenWaveFileFilter openFilter = new OpenWaveFileFilter(ft);
        DataToIntFormFilter waveToIntFilter = new DataToIntFormFilter();
        conveyor1.addFilter(openFilter).addFilter(waveToIntFilter);
        conveyor1.start();
        Conveyor conveyor2 = new Conveyor();
        FileNameFilterTarget ft2 = new FileNameFilterTarget("/home/fedul0x/NetBeansProjects/newmix.wav");
        OpenWaveFileFilter openFilter2 = new OpenWaveFileFilter(ft);
        DataToIntFormFilter waveToIntFilter2 = new DataToIntFormFilter();
        conveyor2.addFilter(openFilter2).addFilter(waveToIntFilter2);
        conveyor2.start();
    }
}
