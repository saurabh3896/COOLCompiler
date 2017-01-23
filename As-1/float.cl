class A2I {

     c2i(char : String) : Int {
	if char = "0" then 0 else
	if char = "1" then 1 else
	if char = "2" then 2 else
        if char = "3" then 3 else
        if char = "4" then 4 else
        if char = "5" then 5 else
        if char = "6" then 6 else
        if char = "7" then 7 else
        if char = "8" then 8 else
        if char = "9" then 9 else
        { abort(); 0; }  -- the 0 is needed to satisfy the typchecker
        fi fi fi fi fi fi fi fi fi fi
     };

     i2c(i : Int) : String {
	if i = 0 then "0" else
	if i = 1 then "1" else
	if i = 2 then "2" else
	if i = 3 then "3" else
	if i = 4 then "4" else
	if i = 5 then "5" else
	if i = 6 then "6" else
	if i = 7 then "7" else
	if i = 8 then "8" else
	if i = 9 then "9" else
	{ abort(); ""; }  -- the "" is needed to satisfy the typchecker
        fi fi fi fi fi fi fi fi fi fi
     };

   a2i(s : String) : Int {
        if s.length() = 0 then 0 else
	if s.substr(0,1) = "-" then ~a2i_aux(s.substr(1,s.length()-1)) else
        if s.substr(0,1) = "+" then a2i_aux(s.substr(1,s.length()-1)) else
           a2i_aux(s)
        fi fi fi
     };

     a2i_aux(s : String) : Int {
	(let int : Int <- 0 in
           {
               (let j : Int <- s.length() in
	          (let i : Int <- 0 in
		    while i < j loop
			{
			    int <- int * 10 + c2i(s.substr(i,1));
			    i <- i + 1;
			}
		    pool
		  )
	       );
              int;
	    }
        )
     };

    i2a(i : Int) : String {
	if i = 0 then "0" else
        if 0 < i then i2a_aux(i) else
          "-".concat(i2a_aux(i * ~1))
        fi fi
    };

    i2a_aux(i : Int) : String {
        if i = 0 then "" else
	    (let next : Int <- i / 10 in
		i2a_aux(next).concat(i2c(i - next * 10))
	    )
        fi
    };

};

class Myrational inherits IO {
  num : Int;
  den : Int;

  getNum() : Int {
    num
  };

  setNum(input : Int) : Object {
    num <- input
  };

  getDen() : Int {
    den
  };

  setDen(input : Int) : Object {
    den <- input
  };

  addition(obj1 : Myrational, obj2 : Myrational) : Myrational {
    let out_num : Int, out_den : Int in {
        out_num <- obj1.getNum()*obj2.getDen() + obj2.getNum()*obj1.getDen();
        out_den <- obj1.getDen()*obj2.getDen();
        num <- out_num;
        den <- out_den;
        self;
    }
  };

  subtraction(obj1 : Myrational, obj2 : Myrational) : Myrational {
    let out_num : Int, out_den : Int in {
        out_num <- obj1.getNum()*obj2.getDen() - obj2.getNum()*obj1.getDen();
        out_den <- obj1.getDen()*obj2.getDen();
        num <- out_num;
        den <- out_den;
        self;
    }
  };

  multiplication(obj1 : Myrational, obj2 : Myrational) : Myrational {
    let out_num : Int, out_den : Int in {
        out_num <- obj1.getNum()*obj2.getNum();
        out_den <- obj1.getDen()*obj2.getDen();
        num <- out_num;
        den <- out_den;
        self;
    }
  };

  division(obj1 : Myrational, obj2 : Myrational) : Myrational {
    let out_num : Int, out_den : Int in {
        out_num <- obj1.getNum()*obj2.getDen();
        out_den <- obj1.getDen()*obj2.getNum();
        num <- out_num;
        den <- out_den;
        self;
    }
  };

};

class Main inherits IO {
  o1 : Myrational;
  o2 : Myrational;
  answer_o : Myrational;

  tail_recursion_power(x : Int, y : Int, acc : Int) : Int {
    if y = 0 then
      acc
    else
        tail_recursion_power(x, y - 1, x*acc)
    fi
  };

  parse(input : String) : Int {
    (let int : Int <- 0, index : Int in {
      (let j : Int <- input.length() in
  	    (let i : Int <- 0, end : Int in
  		    while i < j loop
  			    (let c : String <- input.substr(i,1) in
  			      if (c = ".") then {
  				      index <- i;
                i <- i + 1;
  			      }
  			      else {
                end <- i;
                i <- i + 1;
  			      }
  			      fi
  			    )
  		    pool
  		  )
  	  );
      index;
  	})
  };

  print(object : Myrational) : Object {
    {
      let diff : Int, a : Int <- object.getNum(), b : Int <- object.getDen(), output_string : String, decimal_string : String in {
        if b < a then {
          diff <- ((new A2I).i2a(a)).length() - ((new A2I).i2a(b)).length() + 1;
          output_string <- ((new A2I).i2a(a)).substr(0, diff);
          output_string <- output_string.concat(".");
          output_string <- output_string.concat(((new A2I).i2a(a)).substr(diff, ((new A2I).i2a(a)).length() - diff - 1));
          out_string(output_string);
        }
        else {
          --Not Done
          output_string <- "";
        }
        fi;
      };
    }
  };

  modulo(a : Int, b : Int) : Int {
    a - (a / b * b)
  };

  main() : Object {
    {
      o1 <- new Myrational;
      o2 <- new Myrational;
      answer_o <- new Myrational;
      let input1 : String, input2 : String in {
        input1 <- in_string();
        input2 <- in_string();
        let index : Int <- parse(input1) in {
          o1.setNum((new A2I).a2i((input1.substr(0, index)).concat(input1.substr(index + 1, input1.length() - index - 1))));
          o1.setDen(tail_recursion_power(10, input1.substr(index + 1, input1.length() - index - 1).length(), 1));
          o2.setNum((new A2I).a2i((input2.substr(0, index)).concat(input2.substr(index + 1, input2.length() - index - 1))));
          o2.setDen(tail_recursion_power(10, input2.substr(index + 1, input2.length() - index - 1).length(), 1));
          answer_o <- answer_o.addition(o1, o2);
          print(answer_o);
        };
      };
    }
  };
};
