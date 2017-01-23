class A inherits IO {
  attr1 : Int <- attr2 + attr3;
  attr2 : Int <- 1;
  attr3 : Int <- 2;
  attr4 : Int <- attr2 * 2 + attr3;
  foo() : SELF_TYPE {
    {
      out_int(attr1);
      out_string("\n");
      out_int(attr2);
      out_string("\n");
      out_int(attr3);
      out_string("\n");
      out_int(attr4);
      out_string("\n");
    }
  };
  boo() : SELF_TYPE { self };
};

class B inherits IO {
  a1 : Int <- 1;
  a2 : Int <- 2;
  a3 : Int <- let a1 : Int <- 2, a2 : Int <- (a1 - 1) in (a1 * 2 + a2);
  a4 : Int <- let ii : Int <- 5, result : Int <- 0 in {
         while 0 < ii loop {
           result <- (result + (case new A.boo() of id: IO => 2; id : Object => 1; id : A => 3; esac));
           ii <- (ii - 1);
         } pool; result;};
  foo() : SELF_TYPE {
    {
      out_int(a3);
      out_string("\n");
      out_int(a4);
      out_string("\n");
    }
  };
};

class Main {
  main() : Object { {new A.foo(); new B.foo();} };
};
