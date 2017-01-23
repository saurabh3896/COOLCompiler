class Main {
	main():IO {
		new IO.out_string("Hello world!\n")
	};
};

class A inherits IO {
  x : Int;
  func(x : Int, y : Bool, z : String, a : Int):IO {
    new IOF.out_int(x)
  };
};

class AB {
    x : Int;
    change() : Object {
        --x <- "a";
        x <- 1 * "a"
    };
};

class B inherits A {
  x1 : Int;
  x1 : Int;
  func_(x : Int, y : Int, z : String, b : String):IO {
    new IO.out_string(z)
  };
  func_(x : Int, y : Int, z : String, b : String):IO {
    new IO.out_string(z)
  };
};

class C inherits B {
  x : Int;
  x : String;
	func(x : Int, y : Bool, z : String, a : String):Object{
    new IO.out_string(z)
	};
};
