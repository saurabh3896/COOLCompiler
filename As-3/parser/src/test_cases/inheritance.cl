class A {
  varA : Int;                               --member variable

  cons() : SELF_TYPE {
    self                                    --return instance of current class
  };

  getvar() : Int {
    varA                                    --get member variable
  };

  setvar() : Object {
    varA <- 5                               --set member variable
  };
};

class B inherits A {                        --class B inherits A
  varB : Int;

  cons() : SELF_TYPE {                      --B's own cons returning its instance
    self
  };
};

class C inherits A {                        --class C inherits A
  varC : Int;                               --member variable

  cons() : SELF_TYPE {                      --C's own cons returning its instance
    self
  };

  consc() : SELF_TYPE {                     --C's own consc calling cons in further returning its instance
    cons()
  };

  setvar() : Object {                       --set member variable
    varA <- 5
  };
};

class Main inherits IO {
  main() : Object {
    {
      --Type Determination in CASE
      case 123 of
      a : Int => out_int(a);
      a : String => out_string("It's a String.");
      a : Bool => out_string("It's a Bool.");
      esac;
      out_string("\n");

      --Class Type Determination in CASE
      let sample_class : A <- new C in {
        case sample_class of
        b : A => out_string("It's Class A.\n");
        c : B => out_string("It's Class B.\n");
        d : C => out_string("It's Class C.\n");
        esac;
      };

      --Better Alternative for Class A is to in case 'b', where the type of 'b' is A,
      --but if we comment option 'b' and uncomment case 'a', then control will transfer
      --to case 'a', which is the default one.
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
