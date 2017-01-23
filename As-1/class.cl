--Classes in COOL Language
class ClassA inherits IO {
  a : Int <- b*c;                        --initializing class member variables
  b : Int <- 2;
  c : Int <- 3;

  print_function() : SELF_TYPE {         --print_function for classA
    {
      out_string("A : "); out_int(a);
      out_string(" ");
      out_string("B : "); out_int(b);
      out_string(" ");
      out_string("C : "); out_int(c);
      out_string(" ");
    }
  };

  cons() : SELF_TYPE {                   --function returning current instance of the class
    self
  };

  euclid_hcf(a1 : Int, b1 : Int) : Int { --euclid's method to compute HCF of two numbers
    {
      while not a1 = b1 loop {           --iterating like recursion method for euclid method
        if b1 < a1 then {
          a1 <- a1 - b1;                 --if a > b
        }
        else {
          b1 <- b1 - a1;                 --else if b > a
        }
        fi;
      }
      pool;
      a1;
    }
  };
};

class ClassB inherits IO {
  b : Int <- 5;                           --case example demonstration
  c : Int <- (case new ClassA.cons() of id: IO => 2; id : Object => 1; id : ClassA => 3; esac);
  a : Int <- b + c;

  print_function() : SELF_TYPE {          --print function for printing member variables
    {
      out_string("A : "); out_int(a);
      out_string(" ");
      out_string("B : "); out_int(b);
      out_string(" ");
      out_string("C : "); out_int(c);
      out_string(" ");
    }
  };
};

class Main inherits IO {                  --main class implementation
  varA : ClassA;                          --declaring member variables
  varB : ClassB;
  c : Int;
  d : Int;
  main() : Object {
    {
      varA <- (new ClassA);               --calling constructors for both classes A and B
      varB <- (new ClassB);
      varA.print_function();              --calling overloaded print_functions for both classes, despite having same name
      out_string("\n");
      varB.print_function();
      out_string("\n");
      out_string("Enter a for HCF : ");   --input for euclid-hcf method
      c <- in_int();
      out_string("Enter b for HCF : ");
      d <- in_int();                      --take input using in_int() method
      out_string("The HCF of a and b is : ");
      if d < c then {                     --call the method as a CLASS METHOD with appropriate parameters depending on a<b
        out_int((new ClassA).euclid_hcf(c, d));
      }
      else {
        out_int((new ClassA).euclid_hcf(d, c));
      }
      fi;
      out_string("\n");
    }
  };
};
