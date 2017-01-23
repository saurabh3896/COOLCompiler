CLASS Main inherits IO {
  n : Int;                            --class member
  main() : Object {
    {
      out_string("Enter a non-negative integer : ");
      n <- in_int();                  --input stored in n
      let num : Int <- n in           --let to create local scope for num
        IF num < 0 then               --error checking
          out_string("Invalid input, please enter a non-negative integer.\n")
        else {
          out_string("The factorial of ");
          out_int(num);
          out_string(" is ");
          out_int(factorial(num));    --calling the factorial function
          out_string(".\n");
        }
        FI;
    }
  };

  factorial(num: Int, ,0) : Int {     --parser should catch error here
    if num = 0 then
      1                               --return 1 if n = 0
    else
      num*factorial(num - 1)          --else curr*fact(curr - 1)
    fi
  };

  factorial_iterative(i : Int) : Int {--iterative version of factorial
    let factorial : Int <- 1 in {     --initializing start to 1
      while (not (i = 0)) loop        --while loop to multiply till n
        {
          factorial <- factorial * i;
          i <- i - 1;                 --decreasing count and performing multiplication
        }
      pool;
      factorial;                      --returning factorial
    }
  };
};
