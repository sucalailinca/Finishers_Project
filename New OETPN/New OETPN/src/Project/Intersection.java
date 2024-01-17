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

public class Intersection {
	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection";

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

		

		// ------Intersection Entry-------Lane2----UPPER LANE -----
		// --------FIRST ROW
		DataCar P_a2 = new DataCar();
		P_a2.SetName("P_a2");
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
		P_1N.Value = new TransferOperation("localhost", "1080", "P5");
		pn.PlaceList.add(P_1N);
		
		
        
        // -----Intersection Entry------Lane4------LOWER LANE 
     // --------FIRST ROW -----
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
		OP3.Value =  new TransferOperation("localhost", "1093", "in3");
		pn.PlaceList.add(OP3);


        
        //-----SECOND ROW - EXIT
		DataCarQueue P_o2 = new DataCarQueue();
		P_o2.Value.Size = 3;
		P_o2.SetName("P_o2");
		pn.PlaceList.add(P_o2);

		DataCar P_o2Exit = new DataCar();
		P_o2Exit.SetName("P_o2Exit");
		pn.PlaceList.add(P_o2Exit);


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

       
      //--------------------------------//
        //---- Transitions -- LANE 2 -----//

        //---- Entry Transitions
        // --- ROW1
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
        grdtu2_2.condition = tu2_ct3;

        grdtu2_2.Activations.add(new Activation(t_u2, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grdtu2_2.Activations.add(new Activation(t_u2, "P_a2", TransitionOperation.Move, "P_a2"));
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


    
        //--------------------------------//
        //---- Transitions -- LANE 4 -----//

        //---- Entry Transitions
      //--- t_u3
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


     // ----- t_e3
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


        
      //---- EXIT Transitions
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
