class A {
  varA : Int;                               --member variable
};

class B inherits A {                        --class B inherits A
  varB : Int;
};

class C inherits A {                        --class C inherits A
  varC : Int;                               --member variable
};

class Main inherits IO {
  main() : Object {
    {
      case 123 of
      a : Int => out_int(a);
      a : Stringyyy => out_string("It's a String.");
      a : Bool => out_string("It's a Bool.");
      esac;
      out_string("\n");

      let sample_class : A <- new C in {
        case sample_class of
        b : A => out_string("It's Class A.\n");
        c : Undefined => out_string("It's Class B.\n");
        d : C => out_string("It's Class C.\n");
        esac;
      };

      let sample_class : A <- new A in {
        case sample_class of
        --a : Object => out_string("a");
        b : A => out_string("It's Class A.\n");
        c : B => out_string("It's Class B.\n");
        d : C => out_string("It's Class C.\n");
        esac;
      };
    }
  };
};
