package Project;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class RoundAbout {
    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Roundabout Petri";
        pn.NetworkPort = 1080;
        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.Printable = false;
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);
        
        DataCarQueue p1 = new DataCarQueue();
        p1.SetName("P1");
        p1.Value.Size = 3;
        pn.PlaceList.add(p1);

        DataCarQueue p2 = new DataCarQueue();
        p2.SetName("P2");
        p2.Value.Size = 3;
        pn.PlaceList.add(p2);

        DataCarQueue p3 = new DataCarQueue();
        p3.SetName("P3");
        p3.Value.Size = 3;
        pn.PlaceList.add(p3);
        
        DataCarQueue p4 = new DataCarQueue();
        p4.SetName("P4");
        p4.Value.Size = 3;
        pn.PlaceList.add(p4);
        
        DataCarQueue p11 = new DataCarQueue();
        p11.SetName("P11");
        p11.Value.Size = 3;
        pn.PlaceList.add(p11);

        DataCar p5 = new DataCar();
        p5.SetName("P5");
        pn.PlaceList.add(p5);

        DataCar p6 = new DataCar();
        p6.SetName("P6");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("P7");
        pn.PlaceList.add(p7);

        DataCar p8 = new DataCar();
        p8.SetName("P8");
        pn.PlaceList.add(p8);

        DataCar p9 = new DataCar();
        p9.SetName("P9");
        pn.PlaceList.add(p9);
        
        DataCar p10 = new DataCar();
        p10.SetName("P10");
        pn.PlaceList.add(p10);

        DataCar p12 = new DataCar();
        p12.SetName("P12");
        pn.PlaceList.add(p12);
        
        
        // T1
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P1");

        Condition T1Ct1 = new Condition(t1, "P1", TransitionCondition.HaveCarForMe);
        Condition T1Ct2 = new Condition(t1, "P2", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P1", TransitionOperation.PopElementWithTargetToQueue, "P2"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P2");

        Condition T2Ct1 = new Condition(t2, "P2", TransitionCondition.HaveCarForMe);
        Condition T2Ct2 = new Condition(t2, "P3", TransitionCondition.CanAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P2", TransitionOperation.PopElementWithTargetToQueue, "P3"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);

        // T3
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("P3");

        Condition T3Ct1 = new Condition(t3, "P3", TransitionCondition.HaveCarForMe);
        Condition T3Ct2 = new Condition(t3, "P11", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P3", TransitionOperation.PopElementWithTargetToQueue, "P11"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 0;
        pn.Transitions.add(t3);
        
        // T4
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P4");

        Condition T4Ct1 = new Condition(t4, "P4", TransitionCondition.HaveCarForMe);
        Condition T4Ct2 = new Condition(t4, "P1", TransitionCondition.CanAddCars);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P1"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);
        
        // T11
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "T11";
        t11.InputPlaceName.add("P11");

        Condition T11Ct1 = new Condition(t11, "P11", TransitionCondition.HaveCarForMe);
        Condition T11Ct2 = new Condition(t11, "P4", TransitionCondition.CanAddCars);
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition= T11Ct1;
        grdT11.Activations.add(new Activation(t11, "P11", TransitionOperation.PopElementWithTargetToQueue, "P4"));
        t11.GuardMappingList.add(grdT11);

        t11.Delay = 0;
        pn.Transitions.add(t11);

        // Exit the roundabout
        // T7
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("P2");

        Condition T7Ct1 = new Condition(t7, "P2", TransitionCondition.HaveCarForMe);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT7.Activations.add(new Activation(t7, "P2", TransitionOperation.PopElementWithTarget, "P7"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 0;
        pn.Transitions.add(t7);
        
        // T8
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("P3");

        Condition T8Ct1 = new Condition(t8, "P3", TransitionCondition.HaveCarForMe);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8Ct1;
        grdT8.Activations.add(new Activation(t8, "P3", TransitionOperation.PopElementWithTarget, "P8"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);

        // T9
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("P4");

        Condition T9Ct1 = new Condition(t9, "P4", TransitionCondition.HaveCarForMe);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition= T9Ct1;
        grdT9.Activations.add(new Activation(t9, "P4", TransitionOperation.PopElementWithTarget, "P9"));
        t9.GuardMappingList.add(grdT9);

        t9.Delay = 0;
        pn.Transitions.add(t9);
        
        // T12
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "T12";
        t12.InputPlaceName.add("P11");

        Condition T12Ct1 = new Condition(t12, "P11", TransitionCondition.HaveCarForMe);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition= T12Ct1;
        grdT12.Activations.add(new Activation(t12, "P11", TransitionOperation.PopElementWithTarget, "P12"));
        t12.GuardMappingList.add(grdT12);

        t12.Delay = 0;
        pn.Transitions.add(t12);
        

        // Enter into the roundabout
        // T5
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P5");

        Condition T5Ct1 = new Condition(t5, "P5", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "P1", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P5", TransitionOperation.AddElement, "P1"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);

        // T6
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P6");

        Condition T6Ct1 = new Condition(t6, "P6", TransitionCondition.NotNull);
        Condition T6Ct2 = new Condition(t6, "P2", TransitionCondition.CanAddCars);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P6", TransitionOperation.AddElement, "P2"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);

        // T10
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "T10";
        t10.InputPlaceName.add("P10");

        Condition T10Ct1 = new Condition(t8, "P10", TransitionCondition.NotNull);
        Condition T10Ct2 = new Condition(t8, "P4", TransitionCondition.CanAddCars);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition= T10Ct1;
        grdT10.Activations.add(new Activation(t10, "P10", TransitionOperation.AddElement, "P4"));
        t10.GuardMappingList.add(grdT10);

        t10.Delay = 0;
        pn.Transitions.add(t10);

        //pn.Delay = 2000;
        //pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

    }
}


