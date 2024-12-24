package rennspiel;

public class Zustandsautomat 
{
  public Auto auto;
  public enum Zustand {NEUT, ACC, DEC};
  public Zustand zustand;
  
  public Zustandsautomat(Auto auto)
  { this.auto=auto;
    zustand=Zustand.NEUT;
  }
  
  public void statemachine(char eingabe)
  { switch(zustand)
	{ case NEUT:
	    auto.roll();
        if(eingabe=='t') break;
        else if(eingabe=='a'){zustand=Zustand.ACC;}
        else if(eingabe=='r'){zustand=Zustand.DEC;}
        else if(eingabe=='u'){auto.up();}
        else if(eingabe=='d'){auto.down();}
		break;
	  case ACC:
		auto.accel();
        if(eingabe=='t') break;
        else if(eingabe=='u'){auto.up();}
        else if(eingabe=='d'){auto.down();}
        else if(eingabe=='n'){zustand=Zustand.NEUT;}
        break;
	  case DEC:
		auto.decel();
	    if(eingabe=='t') break;
	    else if(eingabe=='u'){auto.up();}
	    else if(eingabe=='d'){auto.down();}
	    else if(eingabe=='n'){zustand=Zustand.NEUT;}
		break;
	}	
  }
}
