package Project;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersection1 {
	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection 1";

		pn.NetworkPort = 1090;

		// -------- Intersection Entry ---- Lane1 --- LEFT LANE

		// --------FIRST ROW
		DataCar P_a1 = new DataCar();
		P_a1.SetName("P_a1");
		pn.PlaceList.add(P_a1);

		DataCarQueue P_x1 = new DataCarQueue();
		P_x1.Value.Size = 3;
		P_x1.SetName("P_x1");
		pn.PlaceList.add(P_x1);

		DataString P_TL1 = new DataString();
		P_TL1.SetName("P_TL1");
		pn.PlaceList.add(P_TL1);

		DataCar P_b1 = new DataCar();
		P_b1.SetName("P_b1");
		pn.PlaceList.add(P_b1);

		// --- send to Controller 1
		DataTransfer OP1 = new DataTransfer();
		OP1.SetName("OP1");
		OP1.Value = new TransferOperation("localhost", "1093", "in1");
		pn.PlaceList.add(OP1);

		// --------SECOND ROW
		DataCar P_a2 = new DataCar();
		P_a2.SetName("P_a1");
		pn.PlaceList.add(P_a2);

		DataCarQueue P_x2 = new DataCarQueue();
		P_x2.Value.Size = 3;
		P_x2.SetName("P_x2");
		pn.PlaceList.add(P_x2);

		DataString P_TL2 = new DataString();
		P_TL2.SetName("P_TL2");
		pn.PlaceList.add(P_TL2);

		DataCar P_b2 = new DataCar();
		P_b2.SetName("P_b2");
		pn.PlaceList.add(P_b2);

		// --- send to Controller 1
		DataTransfer OP2 = new DataTransfer();
		OP2.SetName("OP2");
		OP2.Value = new TransferOperation("localhost", "1093", "in2");
		pn.PlaceList.add(OP2);

		// --------THIRD ROW
		DataCar P_a3 = new DataCar();
		P_a3.SetName("P_a3");
		pn.PlaceList.add(P_a3);

		DataCarQueue P_x3 = new DataCarQueue();
		P_x3.Value.Size = 3;
		P_x3.SetName("P_x3");
		pn.PlaceList.add(P_x3);

		DataString P_TL3 = new DataString();
		P_TL3.SetName("P_TL3");
		pn.PlaceList.add(P_TL3);

		DataCar P_b3 = new DataCar();
		P_b3.SetName("P_b3");
		pn.PlaceList.add(P_b3);

		// --- send to Controller 1
		DataTransfer OP3 = new DataTransfer();
		OP3.SetName("OP3");
		OP3.Value = new TransferOperation("localhost", "1093", "in3");
		pn.PlaceList.add(OP3);

		// ------Intersection Entry-------Lane2----UPPER LANE -----
		// --------FIRST ROW
		DataCar P_a4 = new DataCar();
		P_a4.SetName("P_a4");
		pn.PlaceList.add(P_a4);

		DataCarQueue P_x4 = new DataCarQueue();
		
		P_x4.Value.Size = 3;
		P_x4.SetName("P_x4");
		pn.PlaceList.add(P_x4);

		DataString P_TL4 = new DataString();
		P_TL4.SetName("P_TL4");
		pn.PlaceList.add(P_TL4);

		DataCar P_b4 = new DataCar();
		P_b4.SetName("P_b4");
		pn.PlaceList.add(P_b4);

		// --- send to Controller 1

		DataTransfer OP4 = new DataTransfer();
		OP4.SetName("OP4");
		OP4.Value = new TransferOperation("localhost", "1093", "in4");
		pn.PlaceList.add(OP4);

		// --------SECOND ROW
		DataCar P_a5 = new DataCar();
		P_a5.SetName("P_a5");
		pn.PlaceList.add(P_a5);

		DataCarQueue P_x5 = new DataCarQueue();
		;
		P_x5.Value.Size = 3;
		P_x5.SetName("P_x5");
		pn.PlaceList.add(P_x5);

		DataString P_TL5 = new DataString();
		P_TL5.SetName("P_TL5");
		pn.PlaceList.add(P_TL5);

		DataCar P_b5 = new DataCar();
		P_b5.SetName("P_b5");
		pn.PlaceList.add(P_b5);

		// --- send to Controller 1

		DataTransfer OP5 = new DataTransfer();
		OP5.SetName("OP5");
		OP5.Value = new TransferOperation("localhost", "1093", "in5");
		pn.PlaceList.add(OP5);

		// ------Intersection Entry-------Lane3----RIGHT LANE -----
		// --------FIRST ROW -----EXIT
		DataCarQueue P_o1 = new DataCarQueue();
		P_o1.Value.Size = 3;
		P_o1.SetName("P_o1");
		pn.PlaceList.add(P_o1);

		DataCar P_o1Exit = new DataCar();
		P_o1Exit.SetName("P_o1Exit");
		pn.PlaceList.add(P_o1Exit);

		//--- sending to Connection Street
		DataTransfer P_1N = new DataTransfer();
		P_1N.SetName("P_1N");
		P_1N.Value = new TransferOperation("localhost", "1091", "P_1N");
		pn.PlaceList.add(P_1N);
		
		// --------SECOND ROW -----EXIT
		DataCarQueue P_o2 = new DataCarQueue();
		P_o2.Value.Size = 3;
		P_o2.SetName("P_o2");
		pn.PlaceList.add(P_o2);

		DataCar P_o2Exit = new DataCar();
		P_o2Exit.SetName("P_o2Exit");
		pn.PlaceList.add(P_o2Exit);

		//--- sending to Connection Street
		DataTransfer P_2N = new DataTransfer();
		P_2N.SetName("P_2N");
		P_2N.Value = new TransferOperation("localhost", "1091", "P_2N");
		pn.PlaceList.add(P_2N);
		
		// --------THIRD ROW -----EXIT
		DataCarQueue P_o3 = new DataCarQueue();
		P_o3.Value.Size = 3;
		P_o3.SetName("P_o3");
		pn.PlaceList.add(P_o3);

		DataCar P_o3Exit = new DataCar();
		P_o3Exit.SetName("P_o3Exit");
		pn.PlaceList.add(P_o3Exit);

		//--- sending to Connection Street
		DataTransfer P_3N = new DataTransfer();
		P_3N.SetName("P_3N");
		P_3N.Value = new TransferOperation("localhost", "1091", "P_3N");
		pn.PlaceList.add(P_3N);

		// --------FOURTH ROW -----EXIT
		DataCarQueue P_o4 = new DataCarQueue();
        P_o4.Value.Size = 3;
        P_o4.SetName("P_o4");
        pn.PlaceList.add(P_o4);

        DataCar P_o4Exit = new DataCar();
        P_o4Exit.SetName("P_o4Exit");
        pn.PlaceList.add(P_o4Exit);

        //--- sending to Connection Street
        DataTransfer P_4N = new DataTransfer();
        P_4N.SetName("P_4N");
        P_4N.Value = new TransferOperation("localhost", "1091", "P_4N");
        pn.PlaceList.add(P_4N);
        
        
        // -----Intersection Entry------Lane4------LOWER LANE 
     // --------FIRST ROW -----
        DataCar P_a6 = new DataCar();
        P_a6.SetName("P_a6");
        pn.PlaceList.add(P_a6);

        DataCarQueue P_x6 = new DataCarQueue();
        P_x6.Value.Size = 3;
        P_x6.SetName("P_x6");
        pn.PlaceList.add(P_x6);

        DataString P_TL6 = new DataString();
        P_TL6.SetName("P_TL6");
        pn.PlaceList.add(P_TL6);

        DataCar P_b6 = new DataCar();
        P_b6.SetName("P_b6");
        pn.PlaceList.add(P_b6);

        // --- send to Controller 1

        DataTransfer OP6 = new DataTransfer();
        OP6.SetName("OP6");
        OP6.Value = new TransferOperation("localhost", "1093", "in6");
        pn.PlaceList.add(OP6);

        
        //-----SECOND ROW - EXIT
        DataCarQueue P_o5 = new DataCarQueue();
        P_o5.Value.Size = 3;
        P_o5.SetName("P_o5");
        pn.PlaceList.add(P_o5);

        DataCar P_o5Exit = new DataCar();
        P_o5Exit.SetName("P_o5Exit");
        pn.PlaceList.add(P_o5Exit);

        // ----------Intersection-

        DataCarQueue P_I = new DataCarQueue();
        P_I.Value.Size = 3;
        P_I.SetName("P_I");
        pn.PlaceList.add(P_I);
        
        //---------------------------//------------------//
        //-----------------------TRANSITIONS-------------//
        //----------------------------//-----------------//

        //--------------------------------//
        //---- Transitions -- LANE 1 -----//

        //---- Entry Transitions
        // --- ROW1
        // --- t_u1
        PetriTransition t_u1 = new PetriTransition(pn);
        t_u1.TransitionName = "t_u1";
        t_u1.InputPlaceName.add("P_a1");
        t_u1.InputPlaceName.add("P_x1");

        Condition tu1_ct1 = new Condition(t_u1, "P_a1", TransitionCondition.NotNull);
        Condition tu1_ct2 = new Condition(t_u1, "P_x1", TransitionCondition.CanAddCars);
        tu1_ct1.SetNextCondition(LogicConnector.AND, tu1_ct2);

        GuardMapping grdtu1 = new GuardMapping();
        grdtu1.condition = tu1_ct1;

        grdtu1.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.AddElement, "P_x1"));

        t_u1.GuardMappingList.add(grdtu1);

        Condition tu1_ct3 = new Condition(t_u1, "P_a1", TransitionCondition.NotNull);
        Condition tu1_ct4 = new Condition(t_u1, "P_x1", TransitionCondition.CanNotAddCars);
        tu1_ct3.SetNextCondition(LogicConnector.AND, tu1_ct4);

        GuardMapping grdtu1_2 = new GuardMapping();
        grdtu1_2.condition= tu1_ct3;

        grdtu1_2.Activations.add(new Activation(t_u1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grdtu1_2.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.Move,"P_a1"));
        t_u1.GuardMappingList.add(grdtu1_2);
        t_u1.Delay = 0;
        pn.Transitions.add(t_u1);
        
        // ---- t_e1

        PetriTransition t_e1 = new PetriTransition(pn);
        t_e1.TransitionName = "t_e1";
        t_e1.InputPlaceName.add("P_x1");
        t_e1.InputPlaceName.add("P_TL1");

        Condition te1_ct1 = new Condition(t_e1, "P_TL1", TransitionCondition.Equal, "green");
        Condition te1_ct2 = new Condition(t_e1, "P_x1", TransitionCondition.HaveCar);
        te1_ct1.SetNextCondition(LogicConnector.AND, te1_ct2);

        GuardMapping grdte1 = new GuardMapping();
        grdte1.condition = te1_ct1;
        grdte1.Activations.add(new Activation(t_e1, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdte1.Activations.add(new Activation(t_e1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        t_e1.GuardMappingList.add(grdte1);

        t_e1.Delay = 3;
        pn.Transitions.add(t_e1);

     // ---- t_i1

        PetriTransition t_i1 = new PetriTransition(pn);
        t_i1.TransitionName = "t_i1";
        t_i1.InputPlaceName.add("P_b1");
        t_i1.InputPlaceName.add("P_I");

        Condition ti1_ct1 = new Condition(t_i1, "P_b1", TransitionCondition.NotNull);
        Condition ti1_ct2 = new Condition(t_i1, "P_I", TransitionCondition.CanAddCars);
        ti1_ct1.SetNextCondition(LogicConnector.AND, ti1_ct2);

        GuardMapping grdti1 = new GuardMapping();
        grdti1.condition = ti1_ct1;
        grdti1.Activations.add(new Activation(t_i1, "P_b1", TransitionOperation.AddElement, "P_I"));
        t_i1.GuardMappingList.add(grdti1);

        t_i1.Delay = 0;
        pn.Transitions.add(t_i1);

        // --- ROW2
        // --- t_u2
        PetriTransition t_u2 = new PetriTransition(pn);
        t_u2.TransitionName = "t_u2";
        t_u2.InputPlaceName.add("P_a2");
        t_u2.InputPlaceName.add("P_x2");
        
        Condition tu2_ct1 = new Condition(t_u2, "P_a2", TransitionCondition.NotNull);
        Condition tu2_ct2 = new Condition(t_u2, "P_x2", TransitionCondition.CanAddCars);
        tu2_ct1.SetNextCondition(LogicConnector.AND, tu2_ct2);

        GuardMapping grdtu2 = new GuardMapping();
        grdtu2.condition = tu2_ct1;
        
        grdtu2.Activations.add(new Activation(t_u2, "P_a2", TransitionOperation.AddElement, "P_x2"));
        
        t_u2.GuardMappingList.add(grdtu2);
        
        Condition tu2_ct3 = new Condition(t_u2, "P_a2", TransitionCondition.NotNull);
        Condition tu2_ct4 = new Condition(t_u2, "P_x2", TransitionCondition.CanNotAddCars);
        tu2_ct3.SetNextCondition(LogicConnector.AND, tu2_ct4);

        GuardMapping grdtu2_2 = new GuardMapping();
        grdtu2_2.condition= tu2_ct3;

        grdtu2_2.Activations.add(new Activation(t_u2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdtu2_2.Activations.add(new Activation(t_u2, "P_a2", TransitionOperation.Move,"P_a2"));
        t_u2.GuardMappingList.add(grdtu2_2);
        t_u2.Delay = 0;
        pn.Transitions.add(t_u2);
        
     // ---- t_e2

        PetriTransition t_e2 = new PetriTransition(pn);
        t_e2.TransitionName = "t_e2";
        t_e2.InputPlaceName.add("P_x2");
        t_e2.InputPlaceName.add("P_TL2");

        Condition te2_ct1 = new Condition(t_e2, "P_TL2", TransitionCondition.Equal, "green");
        Condition te2_ct2 = new Condition(t_e2, "P_x2", TransitionCondition.HaveCar);
        te2_ct1.SetNextCondition(LogicConnector.AND, te2_ct2);

        GuardMapping grdte2 = new GuardMapping();
        grdte2.condition = te2_ct1;
        grdte2.Activations.add(new Activation(t_e2, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
        grdte2.Activations.add(new Activation(t_e2, "P_TL2", TransitionOperation.Move, "P_TL2"));

        t_e2.GuardMappingList.add(grdte2);

        t_e2.Delay = 3;
        pn.Transitions.add(t_e2);

     // ---- t_i2

        PetriTransition t_i2 = new PetriTransition(pn);
        t_i2.TransitionName = "t_i2";
        t_i2.InputPlaceName.add("P_b2");
        t_i2.InputPlaceName.add("P_I");

        Condition ti2_ct1 = new Condition(t_i2, "P_b2", TransitionCondition.NotNull);
        Condition ti2_ct2 = new Condition(t_i2, "P_I", TransitionCondition.CanAddCars);
        ti2_ct1.SetNextCondition(LogicConnector.AND, ti2_ct2);

        GuardMapping grdti2 = new GuardMapping();
        grdti2.condition = ti2_ct1;
        grdti2.Activations.add(new Activation(t_i2, "P_b2", TransitionOperation.AddElement, "P_I"));
        t_i2.GuardMappingList.add(grdti2);

        t_i2.Delay = 0;
        pn.Transitions.add(t_i2);

        
        
        // --- ROW3
        // --- t_u3
     // --- t_u3
        PetriTransition t_u3 = new PetriTransition(pn);
        t_u3.TransitionName = "t_u3";
        t_u3.InputPlaceName.add("P_a3");
        t_u3.InputPlaceName.add("P_x3");

        Condition tu3_ct1 = new Condition(t_u3, "P_a3", TransitionCondition.NotNull);
        Condition tu3_ct2 = new Condition(t_u3, "P_x3", TransitionCondition.CanAddCars);
        tu3_ct1.SetNextCondition(LogicConnector.AND, tu3_ct2);

        GuardMapping grdtu3 = new GuardMapping();
        grdtu3.condition = tu3_ct1;

        grdtu3.Activations.add(new Activation(t_u3, "P_a3", TransitionOperation.AddElement, "P_x3"));

        t_u3.GuardMappingList.add(grdtu3);

        Condition tu3_ct3 = new Condition(t_u3, "P_a3", TransitionCondition.NotNull);
        Condition tu3_ct4 = new Condition(t_u3, "P_x3", TransitionCondition.CanNotAddCars);
        tu3_ct3.SetNextCondition(LogicConnector.AND, tu3_ct4);

        GuardMapping grdtu3_2 = new GuardMapping();
        grdtu3_2.condition= tu3_ct3;

        grdtu3_2.Activations.add(new Activation(t_u3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grdtu3_2.Activations.add(new Activation(t_u3, "P_a3", TransitionOperation.Move,"P_a3"));
        t_u3.GuardMappingList.add(grdtu3_2);
        t_u3.Delay = 0;
        pn.Transitions.add(t_u3);

     // ---- t_e3

        PetriTransition t_e3 = new PetriTransition(pn);
        t_e3.TransitionName = "t_e3";
        t_e3.InputPlaceName.add("P_x3");
        t_e3.InputPlaceName.add("P_TL3");

        Condition te3_ct1 = new Condition(t_e3, "P_TL3", TransitionCondition.Equal, "green");
        Condition te3_ct2 = new Condition(t_e3, "P_x3", TransitionCondition.HaveCar);
        te3_ct1.SetNextCondition(LogicConnector.AND, te3_ct2);

        GuardMapping grdte3 = new GuardMapping();
        grdte3.condition = te3_ct1;
        grdte3.Activations.add(new Activation(t_e3, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
        grdte3.Activations.add(new Activation(t_e3, "P_TL3", TransitionOperation.Move, "P_TL3"));

        t_e3.GuardMappingList.add(grdte3);

        t_e3.Delay = 3;
        pn.Transitions.add(t_e3);

     // ---- t_i3

        PetriTransition t_i3 = new PetriTransition(pn);
        t_i3.TransitionName = "t_i3";
        t_i3.InputPlaceName.add("P_b3");
        t_i3.InputPlaceName.add("P_I");

        Condition ti3_ct1 = new Condition(t_i3, "P_b3", TransitionCondition.NotNull);
        Condition ti3_ct2 = new Condition(t_i3, "P_I", TransitionCondition.CanAddCars);
        ti3_ct1.SetNextCondition(LogicConnector.AND, ti3_ct2);

        GuardMapping grdti3 = new GuardMapping();
        grdti3.condition = ti3_ct1;
        grdti3.Activations.add(new Activation(t_i3, "P_b3", TransitionOperation.AddElement, "P_I"));
        t_i3.GuardMappingList.add(grdti3);

        t_i3.Delay = 0;
        pn.Transitions.add(t_i3);
        
      //--------------------------------//
        //---- Transitions -- LANE 2 -----//

        //---- Entry Transitions
        // --- ROW1
        // --- t_u4
        PetriTransition t_u4 = new PetriTransition(pn);
        t_u4.TransitionName = "t_u4";
        t_u4.InputPlaceName.add("P_a4");
        t_u4.InputPlaceName.add("P_x4");

        Condition tu4_ct1 = new Condition(t_u4, "P_a4", TransitionCondition.NotNull);
        Condition tu4_ct2 = new Condition(t_u4, "P_x4", TransitionCondition.CanAddCars);
        tu4_ct1.SetNextCondition(LogicConnector.AND, tu4_ct2);

        GuardMapping grdtu4 = new GuardMapping();
        grdtu4.condition = tu4_ct1;

        grdtu4.Activations.add(new Activation(t_u4, "P_a4", TransitionOperation.AddElement, "P_x4"));

        t_u4.GuardMappingList.add(grdtu4);

        Condition tu4_ct3 = new Condition(t_u4, "P_a4", TransitionCondition.NotNull);
        Condition tu4_ct4 = new Condition(t_u4, "P_x4", TransitionCondition.CanNotAddCars);
        tu4_ct3.SetNextCondition(LogicConnector.AND, tu4_ct4);

        GuardMapping grdtu4_2 = new GuardMapping();
        grdtu4_2.condition= tu4_ct3;

        grdtu4_2.Activations.add(new Activation(t_u4, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grdtu4_2.Activations.add(new Activation(t_u4, "P_a4", TransitionOperation.Move,"P_a4"));
        t_u4.GuardMappingList.add(grdtu4_2);
        t_u4.Delay = 0;
        pn.Transitions.add(t_u4);
        
        // ---- t_e4

        PetriTransition t_e4 = new PetriTransition(pn);
        t_e4.TransitionName = "t_e4";
        t_e4.InputPlaceName.add("P_x4");
        t_e4.InputPlaceName.add("P_TL4");

        Condition te4_ct1 = new Condition(t_e4, "P_TL4", TransitionCondition.Equal, "green");
        Condition te4_ct2 = new Condition(t_e4, "P_x4", TransitionCondition.HaveCar);
        te4_ct1.SetNextCondition(LogicConnector.AND, te4_ct2);

        GuardMapping grdte4 = new GuardMapping();
        grdte4.condition = te4_ct1;
        grdte4.Activations.add(new Activation(t_e4, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
        grdte4.Activations.add(new Activation(t_e4, "P_TL4", TransitionOperation.Move, "P_TL4"));

        t_e4.GuardMappingList.add(grdte4);

        t_e4.Delay = 3;
        pn.Transitions.add(t_e4);

        // ---- t_i4

        PetriTransition t_i4 = new PetriTransition(pn);
        t_i4.TransitionName = "t_i4";
        t_i4.InputPlaceName.add("P_b4");
        t_i4.InputPlaceName.add("P_I");

        Condition ti4_ct1 = new Condition(t_i4, "P_b4", TransitionCondition.NotNull);
        Condition ti4_ct2 = new Condition(t_i4, "P_I", TransitionCondition.CanAddCars);
        ti4_ct1.SetNextCondition(LogicConnector.AND, ti4_ct2);

        GuardMapping grdti4 = new GuardMapping();
        grdti4.condition = ti4_ct1;
        grdti4.Activations.add(new Activation(t_i4, "P_b4", TransitionOperation.AddElement, "P_I"));
        t_i4.GuardMappingList.add(grdti4);

        t_i4.Delay = 0;
        pn.Transitions.add(t_i4);

        
        
        // --- ROW1
        // --- t_u5
        // --- t_u5
        PetriTransition t_u5 = new PetriTransition(pn);
        t_u5.TransitionName = "t_u5";
        t_u5.InputPlaceName.add("P_a5");
        t_u5.InputPlaceName.add("P_x5");

        Condition tu5_ct1 = new Condition(t_u5, "P_a5", TransitionCondition.NotNull);
        Condition tu5_ct2 = new Condition(t_u5, "P_x5", TransitionCondition.CanAddCars);
        tu5_ct1.SetNextCondition(LogicConnector.AND, tu5_ct2);

        GuardMapping grdtu5 = new GuardMapping();
        grdtu5.condition = tu5_ct1;

        grdtu5.Activations.add(new Activation(t_u5, "P_a5", TransitionOperation.AddElement, "P_x5"));

        t_u5.GuardMappingList.add(grdtu5);

        Condition tu5_ct3 = new Condition(t_u5, "P_a5", TransitionCondition.NotNull);
        Condition tu5_ct4 = new Condition(t_u5, "P_x5", TransitionCondition.CanNotAddCars);
        tu5_ct3.SetNextCondition(LogicConnector.AND, tu5_ct4);

        GuardMapping grdtu5_2 = new GuardMapping();
        grdtu5_2.condition= tu5_ct3;

        grdtu5_2.Activations.add(new Activation(t_u5, "full", TransitionOperation.SendOverNetwork, "OP5"));
        grdtu5_2.Activations.add(new Activation(t_u5, "P_a5", TransitionOperation.Move,"P_a5"));
        t_u5.GuardMappingList.add(grdtu5_2);
        t_u5.Delay = 0;
        pn.Transitions.add(t_u5);
        
        // ---- t_e5

        PetriTransition t_e5 = new PetriTransition(pn);
        t_e5.TransitionName = "t_e5";
        t_e5.InputPlaceName.add("P_x5");
        t_e5.InputPlaceName.add("P_TL5");

        Condition te5_ct1 = new Condition(t_e5, "P_TL5", TransitionCondition.Equal, "green");
        Condition te5_ct2 = new Condition(t_e5, "P_x5", TransitionCondition.HaveCar);
        te5_ct1.SetNextCondition(LogicConnector.AND, te5_ct2);

        GuardMapping grdte5 = new GuardMapping();
        grdte5.condition = te5_ct1;
        grdte5.Activations.add(new Activation(t_e5, "P_x5", TransitionOperation.PopElementWithoutTarget, "P_b5"));
        grdte5.Activations.add(new Activation(t_e5, "P_TL5", TransitionOperation.Move, "P_TL5"));

        t_e5.GuardMappingList.add(grdte5);

        t_e5.Delay = 3;
        pn.Transitions.add(t_e5);

        // ---- t_i5

        PetriTransition t_i5 = new PetriTransition(pn);
        t_i5.TransitionName = "t_i5";
        t_i5.InputPlaceName.add("P_b5");
        t_i5.InputPlaceName.add("P_I");

        Condition ti5_ct1 = new Condition(t_i5, "P_b5", TransitionCondition.NotNull);
        Condition ti5_ct2 = new Condition(t_i5, "P_I", TransitionCondition.CanAddCars);
        ti5_ct1.SetNextCondition(LogicConnector.AND, ti5_ct2);

        GuardMapping grdti5 = new GuardMapping();
        grdti5.condition = ti5_ct1;
        grdti5.Activations.add(new Activation(t_i5, "P_b5", TransitionOperation.AddElement, "P_I"));
        t_i5.GuardMappingList.add(grdti5);

        t_i5.Delay = 0;
        pn.Transitions.add(t_i5);

        //--------------------------------//
        //---- Transitions -- LANE 3 -----//

        // --------Exit Transitions
        // --------ROW1
        // --------t_g1Exit

        PetriTransition t_g1Exit = new PetriTransition(pn);
        t_g1Exit.TransitionName = "t_g1Exit";
        t_g1Exit.InputPlaceName.add("P_o1");

        Condition tg1E_ct1 = new Condition(t_g1Exit, "P_o1", TransitionCondition.HaveCar);

        GuardMapping grdtg1E = new GuardMapping();
        grdtg1E.condition = tg1E_ct1;
        grdtg1E.Activations.add(new Activation(t_g1Exit, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1Exit"));
        t_g1Exit.GuardMappingList.add(grdtg1E);

        t_g1Exit.Delay = 0;
        pn.Transitions.add(t_g1Exit);
        
     // --------- t_g1
        PetriTransition t_g1 = new PetriTransition(pn);
        t_g1.TransitionName = "t_g1";
        t_g1.InputPlaceName.add("P_I");
        t_g1.InputPlaceName.add("P_o1");

        Condition tg1_ct1 = new Condition(t_g1, "P_I", TransitionCondition.HaveCarForMe);
        Condition tg1_ct2 = new Condition(t_g1, "P_o1", TransitionCondition.CanAddCars);
        tg1_ct1.SetNextCondition(LogicConnector.AND, tg1_ct2);

        GuardMapping grdtg1 = new GuardMapping();
        grdtg1.condition = tg1_ct1;
        grdtg1.Activations.add(new Activation(t_g1, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
        t_g1.GuardMappingList.add(grdtg1);

        t_g1.Delay = 0;
        pn.Transitions.add(t_g1);
        
     // --------- t_g1n Connection to Connection Street

        PetriTransition t_g1n = new PetriTransition(pn);
        t_g1n.TransitionName = "t_g1n";
        t_g1n.InputPlaceName.add("P_o1Exit");

        Condition tg1n_ct1 = new Condition(t_g1n, "P_o1Exit", TransitionCondition.NotNull);

        // Send to Connection Street

        GuardMapping grdtg1n = new GuardMapping();
        grdtg1n.condition = tg1n_ct1;
        grdtg1n.Activations.add(new Activation(t_g1n, "P_o1Exit", TransitionOperation.SendOverNetwork, "P_1N"));
        t_g1n.GuardMappingList.add(grdtg1n);

        t_g1n.Delay = 0;
        pn.Transitions.add(t_g1n);


     // --------ROW2
     // --------t_g2Exit

        PetriTransition t_g2Exit = new PetriTransition(pn);
        t_g2Exit.TransitionName = "t_g2Exit";
        t_g2Exit.InputPlaceName.add("P_o2");

        Condition tg2E_ct1 = new Condition(t_g2Exit, "P_o2", TransitionCondition.HaveCar);

        GuardMapping grdtg2E = new GuardMapping();
        grdtg2E.condition = tg2E_ct1;
        grdtg2E.Activations.add(new Activation(t_g2Exit, "P_o2", TransitionOperation.PopElementWithoutTarget, "P_o2Exit"));
        t_g2Exit.GuardMappingList.add(grdtg2E);

        t_g2Exit.Delay = 0;
        pn.Transitions.add(t_g2Exit);

        // --------- t_g2
        PetriTransition t_g2 = new PetriTransition(pn);
        t_g2.TransitionName = "t_g2";
        t_g2.InputPlaceName.add("P_I");
        t_g2.InputPlaceName.add("P_o2");

        Condition tg2_ct1 = new Condition(t_g2, "P_I", TransitionCondition.HaveCarForMe);
        Condition tg2_ct2 = new Condition(t_g2, "P_o2", TransitionCondition.CanAddCars);
        tg2_ct1.SetNextCondition(LogicConnector.AND, tg2_ct2);

        GuardMapping grdtg2 = new GuardMapping();
        grdtg2.condition = tg2_ct1;
        grdtg2.Activations.add(new Activation(t_g2, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
        t_g2.GuardMappingList.add(grdtg2);

        t_g2.Delay = 0;
        pn.Transitions.add(t_g2);
        
     // --------- t_g2n Connection to Connection Street

        PetriTransition t_g2n = new PetriTransition(pn);
        t_g2n.TransitionName = "t_g2n";
        t_g2n.InputPlaceName.add("P_o2Exit");

        Condition tg2n_ct1 = new Condition(t_g2n, "P_o2Exit", TransitionCondition.NotNull);

        // Send to Connection Street

        GuardMapping grdtg2n = new GuardMapping();
        grdtg2n.condition = tg2n_ct1;
        grdtg2n.Activations.add(new Activation(t_g2n, "P_o2Exit", TransitionOperation.SendOverNetwork, "P_2N"));
        t_g2n.GuardMappingList.add(grdtg2n);

        t_g2n.Delay = 0;
        pn.Transitions.add(t_g2n);

        
     // --------ROW3
     // --------t_g3Exit

        PetriTransition t_g3Exit = new PetriTransition(pn);
        t_g3Exit.TransitionName = "t_g3Exit";
        t_g3Exit.InputPlaceName.add("P_o3");

        Condition tg3E_ct1 = new Condition(t_g3Exit, "P_o3", TransitionCondition.HaveCar);

        GuardMapping grdtg3E = new GuardMapping();
        grdtg3E.condition = tg3E_ct1;
        grdtg3E.Activations.add(new Activation(t_g3Exit, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o3Exit"));
        t_g3Exit.GuardMappingList.add(grdtg3E);

        t_g3Exit.Delay = 0;
        pn.Transitions.add(t_g3Exit);

     // --------- t_g3
        PetriTransition t_g3 = new PetriTransition(pn);
        t_g3.TransitionName = "t_g3";
        t_g3.InputPlaceName.add("P_I");
        t_g3.InputPlaceName.add("P_o3");

        Condition tg3_ct1 = new Condition(t_g3, "P_I", TransitionCondition.HaveCarForMe);
        Condition tg3_ct2 = new Condition(t_g3, "P_o3", TransitionCondition.CanAddCars);
        tg3_ct1.SetNextCondition(LogicConnector.AND, tg3_ct2);

        GuardMapping grdtg3 = new GuardMapping();
        grdtg3.condition = tg3_ct1;
        grdtg3.Activations.add(new Activation(t_g3, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
        t_g3.GuardMappingList.add(grdtg3);

        t_g3.Delay = 0;
        pn.Transitions.add(t_g3);

     // --------- t_g3n Connection to Connection Street

        PetriTransition t_g3n = new PetriTransition(pn);
        t_g3n.TransitionName = "t_g3n";
        t_g3n.InputPlaceName.add("P_o3Exit");

        Condition tg3n_ct1 = new Condition(t_g3n, "P_o3Exit", TransitionCondition.NotNull);

        // Send to Connection Street

        GuardMapping grdtg3n = new GuardMapping();
        grdtg3n.condition = tg3n_ct1;
        grdtg3n.Activations.add(new Activation(t_g3n, "P_o3Exit", TransitionOperation.SendOverNetwork, "P_3N"));
        t_g3n.GuardMappingList.add(grdtg3n);

        t_g3n.Delay = 0;
        pn.Transitions.add(t_g3n);

        
     // --------ROW4
     // --------t_g4Exit

        PetriTransition t_g4Exit = new PetriTransition(pn);
        t_g4Exit.TransitionName = "t_g4Exit";
        t_g4Exit.InputPlaceName.add("P_o4");

        Condition tg4E_ct1 = new Condition(t_g4Exit, "P_o4", TransitionCondition.HaveCar);

        GuardMapping grdtg4E = new GuardMapping();
        grdtg4E.condition = tg4E_ct1;
        grdtg4E.Activations.add(new Activation(t_g4Exit, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4Exit"));
        t_g4Exit.GuardMappingList.add(grdtg4E);

        t_g4Exit.Delay = 0;
        pn.Transitions.add(t_g4Exit);

     // --------- t_g4
        PetriTransition t_g4 = new PetriTransition(pn);
        t_g4.TransitionName = "t_g4";
        t_g4.InputPlaceName.add("P_I");
        t_g4.InputPlaceName.add("P_o4");

        Condition tg4_ct1 = new Condition(t_g4, "P_I", TransitionCondition.HaveCarForMe);
        Condition tg4_ct2 = new Condition(t_g4, "P_o4", TransitionCondition.CanAddCars);
        tg4_ct1.SetNextCondition(LogicConnector.AND, tg4_ct2);

        GuardMapping grdtg4 = new GuardMapping();
        grdtg4.condition = tg4_ct1;
        grdtg4.Activations.add(new Activation(t_g4, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
        t_g4.GuardMappingList.add(grdtg4);

        t_g4.Delay = 0;
        pn.Transitions.add(t_g4);

        // --------- t_g4n Connection to Connection Street

        PetriTransition t_g4n = new PetriTransition(pn);
        t_g4n.TransitionName = "t_g4n";
        t_g4n.InputPlaceName.add("P_o4Exit");

        Condition tg4n_ct1 = new Condition(t_g4n,"P_o4Exit", TransitionCondition.NotNull);

        // Send to Connection Street

        GuardMapping grdtg4n = new GuardMapping();
        grdtg4n.condition = tg4n_ct1;
        grdtg4n.Activations.add(new Activation(t_g4n,"P_o4Exit",TransitionOperation.SendOverNetwork,"P_4N"));
        t_g4n.GuardMappingList.add(grdtg4n);

        t_g4n.Delay=0;
        pn.Transitions.add(t_g4n);
        
        //--------------------------------//
        //---- Transitions -- LANE 4 -----//

        //---- Entry Transitions
      //--- t_u6
        PetriTransition t_u6 = new PetriTransition(pn);
        t_u6.TransitionName = "t_u6";
        t_u6.InputPlaceName.add("P_a6");
        t_u6.InputPlaceName.add("P_x6");

        Condition tu6_ct1 = new Condition(t_u6, "P_a6", TransitionCondition.NotNull);
        Condition tu6_ct2 = new Condition(t_u6, "P_x6", TransitionCondition.CanAddCars);
        tu6_ct1.SetNextCondition(LogicConnector.AND, tu6_ct2);

        GuardMapping grdtu6 = new GuardMapping();
        grdtu6.condition = tu6_ct1;

        grdtu6.Activations.add(new Activation(t_u6, "P_a6", TransitionOperation.AddElement, "P_x6"));

        t_u6.GuardMappingList.add(grdtu6);

        Condition tu6_ct3 = new Condition(t_u6, "P_a6", TransitionCondition.NotNull);
        Condition tu6_ct4 = new Condition(t_u6, "P_x6", TransitionCondition.CanNotAddCars);
        tu6_ct3.SetNextCondition(LogicConnector.AND, tu6_ct4);

        GuardMapping grdtu6_2 = new GuardMapping();
        grdtu6_2.condition= tu6_ct3;

        grdtu6_2.Activations.add(new Activation(t_u6, "full", TransitionOperation.SendOverNetwork, "OP6"));
        grdtu6_2.Activations.add(new Activation(t_u6, "P_a6", TransitionOperation.Move,"P_a6"));
        t_u6.GuardMappingList.add(grdtu6_2);
        t_u6.Delay = 0;
        pn.Transitions.add(t_u6);

     // ----- t_e6
        PetriTransition t_e6 = new PetriTransition(pn);
        t_e6.TransitionName = "t_e6";
        t_e6.InputPlaceName.add("P_x6");
        t_e6.InputPlaceName.add("P_TL6");

        Condition te6_ct1 = new Condition(t_e6, "P_TL6", TransitionCondition.Equal, "green");
        Condition te6_ct2 = new Condition(t_e6, "P_x6", TransitionCondition.HaveCar);
        te6_ct1.SetNextCondition(LogicConnector.AND, te6_ct2);

        GuardMapping grdte6 = new GuardMapping();
        grdte6.condition = te6_ct1;
        grdte6.Activations.add(new Activation(t_e6, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_b6"));
        grdte6.Activations.add(new Activation(t_e6, "P_TL6", TransitionOperation.Move, "P_TL6"));

        t_e6.GuardMappingList.add(grdte6);

        t_e6.Delay = 3;
        pn.Transitions.add(t_e6);

     // ---- t_i6
        PetriTransition t_i6 = new PetriTransition(pn);
        t_i6.TransitionName = "t_i6";
        t_i6.InputPlaceName.add("P_b6");
        t_i6.InputPlaceName.add("P_I");

        Condition ti6_ct1 = new Condition(t_i6, "P_b6", TransitionCondition.NotNull);
        Condition ti6_ct2 = new Condition(t_i6, "P_I", TransitionCondition.CanAddCars);
        ti6_ct1.SetNextCondition(LogicConnector.AND, ti6_ct2);

        GuardMapping grdti6 = new GuardMapping();
        grdti6.condition = ti6_ct1;
        grdti6.Activations.add(new Activation(t_i6, "P_b6", TransitionOperation.AddElement, "P_I"));
        t_i6.GuardMappingList.add(grdti6);

        t_i6.Delay = 0;
        pn.Transitions.add(t_i6);

        
      //---- EXIT Transitions
     // --------t_g5Exit

        PetriTransition t_g5Exit = new PetriTransition(pn);
        t_g5Exit.TransitionName = "t_g5Exit";
        t_g5Exit.InputPlaceName.add("P_o5");

        Condition tg5E_ct1 = new Condition(t_g5Exit, "P_o5", TransitionCondition.HaveCar);

        GuardMapping grdtg5E = new GuardMapping();
        grdtg5E.condition = tg5E_ct1;
        grdtg5E.Activations.add(new Activation(t_g5Exit, "P_o5", TransitionOperation.PopElementWithoutTarget, "P_o5Exit"));
        t_g5Exit.GuardMappingList.add(grdtg5E);

        t_g5Exit.Delay = 0;
        pn.Transitions.add(t_g5Exit);

     // --------- t_g5
        PetriTransition t_g5 = new PetriTransition(pn);
        t_g5.TransitionName = "t_g5";
        t_g5.InputPlaceName.add("P_I");
        t_g5.InputPlaceName.add("P_o5");

        Condition tg5_ct1 = new Condition(t_g5, "P_I", TransitionCondition.HaveCarForMe);
        Condition tg5_ct2 = new Condition(t_g5, "P_o5", TransitionCondition.CanAddCars);
        tg5_ct1.SetNextCondition(LogicConnector.AND, tg5_ct2);

        GuardMapping grdtg5 = new GuardMapping();
        grdtg5.condition = tg5_ct1;
        grdtg5.Activations.add(new Activation(t_g5, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o5"));
        t_g5.GuardMappingList.add(grdtg5);

        t_g5.Delay = 0;
        pn.Transitions.add(t_g5);

        
        // -------------------------------------------------------------------------------------
        // ----------------------------PNStart-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Intersection 1 Started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        
	}
}
