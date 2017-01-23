class Aaa {
  x : Int;
  methoda() : SELF_TYPE {
    self
  } ;
  get() : Int {
    x
  };
  change() : Object {
    x <- 4
  };
} ;

class Bbb inherits Aaa {
  methoda() : SELF_TYPE {
    self
  } ;
} ;

class Ccc inherits Bbb {
  i : Ccc;
  methoda() : SELF_TYPE {
    self
  } ;
  methodc() : SELF_TYPE {
    methoda()
  } ;
  change() : Object {
    x <- 5
  };
} ;


class Main inherits IO {
  main() : Object {
    {
      case 999 of
      x1 : Int => out_int(x1);
      x1 : Bool => x1;
      esac;

      let x : Aaa <- new Ccc in {
        case x of
        a : Aaa => out_string("a");
        b : Bbb => out_string("e");
        c : Ccc => out_string("i");
        esac;
        out_string("\n");
      };

      let x : Aaa <- new Aaa in {
        case x of
        a : Object => out_string("a");
        b : Bbb => out_string("e");
        c : Ccc => out_string("i");
        esac;
        out_string("\n");
      };

        case self of
        a : Int => (new IO).out_string("a");
        b : IO => (new IO).out_string("e");
        c : Ccc => (new IO).out_string("i");
        esac;
        (new IO).out_string("\n");

      let x : Aaa <- new Ccc in {
        (new IO).out_string(x.type_name());
        case x of
        a : Int => (new IO).out_string("a");
        b : Object => (new IO).out_string("e");
        c : Ccc => c.change();
        esac;
        (new IO).out_int(x.get());
        (new IO).out_string("\n");
      };

      if case new Int of a : Object => 1; b : Int => 3; esac =
         case new Int of a : Object => 1; b : Int => 4-1; esac
         then {out_int(9);} else {out_int(8);} fi;
  }
  } ;
} ;
