package ru.fedul0x.wavepredict.assemblyline;

import java.io.FileNotFoundException;
import java.lang.annotation.Target;
import ru.fedul0x.wavepredict.assemblyline.conveyor.Conveyor;
import ru.fedul0x.wavepredict.assemblyline.filter.OpenWaveFileFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.DataToIntFormFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.LinearCorrelationCoefficientFilter;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.InvalidFilterTargetTypeException;
import ru.fedul0x.wavepredict.assemblyline.filter.exception.NullFilterException;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FileNameFilterTarget;
import ru.fedul0x.wavepredict.assemblyline.filter.target.FloatDataFilterTarget;

/**
 *
 * @author Ivashin Alexey
 */
public class Main {
    
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException, InvalidFilterTargetTypeException, NullFilterException {
        Conveyor conveyor = new Conveyor();
        FileNameFilterTarget ft = (FileNameFilterTarget) new FileNameFilterTarget().
                addArgument("/home/fedul0x/NetBeansProjects/Зайцева ИВ 8 кашель.wav").
                addArgument("/home/fedul0x/NetBeansProjects/newmix.wav");
        OpenWaveFileFilter openFilter = new OpenWaveFileFilter(ft);
        DataToIntFormFilter waveToIntFilter = new DataToIntFormFilter();
        LinearCorrelationCoefficientFilter correlationCoefficientFilter = new LinearCorrelationCoefficientFilter();
        conveyor.addFilter(openFilter).addFilter(waveToIntFilter).addFilter(correlationCoefficientFilter);
        FloatDataFilterTarget taget = (FloatDataFilterTarget) conveyor.start();
        taget.print();
        
    }
}
