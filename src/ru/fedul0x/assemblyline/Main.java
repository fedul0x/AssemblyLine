package ru.fedul0x.assemblyline;

import java.io.FileNotFoundException;
import ru.fedul0x.assemblyline.conveyor.Conveyor;
import ru.fedul0x.assemblyline.filter.OpenWaveFileFilter;
import ru.fedul0x.assemblyline.filter.WaveDataToIntFormFilter;
import ru.fedul0x.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.assemblyline.filter.target.WaveFileNameFilterTarget;

/**
 *
 * @author Ivashin Alexey
 */
public class Main {

    Conveyor conveyor = new Conveyor();

    public Main() throws FileNotFoundException, InvalidFilterTargetTypeException, NullFilterException {
        WaveFileNameFilterTarget ft = new WaveFileNameFilterTarget("/home/fedul0x/NetBeansProjects/1-welcome.wav");
        OpenWaveFileFilter openFilter = new OpenWaveFileFilter(ft);
        WaveDataToIntFormFilter toIntFilter = new WaveDataToIntFormFilter();
        conveyor.addFilter(openFilter);
        conveyor.addFilter(toIntFilter);
    }
}
